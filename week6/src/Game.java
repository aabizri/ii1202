import java.util.ArrayList;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
    // Terrain
    public Terrain terrain;

    // Liste des balles
    public ArrayList <Ball> balls = new ArrayList<>(2);

    // Constructeurs
    public Game(Terrain terrain, double margin) {
        // Store terrain
        this.terrain = terrain;

        // Graphics
        StdDraw.setXscale(-margin, terrain.xMax + margin);
        StdDraw.setYscale(-margin, terrain.yMax + margin);
    }

    public void addBall(Ball b) {
        balls.add(b);
    }

    public void step(int stepDuration) {
        StdDraw.clear(StdDraw.GRAY);
        StdDraw.setPenColor(StdDraw.RED);
        for (Ball ball : balls) {
            // Physics
            ball.step(this.terrain, stepDuration);

            // Graphics
            StdDraw.filledCircle(ball.positionX, ball.positionY, ball.radius);
        }
        // display
        StdDraw.show(stepDuration);
    }

}
