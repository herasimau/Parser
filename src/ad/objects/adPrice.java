package ad.objects;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adPrice {

    private String adPrice;

    public String getPrice(Document doc){
        Elements adPrices = doc.select("td[class=tdm_05");
        adPrice = adPrices.text();
        return adPrice;
    }

}
