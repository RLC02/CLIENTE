package com.example.clienteapi.entity;

import com.example.clienteapi.model.Endereco;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "clientes")
public class ClienteEntity {
    @Id
    private String id;
    private String nome;
    private LocalDate dtNascimento;
    private Endereco endereco;
}
