package com.example.apirestdemo.service;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.apirestdemo.dto.ClienteDTO;

@Service
public interface ICLientes {

    Page<ClienteDTO> findAll() throws Exception;
	
	Page<ClienteDTO> findAllPager(BigDecimal numPagina,BigDecimal limite,String orden) throws Exception;
}
