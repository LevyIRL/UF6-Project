package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Champion;
import model.Type;

public class ChampionDAO extends BaseDAO {

    public ChampionDAO() {
        this.connect();
    }

    public Champion getChampion(int code) throws SQLException {
        PreparedStatement stmt;
        ResultSet rs;
        Champion champ = null;

        String query = "SELECT * FROM champion WHERE champion.code = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, code);
        rs = stmt.executeQuery();

        if (rs.next()) {
            champ = new Champion();
            champ.setCode(rs.getInt("code"));
            champ.setName(rs.getString("name"));
            champ.setShortDesc(rs.getString("shortDesc"));
            champ.setWinrate(rs.getInt("winrate"));
            champ.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
            champ.setRanged(rs.getBoolean("isRanged"));
            champ.setPrice(rs.getDouble("price"));
            int typeID = rs.getInt("typeID");
            TypeDAO tpDao = new TypeDAO();
            Type type = tpDao.getType(typeID);
            champ.setType(type);
        }

        return champ;
    }

    public int insertChampion(Champion item) throws SQLException {
        TypeDAO tpDao = new TypeDAO();
        int affectedRows = 0;

        String query = "INSERT INTO champion (code, name, shortDesc, winrate, releaseDate, isRanged, price, typeID) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(query);

        if (tpDao.getType(item.getType().getId()) == null) {
            System.out.println("This type doesn't exist.");
            stmt.setNull(8, 0);
        } else {
            stmt.setInt(1, item.getCode());
            stmt.setString(2, item.getName());
            stmt.setString(3, item.getShortDesc());
            stmt.setInt(4, item.getWinrate());
            stmt.setDate(5, Date.valueOf(item.getReleaseDate()));
            stmt.setBoolean(6, item.isRanged());
            stmt.setDouble(7, item.getPrice());
            stmt.setInt(8, item.getType().getId());
            affectedRows = stmt.executeUpdate();
        }

        stmt.close();
        return affectedRows;
    }

    public int deleteChamp(int code) throws SQLException {
        int count = 0;
        if (getChampion(code) == null) {
            System.out.println("This champion doesn't exist.");
        } else {
            String query = "DELETE FROM champion WHERE code = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setInt(1, code);

            count = stmt.executeUpdate();

            stmt.close();
        }
        return count;
    }

    public int updateChamp(Champion item) throws SQLException {
        TypeDAO tpDao = new TypeDAO();
        int count = 0;

        if (getChampion(item.getCode()) == null) {
            System.out.println("This champion doesn't exist.");
        } else if(tpDao.getType(item.getType().getId()) == null){
            System.out.println("This type doesn't exist.");
        }
        else{
            String query = "UPDATE champion SET name = ?, shortDesc = ?, winrate = ?, releaseDate = ?, isRanged = ?, price = ?, typeID = ? WHERE code = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, item.getName());
            stmt.setString(2, item.getShortDesc());
            stmt.setInt(3, item.getWinrate());
            stmt.setDate(4, Date.valueOf(item.getReleaseDate()));
            stmt.setBoolean(5, item.isRanged());
            stmt.setDouble(6, item.getPrice());
            stmt.setInt(7, item.getType().getId());
            stmt.setInt(8, item.getCode());

            count = stmt.executeUpdate();
            stmt.close();
        }
        return count;
    }

    public int showChamps() throws SQLException {
        PreparedStatement stmt;
        ResultSet rs;
        int count = 0;
        Champion champ = null;

        String query = "SELECT * FROM champion ORDER BY code";
        stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery();
        System.out.println("== ALL CHAMPIONS LIST ==");
        while (rs.next()) {
            System.out.println("================================");
            champ = new Champion();
            champ.setCode(rs.getInt("code"));
            champ.setName(rs.getString("name"));
            champ.setShortDesc(rs.getString("shortDesc"));
            champ.setWinrate(rs.getInt("winrate"));
            champ.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
            champ.setRanged(rs.getBoolean("isRanged"));
            champ.setPrice(rs.getDouble("price"));
            int typeID = rs.getInt("typeID");
            TypeDAO tpDao = new TypeDAO();
            Type type = tpDao.getType(typeID);
            champ.setType(type);
            champ.showChamp();
            System.out.println("");
            count++;
        }

        return count;
    }

    public int showChampsByType(Type filter) throws SQLException {
        PreparedStatement stmt;
        ResultSet rs;
        int count = 0;
        Champion champ = null;

        String query = "SELECT * FROM champion WHERE typeID = ? ORDER BY code";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, filter.getId());
        rs = stmt.executeQuery();
        System.out.println("== " + filter.getRole() + " champions ==");
        while (rs.next()) {
            System.out.println("================================");
            champ = new Champion();
            champ.setCode(rs.getInt("code"));
            champ.setName(rs.getString("name"));
            champ.setShortDesc(rs.getString("shortDesc"));
            champ.setWinrate(rs.getInt("winrate"));
            champ.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
            champ.setRanged(rs.getBoolean("isRanged"));
            champ.setPrice(rs.getDouble("price"));
            int typeID = rs.getInt("typeID");
            TypeDAO tpDao = new TypeDAO();
            Type type = tpDao.getType(typeID);
            champ.setType(type);
            champ.showChamp();
            System.out.println("");
            count++;
        }
        stmt.close();

        return count;
    }

    public void getPriceByType() throws SQLException {
        TypeDAO tpDao = new TypeDAO();
        PreparedStatement stmt;
        ResultSet rs;

        String query = "select TypeID, sum(price) " +
                "from champion " +
                "group by TypeID " +
                "order by TypeID";

        stmt = conn.prepareStatement(query);
        rs = stmt.executeQuery();
        System.out.println("== TOTAL PRICE OF CHAMPIONS PER CHAMPION TYPE ==");
        while (rs.next()) {
            System.out.println("================================");
            System.out.println(tpDao.getType(rs.getInt("TypeID")).getRole() + ": " + rs.getDouble("sum(price)"));
        }
        stmt.close();
    }
}