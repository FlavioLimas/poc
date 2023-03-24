package com.sicred.poc.controller;

import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.external.dto.VotingDTO;
import com.sicred.poc.external.dto.VotingSavedDTO;
import com.sicred.poc.service.impl.VotingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vote")
@AllArgsConstructor
@CrossOrigin("*")
public class VotingController {

    private VotingService service;

    @Operation(summary = "Pesquisa de Resultado por Pauta",
            description = "Pesquisa de Resultado por Pauta",
            tags = {"Votação"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pesquisa de Resultado por Pauta",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = VotingDTO.class)))
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/result")
    public ResponseEntity<VotingDTO> pollResult(@RequestBody AgendaDTO agendaDTO) {
        return ResponseEntity.ok(service.pollResult(agendaDTO));
    }

    @Operation(summary = "Realizar Votação",
            description = "Realizar Votação",
            tags = {"Votação"})
    @ApiResponse(responseCode = "200", description = "Realizar Votação")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Object.class))
            })})
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/voting")
    public ResponseEntity<Object> voting(VotingSavedDTO votingSavedDTO) {
        service.voting(votingSavedDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
