package MySever2;

import java.util.HashMap;
import java.util.Map;
/**
 * ��װurlͬSeverlet�Ķ�Ӧ��ϵ
 * @author ������
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
