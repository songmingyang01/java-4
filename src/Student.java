public class Student {
    private String name;
    private int id;
    private double money;
    private int i;
    private Lab[] labs = new Lab[5];

    public Student(String name,int id){
        this.name = name;
        this.id = id;
    }

    public void add_lab(Lab lab){
        labs[i] = lab;
        i++;
    }

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
