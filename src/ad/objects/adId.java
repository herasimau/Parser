package ad.objects;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class adId {
    private long adId;


    public long getId(Document doc){


        Elements adIds = doc.select("a[href*=/workpage.php?page=variant"); //Выбераем ID объявления
        adId = Long.parseLong(adIds.first().ownText().replace("№", "")); // Сохраняем ID


        return adId;
    }

}
