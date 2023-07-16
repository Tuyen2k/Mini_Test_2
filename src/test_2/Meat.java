package test_2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat() {
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return weight * getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        setManufacturingDate(getManufacturingDate().plusDays(7));
        return getManufacturingDate();
    }

    @Override
    public double getRealMoney() {
        long day = ChronoUnit.DAYS.between(LocalDate.now(),getExpiryDate() );

        double realMoney;
        if (day <= 5 && day >= 0) {
            realMoney = getAmount() * (0.7);
        } else if (day <= 7 && day > 5) {
            realMoney = getAmount() * (0.9);
        } else {
            realMoney = 0;
        }

      return realMoney;
    }

    @Override
    public String toString() {
        return super.toString() + " Weight: " + weight;
    }

}
