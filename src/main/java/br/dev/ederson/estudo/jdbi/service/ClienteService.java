package br.dev.ederson.estudo.jdbi.service;

import br.dev.ederson.estudo.jdbi.dao.ClienteDao;
import br.dev.ederson.estudo.jdbi.model.Cliente;
import br.dev.ederson.estudo.jdbi.model.dto.ClienteRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteDao clienteDao;

    @Transactional
    public Cliente create(ClienteRequest req){
        Cliente c = new Cliente();
        c.setId(UUID.randomUUID());
        c.setNome(req.getNome());
        c.setEmail(req.getEmail());
        c.setTelefone(req.getTelefone());
        c.setDataNascimento(req.getDataNascimento());
        c.setAtivo(true);
        c.setDataCriacao(LocalDateTime.now());

        clienteDao.insert(c);
        return c;
    }

    @Transactional
    public Cliente getById(UUID id) {
        return clienteDao.findById(id).orElseThrow();
    }

    @Transactional
    public List<Cliente> listAll() {
        return clienteDao.findAll();
    }

    @Transactional
    public int update(UUID id, @Valid ClienteRequest req) {
        Cliente c = getById(id);

        if (req.getNome() != null) {
            c.setNome(req.getNome());
        }

        if (req.getEmail() != null) {
            c.setEmail(req.getEmail());
        }

        if (req.getEmail() != null) {
            c.setEmail(req.getEmail());
        }

        if (req.getTelefone() != null) {
            c.setTelefone(req.getTelefone());
        }

        if (req.getAtivo() != null) {
            c.setAtivo(req.getAtivo());
        }

        if (req.getDataNascimento() != null) {
            c.setDataNascimento(req.getDataNascimento());
        }

        return clienteDao.update(c);
    }

    @Transactional
    public void delete(UUID id) {
        clienteDao.delete(id);
    }

}
