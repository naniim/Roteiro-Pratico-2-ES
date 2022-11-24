import java.util.Enumeration;

public class TextStatement extends Statement {

    public String resultado_customer(Customer aCustomer){
        return "Rental Record for " + aCustomer.getName() +
        "\n";
    }

    public String resultado_rental(Rental each){
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

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = resultado_customer(aCustomer);
        while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           //show figures for this rental
           result += resultado_rental(each);
        }
        //add footer lines
        result += resultado_ow(aCustomer);
        result += resultado_earned(aCustomer);
        return result;
     }
}