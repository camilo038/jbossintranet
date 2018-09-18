package com.skillnet.intranet.Servicio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skillnet.intranet.Converter.ContratoConverter;
import com.skillnet.intranet.model.Cliente;
import com.skillnet.intranet.model.Contrato;

@Service("contratoService")
public class ContratoService {

	private final RestTemplate restTemplate;

	private final String GET_URL_CONTRATO = "http://172.18.48.140:8280/say/ConsultarContrato";
	private final String POST_URL_CONTRATO = "http://172.18.48.140:8280/say/InsertarContrato";
	private final String PUT_URL_CONTRATO = "http://172.18.48.140:8280/say/ActualizarContrato";
	private final String DELETE_URL_CONTRATO = "http://172.18.48.140:8280/say/EliminarContrato";

	@Autowired
	public ContratoService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void removeContrato(int nit, int id) {

		if (0 != nit && 0 != id) {
			HttpHeaders headers = new HttpHeaders();
			headers.set("nit", String.valueOf(nit));
			headers.set("id", String.valueOf(id));
			HttpEntity entity = new HttpEntity(headers);
			ResponseEntity<String> response = restTemplate.exchange(DELETE_URL_CONTRATO, HttpMethod.DELETE, entity,
					String.class);
		}

	}

	public ArrayList<Contrato> findContratoById(int nit) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("nit", String.valueOf(nit));
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Contrato[]> response = restTemplate.exchange(GET_URL_CONTRATO, HttpMethod.GET, entity,
				Contrato[].class);
		Contrato[] cliente = response.getBody();

		ArrayList<Contrato> converterContrato = new ArrayList<>();
		for (Contrato cliente2 : cliente) {
			converterContrato.add(cliente2);
		}

		return converterContrato;
	}

	public Contrato addContrato(Contrato contrato) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("nit", String.valueOf(contrato.getNit()));
		headers.set("ejecutivo", contrato.getEjecutivo());
		headers.set("tipo_contrato", contrato.getTipo_contrato());
		headers.set("f_inicio", contrato.getF_inicio());
		headers.set("f_final", contrato.getF_final());
		headers.set("horario", contrato.getHorario());
		headers.set("num_visitas", String.valueOf(contrato.getNum_visitas()));
		headers.set("ing_visita", contrato.getIng_visita());
		headers.set("mantenimiento1", contrato.getMantenimiento1());
		headers.set("mantenimiento2", contrato.getMantenimiento2());
		headers.set("mantenimiento3", contrato.getMantenimiento3());
		headers.set("mantenimiento4", contrato.getMantenimiento4());

		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> response = restTemplate.exchange(POST_URL_CONTRATO, HttpMethod.POST, entity,
				String.class);
		return contrato;
	}
	
	
	public Contrato UpdateContrato(Contrato contrato) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("id", String.valueOf(contrato.getId()));
		headers.set("nit", String.valueOf(contrato.getNit()));
		headers.set("ejecutivo", contrato.getEjecutivo());
		headers.set("tipo_contrato", contrato.getTipo_contrato());
		headers.set("f_inicio", contrato.getF_inicio());
		headers.set("f_final", contrato.getF_final());
		headers.set("horario", contrato.getHorario());
		headers.set("num_visitas", String.valueOf(contrato.getNum_visitas()));
		headers.set("ing_visita", contrato.getIng_visita());
		headers.set("mantenimiento1", contrato.getMantenimiento1());
		headers.set("mantenimiento2", contrato.getMantenimiento2());
		headers.set("mantenimiento3", contrato.getMantenimiento3());
		headers.set("mantenimiento4", contrato.getMantenimiento4());

		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> response = restTemplate.exchange(PUT_URL_CONTRATO, HttpMethod.PUT, entity,
				String.class);
		return contrato;
	}
	
	
	public ContratoConverter findContratoByNit(int nit,int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("nit", String.valueOf(nit));
		headers.set("id", String.valueOf(id));
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Contrato[]> response = restTemplate.exchange(GET_URL_CONTRATO, HttpMethod.GET, entity,
				Contrato[].class);
		Contrato[] cliente = response.getBody();

		ContratoConverter converter = new ContratoConverter();
		for (Contrato cliente2 : cliente) {
			converter.setId(cliente2.getId());
			converter.setEjecutivo(cliente2.getEjecutivo());
			converter.setTipo_contrato(cliente2.getTipo_contrato());
			converter.setHorario(cliente2.getHorario());
			converter.setF_inicio(cliente2.getF_inicio());
			converter.setF_final(cliente2.getF_final());
			converter.setNum_visitas(cliente2.getNum_visitas());
			converter.setIng_visita(cliente2.getIng_visita());
			converter.setMantenimiento1(cliente2.getMantenimiento1());
			converter.setMantenimiento2(cliente2.getMantenimiento2());
			converter.setMantenimiento3(cliente2.getMantenimiento3());
			converter.setMantenimiento4(cliente2.getMantenimiento4());
			converter.setNit(cliente2.getNit());
			
			
		
	}
		return converter;
	

}
}
