import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class p713 {

  static class TeamResults implements Comparable<TeamResults> {
    int id, GF, GC, points;

    TeamResults(int id) {
      this.id = id;
      this.GC = 0;
      this.GF = 0;
    }

    public int compareTo(TeamResults team2) {
      if (this.points != team2.points) {
        return team2.points - this.points;
      }

      int diffTeam1 = this.GF - this.GC;
      int diffTeam2 = team2.GF - team2.GC;
      if (diffTeam1 != diffTeam2) {
        return diffTeam2 - diffTeam1;
      }

      return team2.GF - this.GF;
    }

    boolean hasSameResult(TeamResults team2) {
      if (team2 == null)
        return false;

      if (this.points != team2.points)
        return false;

      int diffTeam1 = this.GF - this.GC;
      int diffTeam2 = team2.GF - team2.GC;
      if (diffTeam1 != diffTeam2)
        return false;

      if (this.GF != team2.GF)
        return false;

      return true;
    }
  }

  public static void main(String[] args) {

    Scanner s = new Scanner(System.in);

    HashMap<Integer, TeamResults> teamsResults = new HashMap<>();

    while (s.hasNext()) {
      int N = s.nextInt();
      int Q = s.nextInt();

      for (int i = 1; i <= N; i++) {
        teamsResults.put(i, new TeamResults(i));
      }

      for (int i = 0; i < (N * (N - 1)) / 2; i++) {
        int team1Id = s.nextInt();
        int team2Id = s.nextInt();
        int team1Score = s.nextInt();
        int team2Score = s.nextInt();

        teamsResults.get(team1Id).GF += team1Score;
        teamsResults.get(team1Id).GC += team2Score;

        teamsResults.get(team2Id).GF += team2Score;
        teamsResults.get(team2Id).GC += team1Score;

        if (team1Score == team2Score) {
          teamsResults.get(team1Id).points++;
          teamsResults.get(team2Id).points++;
        } else if (team1Score > team2Score)
          teamsResults.get(team1Id).points += 3;
        else
          teamsResults.get(team2Id).points += 3;
      }

      ArrayList<TeamResults> teamsList = new ArrayList<>(teamsResults.values());
      Collections.sort(teamsList);

      boolean tie = false;
      for (int i = 1; i < Math.min(N, Q + 1) && !tie; i++) {
        if (teamsList.get(i).hasSameResult(teamsList.get(i - 1))) {
          tie = true;
        }
      }

      if (tie) {
        System.out.println("EMPATE");
        teamsResults.clear();
        continue;
      }

      String ans = "";
      for (int i = 0; i < Q; i++) {
        ans += teamsList.get(i).id;
        if (i + 1 != Q)
          ans += " ";
      }

      System.out.println(ans);
      teamsResults.clear();
    }

    s.close();
  }

}
