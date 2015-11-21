package checker;
import var.*;
import java.io.*;
import java.util.*;


public class DubChecker {

    private String line = "";
    private BufferedReader br = null;
    private HashSet<String> lines = new HashSet<>();

    //Метод для проверки csv файла на дубликаты строк
    public void checkDub() throws IOException {


        PathVar pathVar = new PathVar();
        MainVar mainVar = new MainVar();

        FileWriter fileWriter = new FileWriter(pathVar.getLinks()); //Создаем writer и указываем путь где сохраниться файл


        try {
            br = new BufferedReader(new FileReader(pathVar.getDirtyLinks())); //Читаем файл с дубликатами
            while ((line = br.readLine()) != null) {
                if (lines.add(line)) {
                    fileWriter.write(line);
                    fileWriter.append(mainVar.getNewLineSeparator());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}


