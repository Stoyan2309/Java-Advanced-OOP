import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bar {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("%([A-Z][a-z]+)%[^$|\\\\.%]*<(\\w+)>[^$|\\\\.%]*\\|([0-9]+)\\|[^$|\\\\.%0-9]*?([0-9]+.?[0-9]+)\\$");


        double totalPrice = 0;

        while (!input.equals("end of shift")) {


            Matcher matcher = pattern.matcher(input);


            if (matcher.find()){

                String customerName = matcher.group(1);
                String product = matcher.group(2);
                Integer count = Integer.parseInt(matcher.group(3));
                Double price = Double.parseDouble(matcher.group(4));

                Double currentPrice = count * price;

                System.out.printf("%s: %s - %.2f%n",customerName , product , currentPrice);
                totalPrice +=currentPrice;
            }


            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f",totalPrice);






    }
}
