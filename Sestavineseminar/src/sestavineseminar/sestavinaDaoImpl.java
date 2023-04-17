/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sestavineseminar;

import java.sql.*;
import java.util.*;

/**
 *
 * @author marti
 */
public class sestavinaDaoImpl implements sestavinaDao {

    String dbURL = "jdbc:ucanaccess://C://Programi//dbTIS//BazaReceptov.accdb";

    @Override
    public void insertSestavina(sestavina s) {
        String sql, sql2;
        Connection conn;

        PreparedStatement pr1, pr2;

        try {

            conn = DriverManager.getConnection(dbURL);

            sql = "INSERT INTO sestavina (naziv) VALUES(?)";
            
            pr1 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pr1.setString(1, s.getNaziv());
            
            try ( ResultSet generatedKeys = pr1.getGeneratedKeys()) {
                if (generatedKeys.next()) {

                    s.setId(generatedKeys.getInt(1));
                }
            }
            pr1.executeUpdate();
            pr1.close();
            conn.close();

        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    @Override
    public ArrayList<sestavina> getAllsestavine() {
        ArrayList vseSestavine = new ArrayList();
        String sql, naziv;
        Connection conn;
        ResultSet rs;
        PreparedStatement pr1;

        int ids;

        try {

            conn = DriverManager.getConnection(dbURL);

            sql = "SELECT * FROM sestavina";
            pr1 = conn.prepareStatement(sql);

            rs = pr1.executeQuery();
            while (rs.next()) {
                ids = rs.getInt("id");
                naziv = rs.getString("naziv");
                

                sestavina rep = new sestavina(ids, naziv);
               vseSestavine.add(rep);
            }

            pr1.close();
            conn.close();
            rs.close();
        } catch (SQLException es) {
            es.printStackTrace();
        }
        return vseSestavine;
    
    }

}
