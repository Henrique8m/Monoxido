package com.hrodriguesdev.image;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageController {

	public static ImageView loadImageView(String nameImageView, Object recurso) {
		return new ImageView(new Image(	recurso.getClass().getResource("gui/resources/" + nameImageView).toString()));
	}	
	
	public static Image loadImage(String nameImage, Object recurso) {
		return new Image(recurso.getClass().getResource("gui/resources/" + nameImage).toString());
	}
	
}
