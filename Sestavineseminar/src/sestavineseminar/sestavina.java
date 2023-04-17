/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sestavineseminar;

/**
 *
 * @author marti
 */
public class sestavina {
    private String naziv;
    private int id;
    public sestavina(){}
    public sestavina(String naziv){
    this.naziv=naziv;
    }public sestavina (int id,String naziv){
        this(naziv);
        this.id=id;
        
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getId() {
        return id;
    }
}
