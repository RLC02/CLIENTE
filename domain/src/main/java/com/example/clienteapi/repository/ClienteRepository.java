package com.example.clienteapi.repository;

import com.example.clienteapi.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    List<Cliente> findAll();
    Optional<Cliente> findById(String id);
    Cliente save(Cliente cliente);
    void deleteById(String id);
}
