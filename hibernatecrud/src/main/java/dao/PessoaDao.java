package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class PessoaDao {

	public void save(Pessoa pessoa) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatecrud");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pessoa);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

	public void update(Pessoa pessoa) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatecrud");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		pessoa = em.merge(pessoa);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

	public void getId(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatecrud");
		EntityManager em = emf.createEntityManager();
		Pessoa p = em.find(Pessoa.class, id);
		System.out.println(p);
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

	public void deleteById(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatecrud");
		EntityManager em = emf.createEntityManager();
		Pessoa p = em.find(Pessoa.class, id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
