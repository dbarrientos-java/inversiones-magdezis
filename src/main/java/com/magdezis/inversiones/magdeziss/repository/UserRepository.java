package main.java.com.magdezis.inversiones.magdeziss.repository;

import main.java.com.magdezis.inversiones.magdeziss.config.DataBaseConnection;
import main.java.com.magdezis.inversiones.magdeziss.dto.request.LoginDtoRequest;
import main.java.com.magdezis.inversiones.magdeziss.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.com.magdezis.inversiones.magdeziss.dto.response.LoginDtoResponse;

/**
 *
 * @author dbarrientos
 */

public class UserRepository {
    
    
    private Boolean estado = false;
    
    public LoginDtoResponse findUserByEmail(LoginDtoRequest request){
        
        String sql = "select u.nombre, u.apellido, u.contrasena_hash, r.nombre_rol\n" +
                           "from usuarios as u\n" +
                           "inner join roles as r\n" +
                           "on u.id_rol = r.id_rol\n" +
                           "where  u.email = ? ";
        
        try(PreparedStatement ps = DataBaseConnection.getDBConnection().prepareStatement(sql)){
            ps.setString(1, request.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return new LoginDtoResponse(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("contrasena_hash"),
                        rs.getString("nombre_rol")
                );
            }
        }catch(SQLException e){
            System.out.println("Error al buscar en la base de datos" + e.getMessage());
        }
        return null;
    }
    
     public boolean save(User user){
        
        String sql = "INSERT INTO usuarios (id_user, name, lastname, email, password_hash, id_rol) VALUES (?, ?, ?, ?, ?, ?);";
        
        try(PreparedStatement pstm = DataBaseConnection.getDBConnection().prepareStatement(sql)){
            
            pstm.setString(1, user.getId_user());
            pstm.setString(2, user.getName());
            pstm.setString(3, user.getLastname());
            pstm.setString(4, user.getEmail());
            pstm.setString(5, user.getPassword_hash());
            pstm.setString(6, user.getId_rol());
            pstm.execute();
            
            estado = true;
            
        }catch(SQLException e){
            
            System.out.println("Error al registrar usuario " + e.getMessage());
            
        }
        
        return estado;
    }
    

    
}

    



    



