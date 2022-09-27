import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

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

    String[] fortunes = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15"
    };
    int curFortuneDex = -1;
    Random rnd = new Random();

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

        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createTopPanel()
    {

    }
    private void createMiddlePanel()
    {
        midPnl = new JPanel();
        displayFortune = new JTextArea(10,60);
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
        fortuneButton.addActionListener(
                (ActionEvent ae) -> {
                    int newDex = 0;
                    do {
                        newDex = rnd.nextInt(fortunes.length);
                    } while (newDex == curFortuneDex);
                    curFortuneDex = newDex;
                    displayFortune.append(fortunes[curFortuneDex] + "\n");
                });

        botPnl.add(fortuneButton);
        botPnl.add(quitButton);


    }
}


