package com.politecnicomalaga.spaceinvaders;

public class Disparo extends ObjetoVolador {
    public Disparo(float pX, float pY, float vY, String imgStr, float w, float h) {
        super(pX, pY, 0f, vY, imgStr, w, h);
    }

    @Override
    public void moverse() {
        posY += velY;
    }


    @Override
    public void setPosY(float pY) { //Si no declaraba este método aquí junto con override no me funcionaba
        this.posY = pY;
    }
}
