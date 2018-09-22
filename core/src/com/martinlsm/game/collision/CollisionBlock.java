package com.martinlsm.game.collision;

import com.badlogic.gdx.math.Vector2;

public class CollisionBlock {
    private int x0, x1, y0, y1;

    public CollisionBlock(int x, int y, int width, int height) {
        x0 = x;
        y0 = y;
        x1 = x + width - 1;
        y1 = y + height - 1;
    }

    public boolean isInside(int x, int y) {
        return x >= x0 && x <= x1 && y >= y0 && y <= y1;
    }

    /**
     * Checks if another block is colliding with this block and returns the direction from where the collision
     * is occuring (Four possible directions (1, 0), (0, 1), (-1, 0), (0, -1)).
     *
     * @param other Another block to check if it's colliding with this block.
     * @return A vector pointing in the direction of the other block. The zero vector if no collision is occuring.
     */
    public Vector2 collisionDir(CollisionBlock other) {
        return new Vector2(0.0f, 0.0f);
    }
}
