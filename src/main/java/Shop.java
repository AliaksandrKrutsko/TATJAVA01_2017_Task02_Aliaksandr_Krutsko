import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop {


    private Map<SportEquipment, Integer> goods = new HashMap<SportEquipment, Integer>();


    String filename = "shop.txt";
    String workingDirectory = System.getProperty("user.dir");
    String FilePath = workingDirectory + File.separator + filename;
    File file = new File(FilePath);
    String filename2 = "rented.txt";
    String FilePath2 = workingDirectory + File.separator + filename2;
    File file2 = new File(FilePath2);


    public void fromFileToMap() throws IOException {

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        while ((line = reader.readLine()) != null) {
            String[] part = line.split(",", 4);

            if (part.length >= 4) {
                SportEquipment key = new SportEquipment(part[0], Float.valueOf(part[1]), Boolean.parseBoolean(part[2]));
                Integer value = Integer.parseInt(part[3]);
                goods.put(key, value);
            } else {
                System.out.println("to hell with this line: " + line);
            }
        }

        for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        reader.close();

    }
    
    public void rentItem() throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What are you looking for?");
        String searchKey = scanner.next();

        for (SportEquipment key : goods.keySet()) {

            if (searchKey.equals(key.getTitle())) {

                System.out.println("Found total " + goods.get(key) + " "
                        + searchKey + "s");
                break;
            }
        }

        for (SportEquipment key : goods.keySet()) {

            if (searchKey.equals(key.getTitle())) {
                Integer x = goods.get(key);
                if (x > 0) {
                    System.out.println("You can rent no more than 3 items. How many do you need?");
                    int numberOfItems = scanner.nextInt();
                    if (numberOfItems <= 3 & numberOfItems <= x) {
                        //x = x - numberOfItems;
                        //goods.put(key, x);
                        //TODO: implement possibility of editing shop.txt

                        FileWriter writer = new FileWriter(file2, true);
                        writer.write(numberOfItems + "," +searchKey + "\n");
                        writer.flush();
                        writer.close();

                        System.out.println("You've just rented " + numberOfItems + " " + searchKey + "s");
                    } else if (numberOfItems > x) {
                        System.out.println("Sorry, insufficient amount");
                    } else {
                        System.out.println("You're trying to cheat! Go away!");

                    }
                }
            }
        }


    }

    public void returnItem() {

        //TODO: make client return item

    }


}



