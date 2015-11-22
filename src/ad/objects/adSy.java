package ad.objects;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adSy {

    private String adSy;
    public String getSy(Document doc){

        Elements adSys = doc.select("td[class=tdm_045");
        adSy = adSys.text();

        return adSy;
    }


}
