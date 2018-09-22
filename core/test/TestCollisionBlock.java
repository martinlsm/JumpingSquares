import com.badlogic.gdx.math.Vector2;
import org.junit.Test;
import static org.junit.Assert.*;

import com.martinlsm.game.collision.*;

public class TestCollisionBlock {

    @Test
    public void horizontalCollision1() {
        CollisionBlock b1 = new CollisionBlock(200, 200, 50, 50);
        CollisionBlock b2 = new CollisionBlock(248, 200, 50, 50);
        assertEquals(new Vector2(1.0f, 0.0f), b1.collisionDir(b2));
        assertEquals(new Vector2(-1.0f, 0.0f), b2.collisionDir(b1));
    }

    @Test
    public void noCollision() {
        CollisionBlock b1 = new CollisionBlock(200, 200, 50, 50);
        CollisionBlock b2 = new CollisionBlock(250, 200, 50, 50);
        assertEquals(new Vector2(0.0f, 0.0f), b1.collisionDir(b2));
        assertEquals(new Vector2(0.0f, 0.0f), b2.collisionDir(b1));
    }

    @Test
    public void verticalCollision() {
        CollisionBlock b1 = new CollisionBlock(100, 100, 50, 50);
        CollisionBlock b2 = new CollisionBlock(125, 147, 100, 100);
        assertEquals(new Vector2(0.0f, 1.0f), b1.collisionDir(b2));
        assertEquals(new Vector2(0.0f, -1.0f), b2.collisionDir(b1));
    }

    @Test
    public void largeAndSmall() {
        CollisionBlock bSmall = new CollisionBlock(500, 500, 4, 4);
        CollisionBlock bLarge = new CollisionBlock(503, 250, 1000, 1000);
        assertEquals(new Vector2(1.0f, 0.0f), bSmall.collisionDir(bLarge));
        assertEquals(new Vector2(-1.0f, 0.0f), bLarge.collisionDir(bSmall));
    }

    @Test
    public void highOverlap() {
        CollisionBlock b1 = new CollisionBlock(400, 400, 20, 20);
        CollisionBlock b2 = new CollisionBlock(400, 405, 20, 20);
        assertEquals(new Vector2(0.0f, 1.0f), b1.collisionDir(b2));
        assertEquals(new Vector2(0.0f, -1.0f), b2.collisionDir(b1));
    }
}
