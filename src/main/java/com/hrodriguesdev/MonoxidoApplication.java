package com.hrodriguesdev;

import com.hrodriguesdev.gui.controller.Load;
import com.hrodriguesdev.gui.view.NewView;
import com.hrodriguesdev.image.ImageController;
import com.rodrigues.rodrigues.serial.utilitary.DependencyInjection;

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
	
//	Nomes usado no decorrer da application
	public static String NameApplication = "Monitoramento de Monoxido";	
	public static String Serie01 = "Plataforma";
	public static String Serie02 = "Topo";
	public static String Serie03 = "Glendons";
	
//	Tempo inicial para carregar o Aplicativo
	public static Double StartSeconds = 1d;
	
	//--------------------------------------------- Configuração dos aparelhos ------------------------------------------------------------//
	
	public static String[] aparelhos = new String[]{
			"N1540","N1540","N1540"};	
	
	public static int
	IdPlataforma = 1 -1,
	IdTopo = 2-1,
	IdGlendons = 3-1;
	
	//--------------------------------------------- Configuração propriedade de conecao ----------------------------------------------------//

	public static String properties = "Properties.properties";
	public static String Params = "Params.properties";
	public static String strDiretorioYggDrasil = "\\AppData\\Local\\YggDrasil";
	public static String diretorioStr2 = "\\AppData\\Local\\YggDrasil\\serial";
	
	//--------------------------------------------- Configuração modbus -------------------------------------------------------------------//	
	
	public static final Object defautPort = "COM4";	
	public static Integer threadSleep = 150;
		
//	Carregando a view de LoadO
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		stage = primaryStage;	
		Pane pane = (Pane) NewView.loadFXML("loadView", new Load(stage, DependencyInjection.getMain(), this), this);
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
