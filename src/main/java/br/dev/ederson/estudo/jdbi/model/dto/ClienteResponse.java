package br.dev.ederson.estudo.jdbi.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClienteResponse {
    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private Boolean ativo;
    private LocalDateTime dataCriacao;
}
