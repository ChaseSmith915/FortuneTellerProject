import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FortuneTellerFrame extends JFrame
{
    JFrame frame = new JFrame();
    JPanel mainPnl;
    JPanel topPnl;
    JPanel midPnl;
    JPanel botPnl;

    JLabel titleLbl;
    ImageIcon icon;
    JTextArea displayFortune;
    JScrollPane scroller;

    JButton fortuneButton;
    JButton quitButton;

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTopPanel();
        //mainPnl.add(topPnl, BorderLayout.NORTH);
        createMiddlePanel();
        mainPnl.add(midPnl, BorderLayout.CENTER);
        createBottomPanel();
        mainPnl.add(botPnl, BorderLayout.SOUTH);

        add(mainPnl);

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPanel()
    {

    }
    private void createMiddlePanel()
    {
        midPnl = new JPanel();
        displayFortune = new JTextArea(10,30);
        scroller = new JScrollPane(displayFortune);
        midPnl.add(scroller);
    }
    private void createBottomPanel()
    {
        botPnl = new JPanel();
        botPnl.setLayout(new GridLayout(1,2));
        fortuneButton = new JButton("Read my fortune!");
        quitButton = new JButton("Quit");

        quitButton.addActionListener((ActionEvent ae) -> System.exit(0));

        botPnl.add(fortuneButton);
        botPnl.add(quitButton);


    }
}


