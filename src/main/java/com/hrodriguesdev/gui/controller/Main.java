package com.hrodriguesdev.gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;

import javax.comm.CommPortIdentifier;

import com.hrodriguesdev.MonoxidoApplication;
import com.hrodriguesdev.gui.controller.serial.SerialController;
import com.rodrigues.rodrigues.serial.properties.SerialProperties;
import com.rodrigues.rodrigues.serial.utilitary.DependencyInjection;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.text.Text;

public class Main implements Initializable{

	private SerialProperties serialProperties;
	private SerialController serialController;
	
//	Portas disponiveis
	private List<String> avaliablePorts;
	
	@FXML
	public LineChart<String, Double> Grafico01;

	public Text txLog = new Text();


	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		@SuppressWarnings("unused")
		LineChartController chart = new LineChartController(this);		
		
		instanciates();
		
//		Avalia se tem porta setada, e quais portas estao disponiveis no pc
		if(serialProperties.getPorta() == null ) {			
			avaliablePorts = new ArrayList<>();
			@SuppressWarnings("unchecked")
			Enumeration<CommPortIdentifier> enume = CommPortIdentifier.getPortIdentifiers();		
			while(enume.hasMoreElements()) {
				avaliablePorts.add(enume.nextElement().getName());		
			}
			DependencyInjection.setAvaliablePortsNames(avaliablePorts);
			
			for(String e : avaliablePorts)
				if(e.equals(MonoxidoApplication.defautPort) || !e.equals("COM1"))
					serialProperties.setPorta(e);
			serialProperties.writeFile();
		}
			
		serialController.startCommunication();
	}
	
	private void instanciates() {
		if (serialController == null)
			serialController = DependencyInjection.getSerialController();
		if (serialProperties == null)
			serialProperties = DependencyInjection.getSerialProperties();
	}

}
