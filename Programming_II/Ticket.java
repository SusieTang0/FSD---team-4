/**
 * @version 1.01
 * @since 2023-12-18
 * @author Bo Sun
 */

public abstract class Ticket {
    private static int ticketCount = 0;
    private int number;
    private double price;

    public Ticket() {
        this.number = generateTicketNumber();
    }

    private int generateTicketNumber() {
        return ++ticketCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void calculatePrice();

    public String toString() {
        return "Number: " + number + ", Price: " + price;
    }
}
