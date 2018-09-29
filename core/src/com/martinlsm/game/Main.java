package com.martinlsm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Viewport viewport;
	OrthographicCamera cam;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("square.png");
		cam = new OrthographicCamera();
		viewport = new StretchViewport(1920, 1080, cam);
		viewport.apply(true);
	}

	@Override
	public void render () {

		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(img, 0, 0, 1920, 1080);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
