package ad.objects;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adSubway {
    private String adSubway;

    public String getSubway(Document doc){
        Elements adSubways = doc.select("td[class=tdm_03]");
        adSubway = adSubways.text();
        return adSubway;
    }

}
