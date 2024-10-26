package Persistencia;

import Modelo.ProyectoVivienda;
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

public class ProyectoViviendaJpaController implements Serializable {

    public ProyectoViviendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManagerFactory emf = null;

    public ProyectoViviendaJpaController() {
        emf = Persistence.createEntityManagerFactory("persistence");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProyectoVivienda proyectoVivienda) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(proyectoVivienda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProyectoVivienda(proyectoVivienda.getIdProyecto()) != null) {
                throw new PreexistingEntityException("ProyectoVivienda " + proyectoVivienda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProyectoVivienda proyectoVivienda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            proyectoVivienda = em.merge(proyectoVivienda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proyectoVivienda.getIdProyecto(); // Cambiado a int
                if (findProyectoVivienda(id) == null) {
                    throw new NonexistentEntityException("The proyectoVivienda with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException { // Cambiado a int
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProyectoVivienda proyectoVivienda;
            try {
                proyectoVivienda = em.getReference(ProyectoVivienda.class, id);
                proyectoVivienda.getIdProyecto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proyectoVivienda with id " + id + " no longer exists.", enfe);
            }
            em.remove(proyectoVivienda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProyectoVivienda> findProyectoViviendaEntities() {
        return findProyectoViviendaEntities(true, -1, -1);
    }

    public List<ProyectoVivienda> findProyectoViviendaEntities(int maxResults, int firstResult) {
        return findProyectoViviendaEntities(false, maxResults, firstResult);
    }

    private List<ProyectoVivienda> findProyectoViviendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProyectoVivienda.class));
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

    public ProyectoVivienda findProyectoVivienda(int id) { // Cambiado a int
        EntityManager em = getEntityManager();
        try {
            return em.find(ProyectoVivienda.class, id);
        } finally {
            em.close();
        }
    }

    public int getProyectoViviendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProyectoVivienda> rt = cq.from(ProyectoVivienda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}