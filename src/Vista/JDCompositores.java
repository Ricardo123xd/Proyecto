/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista;

import DAO.DAOException;
import DAO.DAOManager;
import DAOMySQL.MySQLDAOManager;
import Modelo.CancionCompositor;
import Modelo.Canciones;
import Modelo.Compositor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Ricardo
 */
public class JDCompositores extends javax.swing.JDialog {

    private DAOManager manager = null;
    //el modelo para nuestra tabla
    private CancionesTableModel model;
    //propiedad que modifica el ancho de la tabla
    TableColumnModel columnModel = null;
    //campos para almacenar los datos del formulario
    private int idCompositor;
    private String nombre;
    private int edad;

    /**
     * Creates new form JDCanciones
     */
    public JDCompositores(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.manager = new MySQLDAOManager();
        this.setLocationRelativeTo(this);
        this.setTitle("Gestion de Compositores");
        //inicializar tabla
        inicializarListaCanciones();

    }

    /**
     * Este metodo permite limpiar las cajas de texto y ubicar el focus en la
     * caja de texto del nombre
     */
    private void limpiarFormulario() {
        //asignmaos el string -1 a la caja de texto de idCompositor
        txtIdCompositor.setText("-1");

        //limpiamos las otras cajas de texto
        txtNombre.setText("");
        txtEdad.setText("");

        //ubicamos el focus en la caja de texto del nombre
        txtNombre.requestFocusInWindow();
    }//fin del metodo limpiarFormulario

    /**
     * valida los datos de entrada del formulario
     *
     * @return true si todos los datos son validados correctamente, false en
     * caso contrario
     */
    private boolean validar() {
        
        boolean validacion = false;
        idCompositor = Integer.parseInt(txtIdCompositor.getText());
        nombre = txtNombre.getText().trim();
        edad = Integer.parseInt(txtEdad.getText().trim());
        
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Especifica el nombre del compositor");
            txtNombre.requestFocusInWindow();
            return validacion = false;
        }
        if (txtEdad.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Especifica la edad del compositor");
            txtEdad.requestFocusInWindow();
            return validacion = false;
        }
        return true;
    }//fin del metodo validar

    /**
     * Imprime un mensaje de error personalizado para aquellos errores que son
     * producidos por el acceso a la base de datos
     *
     * @param ex objeto de tipo DAOException
     */
    private void imprimirMensajeDeErrorDAO(DAOException ex) {
        //si getMessage existe obtenemos su valor
        String mensajeError;

        try {
            mensajeError = ex.getCause().getMessage();
        } catch (NullPointerException error) {
            mensajeError = "";
        }

        JOptionPane.showMessageDialog(null, "Error: \n" + "Mensaje: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }//fin del metodo imprimirMensajeDeErrorDAO

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdCompositor = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtBuscarPorId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtIdCancion = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCanciones = new javax.swing.JTable();
        btnEliminarCancion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id. Compositor:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Edad:");

        txtIdCompositor.setText("-1");
        txtIdCompositor.setEnabled(false);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("Buscar entrada por:");

        jLabel6.setText("Id. Compositor:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Canciones del compositor"));

        jLabel7.setText("Agregar nueva cancion:");

        jLabel8.setText("(Escribe el id de la cancion)");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tblCanciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Cancion", "Nombre de la Cancion", "Fecha de Creacion", "Duracion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCanciones);

        btnEliminarCancion.setText("Eliminar Cancion del Autor");
        btnEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCancionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnEliminarCancion, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdCancion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarCancion)
                .addGap(228, 228, 228))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdCompositor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNuevo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminar))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIdCompositor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtBuscarPorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //llamamos al metodo limpiarFormulario
        limpiarFormulario();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //llamamos al metodo validar para ver si procede guardar los datos
        if (validar()) {
            //si idCompositor = -1 entonces insertamos el registro
            if (idCompositor == -1) {
                //llamamos al constructor para crear un objeto de Compositor
                Compositor miCompositor = new Compositor(nombre, edad);
                try {
                    
                    manager.getCompositorDAO().insertar(miCompositor);
                    txtIdCompositor.setText(Integer.toString(miCompositor.getIdCompositor()));
                    JOptionPane.showMessageDialog(null, "Los datos han sido guardados");
                } catch (DAOException ex) {
                    imprimirMensajeDeErrorDAO(ex);
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Formato incorrecto en alguno de los campos");

                }
            } else {//si es diferente de -1 quiere decir que se esta realizando una modificacion

                //llamamos al constructor para crear un objeto de tipo Compositor
                Compositor miCompositor = new Compositor(idCompositor, nombre, edad);
                try {
                    manager.getCompositorDAO().modificar(miCompositor);
                    JOptionPane.showMessageDialog(null, "Los cambios han sido guardados");
                } catch (DAOException ex) {
                    imprimirMensajeDeErrorDAO(ex);
                }
            }//fin del else
        }//fin del if validar
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //solo se puede eliminar si el compositor es diferente de -1
        if (!txtIdCompositor.getText().equals("-1")) {
            //obtenemos el idCompositor
            int idCompositor = Integer.parseInt(txtIdCompositor.getText());
            //preguntar al usuario si desea eliminar al compositor
            int respuesta = JOptionPane.showConfirmDialog(null, "Deseas eliminar al compositor con id = "
                    + idCompositor + "?", "Confirmar", 0);

            if (respuesta == 0) {
                try {
                    //eliminamos el compositor
                    manager.getCompositorDAO().eliminar(idCompositor);
                    //si no, ocurre una excepción
                    JOptionPane.showMessageDialog(null, "El compositor ah sido eliminado");
                } catch (DAOException ex) {
                    imprimirMensajeDeErrorDAO(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Busca un compositor para poder eliminarlo");
            }
            //si el usuario no especifica un idCompositor 
        } else {
            JOptionPane.showMessageDialog(null, "Busca un compositor para poder eliminarlo");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            //obtenemos el idCompositor a buscar
            int idABuscar = (Integer) Integer.parseInt(txtBuscarPorId.getText());

            //obtenemos los datos de la cancion y lo asignamos al objeto miCancion
            Compositor miCompositor = manager.getCompositorDAO().obtener(idABuscar);

            //mostramos los datos en a caja de texto
            txtIdCompositor.setText(Integer.toString(miCompositor.getIdCompositor()));
            txtNombre.setText(miCompositor.getNombre());
            txtEdad.setText(Integer.toString(miCompositor.getEdad()));
            //actualizamos la lista de las canciones
            actualizarListaCanciones(miCompositor.getIdCompositor());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Especifica un numero entero", "Error",
                    JOptionPane.ERROR_MESSAGE);
            txtBuscarPorId.requestFocusInWindow();
            txtBuscarPorId.selectAll();
        } catch (DAOException ex) {
            imprimirMensajeDeErrorDAO(ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCancionActionPerformed
        //si la tabla tiene contenido entonces
        if (tblCanciones.getRowCount() > 0) {
            //obtenemos el valor de idCancion
            int idCancion;
            idCancion = Integer.parseInt(tblCanciones.getValueAt(tblCanciones.getSelectedRow(),
                    0).toString());
            //mandamos mensaje de confirmacion si el usuario quiere borrarlo
            if (JOptionPane.showConfirmDialog(rootPane, "Seguro que quieres borrar el idCancion: " + idCancion
                    + "\n vinculado con el compositor activo?",
                    "Borrar idCancion vinculado al compositor",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                //obtenemos el idCompositor
                int idCompositor = Integer.parseInt(txtIdCompositor.getText());
                //creamos un objeto tipo CancionCompositor
                CancionCompositor cancionCompositor = new CancionCompositor(idCompositor, idCancion);

                try {
                    //eliminamos la cancion
                    manager.getCancionCompositorDAO().eliminar(cancionCompositor);
                    actualizarListaCanciones(idCompositor);

                    JOptionPane.showMessageDialog(null, "Se ah eliminado la idCancion con exito");
                } catch (DAOException ex) {
                    imprimirMensajeDeErrorDAO(ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una canción para eliminarla");
        }
    }//GEN-LAST:event_btnEliminarCancionActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        //si el texto es diferente de -1 entonces  obtenemos la cancion
        if (!txtIdCompositor.getText().equals("-1")) {
            //obtener idCompositor
            int idCompositor = Integer.parseInt(txtIdCompositor.getText());
            //si el texto idCancion no esta vacío obtenemos la idCancion
            if (!txtIdCancion.getText().trim().equals("")) {
                int idCancion = Integer.parseInt(txtIdCancion.getText());

                try {
                    //creamos un objeto tipo cancion para obtener los datos
                    Canciones miCancion = manager.getCancionDAO().obtener(idCancion);
                    //creamos un objeto de tipo CancionCompositor
                    CancionCompositor cancionCompositor = new CancionCompositor(idCancion, idCompositor);
                    //insertamos la nueva cancion
                    manager.getCancionCompositorDAO().insertar(cancionCompositor);
                    //actualizamos la lista
                    actualizarListaCanciones(idCompositor);

                    JOptionPane.showMessageDialog(null, "Se han guardado los datos");
                } catch (DAOException ex) {
                    imprimirMensajeDeErrorDAO(ex);
                    txtIdCancion.requestFocus();
                    txtIdCancion.selectAll();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Especifica el id de la cancion");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Busca primero el compositor de la cancion");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(JDCompositores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDCompositores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDCompositores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDCompositores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDCompositores dialog = new JDCompositores(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarCancion;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCanciones;
    private javax.swing.JTextField txtBuscarPorId;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtIdCancion;
    private javax.swing.JTextField txtIdCompositor;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void actualizarListaCanciones(int idCompositor) throws DAOException {
        model.updateModel(idCompositor);

        model.fireTableDataChanged();

        setJTableColumnsWidth(tblCanciones, 40, 480, 260, 70, 30);
    }

    private void inicializarListaCanciones() {
        model = new CancionesTableModel(manager.getCancionCompositorDAO());

        //asignamos el modelo sin llamar al metodo actualizar ya que al iniciar el idCompositor es -1
        tblCanciones.setModel(model);

        //redimensionar celdas
        setJTableColumnsWidth(tblCanciones, 40, 480, 260, 70, 30);
    }

    private void setJTableColumnsWidth(JTable table, int tablePreferredWidth, double... percentages) {
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int) (tablePreferredWidth * (percentages[i] / total)));
        }
    }
}
