/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session8;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import masterdegree.ada.sort.utils.Utils;

/**
 *
 * @author angel_banuelos
 */
public class Adn1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt(); //Test Cases.
        while (testCases != 0) {
            TreeSet<AdnString> hashStructure = new TreeSet();
            int adnStrings = sc.nextInt();
            int mod = sc.nextInt();
            while (adnStrings != 0) {
                AdnString adn = new AdnString(sc.next(), mod);
                hashStructure.add(adn);
                adnStrings--;
            }
            int i = 0;
            for (Iterator<AdnString> it = hashStructure.iterator(); it.hasNext();) {
                AdnString adnString = it.next();
                if(i == 5){
                    break;
                }
                System.out.print(adnString + " ");
                i++;
            }
            System.out.println("");
            testCases--;
        }

    }

    static class AdnString implements Comparable<AdnString> {

        String adn;
        int mod;

        public AdnString(String adn, int mod) {
            this.adn = adn.toUpperCase();
            this.mod = mod;
        }

        @Override
        public int hashCode() {
            int hashCode = 0;
            for (int i = 0; i < adn.length(); i++) {
                hashCode += getValue(adn.charAt(i), i);
            }
            return hashCode % mod;
        }

        public long getValue(char c, int at) {
            int value = 0;
            switch (c) {
                case 'A':
                    value = 1;
                    break;
                case 'C':
                    value = 2;
                    break;
                case 'G':
                    value = 3;
                    break;
                case 'T':
                    value = 4;
                    break;
            }
            return (value % mod) * (Utils.pow(4, at) % mod);
        }

        @Override
        public String toString() {
            return adn;
        }

        @Override
        public int compareTo(AdnString o) {
            if (o.hashCode() < this.hashCode()) {
                return 1;
            } else if (o.hashCode() > this.hashCode()) {
                return -1;
            } else {
                return this.adn.compareTo(o.adn);
            }
        }
    }
}
