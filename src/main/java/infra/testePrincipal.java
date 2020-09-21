/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Natalie Macedo
 */
public class testePrincipal {
    public static void main(String[] args) {
     Funcionario testefinal = new Funcionario();
        // Consulta em JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Poo");
        EntityManager em = emf.createEntityManager();       
        
        Query q = em.createQuery("select u from Funcionario u", Funcionario.class);
        List<Funcionario> funcionarios = q.getResultList();
        
        for(Funcionario funcionario: funcionarios){
            System.out.println(funcionario.getId());
            System.out.println(funcionario.getCargo());
            testefinal= funcionario;
        }
        //removendo objeto do banco de dados
        /*
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(testefinal);
        et.commit();*/
        //atualizando objeto no banco de dados
        testefinal.setNome("Roberto");
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(testefinal);
        et.commit();
        em.close();
        emf.close();
    }
}
