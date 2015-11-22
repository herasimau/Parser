package ad.objects;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adType {

    private String adType;
    public String getType(Document doc){

        Elements adTypes = doc.select("td[class=tdm_04");
        adType = adTypes.text();

        return adType;
    }


}
