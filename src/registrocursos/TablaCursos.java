package registrocursos;

import java.awt.Component;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TablaCursos extends javax.swing.JFrame {
    private static Connection con;
    private EstudianteSQL est;
    private CursoSQL cur;
    private EstudianteTableModel model;
    private Estudiante estudiante;
    private FormularioEstudiante formulario;
    private ArrayList<Curso> listCursos;
    
    public TablaCursos(Connection con, Component c) {
        initComponents();
        
        this.setLocationRelativeTo(c);
        
        this.con = con;
        
        est = new EstudianteSQL(con);
        cur = new CursoSQL(con);
        
        listCursos = cur.getAll();
        
        model = new EstudianteTableModel(est, cur);
        getData();
        
        tablaEstudiantes.setModel(model);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstudiantes = new javax.swing.JTable();
        btnModificar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaEstudiantes.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        tablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaEstudiantes.setRowHeight(25);
        jScrollPane1.setViewportView(tablaEstudiantes);

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnRemover.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRemover)
                .addGap(138, 138, 138))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnRemover))
                .addGap(76, 76, 76))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/registrocursos/images.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        
    private Estudiante getSelectedList() {
        estudiante = (Estudiante) model.getValue(tablaEstudiantes.getSelectedRow());
        return estudiante;
    }
    
    private void getData() {
        model.updateModel();
        model.fireTableDataChanged();
    }
    
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        estudiante = getSelectedList();
        
        //**
        formulario = new FormularioEstudiante(this, true, con);
        formulario.setId(estudiante.getId());
        formulario.setNombre(estudiante.getNombre());
        formulario.setCarrera(estudiante.getCarrera());
        formulario.setSemestre(estudiante.getSemestre());
        formulario.setVisible(true);
        
        int index = -1;
        for(Curso c: listCursos) {
            if(c.getId() == estudiante.getCurso())
                index++;
        }
        formulario.setCurso(index);
        //**
        
        System.out.println("est:" + estudiante);
        if(!formulario.estaActivo()) {
            estudiante = formulario.getEstudiante();
            
            System.out.println("EST:"+estudiante);
            
            est.modificar(estudiante);
            JOptionPane.showMessageDialog(this, "Se ha modificado el estudiante " + estudiante.getNombre());
            getData();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        estudiante = getSelectedList();
        
        
        String msg = "Estas seguro que deseas eliminar al estudiante: \'" + estudiante.getNombre() + "\'?";
        int op = JOptionPane.showConfirmDialog(this, msg, "Confirm", JOptionPane.CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(op == JOptionPane.YES_OPTION) {
            est.borrar(estudiante);
            getData();
        }
        
        
    }//GEN-LAST:event_btnRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEstudiantes;
    // End of variables declaration//GEN-END:variables
}
