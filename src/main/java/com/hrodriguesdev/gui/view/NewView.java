package com.hrodriguesdev.gui.view;

import java.io.IOException;

import com.hrodriguesdev.MonoxidoApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NewView {

	public static synchronized <T> Object loadFXML(String fxml, Object controller, Object application) {
		FXMLLoader fxmlLoader = new FXMLLoader(application.getClass().getResource("gui/fxml/" + fxml + ".fxml"));
		fxmlLoader.setController(controller);
		try {
			return fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void getNewViewModall(String title, Pane pane, Stage stageEvent) {
		Stage stage = new Stage();
		stage.setTitle(title);
		stage.setScene(new Scene(pane));
		stage.setResizable(false);
		stage.initOwner(stageEvent);
		stage.getIcons().add(
				new Image(MonoxidoApplication.class.getResource("gui/resources/" + "Yggdrasilicon.jpg").toString()));
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initStyle(StageStyle.UTILITY);
		stage.setAlwaysOnTop(true);
		stage.showAndWait();
	}

	public static Stage newViewOpen(String fxml, Stage stage, Object controller, Object applications,
			boolean setMaximized) throws IOException {
		Pane Pane = (Pane) loadFXML(fxml, controller, applications);
		Scene scene = new Scene(Pane);
		stage.setMaximized(setMaximized);
		stage.getIcons().add(
				new Image(MonoxidoApplication.class.getResource("gui/resources/" + "Yggdrasilicon.jpg").toString()));
		stage.setScene(scene);
		stage.show();
		return stage;

	}

	public static Stage getNewView(String title, Scene mainScene, boolean setMaximized, Stage stage,
			Object application) {
		stage.setMaximized(setMaximized);
		stage.setTitle(title);
		stage.getIcons()
				.add(new Image(application.getClass().getResource("gui/resources/" + "Yggdrasilicon.jpg").toString()));
		stage.setScene(mainScene);
		stage.show();
		return stage;
	}

}
