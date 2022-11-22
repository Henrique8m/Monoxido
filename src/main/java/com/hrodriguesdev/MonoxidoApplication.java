package com.hrodriguesdev;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MonoxidoApplication extends Application{
	private static Scene scene;
	public static Stage stage;
	
//	Carregando a view de LoadO
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;	
		Pane pane = new Pane();
		scene = new Scene(pane, 400, 300);		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.setTitle("Pirometros");
		stage.show();

	}
	
	public static void main(String[] args) {
		 launch(args);
		System.exit(1);
	}
	
}
