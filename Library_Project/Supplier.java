import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supplier 
{
    private String supplierName;
    private List<Book> availableBooks;
    private Library lib;

    public Supplier(Library lib, Scanner sc)
    {
        System.out.println("Please Provide the Supplier's Name");
        supplierName=sc.nextLine();
        availableBooks=new ArrayList<Book>();
        this.lib=lib;
        lib.addSupplier(this);
    }

    public String getName()
    {
        return supplierName;
    }

    public Library getLib()
    {
        return lib;
    }
    public void addBook(Book book)
    {   
        boolean bool=false;
        for (Book b:availableBooks)
        {
            if ((b.equals(book))&&(book.getState()==true))
            {
                System.out.println("Book already exists");
                bool=true;
                break;
            }
        }
        if (!bool)
            {
                availableBooks.add(book);
                System.out.println("The System has been added to the Supplier's Stock successfully!");
            }
    }

    public boolean verifyBookAvailabilitySupplier(Book book)
    {
        for(Book e:availableBooks)
        {
            if (e.equals(book))
                return true;
        }
        return false;
    }

}
