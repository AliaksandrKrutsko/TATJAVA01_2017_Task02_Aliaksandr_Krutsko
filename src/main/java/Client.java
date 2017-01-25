import java.io.IOException;

public class Client {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void rentItem() throws IOException {
        Shop shop = new Shop();
        shop.fromFileToMap();
        shop.rentItem();

    }


}
