package com.mpapi.web.services.utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.mpapi.model.DTOs.MLResponse.MLResponseDTO;

@Service
public class MLAccessService {

	public MLResponseDTO getMotorcyclesPubs() {
		/*
		 * Este metodo hace llamadas secuenciales hasta completar la cantidad de datos requeridos
		 * o se terminen las paginas a las cuales llamar.
		 */

		MLResponseDTO mlResponseDTO = new MLResponseDTO();

		do {
			if (mlResponseDTO.getPaging()==null) {
				//la primer llamada es siempre con los datos iniciales, por lo que siempre sera igual
				String uri = GenerateURI("scan", "MLA1763", 0, 50);
				mlResponseDTO = makeRequest(uri);
			} else {
				//la siguiente llamada no se hara siempre, sino que se hara si se cumplen las condiciones del while.
				String uri = GenerateURI("scan", "MLA1763", mlResponseDTO.getPaging().getOffset()+ mlResponseDTO.getPaging().getLimit(), mlResponseDTO.getPaging().getLimit());
				mlResponseDTO.merge(makeRequest(uri));
			}
			//mientas se cumpla que haya mas paginas con datos y que los datos no sean superiores a los 900 sigo haciendo llamadas. 
		} while (mlResponseDTO.getPaging().getTotal()>(mlResponseDTO.getPaging().getOffset()+mlResponseDTO.getPaging().getLimit())
				&& 900>(mlResponseDTO.getPaging().getOffset()+mlResponseDTO.getPaging().getLimit()));
		
		return mlResponseDTO;
	}
	
	private MLResponseDTO makeRequest(String uri) {
		/*
		 * Hace la llamada propiamente dicha
		 */
		MLResponseDTO mlResponseDTO;

		 HttpClient client = HttpClient.newHttpClient();
		 var httpRequest = HttpRequest.newBuilder()
				.uri(URI.create(
						String.format(uri)))
				.GET().build();
		try {
			 HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			
	         mlResponseDTO = new Gson().fromJson(response.body(), MLResponseDTO.class);
	         
	         return mlResponseDTO;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String GenerateURI(String searchType, String category, Integer offset, Integer limit) {
		
		String uRI = "https://api.mercadolibre.com/sites/MLA/search?";
		
		if (searchType!=null && !searchType.trim().equals("")) {
			uRI = uRI+"search_Type="+searchType;
		}
		if (category!=null && !category.trim().equals("")) {
			uRI = uRI+"&category="+category;
		}
		if (offset!=null) {
			uRI = uRI+"&offset="+offset;
		}
		if (limit!=null) {
			uRI = uRI+"&limit="+limit;
		}
		
		return uRI;
		
		
	}
	
	public MLResponseDTO getMotorcyclesPubsConcurrent() {
	
		MLResponseDTO mlResponseDTO = new MLResponseDTO();


		
		
		
		
		
		
		return mlResponseDTO;
	}
	

	

}
