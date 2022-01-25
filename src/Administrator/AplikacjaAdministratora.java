package Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AplikacjaAdministratora {

    private static JFrame frame;
    private static CardLayout layout = new CardLayout();
    private JPanel glownyPanel;
    private JButton utwórzKontoSędziegoButton;
    private JButton zmieńSkładyDrużynButton;
    private JPanel panelStartowy;
    private JPanel panelTworzeniaKontaSedziego;
    private JTextField imieTextField;
    private JTextField nazwiskoTextField;
    private JTextField dataUrodzeniaTextField;
    private JTextField narodowoscTextField;
    private JButton wróćDoPaneluAdministratoraButton;
    private JPanel panelZmianySkladow;
    private JTable tableSkłady;
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
    private static Connection bazaDanych;
    private Zapytanie zapytanie = new Zapytanie();


    public AplikacjaAdministratora() {
        utwórzKontoSędziegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanel);
                frame.setSize(800,500);
            }
        });

        wróćDoPaneluAdministratoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.previous(glownyPanel);
                imieTextField.setText("");
                nazwiskoTextField.setText("");
                dataUrodzeniaTextField.setText("");
                narodowoscTextField.setText("");
                frame.setSize(300,300);
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

        dodajSędziegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dataUrodzeniaTextField.getText().equals("") || imieTextField.getText().equals("")
                || nazwiskoTextField.getText().equals("") || narodowoscTextField.getText().equals("")
                || rokStartuKarieryTextField.getText().equals("") || debiutLigowyTextField.getText().equals("")
                || pinTextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Należy uzupełnić wszystkie pola!");

                }
                else {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
                    Date date;
                    try {
                        date= new Date(format.parse(dataUrodzeniaTextField.getText()).getTime());
                        Osoba osoba = new Osoba(imieTextField.getText(),nazwiskoTextField.getText(), date, narodowoscTextField.getText(),"Sędzia");
                        zapytanie.wykonajInsertOsoba(bazaDanych, osoba);

                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.osoby WHERE Imie = '" + imieTextField.getText() + "' AND Nazwisko = '" + nazwiskoTextField.getText() + "' AND Data_urodzenia = '" + date + "' AND Narodowosc = '" + narodowoscTextField.getText() + "';");

                        int idOsoby = resultSet.getInt("ID_Osoby");

                        date = new Date(format.parse(debiutLigowyTextField.getText()).getTime());
                        Sedzia sedzia = new Sedzia(Integer.parseInt(rokStartuKarieryTextField.getText()), idOsoby, date, Integer.parseInt(pinTextField.getText()));
                        zapytanie.wykonajInsertSędzia(bazaDanych, sedzia);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        try{
            bazaDanych = DriverManager.getConnection("jdbc:mysql://@czaplinek.home.pl:3306", "00018732_kk", "K@jetanKr@23");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame = new JFrame("Aplikacja administratora");
        frame.setContentPane(new AplikacjaAdministratora().glownyPanel);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(layout);
    }
}
