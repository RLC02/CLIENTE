package com.example.clienteapi.model;

import lombok.Data;

@Data
public class Endereco {
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
}
