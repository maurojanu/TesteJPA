/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testejpa;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author aluno
 */
public class TesteJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // gerenciador de entidades 
        EntityManager manager;
        
        // criador de gerenciador de entidades 
        
        EntityManagerFactory factory;
        factory = Persistence.createEntityManagerFactory("TesteJPAPU");
        manager = factory.createEntityManager();
        
        EntityTransaction transacao = manager.getTransaction();
        
        try{
            
            transacao.begin();
            
            Pessoa p = new Pessoa();
            
            p.setNome("Mauro");
            
            p.setDataNascimento(new Date());
            
            manager.persist(p);
            
            transacao.commit();
            
        }catch(Exception ex){
            
            transacao.rollback();
            
        }
    }
}
