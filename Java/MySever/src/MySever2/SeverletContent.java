package MySever2;

import java.util.HashMap;
import java.util.Map;
/**
 * 封装url同Severlet的对应关系
 * @author 风潇潇
 *
 */
public class SeverletContent {
	
	private Map<String ,String> urlMap;
	private Map<String ,String> sevMap;
	public SeverletContent() {
		this.urlMap = new HashMap<String ,String>();
		this.sevMap = new HashMap<String ,String>();
	}
	
	public Map<String, String> getUrlMap() {
		return urlMap;
	}
	
	public Map<String, String> getSevMap() {
		return sevMap;
	}
	
}
