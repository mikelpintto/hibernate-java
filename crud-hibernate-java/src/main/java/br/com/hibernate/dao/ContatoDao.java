package br.com.hibernate.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import br.com.hibernate.model.Contato;
import br.com.hibernate.util.Util;

public class ContatoDao implements IContatoDao {

	public void save(Contato contato) {

		org.hibernate.Transaction transaction = null;

		try (Session session = Util.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.save(contato);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	@Override
	public void update(Contato contato) {

		org.hibernate.Transaction transaction = null;

		try (Session session = Util.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			session.saveOrUpdate(contato);

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	@Override
	public Contato getById(int id) {

		Contato contato = null;

		try (Session session = Util.getSessionFactory().openSession()) {

			contato = session.find(Contato.class, id);
			System.out.println(
					"ID: " + contato.getId() + " Nome: " + contato.getNome() + " Idade: " + contato.getIdade());
			System.out.println("Pronto!");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return contato;
	}

	@Override
	public List<Contato> getAll() {

		// org.hibernate.Transaction transaction = null;
		List<Contato> contato = null;

		try (Session session = Util.getSessionFactory().openSession()) {

			// transaction = session.beginTransaction();

			// contato = session.createQuery("from Contatos").list();

		} catch (Exception e) {
			// if (transaction != null) {
			// transaction.rollback();
			e.printStackTrace();
		}

		return contato;
	}

	@Override
	public void deleteContatos(int id) {

		org.hibernate.Transaction transaction = null;
		Contato contato = null;

		try (Session session = Util.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();

			contato = session.get(Contato.class, id);

			session.delete(contato);

			transaction.commit();

		} catch (Exception e) {
			// if (transaction != null) {
			// transaction.rollback();
			e.printStackTrace();
		}
	}

	public Contato getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteContatos(long id) {
		// TODO Auto-generated method stub

	}

	public void getNome(String nome) {

		try(Session session = Util.getSessionFactory().openSession()){
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Contato> criteriaQuery = criteriaBuilder.createQuery(Contato.class);
		Root<Contato> root = criteriaQuery.from(Contato.class);

		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("nome"), nome));

		TypedQuery<Contato> typedQuery = session.createQuery(criteriaQuery);
		Contato contato = typedQuery.getSingleResult();
		System.out.println(contato.getNome() + ", " + contato.getIdade() + ", " + contato.getDataCadastro() );
		}catch (Exception e) {
			// if (transaction != null) {
			// transaction.rollback();
			e.printStackTrace();
		}

	}

	public void getByIdade( int idade) {

		try(Session session = Util.getSessionFactory().openSession()){
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Contato> criteriaQuery = criteriaBuilder.createQuery(Contato.class);
		Root<Contato> root = criteriaQuery.from(Contato.class);

		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("idade"), idade));

		TypedQuery<Contato> typedQuery = session.createQuery(criteriaQuery);
		Contato contato = typedQuery.getSingleResult();
		System.out.println(contato.getNome() + ", " + contato.getIdade() + ", " + contato.getDataCadastro() );
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getByDataCadastro(String dataCadastro) {
		try(Session session = Util.getSessionFactory().openSession()){
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

		CriteriaQuery<Contato> criteriaQuery = criteriaBuilder.createQuery(Contato.class);
		Root<Contato> root = criteriaQuery.from(Contato.class);

		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("dataCadastro"), dataCadastro));

		TypedQuery<Contato> typedQuery = session.createQuery(criteriaQuery);
		Contato contato = typedQuery.getSingleResult();
		System.out.println(contato.getNome() + ", " + contato.getIdade() + ", " + contato.getDataCadastro() );
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
