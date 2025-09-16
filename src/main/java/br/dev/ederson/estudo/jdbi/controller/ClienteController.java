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
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@Tag(name="Clientes", description="CRUD de clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    @Operation(summary="Cria um cliente")
    public ResponseEntity<ClienteResponse> create(@Valid @RequestBody ClienteRequest req){
        Cliente result = clienteService.create(req);
        return ResponseEntity.created(URI.create("/cliente/" + result.getId())).body(ClienteResponse.map(result));
    }

    @GetMapping("/{id}")
    @Operation(summary="Busca um cliente por ID")
    public ResponseEntity<ClienteResponse> getById(@PathVariable UUID id){
        return ResponseEntity.ok(ClienteResponse.map(clienteService.getById(id)));
    }

    @GetMapping
    @Operation(summary="Busca todos os clientes cadastrados")
    public List<ClienteResponse> listAll(){
        return clienteService.listAll().stream().map(ClienteResponse::map).toList();
    }

    @PutMapping("/{id}")
    @Operation(summary="Atualiza um cliente")
    public ResponseEntity<String> update(@PathVariable UUID id, @RequestBody ClienteRequest req) {
        try {
            clienteService.update(id, req);

            return ResponseEntity.created(URI.create("/cliente/" + id)).body("Cliente atualizado com sucesso.");

        } catch (NoSuchElementException e) {
            return ResponseEntity.noContent().build();
        }

    }

    @DeleteMapping("/{id}")
    @Operation(summary="Deleta um cliente")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        clienteService.delete(id);
        return ResponseEntity.ok().build();
    }

}