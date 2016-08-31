import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class jsoup {
	
	public static void main(String args[])  {	
		    

			Document doc = null;

			
			String html = "http://sports.sina.com.cn/csl/changchun/";
			String html2 = "http://match.sports.sina.com.cn/football/team.php?id=11480&f=1";
			try {
				doc = Jsoup.connect(html2).timeout(10*1000).get();

			} catch (IOException e) {
				e.printStackTrace();
			} 

			
//			Elements tableContentEles = doc.select(".players p d1");
			Elements tableContentEles = doc.select(".p_r p");
			//System.out.println(tableContentEles.get(0));
			
//	    	String[] playerUrl = new String[size];
//
//			
//		    for (int j = 0; j < size; j++){
//		    	
//		    	playerUrl[j] = tableContentEles.get(j).toString();
//
//		    	//System.out.println(playerUrl[j]);
//		    }	    
//		    
//		    String[] sTag = new String[size];
//		    String[] sTag_q = new String[size];
//
//		    String[] playerName = new String[size];
//		    String[] playerName_q = new String[size];
//
//		    for (int j = 0;j< size;j++){
//			    sTag[j] = playerUrl[j].substring(playerUrl[j].indexOf("id=")+3, playerUrl[j].indexOf("target")-2);
//			    playerName[j] = playerUrl[j].substring(playerUrl[j].indexOf("blank")+7, playerUrl[j].indexOf("</a>"));
//			    playerName_q[j] = "\""+ playerName[j]+ "\"";
//			    sTag_q[j] = "\""+ sTag[j]+ "\"";
//			    
//			    
//			    //System.out.println("put("+sTag_q[j]+","+playerName_q[j]+");	");
//			   //System.out.println("<item>"+ playerName_q[j] +"</item>");
//				   System.out.println("<item>"+ playerName_q[j] +"</item>");
//
//			   // System.out.println("<string name=" + playerName_q[j] + ">" + sTag[j] + "</string>");
//			    //System.out.println(sTag[j]);
//		    }
//		    
//		    for (int j = 0;j< size;j++){
//			    System.out.println("<item>"+ sTag_q[j] +"</item>");
//
//		    }
//		    
//		    for(int j = 0;j<size;j++){
//		    	
//			    System.out.println("put("+sTag_q[j]+","+playerName_q[j]+");	");
//
//		    }
		    
		    

		    
		    


	}
}
