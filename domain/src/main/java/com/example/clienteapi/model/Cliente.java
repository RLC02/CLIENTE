package com.example.clienteapi.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Cliente {
    private String id;
    private String nome;
    private LocalDate dtNascimento;
    private Endereco endereco;
}
