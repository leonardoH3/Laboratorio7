/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.DaoPaciente;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2107262
 */
public class ServiciosPacientesDao extends ServiciosPacientes{
     DaoFactory daof =null;

    public ServiciosPacientesDao(){
         try {
             InputStream input = null;
             input = getClass().getClassLoader().getResource("applicationconfig_test.properties").openStream();
             Properties properties=new Properties();
             properties.load(input);
             daof=DaoFactory.getInstance(properties);
         } catch (IOException ex) {
             Logger.getLogger(ServiciosPacientesDao.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    }
    public Paciente consultarPaciente(int idPaciente, String tipoid) throws ExcepcionServiciosPacientes {
        Paciente pa = null;
        DaoPaciente dao = daof.getDaoPaciente();
         try {
             pa = dao.load(idPaciente, tipoid);
         } catch (PersistenceException ex) {
             Logger.getLogger(ServiciosPacientesDao.class.getName()).log(Level.SEVERE, null, ex);
         }
        return pa;
    }

    @Override
    public void registrarNuevoPaciente(Paciente p) throws ExcepcionServiciosPacientes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarConsultaAPaciente(int idPaciente, String tipoid, Consulta c) throws ExcepcionServiciosPacientes {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Paciente> getPacientes() {
        Paciente pa = null;
        DaoPaciente dao = daof.getDaoPaciente();
        ArrayList<Paciente> pacientes= new ArrayList<Paciente>();
         try {
             pacientes = dao.PacientesTotal();
         } catch (PersistenceException ex) {
             Logger.getLogger(ServiciosPacientesDao.class.getName()).log(Level.SEVERE, null, ex);
         }
         return pacientes;
    }
    
}
