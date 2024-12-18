import java.util.PriorityQueue;
import java.util.Scanner;

class Worker implements Comparable<Worker> {

  int totalWork;
  int horchataExpected;

  public Worker(int t, int g) {
    this.totalWork = t;
    this.horchataExpected = g;
  }

  @Override
  public int compareTo(Worker worker) {
    if (this.totalWork == worker.totalWork) {
      return this.horchataExpected - worker.horchataExpected;
    }

    return worker.totalWork - this.totalWork;
  }

}

public class p766 {

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    PriorityQueue<Worker> workers = new PriorityQueue<>();

    while (true) {
      int totalHorchata = s.nextInt();
      int N = s.nextInt();

      if (totalHorchata == 0 && N == 0)
        break;

      while (N-- != 0) {
        workers.add(new Worker(s.nextInt(), s.nextInt()));
      }

      int count = 0;
      while (!workers.isEmpty() && totalHorchata > 0) {
        Worker worker = workers.poll();
        if (totalHorchata - worker.horchataExpected >= 0) {
          totalHorchata -= worker.horchataExpected;
          count++;
        } else {
          break;
        }
      }

      System.out.println(count + " " + totalHorchata);
      workers.clear();
    }

    s.close();
  }

}
