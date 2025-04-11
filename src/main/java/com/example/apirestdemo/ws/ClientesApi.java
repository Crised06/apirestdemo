package com.example.apirestdemo.ws;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirestdemo.dto.ClienteDTO;
import com.example.apirestdemo.dto.ErrorDTO;
import com.example.apirestdemo.dto.ResponseErrorDTO;
import com.example.apirestdemo.dto.ResponseListDTO;
import com.example.apirestdemo.service.ICLientes;

@RestController
@RequestMapping("pruebaRest")
@SuppressWarnings("rawtypes")
public class ClientesApi {

    @Autowired
	ICLientes srv;

	@GetMapping("/getStatus")
	public ResponseEntity<String> getStatus(){
		return ResponseEntity.status(200).body("On Line");
	}
	
	
	@GetMapping("/clientes")
	public ResponseEntity clientes(
			@RequestParam(name = "page",required = false) BigDecimal numPagina,
			@RequestParam(name = "limit",required = false) BigDecimal limite,
			@RequestParam(name = "sort",required = false) String orden){		
		
		ResponseListDTO respLst=new ResponseListDTO();
		ResponseErrorDTO respError=new ResponseErrorDTO();
		List<ErrorDTO> lstError=new ArrayList<>();
		int status;
		try {
			Page<ClienteDTO> personas=srv.findAllPager(numPagina,limite,orden);	
			respLst.setData(personas.getContent());		
			respLst.setPages(new BigDecimal(personas.getTotalPages()));
			respLst.setTotal(new BigDecimal(personas.getTotalElements()));
			respLst.setLimit(new BigDecimal(limite!=null?((limite.intValue())<0?0:limite.intValue()):10));
			respLst.setPage(new BigDecimal(numPagina!=null?((numPagina.intValue()-1)<1?1:numPagina.intValue()):1));
			status=200;
		}catch(Exception ex) {			
						
			ErrorDTO error=new ErrorDTO();
			error.setCode(new BigDecimal(500));
			error.setMessage(ex.getMessage());
			error.setId(UUID.randomUUID().toString());
			
			lstError.add(error);
			
			respError.setErrors(lstError);
			
			status=500;
		}
		
		return ResponseEntity.status(status).body(!lstError.isEmpty()?respError:respLst);
	}
}
