package Main.Java;

import java.util.*;
import java.util.stream.Collectors;

public class ConjuntosBonsOuRuins {
    public static void main(String[] args) {
        //Capturando entrada de dados.
        Scanner sc = new Scanner(System.in, "ISO-8859-1");

        while (true) {
            //Armazenando a 1º linha que recebe o Inteiro.
            var inteiro = Integer.parseInt(sc.nextLine());

            //Condição para finalizar o programa.
            if (inteiro == 0) break;

            //Declarando variavel para receber as palavras.
            String frase ="";

            for (int a = 1; a <= inteiro ; a++) {
                //Armazenando as palavras inseridas e concatenando com um espaço.Ex: ABC ABCDEF
                frase += sc.nextLine();
                frase += " ";

                //Essa condição so será satisfeita, quando todas as palavras ja tiver sido capturadas.
                if (a == inteiro) {
                    //Criando uma lista com a String frase.
                    List<String> conjuntos = new ArrayList(Arrays.asList(frase.split(" ")));

                    //Colocando a lista em ordem alfabetica.
                    var conjuntoOrdenado = conjuntos.stream().sorted().collect(Collectors.joining(" "));

                    //Criando uma lista com a String acima em ordem alfabetica.
                    List<String> palavras = new ArrayList<>(Arrays.asList(conjuntoOrdenado.split(" ")));

                    //Variavel controle para condição de "CONJUNTO BOM".
                    int conjuntoBom = 0;

                    //Enquanto a variavel controle for menor que nossa lista, o laço continua.
                    for (int i = 0; i < palavras.size(); i++) {
                        int j = 1;

                        //Se houver somente 1 palavra, paramos o laço.
                        if (palavras.size() == 1) {
                            break;
                        }

                        //Condições para verificar se o inicio de uma palavra possui outra palavra. "O prefixo".
                        if (palavras.get(j) != palavras.get(i)) {

                            if (palavras.get(i).startsWith(palavras.get(j))) {
                                System.out.println("conjunto ruim");
                                conjuntoBom = 1;
                                break;
                            }
                            if (palavras.get(j).startsWith(palavras.get(i))) {
                                System.out.println("conjunto ruim");
                                conjuntoBom = 1;
                                break;
                            }
                        }

                        j++;

                    }
                    //Caso nenhuma condição acima seja satisfeita, o conjunto é bom!
                    if (conjuntoBom == 0) {
                        System.out.println("Conjunto bom");
                    }

                }

            }
        }
    }
}
