package application;
    
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    
    private final int WINDOW_WIDTH  = 360;
    private final int WINDOW_HEIGHT = 270;
    private static DesktopTimerController controller;   /* コントローラ */
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DesktopTimer.fxml"));
            AnchorPane root = (AnchorPane)loader.load();
            Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            Main.controller = loader.getController();   /* 他クラスでコントローラクラスのメンバを使用するために変数に記憶しておく */
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        TimerCount.timerCountInit();            /* TimerCountクラスを初期化 */
        launch(args);
    }
    
    /****************************************************/
    /* コントローラを取得するメソッド                   */
    /****************************************************/
    public static DesktopTimerController getController()
    {
        return Main.controller;
    }
}
