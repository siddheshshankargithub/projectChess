import javax.swing.*;
import java.io.*;
import java.util.*;

public class FileReadAndSearch
{
    private static Scanner x;
    public static void main(String [] args)
    {
        String filePath = "demo.csv";
        String SearchItem = "Siddhesh";
        readRecord(SearchItem,filePath);
    }
    public static void readRecord(String SearchItem, String filePath)
    {
        boolean found = false;
        String Id = "";
        String name = "";
        String age = "";
        try
        {
            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");
            while(x.hasNext() && !found)
            {
                Id = x.next();
                name = x.next();
                age = x.next();

                if(Id.equals(SearchItem))
                {
                    found = true;
                }
            }
            if(found)
            {
                JOptionPane.showMessageDialog(null,"ID: " + Id + " NAME: " + name + " AGE: " + age);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Record not found");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
}
