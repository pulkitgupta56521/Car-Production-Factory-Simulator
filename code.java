//Importing libraries
import java.io.*;
import java.util.Scanner;


class Car extends Thread{
	int assemblyLineNumber;
	long totalTime = 0;
	Frame frame;
	Wheel wheel;
	Engine engine;
	Interior interior;
	Chasis chasis;
	Color color;
	
	Car(int i){
		assemblyLineNumber = i;
	}
	
	void select() {
		Scanner sc = new Scanner(System.in);
		int selection = 0;
		
		while(selection < 1 || selection > 5) {
			System.out.println("Enter type of Frame (1-5)");
			selection = sc.nextInt();
		}
		frame = new Frame(selection);
		
		selection = 0;
		while(selection < 1 || selection > 3) {
			System.out.println("Enter type of Wheel (1-3)");
			selection = sc.nextInt();
		}
		wheel = new Wheel(selection);
		
		selection = 0;
		while(selection < 1 || selection > 8) {
			System.out.println("Enter type of Engine (1-8)");
			selection = sc.nextInt();
		}
		engine = new Engine(selection);
		
		selection = 0;
		while(selection < 1 || selection > 3) {
			System.out.println("Enter type of Interior (1-3)");
			selection = sc.nextInt();
		}
		interior = new Interior(selection);
		
		selection = 0;
		while(selection < 1 || selection > 7) {
			System.out.println("Enter type of Chasis (1-7)");
			selection = sc.nextInt();
		}
		chasis = new Chasis(selection);
		
		selection = 0;
		while(selection < 1 || selection > 12) {
			System.out.println("Enter type of Color (1-12)");
			selection = sc.nextInt();
		}
		color = new Color(selection);
	}
	
	String displaytime(long totalTime) {
		 return "0" + totalTime / 60 + ":" + (totalTime % 60) / 10 + "" + (totalTime%60) % 10 + "  ";
	}
	
	public void run() {
		try {
			fitFrame();
			fitWheel();
			fitEngine();
			fitInterior();
			fitChasis();
			fitColor();
			finished();
		}catch (InterruptedException ie) {}
			
		
	}
	
	void fitFrame() throws InterruptedException{
		totalTime += frame.timeTaken;
		Thread.sleep(frame.timeTaken * 1000);
		System.out.println(displaytime(totalTime) + "Frame fitted at car on assembly line " + assemblyLineNumber);
	}
	
	void fitWheel() throws InterruptedException{
		totalTime += wheel.timeTaken;
		Thread.sleep(wheel.timeTaken * 1000);
		System.out.println(displaytime(totalTime) + "Wheel fitted at car on assembly line " + assemblyLineNumber);
	}
	
	void fitEngine() throws InterruptedException{
		totalTime += engine.timeTaken;
		Thread.sleep(engine.timeTaken * 1000);
		System.out.println(displaytime(totalTime) + "Engine fitted at car on assembly line " + assemblyLineNumber);
	}
	
	void fitInterior() throws InterruptedException{
		totalTime += interior.timeTaken;
		Thread.sleep(interior.timeTaken * 1000);
		System.out.println(displaytime(totalTime) + "Interior fitted at car on assembly line " + assemblyLineNumber);
	}
	
	void fitChasis() throws InterruptedException{
		totalTime += chasis.timeTaken;
		Thread.sleep(chasis.timeTaken * 1000);
		System.out.println(displaytime(totalTime) + "Chasis fitted at car on assembly line " + assemblyLineNumber);
	}
	
	void fitColor() throws InterruptedException{
		totalTime += color.timeTaken;
		Thread.sleep(color.timeTaken * 1000);
		System.out.println(displaytime(totalTime) + "Color fitted at car on assembly line " + assemblyLineNumber);
	}
	
	void finished() {
		System.out.println(displaytime(totalTime) + "Car production finished at assembly line " + assemblyLineNumber);
	}
}

//Class which drives the program
public class Solution{
	public static void main(String args[]) throws InterruptedException {
		Scanner sc= new Scanner(System.in);
		//Taking in the number of assembly lines which indicates the number of threads
		int assemblyLines = 0;
		
		while(assemblyLines < 1) {
			System.out.println("Enter Number of Assembly Lines");
			assemblyLines = sc.nextInt();
		}
		
		//Instantiating a car thread array
		Car car[] = new Car[assemblyLines];
		
		for(int i = 0; i < assemblyLines; i++) {
			System.out.println("For Assembly Line " + (i + 1) + ":");
			car[i] = new Car(i + 1);
			car[i].select();
		}
		
		//Starting all the threads
		System.out.println("00:00  Starting Production");
		for(int i = 0; i < assemblyLines; i++) {
			car[i].start();
		}
		
		for(Thread t : car) {
	          // waits for this thread to die
	          t.join();
	      }
	      System.out.print("All cars Produced. Exiting Program");
	      sc.close();
	      return;
	}
}

class Frame{
	int frameType;
	long timeTaken;
	
	//Constructor for frame which selects the time taken
	Frame(int selection){
		this.frameType = selection;
		selectFrame();
	}
	
	//Selecting frame type
	void selectFrame() {
		if(frameType == 1) {
			frame1();
		}
		else if(frameType == 2) {
			frame2();
		}
		else if(frameType == 3) {
			frame3();
		}
		else if(frameType == 4) {
			frame4();
		}
		else if(frameType == 5) {
			frame5();
		}
	}
	
	//Inputting the time
	void frame1() {
		timeTaken = 4;
	}
	
	void frame2() {
		timeTaken = 6;
	}
	
	void frame3() {
		timeTaken = 3;
	}
	
	void frame4() {
		timeTaken = 2;
	}
	
	void frame5() {
		timeTaken = 5;
	}
}

class Wheel{
	int wheelType;
	long timeTaken;
	
	//Constructor for frame which selects the time taken
	Wheel(int selection){
		this.wheelType = selection;
		selectWheel();
	}
	
	//Selecting frame type
	void selectWheel() {
		if(wheelType == 1) {
			wheel1();
		}
		else if(wheelType == 2) {
			wheel2();
		}
		else if(wheelType == 3) {
			wheel3();
		}
	}
	
	//Inputting the time
	void wheel1() {
		timeTaken = 5;
	}
	
	void wheel2() {
		timeTaken = 2;
	}
	
	void wheel3() {
		timeTaken = 3;
	}
}

class Engine{
	int engineType;
	long timeTaken;
	
	//Constructor for frame which selects the time taken
	Engine(int selection){
		this.engineType = selection;
		selectEngine();
	}
	
	//Selecting frame type
	void selectEngine() {
		if(engineType == 1) {
			engine1();
		}
		else if(engineType == 2) {
			engine2();
		}
		else if(engineType == 3) {
			engine3();
		}
		else if(engineType == 4) {
			engine4();
		}
		else if(engineType == 5) {
			engine5();
		}
		else if(engineType == 6) {
			engine6();
		}
		else if(engineType == 7) {
			engine7();
		}
		else if(engineType == 8) {
			engine8();
		}
	}
	
	//Inputting the time
	void engine1() {
		timeTaken = 8;
	}
	
	void engine2() {
		timeTaken = 7;
	}
	
	void engine3() {
		timeTaken = 10;
	}
	
	void engine4() {
		timeTaken = 12;
	}
	
	void engine5() {
		timeTaken = 6;
	}
	void engine6() {
		timeTaken = 9;
	}
	
	void engine7() {
		timeTaken = 10;
	}
	
	void engine8() {
		timeTaken = 5;
	}
}

class Interior{
	int interiorType;
	long timeTaken;
	
	//Constructor for frame which selects the time taken
	Interior(int selection){
		this.interiorType = selection;
		selectInterior();
	}
	
	//Selecting frame type
	void selectInterior() {
		if(interiorType == 1) {
			interior1();
		}
		else if(interiorType == 2) {
			interior2();
		}
		else if(interiorType == 3) {
			interior3();
		}
	}
	
	//Inputting the time
	void interior1() {
		timeTaken = 3;
	}
	
	void interior2() {
		timeTaken = 4;
	}
	
	void interior3() {
		timeTaken = 2;
	}
}

class Chasis{
	int chasisType;
	long timeTaken;
	
	//Constructor for frame which selects the time taken
	Chasis(int selection){
		this.chasisType = selection;
		selectChasis();
	}
	
	//Selecting frame type
	void selectChasis() {
		if(chasisType == 1) {
			chasis1();
		}
		else if(chasisType == 2) {
			chasis2();
		}
		else if(chasisType == 3) {
			chasis3();
		}
		else if(chasisType == 4) {
			chasis4();
		}
		else if(chasisType == 5) {
			chasis5();
		}
		else if(chasisType == 6) {
			chasis6();
		}
		else if(chasisType == 7) {
			chasis7();
		}
	}
	
	//Inputting the time
	void chasis1() {
		timeTaken = 4;
	}
	
	void chasis2() {
		timeTaken = 6;
	}
	
	void chasis3() {
		timeTaken = 5;
	}
	
	void chasis4() {
		timeTaken = 9;
	}
	
	void chasis5() {
		timeTaken = 7;
	}
	void chasis6() {
		timeTaken = 5;
	}
	
	void chasis7() {
		timeTaken = 6;
	}
}

class Color{
	int colorType;
	long timeTaken;
	
	//Constructor for color which selects the time taken
	Color(int selection){
		this.colorType = selection;
		selectColor();
	}
	
	//Selecting color type
	void selectColor() {
		if(colorType == 1) {
			color1();
		}
		else if(colorType == 2) {
			color2();
		}
		else if(colorType == 3) {
			color3();
		}
		else if(colorType == 4) {
			color4();
		}
		else if(colorType == 5) {
			color5();
		}
		else if(colorType == 6) {
			color6();
		}
		else if(colorType == 7) {
			color7();
		}
		else if(colorType == 8) {
			color8();
		}
		else if(colorType == 9) {
			color9();
		}
		else if(colorType == 10) {
			color10();
		}
		else if(colorType == 11) {
			color11();
		}
		else if(colorType == 12) {
			color12();
		}
	}
	
	//Inputting the time
	void color1() {
		timeTaken = 3;
	}
	
	void color2() {
		timeTaken = 1;
	}
	
	void color3() {
		timeTaken = 5;
	}
	
	void color4() {
		timeTaken = 6;
	}
	
	void color5() {
		timeTaken = 3;
	}
	void color6() {
		timeTaken = 5;
	}
	
	void color7() {
		timeTaken = 4;
	}
	
	void color8() {
		timeTaken = 5;
	}
	void color9() {
		timeTaken = 2;
	}
	void color10() {
		timeTaken = 3;
	}
	
	void color11() {
		timeTaken = 6;
	}
	
	void color12() {
		timeTaken = 4;
	}
}