package Main.Java;
import  java.io.BufferedReader ;
import  java.io.IOException ;
import  java.io.InputStreamReader ;
import  java.io.PrintWriter ;

public  class  MaiorSubstring {

    static BufferedReader in =  new  BufferedReader ( new  InputStreamReader ( System.in));
    static PrintWriter  out =  new  PrintWriter (System.out);

    public  static  void  main ( String [] args ) throws  IOException {
        String s1, s2, min, max;

        //Capturando a primeira palavra inserida
        while ((s1 = in.readLine ()) != null ) {
            //Capturando a segunda palavra inserida
            s2 = in.readLine();

            //Atribuindo as palavras inseridas as novas variaveis
            if (s1.length() > s2.length()) {
                max = s1;
                min = s2;
            } else {
                max = s2;
                min = s1;
            }
            //Atribuindo o numero de caracteres da menor palavra
            int minLength = min.length();
            int maxS = minLength;
            boolean f =  true ;

            //Se a menor palavra for maior que 0, ele entra no While.
            while (maxS >  0  && f) {
                int diff = minLength - maxS;

                //Logica para encontrar a maior substring.
                for ( int i =  0 ; i <= diff; i ++ ) {
                    if (max.contains(min.substring (i, i + maxS))) {
                        f =  false ;
                        maxS ++ ;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(maxS);
        }
        out.close();
    }

}
