package yachtzeeplusplus;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

abstract class GUIInterface extends JFrame implements ActionListener, MouseListener,Rules {

    private Font font;
    private Dice diceObject;
    private Player playerObject;
    private Dimension screenSize;
    public static int CURRENT_TURN, SCREEN_HEIGHT, SCREEN_WIDTH;
    private URL urlAppIcon, urlPlayer, urlPlus1, urlMius1, urlBlueRadio, urlRedRadio;
    private URL urlHelp, urlDev, urlSinglePlayerL, urlSinglePlayerR, urlExit, urlGame;
    
    //controls for developerinfo panel
    JButton buttonMainMenu;
    JPanel devInfoPanel;
    URL devphotoPath;
    JLabel devPhoto, devName, devAddress, devContact, devCollege, devCollegeBatch, gameName;
    GridBagConstraints constraints;

    //controls for ScoreBoard
    JPanel scoreBoardNorthPanel, scoreBoardCentralPanel, scoreBoardSouthPanel;
    GridBagConstraints gb4SBNP, gb4SBCP, gb4SBSP;
    JButton btnMainMenu, btnExit;
    JTable scoreTable;
    DefaultTableModel scoreTableModel;
    JScrollPane scoreTablePane;

    //controls for main playboard
    JPanel WPanel, EPanel, upperSection, lowerSection, noticePanel, controlPanel, subControlPanel1;
    JPanel subControlPanel2, subControlPanel3;
    JButton rollButton, confirmButton, powerRollButton, plus1Button, minus1Button,reScoreButton;
    boolean reScoringMode,alreadyScored;
    JButton[] mirrorButton = new JButton[5];

    JLabel labelPlayer, labelNotice;
    GridBagConstraints g2, g1;
    JLabel[] label = new JLabel[19];
    JTextField textOnes, textTwos, textThrees, textFours, textFives, textSixes;
    JTextField kind3, kind4, textSmallStraight, textLargeStraight, textFullHouse, textYahtzee;
    JTextField textChance, textExtraYahtzeeBonus, textGrandTotal;
    int buttonIndex;
    //controls for gameMode Selection and screen ___________________ __________
    private JPanel screen, gameMode, emptyPanel;
    int[] sortedTotal = new int[10];
    private JLabel labelQuestion;
    private JRadioButton radio1, radio2;
    private ButtonGroup group;
    private JButton buttonNext, buttonPrevious;
    private GridBagConstraints gb;

    //components for the pannel which adds user to the game
    private JPanel panelforUserCreation;
    private JLabel labelInfo, icon;
    private GridBagConstraints gb1;
    private JTextField userName;
    private JButton buttonBegin, buttonBack;

    //controls for creating Multi-User Mode panel
    DefaultListModel listModel;
    JList list;
    JScrollPane pane;
    JPanel southPanel, topPanel, leftPanel, rightPanel, rowPanel;
    JButton backButton, playButton, addPlayerButton;
    GridBagConstraints gb4southPanel;
    JLabel playerLabel, instructionLabel;

    //controls used in fixTurnForPlayers functions
    JPanel leftUserListPanel, centralPanel, rightUserListPanel, resultPanel, buttonPanel;
    GridBagConstraints gbc4LP, gbc4RP, gbc4RRP;
    JTable table;
    JScrollPane tablePane;
    JButton buttonStart, currentButton;
    JButton[] playerButton = new JButton[10];
    DefaultTableModel tblModel;

    
 
    //function for adding action listener to copy dices 
    void addActionListenersToDices() {
        try{
        for (int i = 0; i < 5; i++) {
            if (diceObject.mirrorDice[i] == null) {
                diceObject.dices[i].addActionListener(this);
            }
        }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    ActionListener eventMenu = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {
                case "start":
                    hideMenus();
                    selectGameMode();
                    confirmLayout();
                    refreshPanel();
                    break;

                case "help":
                    break;
                case "main":
                    hideDeveloperInfo();
                    showMenus();
                    confirmLayout();
                    refreshPanel();
                    break;
                case "about":
                    hideMenus();
                    showDevevloperInfo();
                    confirmLayout();
                    refreshPanel();
                    break;
                case "mainMenu":
                    removeScoreBoard();
                    makeBasicGui();
                    showMenus();
                    confirmLayout();
                    refreshPanel();
                    break;
                case "exit":
                    System.exit(0);
                    break;

            }

        }
    };

    ActionListener eventGameModeSelection = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {
                case "single":
                    radio2.setForeground(Color.RED);
                    radio2.setIcon(new ImageIcon(urlRedRadio));
                    radio1.setForeground(Color.blue);
                    radio1.setIcon(new ImageIcon(urlBlueRadio));

                    break;

                case "multi":
                    radio1.setForeground(Color.RED);
                    radio1.setIcon(new ImageIcon(urlRedRadio));
                    radio2.setForeground(Color.BLUE);
                    radio2.setIcon(new ImageIcon(urlBlueRadio));
                    break;

                case "next":
                    if (radio1.isSelected()) {
                        hideSelectGameMode();
                        createPlayerPanel();
                        confirmLayout();
                        refreshPanel();
                    } else if (radio2.isSelected()) {
                        hideSelectGameMode();
                        createPlayerPanel(1);
                        confirmLayout();
                        refreshPanel();

                    }
                    break;
                case "back":
                    hideSelectGameMode();
                    showMenus();
                    confirmLayout();
                    refreshPanel();
                    break;

            }

        }
    };

    ActionListener aclsner = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {

                case "startGame":
                    if(userName.getText().equals(""))
                        {
                        JOptionPane.showMessageDialog(null,"Please, enter the name for player","Player name required"
                                + "", JOptionPane.INFORMATION_MESSAGE);
                        }
                    else
                    {
                    diceObject = new Dice();
                    diceObject.setImageURLforButtons();
                    playerObject = new Player();
                    createPlayBoard(playerObject.createSinglePlayer(userName.getText()));
                    deletePlayerPanel();
                    confirmLayout();
                    refreshPanel();
                    }
                    break;

                case "mainMenu":
                    deletePlayerPanel();
                    selectGameMode();
                    confirmLayout();
                    refreshPanel();

                    break;

            }
        }

    };

    ActionListener addingUserEvent = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {

                case "addplayer":
                    if (!userName.getText().equals("")) {
                        addUserToTheList(userName.getText());
                    }
                    break;

                case "play":
                    if (listModel.getSize() < 2) {
                        JOptionPane.showMessageDialog(null, "At-least two players required\n to play");
                    } else {
                        Player.NUM_OF_PLAYERS = listModel.getSize();
                        deletePlayerPaneMultiuserMode();
                        makeBasicGui();
                        playerObject = new Player();
                        playerObject.createPlayers(listModel);
                        fixTurnForPlayers();
                        confirmLayout();
                        refreshPanel();
                    }
                    break;

                case "back":
                    deletePlayerPaneMultiuserMode();
                    selectGameMode();
                    confirmLayout();
                    refreshPanel();
                    break;

                default:
                    break;

            }

        }
    };

    ActionListener customActionEvent1 = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int tossResult;
            trigger1.stop();
            removeDicePanel();
            diceObject.createDicePanel();
            tossResult = diceObject.afterRollForToss();
            diceObject.addDices();
            addDicePanelToCentralPanel(diceObject.getReferenceToDicePanel());
            playerObject.current_player.score = playerObject.initializeScoreObject();
            if (!playerObject.current_player.score.isTossScoreWritten(tblModel, tossResult, playerObject.current_player)) {
                currentButton.setEnabled(true);
            }
            confirmLayout();
            refreshPanel();
            if (verifyIfAllPlayerTossed()) {
                Player.SORTEDTOTAL_IN_DESCENDING = sortResult();
            }

        }
    };

    ActionListener customActionEvent2 = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            trigger2.stop();
            diceObject.afterPlayRoll();
            addActionListenersToDices();
            removeDicePanelFromPlayBoard();
            diceObject.createDicePanel();
            diceObject.addDices();
            addDicePanelToPlayBoard();
            confirmLayout();
            refreshPanel();
            if (reScoringMode)
            {
                scoreAnalyzierUnderResoringMode();
            }
            else
            {
            scoreAnalyzier();
            // findResultAfterRolling1();
            }
        }
    };

    ActionListener eventTurnFinding = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            currentButton = (JButton) e.getSource();
            currentButton.setEnabled(false);
            playerObject.current_player = playerObject.players[Integer.parseInt(currentButton.getActionCommand())];
            trigger1.start();
            removeDicePanel();
            diceObject = createDiceObject();
            diceObject.createDicePanel();
            diceObject.setImageURLforButtons();
            diceObject.duringRoll();
            diceObject.addDices();
            addDicePanelToCentralPanel(diceObject.getReferenceToDicePanel());
            confirmLayout();
            refreshPanel();
        }

    };
//Timer trigger1 = new Timer(2000, customActionEvent1);
    //  Timer trigger2 = new Timer(2000, customActionEvent2);

    Timer trigger1 = new Timer(2000, customActionEvent1);

    Timer trigger2 = new Timer(2000, customActionEvent2);

    @Override
    //this function sorts the toss score made by each players
    public int[] sortResult() {
        try{
        int[] listOfScore = new int[Player.NUM_OF_PLAYERS];
        int[] orderedScore = new int[Player.NUM_OF_PLAYERS];

        // this loop reads the score made by each players
        for (int i = 0; i < Player.NUM_OF_PLAYERS; i++) {
            listOfScore[i] = (int) tblModel.getValueAt(i, 1);
        }

        //this function sorts the scores in sorted order
        Arrays.sort(listOfScore);

        // this loops resores the sorted array to obtain its descending order
        //in order to determine the turn for each user
        for (int i = 0; i <= Player.NUM_OF_PLAYERS - 1; i++) {
            orderedScore[i] = listOfScore[(Player.NUM_OF_PLAYERS - 1) - i];
        }

        for (int x = 0; x < Player.NUM_OF_PLAYERS; x++) {
            switch (x) {

                case 0:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[0])) {
                            tblModel.setValueAt("    1st ", o, 2);
                        }
                    }
                    break;

                case 1:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[1])) {
                            tblModel.setValueAt("    2nd ", o, 2);
                        }
                    }
                    break;

                case 2:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[2])) {
                            tblModel.setValueAt("    3rd ", o, 2);
                        }
                    }
                    break;

                case 3:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[3])) {
                            tblModel.setValueAt("    4th ", o, 2);
                        }
                    }
                    break;

                case 4:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[4])) {
                            tblModel.setValueAt("    5th ", o, 2);
                        }
                    }
                    break;

                case 5:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[5])) {
                            tblModel.setValueAt("    6th ", o, 2);
                        }
                    }
                    break;

                case 6:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[6])) {
                            tblModel.setValueAt("    7th ", o, 2);
                        }
                    }
                    break;

                case 7:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[7])) {
                            tblModel.setValueAt("    8th ", o, 2);
                        }
                    }
                    break;

                case 8:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[8])) {
                            tblModel.setValueAt("    9th ", o, 2);
                        }
                    }
                    break;

                case 9:
                    for (int o = 0; o < Player.NUM_OF_PLAYERS; o++) {
                        if (tblModel.getValueAt(o, 1).equals(orderedScore[9])) {
                            tblModel.setValueAt("    10th ", o, 2);
                        }
                    }
                    break;

                default:
                    break;
            }

        }
        return orderedScore;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        return null;
        }
    }

    @Override
    // this function is called to check if all of the categories have been scored so that
    //total score could be calculated
    public Integer checkForGrandTotal() {
        try{

        if (playerObject.current_player.score.ones != null 
                && playerObject.current_player.score.twos != null
                && playerObject.current_player.score.threes != null
                && playerObject.current_player.score.fours != null 
                && playerObject.current_player.score.fives != null 
                && playerObject.current_player.score.sixes != null
                && playerObject.current_player.score.threeOfaKind != null 
                && playerObject.current_player.score.fourOfaKind != null 
                && playerObject.current_player.score.smallStraignt != null
                && playerObject.current_player.score.largeStraing != null 
                && playerObject.current_player.score.fullHouse != null 
                && playerObject.current_player.score.yachtee != null 
                && playerObject.current_player.score.chance != null) {

            return (playerObject.current_player.score.ones + playerObject.current_player.score.twos 
                    + playerObject.current_player.score.threes + playerObject.current_player.score.fours
                    + playerObject.current_player.score.fives + playerObject.current_player.score.sixes 
                    + playerObject.current_player.score.smallStraignt + playerObject.current_player.score.largeStraing 
                    + playerObject.current_player.score.threeOfaKind+ playerObject.current_player.score.fourOfaKind 
                    + playerObject.current_player.score.fullHouse + playerObject.current_player.score.yachtee 
                    + playerObject.current_player.score.chance);
        } else {
            return null;
        }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    //this function analyzes the results obtained from dice roll by calling other individual functions
    public void scoreAnalyzier() {

        try {
        if (playerObject.current_player.score.ones == null) {
            textOnes.setText(String.valueOf(playerObject.current_player.score.countOnes()));
        } else {
            textOnes.setText(String.valueOf(playerObject.current_player.score.ones));
        }

        if (playerObject.current_player.score.twos == null) {
            textTwos.setText(String.valueOf(playerObject.current_player.score.countTwos()));
        } else {
            textTwos.setText(String.valueOf(playerObject.current_player.score.twos));
        }

        if (playerObject.current_player.score.threes == null) {
            textThrees.setText(String.valueOf(playerObject.current_player.score.countThrees()));
        } else {
            textThrees.setText(String.valueOf(playerObject.current_player.score.threes));
        }

        if (playerObject.current_player.score.fours == null) {
            textFours.setText(String.valueOf(playerObject.current_player.score.countFours()));
        } else {
            textFours.setText(String.valueOf(playerObject.current_player.score.fours));
        }

        if (playerObject.current_player.score.fives == null) {
            textFives.setText(String.valueOf(playerObject.current_player.score.countFives()));
        } else {
            textFives.setText(String.valueOf(playerObject.current_player.score.fives));
        }

        if (playerObject.current_player.score.sixes == null) {
            textSixes.setText(String.valueOf(playerObject.current_player.score.countSixes()));
        } else {
            textSixes.setText(String.valueOf(playerObject.current_player.score.sixes));
        }

        if (playerObject.current_player.score.threeOfaKind == null) {
            kind3.setText(String.valueOf(playerObject.current_player.score.getKindOf3()));
        } else {
            kind3.setText(String.valueOf(playerObject.current_player.score.threeOfaKind));
        }

        if (playerObject.current_player.score.fourOfaKind == null) {
            kind4.setText(String.valueOf(playerObject.current_player.score.getKindOf4()));
        } else {
            kind4.setText(String.valueOf(playerObject.current_player.score.fourOfaKind));
        }

        if (playerObject.current_player.score.largeStraing == null) {

            if (playerObject.current_player.score.checkLargeStraight()) {
                textLargeStraight.setText("40");
            } else {
                textLargeStraight.setText("0");
            }

        }

        if (playerObject.current_player.score.smallStraignt == null) {
            if (playerObject.current_player.score.checkSmallStraight()) {
                textSmallStraight.setText("30");
            } else {
                textSmallStraight.setText("0");
            }
        } else {
            textSmallStraight.setText(String.valueOf(playerObject.current_player.score.smallStraignt));
        }

        if (playerObject.current_player.score.fullHouse == null) {
            if (playerObject.current_player.score.checkFullHouse()) {
                textFullHouse.setText("25");
            } else {
                textFullHouse.setText("0");
            }
        } else {
            textFullHouse.setText(String.valueOf(playerObject.current_player.score.fullHouse));
        }

        if (playerObject.current_player.score.yachtee == null) {
            if (playerObject.current_player.score.checkYachtzee()) {
                textYahtzee.setText("50");
            } else {
                textYahtzee.setText("0");
            }
        } else {
            textYahtzee.setText(String.valueOf(playerObject.current_player.score.yachtee));
            if(playerObject.current_player.score.checkYachtzee()){
                if(playerObject.current_player.score.bonusForYachtee==null)
                {
                playerObject.current_player.score.bonusForYachtee=0;
                }
               playerObject.current_player.score.bonusForYachtee=playerObject.current_player.score.bonusForYachtee+100;
                textExtraYahtzeeBonus.setText(String.valueOf(playerObject.current_player.score.bonusForYachtee));
            }
        }

        if (playerObject.current_player.score.chance == null) {
            textChance.setText(String.valueOf(playerObject.current_player.score.getChance()));
        } else {
            textChance.setText(String.valueOf(playerObject.current_player.score.chance));
        }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
    
   //this function is called when the user selects rescoring mode
    // and this function displayes the scoring options only for already scored categories 
    public void scoreAnalyzierUnderResoringMode() {

    try {
        if (playerObject.current_player.score.ones != null) {
            textOnes.setForeground(Color.BLACK);
            textOnes.setText(String.valueOf(playerObject.current_player.score.countOnes()));
            textOnes.setEnabled(true);
         }

        if (playerObject.current_player.score.twos != null) {
            textTwos.setForeground(Color.BLACK);
            textTwos.setText(String.valueOf(playerObject.current_player.score.countTwos()));
            textTwos.setEnabled(true);
        }

        if (playerObject.current_player.score.threes != null) {
            textThrees.setForeground(Color.BLACK);
            textThrees.setText(String.valueOf(playerObject.current_player.score.countThrees()));
            textThrees.setEnabled(true);
        }

        if (playerObject.current_player.score.fours != null) {
            textFours.setForeground(Color.BLACK);
            textFours.setText(String.valueOf(playerObject.current_player.score.countFours()));
            textFours.setEnabled(true);
        }

        if (playerObject.current_player.score.fives != null) {
            textFives.setForeground(Color.BLACK);
            textFives.setText(String.valueOf(playerObject.current_player.score.countFives()));
            textFives.setEnabled(true);
        }

        if (playerObject.current_player.score.sixes != null) {
            textSixes.setForeground(Color.BLACK);
            textSixes.setText(String.valueOf(playerObject.current_player.score.countSixes()));
            textSixes.setEnabled(true);
        } 

        if (playerObject.current_player.score.threeOfaKind != null) {
 
            kind3.setForeground(Color.BLACK);
            kind3.setText(String.valueOf(playerObject.current_player.score.getKindOf3()));
            kind3.setEnabled(true);
        } 
 
        if (playerObject.current_player.score.fourOfaKind != null) {
            kind4.setForeground(Color.BLACK);
            kind4.setText(String.valueOf(playerObject.current_player.score.getKindOf4()));
            kind4.setEnabled(true);
        } 
        if (playerObject.current_player.score.chance != null) {
            textChance.setFont(font);
            textChance.setForeground(Color.BLACK);
            textChance.setText(String.valueOf(playerObject.current_player.score.getChance()));
            textChance.setEnabled(true);
        }
    }
    catch (Exception e)
    {
        System.out.println(e.getMessage());
    }
    }

   
    //removes the dicepanel form frame
    public void removeDicePanel() {
        try{
        centralPanel.remove(diceObject.getReferenceToDicePanel());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //this function adds users to the left panel after players are registered
    public int addUserToLeftPanel(GridBagConstraints g) {
        try {
        int boundary = Player.NUM_OF_PLAYERS / 2;
        ImageIcon img = new ImageIcon(urlSinglePlayerL);

        for (int i = 0; i < boundary; i++) {

            playerButton[i] = new JButton(playerObject.players[i].name, img);
            playerButton[i].setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .3), 60));
            playerButton[i].setFont(new Font("SERIF", Font.BOLD, 15));
           playerButton[i].addActionListener(eventTurnFinding);
            playerButton[i].setActionCommand(i + "");

            leftUserListPanel.add(playerButton[i], g);
            g.gridy++;
        }
        return boundary;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        return 0;
        }
    }

    //adds the users to the right panel after players are registered
    public void addUserToRightPanel(int boundary, GridBagConstraints g) {
    
        try {
        ImageIcon img = new ImageIcon(urlSinglePlayerR);

        for (int i = boundary; i < Player.NUM_OF_PLAYERS; i++) {

            playerButton[i] = new JButton(playerObject.players[i].name, img);
            playerButton[i].setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .3), 60));
            playerButton[i].setFont(new Font("SERIF", Font.BOLD, 15));
            playerButton[i].addActionListener(eventTurnFinding);
            playerButton[i].setActionCommand("" + i);

            rightUserListPanel.add(playerButton[i], g);

            g.gridy++;
        }
        
        }
        catch(Exception e){
        
            System.out.println(e.getMessage());
        
        }
    }

    @Override
    //ensures that all players tossed before game can be played in multiplayer environment
    public boolean verifyIfAllPlayerTossed() {
    
    try {
        for (int i = 0; i < Player.NUM_OF_PLAYERS; i++) {
            if (playerButton[i].isEnabled()) {
                return false;
            }
        }
        return true;
    }
    catch(Exception e)
    {
        System.out.println(e.getMessage());
        return false;
    }
    }

    @Override
    // sets environment for players for toss
    public void fixTurnForPlayers() {
        try{
        setTitle(getTitle() + " - Know Your Turn");
        buttonStart = new JButton("Begin");
        buttonStart.setForeground(Color.red);
        buttonStart.setFont(new Font("SERIF", Font.BOLD, 15));
        buttonStart.addActionListener(this);
        buttonStart.setActionCommand("begin");
        buttonPanel = new JPanel();
        buttonPanel.add(buttonStart);

        tblModel = new DefaultTableModel();
        tblModel.addColumn("Player Name");
        tblModel.addColumn("Dice face's sum");
        tblModel.addColumn("Turn");
        table = new JTable(tblModel);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setForeground(Color.red);
        table.getTableHeader().setEnabled(false);
        table.getTableHeader().setFont(new Font("SERIF", Font.BOLD, 15));

        table.setFont(new Font("SERIF", Font.BOLD, 15));
        table.setForeground(Color.red);

        // table.setFillsViewportHeight(true);
        tablePane = new JScrollPane(table);

        resultPanel = new JPanel();
        resultPanel.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .8), (int) (SCREEN_HEIGHT * .1f)));
        resultPanel.add(tablePane);

        centralPanel = new JPanel(new BorderLayout());
        centralPanel.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .6), SCREEN_HEIGHT));

        leftUserListPanel = new JPanel(new GridBagLayout());
        leftUserListPanel.setBorder(BorderFactory.createTitledBorder(null, "Player-List A", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new Font("SERIF", Font.BOLD, 20), Color.CYAN));

        gbc4LP = new GridBagConstraints();
        gbc4LP.gridx = gbc4LP.gridy = 0;
        gbc4LP.insets = new Insets(0, 0, (int) (SCREEN_HEIGHT * .1), 0);
        leftUserListPanel.setBackground(Color.GRAY);
        leftUserListPanel.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .2), SCREEN_HEIGHT));

        int tracker = addUserToLeftPanel(gbc4LP);

        rightUserListPanel = new JPanel(new GridBagLayout());
        rightUserListPanel.setBorder(BorderFactory.createTitledBorder(null, "Player-List B", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new Font("SERIF", Font.BOLD, 20), Color.CYAN));

        rightUserListPanel.setBackground(Color.GRAY);
        rightUserListPanel.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .2), SCREEN_HEIGHT));
        gbc4RP = new GridBagConstraints();
        gbc4RP.gridx = gbc4RP.gridy = 0;
        gbc4RP.insets = new Insets(0, 0, (int) (SCREEN_HEIGHT * .1), 0);
        addUserToRightPanel(tracker, gbc4RP);

        diceObject = createDiceObject();
        diceObject.createDicePanel();
        diceObject.beforeRoll();
        diceObject.addDices();
        addDicePanelToCentralPanel(diceObject.getReferenceToDicePanel());

        centralPanel.add(resultPanel, BorderLayout.CENTER);
        centralPanel.add(buttonPanel, BorderLayout.SOUTH);

//    centralPanel.add(resultPanel,BorderLayout.SOUTH);
        this.add(leftUserListPanel, BorderLayout.WEST);
        this.add(rightUserListPanel, BorderLayout.EAST);
        this.add(centralPanel, BorderLayout.CENTER);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
//removes GUI for toss
    public void removeTurnFixer() {
        try{
        remove(leftUserListPanel);
        remove(rightUserListPanel);
        remove(centralPanel);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void addDicePanelToCentralPanel(JPanel panel) {
        try{
        centralPanel.add(panel, BorderLayout.NORTH);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
     }
    //adds registered player to the JList
    public void addUserToTheList(String name) {

        try{
        if (listModel.getSize() < 10 && !listModel.contains("   " + name)) {
            listModel.addElement("   " + name);
            userName.setText("");
        } else if (listModel.getSize() > 9) {
            JOptionPane.showMessageDialog(null, "Only maximum 10 players \ncan play at a time  ", "Player number exceeded!", 
                    JOptionPane.INFORMATION_MESSAGE);
        } else if (listModel.contains("   " + name)) {
            JOptionPane.showMessageDialog(null, " player with name " + name + " already exists !");
        }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //removes GUI for adding players 
    public void deletePlayerPaneMultiuserMode() {
        try {
        remove(topPanel);
        remove(leftPanel);
        remove(rightPanel);
        remove(southPanel);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
//adds panel containing dices to the GUI interface 
    public void addDicePanelToPlayBoard() {
        try{
        EPanel.add(diceObject.getReferenceToDicePanel(), BorderLayout.CENTER);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    
    }

    //prepares GUI for registering players in multiplayer mode
    //argument x is used just for overloading the function createPlayerPanel
    public void createPlayerPanel(int x) {

        try{
        setTitle("Welcome to Yachtee ++: Register Players now!");
        listModel = new DefaultListModel();

        list = new JList(listModel);
        list.setBackground(Color.GRAY);
        list.setForeground(Color.WHITE);
        list.setSelectionBackground(Color.lightGray);
        list.setFont(new Font("SERIF", Font.BOLD, 15));

        pane = new JScrollPane(list);

        //this label contains the icon represntating a player
        playerLabel = new JLabel(new ImageIcon(urlPlayer));

        instructionLabel = new JLabel("Enter the player-name");
        instructionLabel.setFont(new Font("SERIF", Font.BOLD, 15));
        instructionLabel.setForeground(Color.red);

        userName = new JTextField(10);
        userName.setPreferredSize(new Dimension(50, 25));
        userName.setFont(new Font("SERIF", Font.BOLD, 15));
        userName.setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));

        backButton = new JButton("Back");
        backButton.setFont(new Font("SERIF", Font.BOLD, 15));
        backButton.setForeground(Color.red);
        backButton.addActionListener(addingUserEvent);
        backButton.setActionCommand("back");

        playButton = new JButton("Play");
        playButton.setFont(new Font("SERIF", Font.BOLD, 15));
        playButton.setForeground(Color.red);
        playButton.addActionListener(addingUserEvent);
        playButton.setActionCommand("play");

        addPlayerButton = new JButton("Add Player");
        addPlayerButton.setFont(new Font("SERIF", Font.BOLD, 15));
        addPlayerButton.setForeground(Color.red);
        addPlayerButton.addActionListener(addingUserEvent);
        addPlayerButton.setActionCommand("addplayer");

        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(400, 10));

        leftPanel = new JPanel(new GridLayout(0, 1));
        leftPanel.setPreferredSize(new Dimension(180, 420));
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBorder(BorderFactory.createTitledBorder(null, "Player List", 
                TitledBorder.LEFT, TitledBorder.BELOW_TOP, new Font("SERIF", Font.BOLD, 15), Color.RED));
        leftPanel.add(pane);

        rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setPreferredSize(new Dimension(220, 480));
        rightPanel.setBorder(BorderFactory.createTitledBorder(null, "Add User",
                TitledBorder.LEFT, TitledBorder.DEFAULT_POSITION, new Font("SERIF", Font.BOLD, 15), Color.RED));
        GridBagConstraints gbs = new GridBagConstraints();
        gbs.gridx = gbs.gridy = 0;

        southPanel = new JPanel(new GridBagLayout());
        southPanel.setPreferredSize(new Dimension(400, 35));
        gb4southPanel = new GridBagConstraints();
        rightPanel.add(playerLabel, gbs);
        gbs.gridy++;
        gbs.insets = new Insets(5, 0, 15, 0);
        rightPanel.add(instructionLabel, gbs);
        gbs.gridy++;
        gbs.insets = new Insets(5, 0, 0, 0);
        rightPanel.add(userName, gbs);
        gbs.gridy++;
        rightPanel.add(addPlayerButton, gbs);
        gb4southPanel.gridx = gb4southPanel.gridy = 0;
        gb4southPanel.insets = new Insets(0, 5, 0, 5);
        southPanel.add(backButton, gb4southPanel);
        gb4southPanel.gridx++;
        southPanel.add(playButton, gb4southPanel);
        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //prepares GUI for receiving name for a player in single player mode
    public void createPlayerPanel() {
        try{
        panelforUserCreation = new JPanel(new GridBagLayout());
        panelforUserCreation.setPreferredSize(new Dimension(400, 480));
        panelforUserCreation.setBorder(BorderFactory.createTitledBorder(""));
        gb1 = new GridBagConstraints();
        userName = new JTextField(10);
        userName.setPreferredSize(new Dimension(50, 30));
        userName.setFont(new Font("SERIF", Font.BOLD, 20));
        userName.setBorder(BorderFactory.createLineBorder(Color.RED, 1, true));
        labelInfo = new JLabel("Enter your name :");
        labelInfo.setForeground(Color.RED);
        labelInfo.setFont(new Font("SERIF", Font.BOLD, 20));
        icon = new JLabel(new ImageIcon(urlPlayer));
        buttonBack = new JButton("Back");
        buttonBack.addActionListener(aclsner);
        buttonBack.setActionCommand("mainMenu");
        buttonBack.setPreferredSize(new Dimension(110, 40));
        buttonBack.setForeground(Color.red);
        buttonBack.setFont(new Font("SERIF", Font.BOLD, 20));
        buttonBegin = new JButton("Play");
        buttonBegin.addActionListener(aclsner);
        buttonBegin.setActionCommand("startGame");
        buttonBegin.setPreferredSize(new Dimension(110, 40));
        buttonBegin.setForeground(Color.RED);
        buttonBegin.setFont(new Font("SERIF", Font.BOLD, 20));
        gb1.gridx = gb1.gridy = 0;
        gb1.gridwidth = 2;
        gb1.ipady = 50;
        panelforUserCreation.add(labelInfo, gb1);
        gb1.gridy++;
        panelforUserCreation.add(icon, gb1);
        gb1.gridy++;
        gb1.ipady = 0;
        panelforUserCreation.add(userName, gb1);
        gb1.gridy++;
        gb1.insets = new Insets(15, 0, 0, 0);
        gb1.gridwidth = 1;
        panelforUserCreation.add(buttonBack, gb1);
        gb1.gridx++;
        gb1.insets = new Insets(15, 0, 0, 0);
        panelforUserCreation.add(buttonBegin, gb1);
        add(panelforUserCreation, BorderLayout.CENTER);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
   //removes GUI used for receiving players for the game
    public void deletePlayerPanel() {
        try{
        remove(panelforUserCreation);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //removes GUI for selecting game mode
    public void hideSelectGameMode() {
        try{
        remove(gameMode);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //prepares GUI for selecting game mode either single player mode or multiplayer mode
    public void selectGameMode() {
        try{
        gameMode = new JPanel(new GridBagLayout());
        emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(380, 100));
        gb = new GridBagConstraints();
        gb.insets = new Insets(5, 10, 5, 10);
        radio1 = new JRadioButton("  Single-Player Mode");
        radio1.setIcon(new ImageIcon(urlRedRadio));
        radio1.setPreferredSize(new Dimension(380, 50));
        radio1.setForeground(Color.RED);
        radio1.setFont(new Font("SERIF", Font.BOLD, 20));
        radio1.setActionCommand("single");
        radio1.addActionListener(eventGameModeSelection);
        radio2 = new JRadioButton("  Multi-Player Mode");
        radio2.setIcon(new ImageIcon(urlRedRadio));
        radio2.setPreferredSize(new Dimension(380, 50));
        radio2.setForeground(Color.RED);
        radio2.setFont(new Font("SERIF", Font.BOLD, 20));
        radio2.setActionCommand("multi");
        radio2.addActionListener(eventGameModeSelection);
        group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        labelQuestion = new JLabel("  Please select an Option below:");
        labelQuestion.setPreferredSize(new Dimension(380, 180));
        labelQuestion.setForeground(Color.RED);
        labelQuestion.setFont(new Font("SERIF", Font.BOLD, 20));
        buttonNext = new JButton("Next");
        buttonNext.setPreferredSize(new Dimension(170, 50));
        buttonNext.setForeground(Color.RED);
        buttonNext.setFont(new Font("SERIF", Font.BOLD, 20));
        buttonNext.setActionCommand("next");
        buttonNext.addActionListener(eventGameModeSelection);
        buttonPrevious = new JButton("Back");
        buttonPrevious.setPreferredSize(new Dimension(170, 50));
        buttonPrevious.setForeground(Color.RED);
        buttonPrevious.setFont(new Font("SERIF", Font.BOLD, 20));
        buttonPrevious.setActionCommand("back");
        buttonPrevious.addActionListener(eventGameModeSelection);
        gb.gridx = gb.gridy = 0;
        gb.gridwidth = 2;
        gameMode.add(labelQuestion, gb);
        gb.gridy++;
        gameMode.add(radio1, gb);
        gb.gridy++;
        gameMode.add(radio2, gb);
        gb.gridy++;
        gameMode.add(emptyPanel, gb);
        gb.gridy++;
        gb.gridwidth = 1;
        gameMode.add(buttonPrevious, gb);
        gb.gridx++;
        gameMode.add(buttonNext, gb);
        add(gameMode, BorderLayout.CENTER);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //removes menus from JFrame
    public void hideMenus() {
        try{
        remove(screen);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());    
        }
    }
    //ensures that contained objects are rendered occupying less possible space
    public void confirmLayout() {
        try{
        pack();
        setLocationRelativeTo(null);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //revalidates the content hierarchy if changes is made to the hierarchy and 
    //repaints the screen
    public void refreshPanel() {
        try{
        revalidate();
        repaint();
         }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //creates an object of Dice class 
    Dice createDiceObject() {
        try{
        Dice referenceToDiceObject = new Dice();
        return referenceToDiceObject;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //discover current screen height and width in terms of resolution
    public void getScreenDimension() {
        try{
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_WIDTH = (int) screenSize.getWidth();
        SCREEN_HEIGHT = (int) screenSize.getHeight() - 80;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }   
//sets urls for the images used on JButtons 
    void setIconPath() {
        try{
        urlAppIcon = getClass().getResource("GUIComponents/aapIcon.png");
        urlPlayer = getClass().getResource("GUIComponents/player.png");
        urlPlus1 = getClass().getResource("GUIComponents/plus1.png");
        urlMius1 = getClass().getResource("GUIComponents/minus1.png");
        urlBlueRadio = getClass().getResource("GUIComponents/blueRadio.png");
        urlRedRadio = getClass().getResource("GUIComponents/redRadio.png");
        urlHelp = getClass().getResource("GUIComponents/help.png");
        urlDev = getClass().getResource("GUIComponents/dev.png");
        urlSinglePlayerL = getClass().getResource("GUIComponents/singlePlayerL.png");
        urlSinglePlayerR = getClass().getResource("GUIComponents/singlePlayerR.png");
        urlExit = getClass().getResource("GUIComponents/exit.png");
        urlGame = getClass().getResource("GUIComponents/game.png");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }    
    }
    //makes frame visible and sets height width etc for the frame
    public void makeBasicGui() {
        try{
        setIconImage(new ImageIcon(urlAppIcon).getImage());
        setTitle("Welcome to Yachtee ++");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
//shows main menus
    public void showMenus() {
        try{
        screen = new JPanel(new GridLayout(0, 1));
        JButton startButton = new JButton("Play Game  ", new ImageIcon(urlGame));
        startButton.setPreferredSize(new Dimension(400, 120));
        startButton.setForeground(Color.RED);
        startButton.setFont(new Font("SERIF", Font.BOLD, 30));
        startButton.setActionCommand("start");
        startButton.addActionListener(eventMenu);
        JButton helpButton = new JButton("Help           ", new ImageIcon(urlHelp));
        helpButton.setPreferredSize(new Dimension(400, 120));
        helpButton.setForeground(Color.RED);
        helpButton.setFont(new Font("SERIF", Font.BOLD, 30));
        helpButton.setActionCommand("help");
        helpButton.addActionListener(eventMenu);
        JButton aboutButton = new JButton("About        ", new ImageIcon(urlDev));
        aboutButton.setPreferredSize(new Dimension(400, 120));
        aboutButton.setForeground(Color.RED);
        aboutButton.setFont(new Font("SERIF", Font.BOLD, 30));
        aboutButton.setActionCommand("about");
        aboutButton.addActionListener(eventMenu);
        JButton exitButton = new JButton("Exit         ", new ImageIcon(urlExit));
        exitButton.setPreferredSize(new Dimension(400, 120));
        exitButton.setForeground(Color.RED);
        exitButton.setFont(new Font("SERIF", Font.BOLD, 30));
        exitButton.setActionCommand("exit");
        exitButton.addActionListener(eventMenu);
        screen.add(startButton);
        screen.add(helpButton);
        screen.add(aboutButton);
        screen.add(exitButton);
        add(screen, BorderLayout.CENTER);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //disables plus1 and minus1 button
    public void setPlusAndMinusButtonDisabled() {
        try{
        plus1Button.setEnabled(false);
        minus1Button.setEnabled(false);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //creates GUI for rolling dice for player
    public void createPlayBoard(Player p) {
        try{
        playerObject.current_player = p;
        setTitle("Welcome to Yachtee ++ : " + playerObject.current_player.getName() + " 's turn");
        font = new Font("SERIF", Font.BOLD, 15);
        confirmButton = new JButton("Confirm");
        confirmButton.setFont(font);
        confirmButton.setActionCommand("confirm");
        confirmButton.addActionListener(this);   
        reScoreButton=new JButton();
        if(!p.score.reScored)
        {
            reScoreButton.setText("Re-Score");
        }
        else
        {
            reScoreButton.setText("Re-Scored !");
            reScoreButton.setEnabled(false);
            reScoringMode=false;
        }
        reScoreButton.setFont(font);
        reScoreButton.setActionCommand("rescore");
        reScoreButton.addActionListener(this);
        rollButton = new JButton("First Roll");
        rollButton.setFont(font);
        rollButton.setActionCommand("roll1");
        rollButton.addActionListener(this);
        powerRollButton = new JButton("Power-Roll");
        powerRollButton.setFont(font);
        powerRollButton.addActionListener(this);
        powerRollButton.setActionCommand("proll");
        plus1Button = new JButton(new ImageIcon(urlPlus1));
        plus1Button.setPreferredSize(new Dimension(35, 35));
        plus1Button.setActionCommand("plus1");
        plus1Button.addActionListener(this);
        minus1Button = new JButton(new ImageIcon(urlMius1));
        minus1Button.setPreferredSize(new Dimension(35, 35));
        minus1Button.setActionCommand("minus1");
        minus1Button.addActionListener(this);
        setPlusAndMinusButtonDisabled();
        labelPlayer = new JLabel(playerObject.current_player.getName(), new ImageIcon(urlSinglePlayerL), JLabel.HORIZONTAL);
        labelPlayer.setFont(font);
        labelPlayer.setForeground(Color.WHITE);
        labelPlayer.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        labelPlayer.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .3), (int) (SCREEN_HEIGHT * .09)));
        labelNotice = new JLabel("Notice");
        labelNotice.setFont(font);
        labelNotice.setForeground(Color.WHITE);
        noticePanel = new JPanel();
        noticePanel.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .7), (int) (SCREEN_HEIGHT * .1)));
        noticePanel.setBackground(Color.GRAY);
        noticePanel.add(labelNotice);
        controlPanel = new JPanel(new GridLayout(0, 1));
        controlPanel.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .7), (int) (SCREEN_HEIGHT * .2)));
        subControlPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subControlPanel1.add(rollButton);
        subControlPanel1.setBackground(Color.GRAY);
        subControlPanel1.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .5), (int) (SCREEN_HEIGHT * .2)));
        subControlPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        subControlPanel2.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .5), (int) (SCREEN_HEIGHT * .2)));
        subControlPanel2.setBackground(Color.GRAY);
        subControlPanel2.add(powerRollButton);
        subControlPanel2.add(plus1Button);
        subControlPanel2.add(minus1Button);
        subControlPanel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        subControlPanel3.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .7), (int) (SCREEN_HEIGHT * .2)));
        subControlPanel3.setBackground(Color.GRAY);
        subControlPanel3.add(reScoreButton);
        subControlPanel3.add(confirmButton);
        controlPanel.add(subControlPanel1);
        controlPanel.add(subControlPanel2);
        controlPanel.add(subControlPanel3);
        label[0] = new JLabel("Upper Section score ");
        label[0].setFont(font);
        label[5] = new JLabel("Fives");
        label[5].setFont(font);
        label[1] = new JLabel("Ones");
        label[6] = new JLabel("Sixes");
        label[1].setFont(font);
        label[6].setFont(font);
        label[2] = new JLabel("Twos");
        label[2].setFont(font);
        label[3] = new JLabel("Threes");
        label[3].setFont(font);
        label[4] = new JLabel("Fours");
        label[4].setFont(font);
        textOnes = new JTextField(2);
        textOnes.setFont(font);
        textOnes.setName("ones");
        textOnes.setEditable(false);
        textOnes.addMouseListener(this);
        if (playerObject.current_player.score.ones == null) {
            textOnes.setText("");
        } else {
            textOnes.setText(String.valueOf(playerObject.current_player.score.ones));
            textOnes.setForeground(Color.LIGHT_GRAY);
            textOnes.setEnabled(false);
        }
        textTwos = new JTextField(2);
        textTwos.setEditable(false);
        textTwos.setName("twos");
        textTwos.setFont(font);
        textTwos.addMouseListener(this);
        if (playerObject.current_player.score.twos == null) {
            textTwos.setText("");
        } else {
            textTwos.setText(String.valueOf(playerObject.current_player.score.twos));
            textTwos.setForeground(Color.LIGHT_GRAY);
            textTwos.setEnabled(false);
        }
        textThrees = new JTextField(2);
        textThrees.setEditable(false);
        textThrees.setName("threes");
        textThrees.addMouseListener(this);
        textThrees.setFont(font);
        if (playerObject.current_player.score.threes == null) {
            textThrees.setText("");
        } else {
            textThrees.setText(String.valueOf(playerObject.current_player.score.threes));
            textThrees.setForeground(Color.LIGHT_GRAY);
            textThrees.setEnabled(false);
        }
        textFours = new JTextField(2);
        textFours.setEditable(false);
        textFours.setName("fours");
        textFours.addMouseListener(this);
        textFours.setFont(font);
        if (playerObject.current_player.score.fours == null) {
            textFours.setText("");
        } else {
            textFours.setText(String.valueOf(playerObject.current_player.score.fours));
            textFours.setForeground(Color.LIGHT_GRAY);
            textFours.setEnabled(false);
        }
        textFives = new JTextField(2);
        textFives.setEditable(false);
        textFives.setName("fives");
        textFives.addMouseListener(this);
        textFives.setFont(font);
        if (playerObject.current_player.score.fives == null) {
            textFives.setText("");
        } else {
            textFives.setText(String.valueOf(playerObject.current_player.score.fives));
            textFives.setForeground(Color.LIGHT_GRAY);
            textFives.setEnabled(false);
        }
        textSixes = new JTextField(2);
        textSixes.setEditable(false);
        textSixes.addMouseListener(this);
        textSixes.setFont(font);
        textSixes.setName("sixes");
        if (playerObject.current_player.score.sixes == null) {
            textSixes.setText("");
        } else {
            textSixes.setText(String.valueOf(playerObject.current_player.score.sixes));
            textSixes.setForeground(Color.LIGHT_GRAY);
            textSixes.setEnabled(false);
        }
        /* ------------------- end of components for upper section scoreboard -----*/
        WPanel = new JPanel();
        WPanel.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .3), SCREEN_HEIGHT));
        WPanel.setBackground(Color.LIGHT_GRAY);
        upperSection = new JPanel(new GridBagLayout());
        upperSection.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .3), (int) (SCREEN_HEIGHT * .4)));
        upperSection.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        upperSection.setBackground(Color.LIGHT_GRAY);
        g1 = new GridBagConstraints();
        g1.insets = new Insets(0, 0, 10, 0);
        g1.gridx = g1.gridy = 0;
        g1.gridwidth = 2;
        upperSection.add(label[0], g1);
        g1.insets = new Insets(0, 0, 0, 0);
        g1.gridwidth = 1;
        g1.gridy++;
        upperSection.add(label[1], g1);
        g1.gridx++;
        upperSection.add(textOnes, g1);
        g1.gridy++;
        g1.gridx = 0;
        upperSection.add(label[2], g1);
        g1.gridx++;
        upperSection.add(textTwos, g1);
        g1.gridy++;
        g1.gridx = 0;
        upperSection.add(label[3], g1);
        g1.gridx++;
        upperSection.add(textThrees, g1);
        g1.gridy++;
        g1.gridx = 0;
        upperSection.add(label[4], g1);
        g1.gridx++;
        upperSection.add(textFours, g1);
        g1.gridy++;
        g1.gridx = 0;
        upperSection.add(label[5], g1);
        g1.gridx++;
        upperSection.add(textFives, g1);
        g1.gridy++;
        g1.gridx = 0;
        upperSection.add(label[6], g1);
        g1.gridx++;
        upperSection.add(textSixes, g1);
        /*  lower score panel constructions  */
        lowerSection = new JPanel(new GridBagLayout());
        lowerSection.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .3), (int) (SCREEN_HEIGHT * .4)));
        lowerSection.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2, true));
        lowerSection.setBackground(Color.LIGHT_GRAY);
        g2 = new GridBagConstraints();
        g2.gridx = g2.gridy = 0;
        label[9] = new JLabel("Lower Section Score");
        label[9].setFont(font);
        label[10] = new JLabel("Three of a Kind");
        kind3 = new JTextField(2);
        kind3.setEditable(false);
        label[10].setFont(font);
        kind3.setFont(font);
        kind3.setName("kind3");
        kind3.addMouseListener(this);
        if (playerObject.current_player.score.threeOfaKind != null) {
            kind3.setText(String.valueOf(playerObject.current_player.score.threeOfaKind));
            kind3.setForeground(Color.LIGHT_GRAY);
            kind3.setEnabled(false);
        }
        label[11] = new JLabel("Four of a Kind");
        kind4 = new JTextField(2);
        kind4.setName("kind4");
        label[11].setFont(font);
        kind4.setFont(font);
        kind4.setEditable(false);
        kind4.addMouseListener(this);
        if (playerObject.current_player.score.fourOfaKind != null) {
            kind4.setText(String.valueOf(playerObject.current_player.score.fourOfaKind));
            kind4.setForeground(Color.LIGHT_GRAY);
            kind4.setEnabled(false);
        }
        label[12] = new JLabel("Small Straight");
        textSmallStraight = new JTextField(2);
        textSmallStraight.setName("s_straight");
        label[12].setFont(font);
        textSmallStraight.setFont(font);
        textSmallStraight.setEditable(false);
        textSmallStraight.addMouseListener(this);
        if (playerObject.current_player.score.smallStraignt != null) {
            textSmallStraight.setText(String.valueOf(playerObject.current_player.score.smallStraignt));
            textSmallStraight.setForeground(Color.LIGHT_GRAY);
            textSmallStraight.setEnabled(false);
        }
        label[13] = new JLabel("Large Straight");
        textLargeStraight = new JTextField(2);
        textLargeStraight.setName("l_straight");
        label[13].setFont(font);
        textLargeStraight.setFont(font);
        textLargeStraight.setEditable(false);
        textLargeStraight.addMouseListener(this);
        if (playerObject.current_player.score.largeStraing != null) {
            textLargeStraight.setText(String.valueOf(playerObject.current_player.score.largeStraing));
            textLargeStraight.setForeground(Color.LIGHT_GRAY);
            textLargeStraight.setEnabled(false);
        }
        label[14] = new JLabel("Full House");
        textFullHouse = new JTextField(2);
        textFullHouse.setName("fullhouse");
        label[14].setFont(font);
        textFullHouse.setFont(font);
        textFullHouse.setEditable(false);
        textFullHouse.addMouseListener(this);
        if (playerObject.current_player.score.fullHouse != null) {
            textFullHouse.setText(String.valueOf(playerObject.current_player.score.fullHouse));
            textFullHouse.setForeground(Color.LIGHT_GRAY);
            textFullHouse.setEnabled(false);
        }
        label[15] = new JLabel("YAHTZEE !!");
        textYahtzee = new JTextField(2);
        textYahtzee.setName("Y");
        label[15].setFont(font);
        textYahtzee.setFont(font);
        textYahtzee.setEditable(false);
        textYahtzee.addMouseListener(this);
        if (playerObject.current_player.score.yachtee != null) {
            textYahtzee.setText(String.valueOf(playerObject.current_player.score.yachtee));
            textYahtzee.setForeground(Color.LIGHT_GRAY);
            textYahtzee.setEnabled(false);
        }
        label[16] = new JLabel("Chance");
        textChance = new JTextField(2);
        textChance.setName("chance");
        label[16].setFont(font);
        textChance.setFont(font);
        textChance.setEditable(false);
        textChance.addMouseListener(this);
        if (playerObject.current_player.score.chance != null) {
            textChance.setText(String.valueOf(playerObject.current_player.score.chance));
            textChance.setForeground(Color.LIGHT_GRAY);
            textChance.setEnabled(false);
        }
        label[17] = new JLabel("Bonus for extra Yahtzee");
        textExtraYahtzeeBonus = new JTextField(2);
        textExtraYahtzeeBonus.setName("xYbonus");
        label[17].setFont(font);
        textExtraYahtzeeBonus.setFont(font);
        textExtraYahtzeeBonus.setEditable(false);
        textExtraYahtzeeBonus.setForeground(Color.LIGHT_GRAY);
        if (playerObject.current_player.score.bonusForYachtee != null) {
            textExtraYahtzeeBonus.setText(String.valueOf(playerObject.current_player.score.bonusForYachtee));
        }
        label[18] = new JLabel("Grand Total");
        textGrandTotal = new JTextField(2);
        textGrandTotal.setName("gtotal");
        label[18].setFont(font);
        textGrandTotal.setFont(font);
        textGrandTotal.setEditable(false);
        textGrandTotal.setForeground(Color.LIGHT_GRAY);
        g2.insets = new Insets(0, 0, 10, 0);
        g2.gridwidth = 2;
        lowerSection.add(label[9], g2);
        g2.gridwidth = 1;
        g2.gridy++;
        g2.insets = new Insets(0, 5, 0, 0);
        lowerSection.add(label[10], g2);
        g2.gridx++;
        lowerSection.add(kind3, g2);
        g2.gridy++;
        g2.gridx = 0;
        lowerSection.add(label[11], g2);
        g2.gridx++;
        lowerSection.add(kind4, g2);
        g2.gridy++;
        g2.gridx = 0;
        lowerSection.add(label[12], g2);
        g2.gridx++;
        lowerSection.add(textSmallStraight, g2);
        g2.gridy++;
        g2.gridx = 0;
        lowerSection.add(label[13], g2);
        g2.gridx++;
        lowerSection.add(textLargeStraight, g2);
        g2.gridx = 0;
        g2.gridy++;
        lowerSection.add(label[14], g2);
        g2.gridx++;
        lowerSection.add(textFullHouse, g2);
        g2.gridx = 0;
        g2.gridy++;
        lowerSection.add(label[15], g2);
        g2.gridx++;
        lowerSection.add(textYahtzee, g2);
        g2.gridy++;
        g2.gridx = 0;
        lowerSection.add(label[16], g2);
        g2.gridx++;
        lowerSection.add(textChance, g2);
        g2.gridy++;
        g2.gridx = 0;
        lowerSection.add(label[17], g2);
        g2.gridx++;
        lowerSection.add(textExtraYahtzeeBonus, g2);
        g2.gridy++;
        g2.gridx = 0;
        lowerSection.add(label[18], g2);
        g2.gridx++;
        lowerSection.add(textGrandTotal, g2);
        EPanel = new JPanel(new BorderLayout());
        EPanel.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .7), SCREEN_HEIGHT));
        EPanel.setBackground(Color.black);
        diceObject.createDicePanel();
        diceObject.beforeRoll();
        diceObject.addDices();
        EPanel.add(noticePanel, BorderLayout.NORTH);
        addDicePanelToPlayBoard();
        EPanel.add(controlPanel, BorderLayout.SOUTH);

        WPanel.add(labelPlayer, BorderLayout.NORTH);
        WPanel.add(upperSection, BorderLayout.CENTER);
        WPanel.add(lowerSection, BorderLayout.SOUTH);
        add(WPanel, BorderLayout.WEST);
        add(EPanel, BorderLayout.EAST);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

   //removes GUI for rolling dice for player from frame
    public void removePlayBoard() {
        try{
        remove(EPanel);
        remove(WPanel);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //enables plus1 and minus1 button
    public void setPlusAndMinusButtonEnabled() {
        try{
        plus1Button.setEnabled(true);
        minus1Button.setEnabled(true);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //removes panel containing five dices from GUI created for rollng dice 
    public void removeDicePanelFromPlayBoard() {
        try{
        EPanel.remove(diceObject.getReferenceToDicePanel());
    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //sets action listners to listen no appropriate actions before it is rolled
    public void deleteDefaultActionListenerFromDices() {
        try{
        for (int i = 0; i < 5; i++) {
            if (diceObject.dices[i].isEnabled()) {
                diceObject.dices[i].removeActionListener(this);
                diceObject.dices[i].setBackground(Color.yellow);
            }
        }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        switch (e.getActionCommand()) {

            case "Roll":
                trigger1.start();
                refreshPanel();
                break;
            case "Stop":
                break;
            case "begin":
                if (!verifyIfAllPlayerTossed()) {
                
                    JOptionPane.showMessageDialog(null, "All players must roll the dices\nbefore "
                            + "the game can proceed further !", "Information...", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    removeTurnFixer();
                    createPlayBoard(playerObject.getPlayerInOrder(Player.SORTEDTOTAL_IN_DESCENDING[CURRENT_TURN]));
                    confirmLayout();
                    refreshPanel();
                }
                break;

            case "rescore":
                    if(checkIfAnyCategorryIsScored()&& rollButton.getText().equals("First Roll")) {
                    reScoringMode=true;
                    labelNotice.setText("You are about to Rescore a category ! you can you this option only once throughout the game");
                    reScoreButton.setEnabled(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "You cant choose to rescore at the moment", "Stop !", JOptionPane.INFORMATION_MESSAGE);
                    }
                break;
            case "confirm":
                            if(!alreadyScored){
                            JOptionPane.showMessageDialog(null,"Please , select a score category first !","Stop !",JOptionPane.INFORMATION_MESSAGE);
                            }
                            else {
                        alreadyScored=false;
                        labelNotice.setText("");
                        if (diceObject.bufferDice != null) {
                            diceObject.bufferDice = null;
                        }

                        if (CURRENT_TURN < Player.NUM_OF_PLAYERS - 1) {
                            CURRENT_TURN++;

                            diceObject.resetMirrorButtons();
                            removePlayBoard();

                            createPlayBoard(playerObject.getPlayerInOrder(Player.SORTEDTOTAL_IN_DESCENDING[CURRENT_TURN]));
                            setPlusAndMinusButtonDisabled();
                            confirmLayout();
                            refreshPanel();

                        } else {
                            CURRENT_TURN = 0;

                            diceObject.resetMirrorButtons();
                            removePlayBoard();
                            if (Player.NUM_OF_PLAYERS > 1) {
                                createPlayBoard(playerObject.getPlayerInOrder(Player.SORTEDTOTAL_IN_DESCENDING[CURRENT_TURN]));
                            } else {
                                createPlayBoard(playerObject.current_player);
                            }
                            setPlusAndMinusButtonDisabled();
                            confirmLayout();
                            refreshPanel();
                        }

                        if (!powerRollButton.isEnabled()) {
                            powerRollButton.setEnabled(true);
                        }
                         }
                break;

            case "roll1":
                rollButton.setText("Second Roll");
                rollButton.setActionCommand("roll2");
                removeDicePanelFromPlayBoard();
                diceObject.createDicePanel();
                diceObject.duringRoll();
                trigger2.start();
                diceObject.addDices();
                addDicePanelToPlayBoard();

                if (!powerRollButton.isEnabled()) {
                    powerRollButton.setEnabled(true);
                }

                setPlusAndMinusButtonDisabled();
                confirmLayout();
                refreshPanel();
                break;

            case "roll2":
                labelNotice.setText("");
                diceObject.bufferDice = null;
                diceObject.findDisabledDice();
                removeDicePanelFromPlayBoard();
                diceObject.createDicePanel();
                diceObject.rollOnlyDeselectedDices();
                trigger2.start();
                diceObject.addDices();
                addDicePanelToPlayBoard();
                confirmLayout();
                refreshPanel();
                setPlusAndMinusButtonDisabled();
                rollButton.setText("Third Roll");
                rollButton.setActionCommand("roll3");
                if (!powerRollButton.isEnabled()) {
                    powerRollButton.setEnabled(true);
                }
                break;

            case "roll3":
                labelNotice.setText("");
                diceObject.bufferDice = null;
                diceObject.findDisabledDice();
                removeDicePanelFromPlayBoard();
                diceObject.createDicePanel();
                diceObject.rollOnlyDeselectedDices();
                trigger2.start();
                diceObject.addDices();
                addDicePanelToPlayBoard();
                setPlusAndMinusButtonDisabled();
                disableButtons();
                confirmLayout();
                refreshPanel();

                //need to put here and additional code here
                //for checking random operation 
                if (!powerRollButton.isEnabled()) {
                    powerRollButton.setEnabled(true);
                }
                rollButton.setEnabled(false);
                break;

            case "proll":

                if (!rollButton.getActionCommand().equals("roll1")) {
                    labelNotice.setText("You are using Power Roll Mode now. The very first dice you click will be selected to roll up or down.");
                    powerRollButton.setEnabled(false);
                    setPlusAndMinusButtonEnabled();
                    deleteDefaultActionListenerFromDices();
                    diceObject.addTemporaryActionListenerToDices();
                }
                break;

            case "plus1":
                diceObject.updateDiceAfterPowerRollOperation("add1");
                if(!reScoringMode){
                    scoreAnalyzier();
                }
                else{
                    scoreAnalyzierUnderResoringMode();    
                }
                confirmLayout();
                refreshPanel();
                plus1Button.setEnabled(false);
                break;

            case "minus1":
                diceObject.updateDiceAfterPowerRollOperation("substract1");
                if(!reScoringMode){
                    scoreAnalyzier();
                }
                else{
                    scoreAnalyzierUnderResoringMode();    
                }
                confirmLayout();
                refreshPanel();
                minus1Button.setEnabled(false);

                break;

            default:
                JButton btn = (JButton) e.getSource();
                if (btn.isEnabled()) {
                    btn.setEnabled(false);
                } else {
                    btn.setEnabled(true);
                }

                break;
        }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    //function for determining if grandtotal for each player is calculated
    public boolean checkIsGameOver() {
        try{

        for (int i = 0; i < Player.NUM_OF_PLAYERS; i++) {
            if (playerObject.players[i].score.grandTotal == null) {
                return false;
            }
        }
        return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    //assigns values to the Score attributes for each players on clicking the textboxes
    public void mouseClicked(MouseEvent e) {
        try{
        JTextField instance = (JTextField) e.getSource();
        Integer i;
        if(!alreadyScored){
        switch (instance.getName()) {
            case "ones":
                        if (!textOnes.getText().equals("")&& textOnes.isEnabled()) {
                        playerObject.current_player.score.ones = 2*Integer.parseInt(textOnes.getText());
                        alreadyScored=true;
                        textOnes.setText(String.valueOf(playerObject.current_player.score.ones));
                        textOnes.setForeground(Color.LIGHT_GRAY);
                        
                        if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                        }
                        disableButtons();
                        if (checkForGrandTotal() != null) {
                                {
                                    textGrandTotal.setText(String.valueOf(checkForGrandTotal()));
                                    playerObject.current_player.score.grandTotal = checkForGrandTotal();

                                    if (checkIsGameOver()) {
                                        JOptionPane.showMessageDialog(null, "game Over");
                                        removePlayBoard();
                                        loadScoreBoard();
                                        confirmLayout();
                                        refreshPanel();
                                }
                            }
                        }
                    
                }
                break;
                
            case "twos":
                if (!textTwos.getText().equals("")&&textTwos.isEnabled()) {
                    playerObject.current_player.score.twos = 2*Integer.parseInt(textTwos.getText());
                    alreadyScored=true;
                    textTwos.setForeground(Color.LIGHT_GRAY);
                    textTwos.setText(String.valueOf(playerObject.current_player.score.twos));
                    
                    if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                    }
                    disableButtons();
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;

                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "threes":
                if (!textThrees.getText().equals("")&&textThrees.isEnabled()) {
                    playerObject.current_player.score.threes = 2*Integer.parseInt(textThrees.getText());
                    alreadyScored=true;
                    textThrees.setForeground(Color.LIGHT_GRAY);
                    textThrees.setText(String.valueOf(playerObject.current_player.score.threes));
                    
                    if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                        }
                    disableButtons();
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;

                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
                
            case "fours":
                if (!textFours.getText().equals("") &&textFours.isEnabled()) {
                    playerObject.current_player.score.fours = 2*Integer.parseInt(textFours.getText());
                    alreadyScored=true;
                    textFours.setForeground(Color.LIGHT_GRAY);
                    textFours.setText(String.valueOf(playerObject.current_player.score.fours));
                    
                    if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                        }
                    disableButtons();
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;

                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "fives":
                if (!textFives.getText().equals("") && textFives.isEnabled()) {
                    playerObject.current_player.score.fives = 2*Integer.parseInt(textFives.getText());
                    alreadyScored=true;
                    textFives.setForeground(Color.LIGHT_GRAY);
                    textFives.setText(String.valueOf(playerObject.current_player.score.fives));
                    
                    if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                        }
                    disableButtons();
                    
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;
                        
                       if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "sixes":
                if (!textSixes.getText().equals("")&&textSixes.isEnabled()) {
                    playerObject.current_player.score.sixes = 2*Integer.parseInt(textSixes.getText());
                    alreadyScored=true;
                    textSixes.setForeground(Color.LIGHT_GRAY);
                    textSixes.setText(String.valueOf(playerObject.current_player.score.sixes));
                    
                    if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                        }
                    
                    disableButtons();
                    
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;

                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "kind3":
                if (!kind3.getText().equals("")&&kind3.isEnabled()) {
                    playerObject.current_player.score.threeOfaKind = Integer.parseInt(kind3.getText());
                    alreadyScored=true;
                    kind3.setForeground(Color.LIGHT_GRAY);
                    
                    if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                        }
                    
                    disableButtons();
                    
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;

                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "kind4":
                if (!kind4.getText().equals("")&& kind4.isEnabled()) {
                    playerObject.current_player.score.fourOfaKind = Integer.parseInt(kind3.getText());
                    alreadyScored=true;
                    kind4.setForeground(Color.LIGHT_GRAY);
                    
                    if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                        }
                    disableButtons();
                    
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;

                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;

            case "l_straight":
                if (!textLargeStraight.getText().equals("")&&textLargeStraight.isEnabled()) {
                    playerObject.current_player.score.largeStraing = Integer.parseInt(textLargeStraight.getText());
                    alreadyScored=true;
                    textLargeStraight.setForeground(Color.LIGHT_GRAY);
                    disableButtons();
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;
                        
                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "s_straight":
                if (!textSmallStraight.getText().equals("")&& textSmallStraight.isEnabled()) {
                    playerObject.current_player.score.smallStraignt = Integer.parseInt(textSmallStraight.getText());
                    alreadyScored=true;
                    textSmallStraight.setForeground(Color.LIGHT_GRAY);
                    
                    disableButtons();
                    
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;
                        
                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "fullhouse":
                if (!textFullHouse.getText().equals("")&&textFullHouse.isEnabled() ) {
                    playerObject.current_player.score.fullHouse = Integer.parseInt(textFullHouse.getText());
                    alreadyScored=true;
                    textFullHouse.setForeground(Color.LIGHT_GRAY);
                    
                    disableButtons();
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;

                       if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "Y":
                if (!textYahtzee.getText().equals("")&&textYahtzee.isEnabled()) {
                    playerObject.current_player.score.yachtee = Integer.parseInt(textYahtzee.getText());
                    alreadyScored=true;
                    textYahtzee.setForeground(Color.LIGHT_GRAY);
                    disableButtons();
                    
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;
                        
                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
                break;
            case "chance":
                if (!textChance.getText().equals("")&& textChance.isEnabled()) {
                    playerObject.current_player.score.chance = Integer.parseInt(textChance.getText());
                    alreadyScored=true;
                    textChance.setForeground(Color.LIGHT_GRAY);
                    textChance.setText(String.valueOf(playerObject.current_player.score.chance));
                    
                    if(reScoringMode){
                            reScoringMode=false;
                            playerObject.current_player.score.reScored=true;
                        }
                    
                    disableButtons();
                    
                    if ((i = checkForGrandTotal()) != null) {
                        textGrandTotal.setText(String.valueOf(i));
                        playerObject.current_player.score.grandTotal = i;

                        if (checkIsGameOver()) {
                            JOptionPane.showMessageDialog(null, "game Over");
                            removePlayBoard();
                            loadScoreBoard();
                            confirmLayout();
                            refreshPanel();
                        }
                    }
                }
            default:
                   break;
        }
        }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
            try{
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
            try{
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    
            try{
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    
            try{
            }
            catch(Exception ex)
            {
                System.out.println(ex.getMessage());
            }
    }

    //provides summary of individual scores as well as grand total at the end of the game
    void loadScoreBoard() {
        try{
        scoreTableModel = new DefaultTableModel();
        scoreTableModel.addColumn("Player Name");
        scoreTableModel.addColumn("Ones");
        scoreTableModel.addColumn("Twos");
        scoreTableModel.addColumn("Threes");
        scoreTableModel.addColumn("Fours");
        scoreTableModel.addColumn("Fives");
        scoreTableModel.addColumn("Sixes");
        scoreTableModel.addColumn("3ofAkind");
        scoreTableModel.addColumn("4ofAkind");
        scoreTableModel.addColumn("Small Strt");
        scoreTableModel.addColumn("Large Strt");
        scoreTableModel.addColumn("FullHouse");
        scoreTableModel.addColumn("Yachtzee");
        scoreTableModel.addColumn("Chance");
        scoreTableModel.addColumn("Bonus");
        scoreTableModel.addColumn("Total");
        scoreTable = new JTable(scoreTableModel);
        scoreTable.setRowHeight(20);
        scoreTable.getColumnModel().getColumn(0).setPreferredWidth(160);
        scoreTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        scoreTable.getColumnModel().getColumn(2).setPreferredWidth(40);
        scoreTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        scoreTable.getColumnModel().getColumn(4).setPreferredWidth(40);
        scoreTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        scoreTable.getColumnModel().getColumn(6).setPreferredWidth(40);
        scoreTable.getColumnModel().getColumn(7).setPreferredWidth(60);
        scoreTable.getColumnModel().getColumn(8).setPreferredWidth(60);
        scoreTable.getColumnModel().getColumn(9).setPreferredWidth(60);
        scoreTable.getColumnModel().getColumn(10).setPreferredWidth(60);
        scoreTable.getColumnModel().getColumn(11).setPreferredWidth(60);
        scoreTable.getColumnModel().getColumn(12).setPreferredWidth(50);
        scoreTable.getColumnModel().getColumn(13).setPreferredWidth(50);
        scoreTable.getColumnModel().getColumn(14).setPreferredWidth(50);
        scoreTable.getColumnModel().getColumn(15).setPreferredWidth(60);
        scoreTable.getTableHeader().setBackground(Color.LIGHT_GRAY);
        scoreTable.getTableHeader().setEnabled(false);
        scoreTable.getTableHeader().setFont(new Font("SERIF", Font.BOLD, 15));
        scoreTable.setFont(new Font("SERIF", Font.BOLD, 15));
        writePlayerScoresToScoreBoard();
        scoreTablePane = new JScrollPane(scoreTable);
        scoreTablePane.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .95f), (int) (SCREEN_HEIGHT * .4f)));

        scoreBoardNorthPanel = new JPanel(new GridBagLayout());

        scoreBoardCentralPanel = new JPanel(new GridBagLayout());
        gb4SBCP = new GridBagConstraints();

        scoreBoardCentralPanel.add(scoreTablePane);
        scoreBoardSouthPanel = new JPanel(new GridBagLayout());
        gb4SBSP = new GridBagConstraints();
        gb4SBSP.insets = new Insets(0, 5, 10, 0);
        btnExit = new JButton("Exit");
        btnExit.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .1f), (int) (SCREEN_HEIGHT * .05f)));
        btnExit.setFont(new Font("SERIF", Font.BOLD, 15));
        btnExit.setActionCommand("exit");
        btnExit.addActionListener(eventMenu);

        btnMainMenu = new JButton("Main Menu");
        btnMainMenu.setPreferredSize(new Dimension((int) (SCREEN_WIDTH * .1f), (int) (SCREEN_HEIGHT * .05f)));
        btnMainMenu.setFont(new Font("SERIF", Font.BOLD, 15));
        btnMainMenu.setActionCommand("mainMenu");
        btnMainMenu.addActionListener(eventMenu);

        gb4SBSP.gridx = gb4SBSP.gridy = 0;
        scoreBoardSouthPanel.add(btnMainMenu, gb4SBSP);
        gb4SBSP.gridx++;
        scoreBoardSouthPanel.add(btnExit, gb4SBSP);
        JLabel scoreBoardlabel;
        scoreBoardlabel = new JLabel("Game Score Summary");
        scoreBoardlabel.setFont(new Font("SERIF", Font.BOLD, 30));
        scoreBoardlabel.setForeground(Color.WHITE);

        setTitle(" Yachtzee - ScoreBoard ");
        scoreBoardNorthPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, (int) (SCREEN_HEIGHT * .2f)));
        scoreBoardNorthPanel.add(scoreBoardlabel);
        scoreBoardNorthPanel.setBorder(BorderFactory.createLineBorder(Color.yellow, 2, true));
        scoreBoardNorthPanel.setBackground(Color.red);

        scoreBoardCentralPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, (int) (SCREEN_HEIGHT * .7f)));
        scoreBoardSouthPanel.setPreferredSize(new Dimension(SCREEN_WIDTH, (int) (SCREEN_HEIGHT * .1f)));

        add(scoreBoardNorthPanel, BorderLayout.NORTH);
        add(scoreBoardCentralPanel, BorderLayout.CENTER);
        add(scoreBoardSouthPanel, BorderLayout.SOUTH);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    //writes score from each players to the JTable on scoreboard at the end of the game
    public void writePlayerScoresToScoreBoard() {
        try{
        alreadyScored=false;
        for (int i = 0; i < Player.NUM_OF_PLAYERS; i++) {
            scoreTableModel.addRow(new Object[]{playerObject.players[i].name,
                String.valueOf(playerObject.players[i].score.ones),
                String.valueOf(playerObject.players[i].score.twos),
                String.valueOf(playerObject.players[i].score.threes),
                String.valueOf(playerObject.players[i].score.fours),
                String.valueOf(playerObject.players[i].score.fives),
                String.valueOf(playerObject.players[i].score.sixes),
                String.valueOf(playerObject.players[i].score.threeOfaKind),
                String.valueOf(playerObject.players[i].score.fourOfaKind),
                String.valueOf(playerObject.players[i].score.smallStraignt),
                String.valueOf(playerObject.players[i].score.largeStraing),
                String.valueOf(playerObject.players[i].score.fullHouse),
                String.valueOf(playerObject.players[i].score.yachtee),
                String.valueOf(playerObject.players[i].score.chance),
                String.valueOf(playerObject.players[i].score.bonusForYachtee),
                String.valueOf(playerObject.players[i].score.grandTotal)

            });
        }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //disables buttons category is selectd and scored
    void disableButtons(){
        try{
        if(rollButton.isEnabled())
            rollButton.setEnabled(false);
        if(powerRollButton.isEnabled())
            powerRollButton.setEnabled(false);
        if(reScoreButton.isEnabled())
            reScoreButton.setEnabled(false);
        if(plus1Button.isEnabled())
        {plus1Button.setEnabled(false);}
        
        if(minus1Button.isEnabled())
        {minus1Button.setEnabled(false);}
    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    //removes scoreboard from JFrame
    void removeScoreBoard() {
        try{
        remove(scoreBoardNorthPanel);
        remove(scoreBoardCentralPanel);
        remove(scoreBoardSouthPanel);
    
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //displays information about the developer who built the game
    void showDevevloperInfo() {
        try{
        Font fontforLabel = new Font("SERIF", Font.PLAIN, 15);
        buttonMainMenu = new JButton("Main Menu");
        buttonMainMenu.addActionListener(eventMenu);
        buttonMainMenu.setActionCommand("main");
        buttonMainMenu.setPreferredSize(new Dimension(170, 50));
        buttonMainMenu.setFont(new Font("SERIF", Font.BOLD, 15));
        buttonMainMenu.setForeground(Color.red);

        gameName = new JLabel("Yachtzee ++ (Developed By) :");
        gameName.setForeground(Color.red);
        gameName.setFont(new Font("SERIF", Font.BOLD, 25));

        devInfoPanel = new JPanel(new GridBagLayout());
        devInfoPanel.setPreferredSize(new Dimension((int) (400), (int) (480f)));
        constraints = new GridBagConstraints();
        constraints.gridx = constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 10, 0);

        devphotoPath = getClass().getResource("GUIComponents/devPhoto.png");
        try {

            devPhoto = new JLabel(new ImageIcon(devphotoPath));
            devPhoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        } catch (NullPointerException e) {

            System.out.println(e.getMessage());
        }
        devName = new JLabel("Suresh Khatri");
        devName.setForeground(Color.red);
        devName.setFont(fontforLabel);
        devAddress = new JLabel("Address :Kalanki-14, Kathmandu");
        devAddress.setForeground(Color.red);
        devAddress.setFont(fontforLabel);
        devContact = new JLabel("Phone : 9808729596");
        devContact.setForeground(Color.red);
        devContact.setFont(fontforLabel);
        devCollege = new JLabel("Softwarica College of IT & E-commerce");
        devCollege.setForeground(Color.red);
        devCollege.setFont(fontforLabel);
        devCollegeBatch = new JLabel("Batch:19 A");
        devCollegeBatch.setForeground(Color.red);
        devCollegeBatch.setFont(fontforLabel);
        devInfoPanel.add(gameName, constraints);
        constraints.gridy++;
        devInfoPanel.add(devPhoto, constraints);
        constraints.gridy++;
        devInfoPanel.add(devName, constraints);
        constraints.gridy++;
        devInfoPanel.add(devContact, constraints);
        constraints.gridy++;
        devInfoPanel.add(devAddress, constraints);
        constraints.gridy++;
        devInfoPanel.add(devCollege, constraints);
        constraints.gridy++;
        devInfoPanel.add(devCollegeBatch, constraints);
        constraints.gridy++;
        devInfoPanel.add(buttonMainMenu, constraints);

        add(devInfoPanel, BorderLayout.CENTER);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    //removes the developerinformation panel from JFrame
    void hideDeveloperInfo() {
        try{
        remove(devInfoPanel);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    
    @Override
    public void showHelp(){
    
        try{
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    
    }   

    
    @Override
    //finds out if any category has been selected before the user can enter the rescoring mode
    public boolean checkIfAnyCategorryIsScored(){
        try{
        if(playerObject.current_player.score.ones != null || playerObject.current_player.score.twos != null || playerObject.current_player.score.threes !=null
                || playerObject.current_player.score.fours != null || playerObject.current_player.score.fives != null || playerObject.current_player.score.sixes != null
                || playerObject.current_player.score.threeOfaKind != null || playerObject.current_player.score.fourOfaKind != null ||
                 playerObject.current_player.score.chance != null) {

    return true;
    }
        return false;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
