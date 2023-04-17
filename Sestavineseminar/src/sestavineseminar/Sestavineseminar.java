/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sestavineseminar;

import java.util.*;

/*
  ArrayList<Pokrajina> Vse =new ArrayList();
       PokrajinaDaoImpl pokrajinaDao=new PokrajinaDaoImpl();
       Pokrajina neki =new Pokrajina();
       Vse= pokrajinaDao.getAllPokrajine();
       for(int i=0;i<Vse.size();i++){
           System.out.println(Vse.get(i).toString());
       }
      neki=pokrajinaDao.getPokrajinaByid(1);
      System.out.println(neki.toString());
 */
public class Sestavineseminar {
    public static void main(String args[]){
    ArrayList <recept> recepti = new ArrayList();
    ArrayList <String> sestavinea = new ArrayList();
    ArrayList <sestavina> sestavine = new ArrayList();
    sestavina sestavina1 = new sestavina (1,"mezga");
    sestavina sestavina2 = new sestavina (2,"riz");
    sestavina sestavina3 = new sestavina (14,"piscanec");
    sestavina sestavina4 = new sestavina (90,"kruh");
    sestavina sestavina5 = new sestavina (70,"spageti");
    sestavina sestavina6 = new sestavina (1000,"cesen");
    sestavina sestavina7 = new sestavina (10200,"cebula");
    recept recept1  = new recept("rizoto Chikan","skuhi ma nemoj",3);
    sestavine.add(sestavina2);
    sestavine.add(sestavina1);
    sestavine.add(sestavina3);
    sestavine.add(sestavina4);
    sestavine.add(sestavina5);
    sestavine.add(sestavina6);
    sestavine.add(sestavina7);
    
    receptDaoImpl impl =new  receptDaoImpl();
    //impl.getreceptBasedOnGiven(sestavine);
    //impl.insertRecept(recept1, sestavine);
   //impl.deleteRecept(   17);
    
    
    System.out.println("_______________");
    //recepti = impl.getAllRecept();
    
    /*
    sestavinea = impl.getAllSestavineRecepta(1);

    sestavinea.forEach((action)->System.out.println(action));
            
    recepti.forEach((action)->System.out.println(action.toString()));
    */
    recepti=impl.getreceptBasedOnGiven(sestavine);
    recepti.forEach((action)->System.out.println(action.toString()));
}
}