package com.sicred.poc.controller;

import com.sicred.poc.external.dto.AgendaDTO;
import com.sicred.poc.external.dto.AgendaSaveDTO;
import com.sicred.poc.service.impl.AgendaService;
import com.sicred.poc.template.AgendaTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AgendaControllerTest {

    @InjectMocks
    private AgendaController controller;
    @Mock
    private AgendaService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should Pass When GetAll OK")
    void testShouldPassWhenGetAllOK() {
        ResponseEntity<List<AgendaDTO>> response = controller.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode(),
                "Assertion fail, response status invalid");
    }

    @Test
    @DisplayName("Should Pass When FindByTitle OK")
    void testShouldPassWhenFindByTitleOK() {
        ResponseEntity<AgendaDTO> response = controller.findByTitle("Titulo da pauta teste");
        assertEquals(HttpStatus.OK, response.getStatusCode(),
                "Assertion fail, response status invalid");
    }

    @Test
    @DisplayName("Should Pass When Save CREATED")
    void testShouldPassWhenSaveCREATED() {
        AgendaSaveDTO agendaSaveDTO = AgendaTemplate.valid();
        ResponseEntity<AgendaDTO> response = controller.save(agendaSaveDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode(),
                "Assertion fail, response status invalid");
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

}