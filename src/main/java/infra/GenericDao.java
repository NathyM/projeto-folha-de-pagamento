/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;
import javax.persistence.EntityManager;
/**
 *
 * @author Natalie Macedo
 */
 public class GenericDao <Funcionario extends EntityBase> {
        JPAUtils jUtil = new JPAUtils();
        public Funcionario salvar(Funcionario t) {
            EntityManager emf = jUtil.getEntityManager();
            try {
                    emf.getTransaction().begin();
                    if (t.getId() == null) {
                    emf.persist(t);
                    }
                    emf.getTransaction().commit();
                    } catch (Exception e) {
                    } finally {
                    emf.close();
                    }
                    return t;
                    }
        public Funcionario atualizar (Funcionario  t) {
                EntityManager emf = jUtil.getEntityManager();
                try {
                        emf.getTransaction().begin();
                        if (t.getId() == null) {
                        t = emf.merge(t);
                        }
                        emf.getTransaction().commit();
                        } catch (Exception e) {
                        } finally {
                       emf.close();
                       }
                       return t;
                     }
         public FuncionarioDao listar(FuncionarioDao t) {
                return t;
                }
        public Funcionario buscar(Integer id, Class<Funcionario> tclass) {
                EntityManager emf = jUtil.getEntityManager();
                Funcionario t = null;
                try {
                        t = emf.find(tclass, id);
                        } finally {
                        emf.close();
                        }
                        return t;
                }
        public void remover(Integer id, Class<Funcionario> tclass) {
                EntityManager emf = jUtil.getEntityManager();
                Funcionario t = emf.find(tclass, id);
                try {
                         emf.getTransaction().begin();
                         emf.remove(t);
                         emf.getTransaction().commit();
                        } finally {
                        emf.close();
                }
        }
 }
