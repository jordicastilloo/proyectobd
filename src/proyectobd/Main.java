/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectobd;

/**
 *
 * @author jordicastillo
 */
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        VentanaPrincipal vp = new VentanaPrincipal();
        vp.setVisible(true);
        vp.setSize(700, 500);
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}