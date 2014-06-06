/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.util.ArrayList;
import Game.Player;
import Game.CultistPlayer;
import Game.Napakalaki;
import Game.Treasure;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author fdavidcl
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel;
    private Napakalaki napakalakiModel;
    
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public void setNapakalaki(Napakalaki n) {
        napakalakiModel = n;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buyButton = new javax.swing.JButton();
        makeVisButton = new javax.swing.JButton();
        discardButton = new javax.swing.JButton();
        cultistPanel = new GUI.CultistView();
        dataPanel = new javax.swing.JPanel();
        playerLabel = new javax.swing.JLabel();
        levelLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        visibleText = new javax.swing.JLabel();
        hiddenText = new javax.swing.JLabel();
        hiddenNum = new javax.swing.JLabel();
        visibleNum = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(539, 500));

        buyButton.setFont(buyButton.getFont());
        buyButton.setText("Comprar niveles");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        makeVisButton.setFont(makeVisButton.getFont());
        makeVisButton.setText("Equipar tesoros");
        makeVisButton.setEnabled(false);
        makeVisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeVisButtonActionPerformed(evt);
            }
        });

        discardButton.setFont(discardButton.getFont());
        discardButton.setText("Descartar tesoros");
        discardButton.setEnabled(false);
        discardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discardButtonActionPerformed(evt);
            }
        });

        dataPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        playerLabel.setFont(playerLabel.getFont().deriveFont(playerLabel.getFont().getStyle() | java.awt.Font.BOLD, playerLabel.getFont().getSize()+7));
        playerLabel.setText("Name");

        levelLabel.setFont(levelLabel.getFont().deriveFont(levelLabel.getFont().getSize()+27f));
        levelLabel.setText("5");

        jLabel3.setText("nivel");

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerLabel)
                    .addComponent(levelLabel)
                    .addComponent(jLabel3))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerLabel)
                .addGap(18, 18, 18)
                .addComponent(levelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        visibleText.setText("tesoros equipados");

        hiddenText.setText("tesoros ocultos");

        hiddenNum.setText("3");

        visibleNum.setText("3");

        visibleTreasures.setPreferredSize(new java.awt.Dimension(540, 100));

        hiddenTreasures.setPreferredSize(new java.awt.Dimension(540, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visibleTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hiddenTreasures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cultistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(makeVisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(discardButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(visibleNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(visibleText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hiddenNum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hiddenText)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cultistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeVisButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(discardButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visibleText)
                    .addComponent(visibleNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hiddenText)
                    .addComponent(hiddenNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        /** Algo no funciona aquí, no subimos de nivel al comprarlos **/
        if (!napakalakiModel.buyLevels(getSelectedTreasures(visibleTreasures), 
            getSelectedTreasures(hiddenTreasures))) {
            JOptionPane.showMessageDialog(null, "No puedes comprar tantos niveles.");
        }
        
        redraw();
    }//GEN-LAST:event_buyButtonActionPerformed

    private void makeVisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeVisButtonActionPerformed
        ArrayList<Treasure> treasures = getSelectedTreasures(hiddenTreasures);
        
        for (Treasure t : treasures) {
            napakalakiModel.makeTreasureVisible(t);
        }
        
        redraw();
    }//GEN-LAST:event_makeVisButtonActionPerformed

    private void discardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discardButtonActionPerformed
        ArrayList<Treasure> treasures = getSelectedTreasures(visibleTreasures);
        
        for (Treasure t : treasures) {
            napakalakiModel.discardVisibleTreasure(t);
        }
        
        treasures = getSelectedTreasures(hiddenTreasures);
        
        for (Treasure t : treasures) {
            napakalakiModel.discardHiddenTreasure(t);
        }
        
        checkPendingBad();
        checkDeath();
        redraw();
    }//GEN-LAST:event_discardButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyButton;
    private GUI.CultistView cultistPanel;
    private javax.swing.JPanel dataPanel;
    private javax.swing.JButton discardButton;
    private javax.swing.JLabel hiddenNum;
    private javax.swing.JLabel hiddenText;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel levelLabel;
    private javax.swing.JButton makeVisButton;
    private javax.swing.JLabel playerLabel;
    private javax.swing.JLabel visibleNum;
    private javax.swing.JLabel visibleText;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables

    public void redraw() {
        playerLabel.setText(playerModel.getName());
        levelLabel.setText(Integer.toString(playerModel.getCombatLevel()));
        
        fillTreasurePanel(visibleTreasures, visibleNum, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasures, hiddenNum, playerModel.getHiddenTreasures());
        repaint();
        revalidate();
    }
    
    public void setPlayer(Player p){
        playerModel = p;
        buyButton.setEnabled(true);
        discardButton.setEnabled(false);
        makeVisButton.setEnabled(false);
        dataPanel.setBackground(Color.white);
        
        cultistPanel.setVisible(false);
        redraw();
    }
    
    public void setCultistPlayer(CultistPlayer p){
        setPlayer(p);
        cultistPanel.setCultist(p.getCultist());
        cultistPanel.setVisible(true);
        repaint();
    }
    
    public ArrayList<Treasure> getSelectedTreasures(javax.swing.JPanel p) {
        // Se recorren los tesoros que contiene el panel,
        // almacenando en un vector aquellos que están seleccionados.
        // Finalmente se devuelve dicho vector.
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        
        for (Component c : p.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
                output.add(tv.getTreasure());
        }
        
        return output;
    }
    
    public void fillTreasurePanel(javax.swing.JPanel p, javax.swing.JLabel num, ArrayList<Game.Treasure> treasures){
        p.removeAll();
        
        for (Game.Treasure t : treasures){
            TreasureView tview = new TreasureView();
            tview.setTreasure(t);
            tview.setVisible(true);
            p.add(tview);
        }
        
        num.setText(Integer.toString(treasures.size()));
        
        p.repaint();
        p.revalidate();
    }
    
    public void checkDeath() {
        if (playerModel.isDead()) {
            lockButtons(true);
            dataPanel.setBackground(Color.red);
        }
    }
    
    public void lockButtons(boolean lock) {
        if (lock) {
            buyButton.setEnabled(false);
            discardButton.setEnabled(false);
            makeVisButton.setEnabled(false);
        } else {
            discardButton.setEnabled(true);
            checkPendingBad();
        }
    }

    private void checkPendingBad() {
        buyButton.setEnabled(false);
        
        if (napakalakiModel.nextTurnAllowed()) {
            makeVisButton.setEnabled(true);
            dataPanel.setBackground(Color.white);
        } else {
            dataPanel.setBackground(Color.orange);
        }
    }

}
