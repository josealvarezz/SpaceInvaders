package com.politecnicomalaga.spaceinvaders;

public class NaveEnemiga extends ObjetoVolador{
    //ESTADO

    //COMPORTAMIENTO
    //constructor
    public NaveEnemiga(float pX, float pY, float vX, String imgStr, float w, float h) {
        super(pX,pY,vX,0,imgStr,w,h);
    }

    @Override
    public void setVelY(float velY) {

    }

    @Override
    public void moverse() {
        posX += velX;
    }
}
