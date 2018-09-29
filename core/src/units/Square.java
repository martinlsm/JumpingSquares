package units;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.martinlsm.game.Main;

public class Square {

    private Texture tex;
    private Vector2 pos, velocity, gravity;

    public Square(Vector2 pos) {
        this.pos = pos;
        velocity = new Vector2(0, 0);
        gravity = Main.gravity;
        tex = Main.squareTex;
    }

    public void update(float dt) {
        velocity.x += gravity.x * dt;
        velocity.y += gravity.y * dt;
        pos.x += velocity.x * dt;
        pos.y += velocity.y * dt;
        if (pos.y <= 0) {
            pos.y = 0;
            velocity.y = -velocity.y * 0.9f;
        }
    }

    public void draw(SpriteBatch batch) {
        batch.draw(tex, pos.x, pos.y);
    }
}
