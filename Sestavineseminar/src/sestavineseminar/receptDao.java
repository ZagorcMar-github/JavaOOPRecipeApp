/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sestavineseminar;

import java.util.ArrayList;

/*
 public ArrayList<Nepremicnina> getAllNepremicnine();
    public Nepremicnina getNepremicninaById(int id);
    public void insertNepremicnina(Nepremicnina k);
    public void updateNepremicnina(Nepremicnina k);
    public void deleteNepremicnina(int id);
 */
public interface receptDao {

    public ArrayList<recept> getAllRecept();
    public recept getReceptByID(int id);

    public ArrayList<String> getAllSestavineRecepta(int idRecepta);

    public void insertRecept(recept r, ArrayList<sestavina> ses);

    public void updateRecept(recept r);

    public void deleteRecept(int id);

    public ArrayList<recept> getreceptBasedOnGiven(ArrayList<sestavina> ses);

}
