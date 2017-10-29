package com.otaumvc.service;

import java.util.List;

import com.otaumvc.model.Bancario;

/**
 * 
 * Interface que vai assinar os métodos
 * para que se possa resgatar os dados
 * adquiridos pelo DAO
 *
 */
public interface BancarioService {

	public void addBancario(Bancario bancario);
	public void updateBancario(Bancario bancario);
	public List<Bancario> listaBancarios();
	public Bancario getBancarioById(int id);
	public void removeBancario(int id);
	
}
