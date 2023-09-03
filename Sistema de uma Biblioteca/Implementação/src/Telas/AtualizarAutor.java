/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Telas;
import Modelo.Autor;
import javax.swing.JOptionPane;

/**
 *
 * @author Elisa Veloso
 */
public class AtualizarAutor extends javax.swing.JFrame {
    private Autor autor;

    /**
     * Creates new form AtualizarAutor
     */
    public AtualizarAutor(Autor autor) {
        initComponents();
        this.autor = autor;
        jTextPaneNomeAtualizarAutor.setText(autor.get_nome());
        jTextPaneSobrenomeAtualizarAutor.setText(autor.get_sobrenome());
        jTextAreaBiografiaAtualizarAutor.setText(autor.get_biografia());
       this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelNomeAtualizarAutor = new javax.swing.JLabel();
        jLabelSobrenomeAtualizarAutor = new javax.swing.JLabel();
        jLabelBiografiaAtualizarAutor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneNomeAtualizarAutor = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPaneSobrenomeAtualizarAutor = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaBiografiaAtualizarAutor = new javax.swing.JTextArea();
        jButtonAtualizarAutor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelNomeAtualizarAutor.setText("Nome");

        jLabelSobrenomeAtualizarAutor.setText("Sobrenome");

        jLabelBiografiaAtualizarAutor.setText("Biografia");

        jScrollPane1.setViewportView(jTextPaneNomeAtualizarAutor);

        jScrollPane2.setViewportView(jTextPaneSobrenomeAtualizarAutor);

        jTextAreaBiografiaAtualizarAutor.setColumns(20);
        jTextAreaBiografiaAtualizarAutor.setRows(5);
        jScrollPane4.setViewportView(jTextAreaBiografiaAtualizarAutor);

        jButtonAtualizarAutor.setText("Atualizar");
        jButtonAtualizarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarAutorActionPerformed(evt);
            }
        });

        jLabel1.setText("Atualizar Autor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelSobrenomeAtualizarAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(jLabelBiografiaAtualizarAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabelNomeAtualizarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonAtualizarAutor)
                .addGap(143, 143, 143))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNomeAtualizarAutor)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSobrenomeAtualizarAutor)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBiografiaAtualizarAutor)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonAtualizarAutor)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtualizarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarAutorActionPerformed
        String novoNome = jTextPaneNomeAtualizarAutor.getText();
        String novoSobrenome = jTextPaneSobrenomeAtualizarAutor.getText();
        String novaBiografia = jTextAreaBiografiaAtualizarAutor.getText();
        
        this.autor.set_nome(novoNome);
        this.autor.set_sobrenome(novoSobrenome);
        this.autor.set_biografia(novaBiografia);
        
        JOptionPane.showMessageDialog(null, "Autor Atualizado!");
        this.setVisible(false);
        this.dispose();    }//GEN-LAST:event_jButtonAtualizarAutorActionPerformed

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
            java.util.logging.Logger.getLogger(AtualizarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AtualizarAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizarAutor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelBiografiaAtualizarAutor;
    private javax.swing.JLabel jLabelNomeAtualizarAutor;
    private javax.swing.JLabel jLabelSobrenomeAtualizarAutor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaBiografiaAtualizarAutor;
    private javax.swing.JTextPane jTextPaneNomeAtualizarAutor;
    private javax.swing.JTextPane jTextPaneSobrenomeAtualizarAutor;
    // End of variables declaration//GEN-END:variables
}
