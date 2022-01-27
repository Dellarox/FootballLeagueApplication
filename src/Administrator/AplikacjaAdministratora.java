package Administrator;

import Encje.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AplikacjaAdministratora extends JPanel {

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
    private JButton zakonczKariereButton;
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
    private JButton zakonczKariereTreneraButton;
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
    private JButton zakonczKariereSedziegoButton;
    private JButton zamianaWTreneraButton;
    private JPanel panelZamianyZawodnikaWTrenera;
    private JComboBox ulubionaFormacjaComboBox;
    private JComboBox trenowanaDruzynaComboBox;
    private JButton zamienWTreneraButton;
    private JButton zmienDruzyneTrenerowiWEdycjiButton;
    private JComboBox zmianaDruzynyTrenerowiComboBox;
    private JButton zmianaDruzynyTrenerowiButton;
    private JPanel panelZmianyDruzynyTrenerowi;
    private JPanel panelZmianyDruzynyZawodnikowi;
    private JButton zmienDruzyneZawodnikowiButton;
    private JButton zmianaDruzynyZawodnikowiButton;
    private JComboBox zmianaDruzynyZawodnikowiComboBox;
    private JButton powrotButton1;
    private JButton powrotButton2;
    private JButton zwolnijTreneraButton;
    private JButton powrótButton;
    private JButton dodajMeczButton;
    private JComboBox gospodarzeComboBox;
    private JComboBox goscieComboBox;
    private JTextField dataMeczuTextField;
    private JButton powrotMeczButton;
    private JPanel panelDodawaniaMeczu;
    private JTable tableSedziowieMecze;
    private JTextField numerKolejkiTextField;
    private JTextField idSedziegoTextField;
    private JButton dodajMeczButton1;
    private DefaultTableModel defaultTableModelTrenerzy = new DefaultTableModel(null, new String[]{"ID Trenera", "Data rozpoczecia kariery trenerskiej", "Data zakonczenia kariery trenerskiej", "Preferowana formacja", "ID Osoby", "ID Trenowanej druzyny"});
    private DefaultTableModel defaultTableModelZawodnicy = new DefaultTableModel(null, new String[]{"ID Zawodnika", "Data rozpoczecia kariery", "Data zakonczenia kariery", "Pozycja", "ID Osoby", "ID Druzyny"});
    private int wierszZawodnika;
    private int wierszTrenera;
    private DefaultTableModel defaultTableModelSedziowieWMecze = new DefaultTableModel(null, new String[]{"ID Sedziego", "Imie", "Nazwisko", "Narodowosc"});
    
    public void ustawComboBoxy() {
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
        ulubionaFormacjaComboBox.addItem("");
        ulubionaFormacjaComboBox.addItem("4-4-2");
        ulubionaFormacjaComboBox.addItem("3-5-2");
        ulubionaFormacjaComboBox.addItem("4-3-3");
        ulubionaFormacjaComboBox.addItem("4-2-3-1");
        trenowanaDruzynaComboBox.addItem("");
        trenowanaDruzynaComboBox.addItem("FC Bayern Monachium");
        trenowanaDruzynaComboBox.addItem("Borussia Dortmund");
        trenowanaDruzynaComboBox.addItem("Manchester City");
        trenowanaDruzynaComboBox.addItem("Manchester United");
        trenowanaDruzynaComboBox.addItem("Paris Saint-Germain");
        trenowanaDruzynaComboBox.addItem("Olympique Lyon");
        trenowanaDruzynaComboBox.addItem("FC Barcelona");
        trenowanaDruzynaComboBox.addItem("Real Madrid");
        trenowanaDruzynaComboBox.addItem("Inter Mediolan");
        trenowanaDruzynaComboBox.addItem("Juventus F.C.");
        zmianaDruzynyTrenerowiComboBox.addItem("");
        zmianaDruzynyTrenerowiComboBox.addItem("FC Bayern Monachium");
        zmianaDruzynyTrenerowiComboBox.addItem("Borussia Dortmund");
        zmianaDruzynyTrenerowiComboBox.addItem("Manchester City");
        zmianaDruzynyTrenerowiComboBox.addItem("Manchester United");
        zmianaDruzynyTrenerowiComboBox.addItem("Paris Saint-Germain");
        zmianaDruzynyTrenerowiComboBox.addItem("Olympique Lyon");
        zmianaDruzynyTrenerowiComboBox.addItem("FC Barcelona");
        zmianaDruzynyTrenerowiComboBox.addItem("Real Madrid");
        zmianaDruzynyTrenerowiComboBox.addItem("Inter Mediolan");
        zmianaDruzynyTrenerowiComboBox.addItem("Juventus F.C.");
        zmianaDruzynyZawodnikowiComboBox.addItem("");
        zmianaDruzynyZawodnikowiComboBox.addItem("FC Bayern Monachium");
        zmianaDruzynyZawodnikowiComboBox.addItem("Borussia Dortmund");
        zmianaDruzynyZawodnikowiComboBox.addItem("Manchester City");
        zmianaDruzynyZawodnikowiComboBox.addItem("Manchester United");
        zmianaDruzynyZawodnikowiComboBox.addItem("Paris Saint-Germain");
        zmianaDruzynyZawodnikowiComboBox.addItem("Olympique Lyon");
        zmianaDruzynyZawodnikowiComboBox.addItem("FC Barcelona");
        zmianaDruzynyZawodnikowiComboBox.addItem("Real Madrid");
        zmianaDruzynyZawodnikowiComboBox.addItem("Inter Mediolan");
        zmianaDruzynyZawodnikowiComboBox.addItem("Juventus F.C.");
    }

    public AplikacjaAdministratora() {
        stworzTabeleSedziowie();
        stworzTabeleTrenerzy();
        ustawComboBoxy();
        stworzTabeleZawodnicy();
        stworzTabeleMeczeDlaSedziego();
        utworzKontoSedziegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanel);
                frame.setSize(1400, 700);
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
                frame.setSize(300, 300);
            }
        });

        zmienSkladyDruzynButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setSize(1500, 600);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                odswiezTabeleZawodnicy();
            }
        });

        wrocDoPaneluAdministratoraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanel);
                frame.setSize(400, 300);
            }
        });

        dodajSedziegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dataUrodzeniaTextField.getText().equals("") || imieTextField.getText().equals("")
                        || nazwiskoTextField.getText().equals("") || narodowoscTextField.getText().equals("")
                        || rokStartuKarieryTextField.getText().equals("") || debiutLigowyTextField.getText().equals("")
                        || pinTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Należy uzupełnić wszystkie pola!");

                } else {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
                    Date date;
                    try {
                        date = new Date(format.parse(dataUrodzeniaTextField.getText()).getTime());
                        Osoba osoba = new Osoba(imieTextField.getText(), nazwiskoTextField.getText(), date, narodowoscTextField.getText(), "Sedzia");
                        zapytanie.wykonajInsertOsoba(bazaDanych, osoba);

                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT ID_Osoby FROM `00018732_kk`.osoby WHERE Imie = '" + imieTextField.getText() + "' AND Nazwisko = '" + nazwiskoTextField.getText() + "' AND Data_urodzenia = '" + date + "' AND Narodowosc = '" + narodowoscTextField.getText() + "' AND Rola = 'Sedzia';");

                        int idOsoby = 0;
                        while (resultSet.next()) {
                            idOsoby = resultSet.getInt("ID_Osoby");
                        }


                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy MM dd");
                        Date date1 = new Date(format1.parse(debiutLigowyTextField.getText()).getTime());

                        Sedzia sedzia = new Sedzia(Integer.parseInt(rokStartuKarieryTextField.getText()), idOsoby, date1, Integer.parseInt(pinTextField.getText()));
                        zapytanie.wykonajInsertSedzia(bazaDanych, sedzia);
                        int idSedziego;
                        resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.sedziowie WHERE ID_Osoby = "+ idOsoby+";");
                        resultSet.next();
                        idSedziego=resultSet.getInt("ID_Sedziego");
                        zapytanie.wykonajInsterStatystykaSedziego(bazaDanych,idSedziego);
                        JOptionPane.showMessageDialog(null, "Utworzono konto sędziego");
                        imieTextField.setText("");
                        nazwiskoTextField.setText("");
                        dataUrodzeniaTextField.setText("");
                        narodowoscTextField.setText("");
                        rokStartuKarieryTextField.setText("");
                        debiutLigowyTextField.setText("");
                        pinTextField.setText("");
                        odswiezTabeleSedziowie();
                    } catch (ParseException | SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        edytujTabeleTrenerowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                frame.setSize(1500, 600);
                odswiezTabeleTrenerzy();
            }
        });
        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanel);
                frame.setSize(300, 300);
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
                        || druzynyComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Należy uzupełnić wszystkie pola!");

                } else {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
                    Date date;
                    try {
                        date = new Date(format.parse(dataUrodzeniaTreneraTextField.getText()).getTime());
                        Osoba osoba = new Osoba(imieTreneraTextField.getText(), nazwiskoTreneraTextField.getText(), date, narodowoscTreneraTextField.getText(), "Trener");
                        zapytanie.wykonajInsertOsoba(bazaDanych, osoba);

                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.osoby WHERE Imie = '" + imieTreneraTextField.getText() + "' AND Nazwisko = '" + nazwiskoTreneraTextField.getText() + "' AND Data_urodzenia = '" + date + "' AND Narodowosc = '" + narodowoscTreneraTextField.getText() + "' AND Rola = 'Trener';");

                        int idOsoby = 0;

                        while (resultSet.next())
                            idOsoby = resultSet.getInt("ID_Osoby");

                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy MM dd");
                        Date date1 = new Date(format1.parse(rozpoczecieKarieryTreneraTextField.getText()).getTime());

                        Trener trener = new Trener(date1, null, preferowaneFormacjeComboBox.getSelectedItem().toString(), idOsoby, druzynyComboBox.getSelectedIndex());
                        try {
                            zapytanie.wykonajInsertTrener(bazaDanych, trener);
                            JOptionPane.showMessageDialog(null, "Utworzono trenera");
                            imieTreneraTextField.setText("");
                            nazwiskoTreneraTextField.setText("");
                            dataUrodzeniaTreneraTextField.setText("");
                            narodowoscTreneraTextField.setText("");
                            rozpoczecieKarieryTreneraTextField.setText("");
                            preferowaneFormacjeComboBox.setSelectedIndex(0);
                            druzynyComboBox.setSelectedIndex(0);
                            odswiezTabeleTrenerzy();
                        } catch (SQLIntegrityConstraintViolationException exception) {
                            JOptionPane.showMessageDialog(null, "Do tej drużyny został już przypisany trener!");
                        }

                    } catch (ParseException | SQLException ex) {
                        ex.printStackTrace();
                    }
                    odswiezTabeleTrenerzy();
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
                        || druzynyZawodnikaComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Należy uzupełnić wszystkie pola!");

                } else {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
                    Date date;
                    try {
                        date = new Date(format.parse(dataUrodzeniaZawodnikaTextField.getText()).getTime());
                        Osoba osoba = new Osoba(imieZawodnikaTextField.getText(), nazwiskoZawodnikaTextField.getText(), date, narodowoscZawodnikaTextField.getText(), "Zawodnik");
                        zapytanie.wykonajInsertOsoba(bazaDanych, osoba);

                        Statement statement = bazaDanych.createStatement();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM `00018732_kk`.osoby WHERE Imie = '" + imieZawodnikaTextField.getText() + "' AND Nazwisko = '" + nazwiskoZawodnikaTextField.getText() + "' AND Data_urodzenia = '" + date + "' AND Narodowosc = '" + narodowoscZawodnikaTextField.getText() + "' AND Rola = 'Zawodnik';");

                        int idOsoby = 0;

                        while (resultSet.next())
                            idOsoby = resultSet.getInt("ID_Osoby");

                        SimpleDateFormat format1 = new SimpleDateFormat("yyyy MM dd");
                        Date date1 = new Date(format1.parse(rozpoczecieKarieryZawodnikaTextField.getText()).getTime());

                        Zawodnik zawodnik = new Zawodnik(date1, null, pozycjaComboBox.getSelectedItem().toString(), idOsoby, druzynyZawodnikaComboBox.getSelectedIndex());
                        zapytanie.wykonajInsertZawodnik(bazaDanych, zawodnik);
                        JOptionPane.showMessageDialog(null, "Utworzono zawodnika");
                        imieZawodnikaTextField.setText("");
                        nazwiskoZawodnikaTextField.setText("");
                        dataUrodzeniaZawodnikaTextField.setText("");
                        narodowoscZawodnikaTextField.setText("");
                        rozpoczecieKarieryZawodnikaTextField.setText("");
                        pozycjaComboBox.setSelectedIndex(0);
                        druzynyZawodnikaComboBox.setSelectedIndex(0);
                        odswiezTabeleTrenerzy();
                    } catch (ParseException | SQLException ex) {
                        ex.printStackTrace();
                    }
                    odswiezTabeleZawodnicy();
                }
            }
        });
        odswiezTabeleZawodnicyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                odswiezTabeleZawodnicy();
            }
        });
        zakonczKariereSedziegoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int wiersz = tableSedziowie.getSelectedRow();
                if (!(tableSedziowie.getModel().getValueAt(wiersz, 4) == null)) {
                    JOptionPane.showMessageDialog(null, "Ten sędzia już zakończył karierę");
                } else {
                    String komorkaIdSedziego = tableSedziowie.getModel().getValueAt(wiersz, 0).toString();
                    String sql = "UPDATE `00018732_kk`.sedziowie SET Data_zakonczenia_kariery_sedziowskiej = CURDATE() WHERE ID_Sedziego = " + komorkaIdSedziego;

                    try {
                        Statement statement = bazaDanych.createStatement();
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null,"Zakończono karierę sędziego");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    odswiezTabeleSedziowie();
                }

            }
        });
        zakonczKariereButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int wiersz = tableSklady.getSelectedRow();

                if (!(tableSklady.getModel().getValueAt(wiersz, 2) == null)) {
                    JOptionPane.showMessageDialog(null, "Ten zawodnik już zakończył karierę");
                } else {
                    String komorkaIdZawodnika = tableSklady.getModel().getValueAt(wiersz, 0).toString();
                    String sql = "UPDATE `00018732_kk`.zawodnicy SET Data_zakonczenia_kariery_pilkarskiej = CURDATE(), ID_Druzyny = null WHERE ID_Zawodnika = " + komorkaIdZawodnika;

                    try {
                        Statement statement = bazaDanych.createStatement();
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null,"Zakonczone karierę zawodnika");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    odswiezTabeleZawodnicy();
                }

            }
        });
        zakonczKariereTreneraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int wiersz = tableTrenerzy.getSelectedRow();

                if (!(tableTrenerzy.getModel().getValueAt(wiersz, 2) == (null))) {
                    JOptionPane.showMessageDialog(null, "Trener już zakończył karierę");
                } else {
                    String komorkaIdTrenera = tableTrenerzy.getModel().getValueAt(wiersz, 0).toString();

                    String sql = "UPDATE `00018732_kk`.trenerzy SET Data_zakonczenia_kariery_trenerskiej = CURDATE(), ID_Trenowanej_Druzyny = null WHERE ID_Trenera = + " + komorkaIdTrenera;
                    try {
                        Statement statement = bazaDanych.createStatement();
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null,"Zakończono karierę trenera");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    odswiezTabeleTrenerzy();
                }

            }
        });
        zamianaWTreneraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                frame.setSize(500, 400);

            }
        });
        zamienWTreneraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                wierszZawodnika = tableSklady.getSelectedRow();

                String komorkaIdZawodnika = tableSklady.getModel().getValueAt(wierszZawodnika, 0).toString();
                String komorkaIdOsoby = tableSklady.getModel().getValueAt(wierszZawodnika, 4).toString();
                String sqlUsuniecie = "DELETE FROM `00018732_kk`.zawodnicy WHERE ID_Zawodnika = + " + komorkaIdZawodnika;
                String sqlZmianaRoli = "UPDATE `00018732_kk`.osoby SET Rola = 'Trener' WHERE ID_Osoby = " + komorkaIdOsoby;
                String sqlDodajDoTrener = "INSERT INTO `00018732_kk`.trenerzy (Data_rozpoczecia_kariery_trenerskiej, Data_zakonczenia_kariery_trenerskiej, Preferowana_formacja, ID_Osoby, ID_Trenowanej_Druzyny) VALUES (CURDATE(), null, '" + ulubionaFormacjaComboBox.getSelectedItem().toString() + "', " + komorkaIdOsoby + ", " + trenowanaDruzynaComboBox.getSelectedIndex() + ");";
                try {
                    Statement statement = bazaDanych.createStatement();
                    try {
                        statement.executeUpdate(sqlDodajDoTrener);
                        statement.executeUpdate(sqlUsuniecie);
                        statement.executeUpdate(sqlZmianaRoli);
                        JOptionPane.showMessageDialog(null,"Zmieniono zawodnika na trenera");
                    } catch (SQLIntegrityConstraintViolationException exception) {
                        JOptionPane.showMessageDialog(null, "Ta drużyna już posiada trenera");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                odswiezTabeleTrenerzy();
                odswiezTabeleZawodnicy();
                layout.previous(glownyPanel);
                layout.previous(glownyPanel);
                frame.setSize(1500, 600);

            }
        });

        zmienDruzyneTrenerowiWEdycjiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableTrenerzy.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Nie wybrano trenera");
                } else if (!(tableTrenerzy.getModel().getValueAt(tableTrenerzy.getSelectedRow(), 2) == (null))) {
                    JOptionPane.showMessageDialog(null, "Ten trener już zakończył karierę");
                } else {
                    layout.next(glownyPanel);
                    layout.next(glownyPanel);
                    frame.setSize(600, 400);
                }
            }
        });

        zmianaDruzynyTrenerowiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                wierszTrenera = tableTrenerzy.getSelectedRow();

                String komorkaIdTrenera = tableTrenerzy.getModel().getValueAt(wierszTrenera, 0).toString();
                String sql = "UPDATE `00018732_kk`.trenerzy SET ID_Trenowanej_Druzyny = " + zmianaDruzynyTrenerowiComboBox.getSelectedIndex() + " WHERE ID_Trenera = " + komorkaIdTrenera;

                try {
                    Statement statement = bazaDanych.createStatement();
                    try {
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null,"Zmieniono drużynę trenerowi");
                    } catch (SQLIntegrityConstraintViolationException exception) {
                        JOptionPane.showMessageDialog(null, "Ta drużyna ma już trenera");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                odswiezTabeleTrenerzy();
                layout.previous(glownyPanel);
                layout.previous(glownyPanel);
                frame.setSize(1500, 600);

            }
        });
        zmienDruzyneZawodnikowiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableSklady.getSelectedRow() == -1) {
                    JOptionPane.showMessageDialog(null, "Nie wybrano zawodnika");
                } else if (!(tableSklady.getModel().getValueAt(tableSklady.getSelectedRow(), 2) == null)) {
                    JOptionPane.showMessageDialog(null, "Ten zawodnik zakończył już karierę");
                } else {
                    layout.next(glownyPanel);
                    layout.next(glownyPanel);
                    layout.next(glownyPanel);
                    layout.next(glownyPanel);
                    frame.setSize(600, 400);
                }

            }
        });
        zmianaDruzynyZawodnikowiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                wierszZawodnika = tableSklady.getSelectedRow();

                String komorkaIdZawodnika = tableSklady.getModel().getValueAt(wierszZawodnika, 0).toString();
                if (zmianaDruzynyZawodnikowiComboBox.getSelectedIndex() == Integer.parseInt(tableSklady.getModel().getValueAt(wierszZawodnika, 5).toString())) {
                    JOptionPane.showMessageDialog(null, "Zawodnik już jest w tej drużynie");
                } else {
                    String sql = "UPDATE `00018732_kk`.zawodnicy SET ID_Druzyny = " + zmianaDruzynyZawodnikowiComboBox.getSelectedIndex() + " WHERE ID_Zawodnika = " + komorkaIdZawodnika;

                    try {
                        Statement statement = bazaDanych.createStatement();
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null,"Zmienono drużynę zawodnika");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    odswiezTabeleZawodnicy();
                    layout.previous(glownyPanel);
                    layout.previous(glownyPanel);
                    layout.previous(glownyPanel);
                    layout.previous(glownyPanel);
                    frame.setSize(1500, 600);
                }
            }
        });
        powrotButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.previous(glownyPanel);
                layout.previous(glownyPanel);
                layout.previous(glownyPanel);
                layout.previous(glownyPanel);
                frame.setSize(1500, 600);
            }
        });
        powrotButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.previous(glownyPanel);
                layout.previous(glownyPanel);
                frame.setSize(1500, 600);
            }
        });
        zwolnijTreneraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int wiersz = tableTrenerzy.getSelectedRow();

                if (Integer.parseInt(tableTrenerzy.getModel().getValueAt(wiersz, 5).toString()) == 0) {
                    JOptionPane.showMessageDialog(null, "Trener nie ma klubu!");
                } else {
                    String komorkaIdTrenera = tableTrenerzy.getModel().getValueAt(wiersz, 0).toString();

                    String sql = "UPDATE `00018732_kk`.trenerzy SET ID_Trenowanej_Druzyny = null WHERE ID_Trenera = " + komorkaIdTrenera;
                    try {
                        Statement statement = bazaDanych.createStatement();
                        statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null,"Zwolniono trenera");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    odswiezTabeleTrenerzy();
                }
            }
        });
        powrótButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.previous(glownyPanel);
                layout.previous(glownyPanel);
                frame.setSize(1500,600);
            }
        });
        powrotMeczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                layout.first(glownyPanel);
                frame.setSize(300,300);
            }
        });
        dodajMeczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                odswiezTabeleSedziowieMecze();
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                layout.next(glownyPanel);
                frame.setSize(1500,600);
            }
        });
        dodajMeczButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(gospodarzeComboBox.getSelectedIndex()==0 || goscieComboBox.getSelectedIndex()==0 || dataMeczuTextField.getText().equals("")
                || numerKolejkiTextField.getText().equals("") || idSedziegoTextField.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Należy uzupełnić wszystkie pola");
                }
                else if (gospodarzeComboBox.getSelectedIndex()==goscieComboBox.getSelectedIndex())
                {
                    JOptionPane.showMessageDialog(null,"Drużyny nie mogą być takie same");
                }
                else
                {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy MM dd");
                    try {
                        Date date = new Date(format.parse(dataMeczuTextField.getText()).getTime());
                        Mecz mecz = new Mecz(gospodarzeComboBox.getSelectedItem().toString(),goscieComboBox.getSelectedItem().toString(),date,Integer.parseInt(numerKolejkiTextField.getText()),Integer.parseInt(idSedziegoTextField.getText()));
                        zapytanie.wykonajInsertMecz(bazaDanych,mecz);
                        JOptionPane.showMessageDialog(null,"Utworzono nowy mecz");
                        gospodarzeComboBox.setSelectedIndex(0);
                        goscieComboBox.setSelectedIndex(0);
                        dataMeczuTextField.setText("");
                        numerKolejkiTextField.setText("");
                        idSedziegoTextField.setText("");
                        odswiezTabeleSedziowieMecze();
                    } catch (ParseException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            bazaDanych = DriverManager.getConnection("jdbc:mysql://@czaplinek.home.pl:3306", "00018732_kk", "K@jetanKr@23");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        frame = new JFrame("Aplikacja administratora");
        frame.setContentPane(new AplikacjaAdministratora().glownyPanel);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().setLayout(layout);
    }

    private void stworzTabeleSedziowie() {
        tableSedziowie.setModel(defaultTableModelSedziowie);
    }

    private void odswiezTabeleSedziowie() {
        defaultTableModelSedziowie.setRowCount(0);
        try {
            Statement statement = bazaDanych.createStatement();
            ResultSet resultSetSedzia = statement.executeQuery("SELECT * FROM `00018732_kk`.sedziowie;");
            while (resultSetSedzia.next()) {
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

    private void stworzTabeleTrenerzy() {
        tableTrenerzy.setModel(defaultTableModelTrenerzy);
    }

    private void odswiezTabeleTrenerzy() {
        defaultTableModelTrenerzy.setRowCount(0);
        try {
            Statement statement = bazaDanych.createStatement();
            ResultSet resultSetTrener = statement.executeQuery("SELECT * FROM `00018732_kk`.trenerzy;");
            while (resultSetTrener.next()) {
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

    private void stworzTabeleZawodnicy() {
        tableSklady.setModel(defaultTableModelZawodnicy);
    }

    private void odswiezTabeleZawodnicy() {
        defaultTableModelZawodnicy.setRowCount(0);
        try {
            Statement statement = bazaDanych.createStatement();
            ResultSet resultSetZawodnik = statement.executeQuery("SELECT * FROM `00018732_kk`.zawodnicy;");
            while (resultSetZawodnik.next()) {
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

    private void stworzTabeleMeczeDlaSedziego(){ tableSedziowieMecze.setModel(defaultTableModelSedziowieWMecze);}

    private void odswiezTabeleSedziowieMecze(){
        defaultTableModelSedziowieWMecze.setRowCount(0);
        try{
            Statement statement = bazaDanych.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT sedziowie.ID_Sedziego, osoby.Imie, osoby.Nazwisko, osoby.Narodowosc FROM `00018732_kk`.sedziowie inner join `00018732_kk`.osoby WHERE sedziowie.ID_Osoby = osoby.ID_Osoby AND sedziowie.Data_zakonczenia_kariery_sedziowskiej IS NULL;");
            while(resultSet.next()){
                int idSedziego = resultSet.getInt("ID_Sedziego");
                String imie = resultSet.getString("Imie");
                String nazwisko = resultSet.getString("Nazwisko");
                String narodowosc = resultSet.getString("Narodowosc");
                defaultTableModelSedziowieWMecze.addRow(new Object[]{idSedziego, imie, nazwisko, narodowosc});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
