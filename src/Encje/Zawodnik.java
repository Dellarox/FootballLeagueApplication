package Encje;

import java.util.Date;

public class Zawodnik {
    private int idZawodnika;
    private Date dataRozpoczeciaKarieryPilkarskiej;
    private Date dataZakonczeniaKarieryPilkarskiej;
    private String pozycja;
    private int idOsoby;
    private int idDruzyny;

    public Zawodnik(Date dataRozpoczeciaKarieryPilkarskiej, Date dataZakonczeniaKarieryPilkarskiej, String pozycja, int idOsoby, int idDruzyny){
        this.dataRozpoczeciaKarieryPilkarskiej = dataRozpoczeciaKarieryPilkarskiej;
        this.dataZakonczeniaKarieryPilkarskiej = dataZakonczeniaKarieryPilkarskiej;
        this.pozycja = pozycja;
        this.idOsoby = idOsoby;
        this.idDruzyny = idDruzyny;
    }

    public int getIdZawodnika() {
        return idZawodnika;
    }

    public void setIdZawodnika(int idZawodnika) {
        this.idZawodnika = idZawodnika;
    }

    public Date getDataRozpoczeciaKarieryPilkarskiej() {
        return dataRozpoczeciaKarieryPilkarskiej;
    }

    public void setDataRozpoczeciaKarieryPilkarskiej(Date dataRozpoczeciaKarieryPilkarskiej) {
        this.dataRozpoczeciaKarieryPilkarskiej = dataRozpoczeciaKarieryPilkarskiej;
    }

    public Date getDataZakonczeniaKarieryPilkarskiej() {
        return dataZakonczeniaKarieryPilkarskiej;
    }

    public void setDataZakonczeniaKarieryPilkarskiej(Date dataZakonczeniaKarieryPilkarskiej) {
        this.dataZakonczeniaKarieryPilkarskiej = dataZakonczeniaKarieryPilkarskiej;
    }

    public String getPozycja() {
        return pozycja;
    }

    public void setPozycja(String pozycja) {
        this.pozycja = pozycja;
    }

    public int getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(int idOsoby) {
        this.idOsoby = idOsoby;
    }

    public int getIdDruzyny() {
        return idDruzyny;
    }

    public void setIdDruzyny(int idDruzyny) {
        this.idDruzyny = idDruzyny;
    }
}
