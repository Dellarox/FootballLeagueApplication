package Administrator;

import javax.swing.text.rtf.RTFEditorKit;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Zapytanie {

    public void wykonajInsertOsoba(Connection bazaDanych, Osoba osoba) throws  SQLException {
        Statement statement = bazaDanych.createStatement();
        statement.executeUpdate("INSERT INTO `00018732_kk`.osoby (Imie, Nazwisko, Data_urodzenia, Narodowosc, Rola) VALUES ('" + osoba.getImie() + "', '" + osoba.getNazwisko() + "', '" + osoba.getDataUrodzenia() + "', '" + osoba.getNarodowosc() + "', '" + osoba.getRola() + "');");
    }

    public void wykonajInsertSędzia(Connection bazaDanych, Sedzia sedzia) throws SQLException {
        Statement statement = bazaDanych.createStatement();

        statement.executeUpdate("INSERT INTO `00018732_kk`.sedziowie (Rok_startu_kariery_miedzynarodowej, ID_Osoby, Data_debiutu_ligowego, Data_zakonczenia_kariery_sedziowskiej, PIN_Sedziego) VALUES (" + sedzia.getRokStartuKarieryMiedzynarodowej() + ", " + sedzia.getIdOsoby() + ", '" + sedzia.getDataDebiutuLigowego() + "', null, " + sedzia.getPinSedziego() + ");");

    };
    public void wykonajInsertUzytkownik(Connection bazaDanych, Uzytkownik uzytkownik) throws SQLException {
        Statement statement = bazaDanych.createStatement();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        statement.executeUpdate("INSERT INTO `00018732_kk`.uzytkownicy (Pseudonim, Data_zalozenia_konta, ID_Ulubionej_Druzyny, Haslo) VALUES ('" + uzytkownik.getPseudonim() + "','" + format.format(uzytkownik.getDataZalozeniaKonta()) + "', " + uzytkownik.getIdUlubionejDruzyny() + ", '" + uzytkownik.getHaslo() + "');");
        //format.format(uzytkownik.getDataZalozeniaKonta());
    }
}
