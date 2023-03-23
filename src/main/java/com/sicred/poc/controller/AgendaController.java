package com.sicred.poc.controller;

import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.external.dto.AgendaSaveDTO;
import com.sicred.poc.service.impl.AgendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/agenda")
@AllArgsConstructor
@CrossOrigin("*")
public class AgendaController {

    private AgendaService service;

    @Operation(summary = "Listagem de Pautas",
            description = "Listagem de registros",
            tags = {"Listagem de registros"})
    @ApiResponse(responseCode = "200", description = "Listagem de registros")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AgendaDTO.class))
                    )})})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/all")
    public ResponseEntity<List<AgendaDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(summary = "Pesquisa por titulo de Pauta",
            description = "Pesquisa por titulo",
            tags = {"Pesquisa por nome"})
    @ApiResponse(responseCode = "200", description = "Pesquisa por titulo")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AgendaDTO.class))
            })})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/{title}")
    public ResponseEntity<AgendaDTO> findByTitle(@PathParam("title") String title) {
        return ResponseEntity.ok(service.findByTitle(title));
    }

    @Operation(summary = "Inclusão de Pauta",
            description = "Criação de Pauta",
            tags = {"Criação de registro"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a Pauta se já houver o " +
                    "Titulo informado cadastrado",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AgendaDTO.class))),
            @ApiResponse(responseCode = "201", description = "Retorna a Pauta Salva",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AgendaDTO.class)))
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/save")
    public ResponseEntity<AgendaDTO> save(@RequestBody AgendaSaveDTO agendaDTO) {
        return service.save(agendaDTO);
    }

    @Operation(summary = "Atualizão de Pauta",
            description = "Atualizão de Pauta",
            tags = {"Atualização"})
    @ApiResponse(responseCode = "200", description = "Update Operation")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AgendaDTO.class))
            })})
    @PutMapping("/update")
    public ResponseEntity<AgendaDTO> update(@RequestBody AgendaDTO originDto) {
        return ResponseEntity.ok(service.update(originDto));
    }

}
