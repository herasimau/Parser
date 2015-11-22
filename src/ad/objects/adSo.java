package ad.objects;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adSo {
    private String adSo;

    public String getSo(Document doc){

        Elements adSos = doc.select("td[class=tdm_041");
        adSo = adSos.text();

        return adSo;
    }


}
