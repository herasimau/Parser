package ad.parsers;
import ad.objects.adInfo;
import db.connection.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
/*Вытаскиваем информацию из ссылок полученных через класс Link */



public class Ad extends Link {
    @Override
    public void getLinks() {
        super.getLinks();
    }

    public void getAdInfo(){

        String mainSite = "http://arenda-piter.ru";
        adInfo adInfo = new adInfo();

        for (int i = 0; i < linksSet.size() ; i++) {
            String link = mainSite+linksSet.toArray()[i];
            try {
                org.jsoup.Connection.Response res = Jsoup
                        .connect(mainSite+linksSet.toArray()[i])
                        .method(org.jsoup.Connection.Method.POST)
                        .execute();

                Map<String, String> cookies = res.cookies();
                String PHPSESSID = cookies.toString().replace("{","").replace("}","");

                Document doc = Jsoup.connect(mainSite+linksSet.toArray()[i]).cookies(cookies).timeout(10 * 1000).get();

                System.out.println("НОМЕР :"+adInfo.getAdAgent().getNumber(doc, link, PHPSESSID));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
