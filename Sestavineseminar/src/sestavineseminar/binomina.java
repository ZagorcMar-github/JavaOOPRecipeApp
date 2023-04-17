/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sestavineseminar;

/**
 *
 * @author marti
 */
public class binomina {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // 
       double rez=0;
       double c=31;
       
        
        for(double r=2; r<=39;r++){ 
           rez += fact(39)/(fact(r) *fact (39-r));
            System.out.println(rez);
       }
        System.out.println(rez);
        
        
        
    }
    public static double fact (double n){
        double rez =1;
        for (double i=n;i>0;i--){
            rez *= i;
        }
        return rez;
    }
}
