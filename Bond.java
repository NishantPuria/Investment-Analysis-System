import java.util.Date;

public class Bond {

    private int id;
    private String name;
    private int term;
    private double coupon;
    private int frequency;
    private double price;
    public static int numberOfBonds ;

    public Bond (String name, int term, double coupon, int frequency, double price) {
      
        this.name = name;
        this.term = term;
        this.coupon = coupon;
        this.frequency = frequency;
        this.price = price;

        // to make IDs unique
        id = ++numberOfBonds ;
    }

    public String toString() {

        String s = "- ID: " + id;
        s += "\tName: " + name +"\n";
        s += "\tPrice: " + price +"\n";
        s += "\tCoupon: " + coupon + "%" +"\n";
        s += "\tTerm: " + term +"\n";
        s += "\tFrequency: " + frequency +"\n";
        return s;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTerm() {
        return term;
    }

    public double getCoupon() {
        return coupon/100;
    }

    public int getFrequency() {
        return frequency;
    }

    public double getPrice() {
        return price;
    }
}
