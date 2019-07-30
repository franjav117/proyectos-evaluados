/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

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
    
    private Usuario usuario;
    
}
