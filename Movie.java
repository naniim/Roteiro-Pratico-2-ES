public class Movie {

    public static final int  CHILDRENS = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;
  
    private Price _price;
    private String _title;
    
    public Movie(String name, int priceCode) {
       _title = name;
       setPriceCode(priceCode);
    }
  
    public double getCharge(int daysRented) {
      //Adicionar o trecho de código extraído.
      double thisAmount = 0;
      switch (this.getPriceCode()) {
           case Movie.REGULAR:
              thisAmount += 2;
              if (daysRented > 2)
                 thisAmount += (daysRented - 2) * 1.5;
              break;
           case Movie.NEW_RELEASE:
              thisAmount += daysRented * 3;
              break;
           case Movie.CHILDRENS:
              thisAmount += 1.5;
              if (daysRented > 3)
                 thisAmount += (daysRented - 3) * 1.5;
               break;
        }
        return thisAmount;
   }
  
    public int getFrequentRenterPoints(int daysRented){
    //Adicionar o trecho de código extraído.
    if ((this.getPriceCode() == Movie.NEW_RELEASE) &&
            daysRented > 1) {return 2;}
         return 1;
    }
  
    public int getPriceCode() {
        return _price.getPriceCode();
    }
  
    public String getTitle (){
        return _title;
    }

    public void setPriceCode(int arg) {
        switch (arg) {
           case REGULAR:
              _price = new RegularPrice();
              break;
           case CHILDRENS:
              _price = new ChildrensPrice();
              break;
           case NEW_RELEASE:
              _price = new NewReleasePrice();
              break;
           default:
              throw new IllegalArgumentException("Incorrect Price Code");
        }
     }

  }