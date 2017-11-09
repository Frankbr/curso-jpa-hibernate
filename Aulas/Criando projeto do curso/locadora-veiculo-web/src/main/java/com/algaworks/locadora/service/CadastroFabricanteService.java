package com.algaworks.locadora.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.util.jpa.Transactional;
import com.algaworks.locadora.dao.FabricanteDAO;
import com.algaworks.locadora.modelo.Fabricante;

public class CadastroFabricanteService implements Serializable {
	
	@Inject
	FabricanteDAO fabricanteDAO;
	
	
	@Transactional
	public void salvar(Fabricante fabricante ) throws NegocioException{
		
		if(fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante é obrigatório");
		}
		fabricanteDAO.salvar(fabricante);
	}

}
