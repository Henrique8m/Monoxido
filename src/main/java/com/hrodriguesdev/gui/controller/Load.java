package com.hrodriguesdev.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.hrodriguesdev.MonoxidoApplication;
import com.hrodriguesdev.gui.view.NewView;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Load implements Initializable{	
	private Timeline timeline;
	private Stage stagePrincipal;	
	private Stage stage;
	private Object controller;
	private Object application;
	
	public Load(Stage stage, Object controller, Object application) {
		this.stagePrincipal = stage;	
		this.controller = controller;
		this.application = application;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		stage = new Stage();
		beginTimer();
	}

	private void beginTimer() {		
		timeline = new Timeline(new KeyFrame(Duration.seconds(MonoxidoApplication.StartSeconds), ev -> {			
				Pane pane = (Pane) NewView.loadFXML("mainView", controller, application);
				NewView.getNewView(MonoxidoApplication.NameApplication , new Scene(pane), false, stage, application);
				stagePrincipal.close();
				timeline.stop();
		}));
		timeline.setCycleCount(10);
		timeline.play();

	}
	
}
