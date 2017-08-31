package project;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel {

    private final JButton solBtn;
    private final JButton playBtn;
    private final JButton exitBtn;
    private final JLabel no;
    private final JTextField tf;
    Queen q;

    ButtonPanel(Queen q) {
        this.q = q;
        solBtn = new JButton("SOLUTION");
        playBtn = new JButton("PLAY");
        exitBtn = new JButton("EXIT");
        tf = new JTextField(2);
        no = new JLabel("    No. of queen = ");
        setLayout(new GridLayout(1, 5));
        add(no);
        add(tf);
        add(solBtn);
        add(playBtn);
        add(exitBtn);

        solBtn.addActionListener(new mybuttonlistener());
        playBtn.addActionListener(new mybuttonlistener());
        exitBtn.addActionListener(new mybuttonlistener());

    }

    class mybuttonlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == solBtn) {
                System.out.println("Performed");
                String str1 = tf.getText();
                int int1 = Integer.parseInt(str1);
                q.solution = true;
                q.ncall(int1);
                q.dispose();
            } else if (e.getSource() == playBtn) {
                String str1 = tf.getText();
                int int1 = Integer.parseInt(str1);
                q.solution = false;
                q.ncall(int1);
                q.dispose();
            } else if (e.getSource() == exitBtn) {
                System.exit(0);
            }

        }

    }

}
