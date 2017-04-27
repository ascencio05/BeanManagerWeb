/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanmanager.controles;

import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class TestConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
         Bdd conection = new Bdd();
            JOptionPane.showMessageDialog(null, "Exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        
    }
    
}
