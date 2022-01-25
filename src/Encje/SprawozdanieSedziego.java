package Encje;

public class SprawozdanieSedziego {

    private int ID_Sprawozdania;
    private int Ilosc_zoltych_kartek;
    private int Ilosc_czerwonych_kartek;
    private int Ilosc_goli_gospodarzy;
    private int Ilosc_goli_gosci;
    private int ID_Meczu;
    private int ID_Sedziego;

    public SprawozdanieSedziego(int ilosc_zoltych_kartek, int ilosc_czerwonych_kartek, int ilosc_goli_gospodarzy, int ilosc_goli_gosci,int ID_Meczu, int ID_Sedziego) {
        this.Ilosc_zoltych_kartek = ilosc_zoltych_kartek;
        this.Ilosc_czerwonych_kartek = ilosc_czerwonych_kartek;
        this.Ilosc_goli_gospodarzy = ilosc_goli_gospodarzy;
        this.Ilosc_goli_gosci = ilosc_goli_gosci;
        this.ID_Meczu=ID_Meczu;
        this.ID_Sedziego=ID_Sedziego;
    }

    public int getID_Sprawozdania() {
        return ID_Sprawozdania;
    }

    public void setID_Sprawozdania(int ID_Sprawozdania) {
        this.ID_Sprawozdania = ID_Sprawozdania;
    }

    public int getIlosc_zoltych_kartek() {
        return Ilosc_zoltych_kartek;
    }

    public void setIlosc_zoltych_kartek(int ilosc_zoltych_kartek) {
        Ilosc_zoltych_kartek = ilosc_zoltych_kartek;
    }

    public int getIlosc_czerwonych_kartek() {
        return Ilosc_czerwonych_kartek;
    }

    public void setIlosc_czerwonych_kartek(int ilosc_czerwonych_kartek) {
        Ilosc_czerwonych_kartek = ilosc_czerwonych_kartek;
    }

    public int getIlosc_goli_gospodarzy() {
        return Ilosc_goli_gospodarzy;
    }

    public void setIlosc_goli_gospodarzy(int ilosc_goli_gospodarzy) {
        Ilosc_goli_gospodarzy = ilosc_goli_gospodarzy;
    }

    public int getIlosc_goli_gosci() {
        return Ilosc_goli_gosci;
    }

    public void setIlosc_goli_gosci(int ilosc_goli_gosci) {
        Ilosc_goli_gosci = ilosc_goli_gosci;
    }

    public int getID_Meczu() {
        return ID_Meczu;
    }

    public void setID_Meczu(int ID_Meczu) {
        this.ID_Meczu = ID_Meczu;
    }

    public int getID_Sedziego() {
        return ID_Sedziego;
    }

    public void setID_Sedziego(int ID_Sedziego) {
        this.ID_Sedziego = ID_Sedziego;
    }
}
