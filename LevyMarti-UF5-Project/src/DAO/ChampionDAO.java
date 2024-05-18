package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Champion;

public class ChampionDAO extends BaseDAO{
    
    public ChampionDAO(){
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

        if(rs.next()){
            champ = new Champion();
            champ.setCode(rs.getInt("code"));
            champ.setName(rs.getString("name"));
            champ.setShortDesc(rs.getString("shortDesc"));
            champ.setWinrate(rs.getInt("winrate"));
            champ.setReleaseDate(rs.getDate("releaseDate").toLocalDate());
            champ.setRanged(rs.getBoolean("isRanged"));
            champ.setPrice(rs.getDouble("price"));
            int typeID = rs.getInt("typeID");
            
        }
        
        return champ;
    }
}