package com.example.clienteapi.controller;

import com.example.clienteapi.model.Cliente;
import com.example.clienteapi.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @GetMapping
    public List<Cliente> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable String id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable String id, @RequestBody Cliente cliente) {
        return service.update(id, cliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
