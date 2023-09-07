import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Written by "AKSHIT TYAGI":
 * This is Number Guess Game in this game you will be asked that how many game rounds you want to play.
 * you have to enter the number of  game round or matches which you wnat to play.
 * Then you will have to enter your guessed number .
 * In each match you will get only 8 chances.
 */

public class Number_Guess_Game
{
    static int Gameround=1,win=0;
    public static void main(String...args)
    {
       new Play();
    }
}

class Play
{
    JFrame frame;
    JLabel background;
    Play()
    {
        frame=new JFrame("WELCOME");
        frame.setLocation(300,200);
        frame.setSize(600,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon("OIP.jpeg");
        Image img= icon.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon icon1=new ImageIcon(img);
        background=new JLabel(icon1);
        background.setBounds(0,0,600,400);
        frame.add(background);

        frame.setVisible(true);

        try
        {
            Thread.sleep(2000);
            frame.setVisible(false);
            new Round();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }
}


 class Round implements ActionListener
{
    JFrame frame;
    JLabel lable;
    JTextField text;
    JButton btn;
    String str;
    static int rounds;
    Round()
    {
        frame=new JFrame("Number Game");
        frame.setBounds(300,200,450,200);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(4, 228, 248));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lable=new JLabel("Enter Number of Round You Want To Play:-");
        lable.setBounds(10,20,350,40);
        lable.setFont(new Font("arial",Font.BOLD,15));
        lable.setForeground(new Color(7, 7, 7, 255));
        frame.add(lable);

        text=new JTextField();
        text.setBounds(340,25,50,25);
        frame.add(text);

        btn=new JButton("ENTER");
        btn.setBackground(new Color(4, 245, 4));
        btn.setForeground(new Color(7, 7, 7));
        btn.setBounds(170,75,80,30);

        btn.addActionListener(this);
        frame.add(btn);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn)
        {
            str=text.getText();
            if(str.equals(""))
            {
                JOptionPane.showMessageDialog(frame,"Enter a Valid Number:");
            }
            else
            {
                rounds=Integer.parseInt(str);
                if(rounds<=0)
                {
                    JOptionPane.showMessageDialog(frame,"Enter a Valid Number:");
                }
                else
                {
                    new GuessNumberGame();
                    frame.setVisible(false);
                }
            }
        }
    }
}

 class GuessNumberGame implements ActionListener {
    JFrame frame;
    JLabel roundlable,lable, attemplabel, gameroundresult;
    JTextField text;
    JButton Enter, playagain, exit;
    int Random_Number, Attempt =8,usernum;

    GuessNumberGame() {
        Random rd = new Random();
        Random_Number = rd.nextInt(1,100);
        //System.out.println(Random_Number);

        frame = new JFrame("*GUESS NUMBER GAME*");
        frame.getContentPane().setBackground(new Color(4, 228, 248));
        frame.setBounds(300, 200, 500, 380);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        roundlable=new JLabel("Game Round:-"+ Number_Guess_Game.Gameround);
        roundlable.setBounds(10,5,100,30);
        roundlable.setFont(new Font("arial",Font.BOLD,12));
        frame.add(roundlable);

        attemplabel =new JLabel("Attempt Left:-"+Attempt);
        attemplabel.setBounds(160,5,100,30);
        attemplabel.setFont(new Font("arial",Font.BOLD,12));
        frame.add(attemplabel);

        lable=new JLabel("Enter Your Guessed Number Between 1 to 100:-");
        lable.setFont(new Font("arial",Font.BOLD,14));
        lable.setBounds(20,40,350,30);
        frame.add(lable);

        text= new JTextField();
        text.setBounds(375, 45, 40, 20);
        text.addActionListener(this);
        frame.add(text);

        Enter = new JButton("ENTER");
        Enter.setBounds(180, 90, 80, 30);
        Enter.setBackground(Color.pink);
        Enter.addActionListener(this);
        frame.add(Enter);

        gameroundresult=new JLabel();
        gameroundresult.setBounds(10,180,250,30);
        gameroundresult.setFont(new Font("arial",Font.BOLD,12));
        frame.add(gameroundresult);


        playagain = new JButton("PLAY_AGAIN");
        playagain.addActionListener(this);
        playagain.setBackground(Color.green);
        playagain.setBounds(40, 230, 130, 25);
        playagain.setVisible(false);
        frame.add(playagain);

        exit = new JButton("EXIT_GAME");
        exit.setBackground(Color.RED);
        exit.addActionListener(this);
        exit.setBounds(300, 230, 130, 25);
        exit.setVisible(false);
        frame.add(exit);


        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==Enter)
        {
            if(Number_Guess_Game.Gameround<=Round.rounds)
            {
                usernum=Integer.parseInt(text.getText());
                if(usernum<=0 || usernum>100)
                {
                    JOptionPane.showMessageDialog(frame,"Please Enter a Number Between 1 to 100 only:");
                }
                else
                {
                    if(Attempt>=1)
                    {
                            Attempt--;
                            if(usernum==Random_Number)
                            {
                                Number_Guess_Game.win++;
                                JOptionPane.showMessageDialog(frame,"You have win "+ Number_Guess_Game.Gameround+" Round:-");
                                Number_Guess_Game.Gameround++;
                                if(Number_Guess_Game.Gameround<=Round.rounds)
                                {
                                    frame.setVisible(false);
                                    new GuessNumberGame();
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(frame,"Matche Over:");
                                    gameroundresult.setText("You win "+ Number_Guess_Game.win+" Out of "+Round.rounds+" Matches:");
                                    attemplabel.setText("Attempt Left:-0");
                                    Enter.setVisible(false);
                                    playagain.setVisible(true);
                                    exit.setVisible(true);
                                }

                            }
                            if(usernum<Random_Number && Attempt!=0)
                            {
                                JOptionPane.showMessageDialog(frame,"Your Guess is Too Low: Try Again:");
                                attemplabel.setText("Attempt Left:-"+Attempt);
                            }
                            if(usernum>Random_Number && Attempt!=0)
                            {
                                JOptionPane.showMessageDialog(frame,"Your Guess is Too High: Try Again:");
                                attemplabel.setText("Attempt Left:-"+Attempt);
                            }
                            if(usernum<Random_Number && Attempt==0)
                            {
                                JOptionPane.showMessageDialog(frame,"You Have Loss "+ Number_Guess_Game.Gameround+" Match:");
                                attemplabel.setText("Attempt Left:-"+Attempt);
                                Number_Guess_Game.Gameround++;
                                if(Number_Guess_Game.Gameround<=Round.rounds)
                                {
                                    new GuessNumberGame();
                                }
                                else
                                {
                                    gameroundresult.setText("You win "+ Number_Guess_Game.win+" Out of "+Round.rounds+" Matches:");
                                    Enter.setVisible(false);
                                    playagain.setVisible(true);
                                    exit.setVisible(true);
                                }
                            }
                            if(usernum>Random_Number && Attempt==0)
                            {
                                JOptionPane.showMessageDialog(frame,"You Have Loss "+ Number_Guess_Game.Gameround+" Match:");
                                attemplabel.setText("Attempt Left:-"+Attempt);
                                Number_Guess_Game.Gameround++;
                                if(Number_Guess_Game.Gameround<=Round.rounds)
                                {
                                    new GuessNumberGame();
                                }
                                else
                                {
                                    gameroundresult.setText("You win "+ Number_Guess_Game.win+" Out of "+Round.rounds+" Matches:");
                                    Enter.setVisible(false);
                                    playagain.setVisible(true);
                                    exit.setVisible(true);
                                }
                            }

                    }
                }

            }
        }
        if(e.getSource()==playagain)
        {
            Number_Guess_Game.Gameround=1;
            Number_Guess_Game.win=0;
            frame.setVisible(false);
            new Round();
        }
        if(e.getSource()==exit)
        {
            frame.setVisible(false);
            System.exit(0);
        }
    }
}


