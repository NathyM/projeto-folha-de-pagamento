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
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findById", query = "SELECT p FROM Professor p WHERE p.id = :id")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Lob
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Lob
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Lob
    @Column(name = "cargo")
    private String cargo;
    @Basic(optional = false)
    @Lob
    @Column(name = "disciplinas")
    private String disciplinas;
    @Basic(optional = false)
    @Lob
    @Column(name = "areaInteresse")
    private String areaInteresse;
    @Basic(optional = false)
    @Lob
    @Column(name = "salario")
    private Double salario;

    public Professor() {
    }

    public Professor(Integer id) {
        this.id = id;
    }

    public Professor(Integer id, Double salario,String nome, String rg, String cpf, String cargo, String disciplinas, String areaInteresse) {
        this.id = id;
        this.salario=salario;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cargo = cargo;
        this.disciplinas = disciplinas;
        this.areaInteresse = areaInteresse;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getAreaInteresse() {
        return areaInteresse;
    }

    public void setAreaInteresse(String areaInteresse) {
        this.areaInteresse = areaInteresse;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Professor that = (Professor) o;

    if (id != that.id) return false;
    if (Double.compare(that.salario, salario) != 0) return false;
    if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
    if (rg != null ? !rg.equals(that.rg) : that.rg != null) return false;
    if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
    if (cargo != null ? !cargo.equals(that.cargo) : that.cargo != null) return false;
    if (disciplinas != null ? !disciplinas.equals(that.disciplinas) : that.disciplinas != null) return false;
    if (areaInteresse != null ? !areaInteresse.equals(that.areaInteresse) : that.areaInteresse != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result;
    long temp;
    result = id;
    result = 31 * result + (nome != null ? nome.hashCode() : 0);
    temp = Double.doubleToLongBits(salario);
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (rg != null ? rg.hashCode() : 0);
    result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
    result = 31 * result + (cargo != null ? cargo.hashCode() : 0);
    result = 31 * result + (disciplinas != null ? disciplinas.hashCode() : 0);
    result = 31 * result + (areaInteresse != null ? areaInteresse.hashCode() : 0);
    return result;
  }

    @Override
    public String toString() {
        return "infra.Professor[ id=" + id + " ]";
    }
    
}
