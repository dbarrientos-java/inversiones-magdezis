package main.java.com.magdezis.inversiones.magdeziss;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import main.java.com.magdezis.inversiones.magdeziss.util.SceneManager;


/**
 *
 * @author informatica
 */

public class MainApp extends Application {

    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception{
        this.stage = stage;
        SceneManager sceneManager = new SceneManager(stage);
        sceneManager.showLoginView();
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
}

