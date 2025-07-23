package com.aurionpro.test;

class Animal {
	Animal() {
	     System.out.println("Animal constructor called");
	 }
	 void sound() {
	     System.out.println("Animal makes a sound");
	 }
}
//Child class
class Dog extends Animal {
Dog() {
   // Calls the constructor of Animal class
   super();
   System.out.println("Dog constructor called");
}

// Overriding the sound() method of Animal class
@Override
void sound() {
   // Calls the parent class version of sound()
   super.sound();
   System.out.println("Dog barks");
}
}

//Main class to run the code
public class Main {
 public static void main(String[] args) {
     Dog myDog = new Dog();   // Constructor calls
     myDog.sound();           // Method override demonstration
 }
}
