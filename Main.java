import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) {

        Document doc;
        Document docAd;
        ArrayList<String> arrayLinks = new ArrayList<>();
        ArrayList<String> arrayText = new ArrayList<>();
        String mainSite = "http://www.arenda-piter.ru";
        try {

            // получаем документ по ссылке
            doc = Jsoup.connect("http://www.arenda-piter.ru/workpage.php?page=online").get();

            // получаем тайтл
            String title = doc.title();
            System.out.println("title : " + title);

            // получаем ссылки на все объявления
            Elements links = doc.select("a[href*=/workpage.php?page=variant");
            for (Element link : links) {
                // сохраняем в массив ссылки
                arrayLinks.add(link.attr("href"));
                //сохраняем в массив ИД объявлений
                arrayText.add(link.text());
            }

            //цикл для парсинга каждого объявления
            for(int i=0;i<arrayLinks.size();i++)
            {
                //получаем документ отдельного объявления
                docAd = Jsoup.connect(mainSite+ arrayLinks.get(i)).get();


            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}