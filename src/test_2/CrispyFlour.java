package test_2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CrispyFlour extends Material implements Discount {
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        setManufacturingDate(getManufacturingDate().plusYears(1));
        return getManufacturingDate();
    }

    @Override
    public double getRealMoney() {
        long month = ChronoUnit.MONTHS.between(LocalDate.now(), getExpiryDate());
        double realMoney;

        if (month <= 2 && month >= 0) {
            System.out.println("Discount 40%");
            realMoney = getAmount() * (0.6);
        } else if (month <= 4 && month > 2) {
            System.out.println("Discount 20%");
            realMoney = getAmount() * (0.8);
        } else if (month <= 12 && month > 4) {
            System.out.println("Discount 5%");
            realMoney = getAmount() * (0.95);
        } else {
            System.out.println("The material has expired!!");
            realMoney = 0;
        }

        return realMoney;
    }


    @Override
    public String toString() {
        return super.toString() + " Quantity: " + quantity;
    }

    public String checkRealMoney() {
        getRealMoney();
        if (getRealMoney() != 0) {
            return "Real money after discount: " + getRealMoney();
        } else {
            return "The product has expired!!!";
        }
    }
}
