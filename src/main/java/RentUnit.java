import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RentUnit {

    String filename = "rented.txt";
    String workingDirectory = System.getProperty("user.dir");
    String FilePath = workingDirectory + File.separator + filename;
    File file = new File(FilePath);

    int numberOf;
    String itemRented;

    private Map<Integer, String> units = new HashMap<Integer, String>();

    public void fromFileToArray() throws IOException {

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while ((line = reader.readLine()) != null) {
            String[] part = line.split(",", 2);

            if (part.length >= 3) {
                numberOf = Integer.parseInt(part[0]);
                itemRented = part[1];
                units.put(numberOf, itemRented);
            } else {

            }
        }
        reader.close();

    }



}
