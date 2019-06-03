import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//zadanie 3
//przy pomocy podanego linku odbierz informacje na temat stanu powietrza w krakowie

public class SmogAPI {
    public String connect() throws IOException {

        URL url1 = new URL(" http://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/400");


//korzystając z nbpAPi nawiaż połączenie z api.gios i odbierz odpowiedz

        HttpURLConnection con3 = (HttpURLConnection) url1.openConnection();


        con3.setRequestMethod("GET");
        con3.setRequestProperty("Content-Type", "application/json; utf-8");
        con3.setRequestProperty("Accept", "application/json");


        System.out.println(con3);
        String res;

        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(con3.getInputStream(), "utf-8"))) {  // gettting response
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            res = String.valueOf(response);
            System.out.println(res);

            return res;

        }
    }

    public void smogData(String res) throws org.json.simple.parser.ParseException {
        JSONParser parse1 = new JSONParser();

        JSONObject jobj1 = (JSONObject) parse1.parse(res);
        System.out.println(jobj1);
        JSONObject jsonObject2=null;
        JSONObject jsonObject3=null;
        JSONObject jsonObject4=null;
        String pm10=null;
        String pm25=null;
        String co=null;

// przetworz odpowiedz Api dostając sie do parametrow pm25IndexLevel coIndexLevel pm10IndexLevel przy pomocy jobj1.get i przypisz je do kolejnych jsonOBjectow
        // następnie przekaz paramtetr indexLevelName do odpowiednich stringow




        System.out.println("pm10: "+ pm10);
        System.out.println("pm25: " + pm25);
        System.out.println("co: "+co);




    }
}
