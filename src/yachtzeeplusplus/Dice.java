package yachtzeeplusplus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Dice {
    
JButton[] dices = new JButton[5];  //five dices
JButton[] mirrorDice = new JButton[5]; 
JPanel dicePanel; //panel for holding five dices
JLabel dicePanelLabelA;
GridBagConstraints gbc4DP;
URL urlDicePath;
final URL[] urlsDiceImage=new URL[6],animatedDices=new URL[5];
String filePath;
static int[] outcomes = new int[5]; //holds five dice face values 
JButton bufferDice; //holds dice which has been selected for power roll 

 ActionListener TemporaryActionListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            try{
            if (bufferDice == null) {
                bufferDice = (JButton) e.getSource();
            }
        }
                catch(Exception ex)
      {
          System.out.println(ex.getMessage());
      }
    }
    };
 
 //changes the dice face after the powerroll operation i.e eithr after increasing or decreasing the dice face value
 public void updateDiceAfterPowerRollOperation(String operation) {
     try{
        int index = Integer.parseInt(bufferDice.getActionCommand());

        if (operation.equals("add1")) {

            if (index < 6) {
                filePath="GUIComponents/"+(index+1)+".gif";
                urlDicePath=getClass().getResource(filePath);
                
                bufferDice.setIcon(new ImageIcon(urlDicePath));
                bufferDice.setActionCommand(String.valueOf(index + 1));
                outcomes[Integer.parseInt(bufferDice.getToolTipText())] = index + 1;
            }
        } else if (operation.equals("substract1")) {

            if (index > 1) {
                 filePath="GUIComponents/"+(index-1)+".gif";
                urlDicePath=getClass().getResource(filePath);
                
                bufferDice.setIcon(new ImageIcon(urlDicePath));
                bufferDice.setActionCommand(String.valueOf(index - 1));
                outcomes[Integer.parseInt(bufferDice.getToolTipText())] = index - 1;
            }

        }
     }
     catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
    }

 
 //adds action listner to the dices to make ready them for powerroll operation
 public void addTemporaryActionListenerToDices() {
     try{
     for (int i = 0; i < 5; i++) {

            if (dices[i].isEnabled()) {
                dices[i].addActionListener(TemporaryActionListener);
            }
        }
    }
     catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
 }
 
 //resets mirror buttons
 public void resetMirrorButtons() {
     try{
        for (int i = 0; i < 5; i++) {
            mirrorDice[i] = null;
        }
    }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
 }
 
 
 
 //selects disabled dices so that no disabled dice wil be rolled on successive rolls
  public void findDisabledDice() {
      try{
        for (int i = 0; i < 5; i++) {
            if (!dices[i].isEnabled()) {
                mirrorDice[i] = dices[i];
            }
        }
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
}
  
  
  //returns dicepanel which holds five dices
JPanel getReferenceToDicePanel(){
return dicePanel;
}

//sets all dice faces to ones before any rolling is performed
void setAcesForAllDices(){
    try{
        urlsDiceImage[0]=getClass().getResource("GUIComponents/1.gif");
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}

//sets URL for animated gifs which are used on dices
//to display
void setImageURLforButtons(){
    try{
    animatedDices[0]=getClass().getResource("GUIComponents/animatedDice1.gif");
    animatedDices[1]=getClass().getResource("GUIComponents/animatedDice2.gif");
    animatedDices[2]=getClass().getResource("GUIComponents/animatedDice3.gif");
    animatedDices[3]=getClass().getResource("GUIComponents/animatedDice4.gif");
    animatedDices[4]=getClass().getResource("GUIComponents/animatedDice5.gif");

    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}

//layouts the five dices on the dice panel
   public void createDicePanel() {
       try{
        dicePanelLabelA = new JLabel("D i c e         R o l l i n g        P a n n e l");
        dicePanelLabelA.setFont(new Font("SERIF", Font.BOLD, 20));
        dicePanelLabelA.setForeground(Color.red);
        dicePanel = new JPanel(new GridBagLayout());
        gbc4DP = new GridBagConstraints();
        gbc4DP.gridx = gbc4DP.gridy = 0;
        gbc4DP.insets = new Insets(10, 10, 0, 0);

        dicePanel.setPreferredSize(new Dimension((int) (GUIInterface.SCREEN_WIDTH * .7), (int) (GUIInterface.SCREEN_HEIGHT * .7)));
        dicePanel.setBackground(Color.WHITE);
        gbc4DP.gridwidth = 3;
        dicePanel.add(dicePanelLabelA, gbc4DP);
    
       }
       catch(Exception e)
       {
           System.out.println(e.getMessage());
       }
   }

   
   //sets dice buttons to show ones before roll
 public void beforeRoll() {
     try{
     setAcesForAllDices();
        dices[0] = new JButton("", (new ImageIcon(urlsDiceImage[0])));
        dices[1] = new JButton("", (new ImageIcon(urlsDiceImage[0])));
        dices[2] = new JButton("", (new ImageIcon(urlsDiceImage[0])));
        dices[3] = new JButton("", (new ImageIcon(urlsDiceImage[0])));
        dices[4] = new JButton("", (new ImageIcon(urlsDiceImage[0])));
    
     }
     catch(Exception e)
     {
         System.out.println(e.getMessage());
     }
 }
 
  //THIS FUNCTION SETS FIVE DIFFERENT DICES WITH DIFFERENT ANIMATION GIFS
    public void duringRoll() {
        try{
        dices[0] = new JButton("", (new ImageIcon(animatedDices[0])));
        dices[1] = new JButton("", (new ImageIcon(animatedDices[1])));
        dices[2] = new JButton("", (new ImageIcon(animatedDices[2])));
        dices[3] = new JButton("", (new ImageIcon(animatedDices[3])));
        dices[4] = new JButton("", (new ImageIcon(animatedDices[4])));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //rolls only selected dices   
    public void rollOnlyDeselectedDices() {
            try{
        if (mirrorDice[0] == null) {
            dices[0] = new JButton(null, (new ImageIcon(animatedDices[0])));
        } else {
            dices[0] = mirrorDice[0];
        }

        if (mirrorDice[1] == null) {
            dices[1] = new JButton(null, (new ImageIcon(animatedDices[1])));
        } else {
            dices[1] = mirrorDice[1];
        }

        if (mirrorDice[2] == null) {
            dices[2] = new JButton(null, (new ImageIcon(animatedDices[2])));
        } else {
            dices[2] = mirrorDice[2];
        }

        if (mirrorDice[3] == null) {
            dices[3] = new JButton(null, (new ImageIcon(animatedDices[3])));
        } else {
            dices[3] = mirrorDice[3];
        }

        if (mirrorDice[4] == null) {
            dices[4] = new JButton(null, (new ImageIcon(animatedDices[4])));
        } else {
            dices[4] = mirrorDice[4];
        }
    }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
           
    }

    //generates toss individual dice face values while generating toss score 
    public int afterRollForToss() {
         try{
        int sum=0;
        Random results = new Random();
        for (int i = 0; i < 5; i++) {
            outcomes[i] = results.nextInt(6) + 1;
            filePath="GUIComponents/"+outcomes[i]+".gif";
            urlDicePath=getClass().getResource(filePath);
            sum=sum+outcomes[i];   
            dices[i] = new JButton(null, (new ImageIcon(urlDicePath)));
        }
     return sum;
     }
     
     catch(Exception e)
     {
         System.out.println(e.getMessage());
         return 0;
     }
}
    
    //generates score for only enabled dice during selective roll
    public void afterPlayRoll() {
    
        try{
        Random results = new Random();
        for (int i = 0; i < 5; i++) {

            if (mirrorDice[i] == null) {
                outcomes[i] = results.nextInt(6) + 1;
                filePath="GUIComponents/"+outcomes[i]+".gif";
                urlDicePath=getClass().getResource(filePath);
                dices[i] = new JButton(null, (new ImageIcon(urlDicePath)));
                dices[i].setActionCommand(String.valueOf(outcomes[i]));
                filePath="";
            } else {
                outcomes[i] = Integer.parseInt(mirrorDice[i].getActionCommand());
            }
        }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
}
     
    //adds five dices to the dice panel
public void addDices() {
    try{
        gbc4DP.gridy++;
        gbc4DP.gridwidth = 3;
        if (mirrorDice[0] == null) {
            dices[0].setToolTipText("0");
            dicePanel.add(dices[0], gbc4DP);
        } else {
            dicePanel.add(mirrorDice[0], gbc4DP);
        }
        gbc4DP.gridy++;
        gbc4DP.gridwidth = 1;
        if (mirrorDice[1] == null) {
            dices[1].setToolTipText("1");
            dicePanel.add(dices[1], gbc4DP);
        } else {
            dicePanel.add(mirrorDice[1], gbc4DP);
        }
        gbc4DP.gridx++;
        if (mirrorDice[2] == null) {
            dices[2].setToolTipText("2");
            dicePanel.add(dices[2], gbc4DP);
        } else {
            dicePanel.add(mirrorDice[2], gbc4DP);
        }
        gbc4DP.gridx++;
        if (mirrorDice[3] == null) {
            dices[3].setToolTipText("3");
            dicePanel.add(dices[3], gbc4DP);
        } else {
            dicePanel.add(mirrorDice[3], gbc4DP);
        }
        gbc4DP.gridy++;
        gbc4DP.gridx = 0;
        gbc4DP.gridwidth = 3;
        if (mirrorDice[4] == null) {
            dices[4].setToolTipText("4");
            dicePanel.add(dices[4], gbc4DP);
        } else {
            dicePanel.add(mirrorDice[4], gbc4DP);
        }
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }
    
}


}
