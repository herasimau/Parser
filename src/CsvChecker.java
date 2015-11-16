import java.io.*;
import java.util.*;

//Класс для проверки csv файла на дубликаты строк

public class CsvChecker {
    public void checkDub() throws IOException {
        String csvFile = "D:\\links.csv";
        BufferedReader br = null;
        String line = "";
        String newLineSeparator = "\n";
        String csv = "D:\\links2.csv";
        FileWriter fileWriter = new FileWriter(csv);
        HashSet<String> lines = new HashSet<>();



        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                if (lines.add(line)) {
                    fileWriter.append(line);
                    fileWriter.append(newLineSeparator);
                    System.out.println(line);
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


