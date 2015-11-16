import java.io.*;
import java.util.*;

//Класс для проверки csv файла на дубликаты строк

public class CsvChecker {
    public void checkDub() throws IOException {

        DataVar dataVar = new DataVar();
        BufferedReader br = null;
        String line = "";
        FileWriter fileWriter = new FileWriter(dataVar.getLinks()); //Создаем writer и указываем путь где соханиться файл
        HashSet<String> lines = new HashSet<>();

        
        try {
            br = new BufferedReader(new FileReader(dataVar.getDirtyLinks())); //Читаем файл с дубликатами
            while ((line = br.readLine()) != null) {
                if (lines.add(line)) {
                    fileWriter.append(line);
                    fileWriter.append(dataVar.getNewLineSeparator());
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


