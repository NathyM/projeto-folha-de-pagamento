/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Natalie Macedo
 */
public class TesteJPA {
    public static void main (String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Poo");
        EntityManager em = emf.createEntityManager();
        Funcionario funcionarios = new Funcionario();
        funcionarios.setId(1);
        funcionarios.setNome("Fábio");
        funcionarios.setRg("555");
        funcionarios.setCpf("555.555.555-55");
        funcionarios.setCargo("Professor");
        funcionarios.setSalario(2.000);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(funcionarios);
        et.commit();
        em.close();
        emf.close();
        
        
        
    }
    
    
}
