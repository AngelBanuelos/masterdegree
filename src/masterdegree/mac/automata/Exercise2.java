/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.mac.automata;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author angel_banuelos
 */
public class Exercise2 {

    private static State state;

    private static enum State {

        s0, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        System.out.println("Insert a Date ");
        String text = sc.next();
        boolean isValid = validateDate(text);
        if (isValid) {
            System.out.println("Date: " + text + " is a valid date");
        } else {
            System.err.println("Date: " + text + " is an invalid date");
        }
    }

    private static boolean validateDate(String text) {
        boolean valid = false;
        int n = text.length();
        state = State.s0;
        int i = 0;
        while (n > i) {
            char chr = text.charAt(i);
            switch (state) {
                case s0:
                    if (Character.isDigit(chr)) {
                        if (chr == '0') {
                            state = State.s1;
                        } else if (chr == '1') {
                            state = State.s11;
                        }
                    } else {
                        i = n;
                    }
                    break;
                case s1://First mount 
                    if (Character.isDigit(chr)) {
                        if (chr == '2') { //Mounth with 28 days
                            state = State.s13;
                        } else if (chr == '1' || chr == '3' || chr == '5' || chr == '7' || chr == '8') { //mounts with 31 days
                            state = State.s2;
                        } else if (chr != '0') { //mounts with 30 days
                            state = State.s12;
                        }
                    }
                    break;
                case s2:
                    if (chr == '/' || chr == '-' || chr == '.') {
                        state = State.s3;
                    }
                    break;
                case s3:
                    if (Character.isDigit(chr)) {
                        if (chr >= '0' && chr <= '2') {
                            state = State.s4;
                        } else if (chr == '3') {
                            state = State.s16;//0-1
                        }
                    }
                    break;
                case s4:
                    if (Character.isDigit(chr)) {
                        if (chr >= '1' && chr <= '9') {
                            state = State.s5;
                        }
                    }
                    break;
                case s5:
                    if (chr == '/' || chr == '-' || chr == '.') {
                        state = State.s6;
                    }
                    break;
                case s6:
                    if (Character.isDigit(chr)) {
                        if (chr >= '2') {
                            state = State.s7;
                        }
                    }
                    break;
                case s7:
                    if (Character.isDigit(chr)) {
                        state = State.s8;
                    }
                    break;
                case s8:
                    if (Character.isDigit(chr)) {
                        if (chr >= '1') {
                            state = State.s9;
                        }
                    }
                    break;
                case s9:
                    if (Character.isDigit(chr)) {
                        state = State.s10;
                    }
                    break;
                case s10:
                    if (!Character.isDigit(chr)) {
                        state = State.s0;
                    }
                    break;
                case s11:// mounths start with 1s
                    if (Character.isDigit(chr)) {
                        if (chr == '1') {
                            state = State.s12;
                        } else {
                            state = State.s3;
                        }
                    }
                    break;
                case s12:
                    if (chr == '/' || chr == '-' || chr == '.') {
                        state = State.s17;
                    }
                    break;
                case s13://february
                    if (chr == '/' || chr == '-' || chr == '.') {
                        state = State.s14;
                    }
                    break;
                case s14:
                    if (Character.isDigit(chr)) {
                        if (chr >= '0' && chr >= '2') {
                            state = State.s15;
                        }
                    }
                    break;
                case s15:
                    if (Character.isDigit(chr)) {
                        if (chr >= '0' && chr <= '8') {
                            state = State.s5;
                        }
                    }
                    break;
                case s16:// mounth with 31 days
                    if (Character.isDigit(chr)) {
                        if (chr >= '0' && chr <= '1') {
                            state = State.s5;
                        }
                        break;
                    }
                case s17:// mounth with 30 days
                    if (Character.isDigit(chr)) {
                        if (chr >= '0' && chr <= '2') {
                            state = State.s4;
                        } else if (chr == '3') {
                            state = State.s18;//0-1
                        }
                    }
                    break;
                case s18:// mounth with 30 days
                    if (Character.isDigit(chr)) {
                        if (chr == '0') {
                            state = State.s5;
                        }
                        break;
                    }
            }
            i++;
        }
        if (state == State.s10) {
            valid = true;
        }
        return valid;
    }
}
