import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;

public class Race {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] racers = scanner.nextLine().split(", ");

        Map<String, Integer> racersWithDistance = new LinkedHashMap<>();

        Arrays.stream(racers).forEach(racer -> racersWithDistance.put(racer , 0));

        String regexLetters = "[A-Za-z]+";
        Pattern pattern = Pattern.compile(regexLetters);

        String regexDigits = ("[0-9]");
        Pattern pattern1 = Pattern.compile((regexDigits));


        String input = scanner.nextLine();

        while (!input.equals("end of race")) {

            StringBuilder sb = new StringBuilder();
            Matcher matcherName = pattern.matcher(input);

            while (matcherName.find()) {
                sb.append(matcherName.group());
            }

            int distance = 0;
            Matcher matcherDistance = pattern1.matcher(input);

            while (matcherDistance.find()) {
                distance += Integer.parseInt(matcherDistance.group());
            }

            String racerName = sb.toString() ;
            if(racersWithDistance.containsKey(racerName)){
                int currentDistance = racersWithDistance.get(racerName);
                racersWithDistance.put(racerName , currentDistance + distance );
            }

            input = scanner.nextLine();
        }

        List<String> firstThreeNames = racersWithDistance.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());


        System.out.println("1st place: " + firstThreeNames.get(0));
        System.out.println("2nd place: " + firstThreeNames.get(1));
        System.out.println("3rd place: " + firstThreeNames.get(2));

    }
}
