package com.mpapi.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mpapi.model.DTOs.TrademarksResponse.TrademarksResponseDTO;
import com.mpapi.web.services.MotorcyclePostService;

@RestController
@RequestMapping("/MotorcilePostController")
public class MotorcilePostController {

	
	@Autowired
	private MotorcyclePostService motorcyclePostService;

	/*
	 * Peticion que me traera un JSON con la informacion promedio de las motos haciendo llamadas en paralelo. 
	 */
	@RequestMapping(value = "getTrademarkInfo", method = RequestMethod.GET)
	public ResponseEntity<TrademarksResponseDTO> getTrademarkInfo() {
		
	
		try {
			TrademarksResponseDTO trademarksResponseDTO = motorcyclePostService.getTrademarkInfo();
			return ResponseEntity.ok(trademarksResponseDTO);

		} catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		
	}
}
