import java.util.Map;

public class SportEquipment {

    private String title;
    private Float price;
    private boolean availability;


    public SportEquipment(String title, Float price, boolean availability) {

        this.title = title;
        this.price = price;
        this.availability = availability;

    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public float getPrice() {

        return price;

    }

    public void setPrice(float price) {

        this.price = price;

    }

    public Boolean isAvailable() {
        return availability;
    }

    public void setAvability(boolean avability) {
        this.availability = avability;
    }





}
