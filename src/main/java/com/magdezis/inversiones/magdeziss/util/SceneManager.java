
package main.java.com.magdezis.inversiones.magdeziss.util;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import main.java.com.magdezis.inversiones.magdeziss.controller.LoginController;
import main.java.com.magdezis.inversiones.magdeziss.controller.RegisterController;
import main.java.com.magdezis.inversiones.magdeziss.repository.UserRepository;
import main.java.com.magdezis.inversiones.magdeziss.service.UserService;

/**
 *
 * @author informatica
 */



/**
 *
 * @author dbarrientos
 */
public class SceneManager {
    private final Stage stage;
    private final String FXML_PATH = "/main/resources/view/";
    
    public SceneManager(Stage stage){
        this.stage = stage;
    }
    
    public void showLoginView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "login-view.fxml"));
        
        loader.setControllerFactory(
        clazz -> {
            if(clazz == LoginController.class){
                UserRepository repository = new UserRepository();
                UserService service = new UserService(repository);
                return new LoginController(service, this);
            }
            
            try{
                return clazz.getDeclaredConstructor().newInstance();
            }catch (Exception e){
                throw new RuntimeException("Error al crear constructor... " + e.getMessage());
            }
        }
        );
        
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);
        stage.setMinWidth(420);
        stage.setMinHeight(360);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    
    public void showAlertInfo(String head, String title, String content, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.initOwner(this.stage);
        alert.setHeaderText(head);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
        public void showDashboardView() throws Exception {
            
    }
        
    public void showRegisterView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "register-view.fxml"));
        
        loader.setControllerFactory(
        clazz -> {
            if(clazz == RegisterController.class){
                UserRepository repository = new UserRepository();
                UserService service = new UserService(repository);
                return new RegisterController(service, this);
            }
            
            try{
                return clazz.getDeclaredConstructor().newInstance();
            }catch (Exception e){
                throw new RuntimeException("Error al crear constructor... " + e.getMessage());
            }
        }
        );
        
        Parent root = loader.load();
        Scene scene = new Scene(root, 600, 600);
        stage.setMinWidth(420);
        stage.setMinHeight(360);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}