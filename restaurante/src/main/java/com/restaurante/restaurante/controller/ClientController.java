package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.domain.Client;
import com.restaurante.restaurante.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ClientController {
    private final ClientRepository clientRepository;


    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RequestMapping("/clients")
    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    @GetMapping("clients/{id}")
    public Optional<Client> getClientById(@PathVariable int id){
        return clientRepository.findById(id);
    }

    @PostMapping("clients")
    public void newClient(@RequestBody Client newClient){
        clientRepository.save(newClient);
    }

    @PutMapping("clients/{id}")
    public Client replaceClient(@RequestBody Client newClient, @PathVariable int id){
        return clientRepository.findById(id)
                .map(client -> {
                    client.setName(newClient.getFirstName(), newClient.getLastName());
                    client.setAddress(newClient.getClientAddress());
                    client.setPhoneNumber(newClient.getPhoneNumber());
                    return clientRepository.save(client);

                })
                .orElseGet(() ->{ newClient.setId(id);
                return clientRepository.save(newClient);
                });
    }
    @DeleteMapping("clients/{id}")
    public void deleteClient(@PathVariable int id){
        clientRepository.deleteById(id);
    }
}
