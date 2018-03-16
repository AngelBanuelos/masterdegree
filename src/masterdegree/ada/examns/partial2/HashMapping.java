/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.examns.partial2;

/**
 *
 * @author Angel.Sahagun
 */
public class HashMapping {

    static class Alphabet {

        char Character;
        int value;

        public Alphabet(char Character, int value) {
            this.Character = Character;
            this.value = value;
        }

    }
    final static int MAX_SERVICES = 500;
    final static int ELEMENTS = 9;

    static int getValue(char c) {
        for (int i = 0; i < ELEMENTS; i++) {
            if (alphabet[i].Character == c) {
                return alphabet[i].value;
            }
        }
        return - 1;
    }

    static int hashCode(String clave) {
        int hashCode = getValue(clave.charAt(0));
        for (int i = 1; i < clave.length(); i++) {
            hashCode = ((hashCode * ELEMENTS) + getValue(clave.charAt(i)));
        }
        return hashCode % MAX_SERVICES;
    }

    public static void main(String[] args) {
        String clave = "#f6@δ";
        System.out.println("HashCode clave '" + clave + "' = " + hashCode(clave));
    }

    static Alphabet[] alphabet = new Alphabet[ELEMENTS];

    static {
        alphabet[0] = new Alphabet('6', 0);
        alphabet[1] = new Alphabet('#', 1);
        alphabet[2] = new Alphabet('A', 2);
        alphabet[3] = new Alphabet('', 3);
        alphabet[4] = new Alphabet('f', 4);
        alphabet[5] = new Alphabet('@', 5);
        alphabet[6] = new Alphabet('3', 6);
        alphabet[7] = new Alphabet('©', 7);
        alphabet[8] = new Alphabet('δ', 8);
    }
}
