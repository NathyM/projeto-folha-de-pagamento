/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.Funcionario;
import infra.JPAUtils;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;




/**
 *
 * @author Natalie Macedo
 */
@ManagedBean
@RequestScoped
public class FuncionarioBean {

   
  private Funcionario f = new Funcionario();
  private List<Funcionario> funcionarios = new ArrayList<>();
  private String buscaPorNome;
  private String buscaPorId;

    public String getBuscaPorNome() {
        return buscaPorNome;
    }

    public void setBuscaPorNome(String buscaPorNome) {
        this.buscaPorNome = buscaPorNome;
    }

    public String getBuscaPorId() {
        return buscaPorId;
    }

    public void setBuscaPorId(String buscaPorId) {
        this.buscaPorId = buscaPorId;
    }

  public String atulizarFuncionario() {
    EntityManager em = JPAUtils.getEntityManager();
    EntityTransaction et = em.getTransaction();
    et.begin();
    em.merge(f);
    et.commit();
    em.close();
    return "CadFuncionario";
  }
    public void excluir(Funcionario f) {
    EntityManager em = JPAUtils.getEntityManager();
    EntityTransaction et = em.getTransaction();
    et.begin();
    f = em.merge(f);
    em.remove(f);
    et.commit();
    em.close();
  }


  public String salvarFuncionario(){
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(f);
        et.commit();
        em.close();
        return "CadFuncionario";
  }

  public List<Funcionario> getFuncionarios() {
        EntityManager em = JPAUtils.getEntityManager();
        Query q = em.createQuery("select  f from Funcionario f", Funcionario.class);
        List<Funcionario> us = q.getResultList();
        em.close();
        return us;
  }

  public void setFuncionarios (List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
  }

  public Funcionario getFuncionario() {
     return f;
  }

  public void setFuncionario(Funcionario f) {
        this.f = f;
  }
    public void consultarPorNome(String nome) {
    EntityManager em = JPAUtils.getEntityManager();
    Query query = em.createQuery("select f from Funcionario f where f.nome= :nome", Funcionario.class);
    query.setParameter("nome", nome);
    List<Funcionario> funcionarios = query.getResultList();
    em.close();
    this.funcionarios = funcionarios;
   
  }

  public void consultarPorId(String id) {
    EntityManager em = JPAUtils.getEntityManager();
    Query query = em.createQuery("select f from Funcionario f where f.id=:id", Funcionario.class);
    query.setParameter("id", Integer.parseInt(id));
    List<Funcionario> funcionarios = query.getResultList();
    em.close();
    this.funcionarios = funcionarios;
    
  }
    
    
}
