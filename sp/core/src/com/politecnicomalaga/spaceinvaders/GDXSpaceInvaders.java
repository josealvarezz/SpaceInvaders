package com.politecnicomalaga.spaceinvaders;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Random;

public class GDXSpaceInvaders extends ApplicationAdapter {

	//ESTADO
	private SpriteBatch batch;
	private int x,y;
	private Random r = new Random();
	private ArrayList <NaveEnemiga> escuadron;
	private int direccionX;
	private NaveAliada player;
	private Disparo disparoAliado;
	//private ArrayList<DisparoAmigo> rafagaAmiga;
	//private int pasos;
	//private int zonaDerecha;
	//private int zonaIzq;


	//COMPORTAMIENTO

	//RESTO COMPORTAMIENTOS

	//¿CONSTRUCTOR? NO TENGO, pero me dicen que create hace las veces de contructor
	@Override
	public void create () {
		batch = new SpriteBatch();
		direccionX = 1;
		escuadron = new ArrayList<>();
		player = new NaveAliada(Gdx.graphics.getWidth()/2, 50, 0, "nave.png", 50, 60);
		disparoAliado = new Disparo(player.getPosX(), player.getPosY(), 4f, "shot.png",50,60);

		//Primero se divide el ancho de la pantalla entre el número de naves + 1.
		//Este número lo ponemos en segmento.
		//Ahora, se inicializa posición a 0.
		//Y repetimos: Crear la nave, en la posición += segmento tantas vece como naves.
		int segmento = Gdx.graphics.getWidth() / 6;
		int posicion = 0;
		for (int i = 0; i < 5; i++) {
			posicion += segmento;
			escuadron.add(new NaveEnemiga(posicion, Gdx.graphics.getHeight() - 100, -1, "enemy.png", 40, 40));
		}
	}

	@Override
	public void render () {

		Random r = new Random();

		//dibujar despues
		ScreenUtils.clear(0f, 0f, 0f, 1);

		batch.begin();

		player.render(batch);
		player.moverse(Gdx.input.isKeyPressed(A), Gdx.input.isKeyPressed(D));

		// Ajustar la posición de la nave si se sale de los bordes
		if (player.getPosX() > Gdx.graphics.getWidth() - player.getWidth()) {
			player.setPosX(Gdx.graphics.getWidth() - player.getWidth());
		} else if (player.getPosX() < 0) {
			player.setPosX(0);
		}


		// Mueve el escuadrón completo en la misma dirección
		for (NaveEnemiga ov: escuadron) {
			ov.setPosX(ov.getPosX() + (direccionX * -ov.getVelX())); //-ov.getVelX() para que direccionX en 1 vaya a la derecha y -1 a la izquierda
			ov.setPosY(ov.getPosY() + (ov.getVelY()));
		}

		// Cambia la dirección del escuadrón cuando toca los bordes
		if (escuadron.get(0).getPosX() <= 0 || escuadron.get(escuadron.size()-1).getPosX() >= Gdx.graphics.getWidth()-escuadron.get(escuadron.size()-1).getWidth()) {
			direccionX = -direccionX;
		}

		for (NaveEnemiga ov: escuadron) {
			ov.render(batch);
		}

		disparoAliado.render(batch);
		disparoAliado.moverse();

		if (disparoAliado.getPosY() > Gdx.graphics.getHeight()) {
			disparoAliado.setPosX(player.getPosX());
			disparoAliado.setPosY(player.getPosY());
		}
		batch.end();
	}

	
	@Override
	public void dispose () {
		batch.dispose();
	}


}
