import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Book 
{
    private int ISBN;
    private boolean state; //true means the book is available, false if not.
    private String BookName;
    private String Category;
    private String Author;
    private List<Booking> Bookings;

    public Book(Scanner sc)
    {
        System.out.println("Please Enter the Book's ISBN");
        ISBN=sc.nextInt();
        sc.nextLine();
        System.out.println("Please Enter the Book's Name");
        BookName=sc.nextLine();
        System.out.println("Please Enter the Book's Category");
        Category=sc.nextLine();
        System.out.println("Please Enter the Book's Author");
        Author=sc.nextLine();
        Bookings=new ArrayList<Booking>();
        state=true;
    }

    public boolean equals(Book book)
    {
        if (this.ISBN==book.ISBN)
            return true;
        return false;
    }

    public String toString()
    {
        return("Book's Name: "+ BookName+" ISBN: "+ ISBN);
    }

    public int getISBN()
    {
        return ISBN;
    }
    public boolean getState()
    {
        return state;
    }
    public String getBookName()
    {
        return BookName;
    }
    public String getCategory()
    {
        return Category;
    }
    public String getAuthor()
    {
        return Author;
    }
    public List<Booking> getBookings()
    {
        return Bookings;
    }

    public void setCategory(String Category)
    {
        this.Category=Category;
    }
    public void setISBN(int ISBN)
    {
        this.ISBN=ISBN;
    }
    public void setState(boolean state)
    {
        this.state=state;
    }
    public void setBookName(String BookName)
    {
        this.BookName=BookName;
    }
    public void setAuthor(String Author)
    {
        this.Author=Author;
    }

    
}
