import java.util.*;

class Payslip {
    String name, type;
    double pay;

    Payslip(String name, String type, double pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    public String toString() {
        return "Payslip[name=" + name + ", type=" + type
             + ", pay=" + (long) pay + "]";
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Payslip> staff = new ArrayList<>();
        double total = 0;
        int top = 0;

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();
            double pay;

            if (type.equals("FullTime")) {
                pay = sc.nextDouble();
            } else if (type.equals("PartTime")) {
                double hours = sc.nextDouble();
                double rate = sc.nextDouble();
                pay = hours * rate;
            } else {
                pay = sc.nextDouble();
            }

            staff.add(new Payslip(name, type, pay));
        }

        for (int i = 0; i < staff.size(); i++) {
            System.out.println(staff.get(i));
            total += staff.get(i).pay;

            if (staff.get(i).pay > staff.get(top).pay)
                top = i;
        }

        System.out.println("Total " + (long) total);
        System.out.println("top earner " + staff.get(top).name);

        sc.close();
    }
}
