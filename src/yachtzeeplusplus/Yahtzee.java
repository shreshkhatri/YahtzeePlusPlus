package yachtzeeplusplus;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Yahtzee extends GUIInterface {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel()); // this code causes the program to have windows look and feel
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Yahtzee.class.getName()).log(Level.SEVERE, null, ex);
        }

        Yahtzee instance = new Yahtzee();
        instance.getScreenDimension();
        instance.setIconPath();
        instance.makeBasicGui();
        instance.showMenus();
        instance.setResizable(false);
        instance.confirmLayout();
        instance.refreshPanel();
    }
}
