package com.example.clienteapi.adapter;

import com.example.clienteapi.entity.ClienteEntity;
import com.example.clienteapi.model.Cliente;
import com.example.clienteapi.repository.ClienteMongoRepository;
import com.example.clienteapi.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClienteRepositoryAdapter implements ClienteRepository {

    private final ClienteMongoRepository mongoRepository;

    @Override
    public List<Cliente> findAll() {
        return mongoRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return mongoRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entity = toEntity(cliente);
        return toDomain(mongoRepository.save(entity));
    }

    @Override
    public void deleteById(String id) {
        mongoRepository.deleteById(id);
    }

    private Cliente toDomain(ClienteEntity entity) {
        Cliente cliente = new Cliente();
        cliente.setId(entity.getId());
        cliente.setNome(entity.getNome());
        cliente.setDtNascimento(entity.getDtNascimento());
        cliente.setEndereco(entity.getEndereco());
        return cliente;
    }

    private ClienteEntity toEntity(Cliente cliente) {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(cliente.getId());
        entity.setNome(cliente.getNome());
        entity.setDtNascimento(cliente.getDtNascimento());
        entity.setEndereco(cliente.getEndereco());
        return entity;
    }
}
