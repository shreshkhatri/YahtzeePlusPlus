package yachtzeeplusplus;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
public class Player {

Player[] players=new Player[10];  
Player current_player;
static int NUM_OF_PLAYERS;
static int[] SORTEDTOTAL_IN_DESCENDING;
String name;
Score score;

Player(){
}
//constructor for setting player name
Player(String name){
this.name=name;
}
//getter for reading player name
String getName(){
return name;
}
//creates objects as each players
 public void createPlayers(DefaultListModel listModel) {
     try{
        for (int i = 0; i < NUM_OF_PLAYERS; i++) {
            try{
            players[i] = new Player(listModel.getElementAt(i).toString().trim());
            }
            catch(Exception e)
            {
               JOptionPane.showMessageDialog(null,"sorry! players could not be created at this timen\nReason"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
            }
    }
     catch(Exception ex)
     {
         System.out.println(ex.getMessage());
     }
 }
//creaetes score object for each players
Score initializeScoreObject(){
return new Score();
}
//returns player having toss score equal to input
public Player getPlayerInOrder(int input) {
    try{    
    int x;
        for (x = 0; x < NUM_OF_PLAYERS; x++) {

            if (input == players[x].score.tossScore) {
                break;
            }

        }
        return players[x];
    }
    catch(Exception e)
      {
          System.out.println(e.getMessage());
          return null;
      }
 }


//creates a single player in single player mode
Player createSinglePlayer(String name){
NUM_OF_PLAYERS=1;
try {
players[0]=new Player(name);
players[0].score=new Score();
return players[0];
}
    catch(Exception e)
      {
          System.out.println(e.getMessage());
          return null;
      }
 }

}

