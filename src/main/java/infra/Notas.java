/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Natalie Macedo
 */
@Entity
@Table(name = "notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notas.findAll", query = "SELECT n FROM Notas n"),
    @NamedQuery(name = "Notas.findByIdAluno", query = "SELECT n FROM Notas n WHERE n.idAluno = :idAluno"),
    @NamedQuery(name = "Notas.findByNota1", query = "SELECT n FROM Notas n WHERE n.nota1 = :nota1"),
    @NamedQuery(name = "Notas.findByNota2", query = "SELECT n FROM Notas n WHERE n.nota2 = :nota2"),
    @NamedQuery(name = "Notas.findByNota3", query = "SELECT n FROM Notas n WHERE n.nota3 = :nota3"),
    @NamedQuery(name = "Notas.findByNota4", query = "SELECT n FROM Notas n WHERE n.nota4 = :nota4"),
    @NamedQuery(name = "Notas.findByNotaFinal", query = "SELECT n FROM Notas n WHERE n.notaFinal = :notaFinal")})
public class Notas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAluno")
    private Integer idAluno;
    @Basic(optional = false)
    @Column(name = "nota1")
    private double nota1;
    @Basic(optional = false)
    @Column(name = "nota2")
    private double nota2;
    @Basic(optional = false)
    @Column(name = "nota3")
    private double nota3;
    @Basic(optional = false)
    @Column(name = "nota4")
    private double nota4;
    @Basic(optional = false)
    @Column(name = "notaFinal")
    private double notaFinal;

    public Notas() {
    }

    public Notas(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Notas(Integer idAluno, double nota1, double nota2, double nota3, double nota4, double notaFinal) {
        this.idAluno = idAluno;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.notaFinal = notaFinal;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

  @Override
  public int hashCode() {
    int result = 0;
    long temp;
    result = 31 * result + (idAluno != null ? idAluno.hashCode() : 0);
    temp = Double.doubleToLongBits(nota1);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(nota2);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(nota3);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(nota4);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(notaFinal);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    
    return result;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Notas that = (Notas) o;
    
    if (idAluno != null ? !idAluno.equals(that.idAluno) : that.idAluno != null) return false;
    if (Double.compare(that.nota1, nota1) != 0) return false;
    if (Double.compare(that.nota2, nota2) != 0) return false;
    if (Double.compare(that.nota3, nota3) != 0) return false;
    if (Double.compare(that.nota4, nota4) != 0) return false;
    if (Double.compare(that.notaFinal, notaFinal) != 0) return false;
        return true;
    }

    @Override
    public String toString() {
        return "infra.Notas[ idAluno=" + idAluno + " ]";
    }
    
}
