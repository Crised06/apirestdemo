package com.example.apirestdemo.dto;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity(name = "cliente")
@Table(name="CLI_CLI",schema="clientes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ClienteDTO {
    
    @Id
	@Column(name="CLI_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
    private BigDecimal id;

	@Column(name="CLI_RUT")
    private BigDecimal rut;

    @Column(name="CLI_DV")
    private String dv;

    @Column(name="CLI_NOM")
    private String nombre;

    @Column(name="CLI_APL_PTN")
    private String apPaterno;

    @Column(name="CLI_APL_MTN")
    private String apMaterno;

    @Column(name="SEX_ID")
    private BigDecimal sexo;

    @Column(name="CLI_FEC_NCT")
    private Date fechaNacimiento;

    @Column(name="CLI_FEC_DFU")
    private Date fechaDefuncion;

    @Column(name="CLI_EML")
    private String email;

    @Column(name="EST_ID")
    private BigDecimal estado;

    @Column(name="TIP_ID")
    private BigDecimal tipo;

    @Column(name="FTE_ID")
    private BigDecimal fuenteDato;
}
