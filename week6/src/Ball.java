public class Ball {
    public double positionX = 0;
    public double positionY = 10;
    public double speedX = 0;
    public double speedY = 0;
    public double radius = 2.5f;

    public Ball(double startX, double startY, double startSpeedX, double startSpeedY) {
        positionX = startX;
        positionY = startY;
        speedX = startSpeedX;
        speedY = startSpeedY;
    }

    public Ball(double startX, double startY) {
        positionX = startX;
        positionY = startY;
    }

    public void step(Terrain terrain, int stepDuration) {
        // Stepduration to double
        double stepDurationSeconds = (double)(stepDuration)/1000;

        // Changement de la vitesse
        double newSpeedX = this.speedX;
        double newSpeedY = this.speedY - terrain.g*stepDurationSeconds;

        // Changement de la position
        double newPositionX = this.positionX + this.speedX*stepDurationSeconds;
        double newPositionY = this.positionY + this.speedY + -terrain.g*stepDurationSeconds/2;

        // Si la position dépasse le sol ou le plafond, la vitesse Y est inversée
        if (newPositionY < 0 || newPositionY > terrain.yMax) {
            newSpeedY = -newSpeedY;
        }

        // Si la position dépasse le mur, la vitesse X est inversée
        if (newPositionX > terrain.xMax || newPositionX < 0) {
            newSpeedX = -newSpeedX;
        }

        // Set
        this.speedX = newSpeedX;
        this.speedY = newSpeedY;
        this.positionX = newPositionX;
        this.positionY = newPositionY;
    }

    /*public boolean collides(Ball other) {
        if ()
    }*/
}