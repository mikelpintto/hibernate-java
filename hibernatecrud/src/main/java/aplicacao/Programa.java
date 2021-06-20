package aplicacao;

import dao.PessoaDao;
import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		//salvar no banco de dados
		Pessoa pessoa = new Pessoa("Fabiano", "fabiano@gmail.com");
		PessoaDao pessoaDao = new PessoaDao();
		pessoaDao.save(pessoa);

		// atualiza no banco de dados
		
		//pessoa.setNome("CLAUDIO");
		//pessoa.setId(5);
		//pessoa.setEmail("claudio.apr@gmail.com");
		//pessoaDao.update(pessoa);
		
		// buscar no banco de dados

		 // pessoaDao.getId(3);

		// deletar pelo id do banco de dados

		// pessoaDao.deleteById(1);

	}

}
