import java.util.*;

public class AssignmentQuestion3 {

    static String[] mostPopular(String[] orders) {
        HashMap<String, Integer> count = new HashMap<>();

        for (String item : orders) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        String popular = orders[0];
        int maxCount = count.get(popular);

        for (String item : orders) {
            if (count.get(item) > maxCount) {
                popular = item;
                maxCount = count.get(item);
            }
        }

        return new String[]{popular, String.valueOf(maxCount)};
    }

    public static void main(String[] args) {
        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        String[] result = mostPopular(orders);

        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}
