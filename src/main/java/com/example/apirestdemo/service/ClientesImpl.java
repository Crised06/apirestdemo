package com.example.apirestdemo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.apirestdemo.dto.ClienteDTO;
import com.example.apirestdemo.repository.ClientesRepository;

@Service
@SuppressWarnings("unchecked")
public class ClientesImpl implements ICLientes{

    @Autowired
	ClientesRepository repo;
	
	
	@Override
	public Page<ClienteDTO> findAll() throws Exception {		
				
		return (Page<ClienteDTO>) repo.findAll();
	}	
	
	@Override
	public Page<ClienteDTO> findAllPager(BigDecimal numPagina, BigDecimal limit, String orden) throws Exception{
		
		Page<ClienteDTO> personas;
		
		int pagina=numPagina!=null?((numPagina.intValue()-1)<0?0:numPagina.intValue()-1):0;
		int limite=limit!=null?((limit.intValue())<0?0:limit.intValue()):10;

		String[] prop=new String[1];
		prop[0]="id";
		
		if(orden!=null) {			
			String[] array=orden.split(",");
			Direction dir;				
			
			switch(array[1].toUpperCase()) {
			case "DESC":
				dir=Direction.DESC;				
				break;
			case "ASC":
				dir=Direction.ASC;				
				break;
				default:
					dir=Direction.ASC;
					break;
			}
			
			if(array[0].length()>0) {
				String[] propAux=array[0].split(",");
				prop=propAux.clone();
			}
			personas=repo.findAll(PageRequest.of(pagina, limite,Sort.by(dir, prop)));			
		}else {			
			personas=repo.findAll(PageRequest.of(pagina, limite,Sort.by(Direction.ASC, prop)));
		}
		
		return personas;
	}
}
