package com.otaumvc.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.otaumvc.dao.BancarioDAO;
import com.otaumvc.model.Bancario;
/**
 * 
 * Servi�o que resgata as informa��o obtidas
 * no DAO
 *
 */
@Service
public class BancarioServiceImpl implements BancarioService {
	
	private BancarioDAO bancarioDAO;
	
	
	public void setBancarioDAO(BancarioDAO bancarioDAO) {
		this.bancarioDAO = bancarioDAO;
	}

	@Override
	// Transactional � uma anota��o que 
	// garante que o processo deve ser executado
	// com �xito, do contr�rio, nada ser� persistido
	@Transactional
	public void addBancario(Bancario bancario) {
		this.bancarioDAO.addBancario(bancario);
	}

	@Override
	@Transactional
	public void updateBancario(Bancario bancario) {
		this.bancarioDAO.updateBancario(bancario);
	}

	@Override
	@Transactional
	public List<Bancario> listaBancarios() {
		return this.bancarioDAO.listaBancarios();
	}

	@Override
	@Transactional
	public Bancario getBancarioById(int id) {
		return this.bancarioDAO.getBancarioById(id);
	}

	@Override
	@Transactional
	public void removeBancario(int id) {
		this.bancarioDAO.removeBancario(id);
	}


}
