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
public class receptDaoImpl implements receptDao {

    String dbURL = "jdbc:ucanaccess://C://Programi//dbTIS//BazaReceptov.accdb";
    private int id;

    @Override
    public ArrayList<recept> getAllRecept() {
        ArrayList vsiRecepti = new ArrayList();
        String sql, naziv, opis;
        Connection conn;
        ResultSet rs;
        PreparedStatement pr1;

        int ids, stSestavin;

        try {

            conn = DriverManager.getConnection(dbURL);

            sql = "SELECT * FROM recept";
            pr1 = conn.prepareStatement(sql);

            rs = pr1.executeQuery();
            while (rs.next()) {
                ids = rs.getInt("id");
                naziv = rs.getString("naziv");
                opis = rs.getString("opis");
                stSestavin = rs.getInt("stSestavin");

                recept rep = new recept(ids, naziv, opis, stSestavin);
                vsiRecepti.add(rep);
            }

            pr1.close();
            conn.close();
            rs.close();
        } catch (SQLException es) {
            es.printStackTrace();
        }
        return vsiRecepti;
    }

    @Override
    public ArrayList<String> getAllSestavineRecepta(int idRecepta) {
        ArrayList vseSestavine = new ArrayList();
        String sql, vrstica;
        Connection conn;
        ResultSet rs;
        PreparedStatement pr1;

        try {

            conn = DriverManager.getConnection(dbURL);

            sql = "SELECT s.naziv FROM sestavina AS s INNER JOIN sestavinaRecepta AS sr ON sr.id_sestavina = s.id WHERE id_recept = ?";
            pr1 = conn.prepareStatement(sql);
            pr1.setInt(1, idRecepta);
            rs = pr1.executeQuery();
            while (rs.next()) {

                vrstica = rs.getString("naziv");
                vseSestavine.add(vrstica);
            }

            pr1.close();
            conn.close();
            rs.close();
        } catch (SQLException es) {
            es.printStackTrace();
        }
        return vseSestavine;

    }

    @Override
    public void insertRecept(recept r, ArrayList<sestavina> ses) {

        String sql, sql2;
        Connection conn;

        PreparedStatement pr1, pr2;

        try {

            conn = DriverManager.getConnection(dbURL);

            sql = "INSERT INTO recept (naziv,opis,stSestavin) VALUES(?, ?, ?)";

            pr1 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pr1.setString(1, r.getNaziv());
            pr1.setString(2, r.getOpis());
            pr1.setInt(3, r.getStSestavin());

            int affectedRows = pr1.executeUpdate();
            if (affectedRows == 0) {
            }

            try ( ResultSet generatedKeys = pr1.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                    r.setId(generatedKeys.getInt(1));
                }
            }

            pr1.close();

            sql2 = "INSERT INTO sestavinaRecepta (id_recept,id_sestavina) VALUES (?,?)";
            pr2 = conn.prepareStatement(sql2);

            for (sestavina sest : ses) {
                pr2.setInt(1, id);
                pr2.setInt(2, sest.getId());
                pr2.executeUpdate();

            }
            pr2.close();
            conn.close();

            // lahko dam preverjanje če dane sestavine obsajajo
        } catch (SQLException es) {
            es.printStackTrace();
        }

    }

    @Override
    public void updateRecept(recept r) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteRecept(int id) {

        String sql, sql2;
        PreparedStatement pr1, pr2;
        Connection conn;

        try {

            conn = DriverManager.getConnection(dbURL);

            sql = " DELETE FROM sestavinaRecepta WHERE id_recept=?";
            pr1 = conn.prepareStatement(sql);
            pr1.setInt(1, id);
            pr1.executeUpdate();
            pr1.close();

            sql2 = " DELETE FROM recept WHERE ID=?";
            pr2 = conn.prepareStatement(sql2);
            pr2.setInt(1, id);
            pr2.executeUpdate();
            pr2.close();

            conn.close();
        } catch (SQLException es) {
            es.printStackTrace();
        }
    }

    @Override
    public ArrayList<recept> getreceptBasedOnGiven(ArrayList<sestavina> ses) {
        String sql, naseSestavinevp = "";
        PreparedStatement pr1;
        ResultSet rs;
        Connection conn;
        String naziv, opis;
        ArrayList<recept> recepti = new ArrayList();
        int idRecepta, stSestavin;
        int numElements = ses.size();
        int counter = 0;
        int counter2 = 0;
        for (sestavina sest : ses) {
            naseSestavinevp += "?";
            counter++;
            if (counter < numElements) {
                naseSestavinevp += ",";
            }
        }
        sql = """
              SELECT prr.id,  prr.naziv, prr.opis, prr.stSestavin 
             FROM recept AS prr INNER JOIN (SELECT niz, COUNT (stevilo) AS stSestavin FROM (
             SELECT r.naziv AS niz, s.naziv AS stevilo FROM (recept AS r INNER JOIN sestavinaRecepta AS sr ON sr.id_recept=r.ID) INNER JOIN sestavina AS s ON s.ID = sr.id_sestavina 
             WHERE s.naziv IN (""" + naseSestavinevp + ") GROUP BY r.naziv, s.naziv)  AS X GROUP BY niz)  AS ktr ON (ktr.stSestavin = prr.stSestavin) AND (ktr.niz = prr.naziv);";

        try {
            conn = DriverManager.getConnection(dbURL);
            pr1 = conn.prepareStatement(sql);
            for (sestavina sest : ses) {
                pr1.setString(counter2 + 1, sest.getNaziv());
                counter2++;
            }
            /*System.out.println("__________________");
            System.out.println(sql);*/
            rs = pr1.executeQuery();
            while (rs.next()) {
                idRecepta = rs.getInt("id");
                naziv = rs.getString("naziv");
                opis = rs.getString("opis");
                stSestavin = rs.getInt("stSestavin");
                recept novi = new recept(idRecepta, naziv, opis, stSestavin);

                recepti.add(novi);
            }
            pr1.close();
            conn.close();
        } catch (SQLException es) {
            es.printStackTrace();
        }
        return recepti;
    }

    @Override
    public recept getReceptByID(int id) {
        String sql, naziv, opis;
        Connection conn;
        ResultSet rs;
        PreparedStatement pr1;
        recept recept1 = new recept();
        int id2, stSestavin;

        try {
            sql = "Select * FROM recept WHERE id=?";
            conn = DriverManager.getConnection(dbURL);

            pr1 = conn.prepareStatement(sql);
            pr1.setInt(1, id);
            rs = pr1.executeQuery();
            if (rs.next()) {
                id2 = rs.getInt("id");
                naziv = rs.getString("naziv");
                opis = rs.getString("opis");
                stSestavin = rs.getInt("stSestavin");
                recept1.setId(id2);
                recept1.setNaziv(naziv);
                recept1.setOpis(opis);
                recept1.setStSestavin(stSestavin);

            }
            pr1.close();
            conn.close();
            rs.close();
        } catch (SQLException es) {
            es.printStackTrace();
        }
        return recept1;
    }
}
