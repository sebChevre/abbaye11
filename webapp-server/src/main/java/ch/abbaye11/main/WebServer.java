package ch.abbaye11.main;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;








import ch.abbaye11.rest.Connect;
import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;



public class WebServer {

	public static void start() {
		
		final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                WebServer.class, "/");
        
//        Spark.before(new Filter(){
//
//			@Override
//			public void handle(Request request, Response response) {
//				
//				String path = request.pathInfo();
//				
//				if(!ApplicationPaths.pathExist(path)){
//					response.redirect("/error/"+path);
//					
//				}
//				
//			}});
//        
//        Spark.get(new Route("/error/:path"){
//
//			@Override
//			public Object handles(Request request, Response response) {
//				StringWriter writer = new StringWriter();
//                try {
//                    Template helloTemplate = configuration.getTemplate("templates/error.ftl");
//                    Map<String, Object> helloMap = new HashMap<String, Object>();
//                    helloMap.put("message", "404 - " + request.params(":path") + " doesn't exist" );
//
//                    helloTemplate.process(helloMap, writer);
//                } catch (Exception e) {
//                    halt(500);
//                    e.printStackTrace();
//                }
//                return writer;
//			}
//        	
//        });
        
        Spark.get(new Route("/test") {

			@Override
			public Object handle(Request request, Response response) {
				return null;
			}
	
			
		});
		
		
        Spark.get(new Route("/home") {

			public Object handle(Request arg0, Response arg1)  {
				StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("templates/index.ftl");
                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "SebTest");

                    helloTemplate.process(helloMap, writer);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
			}
			
		});
        
       
	}
}
