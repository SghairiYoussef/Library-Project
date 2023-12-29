import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Booking 
{
    private User user;
    private Book book;
    private LocalDate lendDate;
    private LocalDate expectedReturnDate;
    private LocalDate actualReturnDate;

    public Booking(User user,Book book,int n, Scanner sc)
    {
        this.user=user;
        this.book=book;
        System.out.println("Please Enter the lendDate");
        String lendDateStr=sc.nextLine();
        lendDate = parseDate(lendDateStr);
        ExpectedReturnDateSystem(n);
    }

    public String toString()
    {
        return("user: "+user.toString()+", book: "+book.toString()+" ,lendDate: "+lendDate.toString()+" ,Expected Return Date: "+expectedReturnDate.toString());
    }
    
    public Book getBook()
    {
        return book;
    }

    public User getUser()
    {
        return user;
    }
    public LocalDate getLendDate()
    {
        return lendDate;
    }
    public LocalDate getExpectedReturnDate()
    {
        return expectedReturnDate;
    }
    public LocalDate getActualReturnDate()
    {
        return actualReturnDate;
    }
    public void setActualReturnDate(LocalDate date)
    {
        this.actualReturnDate=date;
    }
    private LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr, formatter);
    }
    
    public void ExpectedReturnDateSystem(int n)
    {
        expectedReturnDate = lendDate.plusDays(n);
    }
}