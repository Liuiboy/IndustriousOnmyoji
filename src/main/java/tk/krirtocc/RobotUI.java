package tk.krirtocc;




import tk.krirtocc.dil.AFrame;
import tk.krirtocc.script.Script;


import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @创建人 六濑
 * @创建时间 2019/1/20- 22:21
 */
public class RobotUI extends AFrame {
    private JCheckBox jCheckBox;
    private static Color color;
    private JLabel jLabel1,jLabel2,jLabel3;
    private JComboBox jComboBox1,jComboBox2,jComboBox3;
    JPanel jPanel,jPanel2;
    public static JTextArea jTextArea1;
    JScrollPane jScrollPane;
    int i=0,j=0;
    private static Thread thread;
    public  int For=0;
    private JButton jButton;
    private static RobotUI robotUI=new RobotUI();
    private static String H;
    private SimpleDateFormat csse = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss");//设置日期格式
//

    public  Color getColor() {
        return color;
    }

    public  void setColor(Color color) {
        RobotUI.color = color;
    }

    public  String getH() {
        H=csse.format(new Date());
        return H;
    }

    private RobotUI(){
    }

    public static RobotUI getRobotUI() {
        return robotUI;
    }

    public  void setRobotUI(RobotUI robotUI) {
        RobotUI.robotUI = robotUI;
    }

    public void addtext(String string){
        jTextArea1.append(string);

    }
    public boolean setBoolean(){
        return  jCheckBox.isSelected();
    }
    public boolean getLog(){
        return jCheckBox.isSelected();
    }
    public void Run(){
        this.setSize(400,300);
        jPanel=new Mypanel();
        jCheckBox=new JCheckBox("保存运行日志");
        jLabel1=new JLabel("分辨率：");
        jLabel2=new JLabel("自动关机：");
        jLabel3=new JLabel("       模式：");
        jTextArea1=new JTextArea();
        jTextArea1.setEditable(false);
        jComboBox2=new JComboBox();
        jComboBox2.setModel(new DefaultComboBoxModel(new String[] {"执行完毕自动关机","仅退出程序","仅结束线程"}));
        jComboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (thread!=null) {
                    ((Script) thread).setEnd(jComboBox2.getSelectedIndex());
                }

            }
        });

        jComboBox1=new JComboBox();
        jComboBox3=new JComboBox();
        jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"1024x576","1280x720","1440x810"}));
        jComboBox3.setModel(new DefaultComboBoxModel(new String[] {"单人领队","双开模式","单人打手"}));

        jPanel.add(jLabel1);
        jPanel.add(jComboBox1);
        jPanel.add(jLabel2);
        jPanel.add(jComboBox2);
        jPanel2=new Mypanel();
        //jPanel2.setLayout(null);

         jButton=new JButton("开始运行");

        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (i==0){

                    jButton.setText("停止运行");
                    jTextArea1.append("-----开始运行-----\n");

                    thread=new Script();
                    ((Script) thread).setEnd(jComboBox2.getSelectedIndex());
                    ((Script)thread).setSty(jComboBox3.getSelectedIndex());
                    thread.start();
                    i=1;

                } else{
                    ((Script) thread).setEnd(2);
                    jButton.setText("开始运行");
                   ((Script)thread).setBoolean(false);
                    i=0;
                }
            }
        });
        jButton.setBorderPainted(false);
        jButton.setUI(new MyButtonUI());
        jButton.setBounds(0,0,85,30);
        jPanel2.add(jCheckBox);
        jPanel2.add(jLabel3);
        jPanel2.add(jComboBox3);
        jPanel2.add(jButton);
        jScrollPane=new JScrollPane();
        jScrollPane.setViewportView(jTextArea1);

        join("South", jPanel2);
        join("North",jPanel);
        join("Center",jScrollPane);

        this.setTitle("勤劳的阴阳师 ");

        this.setVisible(true);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RobotUI.getRobotUI().Run();

            }
        });

    }
}
class Mypanel extends JPanel{
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g ;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(new Color(240,220,220));
        g2d.fillRoundRect(0,0,getWidth(),25,10,10);

    }

}
class MyButtonUI extends BasicButtonUI {
    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        LookAndFeel.installProperty(b, "opaque", Boolean.FALSE);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        g.setColor(new Color(246, 190, 79));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRoundRect(0, 0, 85, 23,10,10);
        super.paint(g, c);
    }

    public void paintButtonPressed(Graphics g, AbstractButton b) {
        g.setColor(new Color(253, 181, 37));
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRoundRect(0, 0, 85, 23,10,10);

}
}

