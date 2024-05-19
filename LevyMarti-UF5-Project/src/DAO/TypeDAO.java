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
        }

        return type;
    }

    public int insertType(Type item) throws SQLException{
        String query = "INSERT INTO type VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, item.getId());
        stmt.setString(2, item.getRole());

        int affectedRows = stmt.executeUpdate();

        stmt.close();
        return affectedRows;
    }

    public int deleteType(int id) throws SQLException{
        String query = "DELETE FROM type WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);

        stmt.setInt(1, id);

        int count = stmt.executeUpdate();

        stmt.close();
        return count;
    }

    public int updateType(Type item) throws SQLException{
        String query = "UPDATE type SET role = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, item.getRole());
        stmt.setInt(2, item.getId());
        int count = stmt.executeUpdate();
        stmt.close();
        return count;
    }
}