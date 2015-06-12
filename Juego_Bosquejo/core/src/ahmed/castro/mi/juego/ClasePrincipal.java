package ahmed.castro.mi.juego;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ClasePrincipal extends ApplicationAdapter{
	SpriteBatch batch;
    Texture character_textures[];
    Texture bg;
    Texture enemigo;
    //Texture game_over_texture;


    int frame;
    int textura_actual;

    double y = 100;
    double velocidad_y;

    int bg_x;
    int enemigo_x;

    //boolean game_over;

    double VELOCIDAD_INICIAL=20;
    double GRAVEDAD=-1;
    double PISO = 180;
    int VELOCIDAD=10;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        character_textures = new Texture[3];
        character_textures[0] = new Texture("coche1.png");
        character_textures[1] = new Texture("coche1.png");
        character_textures[2] = new Texture("coche1.png");
        bg = new Texture("carretera9.png");
        enemigo = new Texture("car_enemigo1.png");
        System.out.println(Gdx.graphics.getWidth());
        System.out.println(Gdx.graphics.getHeight());
        frame = 0;
        textura_actual = 0;
        bg_x=0;
        enemigo_x=640;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
        batch.draw(bg, bg_x, 0);
        batch.draw(bg, bg_x+640, 0);
        batch.draw(enemigo, enemigo_x, 100);
        batch.draw(enemigo, enemigo_x, 250);
        batch.draw(character_textures[textura_actual], 0, (int)y);
        batch.draw(enemigo, enemigo_x, 450);
        batch.draw(enemigo, enemigo_x, 690);
		batch.end();

        enemigo_x-=VELOCIDAD;
        if(enemigo_x<=-800)
            enemigo_x=640;

        if(enemigo_x<character_textures[textura_actual].getWidth()-5
                && enemigo_x-enemigo.getWidth()>0
                && y<200)
        {
        }

        bg_x-=VELOCIDAD;
        if(bg_x<=-640)
            bg_x=0;

        if(frame%20==0)
        {
            textura_actual++;
            if(textura_actual>2)
                textura_actual=0;
        }

        if(Gdx.input.justTouched())
        {
            velocidad_y=VELOCIDAD_INICIAL;
        }
        velocidad_y+=GRAVEDAD;
        y=velocidad_y;
        if(y<PISO)
            y=PISO;

        frame++;

	}
}
