package com.restaurante.restaurante.service;

import com.restaurante.restaurante.domain.Client;
import com.restaurante.restaurante.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients(){
        return clientRepository.findAll();
    }


    public Optional<Client> getClientById(int id){
        return clientRepository.findById(id);
    }


    public void newClient(Client newClient){
        clientRepository.save(newClient);
    }


    public Client replaceClient(Client newClient, int id){
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(newClient.getFirstName(), newClient.getLastName());
                    client.setAddress(newClient.getAddress());
                    client.setPhoneNumber(newClient.getPhoneNumber());
                    return clientRepository.save(client);

                })
                .orElseGet(() ->{ newClient.setId(id);
                    return clientRepository.save(newClient);
                });
    }

    public void deleteClient(int id){
        clientRepository.deleteById(id);
    }






}
