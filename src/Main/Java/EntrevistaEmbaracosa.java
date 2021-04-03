package Main.Java;

import  java.io.BufferedReader ;
import  java.io.InputStreamReader ;
import  java.io.IOException ;
import  java.util.StringTokenizer ;

public  class  EntrevistaEmbaracosa{
    public  static  void  main ( String [] args ) throws IOException {
        //Capturando a entrada de dados
        BufferedReader br =  new  BufferedReader ( new InputStreamReader( System.in ));

        String proximaPalavra;

        //Inserindo a entrada de dados dentro da variavel criada acima.
        // E condição para verificar se há algum dado inserido.
        while ((proximaPalavra = br.readLine()) !=  null ) {

            //Variavel para indicar se o fim de alguma palavra repete.
            boolean encontrouRepeticao = false;

            for ( int i = 0 ; i <= proximaPalavra.length() - 1 ; i ++ ) {

                // Utilizando substring() e endsWith(), para verificar se o final da palavra se repete.
                // Se repetir, ele exibi a palavra completa, eliminando o trecho que se repete.
                if (proximaPalavra.substring (0 , i).endsWith(proximaPalavra.substring (i))) {
                    System.out.println(proximaPalavra.substring ( 0 , i));
                    encontrouRepeticao =  true ;
                }
            }
            //Senão repetir, exibiremos a palavra completa.
            if ( ! encontrouRepeticao)
                System.out.println(proximaPalavra);
        }
    }
}
