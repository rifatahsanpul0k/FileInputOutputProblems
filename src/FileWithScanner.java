import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileWithScanner {
    public static void main(String[] args) {
        String line;
        File file = new File("pulok.txt");
        try {
            if (!file.exists())
                file.createNewFile();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {

                line = scanner.nextLine();
                System.out.println(line);

            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file1 = new File("farhana.txt");
        try{
            if (!file1.exists()){
                file1.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file1);
            pw.println("I am sorry Farhana");
            pw.close();
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}