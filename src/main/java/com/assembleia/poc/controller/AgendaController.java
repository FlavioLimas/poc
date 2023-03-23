package com.assembleia.poc.controller;

import com.assembleia.poc.external.dto.AgendaDTO;
import com.assembleia.poc.service.impl.AgendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    @ApiResponse(responseCode = "200", description = "List operation")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AgendaDTO.class))
                    )})})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/all")
    public ResponseEntity<List<AgendaDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }


}
