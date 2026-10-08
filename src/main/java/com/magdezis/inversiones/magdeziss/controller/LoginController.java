
package main.java.com.magdezis.inversiones.magdeziss.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import main.java.com.magdezis.inversiones.magdeziss.dto.request.LoginDtoRequest;
import main.java.com.magdezis.inversiones.magdeziss.dto.response.LoginDtoResponse;
import main.java.com.magdezis.inversiones.magdeziss.service.UserService;
import main.java.com.magdezis.inversiones.magdeziss.util.SceneManager;

/**
 *
 * @author dbarrientos
 */

public class LoginController implements Initializable {
    private UserService userService;
    private SceneManager sceneManager;
    
   
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Button btnRegistrarse;
    @FXML
    private TextField txtFieldEmail;
    @FXML
    private PasswordField pwField;
    
    
    public LoginController(UserService userService, SceneManager sceneManager){
        this.userService = userService;
        this.sceneManager = sceneManager;
    }
    
    public LoginController(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void handleLogin() throws Exception{
        if(txtFieldEmail.getText().isEmpty() || pwField.getText().isEmpty()){
            sceneManager.showAlertInfo("Campos sin llenar", "No se pueden dejar espacios en blanco", "Intenta de nuevo", Alert.AlertType.INFORMATION);
        }else{
            try{
                LoginDtoResponse response = userService.login(new LoginDtoRequest(txtFieldEmail.getText(), pwField.getText()));
                sceneManager.showAlertInfo("Es bueno verte de nuevo", "¡Bienvenido " + response.getName() + "!", "Inicio de sesión correcto", Alert.AlertType.INFORMATION);
                sceneManager.showDashboardView();
            }catch (RuntimeException re){
                sceneManager.showAlertInfo("Error al iniciar sesión", "Verificar campos", "No se ha podido iniciar sesión", Alert.AlertType.WARNING);
            }
        }
    }
    
    @FXML
    public void handleRegister() throws Exception{
        
        sceneManager.showRegisterView();
        
    }
}