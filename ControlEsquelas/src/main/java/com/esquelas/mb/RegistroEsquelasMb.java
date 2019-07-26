/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esquelas.mb;

import com.esquelas.entities.Clasificacion;
import com.esquelas.entities.Decomiso;
import com.esquelas.entities.Departamento;
import com.esquelas.entities.Esquela;
import com.esquelas.entities.Estado;
import com.esquelas.entities.Otros;
import com.esquelas.entities.TipoGravedad;
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
    private List<Esquela> esquelaList; //mostrar de esquelas
    
    private List<Estado> estadoList;
    private List<Departamento> departamentoList;
    private List<TipoGravedad> tipoGravedadList;
    private List<Decomiso> DecomisoList;
    private List<Otros> OtrosList;
    private List<Clasificacion> clasificacionList;
    
}
