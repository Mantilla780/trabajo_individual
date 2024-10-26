/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Torre;
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
public class TorreJpaController implements Serializable {

    public TorreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public TorreJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Torre torre) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(torre);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTorre(torre.getNumeroTorre()) != null) {
                throw new PreexistingEntityException("Torre " + torre + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Torre torre) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            torre = em.merge(torre);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = torre.getNumeroTorre();
                if (findTorre(id) == null) {
                    throw new NonexistentEntityException("The torre with id " + id + " no longer exists.");
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
            Torre torre;
            try {
                torre = em.getReference(Torre.class, id);
                torre.getNumeroTorre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The torre with id " + id + " no longer exists.", enfe);
            }
            em.remove(torre);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Torre> findTorreEntities() {
        return findTorreEntities(true, -1, -1);
    }

    public List<Torre> findTorreEntities(int maxResults, int firstResult) {
        return findTorreEntities(false, maxResults, firstResult);
    }

    private List<Torre> findTorreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Torre.class));
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

    public Torre findTorre(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Torre.class, id);
        } finally {
            em.close();
        }
    }

    public int getTorreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Torre> rt = cq.from(Torre.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
