package com.aurionpro.ISP.Solution.Worker.test;

import com.aurionpro.ISP.Solution.Worker.model.Labour;
import com.aurionpro.ISP.Solution.Worker.model.Robot;

//import java.awt.Robot;

public class WorkTest {
public static void main(String[] args) {
	System.out.println("---Robot details ----");
	Robot r = new Robot();
	r.start();
	r.stop();
	System.out.println("---Labour details----");
	Labour l = new Labour();
	l.eat();
	l.rest();
	l.start();
	l.stop();
}
}
