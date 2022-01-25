package Administrator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Uzytkownik {

    private int idUzytkownika;
    private String pseudonim;
    private Date dataZalozeniaKonta = new Date();
    private int idUlubionejDruzyny;
    private String haslo;

    public Uzytkownik(String pseudonim, Date dataZalozeniaKonta, int idUlubionejDruzyny, String haslo) {
        this.pseudonim = pseudonim;
        this.dataZalozeniaKonta = dataZalozeniaKonta;
        this.idUlubionejDruzyny = idUlubionejDruzyny;
        this.haslo = haslo;
    }

    public int getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(int idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getPseudonim() {
        return pseudonim;
    }

    public void setPseudonim(String pseudonim) {
        this.pseudonim = pseudonim;
    }

    public Date getDataZalozeniaKonta() {
        return dataZalozeniaKonta;
    }

    public void setDataZalozeniaKonta(Date dataZalozeniaKonta) {
        this.dataZalozeniaKonta = dataZalozeniaKonta;
    }

    public int getIdUlubionejDruzyny() {
        return idUlubionejDruzyny;
    }

    public void setIdUlubionejDruzyny(int idUlubionejDruzyny) {
        this.idUlubionejDruzyny = idUlubionejDruzyny;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
