package br.com.hibernate.aplicacao;

import java.util.Date;

import br.com.hibernate.dao.ContatoDao;
import br.com.hibernate.model.Contato;

@SuppressWarnings("unused")
public class Main {
	
	public static void main(String[] args) {

        ContatoDao con = new ContatoDao();
        
        // INSERE NO BANCO - ok

       //Contato contato = new Contato("MENDES",28,1);
		//contato.setDataCadastro(new Date());
		
       // con.save(contato);
        
	    //ATUALIZA CONTATO NO BANCO - ok

		//Contato c1 = new Contato("messi",21,1);
		//c1.setId(1);
		//c1.setDataCadastro(new Date());
		//con.update(c1);
	
        //BUSCAR O CONTATO NO BANCO PELO ID 
		
	    // con.getById(2);
		
		//Visualização de todos os contatos

		 //con.getAll();
        
		// deletar contato pelo id - ok
		 
		 //con.deleteContatos(contato.getId());
		

    }

}
