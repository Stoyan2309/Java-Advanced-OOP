import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = ">>([A-Za-z]+)<<([0-9]+.?[0-9]*)!([0-9]+)";

        Pattern pattern = Pattern.compile(regex);


        List<String> furnitureList = new ArrayList<>();

        double totalMoney = 0;

        while (!input.equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String furniture = matcher.group(1);
                double price = Double.parseDouble(matcher.group(2));
                int quantity = Integer.parseInt(matcher.group(3));


                totalMoney += price * quantity;

                furnitureList.add(furniture);

            }



            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");

        for (int i = 0; i < furnitureList.size(); i++) {

            System.out.println(furnitureList.get(i));
        }
        System.out.printf("Total money spend: %.2f",totalMoney);
    }
}
