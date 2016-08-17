package br.com.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PrinterLogger {
	public static final String TEXTO = ".txt";
	public static final String CSV = ".csv";
	
	public void printLog(String errorMsg, String dir, String fileName, String typeFile) {
		PrintWriter writer = null;
		//String dir = "uzsisc\\li\\env\\erro";
		
		criaDiretorio(dir);
		
		try { 
			writer = new PrintWriter(dir+"\\"+fileName+typeFile, "UTF-8");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(errorMsg);
		writer.close();
	}
	public void criaDiretorio(String dir) {
		File diretorio = new File(dir); // ajfilho é uma pasta!
		if (!diretorio.exists()) {
		   diretorio.mkdirs(); //mkdir() cria somente um diretório, mkdirs() cria diretórios e subdiretórios.
		} else {
		   System.out.println("Diretório já existente");
		}
	}

}
