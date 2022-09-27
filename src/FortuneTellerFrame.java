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
            "At least some time in your life, your program will work on the first attempt",
            "You'll click the fortune button again to get another fortune",
            "A foolish man listens to his heart. A wise man listens to me, Zoltar!",
            "You'll live long enough to click that button at least 5 more times",
            "Never forget your siblings, especially if they owe you",
            "Another student will make this exact fortune",
            "No, there's no cookie, only fortune",
            "You've been blessed with the wisdom of reading",
            "You'll live on to read many more fortunes, but only this one matters",
            "Your shoe's untied",
            "This fortune is worth a fortune",
            "You will not see this fortune twice in a row"
    };
    int curFortuneDex = -1;
    Random rnd = new Random();

    public FortuneTellerFrame()
    {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTopPanel();
        mainPnl.add(topPnl, BorderLayout.NORTH);
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
        topPnl = new JPanel();
        icon = new ImageIcon("src/zoltar.png");
        titleLbl = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setFont(new Font("SansSerif", Font.BOLD, 38));

        topPnl.add(titleLbl);
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


