package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDUtil {

    public static void createDatabaseStructure() throws SQLException {
        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();

        PreparedStatement stmt;
        String query = "CREATE TABLE type "
                + "(id integer not null AUTO_INCREMENT, "
                + "role text, "
                + "PRIMARY KEY (id))";

        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();

        query = "INSERT INTO type (id, role) VALUES (?,?)";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, 1);
        stmt.setString(2, "Tank");
        int count = stmt.executeUpdate();
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
                + "CONSTRAINT FOREIGN KEY fk_champion_type (typeID) REFERENCES type (id))";

        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();
    }
}
