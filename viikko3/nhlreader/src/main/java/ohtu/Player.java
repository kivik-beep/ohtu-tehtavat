package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public void setName(String name, String nationality, String team, int goals, int assists) {
        this.name = name;
        this.nationality = nationality;
        this.team = team;
        this.goals = goals;
        this.assists = assists;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public String toString() {
        return name + " " + team +" " + goals + " + " + assists+" = "+(goals+assists);
    }

    @Override
    public int compareTo(Player t) {
        int player = this.goals + this.assists;
        int other = t.goals + t.assists;

        if (other == player) {
            return t.goals - this.goals;
        }
        return other - player;
    }

}
