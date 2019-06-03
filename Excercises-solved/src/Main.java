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
        double rate= nbpAPI.Rate(nbpAPI.connect(calculator.Currency()));
        calculator.Price(rate,calculator.Quote());

        //rzeczy do Sadu

        SaosAPI saosAPI = new SaosAPI();
        String courtData=saosAPI.connect();
        String wyroki= saosAPI.court(courtData);
        saosAPI.write(wyroki);



        //rzeczy do weather api


        SmogAPI smogAPI=new SmogAPI();
        String smog=smogAPI.connect();
        smogAPI.smogData(smog);

    }
}
