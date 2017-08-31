package project;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NQueen extends JPanel implements ActionListener {

    JButton pos[][] = new JButton[30][30];
    int arr[][] = new int[30][30];
    int allPlace = 0, queen = 0, n = 1;
    Queen q;

    public NQueen(Queen q) {
        this.q = q;
    }

    public NQueen(int n, boolean sol, Queen q) {
        this.q = q;
        this.n = n;
        if (n != 0) {
            setLayout(new GridLayout(n, n));
            if (sol) {
                queenPlace(0, n);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    pos[i][j] = (JButton) add(new JButton());
                    if (!sol) {
                        pos[i][j].addActionListener(this);
                    }

                    if (i % 2 == 0 && j % 2 == 0) {
                        pos[i][j].setBackground(Color.gray);
                    }
                    if (i % 2 == 0 && j % 2 != 0) {
                        pos[i][j].setBackground(Color.white);
                    }
                    if (i % 2 != 0 && j % 2 == 0) {
                        pos[i][j].setBackground(Color.white);
                    }
                    if (i % 2 != 0 && j % 2 != 0) {
                        pos[i][j].setBackground(Color.gray);
                    }
                    if (sol) {
                        System.out.println("Yes " + sol);
                        if (arr[i][j] == 1) {
                            /*
                            ImageIcon imgicn= new ImageIcon("chess.jpg");
                            Image img=imgicn.getImage();
                            int h=pos[i][j].getHeight();
                            int w=pos[i][j].getWidth();
                            
                            Image nwimg=img.getScaledInstance(w, h,Image.SCALE_SMOOTH);
                            imgicn= new ImageIcon(nwimg);
                            pos[i][j].setIcon(imgicn);
                             */
                            pos[i][j].setIcon(new ImageIcon("chess.jpg"));
                        }
                    }

                }
            }
        }

    }

    public void actionPerformed(ActionEvent ae) {
        System.out.println("Hello, ");
        for (int i = 0; i < n; i++) {
            System.out.println("Row " + i);
            for (int j = 0; j < n; j++) {
                System.out.println("Col " + j);
                if (ae.getSource() == pos[i][j]) {
                    System.out.println("Row Row Row " + j);
                    if (arr[i][j] != 1) {
                        System.out.println("Col Col Col " + j);
                        /*
                        ImageIcon imgicn= new ImageIcon("chess.jpg");
                            Image img=imgicn.getImage();
                            int h=pos[i][j].getHeight();
                            int w=pos[i][j].getWidth();
                            
                            Image nwimg=img.getScaledInstance(w, h,Image.SCALE_SMOOTH);
                            imgicn= new ImageIcon(nwimg);
                            pos[i][j].setIcon(imgicn);
                         */
                        pos[i][j].setIcon(new ImageIcon("chess.jpg"));

                        setarr(i, j);
                        queen++;
                        if (queen == n) {
                            JOptionPane.showMessageDialog(null, "Congratulation, You Won", "WINNER", JOptionPane.INFORMATION_MESSAGE);//destroy();

                            q.solution = false;
                            q.ncall(this.n);
                            q.dispose();
                            break;
                        }
                        int dead = 1;
                        for (int k = 0; k < n; k++) {
                            for (int l = 0; l < n; l++) {
                                if (arr[k][l] == 0) {
                                    dead = 0;
                                }
                            }
                        }
                        if (dead == 1) {
                            JOptionPane.showMessageDialog(null, "You can't place more Queen", "LOOSE", JOptionPane.WARNING_MESSAGE);

                            q.solution = false;
                            q.ncall(this.n);
                            q.dispose();
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "You can't place queen here", "WARNING", JOptionPane.WARNING_MESSAGE);

                    }
                }
            }
        }
    }

    public void setarr(int x, int y) {
        int a, b;
        for (a = 0; a < n; a++) {
            arr[a][y] = 1;
        }
        for (b = 0; b < n; b++) {
            arr[x][b] = 1;
        }
        for (a = x, b = y; (a < n && b >= 0); a++, b--) {
            arr[a][b] = 1;
        }
        for (a = x, b = y; (a >= 0 && b < n); a--, b++) {
            arr[a][b] = 1;
        }
        for (a = x, b = y; (a >= 0 && b >= 0); a--, b--) {
            arr[a][b] = 1;
        }
        for (a = x, b = y; (a < n && b < n); a++, b++) {
            arr[a][b] = 1;
        }
    }

    public void queenPlace(int r, int n) {
        System.out.println("Queen place");

        for (int i = 0; i < n; i++) {
            if (allPlace == 0) {
                int tmp = 0, a, b;

                for (b = 0; b < n; b++) {
                    arr[r][b] = 0;
                }
                for (a = 0; a < n; a++) {
                    if (arr[a][i] == 1) {
                        tmp = 1;
                    }
                }
                if (tmp == 0) {
                    for (a = r, b = i; (a < n && b >= 0); a++, b--) {
                        if (arr[a][b] == 1) {
                            tmp = 1;
                        }
                    }
                }
                if (tmp == 0) {
                    for (a = r, b = i; (a >= 0 && b < n); a--, b++) {
                        if (arr[a][b] == 1) {
                            tmp = 1;
                        }
                    }
                }
                if (tmp == 0) {
                    for (a = r, b = i; (a >= 0 && b >= 0); a--, b--) {
                        if (arr[a][b] == 1) {
                            tmp = 1;
                        }
                    }
                }
                if (tmp == 0) {
                    for (a = r, b = i; (a < n && b < n); a++, b++) {
                        if (arr[a][b] == 1) {
                            tmp = 1;
                        }
                    }
                }

                if (tmp == 0) {
                    arr[r][i] = 1;
                    if (r == n - 1) {
                        allPlace = 1;
                    } else {
                        queenPlace(r + 1, n);
                    }
                }
            }
        }
    }

}
