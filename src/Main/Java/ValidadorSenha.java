package Main.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidadorSenha {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String senha;

        //Capturando a entrada de dados
        while ((senha = br.readLine()) != null) {

            //Verificando a quantidade de caracteres.
            boolean isCorrectLength = senha.length() >= 6 && senha.length() <= 32;

            //Criação de variaveis para verificar a existencia de numeros, letras maiusculas e minusculas.
            boolean containsNumber = false;
            boolean containsUpperCase = false;
            boolean containsLowerCase = false;

            //Verificando se há espaços.
            boolean containsSpace = senha.contains(" ");

            //Criando e inicializando variaveis, para verificar caracteres especiais.
            String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,32}";
            String pattern2 = "(?=.*\\p{Punct}).{1,}";


            for (int i = 0; i < senha.length(); i++) {

                //Verificando se há numeros
                if (Character.isDigit(senha.charAt(i))) {
                    containsNumber = true;
                }

                //Verificando letras maiuscula
                else if (Character.isUpperCase(senha.charAt(i))) {
                    containsUpperCase = true;
                }

                // Verificando letra minusculas
                else if (Character.isLowerCase(senha.charAt(i))) {
                    containsLowerCase = true;
                }
            }

            //1º condição para confirmar a verificação do tamanho, espaço, numeros, letras maiusculas e minusculas.
            if (isCorrectLength && !containsSpace && containsNumber && containsUpperCase && containsLowerCase) {

                //2º condição para verificar Caracteres Especiais.
                if (senha.matches(pattern) == true && senha.matches(pattern2) == false) {
                    System.out.println(" Senha valida. ");
                } else {
                    System.out.println(" Senha invalida.");
                }
            } else {
                System.out.println(" Senha invalida.");
            }
        }
    }
}

