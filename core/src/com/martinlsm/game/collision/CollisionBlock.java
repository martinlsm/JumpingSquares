package com.martinlsm.game.collision;

import com.badlogic.gdx.math.Vector2;

public class CollisionBlock {
    private Vector2 pos, size;

    public CollisionBlock(int x, int y, int width, int height) {
        pos = new Vector2(x, y);
        size = new Vector2(width, height);
    }

    /**
     * Checks if another block is colliding with this block and returns the direction from where the collision
     * is occuring (Four possible directions (1, 0), (0, 1), (-1, 0), (0, -1)).
     *
     * @param other Another block to check if it's colliding with this block.
     * @return A vector pointing in the direction of the other block. The zero vector if no collision is occuring.
     */
    public Vector2 collisionDir(CollisionBlock other) {
        boolean collideX = pos.x + size.x >= other.pos.x && other.pos.x + other.size.x >= pos.x;
        boolean collideY = pos.y + size.y >= other.pos.y && other.pos.y + other.size.y >= pos.y;
        if (collideX && collideY) {
            Vector2 centerThis = new Vector2(pos).mulAdd(size, 0.5f);
            Vector2 centerOther = new Vector2(other.pos).mulAdd(other.size, 0.5f);
            Vector2 collisionDir = centerOther.sub(centerThis);
            if (Math.abs(collisionDir.x) > Math.abs(collisionDir.y)) {
                collisionDir.y = 0;
            } else {
                collisionDir.x = 0;
            }
            return collisionDir.nor();
        }
        return new Vector2(0.0f, 0.0f);
    }
}
