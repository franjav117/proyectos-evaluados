/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.entities.Esquela;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author francisco.amayausam
 */
@ManagedBean
@ViewScoped
public class RegistroEsquelasMb {
    
    private Esquela esquela;
    private List<Esquela> esquelaList; 
    
}
