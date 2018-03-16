/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.mac.session7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.BitSet;
import masterdegree.ada.tree.HuffmanTree;
import static masterdegree.ada.tree.graphic.GraphicTreeBuilder.DEFAULTDIRECTORY;

/**
 *
 * @author Angel.Sahagun
 */
public class HuffmanCodeBits {

    private HuffmanTree tree;
    private ArrayList<BitSet> code;

    public HuffmanCodeBits(HuffmanTree tree) {
        this.tree = tree;
    }

    /**
     *
     * @param saveTo Directorio donde se guardara el texto codificado
     * @param fileName Nombre deseado para el archivo.
     * @throws IOException
     */
    public void saveCodeToFile(String saveTo, String fileName) throws IOException {
        fileName = fileName + ".txt";
        ObjectOutputStream s;
        FileOutputStream object;
        try {
            File dir = new File(DEFAULTDIRECTORY);
            if (!dir.exists()) {
                dir.mkdir();
            }
            object = new FileOutputStream(dir.getAbsolutePath()
                    + File.separator + fileName);
            s = new ObjectOutputStream(object);
            s.writeObject(code);
            s.close();
        } catch (IOException ioe) {
            System.err.println("Error, " + ioe);
        } catch (Exception e) {
            System.err.println("Error, Call to Developer  " + e);
        } finally {
        }
    }

    public void code(String message) throws Exception {
        if (tree == null) {// Si no hay arbol pide que sea creado.
            throw new Exception("Create the tree");
        }
        code = new ArrayList();
        BitSet temp = null;
        for (int i = 0; i < message.length(); i++) {
            temp = tree.getHuffmanCodeTableBits().get(message.charAt(i) + "");
            if (temp != null) {// busca la letra equivalente para generar codigo.
                code.add(temp);
            } else {// Si la letra no existe en el arbol indica cual fue.
                throw new RuntimeException("Dictionary not enough impossible to code. Missing " + message.charAt(i));
            }
        }
    }

}
