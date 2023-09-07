
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeSystem
{
    public static void main(String...args)
    {
        new start();
    }
}

class result
{
    JFrame frame;
    static JLabel name,name1,standard,standard1, maxlabel,maxmarks, obtainlabel,obtainmarks,averagepercent,averagepercent1,grade,grade1;
    JButton calagain,exit;
    result()
    {
        frame=new JFrame("Result");
        frame.setBounds(400,200,500,300);
        frame.getContentPane().setBackground(new Color(249, 182, 119));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        name=new JLabel("Student's Name:- ");
        name.setBounds(10,10,100,30);
        name.setFont(new Font("arial",Font.BOLD,12));
        frame.add(name);

        name1=new JLabel();
        name1.setText(information.Name);
        name1.setBounds(115,10,100,30);
        name1.setFont(new Font("arial", Font.BOLD,10));
        name1.setForeground(new Color(11, 27, 242));
        frame.add(name1);


        standard=new JLabel("Class/Course:- ");
        standard.setBounds(10,45,100,30);
        standard.setFont(new Font("arial",Font.BOLD,12));
        frame.add(standard);

        standard1=new JLabel();
        standard1.setText(information.Class);
        standard1.setBounds(100,45,100,30);
        standard1.setFont(new Font("arial", Font.BOLD,10));
        standard1.setForeground(new Color(11, 27, 242));
        frame.add(standard1);

        maxlabel =new JLabel("Total Maximum Marks:-");
        maxlabel.setBounds(10,90,150,30);
        maxlabel.setFont(new Font("arial",Font.BOLD,12));
        frame.add(maxlabel);

        maxmarks=new JLabel();
        maxmarks.setText("400");
        maxmarks.setBounds(150,90,40,30);
        maxmarks.setFont(new Font("arial", Font.BOLD,10));
        maxmarks.setForeground(new Color(11, 27, 242));
        frame.add(maxmarks);

        obtainlabel =new JLabel("Total Obtained Marks:-");
        obtainlabel.setBounds(250,90,150,30);
        obtainlabel.setFont(new Font("arial",Font.BOLD,12));
        frame.add(obtainlabel);

        obtainmarks=new JLabel();
        obtainmarks.setBounds(390,90,40,30);
        obtainmarks.setFont(new Font("arial", Font.BOLD,10));
        if(information.Class=="Intermediate")
        {
            String str=String.valueOf(Inter.Totalobtainmarks);
            obtainmarks.setText(str);
        }
        else
        {
            String str=String.valueOf(Btech.Totalobtainmarks);
            obtainmarks.setText(str);
        }
        obtainmarks.setForeground(new Color(11, 27, 242));
        frame.add(obtainmarks);

        averagepercent=new JLabel("Average Percentage:-");
        averagepercent.setBounds(10,130,150,30);
        averagepercent.setFont(new Font("arial",Font.BOLD,12));
        frame.add(averagepercent);

        averagepercent1=new JLabel();
        averagepercent1.setBounds(150,130,60,30);
        averagepercent1.setFont(new Font("arial", Font.BOLD,10));
        if(information.Class=="Intermediate")
        {
            String strign=String.valueOf(Inter.avgpercent);
            averagepercent1.setText(strign);
        }
        else
        {
            String string=String.valueOf(Btech.avgpercent);
            averagepercent1.setText(string);
        }
        averagepercent1.setForeground(new Color(11, 27, 242));
        frame.add(averagepercent1);

        grade=new JLabel("Grade:-");
        grade.setBounds(10,165,80,30);
        grade.setFont(new Font("arial",Font.BOLD,12));
        frame.add(grade);

        grade1=new JLabel();
        grade1.setBounds(70,165,50,30);
        grade1.setFont(new Font("arial", Font.BOLD,10));
        if(information.Class=="Intermediate")
        {
            grade1.setText(Inter.grade);
        }
        else
        {
            grade1.setText(Btech.grade);
        }
        grade1.setForeground(new Color(11, 27, 242));
        frame.add(grade1);

        calagain=new JButton("Calculate Another");
        calagain.setBounds(50,200,150,30);
        calagain.setBackground(new Color(4, 245, 4));
        calagain.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                new information();
                frame.setVisible(false);
            }

        });
        frame.add(calagain);

        exit=new JButton("EXIT");
        exit.setBounds(330,200,100,30);
        exit.setBackground(new Color(248, 4, 20));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(exit);

        frame.setVisible(true);
    }
}


class Inter
{
    JFrame frame;
    JLabel lable,sub1,sub2,sub3,sub4,logo;
    JTextField tf1,tf2,tf3,tf4;
    JButton btn,cancel;
    static int sub1marks, sub2marks , sub3marks , sub4marks ,Totamaxmarks=500,Totalobtainmarks=0;
    static double numofsubjects=4,avgpercent=0;
    static String grade,sf1="",sf2="",sf3="",sf4="";
    Inter()
    {
        frame =new JFrame("Intermediate");
        frame.setBounds(400,200,450,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(4, 228, 248));
        frame.setLayout(null);

        ImageIcon icon=new ImageIcon("takinginput.jpeg");
        Image img =icon.getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH);
        ImageIcon icon2=new ImageIcon(img);
        logo=new JLabel(icon2);
        logo.setBounds(250,50,140,140);
        frame.add(logo);

        lable=new JLabel("Enter Your Marks out of 100:-");
        lable.setFont(new Font("Elephant",Font.BOLD,14));
        lable.setBounds(20,20,250,30);
        frame.add(lable);

        sub1=new JLabel("Math");
        tf1=new JTextField();
        tf1.setText("");
        sub1.setBounds(35,60,50,25);
        tf1.setBounds(100,60,30,25);
        frame.add(sub1);
        frame.add(tf1);

        sub2=new JLabel("Science");
        tf2=new JTextField();
        tf2.setText("");
        sub2.setBounds(35,90,50,25);
        tf2.setBounds(100,90,30,25);
        frame.add(sub2);
        frame.add(tf2);

        sub3=new JLabel("English");
        tf3=new JTextField();
        tf3.setText("");
        sub3.setBounds(35,120,50,25);
        tf3.setBounds(100,120,30,25);
        frame.add(sub3);
        frame.add(tf3);

        sub4=new JLabel("SST");
        tf4=new JTextField();
        tf4.setText("");
        sub4.setBounds(35,150,50,25);
        tf4.setBounds(100,150,30,25);
        frame.add(sub4);
        frame.add(tf4);

        btn=new JButton("-ENTER-");
        btn.setFont(new Font("arial",Font.BOLD,12));
        btn.setBackground(new Color(7,7,7));
        btn.setForeground(new Color(255,255,255));
        btn.setBounds(50,200,100,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                sf1=tf1.getText();
                sf2=tf2.getText();
                sf3=tf3.getText();
                sf4=tf4.getText();
                if(sf1.isEmpty() || sf2.isEmpty() || sf3.isEmpty() || sf4.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"First Enter all the Marks:");
                }
                else
                {
                    sub1marks =Integer.parseInt(sf1);
                    sub2marks =Integer.parseInt(sf2);
                    sub3marks =Integer.parseInt(sf3);
                    sub4marks =Integer.parseInt(sf4);
                    Totalobtainmarks= sub1marks + sub2marks + sub3marks + sub4marks;
                    avgpercent=Totalobtainmarks/numofsubjects;
                    if(avgpercent<=55)
                    {
                        grade="D";
                    }
                    else
                    {
                        if(avgpercent>55 && avgpercent<=70)
                        {
                            grade="C";
                        }
                        else
                        {
                            if(avgpercent>70 && avgpercent<85)
                            {
                                grade="B";
                            }
                            else
                            {
                                grade="A";
                            }
                        }
                    }
                    new result();
                    frame.setVisible(false);
                }

            }
        });
        frame.add(btn);

        cancel=new JButton("CANCEL");
        cancel.setFont(new Font("arial",Font.BOLD,12));
        cancel.setBackground(new Color(248, 4, 90));
        cancel.setForeground(new Color(7,7,7));
        cancel.setBounds(250,200,100,30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(cancel);
        frame.setVisible(true);
    }
}


class Btech
{
    JFrame frame;
    JLabel lable,sub1,sub2,sub3,sub4,logo;
    JTextField tf1,tf2,tf3,tf4;
    JButton btn,cancel;
    static int sub1marks, sub2marks , sub3marks , sub4marks ,Totamaxmarks=500,Totalobtainmarks=0;
    static double numofsubjects=4,avgpercent=0;
    static String grade,sf1="",sf2="",sf3="",sf4="";
    Btech()
    {
        frame =new JFrame("B.Tech");
        frame.setBounds(400,200,450,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(4, 228, 248));
        frame.setLayout(null);

        ImageIcon icon=new ImageIcon("takinginput.jpeg");
        Image img =icon.getImage().getScaledInstance(140,140,Image.SCALE_SMOOTH);
        ImageIcon icon2=new ImageIcon(img);
        logo=new JLabel(icon2);
        logo.setBounds(250,50,140,140);
        frame.add(logo);

        lable=new JLabel("Enter Your Marks out of 100:-");
        lable.setFont(new Font("Elephant",Font.BOLD,14));
        lable.setBounds(20,20,250,30);
        frame.add(lable);

        sub1=new JLabel("DBMS");
        tf1=new JTextField();
        tf1.setText("");
        sub1.setBounds(35,60,50,25);
        tf1.setBounds(100,60,30,25);
        frame.add(sub1);
        frame.add(tf1);

        sub2=new JLabel("JAVA");
        tf2=new JTextField();
        tf2.setText("");
        sub2.setBounds(35,90,50,25);
        tf2.setBounds(100,90,30,25);
        frame.add(sub2);
        frame.add(tf2);

        sub3=new JLabel("OOPS");
        tf3=new JTextField();
        tf3.setText("");
        sub3.setBounds(35,120,50,25);
        tf3.setBounds(100,120,30,25);
        frame.add(sub3);
        frame.add(tf3);

        sub4=new JLabel("DAA");
        tf4=new JTextField();
        tf4.setText("");
        sub4.setBounds(35,150,50,25);
        tf4.setBounds(100,150,30,25);
        frame.add(sub4);
        frame.add(tf4);

        btn=new JButton("-ENTER-");
        btn.setFont(new Font("arial",Font.BOLD,12));
        btn.setBackground(new Color(7,7,7));
        btn.setForeground(new Color(255,255,255));
        btn.setBounds(50,200,100,30);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                sf1=tf1.getText();
                sf2=tf2.getText();
                sf3=tf3.getText();
                sf4=tf4.getText();
                if(sf1.isEmpty() || sf2.isEmpty() || sf3.isEmpty() || sf4.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"First Enter all the Marks:");
                }
                else
                {
                    sub1marks =Integer.parseInt(sf1);
                    sub2marks =Integer.parseInt(sf2);
                    sub3marks =Integer.parseInt(sf3);
                    sub4marks =Integer.parseInt(sf4);
                    Totalobtainmarks= sub1marks + sub2marks + sub3marks + sub4marks;
                    avgpercent=Totalobtainmarks/numofsubjects;
                    if(avgpercent<=55)
                    {
                        grade="D";
                    }
                    else
                    {
                        if(avgpercent>55 && avgpercent<=70)
                        {
                            grade="C";
                        }
                        else
                        {
                            if(avgpercent>70 && avgpercent<85)
                            {
                                grade="B";
                            }
                            else
                            {
                                grade="A";
                            }
                        }
                    }
                    new result();
                    frame.setVisible(false);
                }

            }
        });
        frame.add(btn);

        cancel=new JButton("CANCEL");
        cancel.setFont(new Font("arial",Font.BOLD,12));
        cancel.setBackground(new Color(248, 4, 90));
        cancel.setForeground(new Color(7,7,7));
        cancel.setBounds(250,200,100,30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        frame.add(cancel);
        frame.setVisible(true);
    }
}



class information
{
    JFrame frame;
    JLabel name,standard,logo;
    JTextField namefield;
    JComboBox comboBox;
    String  arr[]={"Intermediate","B.Tech"};

    JButton btn;
    static String Name;
    static String Class;

    information()
    {
        frame=new JFrame(":INFORMATION:");
        frame.setBounds(400,200,600,300);
        Container c=frame.getContentPane();
        c.setSize(400,300);
        c.setLocation(5,5);
        c.setBackground(new Color(241, 243, 244));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        name=new JLabel("Enter Your Name:-");
        name.setFont(new Font("Elephant",Font.BOLD,14));
        name.setBounds(30,10,150,30);
        frame.add(name);

        namefield=new JTextField();
        namefield.setBounds(210,15,120,25);
        frame.add(namefield);

        standard=new JLabel("Select Your Study:-");
        standard.setFont(new Font("Elephant",Font.BOLD,14));
        standard.setBounds(30,50,180,30);
        frame.add(standard);

        comboBox=new JComboBox(arr);
        comboBox.setBounds(210,50,120,25);
        frame.add(comboBox);

        btn=new JButton("-ENTER-");
        btn.setFont(new Font("arial",Font.BOLD,12));
        btn.setBounds(130,130,100,30);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Name=namefield.getText();
                Class=(String)comboBox.getSelectedItem();
                if(Name.isEmpty())
                {
                    JOptionPane.showMessageDialog(frame,"Please First Enter Your Name:");
                }
                else
                {
                    if(Class.equals("Intermediate"))
                    {
                        new Inter();
                    }
                    else
                    {
                        new Btech();
                    }
                    frame.setVisible(false);
                }
            }
        });
        btn.setBackground(new Color(7, 7, 7));
        btn.setForeground(new Color(255, 255, 255));
        frame.add(btn);

        ImageIcon icon=new ImageIcon("information-png-1.png");
        Image img=icon.getImage().getScaledInstance(220,220,Image.SCALE_SMOOTH);
        ImageIcon icon2=new ImageIcon(img);
        logo=new JLabel(icon2);
        logo.setBounds(330,30,220,220);
        frame.add(logo);

        frame.setVisible(true);
    }

}
class start
{
    JFrame frame;
    JLabel label;
    start()
    {
        frame=new JFrame("Grade System");
        frame.setBounds(400,200,700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        ImageIcon icon=new ImageIcon("front.jpeg");
        Image img=icon.getImage().getScaledInstance(700,500,Image.SCALE_SMOOTH);
        ImageIcon icon2=new ImageIcon(img);
        label=new JLabel(icon2);
        label.setBounds(0,0,700,500);
        frame.add(label);


        frame.setVisible(true);

        try
        {
            Thread.sleep(1000);
            new information();
            frame.setVisible(false);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}



