import org.junit.Test;
import static org.junit.Assert.*;

import com.martinlsm.game.collision.*;

public class TestSomething {

    @Test
    public void someTest() {
        CollisionBlock block = new CollisionBlock(0, 0, 1, 1);
        assertNotNull(block);
    }
}
