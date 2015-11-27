package ad.parsers;

import ad.objects.adInfo;
import db.connection.DbConn;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;


/*Вытаскиваем информацию из ссылок полученных через класс Link */



public class Ad extends Link {
    @Override
    public  void getLinks(){ super.getLinks();}

    public void getAdInfo(){

        String mainSite = "http://arenda-piter.ru";
        adInfo adInfo = new adInfo();
        DbConn dbConn = new DbConn();
        dbConn.getDbConnection();
        for (int i = 0; i < linksSet.size() ; i++) {
            String link = mainSite+linksSet.toArray()[i];
            try {
                System.out.println("Получаем PHPSESSID");
                org.jsoup.Connection.Response res = Jsoup
                        .connect(mainSite+linksSet.toArray()[i])
                        .method(org.jsoup.Connection.Method.POST)
                        .execute();

                Map<String, String> cookies = res.cookies();
                String PHPSESSID = cookies.toString().replace("{","").replace("}","");
                System.out.println("PHPSESSID : "+PHPSESSID);
                Document doc = Jsoup.connect(mainSite+linksSet.toArray()[i]).cookies(cookies).timeout(10 * 1000).get();
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                System.out.println("Получаем дату :" + sqlDate);

                System.out.println("Запись объявления "+i+" в базу началась....");
                PreparedStatement stmt = dbConn.conn.prepareStatement("insert into ad (adID, post_date, deal_type, address, subway, so, sp, sk, sy, et, type, price, contract, furniture, fridge, television, phone, internet, stm, agent_phone, description, is_published, last_check)"
                        + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                stmt.setLong (1, adInfo.getAdId().getId(doc));
                stmt.setString (2, adInfo.getAdDate().getDate(doc));
                stmt.setString (3, adInfo.getAdDealType().getDealType(doc));
                stmt.setString (4, adInfo.getAdAddress().getAddress(doc));
                stmt.setString (5, adInfo.getAdSubway().getSubway(doc));
                stmt.setString (6, adInfo.getAdSo().getSo(doc));
                stmt.setString (7, adInfo.getAdSp().getSp(doc));
                stmt.setString (8, adInfo.getAdSk().getSk(doc));
                stmt.setString (9, adInfo.getAdSy().getSy(doc));
                stmt.setString (10, adInfo.getAdEt().getEt(doc));
                stmt.setString (11, adInfo.getAdType().getType(doc));
                stmt.setString (12, adInfo.getAdPrice().getPrice(doc));
                stmt.setString (13, adInfo.getAdContract().getContract(doc));
                stmt.setString (14, adInfo.getAdDescription().isFurniture(doc));
                stmt.setString (15, adInfo.getAdDescription().isFridge(doc));
                stmt.setString (16, adInfo.getAdDescription().isTv(doc));
                stmt.setString (17, adInfo.getAdDescription().isTel(doc));
                stmt.setString (18, adInfo.getAdDescription().isInternet(doc));
                stmt.setString (19, adInfo.getAdDescription().isStM(doc));
                stmt.setString (20, adInfo.getAdAgent().getNumber(doc, link, PHPSESSID));
                stmt.setString (21, adInfo.getAdDescription().getDescription(doc));
                stmt.setString (22, "0");
                stmt.setDate (23, sqlDate);
                stmt.execute();
                System.out.println("Объявление "+(i+1)+" успешно добавлено!");
                int remain = + linksSet.size()-(i+1);
                System.out.println("Осталось добабавить :"+remain);




            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Объявления успешно добавлены в базу, закрываем соединение");
        try {
            dbConn.conn.close();
            System.out.println("Соединение с базой закрыто");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
