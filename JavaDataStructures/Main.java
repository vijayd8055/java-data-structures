import com.weather.stats.YearAvg;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Create the Main Java Class and Create Collection Data Structures based on the CSV data.
 * 
 */
public class Main {

    public static void main(final String[] args) {
        // Create Class -Class name matches Filename
        // PSVM method required to run this as an application
        // starting point for the desktop application.

        // The YearAvg class is Based on CSV file data
        final int SZ = 66;

        YearAvg yearAvg = new YearAvg(10.0f, 1955, 12.3f);

        System.out.println(yearAvg);
        
        List<YearAvg> yearAvgs = new LinkedList<YearAvg>();

        Map<String,YearAvg> yearMap = new HashMap<String,YearAvg>();
        String header = "";
        int size = 0;
        long stime = System.currentTimeMillis();
        try {
            File file = new File("yearly.csv");
            Scanner fileIn = new Scanner(file);
            header = fileIn.nextLine();
            while (fileIn.hasNextLine()) {
                String data = fileIn.nextLine();
                System.out.println(data);
                String [] strArray = data.split(",");
                
                yearAvgs.add( 
                 new YearAvg(Double.parseDouble(strArray[0]), 
                 Integer.parseInt(strArray[1]),
                 Double.parseDouble(strArray[2])));
                yearMap.put(strArray[1],
                 new YearAvg(Double.parseDouble(strArray[0]), 
                Integer.parseInt(strArray[1]),
                Double.parseDouble(strArray[2])));
                size++;
            }
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to read the file.");
            e.printStackTrace();
        }
        System.out.println(yearAvgs.size());
        
        System.out.println("Time Taken:"+ (System.currentTimeMillis() - stime));
        Set<YearAvg> yearHashSet = new HashSet<YearAvg>(yearAvgs);
        Set<YearAvg> yearSet = new TreeSet<YearAvg>(yearHashSet);
        for (YearAvg yearAvg2 : yearSet){
            System.out.println(yearAvg2);
        }
        System.out.println("Set size:"+yearSet.size());
        try {
            PrintStream fileStream = new PrintStream(new File("sorted.txt"));
            fileStream.println(header);
            for (YearAvg yearAvg2 : yearSet) {
                fileStream.println(yearAvg2.toCSV());
                // System.out.println(yearAvg2.toCSV());
            }
            fileStream.close();
          } catch (IOException e) {
            System.out.println("Falied to write the file.");
            e.printStackTrace();
          }
        System.out.print("Please enter a year:");
        Scanner sc = new Scanner(System.in);
        String year = sc.nextLine();
        if(yearMap.containsKey(year)){
            System.out.println(yearMap.get(year));
        }
        // System.out.println(size);


    }
}