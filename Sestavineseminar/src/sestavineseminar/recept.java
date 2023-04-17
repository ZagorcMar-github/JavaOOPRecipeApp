/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sestavineseminar;

/**
 *
 * @author marti
 */
public class recept {
    private int id;
    private String naziv;
    private String opis;
    private int stSestavin;
    public recept(){}
    public recept(String naziv, String opis, int stSestavin){
        this.naziv=naziv;
        this.opis=opis;
        this.stSestavin=stSestavin;
    }
    public recept(int id,String naziv, String opis, int stSestavin){
        this(naziv,opis,stSestavin);
        this.id=id;
        
    }

    @Override
    public String toString() {
        return "recept{" + "id=" + id + ", naziv=" + naziv + ", opis=" + opis + ", stSestavin=" + stSestavin + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setStSestavin(int stSestavin) {
        this.stSestavin = stSestavin;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public int getStSestavin() {
        return stSestavin;
    }
}
