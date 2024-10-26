/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Modelo.Usuario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Venta;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USER
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public UsuarioJpaController(){
        emf = Persistence.createEntityManagerFactory("persistence");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getListaVentas() == null) {
            usuario.setListaVentas(new ArrayList<Venta>());
        }
        if (usuario.getListaProyectos() == null) {
            usuario.setListaProyectos(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Venta> attachedListaVentas = new ArrayList<Venta>();
            for (Venta listaVentasVentaToAttach : usuario.getListaVentas()) {
                listaVentasVentaToAttach = em.getReference(listaVentasVentaToAttach.getClass(), listaVentasVentaToAttach.getIdVenta());
                attachedListaVentas.add(listaVentasVentaToAttach);
            }
            usuario.setListaVentas(attachedListaVentas);
            ArrayList<Venta> attachedListaProyectos = new ArrayList<Venta>();
            for (Venta listaProyectosVentaToAttach : usuario.getListaProyectos()) {
                listaProyectosVentaToAttach = em.getReference(listaProyectosVentaToAttach.getClass(), listaProyectosVentaToAttach.getIdVenta());
                attachedListaProyectos.add(listaProyectosVentaToAttach);
            }
            usuario.setListaProyectos(attachedListaProyectos);
            em.persist(usuario);
            for (Venta listaVentasVenta : usuario.getListaVentas()) {
                Usuario oldUsuarioOfListaVentasVenta = listaVentasVenta.getUsuario();
                listaVentasVenta.setUsuario(usuario);
                listaVentasVenta = em.merge(listaVentasVenta);
                if (oldUsuarioOfListaVentasVenta != null) {
                    oldUsuarioOfListaVentasVenta.getListaVentas().remove(listaVentasVenta);
                    oldUsuarioOfListaVentasVenta = em.merge(oldUsuarioOfListaVentasVenta);
                }
            }
            for (Venta listaProyectosVenta : usuario.getListaProyectos()) {
                Usuario oldUsuarioOfListaProyectosVenta = listaProyectosVenta.getUsuario();
                listaProyectosVenta.setUsuario(usuario);
                listaProyectosVenta = em.merge(listaProyectosVenta);
                if (oldUsuarioOfListaProyectosVenta != null) {
                    oldUsuarioOfListaProyectosVenta.getListaProyectos().remove(listaProyectosVenta);
                    oldUsuarioOfListaProyectosVenta = em.merge(oldUsuarioOfListaProyectosVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            ArrayList<Venta> listaVentasOld = persistentUsuario.getListaVentas();
            ArrayList<Venta> listaVentasNew = usuario.getListaVentas();
            ArrayList<Venta> listaProyectosOld = persistentUsuario.getListaProyectos();
            ArrayList<Venta> listaProyectosNew = usuario.getListaProyectos();
            ArrayList<Venta> attachedListaVentasNew = new ArrayList<Venta>();
            for (Venta listaVentasNewVentaToAttach : listaVentasNew) {
                listaVentasNewVentaToAttach = em.getReference(listaVentasNewVentaToAttach.getClass(), listaVentasNewVentaToAttach.getIdVenta());
                attachedListaVentasNew.add(listaVentasNewVentaToAttach);
            }
            listaVentasNew = attachedListaVentasNew;
            usuario.setListaVentas(listaVentasNew);
            ArrayList<Venta> attachedListaProyectosNew = new ArrayList<Venta>();
            for (Venta listaProyectosNewVentaToAttach : listaProyectosNew) {
                listaProyectosNewVentaToAttach = em.getReference(listaProyectosNewVentaToAttach.getClass(), listaProyectosNewVentaToAttach.getIdVenta());
                attachedListaProyectosNew.add(listaProyectosNewVentaToAttach);
            }
            listaProyectosNew = attachedListaProyectosNew;
            usuario.setListaProyectos(listaProyectosNew);
            usuario = em.merge(usuario);
            for (Venta listaVentasOldVenta : listaVentasOld) {
                if (!listaVentasNew.contains(listaVentasOldVenta)) {
                    listaVentasOldVenta.setUsuario(null);
                    listaVentasOldVenta = em.merge(listaVentasOldVenta);
                }
            }
            for (Venta listaVentasNewVenta : listaVentasNew) {
                if (!listaVentasOld.contains(listaVentasNewVenta)) {
                    Usuario oldUsuarioOfListaVentasNewVenta = listaVentasNewVenta.getUsuario();
                    listaVentasNewVenta.setUsuario(usuario);
                    listaVentasNewVenta = em.merge(listaVentasNewVenta);
                    if (oldUsuarioOfListaVentasNewVenta != null && !oldUsuarioOfListaVentasNewVenta.equals(usuario)) {
                        oldUsuarioOfListaVentasNewVenta.getListaVentas().remove(listaVentasNewVenta);
                        oldUsuarioOfListaVentasNewVenta = em.merge(oldUsuarioOfListaVentasNewVenta);
                    }
                }
            }
            for (Venta listaProyectosOldVenta : listaProyectosOld) {
                if (!listaProyectosNew.contains(listaProyectosOldVenta)) {
                    listaProyectosOldVenta.setUsuario(null);
                    listaProyectosOldVenta = em.merge(listaProyectosOldVenta);
                }
            }
            for (Venta listaProyectosNewVenta : listaProyectosNew) {
                if (!listaProyectosOld.contains(listaProyectosNewVenta)) {
                    Usuario oldUsuarioOfListaProyectosNewVenta = listaProyectosNewVenta.getUsuario();
                    listaProyectosNewVenta.setUsuario(usuario);
                    listaProyectosNewVenta = em.merge(listaProyectosNewVenta);
                    if (oldUsuarioOfListaProyectosNewVenta != null && !oldUsuarioOfListaProyectosNewVenta.equals(usuario)) {
                        oldUsuarioOfListaProyectosNewVenta.getListaProyectos().remove(listaProyectosNewVenta);
                        oldUsuarioOfListaProyectosNewVenta = em.merge(oldUsuarioOfListaProyectosNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuario.getIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Venta> listaVentas = usuario.getListaVentas();
            for (Venta listaVentasVenta : listaVentas) {
                listaVentasVenta.setUsuario(null);
                listaVentasVenta = em.merge(listaVentasVenta);
            }
            ArrayList<Venta> listaProyectos = usuario.getListaProyectos();
            for (Venta listaProyectosVenta : listaProyectos) {
                listaProyectosVenta.setUsuario(null);
                listaProyectosVenta = em.merge(listaProyectosVenta);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
