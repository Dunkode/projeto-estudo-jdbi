package br.dev.ederson.estudo.jdbi.controller;

import br.dev.ederson.estudo.jdbi.model.Cliente;
import br.dev.ederson.estudo.jdbi.model.dto.ClienteResponse;
import br.dev.ederson.estudo.jdbi.model.dto.ClienteRequest;
import br.dev.ederson.estudo.jdbi.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@Tag(name="Clientes", description="CRUD de clientes")
public class ClienteController {
    private final ClienteService service;
    public ClienteController(ClienteService service){ this.service = service; }

    @PostMapping
    @Operation(summary="Cria um cliente")
    public ResponseEntity<ClienteResponse> create(@Valid @RequestBody ClienteRequest req){
        Cliente saved = service.create(req);
        return ResponseEntity.created(URI.create("/cliente/" + saved.getId()))
                             .body(map(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> getById(@PathVariable UUID id){
        return ResponseEntity.ok(map(service.getById(id)));
    }

    @GetMapping
    public List<ClienteResponse> listAll(){
        return service.listAll().stream().map(this::map).toList();
    }

    @PutMapping("/{id}")
    public ClienteResponse update(@PathVariable UUID id, @Valid @RequestBody ClienteRequest req){
        service.update(id, req);
        return map(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ClienteResponse map(Cliente c){
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