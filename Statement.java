import java.util.Enumeration;

public abstract class Statement {
	abstract String resultado_customer(Customer aCustomer);
	abstract String resultado_rental(Enumeration rentals);
	abstract String resultado_ow(Customer aCustomer);
    abstract String resultado_earned(Customer aCustomer);
	public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = resultado_customer(aCustomer);
        while (rentals.hasMoreElements()) {
           result += resultado_rental(rentals);
        }
        result += resultado_ow(aCustomer);
        result += resultado_earned(aCustomer);
        return result;
     }
}