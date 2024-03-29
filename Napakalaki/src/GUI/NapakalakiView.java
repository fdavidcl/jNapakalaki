/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Game.CombatResult;
import Game.CultistPlayer;
import Game.Napakalaki;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author fdavidcl
 */
public class NapakalakiView extends javax.swing.JFrame {
    private Napakalaki napakalakiModel;
    
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        // Establecemos una apariencia nativa
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NapakalakiView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NapakalakiView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NapakalakiView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NapakalakiView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        combatButton = new javax.swing.JButton();
        nTurnButton = new javax.swing.JButton();
        playerPanel = new GUI.PlayerView();
        monsterPanel = new GUI.MonsterView();
        jScrollPane1 = new javax.swing.JScrollPane();
        combatText = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 20, 20));
        setMinimumSize(new java.awt.Dimension(400, 300));

        combatButton.setFont(combatButton.getFont());
        combatButton.setText("Combatir");
        combatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combatButtonActionPerformed(evt);
            }
        });

        nTurnButton.setText("Siguiente turno");
        nTurnButton.setEnabled(false);
        nTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nTurnButtonActionPerformed(evt);
            }
        });

        combatText.setColumns(20);
        combatText.setLineWrap(true);
        combatText.setRows(5);
        combatText.setFocusable(false);
        jScrollPane1.setViewportView(combatText);

        closeButton.setText("Salir");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(combatButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(monsterPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nTurnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(closeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(monsterPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(closeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nTurnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nTurnButtonActionPerformed
        if (napakalakiModel.nextTurn()) {
            newTurn();
        } else {
            // Todavía queda el mal rollo pendiente
            JOptionPane.showMessageDialog(null, "Aún no puedes pasar el turno. Termina de cumplir el mal rollo.");
        }
    }//GEN-LAST:event_nTurnButtonActionPerformed
    // Método de consulta de resultados de combate
    private String stringifyResult(Game.CombatResult result) {
        String msg = "";

        switch(result) {
            case WINANDWINGAME:
                msg = "Has ganado el juego";
                break;
            case WIN:
                msg = "Has ganado tu combate";
                break;
            case LOSE:
                msg = "Has perdido tu combate, tienes que cumplir un mal rollo";
                break;
            case LOSEANDESCAPE:
                msg = "Has perdido tu combate, pero has escapado a tiempo";
                break;
            case LOSEANDDIE:
                msg = "Has perdido tu combate, y el monstruo te ha matado";
                break;
            case LOSEANDCONVERT:
                msg = "Has perdido tu combate, y te has convertido en sectario";
                break;
        }
        
        return msg;
    }
    
    private void newTurn() {
        if (napakalakiModel.getCurrentPlayer() instanceof CultistPlayer)
            playerPanel.setCultistPlayer((CultistPlayer) napakalakiModel.getCurrentPlayer());
        else
            playerPanel.setPlayer(napakalakiModel.getCurrentPlayer());
        
        monsterPanel.setMonster(napakalakiModel.getCurrentMonster());

        // Restablecemos botones y textos
        combatButton.setEnabled(true);
        nTurnButton.setEnabled(false);
        combatText.setText("");
    }
    
    private void combatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combatButtonActionPerformed
        playerPanel.lockButtons(true);
        
        // Combatir en Napakalaki y obtener resultados
        CombatResult result = napakalakiModel.combat();
        combatText.setText(stringifyResult(result));
        
        // Desbloquea botones para gestionar mal rollo y post-lucha
        combatButton.setEnabled(false);
        
        if (result != CombatResult.WINANDWINGAME) {
            if (result == CombatResult.LOSEANDCONVERT)
                playerPanel.setCultistPlayer((CultistPlayer) napakalakiModel.getCurrentPlayer());
            
            
            nTurnButton.setEnabled(true);
            // Actualizamos niveles, botones y comprobamos lo necesario
            playerPanel.redraw();
            playerPanel.lockButtons(false);
            playerPanel.checkDeath();
        }
    }//GEN-LAST:event_combatButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        System.exit(0);
    }//GEN-LAST:event_closeButtonActionPerformed
    
    public void showView() {
        this.setVisible(true);
    }
    
    public void setNapakalaki(Napakalaki model) {
        napakalakiModel = model;
        playerPanel.setNapakalaki(napakalakiModel);
        
        newTurn();
    }    
    
    public static void main(String args[]) {
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView();
        
        ArrayList<String> names;
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        
        names = namesCapture.getNames();
        napakalakiModel.initGame(names);
        napakalakiView.setNapakalaki(napakalakiModel);
        napakalakiView.showView();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton combatButton;
    private javax.swing.JTextArea combatText;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.MonsterView monsterPanel;
    private javax.swing.JButton nTurnButton;
    private GUI.PlayerView playerPanel;
    // End of variables declaration//GEN-END:variables
}