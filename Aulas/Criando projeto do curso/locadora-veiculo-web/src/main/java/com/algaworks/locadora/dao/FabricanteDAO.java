package com.algaworks.locadora.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.util.jpa.Transactional;
import com.algaworks.locadora.modelo.Fabricante;
import com.algaworks.locadora.service.NegocioException;

public class FabricanteDAO implements Serializable{
	
	@Inject
	EntityManager em;
	
	public void salvar(Fabricante fabricante) {
		
		em.persist(fabricante);
	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> buscarTodos() {
		return em.createQuery("from Fabricante").getResultList();
	}

	@Transactional
	public void excluir(Fabricante fabricante) throws NegocioException{
		
		fabricante = em.find(Fabricante.class, fabricante.getCodigo());
		em.remove(fabricante);
		// Faz a solicitação ir ser executada no banco imediatamente 
		em.flush();
		
	}
	
	

}
