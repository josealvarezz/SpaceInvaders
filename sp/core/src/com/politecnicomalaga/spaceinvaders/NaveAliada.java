package com.politecnicomalaga.spaceinvaders;

public class NaveAliada extends ObjetoVolador {

    //ESTADO

    //COMPORTAMIENTO
    //Constructor
    public NaveAliada(float pX, float pY, float vX, String imgStr, float w, float h) {
        super(pX,pY,vX,0,imgStr,w,h);
    }

    @Override
    public void setVelY(float velY) {

    }

    public void moverse(boolean A, boolean D) {
        if (A){
            velX= -3f;
        }else if (D){
            velX = 3f;
        }else{
            velX = 0;
        }
        super.moverse();
    }
}
