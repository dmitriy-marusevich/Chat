package Lesson_1.marathon.Competitor;

public class Team {
    private Competitor[] members;
    private String title;

    public Team(String title, Competitor... members) {
        this.members = members;
        this.title = title;
    }

    public Competitor[] getMembers() {
        return members;
    }

    public void showWinners() {
        System.out.println("Win");
        for (Competitor o : members) {
            if (o.isOnDistance()){
                o.info();
            }

        }
    }

}
