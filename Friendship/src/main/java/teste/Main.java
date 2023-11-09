package teste;

import java.sql.Date;

import dao.PessoaDAO;
import model.Pessoa;

public class Main {
	
	public static void main(String[] args) {

		// Pessoa 
		
		// adicionar pessoa
		
//		  Pessoa pessoa = new Pessoa(); 
//		  pessoa.setNome("Gabriel");
//		  pessoa.setEmail("gabriel@gmail.com");
//		  pessoa.setDataNascimento(Date.valueOf("1982-08-6"));
//		  
//		  PessoaDAO pDAO = new PessoaDAO();
//		  
//		  pDAO.add(pessoa);
		
		// buscar pessoa pelo id
		
//		  Pessoa pessoa = new Pessoa();
//		  
//		  PessoaDAO pDAO = new PessoaDAO(); 
//		  pessoa = pDAO.findbyId(5);
//		  
//		  System.out.println("Id: "+ pessoa.getIdPessoa());
//		  System.out.println("Nome: "+ pessoa.getNome());
//		  System.out.println("Email: "+ pessoa.getEmail());
//		  System.out.println("Data de nascimento: "+ pessoa.getDataNascimento());
		
		
		// listar todas as pessoa
		
//		PessoaDAO pDAO = new PessoaDAO();
//		List<Pessoa> listaPessoa = pDAO.findAll();
//		  
//		  System.out.println("                   Lista de Pessoas");
//		  System.out.println("----------------------------------------------->");
//		  listaPessoa.forEach(p -> { System.out.println("Código: "+p.getIdPessoa());
//		  System.out.println("Nome: "+p.getNome());
//		  System.out.println("Email: "+p.getEmail());
//		  System.out.println("DATA: "+p.getDataNascimento());
//		  System.out.println("----------------------------------------------->"); });
		
		// deletar pessoa pelo id
		
//		PessoaDAO pDAO = new PessoaDAO();
//		Pessoa pessoa = pDAO.findbyId(1);
//
//		pDAO.deleteByname(pessoa);
		
		// atualizar 
		
		PessoaDAO pDAO = new PessoaDAO();
		 Pessoa pessoa = pDAO.findbyId(3);
		  
		  pessoa.setNome("Kayo");
		  pessoa.setEmail("kayo@gamil");
		  pessoa.setDataNascimento(Date.valueOf("2022-03-01"));
		   pDAO.updateNameEmailById(pessoa);
		
		// Preferencias
		
		// add
		
//		Preferencias preferencias = new Preferencias();
//		 
//		preferencias.setDescricao("Lorem ipsum dolor sit amet, consectetuer adipiscing elit.");
//
//		 PessoaDAO pessoaDAO = new PessoaDAO();
//		 
//		 Pessoa pessoa = pessoaDAO.findbyId(2);
//		 preferencias.setPessoa(pessoa);
//		  
//		 PreferenciaDAO pDAO = new PreferenciaDAO();
//		  
//		  pDAO.add(preferencias);
		
		// buscar pessoa pelo id
		
//		Preferencias preferencias = new Preferencias();
//		
//		PreferenciaDAO preferenciaDAO = new PreferenciaDAO();
//		
//		preferencias = preferenciaDAO.findbyIdPreferencia(1);
//		
//				System.out.println("Id: " + preferencias.getIdPreferencias());
//				System.out.println("Descrição: " + preferencias.getDescricao());
//				System.out.println("Destinatário: " + preferencias.getPessoa().getNome());

		// update descricao preferencias

//				PreferenciaDAO preferenciaDAO = new PreferenciaDAO();
//				Preferencias preferencias = preferenciaDAO.findbyIdPreferencia(1);
//				
//				preferencias.setDescricao("2 - Lorem ipsum dolor sit amet, consectetuer adipiscing elit.");
//				
//				preferenciaDAO.updateDescriptionById(preferencias);
		
		// buscar todos
		
//		PreferenciaDAO preferenciaDAO = new PreferenciaDAO();
//		List<Preferencias> listaPreferencias = preferenciaDAO.findByAll();
//				  
//				  System.out.println(" \n                     Preferencia das Pessoas:");
//				  System.out.println("----------------------------------------------->");
//				  listaPreferencias.forEach(p -> { System.out.println("Código: "+p.getIdPreferencias());
//				  System.out.println("Nome da Pessoa: "+p.getPessoa().getNome());
//				  System.out.println("Descrição: "+ p.getDescricao());
//				  System.out.println("------------------------------------------->"); });
		
		// apagar preferencia
		
//		PreferenciaDAO preferenciaDAO = new PreferenciaDAO();
//		Preferencias preferencias = preferenciaDAO.findbyIdPreferencia(1);
//
//		preferenciaDAO.deleteById(preferencias);
		
		// Amizade
		
		// adicionar
		
//		Amizade amizade = new Amizade();
//
//		 PessoaDAO pessoaDAO = new PessoaDAO();
//		 
//		 Pessoa pessoa = pessoaDAO.findbyId(2);
//		 amizade.setIdPessoa(pessoa);
//		 
//		 Pessoa pessoa2 = pessoaDAO.findbyId(5);
//		 amizade.setIdAmizade(pessoa2);
//		  
//		 AmizadeDAO aDAO = new AmizadeDAO();
//		  
//		  aDAO.add(amizade);
		
		// buscar por id
		
//		Amizade amizade = new Amizade();
//		
//		AmizadeDAO amizadeDAO = new AmizadeDAO();
//		
//		amizade = amizadeDAO.findbyIdAmizade(2);
//		
//				System.out.println("Id: " + amizade.getId());
//				System.out.println("Nome: " + amizade.getIdPessoa().getNome());
//				System.out.println("Amigo: " + amizade.getIdAmizade().getNome());
		
		// buscar todos as amizades
		
//		AmizadeDAO amizadeDAO = new AmizadeDAO();
//		List<Amizade> listaAmizade = amizadeDAO.findAll();
//				  
//				  System.out.println(" \n                     Lista de Amizades:");
//				  System.out.println("----------------------------------------------->");
//				  listaAmizade.forEach(p -> { System.out.println("Código: "+p.getId());
//				  System.out.println("Nome: "+p.getIdPessoa().getNome());
//				  System.out.println("Nome: "+p.getIdAmizade().getNome());
//				  System.out.println("------------------------------------------->"); });
		
		// remover amizade
		
//		AmizadeDAO amizadeDAO = new AmizadeDAO();
//		Amizade amizade = amizadeDAO.findbyIdAmizade(1);
//
//		amizadeDAO.deleteById(amizade);
		
	}
	}
