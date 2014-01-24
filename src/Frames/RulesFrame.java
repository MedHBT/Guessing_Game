package Frames;

import java.net.URL;

import javax.swing.ImageIcon;

public class RulesFrame extends javax.swing.JFrame {

	/*Constructor which create the rules frame*/
    public RulesFrame() {
        initComponents();
    }

    
    private void initComponents() {

        jButton1 = new javax.swing.JButton();//initiate the back button
        jLabel2 = new javax.swing.JLabel();//initiate the rules frame

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//set the default exit button
        setLocationByPlatform(true);//set location of the frame
        setMaximumSize(new java.awt.Dimension(600, 400));//set the frame size
        setMinimumSize(new java.awt.Dimension(600, 400));//set the frame size
        setPreferredSize(new java.awt.Dimension(600, 400));//set the frame size
        setResizable(false);//block the size frame
        getContentPane().setLayout(null);
        setTitle("Guessing Game");//set title to the frame
        URL iconURL = getClass().getResource("/icon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());//set the game icon

        jButton1.setText("Back");//set the back button name
        jButton1.setPreferredSize(new java.awt.Dimension(100, 50));//set the back button size
        /*set action to the back button*/
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(280, 320, 80, 30);//set the back button position

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guessRules.png"))); // load the background image frame
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 600, 390);//set the limit of the frame

        pack();
    }
    /*back button action method*/
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        StartFrame startFrame = new StartFrame();//initiate the start frame
        startFrame.setVisible(true);//show the start frame
        this.setVisible(false);//close the rules frame
        this.dispose();//destroy the rules frame
        
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration
}
