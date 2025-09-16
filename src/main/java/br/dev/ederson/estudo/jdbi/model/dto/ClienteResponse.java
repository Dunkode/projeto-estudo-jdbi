package br.dev.ederson.estudo.jdbi.model.dto;

import br.dev.ederson.estudo.jdbi.model.Cliente;
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

    public static ClienteResponse map(Cliente c){
        ClienteResponse resp = new ClienteResponse();

        resp.setNome(c.getNome());
        resp.setEmail(c.getEmail());
        resp.setTelefone(c.getTelefone());
        resp.setDataNascimento(c.getDataNascimento());
        resp.setAtivo(c.getAtivo());
        resp.setDataCriacao(c.getDataCriacao());

        return resp;
    }
}
