package com.otaumvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidade bean que utiliza
 * Hibernate para implementar JPA
 *
 */
@Entity
@Table(name="Bancario")
public class Bancario {
	// Definindo atributos da classe bancario
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	
	// Getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Re-escrita do m�todo toString para retoranr id e nome do bancario
	@Override
	public String toString(){
		return "id="+this.getId()+", name="+this.getNome();
	}
}
