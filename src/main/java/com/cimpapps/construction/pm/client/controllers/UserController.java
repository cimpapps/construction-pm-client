package com.cimpapps.construction.pm.client.controllers;

import construction.pm.lib.dto.UserDTO;
import construction.pm.lib.rmi.AbstractUserRemote;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserController {

    private static final UserController SINGLETON = new UserController();
    
    Registry registry;
    AbstractUserRemote userService;
    
    
    private UserController() {
        try {
            registry = LocateRegistry.getRegistry("localhost", 4334);
            userService = (AbstractUserRemote) registry.lookup("user");
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
    }
    
    public static UserController getInstance(){
        return SINGLETON;
    }
    
    public boolean registerUser(String username, String password)
    {
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        try {
            return userService.register(user);
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public UserDTO logIn(String username, String password) {
        UserDTO user = new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        try {
            user = userService.logIn(user);
            return user;
        } catch (RemoteException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
