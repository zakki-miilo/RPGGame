import java.io.*;

public class Story {
    File input = new File("./resourceText/Chapter01.txt");
    File town = new File("./resourceText/Town.txt");
    public void intro() throws FileNotFoundException {
        FileReader fr = new FileReader(input);
        BufferedReader inputS = new BufferedReader(fr);
        try {
            String line;
            while ((line = inputS.readLine())!=null) {
                System.out.println(line);
            }
            inputS.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public void toTown() throws FileNotFoundException {
        FileReader fr = new FileReader(town);
        BufferedReader inputS = new BufferedReader(fr);
        try {
            String line;
            while ((line = inputS.readLine())!= null) {
                System.out.println(line);
            }
            inputS.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

}
