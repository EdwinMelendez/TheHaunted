import javax.swing.*;
import java.awt.*;

/**
 * Created by DarthVader on 3/29/17.
 */
public class GameEngineGui extends JFrame{
    private JPanel rootPanel;
    private JLabel roomName;
    private JTextPane roomDescriptor;
    private JTextField userInputTextField;
    private JTextPane itemList;
    private JTextPane directionList;


    protected GameEngineGui(){
        setContentPane(rootPanel);
        setSize(new Dimension(450, 450));
        setTitle("The Haunted");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

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
