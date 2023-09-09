import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class Atminterface
{
    public static void main(String...args)
    {
        new Atm();
    }
}


class Atm
{
    JFrame frame;
    JLabel label,l1;
    JButton withdraw,deposite,checkbal,cancle,Newuser;
    Atm()
    {
        frame=new JFrame("ATM");
        frame.setBounds(400,200,550,400);
        frame.getContentPane().setBackground(new Color(252, 222, 195));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon icon=new ImageIcon("atm-machine-4610416-3816341.png");
        Image img=icon.getImage().getScaledInstance(250,300,Image.SCALE_SMOOTH);
        ImageIcon icon2=new ImageIcon(img);
        l1=new JLabel(icon2);
        l1.setBounds(290,30,250,300);
        frame.add(l1);


        label=new JLabel("ATM Machine Interface:-");
        label.setFont(new Font("arial",Font.BOLD,14));
        label.setBounds(10,10,200,30);
        frame.add(label);
        withdraw=new JButton("WITHDRAW");
        withdraw.setBounds(40,50,130,30);
        withdraw.setBackground(new Color(245, 102, 112, 255));
        withdraw.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new withdrawbalance();
                frame.setVisible(false);
            }
        });
        withdraw.setFont(new Font("arial",Font.BOLD,12));
        frame.add(withdraw);

        deposite=new JButton("DEPOSITE");
        deposite.setBounds(40,110,130,30);
        deposite.setBackground(new Color(124, 244, 124));
        deposite.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new depo();
                frame.setVisible(false);
            }
        });
        deposite.setFont(new Font("arial",Font.BOLD,12));
        frame.add(deposite);

        checkbal=new JButton("CHECK_BALANCE");
        checkbal.setBounds(40,170,150,30);
        checkbal.setBackground(new Color(103, 235, 236));
        checkbal.setFont(new Font("arial",Font.BOLD,12));
        checkbal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new bankaccount();
                frame.setVisible(false);
            }
        });
        frame.add(checkbal);

        cancle=new JButton("CANCLE");
        cancle.setBounds(40,250,100,25);
        cancle.setBackground(Color.red);
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(cancle);

        Newuser=new JButton("NEW_USER");
        Newuser.setBounds(200,250,130,25);
        Newuser.setBackground(Color.green);
        Newuser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Nuser();
                frame.setVisible(false);
            }
        });
        frame.add(Newuser);

        frame.setVisible(true);
    }
}

class withdrawbalance
{
    JFrame frame;
    JLabel l1;
    JTextField f1;
    JButton cancle,enter,back;
    withdrawbalance()
    {
        frame=new JFrame("WITHDRAW");
        frame.setBounds(400,200,300,250);
        frame.getContentPane().setBackground(new Color(252, 222, 195));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        l1=new JLabel("Enter The Amount:-");
        l1.setFont(new Font("arial",Font.BOLD,14));
        l1.setBounds(20,40,150,30);
        frame.add(l1);

        f1=new JTextField();
        f1.setBounds(180,45,40,20);
        frame.add(f1);

        enter=new JButton("ENTER");
        enter.setBounds(20,100,100,25);
        enter.setBackground(Color.green);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=f1.getText();
                double d=Double.parseDouble(str);
                if(d>bankaccount.balance)
                {
                    JOptionPane.showMessageDialog(frame,"Account Balance is not Sufficient:");
                    f1.setText("");
                }
                else
                {
                    double remain=bankaccount.balance-d;
                    bankaccount.balance=remain;
                    JOptionPane.showMessageDialog(frame,"Withdrawl Success:");
                }
            }
        });
        frame.add(enter);

        cancle=new JButton("CANCLE");
        cancle.setBounds(180,100,100,25);
        cancle.setBackground(Color.red);
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(cancle);

        back=new JButton("BACK");
        back.setBounds(90,150,100,25);
        back.setBackground(Color.gray);
        back.setForeground(Color.blue);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Atm();
                frame.setVisible(false);
            }
        });
        frame.add(back);

        frame.setVisible(true);
    }
}


class depo
{
    JFrame frame;
    JLabel l1;
    JTextField f1;
    JButton cancle,enter,back;
    depo()
    {
        frame=new JFrame("DEPOSITE");
        frame.setBounds(400,200,300,250);
        frame.getContentPane().setBackground(new Color(252, 222, 195));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        l1=new JLabel("Enter The Amount:-");
        l1.setFont(new Font("arial",Font.BOLD,14));
        l1.setBounds(20,40,150,30);
        frame.add(l1);

        f1=new JTextField();
        f1.setBounds(180,45,40,20);
        frame.add(f1);

        enter=new JButton("ENTER");
        enter.setBounds(20,100,100,25);
        enter.setBackground(Color.green);
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str=f1.getText();
                double d=Double.parseDouble(str);
                if(d==0)
                {
                    JOptionPane.showMessageDialog(frame,"Please enter a valid Ammount:");
                    f1.setText("");
                }
                else
                {
                    double update=bankaccount.balance+d;
                    bankaccount.balance=update;
                    JOptionPane.showMessageDialog(frame,"Deposite Success:");
                }
            }
        });
        frame.add(enter);

        cancle=new JButton("CANCLE");
        cancle.setBounds(180,100,100,25);
        cancle.setBackground(Color.red);
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(cancle);

        back=new JButton("BACK");
        back.setBounds(90,150,100,25);
        back.setBackground(Color.gray);
        back.setForeground(Color.blue);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Atm();
                frame.setVisible(false);
            }
        });
        frame.add(back);

        frame.setVisible(true);
    }
}


class Nuser
{
    JFrame frame;
    JLabel l1,l2,l3,l4;
    JTextField f1,f2,f3,f4;
    JButton enter,cancle;
    Nuser()
    {
        frame=new JFrame("BALANCE");
        frame.setBounds(400,200,350,300);
        frame.getContentPane().setBackground(new Color(252, 222, 195));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        l1=new JLabel("Account Number:-");
        l1.setFont(new Font("arial",Font.BOLD,12));
        l1.setBounds(20,20,130,30);
        frame.add(l1);

        f1=new JTextField();
        f1.setBounds(140,25,70,20);
        frame.add(f1);

        l2=new JLabel("ATM Card Number:-");
        l2.setFont(new Font("arial",Font.BOLD,12));
        l2.setBounds(20,55,130,30);
        frame.add(l2);

        f2=new JTextField();
        f2.setBounds(140,60,70,20);
        frame.add(f2);

        l3=new JLabel("Make a PIN:-");
        l3.setFont(new Font("arial",Font.BOLD,12));
        l3.setBounds(20,85,120,30);
        frame.add(l3);

        f3=new JTextField();
        f3.setBounds(140,90,70,20);
        frame.add(f3);

        l4=new JLabel("ReEnter PIN:-");
        l4.setFont(new Font("arial",Font.BOLD,12));
        l4.setBounds(20,120,120,30);
        frame.add(l4);

        f4=new JTextField();
        f4.setBounds(140,125,70,20);
        frame.add(f4);

        cancle=new JButton("CANCLE");
        cancle.setBounds(190,180,100,25);
        cancle.setBackground(Color.red);
        cancle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Atm();
                frame.setVisible(false);
            }
        });
        frame.add(cancle);

        enter=new JButton("ENTER");
        enter.setBounds(20,180,100,25);
        enter.setBackground(Color.green);
        enter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if (f1.getText().isEmpty() || f2.getText().isEmpty() || f3.getText().isEmpty() || f4.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"Please fill all the Fields:");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Done:");
                    new Atm();
                    frame.setVisible(false);

                }
            }
        });
        frame.add(enter);

        frame.setVisible(true);
    }
}




class bankaccount
{
    static double balance=2000;
    JFrame frame;
    JLabel l1,l2;
    JButton b1;
    bankaccount()
    {
        frame=new JFrame("BALANCE");
        frame.setBounds(400,200,300,200);
        frame.getContentPane().setBackground(new Color(252, 222, 195));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        l1=new JLabel("Account Balance:-");
        l1.setFont(new Font("arial",Font.BOLD,14));
        l1.setBounds(20,40,150,30);
        frame.add(l1);

        l2=new JLabel();
        String str=String.valueOf(balance);
        l2.setText(str);
        l2.setFont(new Font("arial",Font.BOLD,14));
        l2.setBounds(160,40,80,30);
        frame.add(l2);

        b1=new JButton("BACK");
        b1.setBounds(80,100,100,25);
        b1.setBackground(Color.gray);
        b1.setForeground(Color.blue);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Atm();
                frame.setVisible(false);
            }
        });
        frame.add(b1);

        frame.setVisible(true);
    }
}