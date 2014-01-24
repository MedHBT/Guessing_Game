package Frames;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuFrame extends JMenuBar implements ActionListener{
	//variables declaration
	private JMenuItem item0;
	private JMenuItem item1;
	private JMenuItem item2;
	private JMenuItem item3;
	private GameFrame gameFrame;
	/*Menu creation*/
	MenuFrame(GameFrame gF){
		
		gameFrame = gF;
		JMenu jmenu = new JMenu("File");
		item0 = new JMenuItem("Restart");
		item1 = new JMenuItem("Reinitialize");
		item2 = new JMenuItem("Exit");
		jmenu.add(item0);
        jmenu.add(item1);
        jmenu.add(item2);
        add(jmenu);
        JMenu jmenu1 = new JMenu("Help");
        item3 = new JMenuItem("About Us");
        jmenu1.add(item3);
        add(jmenu1);
        //associate event with every sub-menu
        item0.addActionListener(this);
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		JOptionPane.setDefaultLocale(Locale.ENGLISH);//set the language of the warning frame to English
		if(e.getSource() == item2 && JOptionPane.showConfirmDialog(this, "Are you sure to Quit ?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION) == 0)
            System.exit(0);
		if(e.getSource() == item0 && JOptionPane.showConfirmDialog(this, "Are you sure you want to restart the game ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0){
			StartFrame startFrame = new StartFrame();
        	startFrame.setVisible(true);
        	gameFrame.setVisible(false);
        	gameFrame.dispose();
		}
        if(e.getSource() == item3)
            JOptionPane.showMessageDialog(this, "Guessing Game v1.0 is a Game developped by Amine Haddad and Mohamed Hassine Ben Taieb ", "About Us", 1);
        if(e.getSource() == item1 && JOptionPane.showConfirmDialog(this, "Are you sure you want to reinitialize the number ?", "Confirmation", JOptionPane.YES_NO_OPTION) == 0)
        {
            gameFrame.nbTry = 1;
            gameFrame.result.setForeground(Color.RED);
            gameFrame.result.setFont(new Font("Serif", 1, 14));
            gameFrame.result.setText((new StringBuilder()).append("Warning, You have ").append(gameFrame.nbMaxTry).append(" tries only... Be strategic !").toString());
            gameFrame.result.setIcon((Icon) gameFrame.openning);
            gameFrame.nbToGuess = (int)(Math.random() * 100D) + 1;
            System.out.println((new StringBuilder()).append("The number to guess is ").append(gameFrame.nbToGuess).append(".").toString());
            gameFrame.nbBox.setText(" ??? ");
            gameFrame.guessField.setText("");
            gameFrame.guessField.setEditable(true);
        }
		
	}

}
