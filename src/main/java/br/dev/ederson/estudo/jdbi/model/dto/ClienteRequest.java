package br.dev.ederson.estudo.jdbi.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClienteRequest {
  @NotBlank
  private String nome;
  @Email
  @NotBlank
  private String email;
  private String telefone;
  private Boolean ativo;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dataNascimento;
}