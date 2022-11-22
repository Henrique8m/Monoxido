package com.hrodriguesdev.gui.controller;

import com.hrodriguesdev.MonoxidoApplication;

import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

public class LineChartController implements Runnable{
	private Main controller;
	private Thread thread;
	
	private Series<String, Double> serie01 = null;
	private Series<String, Double> serie02 = null;
	private Series<String, Double> serie03 = null;
	
	public LineChartController(Main controller) {
		this.controller = controller;
		thread = new Thread(this);
		thread.run();
	}


	@Override
	public void run() {

//		System.out.println("Teste run");
		
		serie01 = new XYChart.Series<>();
		serie02 = new XYChart.Series<>();
		serie03 = new XYChart.Series<>();		
		
		serie01.setName(MonoxidoApplication.Serie01);
		serie02.setName(MonoxidoApplication.Serie02);
		serie03.setName(MonoxidoApplication.Serie03);
    	
		controller.Grafico01.getData().add(serie01);
		controller.Grafico01.getData().add(serie02);
		controller.Grafico01.getData().add(serie03);
    	
    	newSerie("12:30", 12d, 20d);
    	newSerie("12:32", 20d, 30d);
    	newSerie("12:35", 25d, 35d);
    	newSerie("12:39", 20d, 40d);
    	newSerie("12:41", 35d, 45d);
    	newSerie("12:43", 30d, 50d);
    	
	}
	
	private void newSerie(String data, Double mediaVazao2, Double mediaPressao2) {
		serie01.getData().add(new Data<String, Double>(data, mediaPressao2));	
		serie02.getData().add(new Data<String, Double>(data, mediaVazao2));	
		serie02.getData().add(new Data<String, Double>(data, mediaVazao2));	
	}
	
}
