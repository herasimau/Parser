package ad.objects;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adEt {
    private String adEt;

    public String getEt(Document doc){

        Elements adEts = doc.select("td[class=tdm_044");
        adEt = adEts.text();

        return adEt;
    }


}
