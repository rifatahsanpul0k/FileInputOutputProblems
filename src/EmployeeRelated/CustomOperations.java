package EmployeeRelated;
import java.io.*;
import java.util.Scanner;

public class CustomOperations {
    File file = new File("employee.txt");
    File file1 = new File("information");
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CustomOperations c = new CustomOperations();
        c.employeeInformation();
        c.averageScore();
        c.findMaximum();
    }
    private void employeeInformation(){
        try{
            FileWriter fw = new FileWriter("employee.txt");
            PrintWriter pw = new PrintWriter(fw);

            int n = 2;

            for (int i = 1; i<=n; i++){
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.println("ID: ");
                String id = scanner.next();
                System.out.println("Performance: ");
                int[] a = new int[6];
                int sum = 0;
                for (int j = 0; j < 6; j++){
                    a[j] = scanner.nextInt();
                    sum+=a[j];
                    a[j] = 0;
                }

                double average = sum/6;
                sum=0;
                pw.println("name: "+name);
                pw.println("ID: "+id);
                pw.println("average: "+average);
                pw.println();


            }
            pw.close();
            System.out.println("Employee Information Added Successfully!");
            scanner.nextLine();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void averageScore(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//to read from the file
            PrintWriter pr = new PrintWriter(file1);//to write down

            String name = null;
            double score = 0;

            String line;
            //read file
            while((line = br.readLine())!= null){
                if (line.startsWith("name: ")){
                    name = line;
                } else if(line.startsWith("average: ")){
                    score = Double.parseDouble(line.substring("average: ".length()));
                }
                if (score>75){
                    pr.println(name);
                }
            }
            br.close();
               pr.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void findMaximum(){
        try{
            BufferedReader br1 = new BufferedReader(new FileReader("employee.txt"));
            String name;
            double score = 0;

            String maxName = null;


            double maxScore = 0;
            String line;
            while((line = br1.readLine())!=null){
                if (line.startsWith("name: ")){
                    name = line;
                } else if (line.startsWith("average: ")) {
                    score = Double.parseDouble(line.substring("average".length()));
                    if (score > maxScore){
                        maxScore = score;
                        maxName = line;
                    }
                }

            }
            System.out.println("Employee name: "+maxName);
            System.out.println("Score: "+score);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
