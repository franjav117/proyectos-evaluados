package com.esquelas.mb;

import com.esquelas.dao.GenericDao;
import com.esquelas.dao.PersonaDao;
import com.esquelas.dao.UsuarioDao;
import com.esquelas.entities.AgenteTransito;
import com.esquelas.entities.Cajero;
import com.esquelas.entities.ClaseLicencia;
import com.esquelas.entities.Conductor;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.EsquelaReporte;
import com.esquelas.entities.Persona;
import com.esquelas.entities.Rol;
import com.esquelas.entities.TipoPlaca;
import com.esquelas.entities.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ViewScoped
@ManagedBean
public class PersonaMB implements Serializable {

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
    //-------------Selecion-------------//
    private boolean insertCajero;
    private boolean insertPersona;
    private boolean insertConductor;
    private boolean insertAgente;
    //-------------Atributos Para el Reporte-----------//
    private JasperPrint jp;
    private String nombreReport;
    private Esquela esquela;
    private List<Esquela> listEsquela;
    private EsquelaReporte reporte;
    private List<EsquelaReporte> listReporte;

    @PostConstruct
    public void init() {
        gd = new GenericDao();
        ejbUsuario = new UsuarioDao();
        ejbPersona = new PersonaDao();
        listEsquela = new ArrayList<>();
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
        insertAgente = false;
        insertCajero = false;
        insertConductor = false;
        insertPersona = true;
        this.consultUsuario();
        this.consultAgentes();
        this.consultCajeros();
        this.consultConductor();
        this.consultarPersona();
        this.fillRols();
        this.fillPersonas();
        this.fillTipo();
        this.fillClaseLicencia();
    }

    //--------metodos de persona--------//
    public String crearPerfil() {
        try {
            ejbPersona = new PersonaDao();
            ejbUsuario = new UsuarioDao();
            persona.setIdPersona(0);
            usuario.setIdUsuario(0);
            listPersonas = new ArrayList<>();
            listUsuarios = new ArrayList<>();
            listPersonas = ejbPersona.consultPersonaDui(persona);
            if (listPersonas.size() <= 0) {
                listUsuarios = ejbUsuario.consultUsuarioByUsuario(usuario);
                if (listUsuarios.size() <= 0) {
                    persona = ejbPersona.insertPersona(persona);
                    rol.setIdRol(idRol);
                    usuario.setIdRol(rol);
                    usuario.setIdPersona(persona);
                    usuario = ejbUsuario.insertUsuario(usuario);
                    msg = new FacesMessage("registrado con exito!");
                    idRol = 0;
                    usuario = new Usuario();
                    persona = new Persona();
                    return "persona.xhtml";
                } else {
                    msg = new FacesMessage("Error ya hay alguien con ese Usuario!");
                    FacesContext.getCurrentInstance().addMessage(null, msg);
                }
            } else {
                msg = new FacesMessage("Existe una persona Registrada Con el mismo DUI!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertPersona() {
        try {
            ejbPersona = new PersonaDao();
            persona.setIdPersona(0);
            listPersonas = ejbPersona.consultPersonaDui(persona);
            if (listPersonas.size() <= 0) {
                persona = ejbPersona.insertPersona(persona);
                msg = new FacesMessage("Exito al ingresar: " + persona.getN1Nombre() + " " + persona.getA1Apellido());
                persona = new Persona();
            } else {
                msg = new FacesMessage("Exite una persona registrada con el mismo DUI!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al insertar persona");
        }
        this.consultarPersona();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void consultarPersona() {
        try {
            ejbPersona = new PersonaDao();
            listPersonas = new ArrayList<>();
            listPersonas = ejbPersona.consultPersona();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePersona() {
        try {
            ejbPersona = new PersonaDao();
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
            ejbPersona = new PersonaDao();
            ejbPersona.deletePersona(persona);
            msg = new FacesMessage("Exito al eliminar Persona!");
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al eliminar");
        }
        this.consultarPersona();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void selectPersona(Persona person) {
        try {
            ejbPersona = new PersonaDao();
            persona = ejbPersona.selectPersona(person);
            persona.setUsuarioList(null);
            persona.setCajeroList(null);
            persona.setConductorList(null);
            persona.setAgenteTransitoList(null);
            persona.setCajeroList(null);
            msg = new FacesMessage("Persona selecionada: " + persona.getN1Nombre() + "" + persona.getA1Apellido());
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    //--------metodos de usuarios--------//
    public void insertUsuario() {
        try {
            ejbUsuario = new UsuarioDao();
            usuario.setIdUsuario(0);
            listUsuarios = ejbUsuario.consultUsuarioByUsuario(usuario);
            if (listUsuarios.size() <= 0) {
                rol.setIdRol(idRol);
                usuario.setIdRol(rol);
                persona.setIdPersona(idPersona);
                usuario.setIdPersona(persona);
                usuario = ejbUsuario.updateUsuario(usuario);
                msg = new FacesMessage("Exito al modificar: " + usuario.getUsuario());
                usuario = new Usuario();
                idRol = 0;
                idPersona = 0;
            } else {
                msg = new FacesMessage("Error, el usuario ya esta en uso!");
            }
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
            listUsuarios = ejbUsuario.consultUsuarioByUsuario(usuario);
            if (listUsuarios.size() <= 0) {
                rol.setIdRol(idRol);
                usuario.setIdRol(rol);
                persona.setIdPersona(idPersona);
                usuario.setIdPersona(persona);
                usuario = ejbUsuario.updateUsuario(usuario);
                msg = new FacesMessage("Exito al modificar: " + usuario.getUsuario());
                usuario = new Usuario();
                idRol = 0;
                idPersona = 0;
            } else {
                msg = new FacesMessage("Error, el usuario ya esta en uso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al modificar");
        }
        this.consultUsuario();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void consultUsuario() {
        try {
            ejbUsuario = new UsuarioDao();
            listUsuarios = new ArrayList<>();
            listUsuarios = ejbUsuario.consultUsuario();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUsuario(Usuario usuario) {
        try {
            ejbUsuario = new UsuarioDao();
            ejbUsuario.deleteUsuario(usuario);
            msg = new FacesMessage("Exito al eliminar Usuario!");
            idPersona = 0;
            idRol = 0;
            this.usuario = new Usuario();
            persona = new Persona();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al eliminar");
        }
        this.consultUsuario();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void selectUsuario(Usuario user) {
        try {
            ejbUsuario = new UsuarioDao();
            usuario = ejbUsuario.findUsuario(user);
            idPersona = usuario.getIdPersona().getIdPersona();
            idRol = usuario.getIdRol().getIdRol();
            msg = new FacesMessage("Usuario selecionado! " + usuario.getUsuario());
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
                selectMenuPersona.put(person.getDui() + " " + person.getN1Nombre() + " " + person.getA1Apellido(), person.getIdPersona());
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
    public void insertPersonaCajero() {
        try {
            ejbPersona = new PersonaDao();
            persona.setIdPersona(0);
            cajero.setIdCajero(0);
            listPersonas = ejbPersona.consultPersonaDui(persona);
            if (listPersonas.size() <= 0) {
                listCajeros = ejbPersona.consultCajeroCodigo(cajero);
                if (listCajeros.size() <= 0) {
                    persona = ejbPersona.insertPersona(persona);
                    cajero.setIdPersona(persona);
                    cajero = ejbPersona.insertCajero(cajero);
                    msg = new FacesMessage("Cajero creado con exito: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " " + cajero.getCac());
                    cajero = new Cajero();
                    persona = new Persona();
                } else {
                    msg = new FacesMessage("Ya hay una persona con ese codigo de caja!");
                }
            } else {
                msg = new FacesMessage("Exite una persona registrada con el mismo DUI!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al insertar Cajero");
        }
        this.consultarPersona();
        this.consultCajeros();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void updatePersonaCajero() {
        try {
            ejbPersona = new PersonaDao();
            listPersonas = ejbPersona.consultPersonaDui(persona);
            if (listPersonas.size() <= 1) {
                listCajeros = ejbPersona.consultCajeroCodigo(cajero);
                if (listCajeros.size() <= 1) {
                    persona = ejbPersona.updatePersona(persona);
                    cajero.setIdPersona(persona);
                    cajero = ejbPersona.updateCajero(cajero);
                    msg = new FacesMessage("Cajero actualizado con exito: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " " + cajero.getCac());
                    cajero = new Cajero();
                    persona = new Persona();
                } else {
                    msg = new FacesMessage("Ya hay una persona con ese codigo de caja!");
                }
            } else {
                msg = new FacesMessage("Exite una persona registrada con el mismo DUI!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al modificar Cajero");
        }
        this.consultarPersona();
        this.consultCajeros();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteCajero(Cajero caja) {
        try {
            ejbPersona = new PersonaDao();
            ejbPersona.deletePersona(caja.getIdPersona());
            ejbPersona.deleteCajero(caja);
            msg = new FacesMessage("Exito al eliminar Cajero!");
            persona = new Persona();
            cajero = new Cajero();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al eliminar");
        }
        this.consultarPersona();
        this.consultCajeros();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void selectCajero(Cajero caja) {
        try {
            ejbPersona = new PersonaDao();
            persona = ejbPersona.findPersona(caja.getIdPersona());
            cajero = ejbPersona.consultCajero(caja);
            msg = new FacesMessage("Cajero selecionado: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " Cod caja:" + cajero.getCodCaja());
        } catch (Exception e) {
            e.printStackTrace();
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void consultCajeros() {
        try {
            ejbPersona = new PersonaDao();
            listCajeros = new ArrayList<>();
            listCajeros = ejbPersona.consultCajeros();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //-------------conductor---------//
    public void insertConductor() {
        try {
            ejbPersona = new PersonaDao();
            persona.setIdPersona(0);
            conductor.setIdConductor(0);
            listPersonas = ejbPersona.consultPersonaDui(persona);
            if (listPersonas.size() <= 0) {
                listConductors = ejbPersona.consultConductorLicencia(conductor);
                if (listConductors.size() <= 0) {
                    persona = ejbPersona.insertPersona(persona);
                    conductor.setIdPersona(persona);
                    claseLicencia.setIdClaseLicencia(idClaseLicencia);
                    conductor.setLicenciaTipo(claseLicencia);
                    conductor = ejbPersona.insertConductor(conductor);
                    msg = new FacesMessage("Conductor creado con exito: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " Licencia: " + conductor.getLicencia());
                    conductor = new Conductor();
                    persona = new Persona();
                    idClaseLicencia = 0;
                } else {
                    msg = new FacesMessage("La licencia ya esta registrada para otro conductor!");
                }
            } else {
                msg = new FacesMessage("Exite una persona registrada con el mismo DUI!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al crear conductor");
        }
        this.consultarPersona();
        this.consultConductor();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void updateConductor() {
        try {
            ejbPersona = new PersonaDao();
            listPersonas = ejbPersona.consultPersonaDui(persona);
            if (listPersonas.size() <= 1) {
                listConductors = ejbPersona.consultConductorLicencia(conductor);
                if (listConductors.size() <= 1) {
                    persona = ejbPersona.updatePersona(persona);
                    conductor.setIdPersona(persona);
                    claseLicencia.setIdClaseLicencia(idClaseLicencia);
                    conductor.setLicenciaTipo(claseLicencia);
                    conductor = ejbPersona.updateConductor(conductor);
                    msg = new FacesMessage("Conductor actualizado con exito: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " Licencia: " + conductor.getLicencia());
                    conductor = new Conductor();
                    persona = new Persona();
                    idClaseLicencia = 0;
                } else {
                    msg = new FacesMessage("La licencia ya esta registrada para otro conductor!");
                }
            } else {
                msg = new FacesMessage("Exite una persona registrada con el mismo DUI!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al actalizar conductor");
        }
        this.consultarPersona();
        this.consultConductor();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteConductor(Conductor conduc) {
        try {
            ejbPersona = new PersonaDao();
            ejbPersona.deletePersona(conduc.getIdPersona());
            ejbPersona.deleteConductor(conduc);
            msg = new FacesMessage("Exito al eliminar Conductor!");
            persona = new Persona();
            conductor = new Conductor();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al eliminar");
        }
        this.consultarPersona();
        this.consultConductor();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void selectConductor(Conductor conduc) {
        try {
            ejbPersona = new PersonaDao();
            persona = ejbPersona.findPersona(conduc.getIdPersona());
            conductor = ejbPersona.consultConductor(conduc);
            idClaseLicencia = conductor.getLicenciaTipo().getIdClaseLicencia();
            msg = new FacesMessage("Conductor selecionado: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + "Licencia:" + conductor.getLicencia());
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void consultConductor() {
        try {
            listConductors = new ArrayList<>();
            listConductors = ejbPersona.consultConductores();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void insertAgente() {
        try {
            ejbPersona = new PersonaDao();
            persona.setIdPersona(0);
            agente.setIdAgente(0);
            listPersonas = ejbPersona.consultPersonaDui(persona);
            if (listPersonas.size() <= 0) {
                listAgente = ejbPersona.consultAgenteByNumPlaca(agente);
                if (listAgente.size() <= 0) {
                    persona = ejbPersona.insertPersona(persona);
                    agente.setIdPersona(persona);
                    tipoPlaca.setIdTipoPlaca(idTipoPlaca);
                    agente.setTipoPlaca(tipoPlaca);
                    agente = ejbPersona.insertAgente(agente);
                    msg = new FacesMessage("Agente de Transito al Servicio!: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " Num:" + agente.getNumPlaca());
                    agente = new AgenteTransito();
                    persona = new Persona();
                    idTipoPlaca = 0;
                } else {
                    msg = new FacesMessage("Ya Existe un registro con dicho numero de placa!");
                }
            } else {
                msg = new FacesMessage("Exite una persona registrada con el mismo DUI!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al crear Agente");
        }
        this.consultarPersona();
        this.consultAgentes();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void updateAgente() {
        try {
            ejbPersona = new PersonaDao();
            listPersonas = ejbPersona.consultPersonaDui(persona);
            if (listPersonas.size() <= 1) {
                listAgente = ejbPersona.consultAgenteByNumPlaca(agente);
                if (listAgente.size() <= 1) {
                    persona = ejbPersona.updatePersona(persona);
                    agente.setIdPersona(persona);
                    tipoPlaca.setIdTipoPlaca(idTipoPlaca);
                    agente.setTipoPlaca(tipoPlaca);
                    agente = ejbPersona.updateAgente(agente);
                    msg = new FacesMessage("Agente actualizado con exito!: " + persona.getN1Nombre() + " " + persona.getA1Apellido() + " Num:" + agente.getNumPlaca());
                    agente = new AgenteTransito();
                    persona = new Persona();
                    idTipoPlaca = 0;
                } else {
                    msg = new FacesMessage("Ya Existe un registro con dicho numero de placa!");
                }
            } else {
                msg = new FacesMessage("Exite una persona registrada con el mismo DUI!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al actualizar Agente");
        }
        this.consultarPersona();
        this.consultAgentes();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void deleteAgente(AgenteTransito agent) {
        try {
            ejbPersona = new PersonaDao();
            ejbPersona.deletePersona(agent.getIdPersona());
            ejbPersona.deleteAgente(agent);
            msg = new FacesMessage("Agente de transito Eliminado del sistema!");
            persona = new Persona();
            agente = new AgenteTransito();
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al eliminar");
        }
        this.consultarPersona();
        this.consultAgentes();
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void consultAgentes() {
        try {
            ejbPersona = new PersonaDao();
            listAgente = new ArrayList<>();
            listAgente = ejbPersona.consultAgentes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void selectAgente(AgenteTransito agen) {
        try {
            ejbPersona = new PersonaDao();
            persona = ejbPersona.findPersona(agen.getIdPersona());
            agente = ejbPersona.consultAgente(agen);
            idTipoPlaca = agente.getTipoPlaca().getIdTipoPlaca();
            msg = new FacesMessage("Agente selecionado: " + persona.getN1Nombre() + persona.getA1Apellido() + " Num:" + agente.getNumPlaca());
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error");
        }
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
    //---------metodos para reporte de esquelas------------//
    public void loadEsquelasList() {
        try {
            reporte = new EsquelaReporte();
            esquela = new Esquela();
            ejbPersona = new PersonaDao();
            listEsquela = new ArrayList<>();
            listReporte = new ArrayList<>();
            listEsquela = ejbPersona.consultEsquelas();
            System.out.println("Tamaño de la lista de esquelas en ManagedBean: " + listEsquela.size());
            EsquelaReporte report;
            if (null != listEsquela) {
                for (Esquela r : listEsquela) {
                    report = new EsquelaReporte();
                    report.setId(r.getIdEsquela());
                    report.setC_Licencia(r.getIdConductor().getLicencia());
                    report.setC_clase_licencia(r.getIdConductor().getLicenciaTipo().getLicencia());
                    report.setC_nombre1(r.getIdConductor().getIdPersona().getN1Nombre());
                    report.setC_nombre2(r.getIdConductor().getIdPersona().getN2Nombre());
                    report.setC_nombre3(r.getIdConductor().getIdPersona().getN3Nombre());
                    report.setC_apellido1(r.getIdConductor().getIdPersona().getA1Apellido());
                    report.setC_apellido2(r.getIdConductor().getIdPersona().getA2Apellido());
                    report.setC_apellido3(r.getIdConductor().getIdPersona().getA3Apellido());
                    report.setC_dui(r.getIdConductor().getIdPersona().getDui());
                    report.setV_tipomatricula(r.getPlaca().getTipoPlaca().getCodigoMatricula());
                    report.setV_placa(r.getPlaca().getNumeroPlaca());
                    report.setV_ruta(r.getPlaca().getCodigoRuta());
                    report.setV_extranjera(r.getPlaca().getExtrangera());
                    report.setV_pais(r.getPlaca().getPais());
                    report.setV_clase(r.getPlaca().getClaseVehiculo());
                    report.setV_marca(r.getPlaca().getMarca());
                    report.setV_modelo(r.getPlaca().getModelo());
                    report.setV_color(r.getPlaca().getColor());
                    report.setE_codigo(r.getCodigoFalta());
                    report.setE_clasificacion(r.getClasificacion().getClasificacion());
                    report.setE_fecha(r.getFechaEsquela());
                    report.setE_lugar(r.getLugarInfraccion());
                    report.setE_observaciones(r.getObservaciones());
                    report.setE_gravedad(r.getTipoGravedad().getGravedad());
                    report.setE_estado(r.getEstado().getEstadoMulta());
                    report.setE_fecha_pago(r.getFechaPago());
                    report.setE_pagar(r.getMontoPagar());
                    report.setA_tipo_placa(r.getIdAgente().getTipoPlaca().getTipoPlaca());
                    report.setA_num_plca(r.getIdAgente().getNumPlaca());
                    report.setA_puesto(r.getIdAgente().getPuestoPolicial());
                    report.setC_codigo(r.getIdCajero().getCodCaja());
                    report.setE_departamento(r.getIdDepartamento().getDepartamento());
                    report.setE_otros(r.getIdOtros().getEspecificacion());
                    report.setE_decomiso(r.getIdDecomiso().getDecomiso());
                    System.out.println("MIRAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA: " + report.getC_Licencia());
                    listReporte.add(report);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toPdf() throws IOException, JRException {
        try {
            HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            hsr.addHeader("Content-disposition", "attachment; filename=" + nombreReport);
            ServletOutputStream sos = hsr.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jp, sos);
            sos.flush();
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void esquelasToPdf() throws IOException, JRException {
        try {
            this.loadEsquelasList();
            JRBeanCollectionDataSource jdbc = new JRBeanCollectionDataSource(listReporte);
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("reportesWilliam/reportePrueba.jasper");
            Map<String, Object> map = new HashMap<String, Object>();
            jp = JasperFillManager.fillReport(reportPath, map, jdbc);
            nombreReport = "reporte de esquelas.pdf";
            this.toPdf();
            msg = new FacesMessage("Reporte Generado con exito!");
        } catch (Exception e) {
            e.printStackTrace();
            msg = new FacesMessage("Error al generar Reporte!");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public Integer getIdTipoPlaca() {
        return idTipoPlaca;
    }

    public void setIdTipoPlaca(Integer idTipoPlaca) {
        this.idTipoPlaca = idTipoPlaca;
    }

    public TipoPlaca getTipoPlaca() {
        return tipoPlaca;
    }

    public void setTipoPlaca(TipoPlaca tipoPlaca) {
        this.tipoPlaca = tipoPlaca;
    }

    public Map<String, Integer> getSelectMenuTipo() {
        return selectMenuTipo;
    }

    public void setSelectMenuTipo(Map<String, Integer> selectMenuTipo) {
        this.selectMenuTipo = selectMenuTipo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public List<Conductor> getListConductors() {
        return listConductors;
    }

    public void setListConductors(List<Conductor> listConductors) {
        this.listConductors = listConductors;
    }

    public Integer getIdClaseLicencia() {
        return idClaseLicencia;
    }

    public void setIdClaseLicencia(Integer idClaseLicencia) {
        this.idClaseLicencia = idClaseLicencia;
    }

    public Map<String, Integer> getSelectMenuLicencia() {
        return selectMenuLicencia;
    }

    public void setSelectMenuLicencia(Map<String, Integer> selectMenuLicencia) {
        this.selectMenuLicencia = selectMenuLicencia;
    }

    public boolean isInsertCajero() {
        return insertCajero;
    }

    public void setInsertCajero(boolean insertCajero) {
        this.insertCajero = insertCajero;
    }

    public boolean isInsertPersona() {
        return insertPersona;
    }

    public void setInsertPersona(boolean insertPersona) {
        this.insertPersona = insertPersona;
    }

    public boolean isInsertConductor() {
        return insertConductor;
    }

    public void setInsertConductor(boolean insertConductor) {
        this.insertConductor = insertConductor;
    }

    public boolean isInsertAgente() {
        return insertAgente;
    }

    public void setInsertAgente(boolean insertAgente) {
        this.insertAgente = insertAgente;
    }
}
