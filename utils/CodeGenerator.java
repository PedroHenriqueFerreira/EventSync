package utils;

import java.security.SecureRandom;
import java.util.Random;

/*
 * Classe utilitária para gerar códigos aleatórios
 */
public class CodeGenerator {
    /*
     * Atributos da classe
     * - CHARACTERS: caracteres que podem ser usados para gerar o código
     * - CODE_LENGTH: tamanho do código
     */
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 8;

    /*
     * Método para gerar um código aleatório
     */ 
    public static String generate() {
        /*
         * O código é gerado da seguinte forma:
         * - Um StringBuilder é criado com o tamanho do código
         * - Um objeto Random é criado
         * - Um loop é executado CODE_LENGTH vezes
         * - A cada iteração, um caractere aleatório é escolhido
         * - O caractere é adicionado ao StringBuilder
         * - Ao final do loop, o código é retornado
         */
        StringBuilder sb = new StringBuilder(CODE_LENGTH);
        Random random = new SecureRandom();
    
        for (int i = 0; i < CODE_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }
    
        return sb.toString();
    }
}
