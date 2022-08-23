import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VierGewinnt implements ActionListener {

    private JLabel[][] labels = new JLabel[6][7];
    private int[][] spielfeld = new int[6][7];
    private int[] kleinst = new int[7];

    private int spieler = 0;
    private int sieger = 0;

    private JFrame frame = new JFrame();
    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JButton button4 = new JButton();
    private JButton button5 = new JButton();
    private JButton button6 = new JButton();
    private JButton button7 = new JButton();
    JPanel panel = new JPanel();

    public VierGewinnt() {
        button1.addActionListener(this::actionPerformed1);
        button2.addActionListener(this::actionPerformed2);
        button3.addActionListener(this::actionPerformed3);
        button4.addActionListener(this::actionPerformed4);
        button5.addActionListener(this::actionPerformed5);
        button6.addActionListener(this::actionPerformed6);
        button7.addActionListener(this::actionPerformed7);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(7, 7));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);

        for (int i = 5; i >= 0; i--) {
            for (int j = 0; j < 7; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setBorder(BorderFactory.createLineBorder(Color.black, 2));
                labels[i][j].setOpaque(true);
                panel.add(labels[i][j]);

            }
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("VierGewinnt");
        frame.pack();
        frame.setMinimumSize(new Dimension(1100, 700));
        frame.setVisible(true);

    }

    public void actionPerformed1(ActionEvent e) {
        buttonPressedAuswertung(0);
    }

    public void actionPerformed2(ActionEvent e) {
        buttonPressedAuswertung(1);
    }

    public void actionPerformed3(ActionEvent e) {
        buttonPressedAuswertung(2);
    }

    public void actionPerformed4(ActionEvent e) {
        buttonPressedAuswertung(3);
    }

    public void actionPerformed5(ActionEvent e) {
        buttonPressedAuswertung(4);
    }

    public void actionPerformed6(ActionEvent e) {
        buttonPressedAuswertung(5);
    }

    public void actionPerformed7(ActionEvent e) {
        buttonPressedAuswertung(6);
    }

    public void buttonPressedAuswertung(int position) {
        if (kleinst[position] < 6) {
            if (spieler % 2 == 0) {
                labels[kleinst[position]][position].setBackground(Color.red);
                spielfeld[kleinst[position]][position] = 1;
            } else {
                labels[kleinst[position]][position].setBackground(Color.yellow);
                spielfeld[kleinst[position]][position] = 2;
            }
            kleinst[position]++;
            spieler++;
        }

        siegerErmitteln();

    }

    public void siegerErmitteln() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (spielfeld[i][j] == spielfeld[i][j + 1] && spielfeld[i][j] == spielfeld[i][j + 2] && spielfeld[i][j] == spielfeld[i][j + 3] && spielfeld[i][j] != 0) {
                    sieger = spielfeld[i][j];
                }
            }

        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 2; j++) {
                if (spielfeld[j][i] == spielfeld[j + 1][i] && spielfeld[j][i] == spielfeld[j + 2][i] && spielfeld[j][i] == spielfeld[j + 3][i] && spielfeld[j][i] != 0) {
                    sieger = spielfeld[j][i];
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (spielfeld[i][j] == spielfeld[i + 1][j + 1] && spielfeld[i][j] == spielfeld[i + 2][j + 2] && spielfeld[i][j] == spielfeld[i + 3][j + 3] && spielfeld[i][j] != 0) {
                    sieger = spielfeld[i][j];
                }
            }
        }
        for (int i = 5; i > 2; i--) {
            for (int j = 0; j < 4; j++) {
                if (spielfeld[i][j] == spielfeld[i - 1][j + 1] && spielfeld[i][j] == spielfeld[i - 2][j + 2] && spielfeld[i][j] == spielfeld[i - 3][j + 3] && spielfeld[i][j] != 0) {
                    sieger = spielfeld[i][j];
                }
            }
        }

        if (sieger != 0){
            sieger(sieger);
        }

    }


    public static void main(String[] args) {
        new VierGewinnt();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }


    private void sieger(int sieger) {
        JPanel panel2 = new JPanel();
        JFrame frame2 = new JFrame();
        JLabel label2 = new JLabel("Spieler " + sieger + " ist Sieger");
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.setLayout(new GridLayout(1, 1));
        panel2.add(label2);
        frame2.add(panel2, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setTitle("Sieger");
        frame2.pack();
        frame2.setMinimumSize(new Dimension(300, 300));
        frame2.setVisible(true);
    }


}