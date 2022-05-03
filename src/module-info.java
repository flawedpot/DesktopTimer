module DesktopTimer {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	exports application;
	opens application to javafx.fxml;
}
