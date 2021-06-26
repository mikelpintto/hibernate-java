package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	public void getByNome(String nome) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatecrud");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select p from Pessoa p where p.nome = :nome";
		
		TypedQuery<Pessoa> typedQueryLog = em.createQuery(jpql, Pessoa.class);
		typedQueryLog.setParameter("nome", nome);
		
		Pessoa pessoaLog = typedQueryLog.getSingleResult();
		System.out.println(pessoaLog.getNome());
		System.out.println("Pronto!");
		em.close();
		emf.close();
		
	}
	
	public void getByEmail(String email) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatecrud");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "select p from Pessoa p where p.email = :email";
		
		TypedQuery<Pessoa> typedQueryLog = em.createQuery(jpql, Pessoa.class);
		typedQueryLog.setParameter("email", email);
		
		Pessoa pessoaLog = typedQueryLog.getSingleResult();
		System.out.println(pessoaLog.getEmail());
		System.out.println("Pronto!");
		em.close();
		emf.close();
		
		
	}
	
	

}
