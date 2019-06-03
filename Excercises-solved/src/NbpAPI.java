import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NbpAPI {




    public Calculator calculator;
    public String query;
/*
Zadanie 1.
W metodzie connect stworz obiekt URL i nawiąż połączenie z http://api.nbp.pl/api/exchangerates/rates/a/", i odczytaj kurs wybranej waluty
*/
    public String connect(String query) throws MalformedURLException {
        //String query="eur";

        //tu stworz obiekt URL z linkiem http://api.nbp.pl/api/exchangerates/rates/a/


        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/");
        URL url1 = new URL(url + query);

        //HttpURLConnection con3 = null;
        String res = null;
        HttpURLConnection con3 = null;
        try {
            con3 = (HttpURLConnection) url1.openConnection();
            //dodaj typ zapytania 'get' do obiektu con3
            con3.setRequestMethod("GET");
            con3.setRequestProperty("Content-Type", "application/json; utf-8");
            con3.setRequestProperty("Accept", "application/json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(con3.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }

            System.out.println(response);

            res = String.valueOf(response);
            System.out.println(res);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
//zadanie 2.
    //Zparsuj odpowiedz API i przekaż wartość "mid" z JSON do double data,
    public double Rate(String res) throws ParseException {
         JSONParser parse1 = new JSONParser();

        JSONObject jobj1 = (JSONObject) parse1.parse(res);

//Store the JSON object in JSON array as objects (For level 1 array element i.e rates)
        // stworz nowy obiekt jsonarray i metodą get pobierz z jobj parametr get
        //JSONArray jsonArray1=null;
          JSONArray jsonArray1 = (JSONArray) jobj1.get("rates");
        System.out.println(jsonArray1);
        double data = 0;
//Get data for Results array
      for (int i = 0; i < jsonArray1.size(); i++) {

            //Store the JSON objects in an array
            //Get the index of the JSON object and print the values as per the index
             //Store the JSON object in JSON array as objects (For level 2 array element i.e mid)
        //    przekaz tablice jsonArray1 przy pomocy iteratora i metody get do jsonObject2

            JSONObject jsonObject2 = (JSONObject) jsonArray1.get(i);


          //System.out.println(jsonObject2.get("mid"));
            //przekaz do zmiennej data wartosc parametru mid dla jsonObject2
            data= (double) jsonObject2.get("mid");



        }
        return data;


    }
}
