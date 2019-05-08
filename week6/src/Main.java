public class Main {
    public static void main(String[] args) {
        Terrain terrain = new Terrain();
        Game game = new Game(terrain, 2.5f);
        Ball b1 = new Ball(0, game.terrain.yMax, 100, 0);
        Ball b2 = new Ball(game.terrain.xMax, game.terrain.yMax, -100, 0);
        Ball b3 = new Ball(0, 0, 100, 1);
        Ball b4 = new Ball(game.terrain.xMax, 0, -100, 1);
        game.addBall(b1);
        game.addBall(b2);
        game.addBall(b3);
        game.addBall(b4);
        while (true){
            game.step(2);
        }
    }
}
