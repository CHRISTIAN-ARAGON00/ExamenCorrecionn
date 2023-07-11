package Utilitario;

import java.util.Scanner;

public class Utility {

    

    static Scanner sc = new Scanner(System.in);
    

    /**
     * Obtener un numero mayor o igual a 0
     * @param mensaje
     * @return Un numero mayor o igual a 0
     */

    public static int caObtenerUnNumeroPositivo(String mensaje) {
        int numero = 0;
        boolean numeroValido = false;

        System.out.print(mensaje);
        String entrada = sc.nextLine();
        while (!numeroValido) {
            try {
                numero = Integer.parseInt(entrada);
                if (numero >= 0 && numero <5 ) {
                    numeroValido = true;
                } else {
                    System.out.print("El número ingresado no es valido, Ingresa otro número: ");
                   
                    entrada = sc.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.print("El valor ingresado no es un número , Intentalo otra vez: ");
                
                entrada = sc.nextLine();
            }
        }

        return numero;
    }


    /**
     * limpia la terminal
     */
    public static final void clearTerminal() {
        try {
            String operatingSystem = System.getProperty("os.name");

            if (operatingSystem.contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
  
    /**
     * invierte la frase con letras en mayúsculas y vocales en minúsculas
     * @param frase cadena ingresada
     * @return la frase
     */
    public static String convertirAMayusculas(String frase) {
        StringBuilder builder = new StringBuilder();

        for (char c : frase.toCharArray()) {
            if (Character.isLetter(c)) {
                
                    builder.append(Character.toUpperCase(c));
                }
             else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
    
}
