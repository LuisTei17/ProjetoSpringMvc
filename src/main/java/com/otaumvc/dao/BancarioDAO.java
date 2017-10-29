package com.otaumvc.dao;

import java.util.List;

import com.otaumvc.model.Bancario;
/**
 * 
 * Interface para assinar metodos
 * que vao acessar o banco de dados
 *
 */
public interface BancarioDAO {
	
	// Definindo assinatura dos m�todos
	public void addBancario(Bancario bancario);
	public void updateBancario(Bancario bancario);
	public List<Bancario> listaBancarios();
	public Bancario getBancarioById(int id);
	public void removeBancario(int id);
}
