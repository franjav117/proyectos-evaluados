package com.esquelas.dao;


import com.esquelas.entities.Rol;
import com.esquelas.entities.TipoPlaca;
import com.esquelas.entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("esquelasPU");
    private EntityManager em = emf.createEntityManager();

    private List<Usuario> listUsuario;
    private List<Rol> listRol;
    private Usuario usuario;
    private List<TipoPlaca> listPlaca;

    public Usuario insertUsuario(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return usuario;
    }

    public List<Usuario> consultUsuario() {
        try {
            listUsuario = new ArrayList<>();
            listUsuario = em.createNamedQuery("Usuario.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listUsuario;
    }

    public List<Usuario> consultUsuarioByUsuario(Usuario usuario) {
        try {
            listUsuario = new ArrayList<>();
            listUsuario = em.createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario.getUsuario()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listUsuario;
    }

    public List<Rol> consultRol() {
        try {
            listRol = new ArrayList<>();
            listRol = em.createNamedQuery("Rol.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listRol;
    }

    public Usuario updateUsuario(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.merge(usuario);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return usuario;
    }

    public void deleteUsuario(Usuario usuario) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Usuario.class, usuario.getIdUsuario()));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    //--------------select usuario con namedQuery----------//
    public Usuario selectUsuario(Usuario user) {
        try {
            usuario = new Usuario();
            usuario = (Usuario) em.createNamedQuery("Usuario.findByIdUsuario").setParameter("idUsuario", user.getIdUsuario()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return usuario;
    }

    //---------------select usuario with jpa------------------//
    public Usuario findUsuario(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    //--------------select * from with criteria------------------//
    public List<Usuario> finAllUsuario() {
        try {
            listUsuario = new ArrayList<>();
            javax.persistence.criteria.CriteriaQuery query = em.getCriteriaBuilder().createQuery();
            query.select(query.from(Usuario.class));
            listUsuario = em.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listUsuario;
    }
}
