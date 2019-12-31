package tk.krirtocc.dil;

import javax.swing.*;
import java.awt.*;

/**
 * @创建人 六濑new
 * @创建时间 2019/1/14- 11:07
 */
public class TitlePanel extends JPanel {

    private static boolean aBoolean=false;
    private String title="@liulai";
    public TitlePanel(){

        this.setLayout(null);

    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g ;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(200,200,200,0));
        g2d.fillRect(0,0,this.getWidth(),4);
        g2d.setColor(new Color(200,200,200));
        g2d.fillRoundRect(0,0,this.getWidth(),34,10,10);

        g2d.setColor(new Color(50,50,50));
        g2d.setFont(new Font("Hevetica Neue",Font.PLAIN,14));
        g2d.drawString(title,this.getWidth()/2-title.length()*4,20);
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
class Uspanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g ;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(240,220,220));
        g2d.fillRoundRect(0,-5,getWidth(),getHeight(),10,10);

    }

}
