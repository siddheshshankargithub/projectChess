import javax.swing.*;
import java.io.*;

public class FileDemo
{
    public static void main(String[] args)
    {
        String PlayerId = "1";
        String PlayerName = "Siddhesh";
        String PlayerAge = "19";
        String filePath = "demo.csv";
        saveRecord(PlayerId,PlayerName,PlayerAge,filePath);
    }
    public static void saveRecord(String PlayerId,String PlayerName,String PlayerAge,String filepath)
    {
        try
        {
            FileWriter fw = new FileWriter(filepath,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.println(PlayerId + ", " + PlayerName + ", " + PlayerAge);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null, "Record Saved");
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null, "Record Not Saved");
        }
    }
}

