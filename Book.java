

public class Book extends Product  {
    private String author ;
    private int pubYear ;
    private int isbn  ;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPubYear(int pubYear) {
        this.pubYear = pubYear;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Book(String name, int price, int quantity, String author, int pubYear, int isbn,Seller seller) {
        super(name, price, quantity,seller);
        this.author = author;
        this.pubYear = pubYear;
        this.isbn = isbn;
    }
}
