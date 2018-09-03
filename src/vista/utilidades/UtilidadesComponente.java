/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package vista.utilidades;

import controlador.utilidades.Utilidades;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import java.util.regex.Matcher;
/**
 *
 * @author Programacion I 2B
 */
public class UtilidadesComponente {

    public static boolean mostrarError(JComponent componente, String mensaje, char tipo) {
        boolean band = true;
        switch (tipo) {
            case 'r':
                if (componente instanceof JTextComponent) {
                    JTextComponent txt = (JTextComponent) componente;
                    if (Utilidades.isEmpty(txt.getText())) {
                        componente.setBackground(Color.red);
                        componente.setToolTipText(mensaje);
                    } else {
                        componente.setBackground(Color.white);
                        componente.setToolTipText(null);
                        band = false;
                    }
                }
                
        }
        return band;
    }

    public static void mensajeError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeOk(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean validarCampoNumericos(JTextComponent campo, int max) {
        if (((campo.getText().charAt(0) < '0') || campo.getText().charAt(0) > '9') || (campo.getText().trim().length() > max)) {
            Toolkit.getDefaultToolkit().beep();
            return false;
        } else {
//            validarCampo(campo);
            return true;
        }
    }
    public static void validarEmail(String email){
    Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            
        } else {
           mensajeError("Error","El email ingresado es incorrecto"); 
        }
    }
    
    public static boolean validarCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) 
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {

                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            mensajeError("Error","Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            mensajeError("Error","La cedula ingresada es incorrecta");
        }
        return cedulaCorrecta;
    }
     
    
    public static void validarCampo(JTextComponent campo) {
        String mensajeError = "";

        if (campo.getText() == null || campo.getText().trim().length() == 0) {
            mensajeError += "¡Campo requerido!\n";
        }

        if (mensajeError.length() == 0) {
            //return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos no válidos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, revise los siguiente campos: \n" + mensajeError);
            alert.showAndWait();
            //return false;
        }
    }

}
