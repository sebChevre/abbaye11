package ch.abbaye11.main;

import spark.Spark;

public class StartApp {

	public static void main(String[] args) {
		Spark.setPort(11111);
		Spark.staticFileLocation("/public");
		
		WebServer.start();
		RestServer.start();
		//RestServer.main(new String[0]);
		//RestServer.start();
	}
}
