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


//Zadanie 4
//Pobierz wyroki dla danego słowa kluczowego
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
        // korzystajac z nbp Api odbierz odpowiedz API na zapytanie (BufferedReader...etc)

        return res;

        }

    public String court(String res) throws org.json.simple.parser.ParseException {

        JSONParser parse1 = new JSONParser();
        JSONObject jobj1 = (JSONObject) parse1.parse(res);
        //przekaz do jsonArray1 wartosci dla klucza items z jobj1
        JSONArray jsonArray1=null;

        System.out.println(jsonArray1);
        String data = null;
        //tu chemy dostac kilka wyrokow wiec musimy je przekazac do jakiejs struktury eg. List
        //do List wyroki przypisz obiekt dla klucza textContent w jsonArray1
        //List<Object> wyroki = IntStream.range(0, jsonArray1.size())
        //         .mapToObj(index -> ((JSONObject)//tu trzeba dodac odwolanie do klucza
        //         .collect(Collectors.toList());

        //System.out.println(wyroki);

        //data= String.valueOf(wyroki);
        return data;

    }
    public void write(String string) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("wyroki.txt", true));
        writer.write(string);

        writer.close();
    }


}
