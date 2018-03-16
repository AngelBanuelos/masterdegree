package masterdegree.mac.exams;

/**
 *
 * @author Angel.Sahagun
 */
public class ByteToBinaryConverter {

    private int byteNumber;
    private String formula = "";
    private int elements;
    private final int BITSONBYTES = 8;

    public ByteToBinaryConverter(int byteNumber) {
        this.byteNumber = byteNumber;
    }

    // Metodo convert calcula el numero total de elementos y la formula para calcularlos.
    public void convert() {
        int bits = 1 << BITSONBYTES * byteNumber;
        elements = (int) bits;
        for (int i = 0; i < (BITSONBYTES * byteNumber); i++) {
            formula += "2*";
        }
        formula = formula.substring(0, formula.length() - 1);
    }

    //Metodo que calcula el numero decimal a entero de todos los elementos del byte. 
    public void print() {
        for (int i = 0; i < elements; i++) {
            int binary = i;
            StringBuilder binaryNumber = new StringBuilder();
            for (int j = 0; j < byteNumber; j++) {
                binaryNumber.append("00000000");
            }
            int j = binaryNumber.length()-1;
            // Para calcular el numero binario por cada elemento de bits
            while (binary > 0) {
                int module = binary % 2;
                binary /= 2;
                if (module == 0) {
                    binaryNumber.setCharAt(j, '0');
                } else {
                    binaryNumber.setCharAt(j, '1');
                }
                j--;
            }
            System.out.println(binaryNumber);
        }
    }

    public int getElements() {
        return elements;
    }

    @Override
    public String toString() {
        return "ByteToBinaryConverter{" + "byteNumber=" + byteNumber + ", formula=" + formula + ", elements=" + elements + '}';
    }
    
    

}
