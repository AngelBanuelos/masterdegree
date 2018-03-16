package masterdegree.ada.homeworks.session8;

import java.util.Scanner;

public class Adn2 {

    static class Nodo {

        private String valor;
        private Nodo childA;
        private Nodo childC;
        private Nodo childG;
        private Nodo childT;

        public Nodo(String valor) {
            this.valor = valor;
            this.childA = null;
            this.childC = null;
            this.childG = null;
            this.childT = null;

        }

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }

        public Nodo getChildA() {
            return childA;
        }

        public void setChildA(Nodo childA) {
            this.childA = childA;
        }

        public Nodo getChildC() {
            return childC;
        }

        public void setChildC(Nodo childC) {
            this.childC = childC;
        }

        public Nodo getChildG() {
            return childG;
        }

        public void setChildG(Nodo childG) {
            this.childG = childG;
        }

        public Nodo getChildT() {
            return childT;
        }

        public void setChildT(Nodo childT) {
            this.childT = childT;
        }

        public Nodo() {
        }
    }

    public static Nodo crearArbol(String[] secuencias, int L, int N) {
        Nodo raiz = new Nodo(""); //hace el primer elemento del arbol vacio como en el ejemplo
        for (int i = 0; i < N; i++) { //recorre el numero de secuencias
            int posicion = -1;
            raiz = insertar(raiz, posicion, secuencias[i]);
        }
        return raiz;
    }

    public static char devolverCaracter(String cadena, int posicion) {
        //devuelve el caracter
        char c = cadena.charAt(posicion);
        return c;
    }

    public static int buscaNodoComparaciones(Nodo nodo, String valor, int posicion, int comparaciones) {
        //caso base=arbol vacio
        //en dicho caso, el objetivo no se encuentra y regresa falso
        if (nodo == null) {
            comparaciones--;
        } else {
            //verifica si lo encuentra aqui
            if (valor.equals(nodo.getValor())) {

            } else {
                //recorre el arbol
                comparaciones++;
                char c = devolverCaracter(valor, posicion + 1);
                if (c == 'A' || c == 'a') {
                    comparaciones = buscaNodoComparaciones(nodo.getChildA(), valor, posicion + 1, comparaciones);
                } else if (c == 'C' || c == 'c') {
                    comparaciones = buscaNodoComparaciones(nodo.getChildC(), valor, posicion + 1, comparaciones);
                } else if (c == 'G' || c == 'g') {
                    comparaciones = buscaNodoComparaciones(nodo.getChildG(), valor, posicion + 1, comparaciones);
                } else if (c == 'T' || c == 't') {
                    comparaciones = buscaNodoComparaciones(nodo.getChildT(), valor, posicion + 1, comparaciones);
                }
            }
        }
        return comparaciones;
    }

    public static Nodo insertar(Nodo nodo, int posicion, String cadena) {
        //si el arbol esta vacio, regresa un nuevo nodo
        if (nodo == null) {
            return nuevoNodo(cadena);
        } else {//recorre el arbol
            char c = devolverCaracter(cadena, posicion + 1);
            if (c == 'A' || c == 'a') {  //verificar si van a llegar minusculas
                nodo.setChildA(insertar(nodo.getChildA(), posicion + 1, cadena));
            } else if (c == 'C' || c == 'c') {
                nodo.setChildC(insertar(nodo.getChildC(), posicion + 1, cadena));
            } else if (c == 'G' || c == 'g') {
                nodo.setChildG(insertar(nodo.getChildG(), posicion + 1, cadena));
            } else if (c == 'T' || c == 't') {
                nodo.setChildT(insertar(nodo.getChildT(), posicion + 1, cadena));
            }
        }

        return nodo;
    }

    public static Nodo nuevoNodo(String valor) {
        Nodo nodo = new Nodo(valor);
        return nodo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int C = sc.nextInt(); //numero de casos de prueba
        String[] resultados = new String[C];
        for (int cp = 0; cp < C; cp++) {
            int[] datos_secuencias = new int[2];
            for (int z = 0; z < datos_secuencias.length; z++) {
                datos_secuencias[z] = sc.nextInt(); //captura L y N   
            }
            int L = datos_secuencias[0];  //L=longitud de las secuencias
            int N = datos_secuencias[1];  //N=numero de secuencias
            String secuencias[] = new String[N]; //arreglo de secuencias
            for (int i = 0; i < N; i++) //captura las secuencias 
            {
                secuencias[i] = sc.next();
            }
            int B = sc.nextInt(); //numero de busquedas
            String busquedas[] = new String[B]; //arreglo de secuencias a buscar
            for (int i = 0; i < B; i++) //captura las secuencias a buscar
            {
                busquedas[i] = sc.next();
            }

            Nodo arbol = crearArbol(secuencias, L, N);
            StringBuffer cadena_comparaciones = new StringBuffer();

            int[] array_comparaciones = new int[B];
            for (int w = 0; w < array_comparaciones.length; w++) {
                cadena_comparaciones = cadena_comparaciones.append(buscaNodoComparaciones(arbol, busquedas[w], -1, 0));
                cadena_comparaciones = cadena_comparaciones.append(" ");
            }
            resultados[cp] = cadena_comparaciones.toString();
        }

        //imprime resultados
        for (int r = 0; r < resultados.length; r++) {
            System.out.println(resultados[r]);
        }
    }
}
