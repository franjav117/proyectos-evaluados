/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;


import com.esquelas.dao.LogingDao;
import com.esquelas.entities.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.esquelas.entities.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author rogelio.mejiausam
 */
@ManagedBean
@SessionScoped
public class LoginMb {

    private String user;
    private String password;
    private String rol;
    private Usuario usuario;
    private Usuario datosUsuarioLogueado;
    private LogingDao loginDao;

    private boolean usuarioIsLogueado;

    private boolean verEsquelas;
    private boolean colocarEsquelas;
    private boolean borrarEsquelas;
    private boolean editarEsquelas;

    private boolean verCaja;
    private boolean pagoCaja;
    private boolean revertirPagoCaja;

    private boolean consultaConductorLogeado;
    private boolean consultaConductorSinLoguear;

    @PostConstruct
    public void init() {
        loginDao = new LogingDao();
        usuarioIsLogueado = false;

        verEsquelas = false;
        colocarEsquelas = false;
        borrarEsquelas = false;
        editarEsquelas = false;

        verCaja = false;
        pagoCaja = false;

        revertirPagoCaja = false;

        consultaConductorLogeado = false;
        consultaConductorSinLoguear = true;
    }

    public String loguearUsuario() {  //ligin y permisos de visualizacion

        Usuario usuarioLogeado = new Usuario();
        usuarioLogeado = loginDao.usuarioLogin(user, password);
        System.out.println("/*/*/*/*/*/ Usuario Logueado: " + usuarioLogeado);
        if (null != usuarioLogeado) {
            rol = usuarioLogeado.getIdRol().getRol();
            if (usuarioLogeado.getIdRol().getIdRol() == 1) {
                usuarioIsLogueado = true;

                verEsquelas = true;
                colocarEsquelas = true;
                borrarEsquelas = false;
                editarEsquelas = false;

                verCaja = false;
                pagoCaja = false;

                revertirPagoCaja = false;

                consultaConductorLogeado = true;

            } else if (usuarioLogeado.getIdRol().getIdRol() == 2) {
                usuarioIsLogueado = true;

                verEsquelas = true;
                colocarEsquelas = true;
                borrarEsquelas = false;
                editarEsquelas = true;

                verCaja = false;
                pagoCaja = false;

                revertirPagoCaja = false;

                consultaConductorLogeado = true;

            } else if (usuarioLogeado.getIdRol().getIdRol() == 3) {
                usuarioIsLogueado = true;

                verEsquelas = true;
                colocarEsquelas = true;
                borrarEsquelas = true;
                editarEsquelas = true;

                verCaja = false;
                pagoCaja = false;

                revertirPagoCaja = false;

                consultaConductorLogeado = false;

            } else if (usuarioLogeado.getIdRol().getIdRol() == 4) {
                usuarioIsLogueado = true;

                verEsquelas = true;
                colocarEsquelas = false;
                borrarEsquelas = false;
                editarEsquelas = false;

                verCaja = true;
                pagoCaja = true;

                revertirPagoCaja = false;

                consultaConductorLogeado = false;

            } else if (usuarioLogeado.getIdRol().getIdRol() == 5) {
                usuarioIsLogueado = true;

                verEsquelas = true;
                colocarEsquelas = false;
                borrarEsquelas = false;
                editarEsquelas = false;

                verCaja = true;
                pagoCaja = true;

                revertirPagoCaja = true;

                consultaConductorLogeado = true;

            } else if (usuarioLogeado.getIdRol().getIdRol() == 6) {
                usuarioIsLogueado = true;

                verEsquelas = true;
                colocarEsquelas = false;
                borrarEsquelas = false;
                editarEsquelas = false;

                verCaja = false;
                pagoCaja = false;

                revertirPagoCaja = false;

                consultaConductorLogeado = true;

            } else if (usuarioLogeado.getIdRol().getIdRol() == 7) {
                usuarioIsLogueado = true;

                verEsquelas = true;
                colocarEsquelas = true;
                borrarEsquelas = true;
                editarEsquelas = true;

                verCaja = true;
                pagoCaja = true;

                revertirPagoCaja = true;

                consultaConductorLogeado = true;

            }
            datosUsuarioLogueado = usuarioLogeado;
            return "Caja.xhtml?faces-redirect=true";
            //return "index.xhtml";
        }
        FacesMessage msg = null;
        msg = new FacesMessage("Error de usuario o contrasña");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        //return "Caja.xhtml?faces-redirect=true";
        return "index.xhtml";

    }

    public String logOut() {
        usuarioIsLogueado = false;
        usuario = new Usuario();
        return "index.xhtml?faces-redirect=true";
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getDatosUsuarioLogueado() {
        return datosUsuarioLogueado;
    }

    public void setDatosUsuarioLogueado(Usuario datosUsuarioLogueado) {
        this.datosUsuarioLogueado = datosUsuarioLogueado;
    }

    public boolean isUsuarioIsLogueado() {
        return usuarioIsLogueado;
    }

    public void setUsuarioIsLogueado(boolean usuarioIsLogueado) {
        this.usuarioIsLogueado = usuarioIsLogueado;
    }
    
    public boolean isVerEsquelas() {
        return verEsquelas;
    }

    public void setVerEsquelas(boolean verEsquelas) {
        this.verEsquelas = verEsquelas;
    }

    public boolean isColocarEsquelas() {
        return colocarEsquelas;
    }

    public void setColocarEsquelas(boolean colocarEsquelas) {
        this.colocarEsquelas = colocarEsquelas;
    }

    public boolean isBorrarEsquelas() {
        return borrarEsquelas;
    }

    public void setBorrarEsquelas(boolean borrarEsquelas) {
        this.borrarEsquelas = borrarEsquelas;
    }

    public boolean isEditarEsquelas() {
        return editarEsquelas;
    }

    public void setEditarEsquelas(boolean editarEsquelas) {
        this.editarEsquelas = editarEsquelas;
    }

    public boolean isVerCaja() {
        return verCaja;
    }

    public void setVerCaja(boolean verCaja) {
        this.verCaja = verCaja;
    }

    public boolean isPagoCaja() {
        return pagoCaja;
    }

    public void setPagoCaja(boolean pagoCaja) {
        this.pagoCaja = pagoCaja;
    }

    public boolean isRevertirPagoCaja() {
        return revertirPagoCaja;
    }

    public void setRevertirPagoCaja(boolean revertirPagoCaja) {
        this.revertirPagoCaja = revertirPagoCaja;
    }

    public boolean isConsultaConductorLogeado() {
        return consultaConductorLogeado;
    }

    public void setConsultaConductorLogeado(boolean consultaConductorLogeado) {
        this.consultaConductorLogeado = consultaConductorLogeado;
    }

    public boolean isConsultaConductorSinLoguear() {
        return consultaConductorSinLoguear;
    }

    public void setConsultaConductorSinLoguear(boolean consultaConductorSinLoguear) {
        this.consultaConductorSinLoguear = consultaConductorSinLoguear;
    }

 }
