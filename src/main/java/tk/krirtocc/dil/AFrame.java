package tk.krirtocc.dil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * @创建人 六濑
 * @创建时间 2019/1/18- 18:33
 */
public class AFrame extends JFrame {
    private boolean monitor=true;
    private int mx,my,jfx,jfy;
    private int agox=0,agoy=0,agow=0,agoh=0;
    private TitlePanel headline;
    private JPanel Usp;
    public AFrame(){

        this.setUndecorated(true);
        headline  = new TitlePanel();
        Usp =new Uspanel();
        Usp.setLayout(new BorderLayout());

        this.setLayout(null);
        this.setSize(500,170);
        headline.setBounds(0,0,this.getWidth(),30);
        Usp.setBounds(0,30,this.getWidth(),getHeight()-25);


        headline.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (monitor){
                    setLocation(jfx+(e.getXOnScreen()-mx),jfy+(e.getYOnScreen()-my));
                }
            }
        });
        headline.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               if (monitor){
                   mx =e.getXOnScreen();
                   my=e.getYOnScreen();
                   jfx=getX();
                   jfy=getY();
               }

            }
        });
        JButton button=new JButton();
        button.setUI(new RedButtonUI());
        button.setBorderPainted(false);
        button.setBounds(10,7,18,18);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        headline.add(button);
        JButton button1=new JButton();
        button1.setUI(new YellowButtonUI());
        button1.setBorderPainted(false);
        button1.setBounds(37,7,18,18);
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setExtendedState(ICONIFIED);
            }
        });
        headline.add(button1);
        JButton button2=new JButton();
        button2.setUI(new greenButtonUI());
        button2.setBorderPainted(false);
       button2.setBounds(64,7,18,18);
        headline.add(button2);
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if((int) Toolkit.getDefaultToolkit().getScreenSize().width!=getWidth()&&(int) Toolkit.getDefaultToolkit().getScreenSize().height!=getWidth()){
                    agox=getX();
                    agoy=getY();
                    agoh=getHeight();
                    agow=getWidth();
                    setSize((int) Toolkit.getDefaultToolkit().getScreenSize().width,(int) Toolkit.getDefaultToolkit().getScreenSize().height);
                    setLocation(0   , 0);
                    monitor=false;

                }else{
                    setSize(agow,agoh);
                    setLocation(agox,agoy);
                    monitor=true;
                }


            }
        });
        this.add(headline);
        add(Usp);
        setBackground(new Color(0,0,0,0));

    }
    public void setSize(int width, int height) {

        super.setSize(width, height);
        headline.setBounds(0,0,this.getWidth(),30);
        Usp.setBounds(0,30,this.getWidth(),getHeight()-25);
    }

public Component join(Component component){
        return Usp.add(component);
}
    public Component join(String mane ,Component component){
        return Usp.add(mane,component);
    }

    @Override
    public void setTitle(String title) {
        headline.setTitle(title);
    }
}
