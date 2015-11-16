import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/* В процессе разработки пока не работает
   В будующем должен быть класс методов который из отдельного объявления будет доставать нужную информацию */

public class SingleAdParser {
    String csvFile = "D:\\links2.csv";
    String line = "";
    public void parseAd() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        DataVar dataVar = new DataVar();
        FileWriter fileWriter = new FileWriter(dataVar.getAdData());
        while((line = br.readLine()) != null ) {
            String link = br.readLine().replace(",", ""); //
            if(link.length()==100) {
                dataVar.setDocAd(Jsoup.connect(link).timeout(10 * 1000).get());
                Elements streets = dataVar.getDocAd().select("td[class=tdm_rn]");
                for (Element e : streets) {
                   // arrayStreets.add(e.text());
                    System.out.println(e.text());
                }
            }
            else {

            }
        }
    }



}
