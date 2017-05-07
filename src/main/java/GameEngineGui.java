import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameEngineGui extends JFrame{
    private JPanel rootPanel;
    private JLabel roomName;
    private JTextPane roomDescriptor;
    private JTextField userInputTextField;
    private JTextPane itemList;
    private JTextPane directionList;



    //game engine gui
    protected GameEngineGui(){
        setContentPane(rootPanel);
        setSize(new Dimension(600, 600));
        setTitle("The Haunted");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        itemList.setEditable(false);
        roomDescriptor.setEditable(false);
        directionList.setEditable(false);

        //displays when game is opened.
        roomDescriptor.setText("Welcome to the Haunted: \n\n" +
                "You wake up disoriented in a dark musty room. Type 'look' " +
                "to find out where you are...\n\n" +
                "Type 'help' anytime to see a list of commands");


        //action listeners
        userInputTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //gets text and processes commands and arguments, then resets the user text field
                try {
                    String userInput = userInputTextField.getText();
                    CommandProcessor.ProcessCommand(userInput);
                    userInputTextField.setText("");

                //error moving between rooms
                }catch (Exception E){
                    System.out.println(E);
                    E.printStackTrace();
                    System.out.println("Error moving between rooms");
                }
            }
        });

        //when user clicks the user text field, clears text field
        userInputTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                userInputTextField.setText("");
                userInputTextField.grabFocus();
            }
        });
    }

    //sets text to the right text boxes
    void DisplayRoomName(String text){
        roomName.setText(text);
    }
    void DisplayRoomDescription(String text){
        roomDescriptor.setText(text);
    }
    void DisplayItems(String text){
        itemList.setText(text);
    }
    void DisplayDirections(String text){
        directionList.setText(text);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JLabel getRoomName() {
        return roomName;
    }

    public void setRoomName(JLabel roomName) {
        this.roomName = roomName;
    }

    public JTextPane getRoomDescriptor() {
        return roomDescriptor;
    }

    public void setRoomDescriptor(JTextPane roomDescriptor) {
        this.roomDescriptor = roomDescriptor;
    }

    public JTextField getUserInputTextField() {
        return userInputTextField;
    }

    public void setUserInputTextField(JTextField userInputTextField) {
        this.userInputTextField = userInputTextField;
    }

    public JTextPane getItemList() {
        return itemList;
    }

    public void setItemList(JTextPane itemList) {
        this.itemList = itemList;
    }

    public JTextPane getDirectionList() {
        return directionList;
    }

    public void setDirectionList(JTextPane directionList) {
        this.directionList = directionList;
    }
}
