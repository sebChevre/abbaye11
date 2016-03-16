package ch.abbaye11.main;

public enum ApplicationPaths {

	TEST("/test"),
	HOME("/home"),
	API_TEST("/api/test"),
	JS_MAIN("/js/main.js"),
	CSS_BOOTSTRAP("/bootstrap/css/bootstrap.min.css"),
	CSS_MAIN("/css/main.css"),
	JS_ANGULAR("/js/angular.js"),
	ERROR("/error");
	
	
	String path;
	
	private ApplicationPaths(String path) {
		this.path = path;
	}
	
	public String path(){
		return path;
	}
	
	public static boolean pathExist(String pathToCompare){
		for(ApplicationPaths path : ApplicationPaths.values()){
			if(path.path().equals(pathToCompare)){
				return true;
			}
		}
		
		return false;
	}
}
