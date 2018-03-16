/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.ada.homeworks.session5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author angel_banuelos
 */
public class EclipseProblem {

    /*
     Tal vez no exista como tal el concepto ‘Eclipse planetario’ pero últimamente me he preguntado si me
     tocará vivir la alineación de dos planetas con respecto al sol, en especial, si uno de esos planetas fuera
     la Tierra. Un profesor de Matemáticas me aconsejó investigar la duración del movimiento de
     traslación de dos planetas del Sistema Solar, suponer que ambos planetas están alineados en un
     momento dado, y calcular cuántas vueltas tienen que dar para que crucen el punto de arranque al
     mismo tiempo.
     Después de investigar que 
     Mercurio tarda 88 días en dar la vuelta al Sol, mi profesor me dijo que no
     ve muy probable que nos toque vivir la alineación de Mercurio con la Tierra, ya que tienen que dar
     32,120 días para que se vuelvan a cruzar. ¿Cómo le hizo mi profesor? Si Mercurio tardara 4 días en
     dar la vuelta al Sol y la Tierra 6 días, sería muy fácil para mí darme cuenta que sólo se necesitan 12
     días para que se alineen.
     El problema consiste en determinar cuánto tiempo tiene que pasar para que un par de planetas se
     vuelvan a cruzar en el punto de arranque. Existen planetas, como Júpiter, cuyo tiempo de traslación
     se tiene que medir en horas porque el último día no se completa, lo que implica que los números son
     más grandes.
     
     input: La primera línea contiene un número entero n > 0 que denota el número de casos de prueba. Cada
     una de las n líneas siguientes contienen dos enteros a, b separados por un espacio, que denota el
     tiempo de rotación de dos planetas, dados en la misma unidad de tiempo. Siempre se cumplirá: 1 ≤ a,
     b ≤ 1*10ala10.
    
     Output: La salida consiste en n líneas que contienen cada una un número entero t que denota el tiempo que
     tiene que pasar para que dos planetas con tiempos de rotación a, b se encuentren en el punto de
     arranque; t se indicará en la misma unidad de tiempo que a y b. Suponga que t nunca será mayor que
     2ala63.
    
     */
    public static void main(String[] args) {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String text = bufferRead.readLine().trim();
            int testCases = Integer.parseInt(text);
            int i = 0;
            while (i < testCases) {
                String helper = bufferRead.readLine().trim();
                String numbers[] = helper.split(" ");
                //System.out.println("" + mcm(new BigInteger(numbers[0]), new BigInteger(numbers[1])));
                System.out.println("" + mcm(Long.parseLong(numbers[0]), Long.parseLong(numbers[1])));
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static long gcd(long a, long b) {
        long r;
        if (a < b) {
            long c = b;
            b = a;
            a = c;
        }
        while (b != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private static long mcm(long a, long b) {
        long c = gcd(a, b);
        return (((a / c) * (b / c)) * c);
    }
}
