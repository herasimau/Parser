
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
        ArrayList<String> arrayLinks = new ArrayList<>(); // ссылки
        ArrayList<String> arrayIds = new ArrayList<>(); //ИД объявлений
        ArrayList<String> arrayData = new ArrayList<>(); //Дата объявления
        ArrayList<String> arrayStreets = new ArrayList<>(); //Улицы tdm_rn
        ArrayList<String> arrayDealType = new ArrayList<>(); //Тип сделки tdm_01
        ArrayList<String> arrayMetro = new ArrayList<>(); //Метро tdm_03
        ArrayList<String> arraySo = new ArrayList<>(); //So tdm_041
        ArrayList<String> arraySp = new ArrayList<>(); //Sp tdm_042
        ArrayList<String> arraySk = new ArrayList<>(); //Sk tdm_043
        ArrayList<String> arrayEt = new ArrayList<>(); //Et tdm_044
        ArrayList<String> arraySy = new ArrayList<>(); //Sy tdm_045
        ArrayList<String> arrayTypeAd = new ArrayList<>(); //тип объявления tdm_04
        ArrayList<String> arrayPrice = new ArrayList<>(); //Цена tdm_05
        ArrayList<String> arrayContract = new ArrayList<>(); //Условия контракта tdm_07
        ArrayList<String> arrayDescriptionAd = new ArrayList<>(); //описание объявления tdm_08
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
                arrayIds.add(link.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //цикл для парсинга каждого объявления
            for (int i = 0; i < arrayLinks.size(); i++) {
                //получаем документ отдельного объявления
                docAd = Jsoup.connect(mainSite + arrayLinks.get(i)).get();
                //Парсим улицы
                Elements streets = docAd.select("td[class=tdm_rn]");
                for (Element e : streets) {
                    arrayStreets.add(e.text());
                    System.out.println(e.text());
                }
                //Парсим тип сделки
                Elements deals = docAd.select("td[class=tdm_01]");
                for (Element e : deals) {
                    arrayDealType.add(e.text());
                    System.out.println(e.text());
                }
                //Парсим метро
                Elements metros = docAd.select("td[class=tdm_03]");
                for (Element e : metros) {
                    arrayMetro.add(e.text());
                    System.out.println(e.text());
                }
                //Парсим So
                Elements so = docAd.select("td[class=tdm_041]");
                for (Element e : so) {
                    arraySo.add(e.text());
                    System.out.println(e.text());
                }

                //Парсим Sp
                Elements sp = docAd.select("td[class=tdm_042]");
                for (Element e : sp) {
                    arraySp.add(e.text());
                    System.out.println(e.text());
                }

                //Парсим Sk
                Elements sk = docAd.select("td[class=tdm_043]");
                for (Element e : sk) {
                    arraySk.add(e.text());
                    System.out.println(e.text());
                }

                //Парсим Et
                Elements et = docAd.select("td[class=tdm_044]");
                for (Element e : et) {
                    arrayEt.add(e.text());
                    System.out.println(e.text());
                }

                //Парсим Sy
                Elements sy = docAd.select("td[class=tdm_045]");
                for (Element e : sy) {
                    arrayEt.add(e.text());
                    System.out.println(e.text());
                }

                //Парсим тип объявления
                Elements typeAd = docAd.select("td[class=tdm_04]");
                for (Element e : typeAd) {
                    arrayTypeAd.add(e.text());
                    System.out.println(e.text());
                }

                //Парсим цену
                Elements price = docAd.select("td[class=tdm_05]");
                for (Element e : price) {
                    arrayPrice.add(e.text());
                    System.out.println(e.text());
                }

                //Парсим условия контракта
                Elements contract = docAd.select("td[class=tdm_07]");
                for (Element e : contract) {
                    arrayContract.add(e.text());
                    System.out.println(e.text());
                }

                //Парсим описание
                Elements description = docAd.select("td[class=tdm_08]");
                for (Element e : description) {
                    arrayDescriptionAd.add(e.text());
                    System.out.println(e.text());
                }




            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}