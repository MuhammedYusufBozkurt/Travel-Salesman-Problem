import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        int boyut = 0;
        File dosya = new File("C:\\\\Gezgin satıcı problemi\\\\tsp_5_1.txt");
        if(dosya.exists())
        {
            System.out.println("dosya bulundu");
        }
        else
        {
            System.out.println("dosya bulunamadı");
        }

        Scanner scanner = new Scanner(dosya);
        boyut = scanner.nextInt();

        double[][] konum = new double [boyut][3];
        int i = -1;
        int j = 0;

        if(boyut < 10)
        {
            while (scanner.hasNext()) {


                if( i == -1)
                {

                    //System.out.println(" dosya boyutu : " + boyut);
                    i++;
                }
                else
                {
                    if(j % 2 == 0)
                    {
                        konum[i][0] = scanner.nextDouble();
                        //System.out.println(i + ". şehrin x konumu " + konum[i][0]);
                        j++;
                    }
                    else
                    {
                        konum[i][1] = scanner.nextDouble();
                        //System.out.println(i + ". şehrin y konumu " + konum[i][1]);
                        i++;
                        j++;
                    }


                }
            }
        }
        else {
            while (scanner.hasNext())
            {
                if( i == -1)
                {

                    //System.out.println(" dosya boyutu : " + boyut);
                    i++;
                }

                String a = scanner.next();
                String b = scanner.next();

                konum[i][0] = Double.valueOf(a);
                konum[i][1]= Double.valueOf(b);

                //System.out.println( konum[i][0] + " " + konum[i][1]);
                i++;
            }
        }

        for(int q = 0; q< konum.length;q++)
        {
            konum[q][2]=0;
        }
        /*for(int q = 0; q< konum.length;q++)
        {
            System.out.println(q+1 + ". sehir " + konum[q][2]);
        }*/
        scanner.close();
        double Xuzaklik = 0;
        double Yuzaklik = 0;
        double Uzaklik = 0;
        double maxUzaklik = 0;
        double minUzaklik = 0;
        int uzakSehir =0;
        int [] gez = new int[boyut];
        int a;
        int yakinSehir = 0;
        double topSeyahat = 0;
        double geriDonus = 0;
        double geriDonus1 = 0;
        int bas = 0;

        for(a = 0; a<konum.length ; a++)
        {

            Xuzaklik = 0 - konum[a][0] ;

            Yuzaklik = 0 - konum[a][1] ;

            Uzaklik=Math.sqrt(Xuzaklik*Xuzaklik+Yuzaklik*Yuzaklik);
            if(maxUzaklik<=Uzaklik)
            {
                maxUzaklik=Uzaklik;
                uzakSehir = a+1;
            }
        }

        int baslangic = 0;
        double minTopSeyahat = maxUzaklik * konum.length * 10;
        int baslangic1 = 0;
        int minTopSeyahatint = 0;

            for(int b = 0; b< konum.length ; b++)
            {
                topSeyahat=0;
                baslangic1=b;
                baslangic=b;
                gez[0] = b+1;
                konum[b][2]=1;

                for(int c = 1; c<konum.length;c++ )
                {

                    minUzaklik=4*maxUzaklik;
                    for(int d = 0; d< konum.length ; d++)
                    {

                        if(konum[d][2] == 0)
                        {
                            Xuzaklik = konum[baslangic1][0] - konum[d][0];

                            Yuzaklik = konum[baslangic1][1] - konum[d][1];

                            Uzaklik=Math.sqrt(Xuzaklik*Xuzaklik+Yuzaklik*Yuzaklik);

                            if (Uzaklik <= minUzaklik)
                            {
                                minUzaklik = Uzaklik;
                                yakinSehir = d;

                            }

                        }


                    }
                    konum[yakinSehir][2]=1;
                    baslangic1=yakinSehir;
                    gez[c] = yakinSehir+1;
                    topSeyahat +=minUzaklik;




                }
                for(int q = 0; q< konum.length;q++)
                {
                    konum[q][2]=0;
                }


                Xuzaklik = konum[baslangic][0] - konum[gez[gez.length-1]-1][0];

                Yuzaklik = konum[baslangic][1] - konum[gez[gez.length-1]-1][1];

                Uzaklik=Math.sqrt(Xuzaklik*Xuzaklik+Yuzaklik*Yuzaklik);
                geriDonus=Uzaklik;
                topSeyahat += geriDonus;

                if (topSeyahat <= minTopSeyahat)
                {
                    minTopSeyahat = topSeyahat;
                    bas = b;
                    geriDonus1=geriDonus;
                }

            }

            //System.out.println("Minimum Seyahat Maailiyeti : " + minTopSeyahat);
            //System.out.println("Başlangıç Şehri : " + (bas+1));
            //System.out.println("Geri dönüş : " + geriDonus1);


        for(int q = 0; q< konum.length;q++)
        {
            konum[q][2]=0;
        }
        konum[bas][2]=1;
        gez[0]=bas+1;
        topSeyahat = 0;
        // System.out.println("Başlangıç Şehri : " + (bas +1));

        for(int c = 1; c<konum.length;c++ )
        {
            minUzaklik=maxUzaklik;
            baslangic1 = gez[c-1] - 1 ;
            for(int d = 0; d< konum.length ; d++)
            {
                if(konum[d][2] == 0)
                {
                    Xuzaklik = konum[baslangic1][0] - konum[d][0];

                    Yuzaklik = konum[baslangic1][1] - konum[d][1];

                    Uzaklik=Math.sqrt(Xuzaklik*Xuzaklik+Yuzaklik*Yuzaklik);

                    if (Uzaklik <= minUzaklik)
                    {
                        minUzaklik = Uzaklik;
                        yakinSehir = d;
                    }
                }
            }
            konum[yakinSehir][2]=1;
            gez[c] = yakinSehir+1;
            topSeyahat +=minUzaklik;
        }


        minTopSeyahatint = (int) minTopSeyahat;
        //System.out.println("Toplam seyahat maaliyeti : " + minTopSeyahatint);


        int y = 0;
        if (boyut==5)
        {
            y=1;
        } else if (boyut==124) {
            y=2;
        } else if (boyut==1000) {
            y=3;
        } else if (boyut==5915) {
            y=4;
        } else if (boyut==11849) {
            y=5;
        } else if (boyut==85900) {
            y=6;
        }
        System.out.print(y + ". SONUÇ : ");
        System.out.print("Boyut : " + boyut  + ",     Minimum Toplam Seyahat Maaliyeti : " + minTopSeyahatint + ",     Yol : ");
        for(int c = 0; c< gez.length ; c++)
        {
            System.out.print(gez[c] + " ");
            if(c== gez.length-1)
            {
                System.out.print(gez[0]);
            }
        }
    }


}