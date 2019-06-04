import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        System.out.println("Hello World!");

       //rzeczy do NBP
        NbpAPI nbpAPI=new NbpAPI();
        Calculator calculator=new Calculator();
     //   String apiResp=nbpAPI.connect(calculator.Currency()); //odkomentuj po 1
    //    System.out.println(apiResp);

        //odkomentuj po 2.
/*      double rate= nbpAPI.Rate(api Resp);
        System.out.println("Twoja kwota w euro: ");
        calculator.Price(rate,calculator.Quote());
*/
        //rzeczy do saos api

        SaosAPI saosAPI = new SaosAPI();
/*      String courtData=saosAPI.connect();
        String wyroki= saosAPI.court(courtData);
        saosAPI.write(wyroki);*/



        //rzeczy do smog api

/*
        SmogAPI smogAPI=new SmogAPI();
        String smog=smogAPI.connect();
        smogAPI.smogData(smog);*/

    }
}
