package main.java.com.magdezis.inversiones.magdeziss.dto.response;

/**
 *
 * @author dbarrientos
 */


public class LoginDtoResponse {
    
 
    private String name;
    private String lastname;
    private String passwordHash;
    private String rol;
    
    public LoginDtoResponse() {
        
    }

    public LoginDtoResponse(String name, String lastname, String passwordHash, String rol) {
        this.name = name;
        this.lastname = lastname;
        this.passwordHash = passwordHash;
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getRol() {
        return rol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
   
}
    

