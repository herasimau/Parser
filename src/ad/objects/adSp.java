package ad.objects;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adSp {

    private String adSp;

    public String getSp(Document doc){

        Elements adSps = doc.select("td[class=tdm_042");
        adSp = adSps.text();

        return adSp;
    }

}
