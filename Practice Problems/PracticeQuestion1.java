import java.util.*;

class Account {
    String id;
    int balance;

    Account(String id, int balance) {
        this.id = id;
        this.balance = balance;
    }

    String withdraw(int amount) {
        return "";
    }
}

class Savings extends Account {
    Savings(String id, int balance) {
        super(id, balance);
    }

    String withdraw(int amount) {
        if (balance - amount < 1000)
            return id + " rejected: minimum balance 1000";
        balance -= amount;
        return id + " balance " + balance;
    }
}

class Current extends Account {
    Current(String id, int balance) {
        super(id, balance);
    }

    String withdraw(int amount) {
        if (balance - amount < -5000)
            return id + " rejected: overdraft limit 5000";
        balance -= amount;
        return id + " balance " + balance;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (sc.hasNext()) {
            String op = sc.next();

            if (op.equals("Savings")) {
                String id = sc.next();
                int bal = sc.nextInt();
                accounts.put(id, new Savings(id, bal));
            } else if (op.equals("Current")) {
                String id = sc.next();
                int bal = sc.nextInt();
                accounts.put(id, new Current(id, bal));
            } else if (op.equals("WITHDRAW")) {
                String id = sc.next();
                int amount = sc.nextInt();

                if (!accounts.containsKey(id))
                    System.out.println("Account not found");
                else
                    System.out.println(accounts.get(id).withdraw(amount));
            }
        }
        sc.close();
    }
}
