package com.skillnet.intranet.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skillnet.intranet.Converter.ClientConverter;
import com.skillnet.intranet.Converter.ContratoConverter;
import com.skillnet.intranet.Servicio.ContratoService;
import com.skillnet.intranet.constan.viewConstan;
import com.skillnet.intranet.model.Contrato;

@Controller
@RequestMapping("/contratos")
public class ContratoController {

	@Autowired
	@Qualifier("contratoService")
	private ContratoService contratoService;

	@GetMapping("/cancel")
	public String cancel(@RequestParam(name = "nit", required = false) int nit) {
		return "redirect:/contratos/verContratoId?nit=" + nit;
	}
	@GetMapping("/Vcontrato")
	public String contratos() {
		return viewConstan.CONTRATOS;
	}

	@GetMapping("/contratosform")
	public String RedirectClienteForm(Model model) {
		Contrato contrato = new Contrato();
		model.addAttribute("contrato", contrato);
		return viewConstan.CONTRATOS_FORM;
	}

	@GetMapping("/verContratoId")
	public String RedirectContratoForm(@RequestParam(name = "nit", required = false) int nit, Model model) {
		ArrayList<Contrato> contrato = new ArrayList<Contrato>();
		if (nit != 0) {
			contrato = contratoService.findContratoById(nit);
		}
		model.addAttribute("contratos", contrato);
		return viewConstan.CONTRATOS;
	}
	
	@GetMapping("/verContratoIdUsers")
	public String RedirectContrato(@RequestParam(name = "nit", required = false) int nit, Model model) {
		ArrayList<Contrato> contrato = new ArrayList<Contrato>();
		if (nit != 0) {
			contrato = contratoService.findContratoById(nit);
		}
		model.addAttribute("contratos", contrato);
		return viewConstan.CONTRATOSUSERS;
	}

	@GetMapping("/contratoEdit")
	public String RedirectEditFormnit(@RequestParam(name = "nit", required = false) int nit,
			@RequestParam(name = "id", required = false) int id, Model model) {
		ContratoConverter contrato = new ContratoConverter();
		if (nit != 0) {
			contrato = contratoService.findContratoByNit(nit,id);
		}
		model.addAttribute("contrato", contrato);
		return viewConstan.CONTRATOS_FORM;
	}

	@GetMapping("/addContrato")
	public String addContrato(@ModelAttribute(name = "contrato") Contrato contrato, Model model) {
		
		if (contratoService.findContratoByNit(contrato.getNit(),contrato.getId()).getId() != contrato.getId() || contrato.getId()==0) {
		
			if (null != contratoService.addContrato(contrato)) {
				model.addAttribute("resul", 1);
			} else {
				model.addAttribute("resul", 0);
			}
		} else {

			if (null != contratoService.UpdateContrato(contrato)) {

				model.addAttribute("resul", 1);
			} else {
				model.addAttribute("resul", 0);
			}
		}
		return "redirect:/contratos/verContratoId?nit=" + contrato.getNit();
	}

	@GetMapping("/removecontrato")
	public String removeContrato(@RequestParam(name = "nit", required = false) int nit,
			@RequestParam(name = "id", required = false) int id) {
		contratoService.removeContrato(nit, id);
		return "redirect:/contratos/verContratoId?nit=" + nit;
	}

}
