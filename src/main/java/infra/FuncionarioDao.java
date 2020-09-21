/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;
import java.util.List;
import javax.persistence.EntityManager;
import infra.Funcionario;
import javax.persistence.Query;

/**
 *
 * @author Natalie Macedo
 */
public class FuncionarioDao  extends GenericDao{
    public List<Funcionario> listaCompleta() {
        List<Funcionario> funcionarios = null;
        EntityManager emf = jUtil.getEntityManager();
        Query queryFcr = emf.createQuery("select u from funcionarios u", Funcionario.class);
        funcionarios = queryFcr.getResultList();
        return funcionarios;
    }

    public void atualizar(Funcionario funcionario, Class<Funcionario> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    }


    
    

