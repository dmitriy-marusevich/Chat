package Lesson_1.marathon;

import Lesson_1.marathon.Competitor.*;
import Lesson_1.marathon.Obstacle.Course;
import Lesson_1.marathon.Obstacle.Cross;
import Lesson_1.marathon.Obstacle.Wall;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(new Cross(50), new Cross(80), new Wall(2), new Wall(1), new Cross(120));
        Team team = new Team("dreamTeam", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
        course.doIt(team);
        team.showWinners();
}
}

