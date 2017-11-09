package com.algaworks.locadora.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.util.jsf.FacesUtil;
import com.algaworks.locadora.modelo.Fabricante;
import com.algaworks.locadora.service.CadastroFabricanteService;
import com.algaworks.locadora.service.NegocioException;

@Named
@ViewScoped
public class CadastroFabricanteBean implements Serializable{
	
	@Inject
	private CadastroFabricanteService cadastroFabricante;
	
	private Fabricante fabricante;
	
	@PostConstruct
	public void init() {
		limpar();
	}
	
	private void limpar() {
		fabricante = new Fabricante();
	}
	
	public void salvar() {
		
		try {
			this.cadastroFabricante.salvar(fabricante);
			FacesUtil.addSuccessMessage("Fabricante Salvo com sucesso !");
			limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro ao salvar. "+e.getMessage());
		}
	}



	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	

}
