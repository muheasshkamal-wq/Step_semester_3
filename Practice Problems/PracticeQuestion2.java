import java.util.*;

interface Chargeable {
    void charge();
}

class Vehicle {
    String passNo, owner, type;
    int fee;

    Vehicle(String type, String passNo, String owner) {
        this.type = type;
        this.passNo = passNo;
        this.owner = owner;
        fee = (type.equals("Bike") || type.equals("EBike")) ? 300 : 1000;
    }

    void display() {
        System.out.println(passNo + " (" + type + ") pass fee " + fee);
    }
}

class EBike extends Vehicle implements Chargeable {
    EBike(String p, String o) {
        super("EBike", p, o);
    }

    public void charge() {
        System.out.println(passNo + " charging bay allotted");
    }
}

class ECar extends Vehicle implements Chargeable {
    ECar(String p, String o) {
        super("ECar", p, o);
    }

    public void charge() {
        System.out.println(passNo + " charging bay allotted");
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new HashMap<>();

        while (sc.hasNext()) {
            String op = sc.next();

            if (op.equals("PASS")) {
                String type = sc.next();
                String p = sc.next();
                String o = sc.next();

                Vehicle v;
                if (type.equals("Bike"))
                    v = new Vehicle(type, p, o);
                else if (type.equals("Car"))
                    v = new Vehicle(type, p, o);
                else if (type.equals("EBike"))
                    v = new EBike(p, o);
                else
                    v = new ECar(p, o);

                vehicles.put(p, v);
                v.display();
            } else if (op.equals("CHARGE")) {
                String p = sc.next();
                Vehicle v = vehicles.get(p);

                if (v == null)
                    System.out.println("Vehicle not found");
                else if (v instanceof Chargeable)
                    ((Chargeable) v).charge();
                else
                    System.out.println(p + " rejected: charging unsupported");
            }
        }
        sc.close();
    }
}
