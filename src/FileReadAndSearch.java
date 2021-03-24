import javax.swing.*;
import java.io.*;
import java.util.*;

public class FileReadAndSearch
{
    private static Scanner x;
    public static void main(String [] args)
    {
        String filePath = "demo.csv";
        String SearchItem = "1";
        String RemoveItem = "3";
        readRecord(SearchItem,filePath);
        removeRecord(filePath,RemoveItem);
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
    public static void removeRecord(String filePath, String RemoveItem)
    {
        String tempFile = "temp.csv";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);
        String Id = ""; String name = ""; String age = "";
        try
        {
            FileWriter fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while(x.hasNext())
            {
                Id = x.next();
                name = x.next();
                age = x.next();
                if(!Id.equals(RemoveItem))
                {
                    pw.println(Id + "," + name + "," + age);
                }
            }
            x.close();;
            pw.flush();;
            pw.close();;
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);
            JOptionPane.showMessageDialog(null,"Record deleted");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }

    }
}
