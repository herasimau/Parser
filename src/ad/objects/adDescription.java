package ad.objects;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class adDescription {
    public String yes = "yes";
    public String no = "no";
    private String adDescription;


    public  String getDescription(Document doc){
        Elements adDescs = doc.select("td[class=tdm_08");
        adDescription = adDescs.text().replace("Меб +", "").replace("Тв +",
                "").replace("Хол +", "").replace("СтМ +", "").replace("Тел +",
                "").replace("Инт +", "");
        return  adDescription;
    }

    public String isFurniture(Document doc){

        Elements adDescs = doc.select("td[class=tdm_08");
        adDescription = adDescs.text();
        if(adDescription.contains("Меб +")){
            return yes;
        }
        else  return no;
    }


    public String isTv(Document doc){
        Elements adDescs = doc.select("td[class=tdm_08");
        adDescription = adDescs.text();
        if(adDescription.contains("Тв +")){
            return yes;
        }
        else  return no;
    }


    public String isFridge(Document doc){
        Elements adDescs = doc.select("td[class=tdm_08");
        adDescription = adDescs.text();
        if(adDescription.contains("Хол +")){

            return yes;
        }
        else  return no;
    }

    public String isStM(Document doc){
        Elements adDescs = doc.select("td[class=tdm_08");
        adDescription = adDescs.text();
        if(adDescription.contains("СтМ +")){

            return yes;
        }
        else  return no;
    }


    public String isTel(Document doc){
        Elements adDescs = doc.select("td[class=tdm_08");
        adDescription = adDescs.text();
        if(adDescription.contains("Тел +")){

            return yes;
        }
        else  return no;
    }

    public String isInternet(Document doc){
        Elements adDescs = doc.select("td[class=tdm_08");
        adDescription = adDescs.text();
        if(adDescription.contains("Инт +")){

            return yes;
        }
        else  return  no;
    }



}
