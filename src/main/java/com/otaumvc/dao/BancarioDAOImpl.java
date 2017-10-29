package com.otaumvc.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.otaumvc.model.Bancario;

/**
 * 
 * Implemtando a interface BancarioDAo
 * para que se possa acessar o banco de dados
 *
 */
@Repository
public class BancarioDAOImpl implements BancarioDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BancarioDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	// M�todo para adicionar banc�rio
	// Session faz o papel do entity manager
	@Override
	public void addBancario(Bancario bancario) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bancario);
		logger.info(bancario + " salvo com sucesso");
	}
	
	// M�todo para atualizar banc�rio
	@Override
	public void updateBancario(Bancario bancario) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(bancario);
		logger.info(bancario+" atualizado com sucesso");
	}
	
	// Impedindo logs desnecess�rios sobre avisos
	@SuppressWarnings("unchecked")
	// M�todo que lista os banc�rios
	@Override
	public List<Bancario> listaBancarios() {
		// Resgata a conex�o atual
		Session session = this.sessionFactory.getCurrentSession();
		// Cria uma query semelhante ao SELECT * FROM Bancario
		List<Bancario> bancariosList = session.createQuery("from Bancario").list();
		// Imprime logs de todos os banc�rios 
		for(Bancario bancario : bancariosList){
			logger.info("Lista de bancarios:"+bancario);
		
		}
		return bancariosList;
	}

	// M�todo que resgata um banc�rio por seu id
	@Override
	public Bancario getBancarioById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		// Coloca o banc�rio procurado como valor da variavel bancario
		Bancario bancario = (Bancario) session.load(Bancario.class, new Integer(id));
		logger.info(bancario + " de id " + id);
		return bancario;
	}
	
	// M�todo para remover banc�rio por seu id
	@Override
	public void removeBancario(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		// Coloca o banc�rio procurado como valor da variavel bancario
		Bancario bancario = (Bancario) session.load(Bancario.class, new Integer(id));
		// Verifica se existe um bancario resgatado para delet�-lo
		if(null != bancario){
			session.delete(bancario);
		}
		logger.info(bancario + " deletado");
	}

}
