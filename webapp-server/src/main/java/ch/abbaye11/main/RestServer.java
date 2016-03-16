package ch.abbaye11.main;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;


import ch.abbaye11.rest.RestTest;

import com.google.gson.Gson;

import freemarker.template.Configuration;
import freemarker.template.Template;


public class RestServer {

	
	
	public static void start()  {
		
	
		final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                WebServer.class, "/");
		
		Spark.get(new Route("/api/test"){

			@Override
			public Object handle(Request request, Response response) {
				response.type("application/json");
				return new RestTest("ok").toJson();
			}

		
		});
		
		Spark.get(new Route("*"){

			@Override
			public Object handle(Request request, Response response) {
				if(!ApplicationPaths.pathExist(request.pathInfo())){
					StringWriter writer = new StringWriter();
	                try {
	                    Template helloTemplate = configuration.getTemplate("templates/error.ftl");
	                    Map<String, Object> helloMap = new HashMap<String, Object>();
	                    helloMap.put("message", "404 - " + request.pathInfo() + " doesn't exist" );

	                    helloTemplate.process(helloMap, writer);
	                } catch (Exception e) {
	                    halt(500);
	                    e.printStackTrace();
	                }
	                return writer;
				}
				
				return null;
				
				
			}
			

		
		});
	
		
		
		
		
	}
}
