package var;
import org.jsoup.nodes.Document;
import java.util.ArrayList;


public class MainVar {

    private  Document doc;
    private  Document docAd;
    private ArrayList<String> arrayLinks = new ArrayList<>(); // ссылки
    private  ArrayList<String> arrayIds = new ArrayList<>(); //ИД объявлений
    private  ArrayList<String> arrayData = new ArrayList<>(); //Дата объявления
    private  ArrayList<String> arrayStreets = new ArrayList<>(); //Улицы tdm_rn
    private  ArrayList<String> arrayDealType = new ArrayList<>(); //Тип сделки tdm_01
    private  ArrayList<String> arrayMetro = new ArrayList<>(); //Метро tdm_03
    private  ArrayList<String> arraySo = new ArrayList<>(); //So tdm_041
    private  ArrayList<String> arraySp = new ArrayList<>(); //Sp tdm_042
    private ArrayList<String> arraySk = new ArrayList<>(); //Sk tdm_043
    private ArrayList<String> arrayEt = new ArrayList<>(); //Et tdm_044
    private ArrayList<String> arraySy = new ArrayList<>(); //Sy tdm_045
    private ArrayList<String> arrayTypeAd = new ArrayList<>(); //тип объявления tdm_04
    private ArrayList<String> arrayPrice = new ArrayList<>(); //Цена tdm_05
    private ArrayList<String> arrayContract = new ArrayList<>(); //Условия контракта tdm_07
    private  ArrayList<String> arrayDescriptionAd = new ArrayList<>(); //описание объявления tdm_08
    private String mainSite = "http://www.arenda-piter.ru"; // Главный сайт
    private String comaDelimiter = ","; // Разделитель для csv файла
    private String newLineSeparator = "\n"; //Новая строка



    public String getComaDelimiter() {
        return comaDelimiter;
    }

    public void setComaDelimiter(String comaDelimiter) {
        this.comaDelimiter = comaDelimiter;
    }

    public String getNewLineSeparator() {
        return newLineSeparator;
    }

    public void setNewLineSeparator(String newLineSeparator) {
        this.newLineSeparator = newLineSeparator;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public Document getDocAd() {
        return docAd;
    }

    public void setDocAd(Document docAd) {
        this.docAd = docAd;
    }

    public ArrayList<String> getArrayLinks() {
        return arrayLinks;
    }

    public void addDataToArrayLinks(String arrayLinks) {
        this.arrayLinks.add(arrayLinks);
    }

    public ArrayList<String> getArrayIds() {
        return arrayIds;
    }

    public void setArrayIds(ArrayList<String> arrayIds) {
        this.arrayIds = arrayIds;
    }

    public ArrayList<String> getArrayData() {
        return arrayData;
    }

    public void setArrayData(ArrayList<String> arrayData) {
        this.arrayData = arrayData;
    }

    public ArrayList<String> getArrayStreets() {
        return arrayStreets;
    }

    public void addDataToArrayStreets(String arrayStreets) {
        this.arrayStreets.add(arrayStreets);
    }

    public ArrayList<String> getArrayDealType() {
        return arrayDealType;
    }

    public void setArrayDealType(ArrayList<String> arrayDealType) {
        this.arrayDealType = arrayDealType;
    }

    public ArrayList<String> getArrayMetro() {
        return arrayMetro;
    }

    public void setArrayMetro(ArrayList<String> arrayMetro) {
        this.arrayMetro = arrayMetro;
    }

    public ArrayList<String> getArraySo() {
        return arraySo;
    }

    public void setArraySo(ArrayList<String> arraySo) {
        this.arraySo = arraySo;
    }

    public ArrayList<String> getArraySp() {
        return arraySp;
    }

    public void setArraySp(ArrayList<String> arraySp) {
        this.arraySp = arraySp;
    }

    public ArrayList<String> getArraySk() {
        return arraySk;
    }

    public void setArraySk(ArrayList<String> arraySk) {
        this.arraySk = arraySk;
    }

    public ArrayList<String> getArrayEt() {
        return arrayEt;
    }

    public void setArrayEt(ArrayList<String> arrayEt) {
        this.arrayEt = arrayEt;
    }

    public ArrayList<String> getArraySy() {
        return arraySy;
    }

    public void setArraySy(ArrayList<String> arraySy) {
        this.arraySy = arraySy;
    }

    public ArrayList<String> getArrayTypeAd() {
        return arrayTypeAd;
    }

    public void setArrayTypeAd(ArrayList<String> arrayTypeAd) {
        this.arrayTypeAd = arrayTypeAd;
    }

    public ArrayList<String> getArrayPrice() {
        return arrayPrice;
    }

    public void setArrayPrice(ArrayList<String> arrayPrice) {
        this.arrayPrice = arrayPrice;
    }

    public ArrayList<String> getArrayContract() {
        return arrayContract;
    }

    public void setArrayContract(ArrayList<String> arrayContract) {
        this.arrayContract = arrayContract;
    }

    public ArrayList<String> getArrayDescriptionAd() {
        return arrayDescriptionAd;
    }

    public void setArrayDescriptionAd(ArrayList<String> arrayDescriptionAd) {
        this.arrayDescriptionAd = arrayDescriptionAd;
    }

    public String getMainSite() {
        return mainSite;
    }

    public void setMainSite(String mainSite) {
        this.mainSite = mainSite;
    }


}
