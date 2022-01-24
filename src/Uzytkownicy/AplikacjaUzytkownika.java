package Uzytkownicy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplikacjaUzytkownika {

    private static JFrame frame;
    private static CardLayout layout = new CardLayout();
    private JPanel glownyPanelUzytkownika;
    private JPanel panelWyboruLogowania;
    private JPanel panelLogowaniaSedziego;
    private JPanel panelLogowaniaUzytkownika;
    private JButton użytkownikButton;
    private JButton sędziaButton;
    private JButton powrótButton;
    private JButton zalogujButton;
    private JTextField idTextField;
    private JTextField pinTextField;
    private JButton powrótButton1;
    private JButton zalogujButton1;
    private JButton utwórzNoweKontoButton;
    private JTextField loginTextField;
    private JTextField hasloTextField;
    private JPanel panelSprawozdan;
    private JTable table1;
    private JButton wylogujButton;
    private JButton wprowadźSprawozdanieButton;
    private JTextField idMeczuTextField;
    private JTextField zolteKartkiTextField;
    private JTextField czerwoneTextField;
    private JTextField goleGospodarzyTextField;
    private JTextField goleGosciTextField;
    private JPanel panelRejestracji;
    private JButton utwórzKontoButton;
    private JTextField loginRejestracjaTextField;
    private JPasswordField hasloRejestracjaTextField;
    private JPasswordField powtorzHasloTextField;
    private JButton powrótButton2;
    private JComboBox druzynyComboBox;
    private JTable table2;
    private JButton ilośćFanówDrużynButton;
    private JButton punktacjaLigiButton;
    private JButton statystykiSędziówButton;
    private JButton terminarzButton;
    private JButton trenerzyButton;
    private JButton wylogujButton1;
    private JButton zawodnicyButton;
    private JPanel panelWidokow;

    public void ustawComboBox()
    {
        druzynyComboBox.removeAllItems();
        druzynyComboBox.addItem("FC Bayern Monachium");
        druzynyComboBox.addItem("Borussia Dortmund");
        druzynyComboBox.addItem("Manchester City");
        druzynyComboBox.addItem("Manchester United");
        druzynyComboBox.addItem("Paris Saint-Germain");
        druzynyComboBox.addItem("Olympique Lyon");
        druzynyComboBox.addItem("FC Barcelona");
        druzynyComboBox.addItem("Real Madrid");
        druzynyComboBox.addItem("Inter Mediolan");
        druzynyComboBox.addItem("Juventus F.C.");
    }
    public AplikacjaUzytkownika() {
        użytkownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanelUzytkownika);
                layout.next(glownyPanelUzytkownika);
                frame.setSize(450,400);

            }
        });
        powrótButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                frame.setSize(300,300);
                loginTextField.setText("");
                hasloTextField.setText("");
            }
        });
        sędziaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanelUzytkownika);
                frame.setSize(400,300);
            }
        });
        powrótButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                idTextField.setText("");
                pinTextField.setText("");
                frame.setSize(300,300);
            }
        });
        wylogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                idMeczuTextField.setText("");
                zolteKartkiTextField.setText("");
                czerwoneTextField.setText("");
                goleGospodarzyTextField.setText("");
                goleGosciTextField.setText("");
                frame.setSize(300,300);
            }
        });
        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanelUzytkownika);
                layout.next(glownyPanelUzytkownika);
                frame.setSize(600,400);
            }
        });
        powrótButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.previous(glownyPanelUzytkownika);
                layout.previous(glownyPanelUzytkownika);
                frame.setSize(600,400);
            }
        });
        utwórzNoweKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanelUzytkownika);
                layout.next(glownyPanelUzytkownika);
                frame.setSize(700,400);
                ustawComboBox();

            }
        });
        wylogujButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                frame.setSize(300,300);
            }
        });
        zalogujButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.last(glownyPanelUzytkownika);
                frame.setSize(700,400);
            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("Aplikacja użytkownika");
        frame.setContentPane(new AplikacjaUzytkownika().glownyPanelUzytkownika);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(layout);

    }
}
