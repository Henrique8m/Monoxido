package com.rodrigues.rodrigues.serial.utilitary;

import java.util.List;

import com.hrodriguesdev.gui.controller.Main;
import com.hrodriguesdev.gui.controller.serial.ReadController;
import com.hrodriguesdev.gui.controller.serial.SerialController;
import com.rodrigues.rodrigues.serial.properties.SerialProperties;
import com.rodrigues.rodrigues.serial.resources.PortComResurce;
import com.rodrigues.rodrigues.service.FormatData;
import com.rodrigues.rodrigues.service.SerialService;

public class DependencyInjection {
	
	private static final ReadController readController = new ReadController();
	private static final SerialController serialController = new SerialController();
	private static final SerialService serialService = new SerialService();
	private static final SerialProperties serialProperties = new SerialProperties();
	private static final FormatData formatData = new FormatData();
	private static final PortComResurce portComResurces = new PortComResurce();
	private static final Main main = new Main();
	
	private static Main primaryViewController;
	private static List<String> avaliablePorts;
	
	public static Main getMain() {
		return main;	
	}
	
	public DependencyInjection() {
	}

	public static ReadController getReadController() {
		return readController;
	}

	public static SerialController getSerialController() {
		return serialController;
	}

	public static SerialService getSerialService() {
		return serialService;
	}

	public static SerialProperties getSerialProperties() {
		return serialProperties;
	}

	public static Main getMainController() {
		return primaryViewController;
	}


	public static void setPrimaryViewController(Main primaryViewController) {
		DependencyInjection.primaryViewController = primaryViewController;
	}
	
	public static List<String> getPortName() {
		return avaliablePorts;
	}
	
	public static void setAvaliablePortsNames(List<String> avaliablePorts) {
		DependencyInjection.avaliablePorts = avaliablePorts;
	}

	public static FormatData getFormatData() {
		return formatData;
	}

	public static PortComResurce getPortComResurce() {
		return portComResurces;
	}

}
