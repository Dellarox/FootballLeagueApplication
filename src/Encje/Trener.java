package Encje;

import java.util.Date;

public class Trener {

    private int IDTrenera;
    private Date dataRozpoczeciaKarieryTrenerskiej;
    private Date dataZakonczeniaKarieryTrenerskiej;
    private String preferowanaFormacja;
    private int IDOsoby;
    private int IDTrenowanejDruzyny;

    public Trener(Date dataRozpoczeciaKarieryTrenerskiej, Date dataZakonczeniaKarieryTrenerskiej, String preferowanaFormacja, int IDOsoby, int IDTrenowanejDruzyny) {
        this.dataRozpoczeciaKarieryTrenerskiej = dataRozpoczeciaKarieryTrenerskiej;
        this.dataZakonczeniaKarieryTrenerskiej = dataZakonczeniaKarieryTrenerskiej;
        this.preferowanaFormacja = preferowanaFormacja;
        this.IDOsoby = IDOsoby;
        this.IDTrenowanejDruzyny = IDTrenowanejDruzyny;
    }

    public int getIDTrenera() {
        return IDTrenera;
    }

    public void setIDTrenera(int IDTrenera) {
        this.IDTrenera = IDTrenera;
    }

    public Date getDataRozpoczeciaKarieryTrenerskiej() {
        return dataRozpoczeciaKarieryTrenerskiej;
    }

    public void setDataRozpoczeciaKarieryTrenerskiej(Date dataRozpoczeciaKarieryTrenerskiej) {
        this.dataRozpoczeciaKarieryTrenerskiej = dataRozpoczeciaKarieryTrenerskiej;
    }

    public Date getDataZakonczeniaKarieryTrenerskiej() {
        return dataZakonczeniaKarieryTrenerskiej;
    }

    public void setDataZakonczeniaKarieryTrenerskiej(Date dataZakonczeniaKarieryTrenerskiej) {
        this.dataZakonczeniaKarieryTrenerskiej = dataZakonczeniaKarieryTrenerskiej;
    }

    public String getPreferowanaFormacja() {
        return preferowanaFormacja;
    }

    public void setPreferowanaFormacja(String preferowanaFormacja) {
        this.preferowanaFormacja = preferowanaFormacja;
    }

    public int getIDOsoby() {
        return IDOsoby;
    }

    public void setIDOsoby(int IDOsoby) {
        this.IDOsoby = IDOsoby;
    }

    public int getIDTrenowanejDruzyny() {
        return IDTrenowanejDruzyny;
    }

    public void setIDTrenowanejDruzyny(int IDTrenowanejDruzyny) {
        this.IDTrenowanejDruzyny = IDTrenowanejDruzyny;
    }
}
