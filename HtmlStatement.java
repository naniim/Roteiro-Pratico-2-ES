import java.util.Enumeration;

public class HtmlStatement extends Statement {
    
    public String resultado_customer(Customer aCustomer){
        return "<H1>Rentals for <EM>" + aCustomer.getName() +
        "</EM></H1><P>\n";
    }
    
    public String resultado_rental(Rental each){
        return each.getMovie().getTitle()+ ": " +
        String.valueOf(each.getCharge()) + "<BR>\n";
    }

    public String resultado_ow(Customer aCustomer){
        return "<P>You owe <EM>" +
        String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
    }

    public String resultado_earned(Customer aCustomer){
        return "On this rental you earned <EM>" + 
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        "</EM> frequent renter points<P>";
    }

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = resultado_customer(aCustomer);
        while (rentals.hasMoreElements()) {
           Rental each = (Rental) rentals.nextElement();
           //show figures for each rental
           result += resultado_rental(each);
        }
        //add footer lines
        result += resultado_ow(aCustomer);
        result += resultado_earned(aCustomer);
        return result;
     }
}