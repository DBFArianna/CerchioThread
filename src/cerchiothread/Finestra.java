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
        setLayout(new GridLayout(1, 1, 3, 3));
//        crea oggetto cerchio
        Cerchio c = new Cerchio();
//        faccio partire il Thread
        c.getThread().start();
//        aggiunge cerchio al Frame
        add(c);
//        aggiunge le componenti grafiche
        pack();
//        setta visibilità a true
        setVisible(true);
    }

}
