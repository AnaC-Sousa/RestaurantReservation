package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.domain.Client;
import com.restaurante.restaurante.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/clients")
@RestController
public class ClientController {

    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getClients();
    }

    @GetMapping(path = "{id}")
    public Optional<Client> getClientbyId(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public void addClient(@RequestBody Client client){
        clientService.newClient(client);
    }

    @PutMapping(path = "{id}")
    public Client replaceClient(@RequestBody Client newClient, @PathVariable int id){
        return clientService.replaceClient(newClient, id);
    }


    @DeleteMapping(path = "{id}")
    public void deleteClient(@PathVariable int id ){
        clientService.deleteClient(id);
    }



}
