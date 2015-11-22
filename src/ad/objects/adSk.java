package ad.objects;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.print.Doc;

public class adSk {

    private String adSk;
    public String getSk(Document doc){

        Elements adSks = doc.select("td[class=tdm_043");
        adSk = adSks.text();

        return adSk;
    }


}
