package com.restaurante.restaurante.service;

import com.restaurante.restaurante.address.Address;
import com.restaurante.restaurante.domain.Client;
import com.restaurante.restaurante.model.ClientDTO;
import com.restaurante.restaurante.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    private final ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
        this.modelMapper = new ModelMapper();
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }


    public Client getClientById(int id){
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found" + id));
    }


    public void newClient(ClientDTO newClient){
        clientRepository.save(modelMapper.map(newClient, Client.class));
    }


    public ClientDTO replaceClient(ClientDTO newClient, int id){
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

    public void deleteClient(int id){
        clientRepository.deleteById(id);
    }






}
