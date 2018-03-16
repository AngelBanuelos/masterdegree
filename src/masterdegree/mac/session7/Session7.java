/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masterdegree.mac.session7;

import masterdegree.ada.tree.HuffmanTree;
import masterdegree.ada.tree.graphic.GraphicTreeBuilder;

/**
 *
 * @author Angel.Sahagun
 */
public class Session7 {

    public static void main(String[] args) {
        Thread start = new Thread(new Runnable() {

            @Override
            public void run() {
                new HuffmanUI();
            }
        });
        start.run();
    }

}
