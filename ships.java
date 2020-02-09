package com.company;

public class ships {

    int numebrField;

    public ships(int numebrField){
        this.numebrField=numebrField;
    }


    public int[][]tableTest(int[][]table,ships st){     // metoda główna umieszcza statek na planszy zgodnie z zasadami gry w statki

        int x=0;            //wspolrzedne statku (poczatkowe) od tego miejsca zaczynamy rysowac nasz statek
        int y=0;

        while(true){
            int flipCoin=3;            // flip coin rozstrzyga kierunek rysowania (pion czy poziom ) wartosc startowa 3 zeby nie aktywowaw niepotrzebnych ifów
            boolean goodPio=false;      //zmiena mowiaca ze statek nie styka sie z innym statkiem w tym przypadku orientacja pionowa
            boolean goodPz=false;       //analogicznie
            boolean pionowo=false;      //zmiena sprawdzajaca krawedzie planszy tzn. czy 4 masztowiec bedzie sie miescił na polu x=8 gdy chcemy rysowac w dół
            boolean poziomo=false;      //analogicznie co wyzej tylko dla poziomu


            x=(int)(Math.random()*10);                                                //współrzedne wiersza
            y=(int)(Math.random()*10);                                                //współrzedna kolumny

            System.out.println("x= "+x+" y= "+y);     //pomocnik wyswietla dodatkowe info


            if(table[x][y]==0 && x!=0 && y!=0 && table[x-1][y]==0 && table[x][y-1]==0){  // poczatkowe sprawdzenie czy nie mamy doczynienia z zerami i sprawdzenie newralgicznych współrzednych


                pionowo=(x>(10-(st.numebrField-1)))?(false):(true);     //jesli wszystko jest ok sprawdzamy krawedzie czy mozemy rysowac tylko w pionie czy tylko w poziomie a moze w obydwu
                poziomo=(y>(10-(st.numebrField-1)))?(false):(true);


                System.out.println("pionowo= "+pionowo+" poziomo= "+poziomo); //w
            }

            if(pionowo==true&&poziomo==true){     //jesli rysowanie jest dozwolone w obydwu kierunkach losujemy jeden z nich
                flipCoin=(int)(Math.random()*2);
                System.out.println("flip= "+flipCoin); //w
            }

            if(flipCoin==0){
                goodPio=Support.postionPio(table, st.numebrField, x, y);  //sprawdzam czy inne statki uniemozliwią rysowanie w pionie
            }

            if(flipCoin==1){
                goodPz=Support.postionPz(table, st.numebrField, x, y);   //analogicznie co wyzej tylko poziom
            }

            if(goodPio){                                        //jesli pion jest dobry postaw statek
                for(int i=0;i<st.numebrField;i++){
                    table[x+i][y]=st.numebrField;
                }
                break;
            }
            if(goodPz) {                                //analogicznie co wyzej
                for(int i=0;i<st.numebrField;i++){
                    table[x][y+i]=st.numebrField;
                }
                break;
            }

            if(pionowo==true&&poziomo==false){             // jezeli ze wzgledu na krawedz planszy rysowanie mozliwe jest tylko pionie to tu sprawdzana jest reszta

                goodPio=Support.postionPio(table, st.numebrField, x, y);  //inne statki

                if(goodPio){ //jesli wszystko gra rysowanie

                    for(int i=0;i<st.numebrField;i++){
                        table[x+i][y]=st.numebrField;
                    }
                    break;
                }

            }

            if(pionowo==false&&poziomo==true){   //analogicznie co wyzej dla pionu
                goodPz=Support.postionPz(table, st.numebrField, x, y);
                if(goodPz){
                    for(int i=0;i<st.numebrField;i++){
                        table[x][y+i]=st.numebrField;
                    }
                    break;
                }
            }
        }





        return table;

    }
}
