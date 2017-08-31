package project;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class Queen extends JFrame {

    private final Container mainContainer;
    private final NQueen nq;
    private final ButtonPanel bp;
    protected static boolean solution;

    Queen(int n) {

        super("NQUEEN");
        System.out.println("Solution " + solution);
        if (solution) {
            nq = new NQueen(n, true, this);
        } else {
            nq = new NQueen(n, false, this);
        }
        bp = new ButtonPanel(this);
        setSize(500, 545);
        mainContainer = getContentPane();
        mainContainer.add(nq, BorderLayout.CENTER);
        mainContainer.add(bp, BorderLayout.SOUTH);
        this.setResizable(false);
    }

    public static void main(String arg[]) {
        ncall(0);
    }

    public static void ncall(int n) {
        System.out.println("Call " + solution);
        Queen q = new Queen(n);
        q.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        q.show();
    }
       // Image's link
    //https://upload.wikimedia.org/wikipedia/commons/4/47/Chess_qdt45.svg
}
