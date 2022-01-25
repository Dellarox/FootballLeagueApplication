package Uzytkownicy;

import Encje.SprawozdanieSedziego;
import Encje.Uzytkownik;
import Administrator.Zapytanie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class AplikacjaUzytkownika {

    private static JFrame frame;
    private static CardLayout layout = new CardLayout();
    private JPanel glownyPanelUzytkownika;
    private JPanel panelWyboruLogowania;
    private JPanel panelLogowaniaSedziego;
    private JPanel panelLogowaniaUzytkownika;
    private JButton uzytkownikButton;
    private JButton sedziaButton;
    private JButton powrotButton;
    private JButton zalogujButton;
    private JTextField idTextField;
    private JTextField pinTextField;
    private JButton powrotButton1;
    private JButton zalogujButton1;
    private JButton utworzNoweKontoButton;
    private JTextField loginTextField;
    private JTextField hasloTextField;
    private JPanel panelSprawozdan;
    private JTable tableSprawozdania;
    private JButton wylogujButton;
    private JButton wprowadzSprawozdanieButton;
    private JTextField idMeczuTextField;
    private JTextField zolteKartkiTextField;
    private JTextField czerwoneTextField;
    private JTextField goleGospodarzyTextField;
    private JTextField goleGosciTextField;
    private JPanel panelRejestracji;
    private JButton utworzKontoButton;
    private JTextField loginRejestracjaTextField;
    private JPasswordField hasloRejestracjaTextField;
    private JPasswordField powtorzHasloTextField;
    private JButton powrotButton2;
    private JComboBox druzynyComboBox;
    private JTable tableWidoki;
    private JButton iloscFanowDruzynButton;
    private JButton punktacjaLigiButton;
    private JButton statystykiSedziowButton;
    private JButton terminarzButton;
    private JButton trenerzyButton;
    private JButton wylogujButton1;
    private JButton zawodnicyButton;
    private JPanel panelWidokow;
    private JPasswordField pinPasswordField;
    private JPasswordField hasloPasswordField;
    private static Connection bazaDanych;
    private Zapytanie zapytanie = new Zapytanie();
    private int zalogowanySedzia;

    public void ustawComboBox()
    {
        druzynyComboBox.removeAllItems();
        druzynyComboBox.addItem("");
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
        uzytkownikButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanelUzytkownika);
                layout.next(glownyPanelUzytkownika);
                frame.setSize(450,400);

            }
        });
        powrotButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                frame.setSize(300,300);
                loginTextField.setText("");
                hasloPasswordField.setText("");
            }
        });
        sedziaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanelUzytkownika);
                frame.setSize(400,300);
            }
        });
        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                idTextField.setText("");
                pinPasswordField.setText("");
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
                if (idTextField.getText().equals("") || pinPasswordField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Należy uzupełnić wszystkie pola!");
                }
                else
                {
                    try {
                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.sedziowie WHERE ID_Sedziego = '" + Integer.parseInt(idTextField.getText()) + "';");
                        if (resultSet.next()==false || resultSet.getInt("PIN_Sedziego")!=Integer.parseInt(pinPasswordField.getText()))
                        {
                            JOptionPane.showMessageDialog(null,"Niepoprawny login lub hasło!");
                        }
                        else
                        {
                            layout.next(glownyPanelUzytkownika);
                            layout.next(glownyPanelUzytkownika);
                            zalogowanySedzia = resultSet.getInt("ID_Sedziego");
                            frame.setSize(600,400);
                            idTextField.setText("");
                            pinPasswordField.setText("");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        powrotButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.previous(glownyPanelUzytkownika);
                layout.previous(glownyPanelUzytkownika);
                frame.setSize(600,400);
                loginRejestracjaTextField.setText("");
                hasloRejestracjaTextField.setText("");
                powtorzHasloTextField.setText("");
                druzynyComboBox.setSelectedIndex(0);
            }
        });
        utworzNoweKontoButton.addActionListener(new ActionListener() {
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
                if (loginTextField.getText().equals("") || hasloPasswordField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Należy uzupełnić wszystkie pola!");
                }
                else {
                    Statement statement = null;
                    try {
                        statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.uzytkownicy WHERE Pseudonim = '" + loginTextField.getText() + "';");
                        if(resultSet.next()==false || !resultSet.getString("Haslo").equals(hasloPasswordField.getText()))
                        {
                            JOptionPane.showMessageDialog(null,"Niepoprawny login lub hasło!");
                        }
                        else
                        {
                            layout.last(glownyPanelUzytkownika);
                            frame.setSize(700,400);
                            hasloPasswordField.setText("");
                            loginTextField.setText("");
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        utworzKontoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (loginRejestracjaTextField.getText().equals("") || hasloRejestracjaTextField.getText().equals("")
                || powtorzHasloTextField.getText().equals("") || druzynyComboBox.getSelectedItem().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Należy uzupełnić wszystkie pola!");
                }
                else if(!hasloRejestracjaTextField.getText().equals(powtorzHasloTextField.getText()))
                {
                    JOptionPane.showMessageDialog(null,"Podane hasła nie są takie same!");
                }
                else
                {

                    Date aktualnaData = new Date();
                    Uzytkownik uzytkownik = new Uzytkownik(loginRejestracjaTextField.getText(),aktualnaData,druzynyComboBox.getSelectedIndex(),hasloRejestracjaTextField.getText());
                    try {
                        zapytanie.wykonajInsertUzytkownik(bazaDanych,uzytkownik);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        wprowadzSprawozdanieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (idMeczuTextField.getText().equals("") || zolteKartkiTextField.getText().equals("")
                || czerwoneTextField.getText().equals("") || goleGospodarzyTextField.getText().equals("") || goleGosciTextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Należy uzupełnić wszystkie pola!");
                }
                else
                {
                    SprawozdanieSedziego sprawozdanieSedziego = new SprawozdanieSedziego(Integer.parseInt(zolteKartkiTextField.getText()),
                                                                                         Integer.parseInt(czerwoneTextField.getText()),
                                                                                         Integer.parseInt(goleGospodarzyTextField.getText()),
                                                                                         Integer.parseInt(goleGosciTextField.getText()),
                                                                                         Integer.parseInt(idMeczuTextField.getText()),
                                                                                         zalogowanySedzia);
                    try {
                        zapytanie.wykonajInsertSprawozdanieSedziego(bazaDanych,sprawozdanieSedziego);
                        JOptionPane.showMessageDialog(null,"Dodano sprawozdanie");
                        idMeczuTextField.setText("");
                        zolteKartkiTextField.setText("");
                        czerwoneTextField.setText("");
                        czerwoneTextField.setText("");
                        goleGosciTextField.setText("");
                        goleGospodarzyTextField.setText("");
                    } catch (SQLException e) {
                        e.printStackTrace();
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

        frame = new JFrame("Aplikacja użytkownika");
        frame.setContentPane(new AplikacjaUzytkownika().glownyPanelUzytkownika);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(layout);

    }
}
