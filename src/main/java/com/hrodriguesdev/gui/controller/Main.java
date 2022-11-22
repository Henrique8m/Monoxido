package com.hrodriguesdev.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;

public class Main implements Initializable{
	@SuppressWarnings("unused")
	private Object applications;
	
	@FXML
	public LineChart<String, Double> Grafico01;

	
	public Main(Object applications) {
		this.applications = applications;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
		LineChartController chart = new LineChartController(this);
		System.out.println("Main");
	}


}
