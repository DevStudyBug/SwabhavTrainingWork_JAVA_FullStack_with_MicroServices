package com.aurionpro.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.aurionpro.model.Plugin;

public class PluginTest {
	public static void main(String[] args) throws Exception {

		Class<Plugin> c = Plugin.class; 

		System.out.println("Class Name: " + c.getName());

		// Access private constructor
		Constructor<Plugin> constructor = c.getConstructor();
		constructor.setAccessible(true); 
		System.out.println("Constructor name: " + constructor.getName());
		
		Object pluginInstance = constructor.newInstance(); // without object to access field and method make it static

		// Access and set the private field 'version' to 3.1
		Field versionField = c.getDeclaredField("version");
		versionField.setAccessible(true); // make it accessible
		// Get and print the value before setting
		System.out.println("Version before set: " + versionField.get(pluginInstance));
		// Now set it to 3.1
		versionField.set(pluginInstance, 3.1);
		// Print the version field
		System.out.println("Version: " + versionField.get(pluginInstance));

		// Invoke the public method execute()
		Method executeMethod = c.getMethod("execute");
		executeMethod.invoke(pluginInstance); //invoke() is the way to call a method via reflection

	}
}