package com.mygdx.gamedev.gigagal;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import util.Assets;
import util.Constants;

/**
 * Created by udayv on 7/23/2016.
 */
public class GamePlayScreen extends ScreenAdapter
{
   public static final String TAG=GamePlayScreen.class.getName();

   SpriteBatch batch;

   ExtendViewport viewport;

    @Override
    public void show()
    {
     Assets.instance.init();

     batch=new SpriteBatch();

     viewport=new ExtendViewport(Constants.WORLD_SIZE,Constants.WORLD_SIZE);
    }


    @Override
    public void resize(int width, int height)
    {
        viewport.update(width, height,true);
    }

    @Override
    public void dispose() {
        Assets.instance.dispose();
        batch.dispose();
    }

    @Override
    public void render(float delta)
    {
    viewport.apply();

        Gdx.gl.glClearColor(
                Constants.BACKGROUND_COLOR.r,
                Constants.BACKGROUND_COLOR.g,
                Constants.BACKGROUND_COLOR.b,
                Constants.BACKGROUND_COLOR.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


      batch.setProjectionMatrix(viewport.getCamera().combined);

      batch.begin();

      TextureRegion region=Assets.instance.gigaGalAssets.standingRight;

        batch.draw(
                region.getTexture(),
                50,
                50,
                0,
                0,
                region.getRegionWidth(),
                region.getRegionHeight(),
                1,
                1,
                0,
                region.getRegionX(),
                region.getRegionY(),
                region.getRegionWidth(),
                region.getRegionHeight(),
                false,
                false);

        batch.end();

    }
}
