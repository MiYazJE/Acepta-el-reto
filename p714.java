import java.util.LinkedList;
import java.util.Scanner;

public class p714 {

  static class Match {

    String teamA, teamB;

    Match() {
      this.teamA = null;
      this.teamB = null;
    }

    Match(String t1, String t2) {
      this.teamA = t1;
      this.teamB = t2;
    }

    void addTeam(String team) {
      if (this.teamA == null) {
        this.teamA = team;
        return;
      }

      this.teamB = team;
    }

    boolean matchIsReady() {
      return this.teamA != null && this.teamB != null;
    }

    String getWinner(int scoreA, int scoreB) {
      if (scoreA > scoreB)
        return teamA;
      return teamB;
    }
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    LinkedList<String> teams = new LinkedList<>();
    LinkedList<Match> matches = new LinkedList<>();

    while (true) {
      int N = s.nextInt();
      if (N == 0)
        break;

      s.nextLine();

      String[] scores = new String[0];

      while (true) {
        String[] parts = s.nextLine().split(" ");
        if (parts[0].matches("\\d+")) {
          scores = parts;
          break;
        }

        for (String str : parts)
          teams.add(str);
      }

      for (int j = 0; j < teams.size(); j += 2) {
        matches.add(new Match(teams.get(j), teams.get(j + 1)));
      }

      String winner = "";
      for (int i = 0; i < scores.length; i += 2) {
        Match match = matches.removeFirst();
        int scoreA = Integer.parseInt(scores[i]);
        int scoreB = Integer.parseInt(scores[i + 1]);
        String currentWinner = match.getWinner(scoreA, scoreB);

        if (i == scores.length - 2) {
          winner = currentWinner;
          break;
        }

        if (!matches.peekLast().matchIsReady()) {
          matches.peekLast().addTeam(currentWinner);
        } else {
          Match newMatch = new Match();
          newMatch.addTeam(currentWinner);
          matches.addLast(newMatch);
        }
      }

      System.out.println(winner);
      matches.clear();
      teams.clear();
    }

    s.close();
  }

}
