package com.hrodriguesdev.gui.controller.serial;

public class SerialController{
	public ReadController readController = new ReadController();
	
    int end = 2;

    public void stopCommunication(){
    	readController.threadCancel();
    }
    
    public void startCommunication(){
    	instanciates();
    	
    	try {
			readController.read();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    private void instanciates() {
	}
}
