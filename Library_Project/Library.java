import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library
{
    private List<Book> Books;
    private List<User> Users;
    private List<BookOrder> BookOrders;
    private List<Supplier> Suppliers;
    private CoWorkingSpace cws;

    public Library()
    {
        Books=new ArrayList<Book>();
        Users=new ArrayList<User>();
        BookOrders=new ArrayList<BookOrder>();
        Suppliers=new ArrayList<Supplier>();
    }

    public List<User> getUsers()
    {
        return Users;
    }

    public List<Book> getBooks()
    {
        return Books;
    }
    public void addBook(Book book)
    {
        boolean bool=false;
        for (Book b:Books)
        {
            if ((b.equals(book))&&(book.getState()==true))
            {
                System.out.println("Book already exists");
                bool=true;
                break;
            }
            else if (b.equals(book))
            {
                book.setState(true);
                bool=true;
                break;
            }
        }
        if (!bool)
            {
                Books.add(book);
                book.setState(true);
                System.out.println("The Book Has Been added to library's Stock successfully!");
            }
    }

    public void addBook(Scanner sc)
    {   
        Book book=new Book(sc);
        addBook(book);
    }

    public void addSupplier(Supplier supplier)
    {
        Suppliers.add(supplier);
    }

    public void addUser(Scanner sc)
    {
        User user;
        System.out.println("Is the user a premiumUser?");
        System.out.println("1. Yes.");
        System.out.println("2. No");
        int answer=sc.nextInt();
        sc.nextLine();
        if (answer==1)
        {
            user=new premiumUser(this,sc);
        }
        else
        {
            user=new User(this,sc);
        }
        boolean bool=false;
        for (User u:Users)
        {
            if (u.Membership==user.Membership)
            {
                System.out.println("Membership already exists");
                bool=true;
                break;
            }
        }
        if (!bool)
            {
                Users.add(user);
                System.out.println("The User Has Been added to library's list successfully!");
            }
    }

    public void removeUser(User user)
    {
        Users.remove(user);
        user=null;
        System.out.println("The User Has Been deleted from the library's list!");
    }
    
    public CoWorkingSpace getCoWorkingSpace()
    {
        return (cws);
    }

    public void setCoWorkingSpace(CoWorkingSpace cws)
    {
        this.cws=cws;
    }

    public boolean verifyBookAvailability(Book book)
    {
        for (Book e:Books)
        {
            if(e.equals(book))
            {
                if (e.getState()==true)
                    return true;
                break;
            }
        }
        return false;
    }

    public void orderBook(Book book)
    {
        boolean verif=false; 
        for (Supplier s:Suppliers)
        {
            if (s.verifyBookAvailabilitySupplier(book))
            {
                BookOrder bookOrder=new BookOrder(book);
                BookOrders.add(bookOrder);
                verif=true;
                addBook(book);
            }
        }
        if(!verif)
        {
            System.out.println("Sorry The Book Is Not Available in any of our Suppliers' Stock!");
        }
    }
}