package com.martinlsm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import units.Square;

public class Main extends ApplicationAdapter {

	public static Texture squareTex;
	public static Vector2 gravity;

	private SpriteBatch batch;
	private Viewport viewport;
	private OrthographicCamera cam;
	private Square[] sq;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		squareTex = new Texture("square.png");
		gravity = new Vector2(0, -8000);
		sq = new Square[4];
		sq[0] = new Square(new Vector2(250, 1200));
		sq[1] = new Square(new Vector2(800, 500));
		sq[2] = new Square(new Vector2(1650, 800));
		sq[3] = new Square(new Vector2(500, 700));
		cam = new OrthographicCamera();
		viewport = new StretchViewport(1920, 1080, cam);
		viewport.apply(true);
	}

	@Override
	public void render () {
		update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		for (Square s : sq) {
			s.draw(batch);
		}
//		batch.draw(squareTex, 0, 0, 1920, 1080);
		batch.end();
	}

	public void update(float dt) {
		for (Square s : sq) {
			s.update(dt);
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		squareTex.dispose();
	}
}
