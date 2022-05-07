package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DesktopTimerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startStopButton;

    @FXML
    private Button hourUpButton;

    @FXML
    private Button minUpButton;

    @FXML
    private Button secDownButton;

    @FXML
    private Button hourDownButton;

    @FXML
    private Label counterLabel;

    @FXML
    private Button secUpButton;

    @FXML
    private Button minDownButton;

    @FXML
    void onClickHourUpButton(ActionEvent event) {
    	TimerCount.setTimerCount(0, 0);
    	this.counterLabel.setText(TimerCount.getTimerCount());
    }

    @FXML
    void onClickMinUpButton(ActionEvent event) {
    	TimerCount.setTimerCount(1, 0);
    	this.counterLabel.setText(TimerCount.getTimerCount());
    }

    @FXML
    void onClickSecUpButton(ActionEvent event) {
    	TimerCount.setTimerCount(2, 0);
    	this.counterLabel.setText(TimerCount.getTimerCount());
    }

    @FXML
    void onClickHourDownButton(ActionEvent event) {
    	TimerCount.setTimerCount(0, 1);
    	this.counterLabel.setText(TimerCount.getTimerCount());
    }

    @FXML
    void onClickMinDownButton(ActionEvent event) {
    	TimerCount.setTimerCount(1, 1);
    	this.counterLabel.setText(TimerCount.getTimerCount());
    }

    @FXML
    void onClickSecDownButton(ActionEvent event) {
    	TimerCount.setTimerCount(2, 1);
    	this.counterLabel.setText(TimerCount.getTimerCount());
    }

    @FXML
    void onClickStartStopButton(ActionEvent event) {
    	TimerCount.timerCountDown();
    }

    @FXML
    void initialize() {
        assert startStopButton != null : "fx:id=\"startStopButton\" was not injected: check your FXML file 'DesktopTimer.fxml'.";
        assert hourUpButton != null : "fx:id=\"hourUpButton\" was not injected: check your FXML file 'DesktopTimer.fxml'.";
        assert minUpButton != null : "fx:id=\"minUpButton\" was not injected: check your FXML file 'DesktopTimer.fxml'.";
        assert secDownButton != null : "fx:id=\"secDownButton\" was not injected: check your FXML file 'DesktopTimer.fxml'.";
        assert hourDownButton != null : "fx:id=\"hourDownButton\" was not injected: check your FXML file 'DesktopTimer.fxml'.";
        assert counterLabel != null : "fx:id=\"counterLabel\" was not injected: check your FXML file 'DesktopTimer.fxml'.";
        assert secUpButton != null : "fx:id=\"secUpButton\" was not injected: check your FXML file 'DesktopTimer.fxml'.";
        assert minDownButton != null : "fx:id=\"minDownButton\" was not injected: check your FXML file 'DesktopTimer.fxml'.";
    }

	/****************************************************/
    /* タイマカウンタラベルを設定するメソッド           */
	/****************************************************/
    public void setCounterLabel(String str)
    {
    	/* ラベルの更新処理をイベント・キューに転送                                                           */
    	/* 補足：JavaFXスレッド以外の別スレッドから直接GUIを更新しようとするとIllegalStateExceptionが発生する */
    	Platform.runLater(()->
    	{
        	this.counterLabel.setText(str);
    	});
    }


	/****************************************************/
    /* タイマオーバー時のポップアップを表示するメソッド */
	/****************************************************/
    public void isTimeOver()
    {
    	/* ラベルの更新処理をイベント・キューに転送     */
    	Platform.runLater(()->
    	{
	    	/* ポップアップを表示 */
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("DesktopTimer");
			alert.setHeaderText(null);
			alert.setContentText("Time Over!!");
			alert.showAndWait();        /* ポップアップを表示し、閉じられるまで待機     */
    	});
    }
}
