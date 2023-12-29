import java.util.InputMismatchException;
import java.util.Scanner;

public class mainClass
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Library lib=new Library();
        CoWorkingSpace cws=new CoWorkingSpace(lib,sc);
        lib.setCoWorkingSpace(cws);
        while (true)
        {
            try
            {
                System.out.println("\n----Welcome To The Library System's project!----\n");
                System.out.println("1. Add User");
                System.out.println("2. Add Book To The Library");
                System.out.println("3. User's space");
                System.out.println("4. Supplier's space");
                System.out.println("5. Show the Users' List.");
                System.out.println("6. Show the Books' List");
                System.out.println("7. Quit");
                int menu=sc.nextInt();
                sc.nextLine();
                switch (menu) 
                {
                    case 1:
                        lib.addUser(sc);
                        break;
                    case 2:
                        lib.addBook(sc);
                        break;
                    case 3:
                        User user=null;
                        System.out.println("Please provide the user's Membership!");
                        int Membership=sc.nextInt();
                        boolean bool=false;
                        for (User u:lib.getUsers())
                        {
                            if (u.Membership==Membership)
                            {
                                user=u;
                                bool=true;
                                break;
                            }
                        }
                        if (bool)
                        {
                            System.out.println("Welcome Back "+user.userName+" !\n What Do You Wish to Do?");
                            while(true)
                            {
                                System.out.println("1. Return A Book");
                                System.out.println("2. Get A Booking");
                                System.out.println("3. Get a List of your previous Bookings");
                                System.out.println("4. Quit");
                                int userMenu=sc.nextInt();
                                sc.nextLine();
                                boolean exit=false;
                                switch (userMenu) 
                                {
                                    case 1:
                                        user.returnBook(sc);
                                        break;
                                    case 2:
                                        user.addBooking(new Book(sc),sc);
                                        break;
                                    case 3:
                                        System.out.println(user.getBookings().toString());
                                        break;
                                    default:
                                        exit=true;
                                        break;
                                }
                                if (exit)
                                    break;
                            }
                        }
                        else
                        {
                            System.out.println("ERROR: User not registered in the library's list!");
                        }
                        break;
                    case 4:
                        Supplier Supp=new Supplier(lib,sc);
                        while (true)
                        {
                            System.out.println("1. Add Book.");
                            System.out.println("2. Verify Book's availability.");
                            System.out.println("3. Quit");
                            int supplierMenu=sc.nextInt();
                            sc.nextLine();
                            boolean verifsupp=false;
                            switch (supplierMenu) 
                            {
                                case 1:
                                    Supp.addBook(new Book(sc));
                                    break;
                                case 2:
                                    if (Supp.verifyBookAvailabilitySupplier(new Book(sc)))
                                        System.out.println("The Book is Available!");
                                    else
                                        System.out.println("The Book is unfortunately out of Stock.. Try Again Later!");
                                    break;
                            
                                default:
                                    verifsupp=true;
                                    break;
                            }
                            if (verifsupp)
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("Users: "+lib.getUsers().toString());    
                        break;
                    case 6:
                        System.out.println("Books: "+lib.getBooks().toString());     
                        break;
                        
                    case 7:
                        System.out.println("Thanks For Your Visit!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong Input!");
                        break;
                }
            }
        
            catch (InputMismatchException IME) 
            {
                System.out.println("ERROR: Invalid input.");
            } 
            catch (Exception e) 
            {
                System.out.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}