# java-4
java实验四 计202 宋明扬 2020310606
# 一、实验目的
1.掌握Java中类的定义
<br>2.掌握static  final等修饰符的用法
<br>3.了解异常的使用方法，并在程序中根据输入情况做异常处理
# 二、实验内容
&emsp;&emsp;某学校为了给学生提供勤工俭学机会，选派了部分学生参与实验室的卫生清洁工作。每个学生被分配若干间实验室，视实验室的清洁打分情况给予劳务补贴。
<br>&emsp;&emsp;例如：
<br>&emsp;&emsp;学生“张三”负责了“计算机网络实验室”、“组成原理实验室”的清洁情况，每周被检查。在某次检查中，“计算机网络实验室”卫生得“优”，“组成原理实验室”卫生得“及格”，一次“优”按x元记录补助，一次“及格”按y元记录补助。（卫生标准分级、相应的等级补助标准，自行规定）
<br>&emsp;&emsp;按国家的税务制度，劳务费应按国家规定纳税，请统计一学期学生的实际收入。（国家最新工资纳税标准，请自行检索）
<br>1.设计系统中的类（如学生、实验室等等）；
<br>2.一学期按18周计；
<br>3.每个学生负责的实验室数量不一定相同；
<br>4.对学期勤工俭学收入和纳税进行统计，求得实际收入；
<br>5.国家最新纳税标准（系数），属于某一时期的特定固定值，与实例化对象没有关系，考虑如何用staticfinal修饰定义。
<br>6.根据处理情况，要在程序中考虑做异常处理。
# 三、解题思路
## **步骤一**：
&emsp;&emsp;**编写类“Lab” 实现打分，依次读取所输入的18个值，并将其放入一个数组中。**
## **步骤二**：
&emsp;&emsp;**编写类“Student”实现对学生所得劳务补贴进行计算，首先将所打的分数分为0-5、5-7、7-10三个等级，分别给予10、15、20的补助，计算出实际所得的全部补助。
<br>&emsp;&emsp;然后在编写类“Peizhi”实现对应纳税值的录入，同时在类“Student”中引用，然后实现对纳税后学生所得收入的输出。**
# 四、关键代码
1. 在Lab类中，通过setscore函数实现对所评成绩的录入。
```java 
    public void setScore() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("请打分");
            int[] a = new int[18];
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
```
2. 类Ppeizhi对纳税值得录入。
```java
public class Peizhi {
    public static final double tax = 0.03;
    public static final double taxmax = 0.05;
    public static final double taxmin = 0.01;
}

```
3. 类Student值运用cal_money和cal_tax两个函数实现对所得补助和税后补助的输出。
```java
public void cal_money(){
        int[] a = new int[18];
        System.out.println("一次最高补助价格：" + Lab.great);
        System.out.println(this.name + "的收入统计");
        double m,n;
        for (int i = 0;i< labs.length;i++){

            if (labs[i] == null){
                continue;
            }
            else {
                System.out.println(labs[i].getName() + "收入统计：");
                a = labs[i].getScore();
                m = 0;
                n = 0;
                for(int j=0;j<18;j++){
                    if(a[j]>0 & a[j]<=5){
                        m = m + Lab.pass;
                        n = Lab.pass;
                        System.out.println(j+1 +"周收入:" +n);
                    }
                    else if(a[j]>7 & a[j]<=10){
                        m = m + Lab.great;
                        n = Lab.great;
                        System.out.println(j+1 +"周收入:" +n);
                    }
                    else if(a[j]>5 & a[j]<=7){
                        m = m + Lab.good;
                        n = Lab.good;
                        System.out.println(j+1 +"周收入:" +n);
                    }

                }
                System.out.println(labs[i].getName() + "的总共收入" + m);
                money = m + money;
            }
        }

        System.out.println(this.name + "的总共收入" + money);
    }

    public void cal_tax(){
        if(money<=200){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.taxmin)));
        }
        else if(money>200 & money<=400){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.tax)));
        }
        else if(money>400){
            System.out.println(this.name + "的税后所得为"+ Math.round(money*(1- Peizhi.taxmax)));
        }
    }
}
```
# 五、感想与体会
&emsp;&emsp;本次实验中运用了static final修饰符，同时实现了要求的部分功能，但由于难度较大，为实现对成绩的输入功能，运用的是默认成绩，存在一些瑕疵。后续还会对程序进行改进。
<br>&emsp;&emsp;本次实验难度较大，为了完成实验，搜索了大量的资料，对不解的问题，寻求同学和老师的帮助，逐步解决问题，使自己的水平有了较大的提高。
