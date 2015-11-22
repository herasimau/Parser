package ad.objects;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class adDate {
private String adDate;
    public String getDate(Document doc){

        Elements adDates = doc.select("span[style=color:#666666;]"); // Дата

        adDate = adDates.text().replace("Выставляется в базе с ", "");
        return adDate;


    }

}


