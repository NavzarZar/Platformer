package game;

import physics.Collision;

/**
 * The `Player` class represents the player character in the game.
 */
public class Player {
    private int playerY = 500;
    private int playerX = 0;

    private boolean playerIsJumping = false;

    public int moveSpeed = 3;

    public double velocityX = 0;
    public double velocityY = 0;

    public final int jumpHeight = 100;
    public final int jumpSpeed = 2;
    public int distanceJumped = 0;
    public double fallingSpeed = 2;

    int playerWidth = 50;
    int playerHeight = 75;

    /**
     * Gets the width of the player character.
     *
     * @return The width of the player character.
     */
    public int getPlayerWidth() {
        return playerWidth;
    }

    /**
     * Gets the height of the player character.
     *
     * @return The height of the player character.
     */
    public int getPlayerHeight() {
        return playerHeight;
    }

    /**
     * Sets the horizontal velocity of the player.
     *
     * @param velocityX The horizontal velocity to set.
     */
    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * Initiates a jump action for the player if a block is under the player.
     */
    public void jump() {
        if (Collision.mapBlockUnderPlayer(this)) {
            playerIsJumping = true;
        }
    }

    /**
     * Moves the player character to the left, if no collision is detected.
     */
    public void moveLeft() {
        if (!Collision.collisionLeft(this)) {
            this.setVelocityX(-moveSpeed);
            this.setPlayerX(this.getPlayerX() - moveSpeed);
        }
    }

    /**
     * Moves the player character to the right, if no collision is detected.
     */
    public void moveRight() {
        if (!Collision.collisionRight(this)) {
            this.setPlayerX(this.getPlayerX() + moveSpeed);
            this.setVelocityX(moveSpeed);
        }
    }

    /**
     * Sets the vertical position of the player.
     *
     * @param playerY The vertical position to set.
     */
    public void setPlayerY(int playerY) {
        this.playerY = playerY;
    }

    /**
     * Updates the player's position based on movement and jumping logic.
     */
    public void makePlayerFall() {
        boolean playerHasBlockUnder = Collision.mapBlockUnderPlayer(this);

        if (!playerHasBlockUnder && !playerIsJumping) {
            velocityY = fallingSpeed;
        } else if (distanceJumped >= jumpHeight) {
            distanceJumped = 0;
            playerIsJumping = false;
        } else if (playerIsJumping) {
            velocityY = -jumpSpeed;
            distanceJumped += jumpSpeed;
        } else {
            velocityY = 0;
        }
        this.setPlayerY((int) (this.getPlayerY() + velocityY));
    }

    /**
     * Gets the vertical position of the player.
     *
     * @return The vertical position of the player.
     */
    public int getPlayerY() {
        return playerY;
    }

    /**
     * Gets the horizontal position of the player.
     *
     * @return The horizontal position of the player.
     */
    public int getPlayerX() {
        return playerX;
    }

    /**
     * Sets whether the player is currently jumping.
     *
     * @param playerIsJumping `true` if the player is jumping, `false` otherwise.
     */
    public void setPlayerIsJumping(boolean playerIsJumping) {
        this.playerIsJumping = playerIsJumping;
    }

    /**
     * Sets the horizontal position of the player.
     *
     * @param playerX The horizontal position to set.
     */
    public void setPlayerX(int playerX) {
        this.playerX = playerX;
    }
}
