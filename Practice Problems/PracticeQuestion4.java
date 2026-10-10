import java.util.*;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        List<int[]> marks = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String name = line.substring(0, line.indexOf('[')).trim();
            String data = line.substring(line.indexOf('[') + 1,
                                         line.indexOf(']'));

            String[] values = data.split(",");
            int[] m = new int[3];

            for (int i = 0; i < 3; i++)
                m[i] = Integer.parseInt(values[i].trim());

            names.add(name);
            marks.add(m);
        }

        int[] subjectTotal = new int[3];
        int topper = 0, highest = -1;

        System.out.print("Totals ");
        for (int i = 0; i < marks.size(); i++) {
            int total = 0;

            for (int j = 0; j < 3; j++) {
                total += marks.get(i)[j];
                subjectTotal[j] += marks.get(i)[j];
            }

            System.out.print(names.get(i) + " " + total);
            if (i < marks.size() - 1) System.out.print(", ");

            if (total > highest) {
                highest = total;
                topper = i;
            }
        }

        System.out.printf("%naverages %.2f, %.2f, %.2f%n",
            (double) subjectTotal[0] / marks.size(),
            (double) subjectTotal[1] / marks.size(),
            (double) subjectTotal[2] / marks.size());

        System.out.println("topper " + names.get(topper)
                           + " (" + highest + ")");

        sc.close();
    }
}
