package game;

import physics.Collision;

/**
 * The `Player` class represents the player character in the game.
 */
public class Player {
    /**
     * The vertical position (Y-coordinate) of the player character.
     */
    private int playerY = 500;

    /**
     * The horizontal position (X-coordinate) of the player character.
     */
    private int playerX = 0;

    /**
     * Indicates whether the player character is currently in a jumping state.
     */
    private boolean playerIsJumping = false;

    /**
     * The horizontal movement speed of the player character.
     */
    private int moveSpeed = 3;

    /**
     * The vertical velocity of the player character (used for jumping).
     */
    private double velocityY = 0;

    /**
     * The distance the player character has jumped.
     */
    private int distanceJumped = 0;


    /**
     * Gets the width of the player character.
     *
     * @return The width of the player character.
     */
    public int getPlayerWidth() {
        return 50;
    }

    /**
     * Gets the height of the player character.
     *
     * @return The height of the player character.
     */
    public int getPlayerHeight() {
        return 75;
    }

    /**
     * Sets the horizontal velocity of the player.
     *
     * @param velocityX The horizontal velocity to set.
     */
    public void setVelocityX(int velocityX) {

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

        int jumpHeight = 100;
        if (!playerHasBlockUnder && !playerIsJumping) {
            double fallingSpeed = 2;
            velocityY = fallingSpeed;
        } else if (distanceJumped >= jumpHeight) {
            distanceJumped = 0;
            playerIsJumping = false;
        } else if (playerIsJumping) {
            int jumpSpeed = 2;
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

    /**
     * Gets the the move speed of the player.
     * @return moveSpeed
     */
    public int getMoveSpeed() {
        return moveSpeed;
    }

    /**
     * Gets the falling speed of the player.
     * @return fallingSpeed
     */
    public int getFallingSpeed() {
        return 2;
    }

}
