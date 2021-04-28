import java.util.ArrayList;
import java.lang.Math;

public class TheSystem {

    private static double balance;
    private static ArrayList<Bond> portfolio;

    public TheSystem() {
        balance = 100;
        portfolio = new ArrayList<Bond>();
    }

    public void add_bond(Bond bond) {
        portfolio.add(bond);
    }

    public static double getBalance() {
      return balance;
    }

    public static ArrayList<Bond> getPortfolio() {
      return portfolio;
    }

    public static double payout(Bond bond) {

      double returnVal = 0;
      double price = bond.getPrice();
      double term = bond.getTerm();
      double coupon = bond.getCoupon();

      for (int i = 1; i < term; i++) {
        returnVal += (price*coupon);
      }

      returnVal += (price + price*coupon);
      double val = returnVal * (100/price);
      return val;
    }

    public static double value(Bond bond, double rate) {

      double returnVal = 0;
      double price = bond.getPrice();
      double term = bond.getTerm();
      double coupon = bond.getCoupon();
      for (int i = 1; i < term; i++) {
        returnVal += (price*coupon) / Math.pow((1 + rate),i);
      }
      returnVal += (price + price*coupon) / Math.pow((1 + rate),term);
      return returnVal * (100/price);
    }

    public static double macaulayDuration (Bond bond, double rate) {

      double returnVal = 0 ;
      double price = bond.getPrice();
      double term = bond.getTerm();
      double coupon = bond.getCoupon();

      for (int i = 1; i < term; i++) {
       returnVal += i*(coupon*price) / Math.pow((1+rate),i);
      }

      returnVal += term * (1+coupon)*price / Math.pow((1+rate),term);

      return returnVal/value(bond , rate) * (100/price);
    }

    public static double irr (Bond bond) {

      double r = 0.05;
      double price = bond.getPrice();
      for(long i = 0; i < 100000; i++){

      if(value(bond,r) == price) break;
      else if (value(bond,r) > price){ r = r + 0.0001;}
      else { r = r - 0.0001; }
    }

    return r;
    }
}
