package com.example.apirestdemo.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListDTO {

    private BigDecimal total;
	
	private BigDecimal page;
	
	private BigDecimal limit;
	
	private BigDecimal pages;
	
	private List<?> data;
}
