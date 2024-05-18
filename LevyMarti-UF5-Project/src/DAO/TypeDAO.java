package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Type;

public class TypeDAO extends BaseDAO{

    public TypeDAO(){
        this.connect();
    }

    public Type getType(int id) throws SQLException{
        PreparedStatement stmt;
        ResultSet rs;
        Type type = null;
        
        String query = "SELECT * FROM type WHERE type.id = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if(rs.next()){
            type = new Type();
            type.setId(rs.getInt("id"));
            type.setRole(rs.getString("role"));
            int typeID = rs.getInt("typeID");
            
        }

        return type;
    }
}