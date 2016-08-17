package br.com.di.registro;

import java.io.File;

import autoitx4java.AutoItX;

import com.jacob.com.LibraryLoader;

public class Autoit {
	
	public Autoit(){
		
	}
	
	public void findXML(String dir,String filename) throws InterruptedException{
		String jacobDllVersionToUse;
		if (jvmBitVersion().contains("32")){
			jacobDllVersionToUse = "jacob-1.18-M2-x86.dll";
		}
		else {
			jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";
		}

		File file = new File("lib", jacobDllVersionToUse); //path to the jacob dll
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		Thread.sleep(5000);
		
		
		AutoItX x = new AutoItX();
		//x.run("calc.exe");
		x.winActivate("Abrir");
		x.winWaitActive("Abrir");
		
		x.controlClick("Abrir", "", "[CLASS:ToolbarWindow32; INSTANCE:3]");
		Thread.sleep(1000);
		x.send(dir);
		Thread.sleep(1000);
		x.send("{ENTER}", false);
		Thread.sleep(1000);
		x.controlClick("Abrir", "", "[CLASS:Edit; INSTANCE:1]");
		Thread.sleep(1000);
		x.send(filename);
		Thread.sleep(1000);
		x.controlClick("Abrir", "", "[CLASS:Button; INSTANCE:1]");
		Thread.sleep(1000);
		
		
		//x.controlClick("Abri", "", "[CLASS:Button; INSTANCE:1]");
	}
	/**
	 *
	 * Returns if the JVM is 32 or 64 bit version
	 */
	public
	static String jvmBitVersion(){
		return System.getProperty("sun.arch.data.model");
	}

}
