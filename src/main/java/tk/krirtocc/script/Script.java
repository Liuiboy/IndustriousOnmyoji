package tk.krirtocc.script;

import com.sun.glass.events.KeyEvent;
import tk.krirtocc.RobotUI;

import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @创建人 六濑
 * @创建时间 2019/1/20- 22:31
 */
public class Script extends Thread{
    private int x,y,w,h,i=0,cd=4;
    private  static int sty=0 ;
    private static Iterator iter;
    private static boolean Boolean=true;
    private static int end=2;

    private static ArrayList<Step> s=new ArrayList<Step>();


    public Script(){

    }
    public void setSty(int sty) {
        this.sty = sty;
    }

    public  void setEnd(int end) {
        this.end = end;
    }

    public int getY() {
        return y;
    }


    public  void setBoolean(boolean aBoolean) {
        Script.Boolean = aBoolean;
    }

    public void  add(Step step){
        s.add(step);

    }



    public void run(){
        Gps();
        Step step = null;
        try {
            Robot robot=new Robot();
            RobotUI.getRobotUI().setColor(robot.getPixelColor(159,23));


            s.clear ();
            if (sty!=cd) {
                cd=sty;
                switch (sty) {
                    case 0:
                        add(new Begin(robot, x, y));
                        add(new SingleEndA(robot, x, y));
                        step=new SingleEndB(robot, x, y);
                        add(step);//单人领队
                    break;
                    case 1:
                        add(new Begin(robot, x, y));
                        add(new TabEndA(robot, x, y));
                        step=new TabEndB(robot, x, y);
                        add(step);//双开模式
                        break;
                    case 2:
                        add(new SingleEndA(robot, x, y));
                        step=new SingleEndB(robot, x, y);
                        add(step);//单人打手
                        break;

                }
            }
            Boolean=true;
            while (Boolean){
                iter=s.iterator();
                RobotUI.getRobotUI().For++;
                robot.delay(500);
                while(iter.hasNext()){
                    Step ss=(Step) iter.next();
                    ss.getStep();

                }
                if (RobotUI.getRobotUI().For==120){
                    Boolean = false;
                }
            }
            RobotUI.getRobotUI().addtext("----已结束运行----\n");
            RobotUI.getRobotUI().addtext("-本次运行"+step.setI()+"回,"+"累计消耗"+(step.setI()*4)+"体力-\n");
            if (RobotUI.getRobotUI().getLog())writeTxtFile(RobotUI.getRobotUI().jTextArea1.getText());
            switch (end) {
                case 0:
                    try {
                        Runtime.getRuntime().exec("shutdown -s -t 60");
                        System.exit(0);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 1:
                    System.exit(0);
                    break;
                case 2:
                    break;
            }
        }catch (AWTException e){
            e.printStackTrace();
        }
    }
    public void Starting(Robot robot,int keyEvent){
        robot.delay(2000);
        while (true){
            robot.delay(500);
            if (robot.getPixelColor(949+x,49+y).getRGB()==new Color(255,255,255).getRGB())
            {
                robot.keyPress(keyEvent);
                robot.delay(300);
                robot.keyRelease(keyEvent);
                robot.delay(3000);

            while (true){
                robot.delay(200);
            if (robot.getPixelColor(x+855,y+306).getRGB()==new Color(0,0,0).getRGB()) {
                robot.keyPress(KeyEvent.VK_R);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_R);
            }
            if (robot.getPixelColor(486+x,106+y).getRGB()==new Color(219,178,112).getRGB()){
                robot.keyPress(KeyEvent.VK_X);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_X);
            }
            if (robot.getPixelColor(430+x,130+y).getRGB()==new Color(255,216,167).getRGB()) {
                robot.keyPress(KeyEvent.VK_R);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_R);
            }

            if(robot.getPixelColor(619+x,122+y ).getRGB()==new Color(90,99,123).getRGB()) {
                robot.keyPress(KeyEvent.VK_R);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_R);
                break;

            }

            }
                break;
            }


        }
    }
    public static void writeTxtFile(String content){
        javax.swing.filechooser.FileSystemView fsv = javax.swing.filechooser.FileSystemView.getFileSystemView();
        System.out.print(RobotUI.getRobotUI().getH());
        String file=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+"日志";
        try {
            FileWriter fileWriter = new FileWriter(fsv.getDefaultDirectory().getPath()+"/"+file+".txt");

            fileWriter.write(content);
            fileWriter.flush();
            fileWriter.close();
            RobotUI.getRobotUI().addtext("日志以保存至"+fsv.getDefaultDirectory().getPath()+"\\"+file+".txt\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void Gps(){
        try
        {
            Process pro =  Runtime.getRuntime().exec("Grab.exe");
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));

            String str;
            if (( str = br.readLine()) == null)
            {

            }else {
                StringTokenizer token=new StringTokenizer(str," ");
                if (token.hasMoreTokens()) {
                    x=Integer.parseInt(token.nextToken());
                    y=Integer.parseInt(token.nextToken());
                    w=Integer.parseInt(token.nextToken())-x;
                    h=Integer.parseInt(token.nextToken())-x;
                }

            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }


}



