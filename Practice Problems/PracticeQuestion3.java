import java.util.*;

class Student {
    String roll, name;

    Student(String roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Student))
            return false;
        return roll.equals(((Student) obj).roll);
    }

    public int hashCode() {
        return roll.hashCode();
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> members = new HashSet<>();
        List<String> results = new ArrayList<>();

        while (sc.hasNext()) {
            String op = sc.next();
            String roll = sc.next();
            String name = sc.next();
            Student s = new Student(roll, name);

            if (op.equals("ADD")) {
                if (members.add(s))
                    System.out.println("Added");
                else
                    System.out.println("duplicate rejected");
            } else if (op.equals("CONTAINS")) {
                results.add("contains: " + members.contains(s));
            }
        }

        System.out.println("member count " + members.size());
        for (String result : results)
            System.out.println(result);

        sc.close();
    }
}
