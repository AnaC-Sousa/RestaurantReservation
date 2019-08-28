package com.restaurante.restaurante.model;

import org.springframework.context.annotation.Bean;

public class ModelMapper {
    @Bean
    public ModelMapper modelMapper(){
        return new org.modelmapper.ModelMapper();
    }}
