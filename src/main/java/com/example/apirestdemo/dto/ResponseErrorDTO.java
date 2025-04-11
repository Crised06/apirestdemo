package com.example.apirestdemo.dto;

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
public class ResponseErrorDTO {

    private List<ErrorDTO> errors;
}
