package com.company;

public class Support {




    public static boolean postionPio(int[][]table,int shipNumber,int x,int y){ //metoda sprawdza czy statek nie sasjaduje z innym statkiem w pionie
        int counter=shipNumber;
        boolean goodPio=false;

        for(int i=0;i<shipNumber;i++){

            if(i==0){
                if(table[x-1][y]!=0 || table[x-1][y-1]!=0 || table[x-1][y+1]!=0){
                    break;
                }
            }

            if(table[x+i][y]!=0 || table[x+i][y+1]!=0 || table[x+i][y-1]!=0){
                break;
            }


            if(counter==1){
                if(table[x+i+1][y]!=0 || table[x+1+i][y+1]!=0 || table[x+1+i][y-1]!=0){
                    break;
                }
                else {goodPio=true;break;}
            }

            counter--;

        }
        System.out.println(goodPio);//w
        System.out.println();
        return goodPio;

    }


    public static boolean postionPz(int[][]table,int shipNumber,int x,int y){ //metoda sprawdza czy statek nie sadziaduje z innym statkiem w poziomie

        int counter=shipNumber;
        boolean goodPz=false;

        for(int i=0;i<shipNumber;i++){

            if(i==0){
                if(table[x][y-1]!=0 || table[x-1][y-1]!=0 || table[x+1][y-1]!=0){
                    break;
                }
            }

            if( table[x][y+i]!=0 || table[x+1][y+i]!=0 || table[x-1][y+i]!=0){
                break;
            }


            if(counter==1){
                if(table[x][y+1+i]!=0 || table[x-1][y+1+i]!=0 || table[x+1][y+1+i]!=0){
                    break;
                }
                else{goodPz=true;break;}
            }

            counter--;

        }




        System.out.println(goodPz);//w
        System.out.println();

        return goodPz;


    }

}
