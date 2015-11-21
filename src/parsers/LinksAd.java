package parsers;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import var.MainVar;
import var.MainVar;
import var.PathVar;

import java.io.FileWriter;
import java.io.IOException;

public class LinksAd {
    //метод для парсинга каждой страницы сайта и сохранения ссылок на каждое объявление в csv файл
    public void getAllLinksAd() throws IOException {

        MainVar dataVar = new MainVar();// Создаем объект со ссылками на все наши переменные
        PathVar pathVar = new PathVar();
        FileWriter fileWriter = new FileWriter(pathVar.getDirtyLinks()); // Создаем csv writer для грязных ссылок
        //Цикл для парсинга всех станиц с сайта вместо i < 560 можно будет выставить максимальное значение страниц.
        for (int i =1; i <= 1;i++)
        {
            try {

            // Создаем документ для страницы i
             dataVar.setDoc(Jsoup.connect("http://www.arenda-piter.ru/workpage.php?page=online").timeout(10*1000).get());

            // Выделяем как элементы links все ссылки на объявления на текущей странице
             Elements links = dataVar.getDoc().select("a[href*=/workpage.php?page=variant");
            // Ищем ссылки по шаблону и записываем их в Csv файл
             for (Element link : links) {

                     fileWriter.append(dataVar.getMainSite()+(link.attr("href")));
                     fileWriter.append(dataVar.getComaDelimiter());
                     fileWriter.append(dataVar.getNewLineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace(); }
        }

        fileWriter.close();
    }
}