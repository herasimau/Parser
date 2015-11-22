package ad.objects;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adContract {
    private String adContract;

    public  String getContract(Document doc){
        Elements adContracts = doc.select("td[class=tdm_07");
        adContract = adContracts.text();
        return adContract;

    }
}
