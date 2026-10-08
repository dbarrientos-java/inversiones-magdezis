package main.java.com.magdezis.inversiones.magdeziss.model;

/**
 *
 * @author dbarrientos
 */
public class User {
    
    private String id_user;
    private String name;
    private String lastname;
    private String email;
    private String password_hash;
    private String id_rol;
    private String rol;

    
    public User(){
        
    }

    public User(String name, String lastname, String email, String password_hash, String id_rol, String rol) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password_hash = password_hash;
        this.id_rol = id_rol;
        this.rol = rol;
    }
    

    public String getId_user() {
        return id_user;
    }
    

    public String getName() {
        return name;
    }
    

    public String getLastname() {
        return lastname;
    }
    

    public String getEmail() {
        return email;
    }
    

    public String getPassword_hash() {
        return password_hash;
    }

    
    public String getId_rol() {
        return id_rol;
    }
    

    public String getRol() {
        return rol;
    }
    

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
    

    public void setName(String name) {
        this.name = name;
    }
    

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    

    public void setEmail(String email) {
        this.email = email;
    }
    

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
    

    public void setId_rol(String id_rol) {
        this.id_rol = id_rol;
    }

    
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
