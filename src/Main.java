import java.io.IOException;
/* На данный момент программа работает так : Запускаем LinksAd - и получаем все ссылки с 560 страниц в csv файл,
Далее запускаем CsvChecker - который уберет дубликаты и на выходе получим новый файл в csv.
Парсинг отдельного объявления в процессе разработки, думаю над выводом в csv.
 */
public class Main {

    public static void main(String[] args) throws IOException {



       /*Включаем  CsvChecker когда нужно удалить дубликаты из файла links.csv*/

       /* CsvChecker csvChecker = new CsvChecker();
        csvChecker.checkDub();*/

        /* LinksAd - включаем когда нужно вынуть все ссылки на объявления с сайта и сохранить их в файл*/

        LinksAd linksAd = new LinksAd();
        try {
            linksAd.getAllLinksAd();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}