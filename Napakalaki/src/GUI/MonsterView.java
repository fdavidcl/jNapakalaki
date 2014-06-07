/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Game.Monster;

/**
 *
 * @author fdavidcl
 */
public class MonsterView extends javax.swing.JPanel {
    private Monster monsterModel;
    
    /**
     * Creates new form MonsterView
     */
    public MonsterView() {
        initComponents();
    }
    
    public void setMonster(Monster m) {
        monsterModel = m;
        
        nameLabel.setText(monsterModel.getName());
        levelLabel.setText(Integer.toString(monsterModel.getLevel()));
        int bonus = monsterModel.getSpecialValue() - monsterModel.getBasicValue();
        String mas = bonus >= 0 ? "+" : "";
        bonusSectarios.setText(mas + bonus + " contra sectarios");
        prizePanel.setPrize(monsterModel.getPrize());
        badPanel.setBad(monsterModel.getBadConsequence());
        
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

        prizeView1 = new GUI.PrizeView();
        badPanel = new GUI.BadConsequenceView();
        prizePanel = new GUI.PrizeView();
        nameLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        bonusSectarios = new javax.swing.JLabel();

        javax.swing.GroupLayout prizeView1Layout = new javax.swing.GroupLayout(prizeView1);
        prizeView1.setLayout(prizeView1Layout);
        prizeView1Layout.setHorizontalGroup(
            prizeView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        prizeView1Layout.setVerticalGroup(
            prizeView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nameLabel.setFont(nameLabel.getFont().deriveFont(nameLabel.getFont().getStyle() | java.awt.Font.BOLD, nameLabel.getFont().getSize()+7));
        nameLabel.setText("Nombre");

        levelLabel.setFont(levelLabel.getFont().deriveFont(levelLabel.getFont().getSize()+27f));
        levelLabel.setText("24");

        bonusSectarios.setFont(bonusSectarios.getFont());
        bonusSectarios.setText("-2 contra sectarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(badPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(levelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(prizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bonusSectarios))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(prizePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(levelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bonusSectarios)
                .addGap(9, 9, 9)
                .addComponent(badPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.BadConsequenceView badPanel;
    private javax.swing.JLabel bonusSectarios;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JLabel nameLabel;
    private GUI.PrizeView prizePanel;
    private GUI.PrizeView prizeView1;
    // End of variables declaration//GEN-END:variables
}
