package com.example.clienteapi.config;

import com.example.clienteapi.repository.ClienteRepository;
import com.example.clienteapi.service.ClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteConfig {

    @Bean
    public ClienteService clienteService(ClienteRepository clienteRepository) {
        return new ClienteService(clienteRepository);
    }
}
