/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yachtzeeplusplus;


public interface Rules {
    
void fixTurnForPlayers();
boolean verifyIfAllPlayerTossed();
int[] sortResult();
 void scoreAnalyzier();  
 public Integer checkForGrandTotal();
boolean checkIsGameOver();
void writePlayerScoresToScoreBoard();
 void showHelp();
 boolean checkIfAnyCategorryIsScored();

}
