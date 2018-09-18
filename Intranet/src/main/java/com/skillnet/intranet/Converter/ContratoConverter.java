package com.skillnet.intranet.Converter;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContratoConverter {
	private int id;
	private String ejecutivo;
	private String tipo_contrato;
	private String horario;
	private String f_inicio;
	private String f_final;
	private int num_visitas;
	private String ing_visita;
	private String mantenimiento1;
	private String mantenimiento2;
	private String mantenimiento3;
	private String mantenimiento4;
	private int nit;
	
	public ContratoConverter() {}

	public ContratoConverter(int id, String ejecutivo, String tipo_contrato, String horario, String f_inicio,
			String f_final, int num_visitas, String ing_visita, String mantenimiento1, String mantenimiento2,
			String mantenimiento3, String mantenimiento4, int nit) {
		super();
		this.id = id;
		this.ejecutivo = ejecutivo;
		this.tipo_contrato = tipo_contrato;
		this.horario = horario;
		this.f_inicio = f_inicio;
		this.f_final = f_final;
		this.num_visitas = num_visitas;
		this.ing_visita = ing_visita;
		this.mantenimiento1 = mantenimiento1;
		this.mantenimiento2 = mantenimiento2;
		this.mantenimiento3 = mantenimiento3;
		this.mantenimiento4 = mantenimiento4;
		this.nit = nit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public String getTipo_contrato() {
		return tipo_contrato;
	}

	public void setTipo_contrato(String tipo_contrato) {
		this.tipo_contrato = tipo_contrato;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getF_inicio() {
		return f_inicio;
	}

	public void setF_inicio(String f_inicio) {
		this.f_inicio = f_inicio;
	}

	public String getF_final() {
		return f_final;
	}

	public void setF_final(String f_final) {
		this.f_final = f_final;
	}

	public int getNum_visitas() {
		return num_visitas;
	}

	public void setNum_visitas(int num_visitas) {
		this.num_visitas = num_visitas;
	}

	public String getIng_visita() {
		return ing_visita;
	}

	public void setIng_visita(String ing_visita) {
		this.ing_visita = ing_visita;
	}

	public String getMantenimiento1() {
		return mantenimiento1;
	}

	public void setMantenimiento1(String mantenimiento1) {
		this.mantenimiento1 = mantenimiento1;
	}

	public String getMantenimiento2() {
		return mantenimiento2;
	}

	public void setMantenimiento2(String mantenimiento2) {
		this.mantenimiento2 = mantenimiento2;
	}

	public String getMantenimiento3() {
		return mantenimiento3;
	}

	public void setMantenimiento3(String mantenimiento3) {
		this.mantenimiento3 = mantenimiento3;
	}

	public String getMantenimiento4() {
		return mantenimiento4;
	}

	public void setMantenimiento4(String mantenimiento4) {
		this.mantenimiento4 = mantenimiento4;
	}

	public int getNit() {
		return nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	
}