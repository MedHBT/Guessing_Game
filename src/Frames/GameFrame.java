package Frames;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class GameFrame extends JFrame implements ActionListener {
	//declare variable
	int nbTry;
    int nbMaxTry;
    ImageIcon openning;
    ImageIcon smaller;
    ImageIcon greater;
    ImageIcon lost;
    ImageIcon win;
    JLabel toguessText;
    JTextField nbBox;
    int nbToGuess;
    JLabel guessText;
    JTextField guessField;
    JButton tryButton;
    JLabel result;
	//end of variable declaration
    
    /*constructor of the main game frame*/
	public GameFrame(){
		super("Guessing Game");
		nbTry = 1;
		nbMaxTry = 6;
		
		setBackground(Color.WHITE);//set the background color
        //load the smiles icon
		openning = new ImageIcon(GameFrame.class.getResource("/openning.png"));
	    smaller = new ImageIcon(GameFrame.class.getResource("/smaller.png"));
	    greater = new ImageIcon(GameFrame.class.getResource("/greater.png"));
	    lost = new ImageIcon(GameFrame.class.getResource("/lost.png"));
	    win = new ImageIcon(GameFrame.class.getResource("/win.png"));
	    URL iconURL = getClass().getResource("/icon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());//set the game icon
        
        toguessText = new JLabel("Behind this case lies the number to guess...  ");//set text
        nbBox = new JTextField("???", 5);//set text
        nbBox.setHorizontalAlignment(0);
        nbBox.setEditable(false);
        nbBox.setBackground(Color.YELLOW);//set background color
        nbBox.setForeground(Color.DARK_GRAY);
        nbToGuess = (int)(Math.random() * 100D) + 1;//generate random number
        System.out.println((new StringBuilder()).append("The Number to guess is ").append(nbToGuess).append(".").toString());
        guessText = new JLabel("Enter a number between 1 and 100 : ");//set text
        guessField = new JTextField("", 3);
        guessField.setColumns(3);
        guessField.setHorizontalAlignment(0);
        guessField.setMaximumSize(new Dimension(50, 30));//set text field size
        guessField.setEditable(true);
        guessField.addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent keyevent)
            {
                if(keyevent.getKeyChar() == '\n'){
                    verifyGuessNb();
                }
            }
        });
        
        tryButton = new JButton("Try !");//set button name
        tryButton.addActionListener((ActionListener) this);
        result = new JLabel((new StringBuilder()).append("Warning, You have ").append(nbMaxTry).append(" tries only... Be strategic !").toString(), 0);
        result.setIcon((Icon) openning);
        result.setFont(new Font("Serif", 1, 14));
        result.setForeground(Color.RED);
        Container container = getContentPane();
        Box box = Box.createVerticalBox();
        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();
        Box box3 = Box.createHorizontalBox();
        Box box4 = Box.createHorizontalBox();
        box1.add(Box.createHorizontalStrut(10));
        box1.add(toguessText);
        box1.add(Box.createHorizontalGlue());
        box1.add(nbBox);
        box1.add(Box.createHorizontalStrut(10));
        box2.add(Box.createHorizontalStrut(10));
        box2.add(guessText);
        box1.add(Box.createHorizontalGlue());
        box2.add(guessField);
        box2.add(Box.createHorizontalStrut(10));
        box3.add(tryButton);
        box4.add(Box.createHorizontalStrut(10));
        box4.add(result);
        box4.add(Box.createHorizontalStrut(20));
        box.add(Box.createVerticalStrut(10));
        box.add(box1);
        box.add(Box.createVerticalStrut(20));
        box.add(box2);
        box.add(Box.createVerticalGlue());
        box.add(box3);
        box.add(Box.createVerticalStrut(20));
        box.add(box4);
        box.add(Box.createVerticalStrut(20));
        container.add(box);
        MenuFrame menuFrame = new MenuFrame(this);
        setJMenuBar(menuFrame);
        setDefaultCloseOperation(3);
        pack();
        setLocationRelativeTo(null);//center the frame
        setResizable(false);//block the size of the frame
        setVisible(true);//show the frame
	}
	
	public void actionPerformed(ActionEvent actionevent)
    {
        if(actionevent.getSource() == tryButton){
            verifyGuessNb();
        }
        
    }
	
	public void verifyGuessNb()
    {
        String s = guessField.getText();
        try
        {
            int i = Integer.parseInt(s);
            verifyRangeNb(i);
            if(i == nbToGuess)
            {
                result.setForeground(Color.GREEN);
                result.setFont(new Font("Serif", 1, 14));
                result.setText((new StringBuilder()).append("Excellent ! You guessed it with ").append(nbTry).append(" tries.").toString());
                result.setIcon((Icon) win);
                nbBox.setText((new StringBuilder()).append("  ").append(nbToGuess).toString());
                guessField.setEditable(false);
            } else
            if(nbTry >= nbMaxTry)
            {
                result.setForeground(Color.RED);
                result.setFont(new Font("Serif", 1, 14));
                result.setText("LOST! You no longer have tries...");
                result.setIcon((Icon) lost);
                nbBox.setText((new StringBuilder()).append(" ").append(nbToGuess).toString());
                guessField.setEditable(false);
            } else
            {
                if(i < nbToGuess)
                {
                    result.setForeground(Color.BLUE);
                    result.setFont(new Font("Serif", 1, 12));
                    result.setText((new StringBuilder()).append("Too small! ").append(nbMaxTry - nbTry).append(" tries left...").toString());
                    result.setIcon((Icon) smaller);
                } else
                {
                    result.setFont(new Font("Serif", 1, 15));
                    result.setForeground(Color.ORANGE);
                    result.setText((new StringBuilder()).append("Too big ! ").append(nbMaxTry - nbTry).append(" tries left...").toString());
                    result.setIcon((Icon) greater);
                }
                nbTry++;
            }
        }
        catch(NumberFormatException numberformatexception)
        {
            JOptionPane.showMessageDialog(this, " Enter an integer !!!", "Warning !!!", 2);
        }
        catch(InfoException exp)
        {
        	JOptionPane.showMessageDialog(this, exp.getErrorMSG(), "Warning !!!", 2);
        }
    }
	
	//Custom class Exception
		public class InfoException extends Exception {
			private String errorMsg;
			public InfoException(String msg){
					super(msg);
				errorMsg = msg;
			}
			public String getErrorMSG(){
				return errorMsg;
			}
			public void setErrorMSG(String errorMsg){
				this.errorMsg = errorMsg;
			}
		}
	
	private void verifyRangeNb(int guessNb) throws InfoException{
		if(guessNb<1){
			throw new InfoException("Your number is smaller than 1!\nPlease choose number between 1 and 100.");
		}
		else if(guessNb>100){
			throw new InfoException("Your number is greater than 100!\nPlease choose number between 1 and 100.");
		}
	}



	

}
