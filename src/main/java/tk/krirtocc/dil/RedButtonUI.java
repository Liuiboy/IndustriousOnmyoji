package tk.krirtocc.dil;

import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;

/**
 * @创建人 六濑
 * @创建时间 2019/1/18- 19:14
 */
public class RedButtonUI extends BasicButtonUI {



    @Override
    protected void installDefaults(AbstractButton b){
        super.installDefaults(b);
        LookAndFeel.installProperty(b,"opaque",Boolean.FALSE);
    }
    @Override
    public void paint(Graphics g,JComponent c){
        g.setColor(new Color(238,106,94));
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, 18, 18);
        super.paint(g,c);
    }
    public void paintButtonPressed(Graphics g, AbstractButton b) {
        g.setColor(new Color(255,98,89));
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, 18, 18);
        g2d.setColor(new Color(82,3,2));
        g2d.drawLine(5,5,13,13);
        g2d.drawLine(13,5,5,13);
    }


}

class YellowButtonUI extends BasicButtonUI {
    @Override
    protected void installDefaults(AbstractButton b){
        super.installDefaults(b);
        LookAndFeel.installProperty(b,"opaque",Boolean.FALSE);
    }
    @Override
    public void paint(Graphics g,JComponent c){
        g.setColor(new Color(246,190,79));
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, 18, 18);
        super.paint(g,c);
    }
    public void paintButtonPressed(Graphics g, AbstractButton b) {
        g.setColor(new Color(253,181,37));
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, 18, 18);
        g2d.setColor(new Color(134,69,2));
        g2d.drawLine(3,9,14,9);
    }


}
class greenButtonUI extends BasicButtonUI {
    @Override
    protected void installDefaults(AbstractButton b){
        super.installDefaults(b);
        LookAndFeel.installProperty(b,"opaque",Boolean.FALSE);
    }
    @Override
    public void paint(Graphics g,JComponent c){
        g.setColor(new Color(98,197,84));
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, 18, 18);
        super.paint(g,c);
    }
    public void paintButtonPressed(Graphics g, AbstractButton b) {
        g.setColor(new Color(37,200,58));
        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(0, 0, 18, 18);
        g2d.setColor(new Color(3,100,3));
        g2d.drawLine(3,9,14,9);
        g2d.drawLine(8,4,8,15);
    }
}

