package com.restaurante.restaurante.service;

import com.restaurante.restaurante.domain.address.Address;
import com.restaurante.restaurante.domain.Client;
import com.restaurante.restaurante.model.ClientDTO;
import com.restaurante.restaurante.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    private final ModelMapper modelMapper;

    public ClientService(){
        this.modelMapper = new ModelMapper();
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }


    public Client getClientById(Long id){
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found" + id));
    }


    public void newClient(ClientDTO newClient){
        clientRepository.save(modelMapper.map(newClient, Client.class));
    }


    public ClientDTO replaceClient(ClientDTO newClient, Long id){
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(newClient.getFirstName(), newClient.getLastName());
                    client.setAddress(modelMapper.map(newClient.getAddress(), Address.class));
                    client.setPhoneNumber(newClient.getPhoneNumber());
                    return modelMapper.map(clientRepository.save(client), ClientDTO.class);

                })
                .orElseGet(() ->{ newClient.setId(id);
                    return modelMapper.map(clientRepository.save(modelMapper.map(newClient, Client.class)), ClientDTO.class);
                });
    }

    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }






}
