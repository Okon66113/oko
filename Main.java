package com.company;

public class Main {

    public static void main(String[] args) {
        ships s4=new ships(4);          //tworze statki wiadomo 4 czteromasztowiec 3 trzy itd
        ships s3a=new ships(3);
        ships s3b=new ships(3);

        ships s2a=new ships(2);
        ships s2b=new ships(2);
        ships s2c=new ships(2);
        ships s1a=new ships(1);
        ships s1b=new ships(1);
        ships s1c=new ships(1);
        ships s1d=new ships(1);


        int [][]table=new int[12][12];

        table=s4.tableTest(table, s4);  //umieszczam statki na planszy czy Table test nie powinien byc statyczny ?
        table=s3a.tableTest(table, s3a);
        table=s3b.tableTest(table, s3b);
        table=s2a.tableTest(table, s2a);
        table=s2b.tableTest(table, s2b);
        table=s2c.tableTest(table, s2c);
        table=s1a.tableTest(table, s1a);
        table=s1b.tableTest(table, s1b);
        table=s1c.tableTest(table, s1c);
        table=s1d.tableTest(table, s1d);



        for(int i=1;i<11;i++){                          //wyswietlanie 
            for(int j=1;j<11;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
}
