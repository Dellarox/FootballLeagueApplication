package Administrator;

import javax.swing.text.rtf.RTFEditorKit;
import java.sql.*;

public class Zapytanie {

    public void wykonajInsertOsoba(Connection bazaDanych, Osoba osoba) throws  SQLException {
        Statement statement = bazaDanych.createStatement();
        statement.executeUpdate("INSERT INTO `00018732_kk`.osoby (Imie, Nazwisko, Data_urodzenia, Narodowosc, Rola) VALUES ('" + osoba.getImie() + "', '" + osoba.getNazwisko() + "', '" + osoba.getDataUrodzenia() + "', '" + osoba.getNarodowosc() + "', '" + osoba.getRola() + "');");
    }

    public void wykonajInsertSędzia(Connection bazaDanych, Sedzia sedzia) throws SQLException {
        Statement statement = bazaDanych.createStatement();

        statement.executeUpdate("INSERT INTO `00018732_kk`.sedziowie (Rok_startu_kariery_miedzynarodowej, ID_Osoby, Data_debiutu_ligowego, Data_zakonczenia_kariery_sedziowskiej) VALUES (" + sedzia.getRokStartuKarieryMiedzynarodowej() + ", " + sedzia.getIdOsoby() + ", " + sedzia.getDataDebiutuLigowego() + ", null, " + sedzia.getPinSedziego() + ");");

    };
}
