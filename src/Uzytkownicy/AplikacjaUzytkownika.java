package Uzytkownicy;

import Encje.SprawozdanieSedziego;
import Encje.Uzytkownik;
import Administrator.Zapytanie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private JButton wynikiButton;
    private JButton trenerzyButton;
    private JButton wylogujButton1;
    private JButton zawodnicyButton;
    private JPanel panelWidokow;
    private JPasswordField pinPasswordField;
    private JPasswordField hasloPasswordField;
    private static Connection bazaDanych;
    private Zapytanie zapytanie = new Zapytanie();
    private int zalogowanySedzia;
    private DefaultTableModel defaultTableModelIloscFanowDruzyn = new DefaultTableModel(null, new String[]{"Nazwa druzyny", "Ilosc fanow"});
    private DefaultTableModel defaultTableModelPunktacjaLigi = new DefaultTableModel(null, new String[]{"Nazwa druzyny", "Ilosc bramek zdobytych", "Ilosc bramek straconych", "Ilosc wygranych meczow", "Ilosc przegranych meczow", "Ilosc zremisowanych meczow", "Ilosc zdobytych punktow"});
    private DefaultTableModel defaultTableModelStatystykiSedziow = new DefaultTableModel(null, new String[]{"Nazwisko", "Imie", "Ilosc poprowadzonych spotkan", "Ilosc pokazanych zoltych kartek", "Ilosc pokazanych czerwonych kartek"});
    private DefaultTableModel defaultTableModelTerminarz = new DefaultTableModel(null, new String[]{"Numer kolejki", "Gospodarze", "Goscie", "Data meczu", "Ilosc goli gospodarzy", "Ilosc goli gosci"});
    private DefaultTableModel defaultTableModelTrenerzy = new DefaultTableModel(null, new String[]{"Imie", "Nazwisko", "Data rozpoczecia kariery", "Preferowana formacja", "Nazwa druzyny"});
    private DefaultTableModel defaultTableModelZawodnicy = new DefaultTableModel(null, new String[]{"Imie", "Nazwisko", "Nazwa druzyny", "Data rozpoczecia kariery", "Data zakonczenia kariery", "Pozycja"});
    private DefaultTableModel defaultTableModelMeczeDlaSedziow = new DefaultTableModel(null, new String[]{"ID Meczu", "Gospodarze", "Goscie", "Data meczu", "Numer kolejki", "ID Sedziego", "ID Druzyny wygranej"});

    public void ustawComboBox() {
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
                frame.setSize(450, 400);

            }
        });
        powrotButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                frame.setSize(300, 300);
                loginTextField.setText("");
                hasloPasswordField.setText("");
            }
        });
        sedziaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanelUzytkownika);
                frame.setSize(400, 300);
            }
        });
        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                idTextField.setText("");
                pinPasswordField.setText("");
                frame.setSize(300, 300);
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
                frame.setSize(300, 300);
            }
        });
        zalogujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (idTextField.getText().equals("") || pinPasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nale??y uzupe??ni?? wszystkie pola!");
                } else {
                    try {
                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.sedziowie WHERE ID_Sedziego = '" + Integer.parseInt(idTextField.getText()) + "';");
                        if (resultSet.next() == false || resultSet.getInt("PIN_Sedziego") != Integer.parseInt(pinPasswordField.getText())) {
                            JOptionPane.showMessageDialog(null, "Niepoprawny login lub has??o!");
                        } else if (!(resultSet.getString("Data_zakonczenia_kariery_sedziowskiej") == null)) {
                            JOptionPane.showMessageDialog(null, "Konto jest nieaktywne z powodu zako??czenia kariery");
                        } else {
                            layout.next(glownyPanelUzytkownika);
                            layout.next(glownyPanelUzytkownika);
                            zalogowanySedzia = resultSet.getInt("ID_Sedziego");
                            frame.setSize(600, 400);
                            idTextField.setText("");
                            pinPasswordField.setText("");
                            sedziaMecze(zalogowanySedzia);
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
                frame.setSize(600, 400);
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
                frame.setSize(700, 400);
                ustawComboBox();

            }
        });
        wylogujButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanelUzytkownika);
                frame.setSize(300, 300);
            }
        });
        zalogujButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (loginTextField.getText().equals("") || hasloPasswordField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nale??y uzupe??ni?? wszystkie pola!");
                } else {
                    Statement statement = null;
                    try {
                        statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.uzytkownicy WHERE Pseudonim = '" + loginTextField.getText() + "';");
                        if (resultSet.next() == false || !resultSet.getString("Haslo").equals(hasloPasswordField.getText())) {
                            JOptionPane.showMessageDialog(null, "Niepoprawny login lub has??o!");
                        } else {
                            layout.last(glownyPanelUzytkownika);
                            frame.setSize(1400, 700);
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
                        || powtorzHasloTextField.getText().equals("") || druzynyComboBox.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nale??y uzupe??ni?? wszystkie pola!");
                } else if (!hasloRejestracjaTextField.getText().equals(powtorzHasloTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "Podane has??a nie s?? takie same!");
                } else {

                    Date aktualnaData = new Date();
                    Uzytkownik uzytkownik = new Uzytkownik(loginRejestracjaTextField.getText(), aktualnaData, druzynyComboBox.getSelectedIndex(), hasloRejestracjaTextField.getText());
                    try {
                        zapytanie.wykonajInsertUzytkownik(bazaDanych, uzytkownik);
                        JOptionPane.showMessageDialog(null,"Zarejestrowano u??ytkownika");
                    } catch (SQLIntegrityConstraintViolationException exception) {
                        JOptionPane.showMessageDialog(null,"Ten pseudonim jest ju?? zaj??ty");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        wprowadzSprawozdanieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String gospodarze;
                String goscie;
                int idGospodarzy;
                int idGosci;

                if (idMeczuTextField.getText().equals("") || zolteKartkiTextField.getText().equals("")
                        || czerwoneTextField.getText().equals("") || goleGospodarzyTextField.getText().equals("") || goleGosciTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nale??y uzupe??ni?? wszystkie pola!");
                } else {
                    SprawozdanieSedziego sprawozdanieSedziego = new SprawozdanieSedziego(Integer.parseInt(zolteKartkiTextField.getText()),
                            Integer.parseInt(czerwoneTextField.getText()),
                            Integer.parseInt(goleGospodarzyTextField.getText()),
                            Integer.parseInt(goleGosciTextField.getText()),
                            Integer.parseInt(idMeczuTextField.getText()),
                            zalogowanySedzia);
                    try {


                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.mecze WHERE ID_Meczu = " + idMeczuTextField.getText() + ";");
                        resultSet.next();
                        gospodarze = resultSet.getString("Gospodarze");
                        goscie = resultSet.getString("Goscie");

                        resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.druzyny WHERE Nazwa_druzyny = '" + gospodarze + "';");
                        resultSet.next();
                        idGospodarzy = resultSet.getInt("ID_Druzyny");

                        resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.druzyny WHERE Nazwa_druzyny = '" + goscie + "';");
                        resultSet.next();
                        idGosci = resultSet.getInt("ID_Druzyny");

                        try {
                            zapytanie.wykonajInsertSprawozdanieSedziego(bazaDanych, sprawozdanieSedziego);
                            JOptionPane.showMessageDialog(null, "Dodano sprawozdanie");
                            if (!goleGospodarzyTextField.getText().equals(goleGosciTextField.getText())) {
                                if (Integer.parseInt(goleGospodarzyTextField.getText()) > Integer.parseInt(goleGosciTextField.getText())) {
                                    zapytanie.updateWygrana(bazaDanych, Integer.parseInt(idMeczuTextField.getText()), idGospodarzy, idGosci, Integer.parseInt(goleGospodarzyTextField.getText()), Integer.parseInt(goleGosciTextField.getText()));

                                } else {
                                    zapytanie.updateWygrana(bazaDanych, Integer.parseInt(idMeczuTextField.getText()), idGosci, idGospodarzy, Integer.parseInt(goleGospodarzyTextField.getText()), Integer.parseInt(goleGosciTextField.getText()));
                                }
                            } else {
                                zapytanie.updateRemis(bazaDanych, idGospodarzy, idGosci, Integer.parseInt(goleGosciTextField.getText()));
                            }
                        } catch (SQLIntegrityConstraintViolationException exception) {
                            JOptionPane.showMessageDialog(null, "Dodano ju?? sprawozdanie dla tego meczu");
                            return;
                        }



                        idMeczuTextField.setText("");
                        zolteKartkiTextField.setText("");
                        czerwoneTextField.setText("");
                        czerwoneTextField.setText("");
                        goleGosciTextField.setText("");
                        goleGospodarzyTextField.setText("");

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null,"Mecz o takim ID nie istnieje");
                    }

                }
            }
        });
        iloscFanowDruzynButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uzytkownikIloscFanowDruzyn();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        punktacjaLigiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uzytkownikPunktacjaLigi();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        statystykiSedziowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uzytkownikStatystykiSedziow();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        wynikiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uzytkownikTerminarz();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        trenerzyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uzytkownikTrenerzy();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        zawodnicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uzytkownikZawodnicy();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            bazaDanych = DriverManager.getConnection("baza", "login", "haslo");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame = new JFrame("Aplikacja u??ytkownika");
        frame.setContentPane(new AplikacjaUzytkownika().glownyPanelUzytkownika);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(layout);
    }

    public void uzytkownikIloscFanowDruzyn() throws SQLException {
        tableWidoki.setModel(defaultTableModelIloscFanowDruzyn);

        defaultTableModelIloscFanowDruzyn.setRowCount(0);

        Statement statement = bazaDanych.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.widok_ilosc_fanow_druzyn");
        while (resultSet.next()) {
            String nazwaDruzyny = resultSet.getString("Nazwa dru??yny");
            int iloscFanow = resultSet.getInt("Ilo???? fan??w");
            defaultTableModelIloscFanowDruzyn.addRow(new Object[]{nazwaDruzyny, iloscFanow});
        }
    }

    public void uzytkownikPunktacjaLigi() throws SQLException {
        tableWidoki.setModel(defaultTableModelPunktacjaLigi);

        defaultTableModelPunktacjaLigi.setRowCount(0);

        Statement statement = bazaDanych.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.widok_punktacja");
        while (resultSet.next()) {
            String nazwaDruzyny = resultSet.getString("Nazwa dru??yny");
            int iloscBramekZdobytych = resultSet.getInt("Ilo???? bramek zdobytych");
            int iloscBramekStraconych = resultSet.getInt("Ilo???? bramek straconych");
            int iloscWygranych = resultSet.getInt("Ilo???? wygranych mecz??w");
            int iloscPrzegranych = resultSet.getInt("Ilo???? przegranych mecz??w");
            int iloscZremisowanych = resultSet.getInt("Ilo???? zremisowanych mecz??w");
            int iloscPuntktow = resultSet.getInt("Ilo???? zdobytych punkt??w");
            defaultTableModelPunktacjaLigi.addRow(new Object[]{nazwaDruzyny, iloscBramekZdobytych, iloscBramekStraconych, iloscWygranych, iloscPrzegranych, iloscZremisowanych, iloscPuntktow});
        }
    }

    public void uzytkownikStatystykiSedziow() throws SQLException {
        tableWidoki.setModel(defaultTableModelStatystykiSedziow);

        defaultTableModelStatystykiSedziow.setRowCount(0);

        Statement statement = bazaDanych.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.widok_statystyki_sedziow");
        while (resultSet.next()) {
            String nazwisko = resultSet.getString("Nazwisko");
            String imie = resultSet.getString("Imi??");
            int iloscPoprowadzonychSpotkan = resultSet.getInt("Ilo???? poprowadzonych spotka??");
            int iloscPokazanychZoltychKartek = resultSet.getInt("Ilo???? pokazanych ??????tych kartek");
            int iloscPokazanychCzerwonychKartek = resultSet.getInt("Ilo???? pokazanych czerwonych kartek");
            defaultTableModelStatystykiSedziow.addRow(new Object[]{nazwisko, imie, iloscPoprowadzonychSpotkan, iloscPokazanychZoltychKartek, iloscPokazanychCzerwonychKartek});
        }
    }

    public void uzytkownikTerminarz() throws SQLException {
        tableWidoki.setModel(defaultTableModelTerminarz);

        defaultTableModelTerminarz.setRowCount(0);

        Statement statement = bazaDanych.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.widok_terminarz");
        while (resultSet.next()) {
            int numerKolejki = resultSet.getInt("Numer kolejki");
            String gospodarze = resultSet.getString("Gospodarze");
            String goscie = resultSet.getString("Go??cie");
            Date dataMeczu = resultSet.getDate("Data meczu");
            int iloscGoliGospodarzy = resultSet.getInt("Ilo???? goli gospodarzy");
            int iloscGoliGosci = resultSet.getInt("Ilo???? goli go??ci");
            defaultTableModelTerminarz.addRow(new Object[]{numerKolejki, gospodarze, goscie, dataMeczu, iloscGoliGospodarzy, iloscGoliGosci});
        }
    }

    public void uzytkownikTrenerzy() throws SQLException {
        tableWidoki.setModel(defaultTableModelTrenerzy);

        defaultTableModelTrenerzy.setRowCount(0);

        Statement statement = bazaDanych.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.widok_trenerzy");
        while (resultSet.next()) {
            String imie = resultSet.getString("Imi??");
            String nazwisko = resultSet.getString("Nazwisko");
            Date dataRozpoczeciaKariery = resultSet.getDate("Data rozpocz??cia kariery trenerskiej");
            String formacja = resultSet.getString("Preferowana formacja");
            String nazwaDruzyny = resultSet.getString("Nazwa dru??yny");
            defaultTableModelTrenerzy.addRow(new Object[]{imie, nazwisko, dataRozpoczeciaKariery, formacja, nazwaDruzyny});
        }
    }

    public void uzytkownikZawodnicy() throws SQLException {
        tableWidoki.setModel(defaultTableModelZawodnicy);

        defaultTableModelZawodnicy.setRowCount(0);

        Statement statement = bazaDanych.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.widok_zawodnicy");
        while (resultSet.next()) {
            String imie = resultSet.getString("Imi??");
            String nazwisko = resultSet.getString("Nazwisko");
            String nazwaDruzyny = resultSet.getString("Nazwa dru??yny");
            Date dataRozpoczeciaKariery = resultSet.getDate("Data rozpocz??cia kariery pi??karskiej");
            Date dataZakonczeniaKariery = resultSet.getDate("Data zako??czenia kariery pi??karskiej");
            String pozycja = resultSet.getString("Pozycja");
            defaultTableModelZawodnicy.addRow(new Object[]{imie, nazwisko, nazwaDruzyny, dataRozpoczeciaKariery, dataZakonczeniaKariery, pozycja});
        }
    }

    public void sedziaMecze(int idZalogowanegoSedziego) throws SQLException {
        tableSprawozdania.setModel(defaultTableModelMeczeDlaSedziow);

        defaultTableModelMeczeDlaSedziow.setRowCount(0);

        Statement statement = bazaDanych.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.mecze WHERE ID_Sedziego = "+ idZalogowanegoSedziego);
        while (resultSet.next()) {
            int idMeczu = resultSet.getInt("ID_Meczu");
            String gospodarze = resultSet.getString("Gospodarze");
            String goscie = resultSet.getString("Goscie");
            Date dataMeczu = resultSet.getDate("Data_meczu");
            int numberKolejki = resultSet.getInt("Numer_kolejki");
            int idSedziego = resultSet.getInt("ID_Sedziego");
            int idDruzynyWygranej = resultSet.getInt("ID_Druzyny_Wygranej");
            defaultTableModelMeczeDlaSedziow.addRow(new Object[]{idMeczu, gospodarze, goscie, dataMeczu, numberKolejki, idSedziego, idDruzynyWygranej});
        }
    }
}
