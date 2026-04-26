package com.example.clienteapi.service;

import com.example.clienteapi.model.Cliente;
import com.example.clienteapi.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Optional<Cliente> findById(String id) {
        return repository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return repository.save(cliente);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Optional<Cliente> update(String id, Cliente clienteData) {
        return repository.findById(id).map(existing -> {
            existing.setNome(clienteData.getNome());
            existing.setDtNascimento(clienteData.getDtNascimento());
            existing.setEndereco(clienteData.getEndereco());
            return repository.save(existing);
        });
    }
}
