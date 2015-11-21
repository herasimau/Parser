package parsers;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import var.AdVar;
import var.MainVar;
import var.PathVar;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

/*  */

public class SingleAdParser {

    private String csvFile = "D:\\links2.csv"; //Путь до файла где хранятся ссылки
    private String line = "";
    private AdVar adVar = new AdVar();
    private String URL = "jdbc:mysql://localhost:3306/adb";
    private String USERNAME = "root";
    private String PASSWORD = "root";

    //Метод для парсинга ID объявления
    public void parseIdAd() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(csvFile));//Читаем файл где хранятся ссылки на объявления
        Connection connection;
        try {
            //Регистрируем драйвер
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Драйвер успешно зарегестрирован!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Соединение с базой установлено!");

                while ((line = br.readLine()) != null) {
                    String link = br.readLine().replace(",", ""); //Убираем лишние запятые
                    if (link.length() == 100) { //Проверяем битая ли ссылка
                        adVar.setDocAd(Jsoup.connect(link).timeout(10 * 1000).get()); //Делаем коннект и получаем документ объявления

                        Elements adIds = adVar.getDocAd().select("a[href*=/workpage.php?page=variant"); //Выбераем ID объявления
                        String adId = adIds.first().ownText().replace("№", ""); // Сохраняем ID
                        Elements adDates = adVar.getDocAd().select("span[style=color:#666666;]"); // Дата
                        String adDate = adDates.text().replace("Выставляется в базе с ", "").replace(".", "-");
                        Elements adStreets = adVar.getDocAd().select("td[class=tdm_02]"); //Адрес
                        String adStreet = adStreets.text().replace("на карте", "");
                        Elements adDealTypes = adVar.getDocAd().select("td[class=tdm_01]");//Тип сделки
                        String adDealType = adDealTypes.text();
                        Elements adMetros = adVar.getDocAd().select("td[class=tdm_03]");
                        String adMetro = adMetros.text();
                        Elements adSos = adVar.getDocAd().select("td[class=tdm_041");
                        String adSo = adSos.text();
                        Elements adSps = adVar.getDocAd().select("td[class=tdm_042");
                        String adSp = adSps.text();
                        Elements adSks = adVar.getDocAd().select("td[class=tdm_043");
                        String adSk = adSks.text();
                        Elements adEts = adVar.getDocAd().select("td[class=tdm_044");
                        String adEt = adEts.text();
                        Elements adSys = adVar.getDocAd().select("td[class=tdm_045");
                        String adSy = adSys.text();
                        Elements adTypes = adVar.getDocAd().select("td[class=tdm_04");
                        String adType = adTypes.text();
                        Elements adPrices = adVar.getDocAd().select("td[class=tdm_05");
                        String adPrice = adPrices.text();
                        Elements adContracts = adVar.getDocAd().select("td[class=tdm_07");
                        String adContract = adContracts.text();
                        Elements adDescs = adVar.getDocAd().select("td[class=tdm_08");
                        String adDesc = adDescs.text();



                        // создаем sql запрос
                        PreparedStatement preparedStmt = connection.prepareStatement("insert into ad_info (ad_street, ad_deal_type, ad_metro, ad_So, ad_Sp, ad_Sk, ad_Et,ad_Sy,ad_type,ad_price,ad_contract,ad_desc,ad_id)"
                                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                        preparedStmt.setString (1, adStreet);
                        preparedStmt.setString (2, adDealType);
                        preparedStmt.setString (3, adMetro);
                        preparedStmt.setString (4, adSo);
                        preparedStmt.setString (5, adSp);
                        preparedStmt.setString (6, adSk);
                        preparedStmt.setString (7, adEt);
                        preparedStmt.setString (8, adSy);
                        preparedStmt.setString (9, adType);
                        preparedStmt.setString (10, adPrice);
                        preparedStmt.setString (11, adContract);
                        preparedStmt.setString (12, adDesc);
                        preparedStmt.setString (13, adId);

                        // выполняем запрос и записываем данные в базу
                        preparedStmt.execute();
                        System.out.println("Объявление "+adId+" успешно добавлено в базу!");
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
}
