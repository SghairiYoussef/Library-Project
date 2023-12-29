import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoWorkingSpace 
{
    private Library lib;
    private String cwsName;
    private List<premiumUser> Access;

    public CoWorkingSpace(Library lib, Scanner sc)
    {
        System.out.println("Please Give the Library's CoWorking Space Name, ONLY PREMIUM MEMBERS HAVE ACCESS TO THIS SPACE.");
        cwsName=sc.nextLine();
        this.lib=lib;
        Access=new ArrayList<premiumUser>();
    }

    public List<premiumUser> getAccess()
    {
        return Access;
    }
    
    public void addUser(premiumUser user)
    {
        Access.add(user);
    }

    public Library getLib()
    {
        return lib;
    }

    public String getName()
    {
        return cwsName;
    }
}
