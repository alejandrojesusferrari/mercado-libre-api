package com.mpapi.web.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpapi.model.DTOs.MLResponse.MLResponseDTO;
import com.mpapi.model.DTOs.MLResponse.ResultDTO;
import com.mpapi.model.DTOs.TrademarksResponse.TrademarksResponseDTO;
import com.mpapi.model.beans.Trademarks;
import com.mpapi.web.services.utils.MLAccessService;

@Service
public class MotorcyclePostService {

	@Autowired
	private MLAccessService mlAccessService;
	
	public TrademarksResponseDTO getTrademarkInfo() {
		
		//llamo al servicio de acceso a la api de ML y obtengo una respuesta de su tipo
		MLResponseDTO mlResponseDTO = mlAccessService.getMotorcyclesPubs();
		
		//Genero una instancia de trademarks, que es un maps de marcas con sus datos, a partir de la info obtenida de las llamadas
		Trademarks trademarks = this.populateTrademarksAsArray(mlResponseDTO);
		
		//Ahora genero el objeto que le dara origen al JSON de salida. 
		TrademarksResponseDTO trademarksResponseDTO = new TrademarksResponseDTO(trademarks);
		return trademarksResponseDTO;
		
	}

	private Trademarks populateTrademarksAsArray(MLResponseDTO mlResponseDTO) {
		/*
		 * Transforma los resultados de la peticion en un objeto trademarks
		 * que es un map con la info de cada marca. 
		 */
		
		Trademarks trademarks = new Trademarks();
		
		ArrayList<ResultDTO> resultDTOs = mlResponseDTO.getResults();
		
		for (ResultDTO resultDTO : resultDTOs) {
			trademarks.addItem(resultDTO);
		}
		
		return trademarks;
	}
	
	
	
}
