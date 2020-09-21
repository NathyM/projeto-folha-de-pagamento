/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.Aluno;
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
public class AlunoBean {
    
  private Aluno aluno = new Aluno();
  private List<Aluno> alunos = new ArrayList<>();
  private String buscaNome;
  private String buscaCpf;
  private String buscaData;
  private String buscaStatus;



  public Aluno getAluno() {
    return aluno;
  }

  public void setAluno(Aluno aluno) {
    this.aluno = aluno;
  }

  public List<Aluno> getAlunos() {
    return alunos;
  }

  public void setAlunos(List<Aluno> alunos) {
    this.alunos = alunos;
  }

  public String getBuscaNome() {
    return buscaNome;
  }

  public void setBuscaNome(String buscaNome) {
    this.buscaNome = buscaNome;
  }

  public String getBuscaCpf() {
    return buscaCpf;
  }

  public void setBuscaCpf(String buscaCpf) {
    this.buscaCpf = buscaCpf;
  }

  public String getBuscaData() {
    return buscaData;
  }

  public void setBuscaData(String buscaData) {
    this.buscaData = buscaData;
  }

  public String getBuscaStatus() {
    return buscaStatus;
  }

  public void setBuscaStatus(String buscaStatus) {
    this.buscaStatus = buscaStatus;
  }

  public void consultarPorNome(String nome) {
    EntityManager em = JPAUtils.getEntityManager();
    Query query = em.createQuery("select a from Aluno a where a.nome like :nome", Aluno.class);
    query.setParameter("nome", nome);
    List<Aluno> alunos = query.getResultList();
    em.close();
    this.alunos = alunos;
    
  }

  public void consultarPorCpf(String cpf) {
    EntityManager em = JPAUtils.getEntityManager();
    Query query = em.createQuery("select a from Aluno a where a.cpf like :cpf", Aluno.class);
    query.setParameter("cpf", cpf);
    List<Aluno> alunos = query.getResultList();
    em.close();
    this.alunos = alunos;
    
  }

  public void consultarPorDataNascimento(String dtNasc) {
    EntityManager em = JPAUtils.getEntityManager();
    Query query = em.createQuery("select a from Aluno a where a.dataNascimento like :dataNascimento", Aluno.class);
    query.setParameter("data", dtNasc);
    List<Aluno> alunos = query.getResultList();
    em.close();
    this.alunos = alunos;
 
  }

  public void consultarPorStatus(String status) {
    EntityManager em = JPAUtils.getEntityManager();
    Query query = em.createQuery("select a from Aluno a where a.status like :status", Aluno.class);
    query.setParameter("status", status);
    List<Aluno> alunos = query.getResultList();
    em.close();

  }

  public String cadastrarAluno() {
    EntityManager em = JPAUtils.getEntityManager();
    EntityTransaction et = em.getTransaction();
    et.begin();
    em.merge(aluno);
    et.commit();
    em.close();

    return "CadAluno";
  }

  public void atualizar(Aluno aluno) {
    this.aluno = aluno;
  }

  public String remover(Aluno aluno) {
    EntityManager em = JPAUtils.getEntityManager();
    EntityTransaction et = em.getTransaction();
    et.begin();
    aluno = em.merge(aluno);
    em.remove(aluno);
    et.commit();
    em.close();
    return "CadAluno";
  }
    
}
