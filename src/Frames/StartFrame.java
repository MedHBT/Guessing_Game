package Frames;

import java.net.URL;

import javax.swing.ImageIcon;

public class StartFrame extends javax.swing.JFrame {

    /*Constructor which create the start menu*/
    public StartFrame() {
        initComponents();
    }
    
    private void initComponents() {

        startButton = new javax.swing.JButton();//create start button
        exitButton = new javax.swing.JButton();//create exit button
        reulesButton = new javax.swing.JButton();//create rules button
        jLabel1 = new javax.swing.JLabel();//create the container frame

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//set the default close button
        setMaximumSize(new java.awt.Dimension(600, 400));//set the maximum size of the frame
        setMinimumSize(new java.awt.Dimension(600, 400));//set the minimum size of the frame
        setPreferredSize(new java.awt.Dimension(600, 400));//set the default opening size frame
        setResizable(false);//block the size of the frame
        getContentPane().setLayout(null);
        setTitle("Guessing Game");//set title to the frame
        URL iconURL = getClass().getResource("/icon.png");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());//set the game icon

        startButton.setText("START");//set the start button name
        /*start button action method*/
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        getContentPane().add(startButton);
        startButton.setBounds(250, 320, 105, 49);//set the button potition

        exitButton.setText("EXIT");//set the exit button name
        exitButton.setMaximumSize(new java.awt.Dimension(75, 30));//set the exit button size
        exitButton.setMinimumSize(new java.awt.Dimension(75, 30));//set the exit button size
        exitButton.setPreferredSize(new java.awt.Dimension(75, 30));//set the exit button size
        /*exit button action method*/
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(exitButton);
        exitButton.setBounds(405, 329, 75, 30);//set exit button position

        reulesButton.setText("RULES");//set the rules button name
        reulesButton.setPreferredSize(new java.awt.Dimension(75, 30));//set the rules button size
        /*rules button action method*/
        reulesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reulesButtonActionPerformed(evt);
            }
        });
        getContentPane().add(reulesButton);
        reulesButton.setBounds(125, 329, 75, 30);//set the rules button position

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/guess.png"))); //load the menu image
        jLabel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, 0, 610, 400);

        pack();
        setLocationRelativeTo(null);//set frame location in center
    }

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	new GameFrame();//open the game frame
    	this.setVisible(false);//close the menu frame
        this.dispose();//destroy the menu frame
    }

    private void reulesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        RulesFrame rulesFrame = new RulesFrame();//open the rules frame
        rulesFrame.setVisible(true);//show the rules frame
        this.setVisible(false);//close the start frame
        this.dispose();//destroy the start frame
    }

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);//close the program
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reulesButton;
    private javax.swing.JButton startButton;
    // End of variables declaration
}


