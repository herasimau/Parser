package ad.objects;


import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class adAgent {
    private String number;
    private String nom;
    private String sss;
    private String adId;
    public String getNumber(Document doc, String link, String PHPSESSID) throws MalformedURLException {
        /*Сначала получем Id объявления, затем ищем nom и sss*/
        try {
            Elements adIds = doc.select("a[href*=/workpage.php?page=variant");
            adId = (adIds.first().ownText().replace("№", ""));
            Elements agentNom = doc.select("span[id=tl" + adId);
            String span = agentNom.toString();
            Pattern pattern = Pattern.compile("'(?:[^']|'')+'");
            ArrayList<String> values = new ArrayList<>();
            Matcher matcher = pattern.matcher(span);
            while (matcher.find()) {
                values.add(matcher.group());
            }
            nom = values.get(1).replace("'", ""); //Найденный nom
            sss = values.get(2).replace("'", ""); //Найденный sss


            if (nom != null && sss != null) {

                URL url = new URL("http://www.arenda-piter.ru/tiptel.php");
                Map<String, Object> params = new LinkedHashMap<>();
                params.put("nom", nom);
                params.put("sss", sss);


                StringBuilder postData = new StringBuilder();
                for (Map.Entry<String, Object> param : params.entrySet()) {
                    if (postData.length() != 0) postData.append('&');
                    postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                    postData.append('=');
                    postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
                }
                byte[] postDataBytes = postData.toString().getBytes("UTF-8");

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                conn.setRequestProperty("Host", "www.arenda-piter.ru");
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:42.0) Gecko/20100101 Firefox/42.0");
                conn.setRequestProperty("Accept", "*/*");
                conn.setRequestProperty("Refer", link);
                conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");
                conn.setRequestProperty("Cookie", "_ym_uid=1447431878410888320; "+PHPSESSID+"; _ym_isad=1");
                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);

                Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                StringBuilder str = new StringBuilder();
                for (int c = in.read(); c != -1; c = in.read()) {
                    str.append((char) c);
                }
                number = str.toString();

                conn.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return number;


    }
}



