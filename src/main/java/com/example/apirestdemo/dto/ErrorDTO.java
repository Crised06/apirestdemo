package com.example.apirestdemo.dto;

import java.math.BigDecimal;

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
public class ErrorDTO {

    private String message;
	
	private BigDecimal code;
	
	private String id;
    
}
