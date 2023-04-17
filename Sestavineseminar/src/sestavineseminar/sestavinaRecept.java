/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sestavineseminar;

/**
 *
 * @author marti
 */
public class sestavinaRecept {
    private int idRecept;
    private int idSestavina;
    public sestavinaRecept(int idRecept,int idSestavina){
        this.idRecept=idRecept;
        this.idSestavina=idSestavina;
    }

    @Override
    public String toString() {
        return "sestavinaRecept{" + "idRecept=" + idRecept + ", idSestavina=" + idSestavina + '}';
    }

    public void setIdRecept(int idRecept) {
        this.idRecept = idRecept;
    }

    public void setIdSestavina(int idSestavina) {
        this.idSestavina = idSestavina;
    }

    public int getIdRecept() {
        return idRecept;
    }

    public int getIdSestavina() {
        return idSestavina;
    }
}
