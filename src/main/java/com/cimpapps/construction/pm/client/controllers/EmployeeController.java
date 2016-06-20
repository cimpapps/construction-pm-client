package com.cimpapps.construction.pm.client.controllers;

import construction.pm.lib.dto.EmployeeDTO;
import construction.pm.lib.rmi.AbstractEmployeeRemote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController {

    private static final EmployeeController SINGLETON = new EmployeeController();
    private Registry registry;
    private AbstractEmployeeRemote employeeService;

    private EmployeeController() {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4334);
            employeeService = (AbstractEmployeeRemote) registry.lookup("employee");
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static EmployeeController getInstance() {
        return SINGLETON;
    }

    public boolean registerEmployee(EmployeeDTO employee) {

        try {
            return employeeService.addEmployee(employee);
        } catch (RemoteException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return false;
    }

}
