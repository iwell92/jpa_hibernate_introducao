package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		/*TESTE 1 Insert====
		Pessoa p1 = new Pessoa(null, "Wellington Prestes", "wp@email.com");
		Pessoa p2 = new Pessoa(null, "Joselito Silva", "joselito@email.com");
		Pessoa p3 = new Pessoa(null, "Hermes Renato", "hermes@email.com");
		==== TESTE 1 Insert*/
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager(); //Conexão com banco de dados
		
		Pessoa p = em.find(Pessoa.class, 6); //Para remover
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		/*TESTE 2 Find====
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		====TESTE 2 FIND*/
		
		/*TESTE 1 Insert====
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		==== TESTE 1 Insert*/
		
		System.out.println("Pronto!");
		em.close();
		emf.close();
	}

}
