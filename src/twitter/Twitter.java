/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitter;

import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Twitter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Metodos.conexion();

        int menu;

        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog("1.Cambiar estado \n 2.TimeLine \n 3.Buscar un twett \n 4.Mensaje"));
            switch (menu) {

                case 1:
                    Metodos.twittear(JOptionPane.showInputDialog(null, "Introducir el nuevo estado"));
                    break;
                case 2:
                    Metodos.lineaTiempo();
                    break;
                case 3:
                   Metodos.buscartwitt(JOptionPane.showInputDialog("Introduce el hastag"));
                    break;
                case 4:
                    Metodos.enviarMensaje(JOptionPane.showInputDialog("Introduce nombre destinatario"), JOptionPane.showInputDialog("Introduce el mensaje a enviar"));
                    break;

            }

        } while (menu!= 0);

    }
}
    
    

