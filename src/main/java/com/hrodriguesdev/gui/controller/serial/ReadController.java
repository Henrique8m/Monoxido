package com.hrodriguesdev.gui.controller.serial;

import java.io.IOException;

import javax.comm.NoSuchPortException;
import javax.comm.SerialPort;

import com.hrodriguesdev.MonoxidoApplication;
import com.hrodriguesdev.gui.controller.Main;
import com.rodrigues.rodrigues.serial.utilitary.DependencyInjection;
import com.rodrigues.rodrigues.serial.utilitary.Gadgets;
import com.rodrigues.rodrigues.serial.utilitary.calc.CalculatorData;
import com.rodrigues.rodrigues.service.FormatData;
import com.rodrigues.rodrigues.service.SerialService;

public class ReadController implements Runnable{

	private Main main;
	
	public ReadController(Main main) {
		this.main = main;
	}
	
    private SerialService serialService;
    private FormatData formatData;
    private Thread thread = new Thread(this);
    
    private byte[] bufferWrite= new byte[8];
    
//    lista com as leituras realizadas
    public static String[] displayVetor;
    
    private int bufferSizeRead;
    private int bufferSizeWrite;
    
//   Ativa ou nao o ciclo de leituras
    private Boolean whileRead = false;
    		
//	Quais os modelos de aparelhos vamos fazer leitura
	private String[] aparelhos = MonoxidoApplication.aparelhos;
	 
    public ReadController() {}

	public void read() throws InterruptedException {
		instanciates();
		if(!thread.isAlive()){
			whileRead = true;
			thread.start();
			}				
		}

    @Override
    public void run() { 
    	
//    	Aqui vai o sincronizad
//    	pirometriaService.start();
    	    	
    	try {
			Thread.sleep(1000);		
			displayVetor = new String[aparelhos.length];
			
			
	    	while(whileRead) {
	    		
	    		for(int i = 0; i < aparelhos.length; i++) {
	    			
	    			try{
	    				sweep(i+1, serialService.enablePortCom());
	    			}catch (NoSuchPortException e) {
	    				System.out.println("Porta não existe! STATUS: " + e.getMessage());	
	    				main.txLog.setText("Porta não existe!");
	    				Thread.sleep(100);	
	    				
	    			}catch (NullPointerException e) {
						main.txLog.setText("Null Pointer Exception");
						e.printStackTrace();
	    			}catch (IOException e) {
	    				main.txLog.setText("Erro ao enviar os dados!");
	    				System.out.println("Erro ao enviar os dados!");
	    			}catch (Exception e) {
	    				main.txLog.setText("Exception");
	    				
	    			}	    			
	    		}
           }
	    	  				    	
    	} catch (InterruptedException | NullPointerException e) {
			e.printStackTrace();
		}
    }

	private void sweep(int i, SerialPort serial) throws NullPointerException, IOException{    	
	    byte[] bufferRead = new byte[7];
	    String display = "";
        	if(serial != null)
        	{ 
        		switch (aparelhos[i-1]) 
        		{
				case "N2000":
					bufferWrite = CalculatorData.addressRead(i,1);					
					break;
				default:					
					bufferWrite = CalculatorData.addressRead(i,0);
					break;
				}        		
        		
            	bufferSizeRead = Gadgets.N1500.getBufferRead();
            	bufferSizeWrite = Gadgets.N1500.getBufferWrite();
            	serialService.writeData(bufferWrite, serial, bufferSizeWrite);
            	bufferRead = serialService.readData(serial, bufferSizeRead);
        		
	        	if(bufferRead != null) 
	        	{ 
	            	switch (aparelhos[i-1]) 
	            	{
					case "N1540":
							display = formatData.formatData(bufferRead, "N1540", "int");
						break;
						
					case "N1540_4_a_20" :
							display = formatData.formatData(bufferRead, "N1540_4_a_20", "double");
						break;
						
					case "N2000" :
		                	display	= formatData.formatData(bufferRead, "N2000", "double");		                	
						break;
						
					case "N1500" :
	                	display = formatData.formatData(bufferRead, "N1500", "int");
	                	
	                	break;
					default:
						break;
					}
	            	
	            	
	            	System.out.println(display);
	            	
	            	
	            	displayVetor[i-1] = display;
    
                }else {
                	displayVetor[i-1]= "Error";
	            }
	        	
//                viewService.writeText(i, display);         
                
            	main.txLog.setText("Conection OK");

            } 
    }

	private void instanciates() {
		if(main == null) main = DependencyInjection.getMain();
		if(serialService == null) serialService = DependencyInjection.getSerialService();
		if(formatData == null) formatData = DependencyInjection.getFormatData();
	}

	@SuppressWarnings("deprecation")
	public void threadCancel() {		
		main.txLog.setText("Conection Lost");


		if(!thread.isInterrupted()) {
			thread.suspend();
		}	
		whileRead = false;
	}
	
	public Boolean getWhileRead() {
		return this.whileRead;
	}
	

		
}
