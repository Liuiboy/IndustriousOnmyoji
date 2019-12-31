package tk.krirtocc.script;

import com.sun.glass.events.KeyEvent;
import tk.krirtocc.RobotUI;


import java.awt.*;
import java.util.Random;

/**
 * @创建人 六濑
 * @创建时间 2019/1/22- 9:17
 */
public interface Step {
    public  void getStep();
    public int setI();
}
class Begin implements Step{
    private Robot robot;
    private int x,y;
    Random ra =new Random();
    public Begin(Robot robot,int x,int y)
    {
        this.robot=robot;
        this.x=x;
        this.y=y;
    }
    public void getStep() {
        if (robot.getPixelColor(844+x,526+y).getRGB()==new Color(244,178,95).getRGB()){
            if(RobotUI.getRobotUI().getColor().getRGB()==robot.getPixelColor(159,23).getRGB()) {
                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyPress(KeyEvent.VK_1);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
            }
            robot.delay(ra.nextInt(350)+270);
            robot.keyPress(KeyEvent.VK_K);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_K);
        }
    }

    @Override
    public int setI() {
        return 0;
    }
}
 class SingleEndA implements Step{
    private Robot robot;
    private int x,y;
    Random ra =new Random();
    public SingleEndA(Robot robot,int x,int y)
    {
        this.robot=robot;
        this.x=x;
        this.y=y;
    }
    public void getStep() {

        if (robot.getPixelColor(507+x,487+y ).getRGB()==new Color(242,216,180).getRGB()){
                if(RobotUI.getRobotUI().getColor().getRGB()==robot.getPixelColor(159,23).getRGB()) {
                    robot.keyPress(KeyEvent.VK_WINDOWS);
                    robot.keyPress(KeyEvent.VK_1);
                    robot.delay(200);
                    robot.keyRelease(KeyEvent.VK_1);
                    robot.keyRelease(KeyEvent.VK_WINDOWS);
                }
            robot.delay(ra.nextInt(350)+270);
            robot.keyPress(KeyEvent.VK_K);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_K);
        }
    }

    @Override
    public int setI() {
        return 0;
    }
}
class SingleEndB implements Step{
    private Robot robot;
    private int x,y;
    private static int i=0;
    Random ra =new Random();
    public SingleEndB(Robot robot,int x,int y)
    {
        this.robot=robot;
        this.x=x;
        this.y=y;
        i=0;
    }

    public int getI() {
        return i;
    }

    public void getStep() {
        if (robot.getPixelColor(543+x,458+y).getRGB()==new Color(187,56,26).getRGB()){
            if(RobotUI.getRobotUI().getColor().getRGB()==robot.getPixelColor(159,23).getRGB()) {
                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyPress(KeyEvent.VK_1);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
            }
            RobotUI.getRobotUI().For=0;
            robot.delay(ra.nextInt(350)+270);
            i++;
            RobotUI.getRobotUI().addtext(RobotUI.getRobotUI().getH()+"---第"+i+"回\n");
            robot.keyPress(KeyEvent.VK_K);
            robot.delay(ra.nextInt(400)+250);
            robot.keyRelease(KeyEvent.VK_K);
        }
    }

    @Override
    public int setI() {
        return i;
    }


}
class TabEndA implements Step{
    private Robot robot;
    private int x,y;
    Random ra =new Random();
    public TabEndA(Robot robot,int x,int y)
    {
        this.robot=robot;
        this.x=x;
        this.y=y;
    }
    public void getStep() {

        if (robot.getPixelColor(507+x,487+y ).getRGB()==new Color(242,216,180).getRGB()){
            if(RobotUI.getRobotUI().getColor().getRGB()==robot.getPixelColor(159,23).getRGB()) {
                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyPress(KeyEvent.VK_1);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
            }
            robot.delay(ra.nextInt(350)+270);
            robot.keyPress(KeyEvent.VK_K);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_K);

            robot.delay(ra.nextInt(800)+600);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(ra.nextInt(100)+50);
            robot.keyPress(KeyEvent.VK_3);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_3);
            robot.delay(ra.nextInt(100)+50);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(ra.nextInt(600)+500);

            robot.keyPress(KeyEvent.VK_K);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_K);

            robot.delay(ra.nextInt(700)+600);


            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(ra.nextInt(100)+50);
            robot.keyPress(KeyEvent.VK_2);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_2);
            robot.delay(ra.nextInt(100)+50);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        }
    }

    @Override
    public int setI() {
        return 0;
    }


    }
class TabEndB implements Step{
    private Robot robot;
    private int x,y;
    private static int i=0;
    Random ra =new Random();
    public TabEndB(Robot robot, int x, int y)
    {
        this.robot=robot;
        this.x=x;
        this.y=y;
        i=0;
    }

    public int getI() {
        return i;
    }

    public void getStep() {
        if (robot.getPixelColor(543+x,458+y).getRGB()==new Color(187,56,26).getRGB()){
             i++;
             if(RobotUI.getRobotUI().getColor().getRGB()==robot.getPixelColor(159,23).getRGB()) {
                robot.keyPress(KeyEvent.VK_WINDOWS);
                robot.keyPress(KeyEvent.VK_1);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_1);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
            }

            RobotUI.getRobotUI().For=0;
            robot.delay(ra.nextInt(350)+270);

            RobotUI.getRobotUI().addtext(RobotUI.getRobotUI().getH()+"---第"+i+"回\n");
            robot.keyPress(KeyEvent.VK_K);
            robot.delay(ra.nextInt(400)+250);
            robot.keyRelease(KeyEvent.VK_K);

            robot.delay(ra.nextInt(700)+600);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(ra.nextInt(100)+50);
            robot.keyPress(KeyEvent.VK_3);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_3);
            robot.delay(ra.nextInt(100)+50);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            robot.delay(ra.nextInt(700)+600);

            robot.keyPress(KeyEvent.VK_K);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_K);

            robot.delay(ra.nextInt(700)+600);


            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.delay(ra.nextInt(100)+50);
            robot.keyPress(KeyEvent.VK_2);
            robot.delay(ra.nextInt(350)+270);
            robot.keyRelease(KeyEvent.VK_2);
            robot.delay(ra.nextInt(100)+50);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(ra.nextInt(200)+50);
        }
    }

    @Override
    public int setI() {
        return i;
    }

}