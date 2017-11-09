package com.algaworks.locadora.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.util.jsf.FacesUtil;
import com.algaworks.locadora.dao.FabricanteDAO;
import com.algaworks.locadora.modelo.Fabricante;
import com.algaworks.locadora.service.NegocioException;

@Named
@ViewScoped
public class PesquisarFabricanteBean implements Serializable {

	@Inject
	FabricanteDAO fabricanteDAO;

	@PostConstruct
	public void inicializar() {
		fabricantes = fabricanteDAO.buscarTodos();
	}

	private List<Fabricante> fabricantes;

	private Fabricante fabricanteSelecionado;

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void excluir() {
		try {
		fabricanteDAO.excluir(fabricanteSelecionado);
		this.fabricantes.remove(fabricanteSelecionado);
		FacesUtil.addSuccessMessage("Fabricante removido com sucesso");
		}catch (NegocioException e) {
			FacesUtil.addErrorMessage("Erro ao excluir fabricante." +e.getMessage());
		}
	}

	public Fabricante getFabricanteSelecionado() {
		return fabricanteSelecionado;
	}

	public void setFabricanteSelecionado(Fabricante fabricanteSelecionado) {
		this.fabricanteSelecionado = fabricanteSelecionado;
	}

}
