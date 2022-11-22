package com.hrodriguesdev;

import com.hrodriguesdev.gui.controller.Load;
import com.hrodriguesdev.gui.controller.Main;
import com.hrodriguesdev.gui.view.NewView;
import com.hrodriguesdev.image.ImageController;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MonoxidoApplication extends Application{
	private static Scene scene;
	public static Stage stage;
	private final String nameIcon = "Yggdrasilicon.jpg";
	private final String nameImageViewStarting = "Yggdrasil.jpg";
	
	public static String nameApplication = "Monitoramento de Monoxido";
	
//	Carregando a view de LoadO
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;	
		Pane pane = (Pane) NewView.loadFXML("loadView", new Load(stage, new Main(this), this), this);
		pane.getChildren().add(ImageController.loadImageView(nameImageViewStarting, this));
		scene = new Scene(pane, 400, 300);		
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setScene(scene);
		stage.setTitle("Monoxido");
		stage.getIcons().add(ImageController.loadImage(nameIcon, this));
		stage.show();

	}
	
	public static void main(String[] args) {
		 launch(args);
		System.exit(1);
	}
	
}
