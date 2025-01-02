import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class p702 {

  static class Transaction {
    int month;
    String operation;

    Transaction(int month, String operation) {
      this.month = month;
      this.operation = operation;
    }

    int calculate(int amount) {
      int operationAmount = Integer.parseInt(this.operation.substring(1));
      if (this.operation.charAt(0) == '-') {
        return amount - operationAmount;
      }
      return amount + operationAmount;
    }
  }

  static class MonthlyTransactions {
    HashMap<Integer, ArrayList<Transaction>> transactionsByMonth;
    int amount;

    MonthlyTransactions(int amount) {
      this.amount = amount;
      this.transactionsByMonth = new HashMap<>();
      for (int i = 0; i < 12; i++) {
        this.transactionsByMonth.put(i, new ArrayList<Transaction>());
      }
    }

    void addTransaction(String line) {
      String[] parts = line.split(" ");
      int month = Integer.parseInt(parts[0].substring(3)) - 1;

      Transaction transaction = new Transaction(month, parts[1]);
      this.transactionsByMonth.get(month).add(transaction);
    }

    void printYear() {
      String ans = "";
      int currentAmount = this.amount;

      for (int i = 0; i < 12; i++) {

        for (Transaction transaction : transactionsByMonth.get(i)) {
          currentAmount = transaction.calculate(currentAmount);
        }

        ans += currentAmount;
        if (i < 11)
          ans += " ";
      }

      System.out.println(ans);
    }
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    while (s.hasNext()) {

      int amount = s.nextInt();
      MonthlyTransactions monthlyTransactions = new MonthlyTransactions(amount);

      int N = s.nextInt();
      s.nextLine();
      while (N-- != 0) {
        monthlyTransactions.addTransaction(s.nextLine());
      }

      monthlyTransactions.printYear();
    }

    s.close();

  }

}
