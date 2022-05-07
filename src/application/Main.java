package application;
    
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
    
    private final int WINDOW_WIDTH  = 360;
    private final int WINDOW_HEIGHT = 270;
    private static DesktopTimerController controller;   /* �R���g���[�� */
    
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DesktopTimer.fxml"));
            AnchorPane root = (AnchorPane)loader.load();
            Scene scene = new Scene(root,WINDOW_WIDTH,WINDOW_HEIGHT);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
            Main.controller = loader.getController();   /* ���N���X�ŃR���g���[���N���X�̃����o���g�p���邽�߂ɕϐ��ɋL�����Ă��� */
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        TimerCount.timerCountInit();            /* TimerCount�N���X�������� */
        launch(args);
    }
    
    /****************************************************/
    /* �R���g���[�����擾���郁�\�b�h                   */
    /****************************************************/
    public static DesktopTimerController getController()
    {
        return Main.controller;
    }
}
