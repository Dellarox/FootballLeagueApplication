package Administrator;

import java.sql.Date;

public class Osoba {

    private int idOsoby;
    private String imie;
    private String nazwisko;
    private Date dataUrodzenia;
    private String narodowosc;
    private String rola;

    public Osoba(String imie, String nazwisko, Date dataUrodzenia, String narodowosc, String rola)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.dataUrodzenia=dataUrodzenia;
        this.narodowosc=narodowosc;
        this.rola=rola;
    }

    public int getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(int idOsoby) {
        this.idOsoby = idOsoby;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Date getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(Date dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }

    public String getRola() {
        return rola;
    }

    public void setRola(String rola) {
        this.rola = rola;
    }
}
