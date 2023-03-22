package com.sicred.poc.service.impl;

import com.sicred.poc.mapper.AgendaMapper;
import com.sicred.poc.repository.AgendaRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class AgendaService {

    private AgendaRepository repository;

    private AgendaMapper mapper;

}
