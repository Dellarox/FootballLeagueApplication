package Encje;

import java.util.Date;

public class Mecz {

    private int idMeczu;
    private String gospodarze;
    private String goscie;
    private Date dataMeczu;
    private int numerKolejki;
    private int idSedziego;
    private int idDruzynyWygranej;

    public Mecz(String gospodarze, String goscie, Date dataMeczu, int numerKolejki, int idSedziego) {
        this.gospodarze = gospodarze;
        this.goscie = goscie;
        this.dataMeczu = dataMeczu;
        this.numerKolejki = numerKolejki;
        this.idSedziego = idSedziego;
    }

    public int getIdMeczu() {
        return idMeczu;
    }

    public void setIdMeczu(int idMeczu) {
        this.idMeczu = idMeczu;
    }

    public String getGospodarze() {
        return gospodarze;
    }

    public void setGospodarze(String gospodarze) {
        this.gospodarze = gospodarze;
    }

    public String getGoscie() {
        return goscie;
    }

    public void setGoscie(String goscie) {
        this.goscie = goscie;
    }

    public Date getDataMeczu() {
        return dataMeczu;
    }

    public void setDataMeczu(Date dataMeczu) {
        this.dataMeczu = dataMeczu;
    }

    public int getNumerKolejki() {
        return numerKolejki;
    }

    public void setNumerKolejki(int numerKolejki) {
        this.numerKolejki = numerKolejki;
    }

    public int getIdSedziego() {
        return idSedziego;
    }

    public void setIdSedziego(int idSedziego) {
        this.idSedziego = idSedziego;
    }

    public int getIdDruzynyWygranej() {
        return idDruzynyWygranej;
    }

    public void setIdDruzynyWygranej(int idDruzynyWygranej) {
        this.idDruzynyWygranej = idDruzynyWygranej;
    }
}
