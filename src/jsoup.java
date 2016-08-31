import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoup {
	
	public static void main(String args[])  {	
		    

			
			String 长春亚泰 = "http://sports.sina.com.cn/csl/changchun/";
			String 河北华夏 = "http://match.sports.sina.com.cn/football/team.php?id=11480&f=1";
			String 延边富德 = "http://match.sports.sina.com.cn/football/csl/team.php?id=5067&dpc=1";
			importPlayer2(延边富德);
			
		    
	}
	
	public static void importPlayer2(String html){
		//河北华夏+延边富德
		Document doc = null;

		try {
			doc = Jsoup.connect(html).timeout(10*1000).get();

		} catch (IOException e) {
			e.printStackTrace();
		} 

		
		Elements contents = doc.select(".p_r p");
		Elements contents_tag = doc.select(".p_r dt");
		//System.out.println(contents.get(0).toString()+contents_tag.get(0).toString());

		int size = contents.size();
    	    	

	    String[] playerName = new String[size];	  
	    String[] playerName_q = new String[size];
	    String[] playerTag = new String[size];
	    String[] playerTag_q = new String[size];

	    String rawName;
	    String rawTag;

		
	    for (int j = 0; j < size; j++){
	    	
	    	rawName = contents.get(j).toString();
	    	playerName[j] = rawName.substring(rawName.indexOf("－")+1, rawName.indexOf("</"));
	    	playerName_q[j] = "\""+ playerName[j]+ "\"";
	    	
	    	System.out.println("<item>"+ playerName_q[j] +"</item>");
	    }	 
	    for (int j = 0; j < size; j++){
	    	
	    	rawTag = contents_tag.get(j).toString();
	    	playerTag[j] = rawTag.substring(rawTag.indexOf("id=")+3, rawTag.indexOf("target")-2);
	    	playerTag_q[j] = "\""+ playerTag[j]+ "\"";

	    	System.out.println("<item>"+ playerTag_q[j] +"</item>");
	    }	  
	    for(int j = 0;j<size;j++){
	    	
		    System.out.println("put("+playerTag_q[j]+","+playerName_q[j]+");	");

	    }
	    
	    
	}
	
	public static void importPlayer(String html){
		
		Document doc = null;

		
		try {
			doc = Jsoup.connect(html).timeout(10*1000).get();

		} catch (IOException e) {
			e.printStackTrace();
		} 

		
		Elements tableContentEles = doc.select(".players p d1");
		//System.out.println(tableContentEles.get(0));
		
		int size = tableContentEles.size();
		
    	String[] playerUrl = new String[size];

	
    for (int j = 0; j < size; j++){
    	
	    	playerUrl[j] = tableContentEles.get(j).toString();

	    	//System.out.println(playerUrl[j]);
	    }	    
	    
	    String[] sTag = new String[size];
	    String[] sTag_q = new String[size];

	    String[] playerName = new String[size];
	    String[] playerName_q = new String[size];

	    for (int j = 0;j< size;j++){
		    sTag[j] = playerUrl[j].substring(playerUrl[j].indexOf("id=")+3, playerUrl[j].indexOf("target")-2);
		    playerName[j] = playerUrl[j].substring(playerUrl[j].indexOf("blank")+7, playerUrl[j].indexOf("</a>"));
		    playerName_q[j] = "\""+ playerName[j]+ "\"";
		    sTag_q[j] = "\""+ sTag[j]+ "\"";
		    
		    
		    //System.out.println("put("+sTag_q[j]+","+playerName_q[j]+");	");
		   //System.out.println("<item>"+ playerName_q[j] +"</item>");
			   System.out.println("<item>"+ playerName_q[j] +"</item>");

		   // System.out.println("<string name=" + playerName_q[j] + ">" + sTag[j] + "</string>");
		    //System.out.println(sTag[j]);
	    }
	    
	    for (int j = 0;j< size;j++){
		    System.out.println("<item>"+ sTag_q[j] +"</item>");

	    }
	    
	    for(int j = 0;j<size;j++){
	    	
		    System.out.println("put("+sTag_q[j]+","+playerName_q[j]+");	");

	    }
	}
}
