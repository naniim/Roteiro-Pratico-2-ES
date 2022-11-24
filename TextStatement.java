import java.util.Enumeration;

public class TextStatement extends Statement {

    public String resultado_customer(Customer aCustomer){
        return "Rental Record for " + aCustomer.getName() +
        "\n";
    }

    public String resultado_rental(Enumeration rentals){
        Rental each = (Rental) rentals.nextElement();
        return "\t" + each.getMovie().getTitle()+ "\t" +
        String.valueOf(each.getCharge()) + "\n";
    }

    public String resultado_ow(Customer aCustomer){
        return "Amount owed is " +
        String.valueOf(aCustomer.getTotalCharge()) + "\n";
    }

    public String resultado_earned(Customer aCustomer){
        return "You earned " +
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        " frequent renter points";
    }

}