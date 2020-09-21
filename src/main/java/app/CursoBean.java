/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/**
 *
 * @author Natalie Macedo
 */
import infra.Curso;
import infra.JPAUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class CursoBean {
  private Curso curso = new Curso();
  private List<Curso> cursos = new ArrayList<>();
  private String buscaTitulo;
  private String buscaId;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getBuscaTitulo() {
        return buscaTitulo;
    }

    public void setBuscaTitulo(String buscaTitulo) {
        this.buscaTitulo = buscaTitulo;
    }

    public String getBuscaId() {
        return buscaId;
    }

    public void setBuscaId(String buscaId) {
        this.buscaId = buscaId;
    }
    public void consultarPorTitulo(String titulo) {
        EntityManager em = JPAUtils.getEntityManager();
        Query query = em.createQuery("select c from Curso c where c.titulo like :titulo", Curso.class);
        query.setParameter("titulo", titulo);
        List<Curso> cursos = query.getResultList();
        em.close();
        this.cursos = cursos;
      }

  public void consultarPorId(String id) {
        EntityManager em = JPAUtils.getEntityManager();
        Query query = em.createQuery("select c from Curso c where c.id=:id", Curso.class);
        query.setParameter("id", Integer.parseInt(id));
        List<Curso> cursos = query.getResultList();
        em.close();
        this.cursos = cursos;

      }

  public String cadastrarCurso() {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(curso);
        et.commit();
        em.close();

        return "CadCurso";
      }

  public void atualizar(Curso curso) {
    this.curso = curso;
  }

  public String remover(Curso curso) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        curso = em.merge(curso);
        em.remove(curso);
        et.commit();
        em.close();
        return "CadCurso";
      }
    
}
