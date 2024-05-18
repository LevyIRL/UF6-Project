package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDUtil {

    public static void createDatabaseStructure() throws SQLException {
        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();

        PreparedStatement stmt;
        String query = null;
        int count = 0;
        
        query = "CREATE TABLE type "
                + "(id integer not null AUTO_INCREMENT, "
                + "role text, "
                + "PRIMARY KEY (id));";
                
        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
        
        query = "INSERT INTO type (role) VALUES (?);";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, "Marksmen");
        count = stmt.executeUpdate();
        stmt.close();
               
        query = "CREATE TABLE champion("
                + "code integer not null AUTO_INCREMENT, "
                + "name text, "
                + "shortDesc text, "
                + "winrate integer, "
                + "releaseDate date, "
                + "isRanged boolean, "
                + "price double, "
                + "typeID integer, "
                + "PRIMARY KEY (code), "
                + "FOREIGN KEY (typeID) "
                + "REFERENCES type (id) "
                + "ON DELETE SET NULL "
                + "ON UPDATE CASCADE)";

        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
        

        query = "INSERT INTO champion (name, shortDesc, winrate, releaseDate, isRanged, price, typeID) VALUES (?,?,?,?,?,?,?);";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, "Sion");
        stmt.setString(2, "A war hero from a bygone era, Sion was revered in Noxus for choking the life out of a Demacian king with his bare hands—but, denied oblivion, he was resurrected to serve his empire even in death. His indiscriminate slaughter claimed all who stood in his way, regardless of allegiance, proving he no longer retained his former humanity. Even so, with crude armor bolted onto rotten flesh, Sion continues to charge into battle with reckless abandon, struggling to remember his true self between the swings of his mighty axe.");
        stmt.setInt(3,50);
        stmt.setString(4,"2012-04-05");
        stmt.setBoolean(5, false);
        stmt.setDouble(6, 50.3);
        stmt.setInt(7, 1);
        count =+ stmt.executeUpdate();
        stmt.close();
    }
    
    public static void clearTables() {
        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();
        PreparedStatement stmt;
        try {
            String query = "delete from type";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            stmt = conn.prepareStatement("delete from champion");
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
