package levels;

/**
 * The `Level` abstract class represents a game level with shared properties.
 */
public abstract class Level {
    // Constants defining properties of a level
    public static final int levelHeight = 500;
    public static final int mapElementWidth = 80;
    public static final int mapElementHeight = 60;
    public static final int spikeHeight = 50;
    public static int mapOffset = 0;  // Shared offset for the level

    // This class is abstract, so it should be extended by specific level implementations.
}
