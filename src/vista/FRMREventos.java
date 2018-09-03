/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.dao.MateriaDao;
import controlador.servicio.EventoServicio;
import controlador.servicio.MateriaServicio;
import controlador.servicio.PersonaServicio;
import controlador.utilidades.Sesion;
import vista.tablas.ModeloTablaEventos;
import vista.tablas.ModeloTablaMateria;
import vista.utilidades.UtilidadesComponente;

/**
 *
 * @author Jean Pierre
 */
public class FRMREventos extends javax.swing.JDialog {

    private PersonaServicio ps = new PersonaServicio();
    private MateriaServicio ms = new MateriaServicio();
    private EventoServicio es = new EventoServicio();
    private ModeloTablaMateria modelo = new ModeloTablaMateria();
    private ModeloTablaEventos modelos = new ModeloTablaEventos();
    
    /**
     * Creates new form FRMREventos
     */
    public FRMREventos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarTabla();
    }
    private void cargarTabla() {
        modelo.setListaMat(ms.listarMateriaNombre(Sesion.getCuenta().getPersona().getId()));
        tbl_Materia.setModel(modelo);
        tbl_Materia.updateUI();
    }
    private void cargarTablaEventos(){
        modelos.setListaEven(modelo.getValueAt(tbl_Materia.getSelectedRow()).getListaEventos());
        tbl_Evento.setModel(modelos);
        tbl_Evento.updateUI();  
    }   
    private void cargarObjeto(){        
        es.getEventos().setDescripcion(txt_des.getText());      
        es.getEventos().setTipo(cbx_tipoEvento.getSelectedItem().toString());
        es.getEventos().setFechaInicio(data_I.getDate());
        es.getEventos().setFechaFinalizacion(data_F.getDate());
        es.getEventos().setMateria(modelo.getValueAt(tbl_Materia.getSelectedRow()));
    }
    private void limpiar() {
        es.fijarEventos(null);
        cargarTablaEventos();
        txt_des.setText("");
        data_I.setDate(null);
        data_F.setDate(null);
        cbx_tipoEvento.setSelectedIndex(0);
    }
    private void cargarVistaM(){
        int fila = tbl_Materia.getSelectedRow();
        if(fila >= 0){
            String mensaje = "Se requiere este campo";
            if(!UtilidadesComponente.mostrarError(txt_des, mensaje, 'r') ){
                cargarObjeto();
                
                if(es.getEventos().getId() != null) {
                    if(es.guardar()) {
                        UtilidadesComponente.mensajeOk("Se ha modificado correctamente","Ok");
                        limpiar();
                        cargarTablaEventos();
                    } else {
                        UtilidadesComponente.mensajeError("Error", "No se pudo modificar");
                    }
                } else {
                    if(es.guardar()) {
                        UtilidadesComponente.mensajeOk("OK", "Se ha guardado correctamente");
                        limpiar();
                        cargarTablaEventos();
                    } else {
                        UtilidadesComponente.mensajeError("Error", "No se pudo guardar");
                    }
                }
            }else{
                System.out.println("Vacio");
            }
        }else{
            UtilidadesComponente.mensajeError("Error", "Cargue Objeto");
        }
    }
    private void cargarVistaEvento() {
        int fila = tbl_Evento.getSelectedRow();
        if(fila >= 0 ) {
            
            es.fijarEventos(modelos.getListaEven().get(fila));
            txt_des.setText(es.getEventos().getDescripcion());
            data_F.setDate(es.getEventos().getFechaFinalizacion());
            data_I.setDate(es.getEventos().getFechaInicio());
            cbx_tipoEvento.setSelectedItem(es.getEventos().getTipo());       
        } else {
            UtilidadesComponente.mensajeError("Error", "Llene todoss los campos");
        }
    }
    private void guardar(){
        String mensaje = "Se requiere este campo";
            if(!UtilidadesComponente.mostrarError(txt_des, mensaje, 'r') &&
                !UtilidadesComponente.mostrarError(data_F, mensaje, 'r') && 
                !UtilidadesComponente.mostrarError(data_I, mensaje, 'r') &&
                !UtilidadesComponente.mostrarError(cbx_tipoEvento, mensaje, 'r')){
            cargarObjeto();
            if(es.getEventos().getId() != null) {
                if(es.guardar()) {
                    UtilidadesComponente.mensajeOk("Se ha modificado correctamente","Ok");
                    limpiar();
                } else {
                        UtilidadesComponente.mensajeError("Error", "No se pudo modificar");
                    }
            } else {
                if(es.guardar()) {
                    UtilidadesComponente.mensajeOk("OK", "Se ha guardado correctamente");
                    limpiar();
                } else {
                    UtilidadesComponente.mensajeError("Error", "No se pudo guardar");
                }
            }
        }
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Materia = new javax.swing.JTable();
        btn_registar = new org.edisoncor.gui.button.ButtonColoredAction();
        btn_Editar = new org.edisoncor.gui.button.ButtonColoredAction();
        panel1 = new org.edisoncor.gui.panel.Panel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_des = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cbx_tipoEvento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        data_I = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        data_F = new com.toedter.calendar.JDateChooser();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Evento = new javax.swing.JTable();
        btn_Salir = new org.edisoncor.gui.button.ButtonColoredAction();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro Eventos.");
        setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        getContentPane().setLayout(null);

        panelNice1.setBackground(new java.awt.Color(0, 0, 0));
        panelNice1.setLayout(null);

        panelCurves1.setLayout(null);

        tbl_Materia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Materia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_MateriaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Materia);

        panelCurves1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 660, 100);

        btn_registar.setBackground(new java.awt.Color(0, 51, 0));
        btn_registar.setText("Registrar Evento");
        btn_registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registarActionPerformed(evt);
            }
        });
        panelCurves1.add(btn_registar);
        btn_registar.setBounds(540, 360, 140, 30);

        btn_Editar.setBackground(new java.awt.Color(0, 51, 0));
        btn_Editar.setText("Editar");
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });
        panelCurves1.add(btn_Editar);
        btn_Editar.setBounds(410, 540, 130, 30);

        panel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/fondo.jpg"))); // NOI18N
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(102, 0, 0));
        jLabel2.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Descripcion");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 30));

        txt_des.setColumns(20);
        txt_des.setRows(5);
        jScrollPane2.setViewportView(txt_des);

        panel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 230, 80));

        jLabel4.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tipo de Evento");
        panel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 150, 30));

        cbx_tipoEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Deberes", "Talleres", "Examanes" }));
        panel1.add(cbx_tipoEvento, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 210, 30));

        jLabel3.setBackground(new java.awt.Color(102, 0, 0));
        jLabel3.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de inicio.");
        panel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 130, 30));
        panel1.add(data_I, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 210, 30));

        jLabel1.setBackground(new java.awt.Color(102, 0, 0));
        jLabel1.setFont(new java.awt.Font("Georgia", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Fecha de Finalizacion");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 150, 30));
        panel1.add(data_F, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 210, 30));

        panelCurves1.add(panel1);
        panel1.setBounds(20, 170, 650, 180);

        tbl_Evento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbl_Evento);

        panelCurves1.add(jScrollPane3);
        jScrollPane3.setBounds(20, 420, 660, 110);

        btn_Salir.setBackground(new java.awt.Color(0, 51, 0));
        btn_Salir.setText("Salir");
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        panelCurves1.add(btn_Salir);
        btn_Salir.setBounds(550, 540, 130, 30);

        panelNice1.add(panelCurves1);
        panelCurves1.setBounds(0, 0, 710, 650);

        getContentPane().add(panelNice1);
        panelNice1.setBounds(-6, 0, 710, 670);

        setSize(new java.awt.Dimension(716, 692));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_MateriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MateriaMouseClicked
        if (evt.getClickCount()>=2){
            cargarTablaEventos();
        }// TODO add your handling code here:
    }//GEN-LAST:event_tbl_MateriaMouseClicked

    private void btn_registarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registarActionPerformed
        cargarVistaM();           // TODO add your handling code here:
    }//GEN-LAST:event_btn_registarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        cargarVistaEvento();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed
        dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_btn_SalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FRMREventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRMREventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRMREventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRMREventos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FRMREventos dialog = new FRMREventos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonColoredAction btn_Editar;
    private org.edisoncor.gui.button.ButtonColoredAction btn_Salir;
    private org.edisoncor.gui.button.ButtonColoredAction btn_registar;
    private javax.swing.JComboBox<String> cbx_tipoEvento;
    private com.toedter.calendar.JDateChooser data_F;
    private com.toedter.calendar.JDateChooser data_I;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.edisoncor.gui.panel.Panel panel1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelNice panelNice1;
    private javax.swing.JTable tbl_Evento;
    private javax.swing.JTable tbl_Materia;
    private javax.swing.JTextArea txt_des;
    // End of variables declaration//GEN-END:variables
}
