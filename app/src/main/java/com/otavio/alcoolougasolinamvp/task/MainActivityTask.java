package com.otavio.alcoolougasolinamvp.task;

public interface MainActivityTask {

    interface View{

        void edtAlcoolEmBranco();

        void edtGasolinaEmBranco();

        void mostrarResultado(String resultado);
    }

    interface Presenter{
        void calcular(String alcool, String gasolina);
    }
}
