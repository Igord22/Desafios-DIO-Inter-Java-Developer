package Main.Java;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.*;

public class AbreviadorDePalavras {

    public static void main(String[] args) throws IOException {
        //Criando uma lista com as letras do alfabeto.
        List<String> alfabeto = new ArrayList(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));

        //Capturando a entrada de dados
        Scanner sc = new Scanner(System.in,"ISO-8859-1");

        //Incluindo toda a logica dentro do while para ter novamente uma entrada de dados.
        while(true) {

            //Atribuindo a entrada de dados a uma variavel String
            String frase = sc.nextLine()
                    .trim()
                    .toLowerCase()
                    .replaceAll("\n", " ")
                    .replaceAll("\t", " ");

            //Condicionais
            if(frase.equals(".")) break; //Finaliza o programa caso entre um "."
            if(frase.length() <= 0) continue; //Continua o processo com a entrada das letras.

            //Armazenando os dados de entrada em uma Lista
            List<String> vetPalavrasFrase = new ArrayList(Arrays.asList(frase.split(" ")));

            //Criação de uma MAP
            Map<String, String> dicionario = new HashMap<String, String>();

            alfabeto.stream().forEach(letra -> {

                //Adicionando as letras do alfabeto como chaves.
                dicionario.put(letra, "");
            });

            //MAP Criado para adicionar o numero de repetição das palavras
            Map<String, Map<String, Integer>> repeticaoPalavra = new HashMap<String, Map<String, Integer>>();

            alfabeto.stream().forEach(letra -> {

                //Adicionando as letras como chaves.
                repeticaoPalavra.put(letra, new HashMap<String, Integer>());
            });

            vetPalavrasFrase.stream().forEach(palavra -> {

                //Adiciona as palavras inseridas pelo usuario as suas respectivas letras e adiciona um numero
                //que posteriormente será armazenado a quantidade de repetições.
                repeticaoPalavra.get(palavra.substring(0, 1)).put(palavra, 0);
            });

            vetPalavrasFrase.stream().forEach(palavra -> {

                //Atribuindo o numero de repetições de cada palavra.
                int qt = repeticaoPalavra.get(palavra.substring(0, 1)).get(palavra);
                qt++;
                repeticaoPalavra.get(palavra.substring(0, 1)).put(palavra, qt);
            });


            alfabeto.stream().forEach(letra -> {

                //MAP para receber a palavra + quantidade de repetição.
                Map<String, Integer> map = repeticaoPalavra.get(letra);

                //Lista para capturar somente a palavra.
                List<String> chaves = new ArrayList<String>(map.keySet());

                int qtTotalCharPorLetra = 0;

                for (String chave : chaves) {
                    //Atribuindo a variavel a quantidade total de caracteres das palavras
                    qtTotalCharPorLetra += map.get(chave) * chave.length();
                }

                int qtTotalCharMelhorCenario;
                int qtTotalCharMelhorCenarioAux = 10000;

                for (String chave : chaves) {
                    //Logica para determinar a menor palavra inserida e com base nela, as que serão abreviadas.
                    qtTotalCharMelhorCenario = (qtTotalCharPorLetra - (map.get(chave) * chave.length())) + (map.get(chave) * 2);

                    //Selecionando as palavras que serão abreviadas.
                    if((qtTotalCharMelhorCenarioAux > qtTotalCharMelhorCenario) && chave.length() > 2) {

                        qtTotalCharMelhorCenarioAux = qtTotalCharMelhorCenario;
                        dicionario.put(letra, chave);
                    }

                }

            });

            //Abreviando as palavras escolhidas
            String fraseAbreviada = vetPalavrasFrase
                    .stream()
                    .map(palavra -> {

                        //Capturando as primeiras letras.
                        String primeiraLetra = palavra.substring(0, 1);

                        //Concatenando-as com "." e palavras não abreviadas
                        return dicionario.get(primeiraLetra).equals(palavra) ? primeiraLetra + "." : palavra;
                    }).collect(Collectors.joining(" "));

            System.out.println(fraseAbreviada);

            int quantidadeAbreviacoes = 0;

            for(String letra : alfabeto) {

                //Somando a quantidade de palavras abreviadas
                if(!dicionario.get(letra).equals("")) {

                    quantidadeAbreviacoes++;

                }

            }

            System.out.println(quantidadeAbreviacoes);

            alfabeto.stream().forEach(letra -> {

                //Concatenta a letra + a palavra abreviada.
                if(!dicionario.get(letra).equals("")) {

                    System.out.println(letra + ". = " + dicionario.get(letra) );

                }

            });

        }

    }

}
