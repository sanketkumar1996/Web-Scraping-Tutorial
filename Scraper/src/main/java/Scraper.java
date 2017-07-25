import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.lang.Object;
import java.net.URL;
import java.util.Scanner;

public class Scraper {
  public static void main(String[] args) throws Exception{
      final Document document ;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the search : >>>> ");
        String name = input.nextLine();
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //create an print writer for writing to a file
        //PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
          //      new FileOutputStream("results.csv"), "UTF-8"));;
        document = (Document) Jsoup.connect("https://search.yahoo.com/search?ei=utf-8&fr=tightropetb&type=11745&p="+name).get();
//        bw.write("HEADING");
//        bw.write(",");
//        bw.write("LINKS");
//        bw.newLine();
//        bw.newLine();
        for(Element row : document.select("ol.mb-15.reg.searchCenterMiddle li")){
             String  title = row.select(".title").text();
             String url = row.select("span.fz-ms.fw-m.fc-12th.wr-bw.lh-17 ").text();
             //final String rating = row.select(".imdbRating").text();
             if(!title.isEmpty()){
             System.out.println(title + "-> URL: " + url+ "\n\n");
             
             title = title.replace(",", "|");
             //out.println(title + "-> URL: " + url + "\n\n");
//             bw.write(title);
//             bw.write(",");
//             bw.write(url);
//             bw.newLine();
             }
        }
//        bw.flush();
//        bw.close();
       // System.setOut(out);
  } 
}
