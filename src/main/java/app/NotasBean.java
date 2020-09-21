/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import infra.Aluno;
import infra.JPAUtils;
import infra.Notas;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Natalie Macedo
 */
@ManagedBean
@RequestScoped
public class NotasBean {
    private Notas nota = new Notas();
    private Aluno aluno = new Aluno();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Notas> listaNotas= new ArrayList();

    public Notas getNota() {
        return nota;
    }

    public void setNota(Notas nota) {
        this.nota = nota;
    }

    public List<Notas> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Notas> listaNotas) {
        this.listaNotas = listaNotas;
    }
    
    public void calcularNotaFinal() {
        double notaFinal = (nota.getNota1() + nota.getNota2() + nota.getNota3() + nota.getNota4()) / 4;
        aluno.setNotaFinal(notaFinal);
      }

    public void alunoStatus() {
        if (aluno.getNotaFinal() >= 6) {
            aluno.setStatus("Aprovado");
         } else if (aluno.getNotaFinal() >= 4) {
            aluno.setStatus("Prova Final");
         } else {
            aluno.setStatus("Reprovado");
         }
     }

      public String inserirNota() {
        calcularNotaFinal();
        alunoStatus();
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(aluno);
        et.commit();
        em.close();
        return "Notas";
      }

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
   public String editarNota(Aluno aluno) {
        this.aluno = aluno;
        return "Notas";
        }

}
