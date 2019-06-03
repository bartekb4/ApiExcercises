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
        String query = "rower";

        URL url1 = new URL("https://www.saos.org.pl/api/search/judgments?" +
                "pageSize=10&pageNumber=0&all=" + query +
                "&sortingField=JUDGMENT_DATE&sortingDirection=DESC");


        HttpURLConnection con3 = (HttpURLConnection) url1.openConnection();
        con3.setRequestMethod("GET");
        con3.setRequestProperty("Content-Type", "application/json; utf-8");
        con3.setRequestProperty("Accept", "application/json");


        System.out.println(con3);
        String res = null;


        try (BufferedReader br = new BufferedReader(
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
    public String court(String res) throws org.json.simple.parser.ParseException {

        JSONParser parse1 = new JSONParser();
        JSONObject jobj1 = (JSONObject) parse1.parse(res);

        JSONArray jsonArray1 = (JSONArray) jobj1.get("items");

        System.out.println(jsonArray1);
        String data = null;

        List<Object> wyroki = IntStream.range(0, jsonArray1.size())
               .mapToObj(index -> ((JSONObject) jsonArray1.get(index)).get("textContent"))
               .collect(Collectors.toList());

        System.out.println(wyroki);

        data= String.valueOf(wyroki);
        return data;


    }
    public void write(String string) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("wyroki.txt", true));
        writer.write(string);

        writer.close();
    }


}
