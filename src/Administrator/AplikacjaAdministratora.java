package Administrator;

import Encje.Osoba;
import Encje.Sedzia;
import Encje.Trener;
import Encje.Zawodnik;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AplikacjaAdministratora extends JPanel{

    private static JFrame frame;
    private static CardLayout layout = new CardLayout();
    private JPanel glownyPanel;
    private JButton utworzKontoSedziegoButton;
    private JButton zmienSkladyDruzynButton;
    private JPanel panelStartowy;
    private JPanel panelTworzeniaKontaSedziego;
    private JTextField imieTextField;
    private JTextField nazwiskoTextField;
    private JTextField dataUrodzeniaTextField;
    private JTextField narodowoscTextField;
    private JButton wrocDoPaneluAdministratoraButton2;
    private JPanel panelZmianySkladow;
    private JTable tableSklady;
    private JButton odswiezTabeleZawodnicyButton;
    private JButton usunZawodnikaButton;
    private JButton dodajZawodnikaButton;
    private JButton wrocDoPaneluAdministratoraButton;
    private JLabel nazwiskoLabel;
    private JLabel dataUrodzeniaLabel;
    private JLabel narodowoscLabel;
    private JLabel imieLabel;
    private JTextField rokStartuKarieryTextField;
    private JTextField debiutLigowyTextField;
    private JTextField pinTextField;
    private JButton dodajSedziegoButton;
    private JLabel rokStartuKarieryLabel;
    private JLabel debiutLigowyLabel;
    private JLabel pinLabel;
    private JButton edytujTabeleTrenerowButton;
    private JPanel panedEdycjiTrenerow;
    private JTable tableTrenerzy;
    private JButton powrotButton;
    private JButton dodajTreneraButton;
    private JButton usunTreneraButton;
    private JButton odswiezTabeleButton2;
    private JButton odswiezTabeleButton;
    private static Connection bazaDanych;
    private Zapytanie zapytanie = new Zapytanie();
    private JTable tableSedziowie;
    private DefaultTableModel defaultTableModelSedziowie = new DefaultTableModel(null, new String[]{"ID Sedziego", "Rok startu kariery miedzynarodowej", "ID Osoby", "Data debiutu ligowego", "Data zakonczenia kariery sedziowskiej", "PIN Sedziego"});
    private JScrollPane sedziowieScrollPane;
    private JTextField imieTreneraTextField;
    private JTextField nazwiskoTreneraTextField;
    private JTextField dataUrodzeniaTreneraTextField;
    private JTextField narodowoscTreneraTextField;
    private JTextField rozpoczecieKarieryTreneraTextField;
    private JComboBox preferowaneFormacjeComboBox;
    private JComboBox druzynyComboBox;
    private JTextField imieZawodnikaTextField;
    private JTextField nazwiskoZawodnikaTextField;
    private JTextField dataUrodzeniaZawodnikaTextField;
    private JTextField narodowoscZawodnikaTextField;
    private JTextField rozpoczecieKarieryZawodnikaTextField;
    private JComboBox pozycjaComboBox;
    private JComboBox druzynyZawodnikaComboBox;
    private DefaultTableModel defaultTableModelTrenerzy = new DefaultTableModel(null, new String[]{"ID Trenera", "Data rozpoczecia kariery trenerskiej", "Data zakonczenia kariery trenerskiej", "Preferowana formacja", "ID Osoby", "ID Trenowanej druzyny"});
    private DefaultTableModel defaultTableModelZawodnicy = new DefaultTableModel(null, new String[]{"ID Zawodnika", "Data rozpoczecia kariery", "Data zakonczenia kariery", "Pozycja", "ID Osoby", "ID Druzyny"});

    public void ustawComboBoxy()
    {
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
        druzynyZawodnikaComboBox.addItem("");
        druzynyZawodnikaComboBox.addItem("FC Bayern Monachium");
        druzynyZawodnikaComboBox.addItem("Borussia Dortmund");
        druzynyZawodnikaComboBox.addItem("Manchester City");
        druzynyZawodnikaComboBox.addItem("Manchester United");
        druzynyZawodnikaComboBox.addItem("Paris Saint-Germain");
        druzynyZawodnikaComboBox.addItem("Olympique Lyon");
        druzynyZawodnikaComboBox.addItem("FC Barcelona");
        druzynyZawodnikaComboBox.addItem("Real Madrid");
        druzynyZawodnikaComboBox.addItem("Inter Mediolan");
        druzynyZawodnikaComboBox.addItem("Juventus F.C.");
        pozycjaComboBox.addItem("");
        pozycjaComboBox.addItem("Bramkarz");
        pozycjaComboBox.addItem("Obrońca");
        pozycjaComboBox.addItem("Pomocnik");
        pozycjaComboBox.addItem("Napastnik");
        preferowaneFormacjeComboBox.addItem("");
        preferowaneFormacjeComboBox.addItem("4-4-2");
        preferowaneFormacjeComboBox.addItem("3-5-2");
        preferowaneFormacjeComboBox.addItem("4-3-3");
        preferowaneFormacjeComboBox.addItem("4-2-3-1");
    }

    public AplikacjaAdministratora() {
        stworzTabeleSedziowie();
        stworzTabeleTrenerzy();
        ustawComboBoxy();
        stworzTabeleZawodnicy();
        utworzKontoSedziegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanel);
                frame.setSize(1250,700);
                odswiezTabeleSedziowie();
            }
        });

        wrocDoPaneluAdministratoraButton2.addActionListener(new ActionListener() {
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

        zmienSkladyDruzynButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setSize(1500,600);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                odswiezTabeleZawodnicy();
            }
        });

        wrocDoPaneluAdministratoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanel);
                frame.setSize(400,300);
            }
        });

        dodajSedziegoButton.addActionListener(new ActionListener() {
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
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.osoby WHERE Imie = '" + imieTextField.getText() + "' AND Nazwisko = '" + nazwiskoTextField.getText() + "' AND Data_urodzenia = '" + date + "' AND Narodowosc = '" + narodowoscTextField.getText() + "' AND Rola = 'Sedzia';");
                        resultSet.next();
                        int idOsoby = resultSet.getInt("ID_Osoby");

                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy MM dd");
                        Date date1 = new Date(format1.parse(debiutLigowyTextField.getText()).getTime());

                        Sedzia sedzia = new Sedzia(Integer.parseInt(rokStartuKarieryTextField.getText()), idOsoby, date1, Integer.parseInt(pinTextField.getText()));
                        zapytanie.wykonajInsertSędzia(bazaDanych, sedzia);
                        JOptionPane.showMessageDialog(null,"Utworzono konto sędziego");
                        imieTextField.setText("");
                        nazwiskoTextField.setText("");
                        dataUrodzeniaTextField.setText("");
                        narodowoscTextField.setText("");
                        rokStartuKarieryTextField.setText("");
                        debiutLigowyTextField.setText("");
                        pinTextField.setText("");
                        odswiezTabeleSedziowie();
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        edytujTabeleTrenerowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.last(glownyPanel);
                frame.setSize(1500,600);
            }
        });
        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanel);
                frame.setSize(300,300);
            }
        });
        odswiezTabeleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                odswiezTabeleSedziowie();
            }
        });
        dodajTreneraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (dataUrodzeniaTreneraTextField.getText().equals("") || imieTreneraTextField.getText().equals("")
                        || nazwiskoTreneraTextField.getText().equals("") || narodowoscTreneraTextField.getText().equals("")
                        || rozpoczecieKarieryTreneraTextField.getText().equals("") || preferowaneFormacjeComboBox.getSelectedIndex() == 0
                        || druzynyComboBox.getSelectedIndex() == 0)
                {
                    JOptionPane.showMessageDialog(null,"Należy uzupełnić wszystkie pola!");

                }
                else {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
                    Date date;
                    try {
                        date= new Date(format.parse(dataUrodzeniaTreneraTextField.getText()).getTime());
                        Osoba osoba = new Osoba(imieTreneraTextField.getText(),nazwiskoTreneraTextField.getText(), date, narodowoscTreneraTextField.getText(),"Trener");
                        zapytanie.wykonajInsertOsoba(bazaDanych, osoba);

                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.osoby WHERE Imie = '" + imieTreneraTextField.getText() + "' AND Nazwisko = '" + nazwiskoTreneraTextField.getText() + "' AND Data_urodzenia = '" + date + "' AND Narodowosc = '" + narodowoscTreneraTextField.getText() + "' AND Rola = 'Trener';");
                        resultSet.next();
                        int idOsoby = resultSet.getInt("ID_Osoby");

                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy MM dd");
                        Date date1 = new Date(format1.parse(rozpoczecieKarieryTreneraTextField.getText()).getTime());

                        Trener trener = new Trener( date1, null, preferowaneFormacjeComboBox.getSelectedItem().toString(), idOsoby, druzynyComboBox.getSelectedIndex());
                        zapytanie.wykonajInsertTrener(bazaDanych, trener);
                        JOptionPane.showMessageDialog(null,"Utworzono trenera");
                        imieTreneraTextField.setText("");
                        nazwiskoTreneraTextField.setText("");
                        dataUrodzeniaTreneraTextField.setText("");
                        narodowoscTreneraTextField.setText("");
                        rozpoczecieKarieryTreneraTextField.setText("");
                        preferowaneFormacjeComboBox.setSelectedIndex(0);
                        druzynyComboBox.setSelectedIndex(0);
                        odswiezTabeleTrenerzy();
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        odswiezTabeleButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                odswiezTabeleTrenerzy();
            }
        });

        dodajZawodnikaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (dataUrodzeniaZawodnikaTextField.getText().equals("") || imieZawodnikaTextField.getText().equals("")
                        || nazwiskoZawodnikaTextField.getText().equals("") || narodowoscZawodnikaTextField.getText().equals("")
                        || rozpoczecieKarieryZawodnikaTextField.getText().equals("") || pozycjaComboBox.getSelectedIndex() == 0
                        || druzynyZawodnikaComboBox.getSelectedIndex() == 0)
                {
                    JOptionPane.showMessageDialog(null,"Należy uzupełnić wszystkie pola!");

                }
                else {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
                    Date date;
                    try {
                        date= new Date(format.parse(dataUrodzeniaZawodnikaTextField.getText()).getTime());
                        Osoba osoba = new Osoba(imieZawodnikaTextField.getText(),nazwiskoZawodnikaTextField.getText(), date, narodowoscZawodnikaTextField.getText(),"Zawodnik");
                        zapytanie.wykonajInsertOsoba(bazaDanych, osoba);

                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.osoby WHERE Imie = '" + imieZawodnikaTextField.getText() + "' AND Nazwisko = '" + nazwiskoZawodnikaTextField.getText() + "' AND Data_urodzenia = '" + date + "' AND Narodowosc = '" + narodowoscZawodnikaTextField.getText() + "' AND Rola = 'Zawodnik';");
                        resultSet.next();
                        int idOsoby = resultSet.getInt("ID_Osoby");

                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy MM dd");
                        Date date1 = new Date(format1.parse(rozpoczecieKarieryZawodnikaTextField.getText()).getTime());

                        Zawodnik zawodnik = new Zawodnik( date1, null, pozycjaComboBox.getSelectedItem().toString(), idOsoby, druzynyZawodnikaComboBox.getSelectedIndex());
                        zapytanie.wykonajInsertZawodnik(bazaDanych, zawodnik);
                        JOptionPane.showMessageDialog(null,"Utworzono zawodnika");
                        imieZawodnikaTextField.setText("");
                        nazwiskoZawodnikaTextField.setText("");
                        dataUrodzeniaZawodnikaTextField.setText("");
                        narodowoscZawodnikaTextField.setText("");
                        rozpoczecieKarieryZawodnikaTextField.setText("");
                        pozycjaComboBox.setSelectedIndex(0);
                        druzynyZawodnikaComboBox.setSelectedIndex(0);
                        odswiezTabeleTrenerzy();
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        odswiezTabeleZawodnicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                odswiezTabeleZawodnicy();
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

    private void stworzTabeleSedziowie(){
        tableSedziowie.setModel(defaultTableModelSedziowie);
    }

    private void odswiezTabeleSedziowie(){
        defaultTableModelSedziowie.setRowCount(0);
        try {
            Statement statement = bazaDanych.createStatement();
            ResultSet resultSetSedzia = statement.executeQuery("SELECT * FROM `00018732_kk`.sedziowie;");
            while(resultSetSedzia.next()) {
                int idSedziego = resultSetSedzia.getInt("ID_Sedziego");
                int rokStartuKariery = resultSetSedzia.getInt("Rok_startu_kariery_miedzynarodowej");
                int idOsoby = resultSetSedzia.getInt("ID_Osoby");
                Date dataDebiutuLigowego = resultSetSedzia.getDate("Data_debiutu_ligowego");
                Date dataZakonczeniaKariery = resultSetSedzia.getDate("Data_zakonczenia_kariery_sedziowskiej");
                int pinSedziego = resultSetSedzia.getInt("PIN_Sedziego");
                defaultTableModelSedziowie.addRow(new Object[]{idSedziego, rokStartuKariery, idOsoby, dataDebiutuLigowego, dataZakonczeniaKariery, pinSedziego});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void stworzTabeleTrenerzy(){
        tableTrenerzy.setModel(defaultTableModelTrenerzy);
    }

    private void odswiezTabeleTrenerzy(){
        defaultTableModelTrenerzy.setRowCount(0);
        try {
            Statement statement = bazaDanych.createStatement();
            ResultSet resultSetTrener = statement.executeQuery("SELECT * FROM `00018732_kk`.trenerzy;");
            while(resultSetTrener.next()) {
                int idTrenera = resultSetTrener.getInt("ID_Trenera");
                Date dataRozpoczeciaKariery = resultSetTrener.getDate("Data_rozpoczecia_kariery_trenerskiej");
                Date dataZakonczeniaKariery = resultSetTrener.getDate("Data_zakonczenia_kariery_trenerskiej");
                String formacja = resultSetTrener.getString("Preferowana_formacja");
                int idOsoby = resultSetTrener.getInt("ID_Osoby");
                int idTrenowanejDruzyny = resultSetTrener.getInt("ID_Trenowanej_Druzyny");
                defaultTableModelTrenerzy.addRow(new Object[]{idTrenera, dataRozpoczeciaKariery, dataZakonczeniaKariery, formacja, idOsoby, idTrenowanejDruzyny});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void stworzTabeleZawodnicy(){
        tableSklady.setModel(defaultTableModelZawodnicy);
    }

    private void odswiezTabeleZawodnicy(){
        defaultTableModelZawodnicy.setRowCount(0);
        try {
            Statement statement = bazaDanych.createStatement();
            ResultSet resultSetZawodnik = statement.executeQuery("SELECT * FROM `00018732_kk`.zawodnicy;");
            while(resultSetZawodnik.next()) {
                int idZawodnika = resultSetZawodnik.getInt("ID_Zawodnika");
                Date dataRozpoczeciaKariery = resultSetZawodnik.getDate("Data_rozpoczecia_kariery_pilkarskiej");
                Date dataZakonczeniaKariery = resultSetZawodnik.getDate("Data_zakonczenia_kariery_pilkarskiej");
                String pozycja = resultSetZawodnik.getString("Pozycja");
                int idOsoby = resultSetZawodnik.getInt("ID_Osoby");
                int idDruzyny = resultSetZawodnik.getInt("ID_Druzyny");
                defaultTableModelZawodnicy.addRow(new Object[]{idZawodnika, dataRozpoczeciaKariery, dataZakonczeniaKariery, pozycja, idOsoby, idDruzyny});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
