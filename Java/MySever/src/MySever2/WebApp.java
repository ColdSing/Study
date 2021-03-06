package MySever2;

import java.util.HashMap;
/**
 * 构建url同Severlet的对应关系
 * 并提供通过url找到对应Severlet方法
 * @author 风潇潇
 *
 */
public class WebApp {
	private static SeverletContent slc;
	/**
	 * 静态代码块，在调用类时自动执行
	 */
	static{
		slc = new SeverletContent();
		HashMap<String,String> urlMap = (HashMap)slc.getUrlMap();
		HashMap<String,String> sevMap = (HashMap)slc.getSevMap();
		urlMap.put("/log", "login");
		urlMap.put("/login", "login");
		urlMap.put("/reg", "regist");
		urlMap.put("/regist", "regist");
		sevMap.put("login","MySever2.LoginSeverlet");
		sevMap.put("regist","MySever2.RegistSeverlet");
		sevMap.put("clc","MySever2.ClcSeverlet");
		urlMap.put("/clc", "clc");
	}
	
	public static Severlet getSeverlet(String url) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		if(null==url||(url.trim()).equals("")){
			return null;
		}
		String name =slc.getSevMap().get(slc.getUrlMap().get(url));
		return (Severlet)Class.forName(name).newInstance();
		
	}
}
