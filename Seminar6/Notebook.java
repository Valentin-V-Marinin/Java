import java.util.Objects;

public class Notebook {

    private int hdd;
    private int ozu;
    private int screen;
    private String os;
    private String color;
    private String model;
    private double price;

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getOzu() {
        return ozu;
    }

    public void setOzu(int ozu) {
        this.ozu = ozu;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >=0) this.price = price;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "model=" + model +
                ", hdd='" + hdd + '\'' +
                ", ozu=" + ozu +
                ", screen=" + screen +
                ", os='" + os + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Notebook notebook)) return false;
        return getHdd() == notebook.getHdd() && getOzu() == notebook.getOzu() && getScreen() == notebook.getScreen() && Double.compare(notebook.getPrice(), getPrice()) == 0 && getOs().equals(notebook.getOs()) && getColor().equals(notebook.getColor()) && getModel().equals(notebook.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHdd(), getOzu(), getScreen(), getOs(), getColor(), getModel(), getPrice());
    }
}