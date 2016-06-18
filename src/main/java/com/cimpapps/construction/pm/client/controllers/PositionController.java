
package com.cimpapps.construction.pm.client.controllers;

import construction.pm.lib.dto.EmployeePositionDTO;
import construction.pm.lib.rmi.AbstractEmployeePositionRemote;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PositionController {

    private static final PositionController SINGLETON = new PositionController();
    
    private Registry registry;
    private AbstractEmployeePositionRemote service;
    
    private PositionController(){
        try {
            registry = LocateRegistry.getRegistry("localhost", 4334);
            service =  (AbstractEmployeePositionRemote) registry.lookup("employeePosition");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(PositionController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } 
    }
    
    public static PositionController getInstance(){
        return SINGLETON;
    }
    
    public List<EmployeePositionDTO> getAllEmployeePositions(){
        List<EmployeePositionDTO> positions = null;
        try {
            positions = service.getAllEmployeePositions();         
        } catch (RemoteException ex) {
            Logger.getLogger(PositionController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return positions;
    }
}