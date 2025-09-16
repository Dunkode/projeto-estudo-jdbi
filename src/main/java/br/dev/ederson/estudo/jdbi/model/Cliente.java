package br.dev.ederson.estudo.jdbi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    private UUID id;
    private String nome;
    private String email;
    private String telefone;
    @ColumnName("data_nascimento")
    private LocalDate dataNascimento;
    private Boolean ativo;
    @ColumnName("data_criacao")
    private LocalDateTime dataCriacao;
}
