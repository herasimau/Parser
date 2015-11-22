package ad.objects;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adDealType {

    private String adDealType;
    public String getDealType(Document doc){
        Elements adDealTypes = doc.select("td[class=tdm_01]");//Тип сделки
        adDealType = adDealTypes.text();
        return adDealType;
    }

}
