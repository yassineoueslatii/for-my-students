import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Jsoups {

	public static void main(String[] args) throws Exception {
		
		String url= "http://www.meteo.tn/listear/previsions/previsions.php";
		Document doc = Jsoup.connect(url)
				  .userAgent("Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.10136")
				  .get();
				  ;
				  
		
		//Document document = Jsoup.parse(new URL(url).openStream(), "windows-1256", url);
		Elements masthead = doc.select("td.txt12b");
		List<meteo> meteoo =new ArrayList<meteo>();
		int i=0;
		String title="التوقعات الجوية لبقية هذا اليوم والليلة القادمة";
		for (Element element : masthead) {
			
			
			meteoo.add(new meteo(i, title,element.text() ));
			//System.out.println(element.text());
			i++;
			title="لتوقعات الجوية ليوم الغد ا";
		}
		for (meteo meteo : meteoo) {
			System.out.println(""+meteo.getId());
			System.out.println(meteo.getTitle());
			System.out.println(meteo.getContent());
			
		}
		
		


	}
}


