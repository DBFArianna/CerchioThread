package cerchiothread;

import java.awt.*;
import javax.swing.*;

/**
 * classe concreta
 *
 * @extends JFrame
 */
public class Finestra extends JFrame {
//    variabili e costanti globali

//    costanti statiche in larghezza e altezza Frame
    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGTH = 400;

//    costruttore di default
    public Finestra() {
//        setta titolo frame
        setTitle("Al momento un cerchietto");
//        setta cosa fare alla chiusura
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setta dimensioni
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGTH));
//        setta layout
        setLayout(new GridLayout(2, 2, 3, 3));
        /*faccio partire processi in parallelo
          in questo caso non serve il join
          perchè sono in conflitto solo per la CPU*/
//         crea oggetti cerchio
        Cerchio c1 = new Cerchio();
        Cerchio c2 = new Cerchio();
        Cerchio c3 = new Cerchio();
        Cerchio c4 = new Cerchio();

//        fa partire il Thread
        c1.getThread().start();
        c2.getThread().start();
        c3.getThread().start();
        c4.getThread().start();

//        aggiunge cerchi al Frame
        add(c1);
        add(c2);
        add(c3);
        add(c4);

//        aggiunge le componenti grafiche
        pack();
//        setta visibilità a true
        setVisible(true);
    }

}
