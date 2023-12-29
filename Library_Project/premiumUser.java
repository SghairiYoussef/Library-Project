import java.util.Scanner;

public class premiumUser extends User
{
    private int tier;
    public premiumUser(Library lib, Scanner sc)
    {
        super(lib,sc);
        boolean verif=false;
        while (!verif)
        {
            verif=true;
            System.out.println("Please enter the premium User's tier (1->3, 3 Being the best offer.)");
            int t=sc.nextInt();
            switch (t) {
                case 1:
                this.loyaltyPoints=3;
                break;
            case 2:
                this.loyaltyPoints=5;
                break;
            case 3:
                this.loyaltyPoints=10;
                break;
        
            default:
            verif=false;
            System.out.println("The tier can only be between 1 and 3, 3 being the best");
                break;
            }
            tier=t;
        }
        lib.getCoWorkingSpace().addUser(this);
        System.out.println("The User has gained access to The CoWorkingSpace!");
    }

    public String toString()
    {
        return("Premium Member's Name: "+ userName+" Membership: "+ Membership+" tier: "+tier);
    }

    public void addBooking(Book book, Scanner sc)
    {
        Booking booking;
        if (lib.verifyBookAvailability(book))
        {
            switch (tier) 
            {
                case 1:
                    booking=new Booking(this, book,9,sc);
                    break;
                case 2:
                    booking=new Booking(this, book,11,sc);
                    break;
                case 3:
                    booking=new Booking(this, book,14,sc);
                    break;
            
                default:
                    booking=new Booking(this, book,7,sc);
                    break;
            }
            userBookings.add(booking);
            book.getBookings().add(booking);
            book.setState(false);
            loyaltyPoints++;
        }
        else
        {
            System.out.println("Book currently unavailble but an order has been sent to our Suppliers! Accordingly to the next message, Try reordering the book.");
            lib.orderBook(book);
            loyaltyPoints+=2;
        }
    }
}
