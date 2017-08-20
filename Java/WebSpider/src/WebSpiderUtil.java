import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class WebSpiderUtil {
	public static String getWebContent(String address) throws IOException{
		URL url = new URL(address);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuilder sb = new StringBuilder();
		String temp = "";
		while(null!=(temp=br.readLine())){
			sb.append(temp);
		}
		temp = sb.toString();
		Pattern p = Pattern.compile("<head>[\\s\\S]+?charset=\"*([\\w-]{1,15}?)[>\"; ]");
		Matcher m = p.matcher(temp);
		m.find();
		String charset = m.group(1);
		temp = getWebContent(address,charset);
		return temp;
	}
	public static String getWebContent(String address,String charset) throws IOException{
		URL url = new URL(address);
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),charset));
		StringBuilder sb = new StringBuilder();
		String temp = "";
		while(null!=(temp=br.readLine())){
			sb.append(temp);
		}
		return sb.toString();
	}
	public static void fileWebContent(String address){
		String content="";
		try {
			content= getWebContent(address);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
