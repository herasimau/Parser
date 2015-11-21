package var;

public class PathVar {


    private String dirtyLinks = "D:\\dirtyLinks.csv"; //Путь для сохранения грязного файла с дубликатами
    private String links = "D:\\clearLinks.csv"; //Путь для сохранения грязного файла с дубликатами
    private String adData = "D:\\adData.csv"; // Путь для сохранения информации из отдельного объявления

    public String getDirtyLinks() {
        return dirtyLinks;
    }

    public String getLinks() {
        return links;
    }

    public String getAdData() {
        return adData;
    }
}
