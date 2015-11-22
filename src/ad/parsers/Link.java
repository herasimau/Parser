package ad.parsers;
import ad.objects.adDate;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* Парсим последнюю страницу, на которой показывает последние 50 объявлений, собираем ссылки и сохраняем их в Set*/


public class Link {
    public static Set<String> linksSet = new HashSet<>();
    public void getLinks(){


            try {
                Document doc = Jsoup.connect("http://www.arenda-piter.ru/workpage.php?page=online").timeout(10*1000).get();
                Elements links = doc.select("a[href*=/workpage.php?page=variant");

                for (Element link : links) {
                    linksSet.add(link.attr("href"));
                }

            } catch (IOException e) {
                e.printStackTrace(); }



    }
}
