/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.dao.GenericDao;
import com.esquelas.dao.PersonaDao;
import com.esquelas.dao.UsuarioDao;
import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Cajero;
import com.esquelas.entities.ClaseLicencia;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Persona;
import com.esquelas.entities.Rol;
import com.esquelas.entities.TipoPlaca;
import com.esquelas.entities.Usuario;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author rogelio.mejiausam
 */
@ManagedBean
@SessionScoped
public class PersonaMb implements Serializable{
    
    //--------atributos de persona-------//
    private PersonaDao ejbPersona;
    private Persona persona;
    private List<Persona> listPersonas;
    //--------atributos de usuario-------//
    private UsuarioDao ejbUsuario;
    private Usuario usuario;
    private Rol rol;
    private List<Rol> listRols;
    private List<Usuario> listUsuarios;
    private Integer idRol;
    private Integer idPersona;
    private Map<String, Integer> selectMenuRol;
    private Map<String, Integer> selectMenuPersona;
    //--------------cajero---------------//
    private Cajero cajero;
    private List<Cajero> listCajeros;
    //-------------Policia---------------//
    private AgenteTransito agente;
    private List<AgenteTransito> listAgente;
    private Integer idTipoPlaca;
    private TipoPlaca tipoPlaca;
    private List<TipoPlaca> listPlacas;
    private Map<String, Integer> selectMenuTipo;
    //--------------conductor-------------//
    private ClaseLicencia claseLicencia;
    private Conductor conductor;
    private List<Conductor> listConductors;
    private List<ClaseLicencia> listClaseLicencias;
    private Integer idClaseLicencia;
    private Map<String, Integer> selectMenuLicencia;
    //--------------general--------------//
    private FacesMessage msg;
    private SimpleDateFormat formato;
    private GenericDao gd;

    @PostConstruct
    public void init() {
        gd = new GenericDao();
        ejbUsuario = new UsuarioDao();
        ejbPersona = new PersonaDao();
        listClaseLicencias = new ArrayList<>();
        listConductors = new ArrayList<>();
        listPlacas = new ArrayList<>();
        listPersonas = new ArrayList<>();
        listUsuarios = new ArrayList<>();
        listCajeros = new ArrayList<>();
        listRols = new ArrayList<>();
        listAgente = new ArrayList<>();
        conductor = new Conductor();
        cajero = new Cajero();
        tipoPlaca = new TipoPlaca();
        agente = new AgenteTransito();
        rol = new Rol();
        claseLicencia = new ClaseLicencia();
        persona = new Persona();
        usuario = new Usuario();
        idClaseLicencia = 0;
        idTipoPlaca = 0;
        idRol = 0;
        idPersona = 0;
        selectMenuLicencia = new HashMap<>();
        selectMenuTipo = new HashMap<>();
        selectMenuRol = new HashMap<>();
        selectMenuPersona = new HashMap<>();
        formato = new SimpleDateFormat("yyyy-MM-dd");
        this.consultUsuario();
        this.consultarPersona();
        this.fillRols();
        this.fillPersonas();
    }

    //--------metodos de persona--------//
    public void insertPersona() {
        try {
            persona = ejbPersona.insertPersona(persona);
            msg = new FacesMessage("Exito al ingresar: " + persona.getN1Nombre() + " " + persona.getA1Apellido());
            persona = new Persona();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al insertar persona");
        }
        this.consultarPersona();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void consultarPersona() {
        try {
            listPersonas = ejbPersona.consultPersona();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePersona() {
        try {
            persona = ejbPersona.updatePersona(persona);
            msg = new FacesMessage("Exito al modificar");
            persona = new Persona();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al modificar");
        }
        this.consultarPersona();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deletePersona(Persona persona) {
        try {
            ejbPersona.deletePersona(persona);
            msg = new FacesMessage("Exito al eliminar");
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al eliminar");
        }
        this.consultarPersona();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void selectPersona(Persona per) {
        try {
            persona = ejbPersona.selectPersona(per);
            msg = new FacesMessage("Persona selecionada");
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //--------metodos de usuarios--------//
    public void insertUsuario() {
        try {
            rol.setIdRol(idRol);
            usuario.setIdRol(rol);
            persona.setIdPersona(idPersona);
            usuario.setIdPersona(persona);
            usuario = ejbUsuario.insertUsuario(usuario);
            msg = new FacesMessage("Exito al crear: " + usuario.getUsuario());
            usuario = new Usuario();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al crear");
        }
        this.consultUsuario();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void updateUsuario() {
        try {
            ejbUsuario = new UsuarioDao();
            rol.setIdRol(idRol);
            usuario.setIdRol(rol);
            persona.setIdPersona(idPersona);
            usuario.setIdPersona(persona);
            usuario = ejbUsuario.updateUsuario(usuario);
            msg = new FacesMessage("Exito al modificar");
            usuario = new Usuario();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error");
        }
        this.consultUsuario();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void consultUsuario() {
        try {
            ejbUsuario = new UsuarioDao();
            listUsuarios = ejbUsuario.consultUsuario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuario(Usuario usuario) {
        try {
            ejbUsuario.deleteUsuario(usuario);
            msg = new FacesMessage("Exito al eliminar Usuario");
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al eliminar");
        }
        this.consultUsuario();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void selectUsuario(Usuario user) {
        try {
            usuario = ejbUsuario.findUsuario(user);
            idPersona = usuario.getIdPersona().getIdPersona();
            idRol = usuario.getIdRol().getIdRol();
            msg = new FacesMessage("Usuario selecionado con entitymanager");
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Ocurrio un error");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void fillPersonas() {
        try {
            listPersonas = ejbPersona.consultPersona();
            for (Persona person : listPersonas) {
                selectMenuPersona.put(person.getN1Nombre() + " " + person.getA1Apellido(), person.getIdPersona());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillRols() {
        try {
            listRols = ejbUsuario.consultRol();
            for (Rol r : listRols) {
                selectMenuRol.put(r.getRol() + " " + r.getDescripcionRol(), r.getIdRol());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------metodos de cajero-----//
    public void insertCajero() {
        try {
            persona = ejbPersona.insertPersona(persona);
            cajero.setIdPersona(persona);
            cajero = ejbPersona.insertCajero(cajero);
            msg = new FacesMessage("Cajero creado con exito: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " " + cajero.getCac());
            cajero = new Cajero();
            persona = new Persona();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al crear cajero");
        }
        this.consultarPersona();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //-------------conductor---------//
    public void insertConductor() {
        try {
            persona = ejbPersona.insertPersona(persona);
            conductor.setIdPersona(persona);
            claseLicencia.setIdClaseLicencia(idClaseLicencia);
            conductor.setLicenciaTipo(claseLicencia);
            conductor = ejbPersona.insertConductor(conductor);
            msg = new FacesMessage("Exito al crear Conductor: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " " + conductor.getLicencia());
            conductor = new Conductor();
            persona = new Persona();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al crear conductor");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void fillClaseLicencia() {
        try {
            listClaseLicencias = ejbPersona.consultLicencia();
            for (ClaseLicencia c : listClaseLicencias) {
                selectMenuLicencia.put(c.getLicencia(), c.getIdClaseLicencia());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //--------------metodos de agente-------------//   
    public void inserAgente() {
        try {
            persona = ejbPersona.insertPersona(persona);
            agente.setIdPersona(persona);
            tipoPlaca.setIdTipoPlaca(idTipoPlaca);
            agente.setTipoPlaca(tipoPlaca);
            agente = ejbPersona.insertAgente(agente);
            msg = new FacesMessage("Exito al crear Agente de transito: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " " + agente.getNumPlaca());
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al crear Agente");
        }
        this.consultarPersona();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void fillTipo() {
        try {
            listPlacas = ejbPersona.consultPlaca();
            for (TipoPlaca t : listPlacas) {
                selectMenuTipo.put(t.getTipoPlaca(), t.getIdTipoPlaca());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListPersonas() {
        return listPersonas;
    }

    public void setListPersonas(List<Persona> listPersonas) {
        this.listPersonas = listPersonas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Map<String, Integer> getSelectMenuPersona() {
        return selectMenuPersona;
    }

    public void setSelectMenuPersona(Map<String, Integer> selectMenuPersona) {
        this.selectMenuPersona = selectMenuPersona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListRols() {
        return listRols;
    }

    public void setListRols(List<Rol> listRols) {
        this.listRols = listRols;
    }

    public Map<String, Integer> getSelectMenuRol() {
        return selectMenuRol;
    }

    public void setSelectMenuRol(Map<String, Integer> selectMenuRol) {
        this.selectMenuRol = selectMenuRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    
    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public List<Cajero> getListCajeros() {
        return listCajeros;
    }

    public void setListCajeros(List<Cajero> listCajeros) {
        this.listCajeros = listCajeros;
    }

    public AgenteTransito getAgente() {
        return agente;
    }

    public void setAgente(AgenteTransito agente) {
        this.agente = agente;
    }

    public List<AgenteTransito> getListAgente() {
        return listAgente;
    }

    public void setListAgente(List<AgenteTransito> listAgente) {
        this.listAgente = listAgente;
    }
    //
}
