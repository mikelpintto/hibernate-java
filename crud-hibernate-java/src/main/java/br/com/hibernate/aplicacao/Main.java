package br.com.hibernate.aplicacao;

import br.com.hibernate.dao.ContatoDao;

public class Main {
	
	public static void main(String[] args) {

        ContatoDao con = new ContatoDao();
        
        // INSERE NO BANCO - ok

//       Contato contato = new Contato("ZAGALLO",9,1);
//       String pattern = "yyyy-MM-dd";
//       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//	   contato.setDataCadastro(new Date());
//       con.save(contato);
        
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
		
         // trazer informações pelo nome
        
        // con.getNome("danilo roger");
         
         // trazer informações pela idade
         
       //  con.getByIdade(15);
         
         // trazer informações pela data de cadastro
         
         //con.getByDataCadastro("21-06-23");

        
    }

}
