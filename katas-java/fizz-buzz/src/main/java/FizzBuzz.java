import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static List<String> applyFizzBuzz() {
        List<String> result = new ArrayList<String>();
        for(Integer i = 1; i <= 100; i++) {
            if(i%3 == 0) {
                if(i%5 == 0) {
                    result.add("FizzBuzz");
                    continue;
                }
                result.add("Fizz");
                continue;
            } else if (i%5 == 0) {
                result.add("Buzz");
                continue;
            }
            result.add(i.toString());
        }

        return result;
    }
}
