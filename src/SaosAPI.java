import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SaosAPI {
    public String connect() throws IOException, ParseException {
        String query="rower";

        URL url1 = new URL("https://www.saos.org.pl/api/search/judgments?" +
               "pageSize=10&pageNumber=0&all="+query+
                "&soringField=JUDGMENT_DATE&sortingDirection=DESC");


        HttpURLConnection con3 = (HttpURLConnection) url1.openConnection();
//ustaw odpowiednie parametry polaczenia korzystając z nbpApi



        System.out.println(con3);
        String res=null;
        // korzystajac z nbp Api odbierz odpowiedz API na zapytanie

  /*      try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con3.getInputStream(), "utf-8"))) {  // gettting response
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            res = String.valueOf(response);
            System.out.println(res);*/

            return res;

        }

    public String court(String res) throws org.json.simple.parser.ParseException {

        JSONParser parse1 = new JSONParser();
        JSONObject jobj1 = (JSONObject) parse1.parse(res);
//przekaz do jsonArray1 wartosci dla parametru items z jobj1
        JSONArray jsonArray1=null;
       // JSONArray jsonArray1 = (JSONArray) jobj1.get("items");
        System.out.println(jsonArray1);
        String data = null;
        //do List wyroki przypisz obiekt dla wartosci textContent w jsonArray1 po .mapToObj(index -> ((JSONObject)
     //   List<Object> wyroki = IntStream.range(0, jsonArray1.size())
       //         .mapToObj(index -> ((JSONObject)
       //         .collect(Collectors.toList());

       // System.out.println(wyroki);

    //    data= String.valueOf(wyroki);
        return data;


    }
    public void write(String string) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("wyroki.txt", true));
        writer.write(string);

        writer.close();
    }


}