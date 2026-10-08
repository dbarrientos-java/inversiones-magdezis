package main.java.com.magdezis.inversiones.magdeziss.controller;

import java.util.UUID;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.java.com.magdezis.inversiones.magdeziss.model.User;
import main.java.com.magdezis.inversiones.magdeziss.service.UserService;
import main.java.com.magdezis.inversiones.magdeziss.util.SceneManager;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author dbarrientos
 */

public class RegisterController {

    private UserService userService;
    private SceneManager sceneManager;
    
        public RegisterController( UserService userService, SceneManager sceneManager){
          
            this.userService = userService;
            this.sceneManager = sceneManager;
        }
     
     @FXML
     private TextField txtNombre;
     @FXML
     private TextField txtApellido;
     @FXML
     private TextField txtEmail;
     @FXML
     private PasswordField txtContrasena;
     @FXML
     private TextField txtId_rol;
     @FXML
     private Button btnRegistrarse;
     @FXML
     private Button btnRegresar;
     
     public void registerUser(){
         boolean registro;
        if(txtNombre.getText().isBlank() || txtNombre.getText().isEmpty() ||
        txtApellido.getText().isBlank() || txtApellido.getText().isEmpty() ||
        txtEmail.getText().isBlank() || txtEmail.getText().isEmpty() ||
        txtContrasena.getText().isBlank() || txtContrasena.getText().isEmpty() ||
        txtId_rol.getText().isBlank() || txtId_rol.getText().isEmpty()){
            sceneManager.showAlertInfo("Campos vacios", "Verificar campos", "No se ha podido registrar el usuario", Alert.AlertType.ERROR);
        }else{
        try{ 
        String contrasena_hash = BCrypt.hashpw(txtContrasena.getText(), BCrypt.gensalt(12));
        User user = new User();
        user.setId_user(UUID.randomUUID().toString());
        user.setName(txtNombre.getText());
        user.setLastname(txtApellido.getText());
        user.setEmail(txtEmail.getText());
        user.setPassword_hash(contrasena_hash);
        user.setId_rol(txtId_rol.getText());
        registro = userService.makeNewUser(user);
        if (registro){
            sceneManager.showAlertInfo("Registro exitoso", "Su cuenta se ah creado con exito", "Bienvenido a CinePlex", Alert.AlertType.CONFIRMATION); 
        }else{
            sceneManager.showAlertInfo("Error al Registrarse", "Verificar campos", "No se ha podido registrar el usuario", Alert.AlertType.ERROR);
        }
        }catch (RuntimeException re){
                sceneManager.showAlertInfo("Error al Registrar", "Verificar la Base de Datos", "No se ha podido registrar el usuario", Alert.AlertType.WARNING);
            }
        }
     }
     
     public void exit() throws Exception{
         sceneManager.showLoginView();
     }
     
     
}

