package yachtzeeplusplus;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Score {

    Integer ones;        Integer fours;
    Integer twos;        Integer fives;
    Integer threes;      Integer sixes;
    Integer threeOfaKind;    Integer fourOfaKind;
    Integer smallStraignt;   Integer largeStraing;
    Integer fullHouse;       Integer yachtee;
    Integer chance;    
    Integer bonusForYachtee;
    Integer grandTotal; 
    int tossScore;
    boolean reScored;
Score getScoreObject(){
 return new Score();
}

void setTossScore(int TS)
{
tossScore=TS;
}
        
int getTossScore(){
return tossScore;
}
public boolean isTossScoreWritten(DefaultTableModel tblModel,int sum,Player current_player) {
try{
    boolean addable = true;
        for (int i = 0; i < tblModel.getRowCount(); i++) {
            if (tblModel.getValueAt(i, 1).equals(sum)) {
                JOptionPane.showMessageDialog(null, "the result is same as for another player\nplease roll again",
                        "Re-roll again !", JOptionPane.INFORMATION_MESSAGE);
                addable = false;
                break;
            }
        }
        if (addable) {
            current_player.score.setTossScore(sum);
            tblModel.addRow(new Object[]{current_player.name, current_player.score.getTossScore()});
            return addable;
        } else {
            return addable;
        }
    }
    catch(Exception e)
      {
          System.out.println(e.getMessage());
          return false;
      }
 }
Score initializeScoreObject(){
return new Score();
}
 public int countOnes() {
        int sum = 0;
        for (int x = 0; x < 5; x++) {
            if (Dice.outcomes[x] == 1) {
                sum += 1;
            }
        }
        return sum;
    }

    public int countTwos() {
        int sum = 0;
        for (int x = 0; x < 5; x++) {
            if (Dice.outcomes[x] == 2) {
                sum += 2;
            }
        }
        return sum;
    }

    public int countThrees( ) {
        int sum = 0;
        for (int x = 0; x < 5; x++) {
            if (Dice.outcomes[x] == 3) {
                sum += 3;
            }
        }
        return sum;
    }

    public int countFours() {
        int sum = 0;
        for (int x = 0; x < 5; x++) {
            if (Dice.outcomes[x] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int countFives() {
        int sum = 0;
        for (int x = 0; x < 5; x++) {
            if (Dice.outcomes[x] == 5) {
                sum += 5;
            }
        }
        return sum;
    }

    public int countSixes() {
        int sum = 0;
        for (int x = 0; x < 5; x++) {
            if (Dice.outcomes[x] == 6) {
                sum += 6;
            }
        }
        return sum;
}
    
public int getKindOf3() {
        if (countOnes() >= 3) {
            return getChance();
        } else if (countTwos() >= 6) {
            return getChance();
        } else if (countThrees() >= 9) {
            return getChance();
        } else if (countFours() >= 12) {
            return getChance();
        } else if (countFives() >= 15) {
            return getChance();
        } else if (countSixes() >= 18) {
            return getChance();
        } else {
            return 0;
        }
    }

    public int getKindOf4() {
        if (countOnes() >= 4) {
            return getChance();
        } else if (countTwos() >= 8) {
            return getChance();
        } else if (countThrees() >= 12) {
            return getChance();
        } else if (countFours() >= 16) {
            return getChance();
        } else if (countFives() >= 20) {
            return getChance();
        } else if (countSixes() >= 24) {
            return getChance();
        } else {
            return 0;
        }
    }

    public boolean checkYachtzee() {

        for (int x = 1; x < 5; x++) {
            if (Dice.outcomes[0] != Dice.outcomes[x]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkSmallStraight() {
        int[] tempArray = new int[5];
        int one,two,three,four,five,six;
        System.arraycopy(Dice.outcomes, 0, tempArray, 0, 5);
        Arrays.sort(tempArray);
        one=Arrays.binarySearch(tempArray, 1);
        two=Arrays.binarySearch(tempArray, 2);
        three=Arrays.binarySearch(tempArray, 3);
        four=Arrays.binarySearch(tempArray, 4);
        five=Arrays.binarySearch(tempArray, 5);
        six=Arrays.binarySearch(tempArray, 6);
       
        if(one>=0&&two>=0&&three>=0&&four>=0)
            return true;
        else if (two>=0&&three>=0&&four>=0&&five>=0)
            return true;
        else if (three>=0&&four>=0&&five>=0&&six>=0)
            return true;
        
        return false;
    }

    public boolean checkFullHouse() {
        if (countOnes() == 2 && countTwos() == 6 || countOnes() == 3 && countTwos() == 4) {
            return true;
        } else if (countOnes() == 2 && countThrees() == 9 || countOnes() == 3 && countThrees() == 6) {
            return true;
        } else if (countOnes() == 2 && countFours() == 12 || countOnes() == 3 && countFours() == 8) {
            return true;
        } else if (countOnes() == 2 && countFives() == 15 || countOnes() == 3 && countFives() == 10) {
            return true;
        } else if (countOnes() == 2 && countSixes() == 18 || countOnes() == 3 && countSixes() == 12) {
            return true;
        } else if (countTwos() == 4 && countThrees() == 9 || countTwos() == 6 && countThrees() == 6) {
            return true;
        } else if (countTwos() == 4 && countFours() == 12 || countTwos() == 6 && countFours() == 8) {
            return true;
        } else if (countTwos() == 4 && countFives() == 15 || countTwos() == 6 && countFives() == 10) {
            return true;
        } else if (countTwos() == 4 && countSixes() == 18 || countTwos() == 6 && countFives() == 12) {
            return true;
        } else if (countThrees() == 6 && countFours() == 12 || countThrees() == 9 && countFours() == 8) {
            return true;
        } else if (countThrees() == 6 && countFives() == 15 || countThrees() == 9 && countFives() == 10) {
            return true;
        } else if (countThrees() == 6 && countSixes() == 18 || countThrees() == 9 && countSixes() == 12) {
            return true;
        } else if (countFours() == 8 && countFives() == 15 || countFours() == 12 && countFives() == 10) {
            return true;
        } else if (countFours() == 8 && countSixes() == 18 || countFours() == 12 && countSixes() == 12) {
            return true;
        } else {
            return countFives() == 10 && countSixes() == 18 || countFives() == 15 && countSixes() == 12;
        }
    }

    public boolean checkLargeStraight() {

        boolean result = true;
        int[] tempArray = new int[5];

        for (int i = 0; i < 5; i++) {
            tempArray[i] = Dice.outcomes[i];
        }

        Arrays.sort(tempArray);

        //this loops checks for the sequence 1,2,3,4,5
        for (int i = 0; i < 5; i++) {
            if (tempArray[i] != (i + 1)) {
                result = false;
            }
        }

        if (!result) {
            result = true;
        } else {
            return result;
        }

        // this loop checks for the sequence 2,3,4,5,6
        for (int i = 0; i < 5; i++) {
            if (tempArray[i] != (i + 2)) {
                result = false;
            }
        }
        return result;
    }

    public int getChance() {
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            sum += Dice.outcomes[i];
        }

        return sum;
    }


    Score getScoreData(Player player){
    try{
    return player.score;
    }
        catch(Exception e)
      {
          System.out.println(e.getMessage());
          return null;
      }
 }
}



