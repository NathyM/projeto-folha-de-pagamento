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


/**
 *
 * @author Natalie Macedo
 */
@Entity
@Table(name = "folhapagamento")

@NamedQueries({
    @NamedQuery(name = "Folhapagamento.findAll", query = "SELECT f FROM Folhapagamento f"),
    @NamedQuery(name = "Folhapagamento.findById", query = "SELECT f FROM Folhapagamento f WHERE f.id = :id"),
    @NamedQuery(name = "Folhapagamento.findByNomeFuncionario", query = "SELECT f FROM Folhapagamento f WHERE f.nomeFuncionario = :nomeFuncionario"),
    @NamedQuery(name = "Folhapagamento.findBySalarioBruto", query = "SELECT f FROM Folhapagamento f WHERE f.salarioBruto = :salarioBruto"),
    @NamedQuery(name = "Folhapagamento.findByInss", query = "SELECT f FROM Folhapagamento f WHERE f.inss = :inss"),
    @NamedQuery(name = "Folhapagamento.findByIrrf", query = "SELECT f FROM Folhapagamento f WHERE f.irrf = :irrf"),
    @NamedQuery(name = "Folhapagamento.findBySalarioLiquido", query = "SELECT f FROM Folhapagamento f WHERE f.salarioLiquido = :salarioLiquido")})
public class Folhapagamento implements Serializable {

    @Basic(optional = false)
    @Lob()
    @Column(name = "nomeFuncionario")
    private String nomeFuncionario;
    @Basic(optional = false)
    @Column(name = "inss")
    private double inss;
    @Basic(optional = false)
    @Column(name = "irrf")
    private double irrf;
    @Basic(optional = false)
    @Column(name = "salarioLiquido")
    private double salarioLiquido;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "salarioBruto")
    private double salarioBruto;

    public Folhapagamento() {
    }

    public Folhapagamento(Integer id) {
        this.id = id;
    }

    public Folhapagamento(Integer id, String nomeFuncionario, double salarioBruto) {
        this.id = id;
        this.nomeFuncionario = nomeFuncionario;
        this.salarioBruto = salarioBruto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Folhapagamento)) {
            return false;
        }
        Folhapagamento other = (Folhapagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infra.Folhapagamento[ id=" + id + " ]";
    }


    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getIrrf() {
        return irrf;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    
}
