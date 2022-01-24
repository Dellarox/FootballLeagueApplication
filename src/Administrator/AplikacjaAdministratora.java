package Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikacjaAdministratora {

    private static JFrame frame;
    private static CardLayout layout = new CardLayout();
    private JPanel glownyPanel;
    private JButton utwórzKontoSędziegoButton;
    private JButton zmieńSkładyDrużynButton;
    private JPanel panelStartowy;
    private JPanel panelTworzeniaKontaSedziego;
    private JTextField imięTextField;
    private JTextField nazwiskoTextField;
    private JTextField dataUrodzeniaTextField;
    private JTextField narodowoscTextField;
    private JButton wróćDoPaneluAdministratoraButton;
    private JButton utwórzOsobęButton;
    private JPanel panelZmianySkladow;
    private JTable table1;
    private JButton zapiszZmianyButton;
    private JButton usuńZawodnikaButton;
    private JButton dodajZawodnikaButton;
    private JButton wrócDoPaneluAdministratoraButton;
    private JLabel nazwiskoLabel;
    private JLabel dataUrodzeniaLabel;
    private JLabel narodowośćLabel;
    private JLabel imięLabel;
    private JTextField rokStartuKarieryTextField;
    private JTextField debiutLigowyTextField;
    private JTextField pinTextField;
    private JButton dodajSędziegoButton;
    private JLabel rokStartuKarieryLabel;
    private JLabel debiutLigowyLabel;
    private JLabel pinLabel;

    public AplikacjaAdministratora() {
        utwórzKontoSędziegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanel);
                frame.setSize(800,500);
                rokStartuKarieryLabel.setVisible(false);
                debiutLigowyLabel.setVisible(false);
                pinLabel.setVisible(false);
                rokStartuKarieryTextField.setVisible(false);
                debiutLigowyTextField.setVisible(false);
                pinTextField.setVisible(false);
                dodajSędziegoButton.setVisible(false);
            }
        });
        wróćDoPaneluAdministratoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.previous(glownyPanel);
                imięTextField.setText("");
                nazwiskoTextField.setText("");
                dataUrodzeniaTextField.setText("");
                narodowoscTextField.setText("");

                rokStartuKarieryLabel.setVisible(false);
                debiutLigowyLabel.setVisible(false);
                pinLabel.setVisible(false);
                rokStartuKarieryTextField.setVisible(false);
                debiutLigowyTextField.setVisible(false);
                pinTextField.setVisible(false);
                dodajSędziegoButton.setVisible(false);
                imięLabel.setVisible(true);
                imięTextField.setVisible(true);
                nazwiskoLabel.setVisible(true);
                nazwiskoTextField.setVisible(true);
                dataUrodzeniaLabel.setVisible(true);
                dataUrodzeniaTextField.setVisible(true);
                narodowośćLabel.setVisible(true);
                narodowoscTextField.setVisible(true);
                utwórzOsobęButton.setVisible(true);

                frame.setSize(300,300);

            }
        });

        utwórzOsobęButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rokStartuKarieryLabel.setVisible(true);
                debiutLigowyLabel.setVisible(true);
                pinLabel.setVisible(true);
                rokStartuKarieryTextField.setVisible(true);
                debiutLigowyTextField.setVisible(true);
                pinTextField.setVisible(true);
                dodajSędziegoButton.setVisible(true);
                imięLabel.setVisible(false);
                imięTextField.setVisible(false);
                nazwiskoLabel.setVisible(false);
                nazwiskoTextField.setVisible(false);
                dataUrodzeniaLabel.setVisible(false);
                dataUrodzeniaTextField.setVisible(false);
                narodowośćLabel.setVisible(false);
                narodowoscTextField.setVisible(false);
                utwórzOsobęButton.setVisible(false);
            }
        });
        zmieńSkładyDrużynButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setSize(500,400);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
            }
        });
        wrócDoPaneluAdministratoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanel);
                frame.setSize(400,300);


            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Aplikacja administratora");
        frame.setContentPane(new AplikacjaAdministratora().glownyPanel);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(layout);
    }
}
