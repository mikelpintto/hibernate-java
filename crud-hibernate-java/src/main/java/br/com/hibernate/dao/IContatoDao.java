package br.com.hibernate.dao;

import java.util.List;

import br.com.hibernate.model.Contato;

public interface IContatoDao {

	void save(Contato contato);

	void update(Contato contato);

	Contato getById(long id);

	List<Contato> getAll();

	void deleteContatos(long id);

	Contato getById(int id);

	void deleteContatos(int id);

}