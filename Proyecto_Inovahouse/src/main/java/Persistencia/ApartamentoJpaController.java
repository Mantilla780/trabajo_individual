/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Apartamento;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author USER
 */
public class ApartamentoJpaController implements Serializable {

    public ApartamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public ApartamentoJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Apartamento apartamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(apartamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findApartamento(apartamento.getMatricula()) != null) {
                throw new PreexistingEntityException("Apartamento " + apartamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Apartamento apartamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            apartamento = em.merge(apartamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = apartamento.getMatricula();
                if (findApartamento(id) == null) {
                    throw new NonexistentEntityException("The apartamento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Apartamento apartamento;
            try {
                apartamento = em.getReference(Apartamento.class, id);
                apartamento.getMatricula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The apartamento with id " + id + " no longer exists.", enfe);
            }
            em.remove(apartamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Apartamento> findApartamentoEntities() {
        return findApartamentoEntities(true, -1, -1);
    }

    public List<Apartamento> findApartamentoEntities(int maxResults, int firstResult) {
        return findApartamentoEntities(false, maxResults, firstResult);
    }

    private List<Apartamento> findApartamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Apartamento.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Apartamento findApartamento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Apartamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getApartamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Apartamento> rt = cq.from(Apartamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
