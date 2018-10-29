package cerchiothread;

import java.awt.*;
import java.util.*;
import javax.swing.*;

//classe concreta deriva da JPanel implementa Runnable
public class Cerchio extends JPanel implements Runnable {
//    variabili e costanti globali

//    costanti statiche int larghezza e altezza pannello
    public final static int PANEL_WIDTH = 500;
    public final static int PANEL_HEIGHT = 400;
//    costante staica int misura ovale
    public final static int OVAL_SIZE = 30;

//    varibili int coordinate e spostamento
    int x = 0, y = 0, dx = 2, dy = 2;
//    variabile random
    Random ran = new Random();
//    oggetto Thread che crea un oggetto Cerchio
    Thread animator;

//    GETTERS
    public Thread getThread() {
        return animator;
    }

//    costruttore di dafult
    public Cerchio() {
//        setto colore sfondo pannello
        setBackground(Color.GRAY);
//        setto dimensioni
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
//        mette un numero random in x e y
        x = ran.nextInt(PANEL_WIDTH - OVAL_SIZE);
        y = ran.nextInt(PANEL_HEIGHT - OVAL_SIZE);
//        inizializza animator come new Thread
        animator = new Thread(this);
    }

    /**
     * override metodo paintComonent di JPanel
     *
     * @param g componente grafica
     */
    @Override
    public void paintComponent(Graphics g) {
//        chiamo costruttore metodo già esistente
        super.paintComponent(g);

//        setto colore oggetto
        g.setColor(Color.DARK_GRAY);
//        creo l'ovale
        g.fillOval(x, y, OVAL_SIZE, OVAL_SIZE);
//        chiamo metodo cycle
    }

//    metodo cycle
    private void cycle() {
//        controllo se le palline sono arrivate ai bordi
//        cambio direzione
        if (x + dx < 0 || x + dx > PANEL_WIDTH - OVAL_SIZE - 13) {
            dx = -dx;
        }
        if (y + dy < 0 || y + dy > PANEL_HEIGHT - OVAL_SIZE - 40) {
            dy = -dy;
        }

//        incrementiamo x e y del valore di dx e dy
        x += dx;
        y += dy;
//        ridisegno il cerchio
        repaint();
    }

//    implementazione metodo run di Runnable
    @Override
    public void run() {
//        chiamo il metodo cycle finchè è vero (sempre)
        while (true) {
            cycle();
//            rallento il cerchio
//            ci vuole Try Catch
            try {
                Thread.currentThread().sleep(30);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }

}
