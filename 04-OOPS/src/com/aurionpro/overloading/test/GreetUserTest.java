package com.aurionpro.overloading.test;
/*🔹 3. Greet User
Create a class Greeter with:
 greet() – prints "Hello!"
 greet(String name) – prints "Hello, [name]!"*/
import com.aurionpro.overloading.model.GreetUser;
public class GreetUserTest {
public static void main(String [] args) {

		String name = "anshika";
		GreetUser greetuser = new GreetUser();
		System.out.println(greetuser.greet());
		System.out.println("Hello "+greetuser.greet(name));
}

}
