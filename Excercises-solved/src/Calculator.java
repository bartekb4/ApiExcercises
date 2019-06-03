import java.util.Scanner;

public class Calculator {


    public String Currency(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj walute: ");
        String query = scanner.nextLine();
        return query;
    }
    public double Quote(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kwote: ");
        String query = scanner.nextLine();
        double quote= Integer.parseInt(query);
        return quote;
    }
    public double Price(double rate, double quote){
        double price=rate*quote;
        System.out.println("Twoja kwota w wybranej walucie: ");
        System.out.println(price);
        return price;

    }
}
