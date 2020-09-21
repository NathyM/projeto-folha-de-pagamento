/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import infra.FuncionarioDao;
import infra.Funcionario;
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
public class FuncionarioBR {
    private Funcionario funcionario = new Funcionario();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Poo");
    EntityManager em = emf.createEntityManager();       
    FuncionarioDao fundao = new FuncionarioDao();
    List<Funcionario> funcionarios;
    

     public void  salvar(Integer id, String nome, String rg, String cpf, String cargo, Double salario){
        funcionario.setId(id);
        funcionario.setNome(nome);
        funcionario.setRg(rg);
        funcionario.setCpf(cpf);
        funcionario.setCargo(cargo);
        funcionario.setSalario(salario);
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(funcionario);
        et.commit();
        em.close();
        emf.close();
      
    }
      
    public void listar(){
        Query q = em.createQuery("select u from Funcionario u", Funcionario.class);
        List<Funcionario> funcionarios = q.getResultList();
        System.out.println(funcionarios);
     }
    
    public void pesquisarID (Integer id, List<Funcionario> lista){
      fundao.buscar(id, Funcionario.class);
    }
    public void pesquisarNome (String nome, List<Funcionario> lista){
        for(Funcionario funcionario: funcionarios){
            System.out.println(funcionario.getNome());
        }
    }
    public void atualizar(List<Funcionario> lista){
        fundao.atualizar(funcionario, Funcionario.class);
        
       
    }
    public void remover(Integer id, List<Funcionario> lista){
        fundao.remover(id, Funcionario.class);
    }
     
        
 }
    

