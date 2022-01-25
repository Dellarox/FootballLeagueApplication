package Administrator;

import Encje.*;

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
    }

    public void wykonajInsertSprawozdanieSedziego(Connection bazaDanych, SprawozdanieSedziego sprawozdanieSedziego) throws SQLException {
        Statement statement = bazaDanych.createStatement();
        statement.executeUpdate("INSERT INTO `00018732_kk`.sprawozdanie_sedziego (Ilosc_zoltych_kartek, Ilosc_czerwonych_kartek, Ilosc_goli_gospodarzy, Ilosc_goli_gosci, ID_Meczu, ID_Sedziego) VALUES (" + sprawozdanieSedziego.getIlosc_zoltych_kartek() + ", " + sprawozdanieSedziego.getIlosc_czerwonych_kartek() +", " + sprawozdanieSedziego.getIlosc_goli_gospodarzy() + ", " + sprawozdanieSedziego.getIlosc_goli_gosci() + ", " + sprawozdanieSedziego.getID_Meczu() + ", " + sprawozdanieSedziego.getID_Sedziego() +");");
    }

    public void wykonajInsertTrener(Connection bazaDanych, Trener trener) throws SQLException {
        Statement statement = bazaDanych.createStatement();
        statement.executeUpdate("INSERT INTO `00018732_kk`.trenerzy (Data_rozpoczecia_kariery_trenerskiej, Data_zakonczenia_kariery_trenerskiej, Preferowana_formacja, ID_Osoby, ID_Trenowanej_Druzyny) VALUES ('" + trener.getDataRozpoczeciaKarieryTrenerskiej() + "', null, '" + trener.getPreferowanaFormacja() + "', "+ trener.getIDOsoby() + ", " + trener.getIDTrenowanejDruzyny() + ");");
    }

    public void wykonajInsertZawodnik(Connection bazaDanych, Zawodnik zawodnik) throws SQLException {
        Statement statement = bazaDanych.createStatement();
        statement.executeUpdate("INSERT INTO `00018732_kk`.zawodnicy (Data_rozpoczecia_kariery_pilkarskiej, Data_zakonczenia_kariery_pilkarskiej, Pozycja, ID_Osoby, ID_Druzyny) VALUES ('" + zawodnik.getDataRozpoczeciaKarieryPilkarskiej() + "', null, '" + zawodnik.getPozycja() + "', "+ zawodnik.getIdOsoby() + ", " + zawodnik.getIdDruzyny() + ");");
    }
}
