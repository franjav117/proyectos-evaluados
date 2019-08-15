package com.esquelas.dao;

import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Cajero;
import com.esquelas.entities.ClaseLicencia;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Persona;
import com.esquelas.entities.TipoPlaca;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonaDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("esquelasPU");
    private EntityManager em = emf.createEntityManager();

    private List<Persona> listPersona;
    private List<Cajero> listCajero;
    private List<TipoPlaca> listPlaca;
    private List<ClaseLicencia> listClaseLicencias;
    private List<AgenteTransito> listAgente;
    private List<Conductor> listConductor;
    private List<Esquela> listEsquelas;
    private Persona persona;
    private Cajero cajero;
    private Conductor conductor;
    private AgenteTransito agente;

    //--------metodos de personas comunes------//
    public Persona insertPersona(Persona persona) {
        try {
            em.getTransaction().begin();
            em.persist(persona);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return persona;
    }

    public List<Persona> consultPersona() {
        try {
            listPersona = new ArrayList<>();
            listPersona = em.createNamedQuery("Persona.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return listPersona;
    }

    //--------------select * from with criteria------------//
    public List<Persona> findAllPersona() {
        try {
            listPersona = new ArrayList<>();
            javax.persistence.criteria.CriteriaQuery query = em.getCriteriaBuilder().createQuery();
            query.select(query.from(Persona.class));
            listPersona = em.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return listPersona;
    }

    public List<Persona> consultPersonaDui(Persona perso) {
        try {
            listPersona = new ArrayList<>();
            listPersona = em.createNamedQuery("Persona.findByDui").setParameter("dui", perso.getDui()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listPersona;
    }

    public void deletePersona(Persona persona) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Persona.class, persona.getIdPersona()));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Persona updatePersona(Persona per) {
        try {
            em.getTransaction().begin();
            em.merge(per);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return per;
    }

    public Persona selectPersona(Persona perso) {
        try {
            persona = (Persona) em.createNamedQuery("Persona.findByIdPersona").setParameter("idPersona", perso.getIdPersona()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return persona;
    }

    //--------------select with jpa---------------//
    public Persona findPersona(Persona perso) {
        try {
            persona = new Persona();
            persona = em.find(Persona.class, perso.getIdPersona());
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return persona;
    }

    //----------------daos de personas con funciones----------//
    public Cajero insertCajero(Cajero cajero) {
        try {
            em.getTransaction().begin();
            em.persist(cajero);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return cajero;
    }

    public Cajero updateCajero(Cajero cajero) {
        try {
            em.getTransaction().begin();
            em.merge(cajero);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return cajero;
    }

    public Cajero consultCajero(Cajero caj) {
        try {
            cajero = new Cajero();
            cajero = (Cajero) em.createNamedQuery("Cajero.findByIdCajero").setParameter("idCajero", caj.getIdCajero()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return cajero;
    }

    public void deleteCajero(Cajero caja) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Cajero.class, caja.getIdCajero()));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public List<Cajero> consultCajeros() {
        try {
            listCajero = new ArrayList<>();
            listCajero = em.createNamedQuery("Cajero.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listCajero;
    }

    public List<Cajero> consultCajeroCodigo(Cajero cajero) {
        try {
            listCajero = new ArrayList<>();
            listCajero = em.createNamedQuery("Cajero.findByCodCaja").setParameter("codCaja", cajero.getCodCaja()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listCajero;
    }

//-------------------Metodos de agente----------------//
    public AgenteTransito insertAgente(AgenteTransito agente) {
        try {
            em.getTransaction().begin();
            em.persist(agente);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return agente;
    }

    public void deleteAgente(AgenteTransito agente) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(AgenteTransito.class, agente.getIdAgente()));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public AgenteTransito updateAgente(AgenteTransito agente) {
        try {
            em.getTransaction().begin();
            em.merge(agente);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return agente;
    }

    public List<AgenteTransito> consultAgenteByNumPlaca(AgenteTransito agente) {
        try {
            listAgente = new ArrayList<>();
            listAgente = em.createNamedQuery("AgenteTransito.findByNumPlaca").setParameter("numPlaca", agente.getNumPlaca()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listAgente;
    }

    public List<AgenteTransito> consultAgentes() {
        try {
            listAgente = new ArrayList<>();
            listAgente = em.createNamedQuery("AgenteTransito.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listAgente;
    }

    public AgenteTransito consultAgente(AgenteTransito agent) {
        try {
            agente = new AgenteTransito();
            agente = (AgenteTransito) em.createNamedQuery("AgenteTransito.findByIdAgente").setParameter("idAgente", agent.getIdAgente()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return agente;
    }

    public List<TipoPlaca> consultPlaca() {
        try {
            listPlaca = new ArrayList<>();
            listPlaca = em.createNamedQuery("TipoPlaca.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPlaca;
    }
//------------------metodos de conductor--------------//

    public Conductor insertConductor(Conductor conductor) {
        try {
            em.getTransaction().begin();
            em.persist(conductor);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return conductor;
    }

    public Conductor updateConductor(Conductor conductor) {
        try {
            em.getTransaction().begin();
            em.merge(conductor);
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return conductor;
    }

    public void deleteConductor(Conductor conductor) {
        try {
            em.getTransaction().begin();
            em.remove(em.find(Conductor.class, conductor.getIdConductor()));
            em.flush();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Conductor consultConductor(Conductor condu) {
        try {
            conductor = new Conductor();
            conductor = (Conductor) em.createNamedQuery("Conductor.findByIdConductor").setParameter("idConductor", condu.getIdConductor()).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return conductor;
    }

    public List<ClaseLicencia> consultLicencia() {
        try {
            listClaseLicencias = new ArrayList<>();
            listClaseLicencias = em.createNamedQuery("ClaseLicencia.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        }
        return listClaseLicencias;
    }

    public List<Conductor> consultConductores() {
        try {
            listConductor = new ArrayList<>();
            listConductor = em.createNamedQuery("Conductor.findAll").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listConductor;
    }

    public List<Conductor> consultConductorLicencia(Conductor conductor) {
        try {
            listConductor = new ArrayList<>();
            listConductor = em.createNamedQuery("Conductor.findByLicencia").setParameter("licencia", conductor.getLicencia()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listConductor;
    }
//-----------------metodos de esquelas--------------//

    public List<Esquela> findAllEsquelas() {
        try {
            listEsquelas = new ArrayList<>();
            listEsquelas = em.createNativeQuery("call cargarEsquelas()", Esquela.class).getResultList();
            //StoredProcedureQuery w = em.createNamedStoredProcedureQuery("Esquela.CargarEsquelas");
            //listEsquelas = w.getResultList();
            System.out.println("Tamaño de lista de esquelas: " + listEsquelas);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listEsquelas;
    }

    public List<Esquela> consultEsquelas() {
        try {
            listEsquelas = new ArrayList<>();
            listEsquelas = em.createNamedQuery("Esquela.findAll").getResultList();
            System.out.println("Tamaño de lista de esquelas: " + listEsquelas.size());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listEsquelas;
    }
}
