/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Game.Prize;

/**
 *
 * @author fdavidcl
 */
public class PrizeView extends javax.swing.JPanel {
    private Prize prizeModel;
    
    /**
     * Creates new form PrizeView
     */
    public PrizeView() {
        initComponents();
    }
    
    public void setPrize(Prize p) {
        prizeModel = p;
        treasureNum.setText(Integer.toString(prizeModel.getTreasures()));
        levelNum.setText(Integer.toString(prizeModel.getLevels()));
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treasureNum = new javax.swing.JLabel();
        levelNum = new javax.swing.JLabel();
        treasureText = new javax.swing.JLabel();
        levelText = new javax.swing.JLabel();

        treasureNum.setFont(treasureNum.getFont());
        treasureNum.setText("4");

        levelNum.setFont(levelNum.getFont());
        levelNum.setText("1");

        treasureText.setFont(treasureText.getFont());
        treasureText.setText("treasures");

        levelText.setFont(levelText.getFont());
        levelText.setText("levels");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(treasureNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(treasureText))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(levelNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(levelText)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(treasureNum)
                    .addComponent(treasureText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(levelNum)
                    .addComponent(levelText))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel levelNum;
    private javax.swing.JLabel levelText;
    private javax.swing.JLabel treasureNum;
    private javax.swing.JLabel treasureText;
    // End of variables declaration//GEN-END:variables
}
