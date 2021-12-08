import java.util.NoSuchElementException;
import java.util.Scanner;

public class Lab {
    static double great = 20;
    static double good = Math.ceil(great*0.75);
    static double pass = Math.ceil(great*0.5);
    private String name;
    private int room;
    private int[] score = new int[18];


    public Lab(String name,int room){
        this.name = name;
        this.room = room;
    }


    public void setscore(int[] a){ this.score = a; }
    public void setScore() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("请打分");
            //int[] a = new int[18];
            for (int i = 0; i < 18; i++) {
                System.out.println("第" + (i + 1) + "周:");
                score[i] = in.nextInt();
                if(score[i]>0 & score[i]<=10){
                    continue;
                }
                else{
                    System.out.println("输入错误");
                    break;
                }
            }
        }
        catch (NoSuchElementException in){
            System.out.println("输入耗尽");
        }
        catch (IllegalStateException in){
            System.out.println("此扫描仪已关闭");
        }
        catch (Exception n){
            System.out.println("异常");
            n.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
    public int[] getScore(){
        return score;
    }

}
