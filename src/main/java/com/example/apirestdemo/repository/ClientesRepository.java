package com.example.apirestdemo.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.apirestdemo.dto.ClienteDTO;

@Repository
public interface ClientesRepository extends PagingAndSortingRepository<ClienteDTO,BigDecimal>,JpaRepository<ClienteDTO,BigDecimal>{

}
