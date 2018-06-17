import com.sun.org.apache.bcel.internal.classfile.Constant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class s0020 extends JFrame{

    private Container c;
    ImageIcon icon01=new ImageIcon("1.png");
    ImageIcon icon02=new ImageIcon("2.png");
    ImageIcon icon03=new ImageIcon("3.png");
    ImageIcon icon04=new ImageIcon("4.png");
    ImageIcon icon05=new ImageIcon("5.png");
    ImageIcon icon06=new ImageIcon("6.png");
    ImageIcon icon07=new ImageIcon("7.png");
    ImageIcon icon08=new ImageIcon("8.png");
    ImageIcon icon09=new ImageIcon("9.png");
    ImageIcon icon0=new ImageIcon("0.png");
    JButton bot[]=new JButton[10];
    JButton bot_dt=new JButton(".");
    JButton bot_a=new JButton("+");
    JButton bot_s=new JButton("-");
    JButton bot_m=new JButton("*");
    JButton bot_d=new JButton("/");
    JButton bot_e=new JButton("=");
    JButton bot_AC=new JButton("AC");
    JButton bot_sqrt=new JButton("sqrt");
    JButton bot_PI=new JButton("PI");
    JButton bot_exit=new JButton("EXIT");

    double A=0, B=0;
    int op=0,dot=0;

    JTextField txt;
    private JPanel jpl = new JPanel(new GridLayout(4, 3, 5, 3));
    private JPanel jPane2 = new JPanel(new GridLayout(4, 3, 5, 3));




    public s0020(){
        init();
    }
    private  void init(){
        int i;

        bot[0]=new JButton(Integer.toString(0,SwingConstants.TRAILING),icon0);
        bot[1]=new JButton(Integer.toString(1),icon01);
        bot[2]=new JButton(Integer.toString(2),icon02);
        bot[3]=new JButton(Integer.toString(3),icon03);
        bot[4]=new JButton(Integer.toString(4),icon04);
        bot[5]=new JButton(Integer.toString(5),icon05);
        bot[6]=new JButton(Integer.toString(6),icon06);
        bot[7]=new JButton(Integer.toString(7),icon07);
        bot[8]=new JButton(Integer.toString(8),icon08);
        bot[9]=new JButton(Integer.toString(9),icon09);

        txt=new JTextField(10);
        txt.setEditable(false);//設定成不能修改
        c=getContentPane();
        c.setLayout(new BorderLayout());//設定為用Borderlayout
        jpl.setLayout(new GridLayout(4,4));//設定為用gridlayout
        c.add(jPane2,BorderLayout.NORTH);
        jPane2.add(txt);
        c.add(jpl,BorderLayout.CENTER);
        //注意加入元件的順序
        for (i=0;i<10;i=i+1)
        {
            bot[i].setFont(new Font(null,Font.BOLD,40));
            jpl.add(bot[i]);
            bot[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int i;
                    JButton tmpjbn =(JButton) e.getSource();
                    for (i=0;i<10;i=i+1)
                    {
                        if (tmpjbn==bot[i])
                        {
                            txt.setText(txt.getText()+Integer.toString(i));
                            A=Double.parseDouble(txt.getText());
                        }
                    }
                }
            });
        }
        jpl.add(bot_dt);
        bot_dt.setFont(new Font(null,Font.BOLD,40));
        bot_dt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_dt)
                {
                    txt.setText(txt.getText()+".");
                    dot=1;
                }
            }
        });
        jpl.add(bot_a);
        bot_a.setFont(new Font(null,Font.BOLD,40));
        bot_a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_a)
                {
                    txt.setText("");
                    B=A;
                    A=0;
                    op=1;//add
                    dot=0;
                }
            }
        });
        jpl.add(bot_s);
        bot_s.setFont(new Font(null,Font.BOLD,40));
        bot_s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_s)
                {
                    txt.setText("");
                    B=A;
                    A=0;
                    op=2;//減
                    dot=0;
                }
            }
        });
        jpl.add(bot_m);
        bot_m.setFont(new Font(null,Font.BOLD,40));
        bot_m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_m)
                {
                    txt.setText("");
                    B=A;
                    A=0;
                    op=3;//乘
                    dot=0;
                }
            }
        });
        jpl.add(bot_d);
        bot_d.setFont(new Font(null,Font.BOLD,40));
        bot_d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_d)
                {
                    txt.setText("");
                    B=A;
                    A=0;
                    op=4;//除
                    dot=0;
                }
            }
        });
        jpl.add(bot_e);
        bot_e.setFont(new Font(null,Font.BOLD,40));
        bot_e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==bot_e)
                {
                    txt.setText("=");
                    if (op==0) A=B;
                    else if (op==1) A=B+A;
                    else if (op==2) A=B-A;
                    else if (op==3) A=B*A;
                    else if (op==4) A=B/A;
                    txt.setText(Double.toString(A));
                    dot=0;
                }
            }
        });
        jpl.add(bot_AC);
        bot_AC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setText("");
                A=0;
                B=0;
            }
        });
        jpl.add(bot_sqrt);
        bot_sqrt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setText(Double.toString(Math.sqrt(Double.parseDouble(txt.getText()))));
            }
        });
        jpl.add(bot_PI);
        bot_PI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txt.setText(Double.toString(A*Math.PI));
            }
        });
        jpl.add(bot_exit);

        setSize(600,480);
        Image img =icon0.getImage();
        Image img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon0.setImage(img2);
        img=icon01.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon01.setImage(img2);
        img=icon02.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon02.setImage(img2);
        img=icon03.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon03.setImage(img2);
        img=icon04.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon04.setImage(img2);
        img=icon05.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon05.setImage(img2);
        img=icon06.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon06.setImage(img2);
        img=icon07.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon07.setImage(img2);
        img=icon08.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon08.setImage(img2);
        img=icon09.getImage();
        img2=img.getScaledInstance(150,100,Image.SCALE_SMOOTH);
        icon09.setImage(img2);









     /* bot[0].setIcon(icon0);
        bot[1].setIcon(icon01);
        bot[2].setIcon(icon02);
        bot[3].setIcon(icon03);
        bot[4].setIcon(icon04);
        bot[5].setIcon(icon05);
        bot[6].setIcon(icon06);
        bot[7].setIcon(icon07);
        bot[8].setIcon(icon08);
        bot[9].setIcon(icon09);*/

    }
}
