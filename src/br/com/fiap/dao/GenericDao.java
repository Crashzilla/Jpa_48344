package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao<T> implements Dao<T>{
	
	private final Class<T> classe;
	protected EntityManager em;
	
	public GenericDao(Class<T> classe) {
		super();
		this.classe = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em=JpaUtil.geEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
		System.out.println(entidade + " adicionada com sucesso");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em=JpaUtil.geEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}

	@Override
	public void atualizar(T entidade) {
		em=JpaUtil.geEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public void remover(T entidade) {
		em=JpaUtil.geEntityManager();
		em.getTransaction().begin();
		em.remove(entidade);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public T buscar(int id) {
		em=JpaUtil.geEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close(); 
		 
		return entidade;
	}	
}
