package br.com.casadocodigo.loja.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.casadocodigo.loja.models.Usuario;

public class TestQueryMySql {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("casadocodigo");
	    EntityManager em = emf.createEntityManager();
	    
	    List<Usuario> usuarios = em.createQuery("select u from Usuario u", Usuario.class)
	    		.getResultList();
	    
	    System.out.println(usuarios);
	    
		
	}

    
    

}
