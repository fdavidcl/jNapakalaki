/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Game.Cultist;

/**
 *
 * @author fdavidcl
 */
public class CultistView extends javax.swing.JPanel {
    private Cultist cultistModel;
    
    /**
     * Creates new form CultistView
     */
    public CultistView() {
        initComponents();
    }
    
    public void setCultist(Cultist carta) {
        cultistModel = carta;
        basicLabel.setText("+" + Integer.toString(cultistModel.getBasicValue()));
        specialLabel.setText("+" + Integer.toString(cultistModel.getSpecialValue()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        basicLabel = new javax.swing.JLabel();
        explainLabel = new javax.swing.JLabel();
        specialLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setFont(nameLabel.getFont().deriveFont(nameLabel.getFont().getStyle() | java.awt.Font.BOLD, nameLabel.getFont().getSize()+7));
        nameLabel.setText("Cultist");

        basicLabel.setFont(basicLabel.getFont().deriveFont(basicLabel.getFont().getSize()+27f));
        basicLabel.setText("+2");

        explainLabel.setText("for each cultist in game");

        specialLabel.setText("+4");

        totalLabel.setText("Total:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(basicLabel)
                    .addComponent(explainLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(totalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specialLabel)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addGap(18, 18, 18)
                .addComponent(basicLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(explainLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(specialLabel)
                    .addComponent(totalLabel))
                .addContainerGap(103, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel basicLabel;
    private javax.swing.JLabel explainLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel specialLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
