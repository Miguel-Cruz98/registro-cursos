package registrocursos;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegistroCursos extends javax.swing.JFrame {

    private static Connection con;
    private EstudianteSQL est;
    private CursoSQL cur;
    private ArrayList<Curso> listCursos;
    private TablaCursos frame2;
    
    public RegistroCursos(Connection con) {
        initComponents();
        this.con = con;
        
        est = new EstudianteSQL(con);
        cur = new CursoSQL(con);
        
        listCursos = cur.getAll();
        
        cboCursos.removeAllItems();
        
        for(Curso c: listCursos) {
            cboCursos.addItem(c.getNombre());
        }
        
        setPlaceholder(txtMatricula, "Matricula");
        setPlaceholder(txtNombre, "Nombre");
        setPlaceholder(txtCarrera,"Carrera");
        setPlaceholder(txtSemestre, "Semestre");
    }
    
    public void clearTextFields() {
        setPlaceholder(txtNombre, "Nombre");
        setPlaceholder(txtCarrera,"Carrera");
        setPlaceholder(txtSemestre, "Semestre");
        cboCursos.setSelectedIndex(0);
        
        txtMatricula.setText("");
        txtMatricula.requestFocus();
    }
    
    public void setPlaceholder(JTextField textField, String text) {
        textField.setText(text);
        textField.setForeground(Color.decode("#b9b9b9"));
        textField.setFont(new Font("Dialog", Font.ITALIC + Font.BOLD, 16));
    }
    
    public void removePlaceholder(JTextField textField) {
        textField.setText("");
        textField.setForeground(Color.black);
        textField.setFont(new Font("Dialog", Font.BOLD, 16));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtMatricula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCarrera = new javax.swing.JTextField();
        cboCursos = new javax.swing.JComboBox<>();
        txtSemestre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnConsultar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMatricula.setForeground(new java.awt.Color(153, 153, 153));
        txtMatricula.setText("Matricula");
        txtMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMatriculaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatriculaFocusLost(evt);
            }
        });
        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Nombre");
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCarrera.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtCarrera.setForeground(new java.awt.Color(153, 153, 153));
        txtCarrera.setText("Carrera");
        txtCarrera.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCarreraFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCarreraFocusLost(evt);
            }
        });
        txtCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarreraActionPerformed(evt);
            }
        });

        cboCursos.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        cboCursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Programacion Basica", "Programacion Intermedia", "Programacion Avanzada", "Robotica", "Electronica", " " }));
        cboCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCursosActionPerformed(evt);
            }
        });

        txtSemestre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSemestre.setForeground(new java.awt.Color(153, 153, 153));
        txtSemestre.setText("Semestre");
        txtSemestre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSemestreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSemestreFocusLost(evt);
            }
        });
        txtSemestre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSemestreActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel2.setText("Cursos: ");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrocursos/ITNL.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel4.setText("Registro para Cursos");

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4)
                            .addGap(421, 421, 421))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(15, 15, 15)
                                    .addComponent(cboCursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(107, 107, 107)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btnAgregar)
                        .addGap(176, 176, 176)
                        .addComponent(btnConsultar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboCursos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnConsultar))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrocursos/images.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cboCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCursosActionPerformed

    private void txtCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarreraActionPerformed

    private void txtSemestreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSemestreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSemestreActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        frame2 = new TablaCursos(con, this);
        frame2.setVisible(true);
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int id = Integer.parseInt(txtMatricula.getText());
        String nombre = txtNombre.getText();
        String carrera = txtCarrera.getText();
        int semestre = Integer.parseInt(txtSemestre.getText());
        int indexCurso = cboCursos.getSelectedIndex();
        int curso = listCursos.get(indexCurso).getId();
        
        Estudiante e = new Estudiante(id, nombre, carrera, semestre, curso);
        
        est.insertar(e);
        JOptionPane.showMessageDialog(this, "Se ha agregado el estudiante " + nombre);
        
        
        clearTextFields();
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtMatriculaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatriculaFocusGained
        if(txtMatricula.getText().equals("Matricula"))
            removePlaceholder(txtMatricula);
    }//GEN-LAST:event_txtMatriculaFocusGained

    private void txtMatriculaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatriculaFocusLost
        if(txtMatricula.getText().equals("")) {
            setPlaceholder(txtMatricula, "Matricula");
        }
    }//GEN-LAST:event_txtMatriculaFocusLost

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if(txtNombre.getText().equals("Nombre"))
            removePlaceholder(txtNombre);
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if(txtNombre.getText().equals("")) {
            setPlaceholder(txtNombre, "Nombre");
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtCarreraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCarreraFocusGained
        if(txtCarrera.getText().equals("Carrera"))
            removePlaceholder(txtCarrera);
    }//GEN-LAST:event_txtCarreraFocusGained

    private void txtCarreraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCarreraFocusLost
        if(txtCarrera.getText().equals("")) {
            setPlaceholder(txtCarrera, "Carrera");
        }
    }//GEN-LAST:event_txtCarreraFocusLost

    private void txtSemestreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSemestreFocusGained
        if(txtSemestre.getText().equals("Semestre"))
            removePlaceholder(txtSemestre);
    }//GEN-LAST:event_txtSemestreFocusGained

    private void txtSemestreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSemestreFocusLost
        if(txtSemestre.getText().equals("")) {
            setPlaceholder(txtSemestre, "Semestre");
        }
    }//GEN-LAST:event_txtSemestreFocusLost

    public static void main(String args[]) {
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro_cursos", "root", "");
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new RegistroCursos(con).setVisible(true);
                }
            });
        }
        catch (SQLException ex) {
            Logger.getLogger(RegistroCursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JComboBox<String> cboCursos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSemestre;
    // End of variables declaration//GEN-END:variables
}
