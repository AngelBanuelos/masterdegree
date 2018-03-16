package masterdegree.mac.automata;

import java.util.Scanner;

/**
 *
 * @author angel_banuelos
 */
public class Exercise {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Text to Validate: ");
        String text = sc.nextLine();
        System.out.println("This Text is correct " + validate(text));
        sc.close();
    }

    public enum States {

        S0,
        S1,
        S2
    }

    private static boolean validate(String text) {
        States state = States.S0;
        boolean correct = false;
        int i = 0;
        while (text.length() > i) {
            char c = text.charAt(i);
            switch (state) {
                case S0:
                    if (Character.isLetter(c)) {
                        state = States.S1;
                    } else {
                        state = States.S2;

                    }
                    break;
                case S1:
                    if (Character.isLetter(c) || Character.isDigit(c)) {
                        state = States.S1;
                    } else {
                        state = States.S2;
                    }
                    break;
                case S2:
                    break;
            }
            i++;
        }

        if (state == States.S1) {
            correct = true;
        }
        return correct;
    }

}
