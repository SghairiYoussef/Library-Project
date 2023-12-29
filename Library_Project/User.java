import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class User
{
    protected Library lib;
    protected List<Booking> userBookings;
    protected String userName;
    protected int Membership;
    protected int loyaltyPoints=0;
    protected int numberOfSanctions=0;


    public User(Library lib, Scanner sc)
    {
        this.lib=lib;
        System.out.println("Please Enter the User's Membership");
        Membership=sc.nextInt();
        sc.nextLine();
        System.out.println("Please Enter the User's Name");
        userName=sc.nextLine();
        userBookings=new ArrayList<Booking>();
    }

    public String toString()
    {
        return("Member's Name: "+ userName+" Membership: "+ Membership);
    }

    public void returnBook (Scanner sc) throws Exception
    {
        System.out.println("Please Enter the Return Date");
        String DateStr=sc.nextLine();
        LocalDate Date = parseDate(DateStr);
        Booking booking=userBookings.get(userBookings.size()-1);
        booking.setActualReturnDate(Date);
        Sanctions_loyaltyPoints_System();
        booking.getBook().setState(true);
    }

    public void addBooking(Book book, Scanner sc)
    {
        boolean verif=lib.verifyBookAvailability(book);
        if (verif)
        {
            Booking booking=new Booking(this, book,7,sc);
            userBookings.add(booking);
            book.getBookings().add(booking);
            for ( Book b :lib.getBooks())
            {
                if (b.equals(book))
                {
                    book.setState(false);
                    b.setState(false);
                    break;
                }
            }
            loyaltyPoints++;
            userBookings.add(booking);
        }
        else
            System.out.println("Book Currently unavailable");
    }

    public List<Booking> getBookings()
    {
        return userBookings;
    }
    private LocalDate parseDate(String dateStr) throws Exception{
        
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(dateStr, formatter);
    }

    public void Sanctions_loyaltyPoints_System()
    {
        for (Booking e:userBookings)
        {
            if ((e.getExpectedReturnDate().compareTo(e.getActualReturnDate()))<0)
            {
                long diffInDays=e.getExpectedReturnDate().until(e.getActualReturnDate(),ChronoUnit.DAYS);
                numberOfSanctions=(int)((diffInDays%7)*3)+(int)(diffInDays-(diffInDays)%7);
            }
            else
            {
                if (numberOfSanctions>0)
                    numberOfSanctions--;
                loyaltyPoints++;
            }
        }
        loyaltyPoints-=numberOfSanctions;
        if (loyaltyPoints<0)
        {
            System.out.println("The User with the Membership: "+Membership+" has been banned due to losing all his loyalty Points!");
            lib.removeUser(this);
        }
    }
}
