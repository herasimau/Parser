package ad.objects;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adAddress {

    private String adAddress;

    public String getAddress(Document doc){

        Elements adAddresses = doc.select("td[class=tdm_02]"); //Адрес
        adAddress = adAddresses.text().replace("на карте", "");

        return adAddress;
    }


}
