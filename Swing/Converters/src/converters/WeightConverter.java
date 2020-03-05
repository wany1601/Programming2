/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author cstuser
 */
public class WeightConverter extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public WeightConverter() {
        initComponents();
        ImageIcon icon = new ImageIcon("weight3.png");
        imageLabel.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modeButtonGroup = new javax.swing.ButtonGroup();
        titleLabel = new javax.swing.JLabel();
        kgLabel = new javax.swing.JLabel();
        equalLabel = new javax.swing.JLabel();
        lbLabel = new javax.swing.JLabel();
        kgTF = new javax.swing.JTextField();
        lbTF = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        kg2lbRB = new javax.swing.JRadioButton();
        lb2kgRB = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        historyArea = new javax.swing.JTextArea();
        inputSlider = new javax.swing.JSlider();
        imageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Weight Converter");

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleLabel.setText("Weight Converter");

        kgLabel.setText("KG");

        equalLabel.setText("=");

        lbLabel.setText("LB");

        kgTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                kgTFKeyReleased(evt);
            }
        });

        lbTF.setEditable(false);
        lbTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbTFActionPerformed(evt);
            }
        });
        lbTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbTFKeyReleased(evt);
            }
        });

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        modeButtonGroup.add(kg2lbRB);
        kg2lbRB.setSelected(true);
        kg2lbRB.setText("KG to LB");
        kg2lbRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kg2lbRBActionPerformed(evt);
            }
        });

        modeButtonGroup.add(lb2kgRB);
        lb2kgRB.setText("LB to KG");
        lb2kgRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lb2kgRBActionPerformed(evt);
            }
        });

        historyArea.setEditable(false);
        historyArea.setColumns(20);
        historyArea.setRows(5);
        jScrollPane2.setViewportView(historyArea);

        inputSlider.setMajorTickSpacing(25);
        inputSlider.setMinorTickSpacing(5);
        inputSlider.setPaintLabels(true);
        inputSlider.setPaintTicks(true);
        inputSlider.setValue(10);
        inputSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                inputSliderStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inputSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(kg2lbRB)
                                                .addComponent(lb2kgRB))
                                            .addGap(64, 64, 64)
                                            .addComponent(submitButton))
                                        .addComponent(titleLabel))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(kgTF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kgLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(equalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbLabel)))
                        .addGap(44, 44, 44)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(kgLabel)
                                    .addComponent(equalLabel)
                                    .addComponent(lbLabel)
                                    .addComponent(kgTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(inputSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(kg2lbRB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb2kgRB)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTFActionPerformed

    private void convertToLb() {
        if (!isInputValid(kgTF.getText()))
            return;
        
        double source = Double.parseDouble(kgTF.getText());
        double result = source * 2.2;
        lbTF.setText(String.format("%.2f", result));
        
        String message = String.format("%.2f kg -> %.2f lb\n", source, result);
        historyArea.setText(historyArea.getText() + message);
    }
    
    private boolean isInputValid(String input) {
        String pattern = "-?\\d+.?\\d*";
        return input.matches(pattern);
    }
    
    private void converToKg() {
        if (!isInputValid(lbTF.getText()))
            return;
        
        double source = Double.parseDouble(lbTF.getText());
        double result = source / 2.2;
        kgTF.setText(String.format("%.2f", result));
        
        String message = String.format("%.2f lb -> %.2f kg\n", source, result);
        historyArea.setText(historyArea.getText() + message);
    }
    

    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (kg2lbRB.isSelected()) 
            convertToLb();
        else 
            converToKg();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void kgTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kgTFKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_SPACE) {
            convertToLb();
        }
    }//GEN-LAST:event_kgTFKeyReleased

    private void kg2lbRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kg2lbRBActionPerformed
        kgTF.setEditable(true);
        lbTF.setEditable(false);
        kgTF.setText("");
        lbTF.setText("");
    }//GEN-LAST:event_kg2lbRBActionPerformed

    private void lb2kgRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lb2kgRBActionPerformed
        kgTF.setEditable(false);
        lbTF.setEditable(true);
        kgTF.setText("");
        lbTF.setText("");
    }//GEN-LAST:event_lb2kgRBActionPerformed

    private void lbTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbTFKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_SPACE) {
            converToKg();
        }
    }//GEN-LAST:event_lbTFKeyReleased

    private void inputSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_inputSliderStateChanged
        if (kg2lbRB.isSelected())
            kgTF.setText("" + inputSlider.getValue());
        else
            lbTF.setText("" + inputSlider.getValue());
    }//GEN-LAST:event_inputSliderStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel equalLabel;
    private javax.swing.JTextArea historyArea;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JSlider inputSlider;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton kg2lbRB;
    private javax.swing.JLabel kgLabel;
    private javax.swing.JTextField kgTF;
    private javax.swing.JRadioButton lb2kgRB;
    private javax.swing.JLabel lbLabel;
    private javax.swing.JTextField lbTF;
    private javax.swing.ButtonGroup modeButtonGroup;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
