package com.restaurante.restaurante.controller;

import com.restaurante.restaurante.model.ClientDTO;
import com.restaurante.restaurante.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/clients")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    private final ModelMapper modelMapper;

    public ClientController(){
        this.modelMapper = new ModelMapper();
    }

    @GetMapping
    public List<ClientDTO> getAllClients(){
        return clientService.getClients().stream().map(client -> modelMapper.map(client, ClientDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "{id}")
    public ClientDTO getClientById(@PathVariable Long id){
        return modelMapper.map(clientService.getClientById(id), ClientDTO.class);
    }

    @PostMapping
    public void addClient(@RequestBody ClientDTO client){
        clientService.newClient(client);
    }

    @PutMapping(path = "{id}")
    public ClientDTO replaceClient(@RequestBody ClientDTO newClient, @PathVariable Long id){
        return clientService.replaceClient(newClient, id);
    }


    @DeleteMapping(path = "{id}")
    public void deleteClient(@PathVariable Long id ){
        clientService.deleteClient(id);
    }



}
