package Encje;

import java.util.Date;

public class Sedzia {
    private int idSedziego;
    private int rokStartuKarieryMiedzynarodowej;
    private int idOsoby;
    private Date dataDebiutuLigowego;
    private Date dataZakonczeniaKarierySedziowskiej;
    private int pinSedziego;

    public Sedzia(int rokStartuKarieryMiedzynarodowej, int idOsoby, Date dataDebiutuLigowego, int pinSedziego) {
        this.rokStartuKarieryMiedzynarodowej = rokStartuKarieryMiedzynarodowej;
        this.idOsoby = idOsoby;
        this.dataDebiutuLigowego = dataDebiutuLigowego;
        this.pinSedziego = pinSedziego;
    }

    public int getIdSedziego() {
        return idSedziego;
    }

    public void setIdSedziego(int idSedziego) {
        this.idSedziego = idSedziego;
    }

    public int getRokStartuKarieryMiedzynarodowej() {
        return rokStartuKarieryMiedzynarodowej;
    }

    public void setRokStartuKarieryMiedzynarodowej(int rokStartuKarieryMiedzynarodowej) {
        this.rokStartuKarieryMiedzynarodowej = rokStartuKarieryMiedzynarodowej;
    }

    public int getIdOsoby() {
        return idOsoby;
    }

    public void setIdOsoby(int idOsoby) {
        this.idOsoby = idOsoby;
    }

    public Date getDataDebiutuLigowego() {
        return dataDebiutuLigowego;
    }

    public void setDataDebiutuLigowego(Date dataDebiutuLigowego) {
        this.dataDebiutuLigowego = dataDebiutuLigowego;
    }

    public Date getDataZakonczeniaKarierySedziowskiej() {
        return dataZakonczeniaKarierySedziowskiej;
    }

    public void setDataZakonczeniaKarierySedziowskiej(Date dataZakonczeniaKarierySedziowskiej) {
        this.dataZakonczeniaKarierySedziowskiej = dataZakonczeniaKarierySedziowskiej;
    }

    public int getPinSedziego() {
        return pinSedziego;
    }

    public void setPinSedziego(int pinSedziego) {
        this.pinSedziego = pinSedziego;
    }
}
