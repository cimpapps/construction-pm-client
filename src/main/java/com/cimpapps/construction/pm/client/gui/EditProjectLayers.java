/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cimpapps.construction.pm.client.gui;

import construction.pm.lib.dto.ProjectDTO;
import construction.pm.lib.dto.ProjectLayerDTO;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author catalin.cimpoeru
 */
public class EditProjectLayers extends javax.swing.JDialog {

    /**
     * Creates new form EditProjectLayers
     */
    JButton addLayersToProjectButton;
    Collection<ProjectLayerDTO> layers;
    List<JTextField> textFields = new ArrayList<>();
    ProjectDTO project;

    public EditProjectLayers(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    public EditProjectLayers(java.awt.Frame parent, boolean modal, int rows, ProjectDTO project) {
        this(parent, modal);
        this.project = project;
        layers = project.getProjectLayerCollection();

        setLayout(new FlowLayout());
        addComponentsToPanel(rows);
        addActionListeners();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent());
        pack();
        setResizable(false);
        setVisible(true);

    }

    public void addComponentsToPanel(int rows) {
        JPanel layersPanel = new JPanel();
        layersPanel.setLayout(new GridLayout(rows, 2));

        for (int i = 1; i <= rows; i++) {
            layersPanel.add(new JLabel("Story " + i + ":    "));
            JTextField text = new JTextField("");
            layersPanel.add(text);
            textFields.add(text);
        }
        add(layersPanel);
        addLayersToProjectButton = new JButton("Add Layers");
        add(addLayersToProjectButton);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionListeners() {
        addLayersToProjectButton.addActionListener(ev -> addLayersToProject());
    }

    private void addLayersToProject() {
        textFields.forEach(this :: addSingleLayerToProject);
        dispose();
    }

    private void addSingleLayerToProject(JTextField t) {
        ProjectLayerDTO layer = new ProjectLayerDTO();
        layer.setProjectsId(project);
        layer.setName(t.getText().trim());
        layers.add(layer);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
