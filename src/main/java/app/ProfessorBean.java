/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import infra.JPAUtils;
import infra.Professor;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Natalie Macedo
 */
@ManagedBean
@RequestScoped
public class ProfessorBean extends FuncionarioBean{
  private Professor professor = new Professor();
  private List<Professor> professores = new ArrayList<>();
  private String buscaNome;
  private String buscaId;
  private String buscaAreaInteresse;
  private String buscaDisciplinas;

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public String getBuscaNome() {
        return buscaNome;
    }

    public void setBuscaNome(String buscaNome) {
        this.buscaNome = buscaNome;
    }

    public String getBuscaId() {
        return buscaId;
    }

    public void setBuscaId(String buscaId) {
        this.buscaId = buscaId;
    }

    public String getBuscaAreaInteresse() {
        return buscaAreaInteresse;
    }

    public void setBuscaAreaInteresse(String buscaAreaInteresse) {
        this.buscaAreaInteresse = buscaAreaInteresse;
    }

    public String getBuscaDisciplinas() {
        return buscaDisciplinas;
    }

    public void setBuscaDisciplinas(String buscaDisciplinas) {
        this.buscaDisciplinas = buscaDisciplinas;
    }
  @Override
    public void consultarPorNome(String nome) {
        EntityManager em = JPAUtils.getEntityManager();
        Query query = em.createQuery("select p from Professor p where p.nome like :nome", Professor.class);
        query.setParameter("nome", nome);
        List<Professor> professores = query.getResultList();
        em.close();
        this.professores = professores;

      }

  @Override
  public void consultarPorId(String id) {
        EntityManager em = JPAUtils.getEntityManager();
        Query query = em.createQuery("select p from Professor p where p.id=:id", Professor.class);
        query.setParameter("id", Integer.parseInt(id));
        List<Professor> professores = query.getResultList();
        em.close();
        this.professores= professores;
    
      }

  public void consultarPorAreaInteresse(String area) {
        EntityManager em = JPAUtils.getEntityManager();
        Query query = em.createQuery("select p from Professor p where p.areaInteresse like :areaInteresse", Professor.class);
        query.setParameter("area", area);
        List<Professor> professores = query.getResultList();
        em.close();
        this.professores = professores;
        
      }

  public void consultarPorDisciplinas(String disciplinas) {
        EntityManager em = JPAUtils.getEntityManager();
        Query query = em.createQuery("select p from Professor p where p.disciplinas like :disciplinas", Professor.class);
        query.setParameter("disciplinas", disciplinas);
        List<Professor> professores = query.getResultList();
        em.close();
        this.professores = professores;
        
      }


  public String cadastrarProfessor() {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(professor);
        et.commit();
        em.close();

        return "CadProfessor";
      }

  public void atualizar(Professor professor) {
    this.professor = professor;
  }

  public String excluirProfessor(Professor professor) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        professor = em.merge(professor);
        em.remove(professor);
        et.commit();
        em.close();
      
        return "CadProfessor";
      }

    
}
