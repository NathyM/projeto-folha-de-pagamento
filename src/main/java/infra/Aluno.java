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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author franklin
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByIdAluno", query = "SELECT a FROM Aluno a WHERE a.idAluno = :idAluno"),
    @NamedQuery(name = "Aluno.findByNotaFinal", query = "SELECT a FROM Aluno a WHERE a.notaFinal = :notaFinal")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAluno")
    private Integer idAluno;
    @Basic(optional = false)
    @Lob
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Lob
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Lob
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Lob
    @Column(name = "dataNascimento")
    private String dataNascimento;
    @Basic(optional = false)
    @Column(name = "notaFinal")
    private double notaFinal;
    @Basic(optional = false)
    @Lob
    @Column(name = "status")
    private String status;

    public Aluno() {
    }

    public Aluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Aluno(Integer idAluno, String nome, String cpf, String rg, String sexo, String dataNascimento, double notaFinal, String status) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.notaFinal = notaFinal;
        this.status = status;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

@Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Aluno that = (Aluno) o;

    if (Double.compare(that.notaFinal, notaFinal) != 0) return false;
    if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
    if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
    if (rg != null ? !rg.equals(that.rg) : that.rg != null) return false;
    if (dataNascimento != null ? !dataNascimento.equals(that.dataNascimento) : that.dataNascimento != null)
      return false;
    if (sexo != null ? !sexo.equals(that.sexo) : that.sexo != null) return false;
    if (status != null ? !status.equals(that.status) : that.status != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = cpf != null ? cpf.hashCode() : 0;
    result = 31 * result + (nome != null ? nome.hashCode() : 0);
    result = 31 * result + (rg != null ? rg.hashCode() : 0);
    result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
    result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
    temp = Double.doubleToLongBits(notaFinal);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (status != null ? status.hashCode() : 0);
    return result;
  }

    @Override
    public String toString() {
        return "infra.Aluno[ idAluno=" + idAluno + " ]";
    }
    
}
