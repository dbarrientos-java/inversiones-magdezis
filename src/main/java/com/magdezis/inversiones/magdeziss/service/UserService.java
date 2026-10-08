package main.java.com.magdezis.inversiones.magdeziss.service;

import main.java.com.magdezis.inversiones.magdeziss.dto.request.LoginDtoRequest;
import main.java.com.magdezis.inversiones.magdeziss.dto.response.LoginDtoResponse;
import main.java.com.magdezis.inversiones.magdeziss.model.User;
import main.java.com.magdezis.inversiones.magdeziss.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author dbarrientos
 */


public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository authRepository){
        this.userRepository = authRepository;
    }
    
    public LoginDtoResponse login(LoginDtoRequest request){
        if(request == null){
            throw new RuntimeException("Los datos están vacíos");
        }else if (request.getEmail() == null || request.getPassword() == null){
            throw new RuntimeException("Se encontraron campos vacíos");
        }else if (request.getEmail().isEmpty() || request.getPassword().isEmpty()){
            throw new RuntimeException("No pueden existir campos en blanco");
        }
        LoginDtoResponse response = userRepository.findUserByEmail(request);
        
        if(response == null){
            System.out.println("No se encontró el usuario");
        }
        
        if(response.getPasswordHash() == null){
            throw new RuntimeException("No se logró concretar la operación");
        }else{
            if(BCrypt.checkpw(request.getPassword(), response.getPasswordHash())){
                return response;
            }
        }
        return null;
    }
    
        public boolean makeNewUser(User user) {
           boolean registro;
        String hashContrasena = BCrypt.hashpw(user.getPassword_hash(), BCrypt.gensalt(12));
        User userARegistrar = new User();
        userARegistrar.setId_user(user.getId_user());
        userARegistrar.setName(user.getName());
        userARegistrar.setLastname(user.getLastname());
        userARegistrar.setEmail(user.getEmail());
        userARegistrar.setPassword_hash(hashContrasena);
        userARegistrar.setId_rol(user.getId_rol());
        registro = userRepository.save(user);
        return registro;
    }
}

