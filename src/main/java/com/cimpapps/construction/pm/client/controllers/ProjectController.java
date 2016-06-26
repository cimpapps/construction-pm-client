package com.cimpapps.construction.pm.client.controllers;

import construction.pm.lib.dto.ProjectDTO;
import construction.pm.lib.dto.ProjectLayerDTO;
import construction.pm.lib.rmi.AbstractLayersRemote;
import construction.pm.lib.rmi.AbstractProjectRemote;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectController {

    private static final ProjectController SINGLETON = new ProjectController();
    Registry registry;
    AbstractProjectRemote projectRemote;
    AbstractLayersRemote layerRemote;

    private ProjectController() {
        try {

            registry = LocateRegistry.getRegistry("localhost", 4334);
            projectRemote = (AbstractProjectRemote) registry.lookup("project");
            layerRemote = (AbstractLayersRemote) registry.lookup("layer");

        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public static ProjectController getInstance() {
        return SINGLETON;
    }

    public List<ProjectDTO> getAllProjects() {
        try {
            return projectRemote.getAllProjects();
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean addProject(ProjectDTO dto) {
        try {
            projectRemote.addProject(dto);
            return true;
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addLayerToProject(ProjectLayerDTO dto) {
        try {
            layerRemote.addLayer(dto);
            return true;
        } catch (RemoteException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<ProjectLayerDTO> getProjectLayer(ProjectDTO project) {
        try {
            return layerRemote.getProjectLayers(project);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
