package app;

import domain.FolhaPagamentoBR;
import infra.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Natalie Macedo
 */
@ManagedBean
@RequestScoped
public class FolhaPagamentoBean {

    private double salarioLiquido, inss, salarioBruto, irrf;
    private FolhaPagamentoBR fprn;
    private FuncionarioBean f = new FuncionarioBean();
    public FolhaPagamentoBean() {
    }
    public void CalcularFolhaPagamento(Funcionario f){
         fprn = new FolhaPagamentoBR(this.salarioBruto);
         fprn.calcularInss();
         fprn.calcularIrrf();
         fprn.calcularSalarioLiquido();
         setInss(fprn.getInss());
         setIrrf(fprn.getIrrf());
         setSalarioLiquido(fprn.getSalarioLiquido());
    }
      public FuncionarioBean getFuncionario() {
        return f;
    }
    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public double getInss() {
        return inss;
    }

    public void setInss(double inss) {
        this.inss = inss;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(double salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public double getIrrf() {
        return irrf;
    }

    public void setIrrf(double irrf) {
        this.irrf = irrf;
    }
    public String exibirFolhaDoFuncionario(Funcionario f) {
        this.f.setFuncionario(f);
        this.salarioBruto = f.getSalario();
         return "FolhaPagamento";
  }
    

    
    
    
}
