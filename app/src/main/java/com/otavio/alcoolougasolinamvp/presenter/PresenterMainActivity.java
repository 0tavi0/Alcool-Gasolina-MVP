package com.otavio.alcoolougasolinamvp.presenter;

import com.otavio.alcoolougasolinamvp.task.MainActivityTask;
import com.otavio.alcoolougasolinamvp.view.MainActivity;

public class PresenterMainActivity implements MainActivityTask.Presenter {

    private MainActivityTask.View view;

    public PresenterMainActivity(MainActivityTask.View view) {
        this.view = view;
    }

    @Override
    public void calcular(String alcool, String gasolina) {
        if (alcool.isEmpty() || gasolina.isEmpty()){
            if (alcool.isEmpty()){
                view.edtAlcoolEmBranco();
            }
            if (gasolina.isEmpty()){
                view.edtGasolinaEmBranco();
            }


        }else {
            double Resultado = Double.parseDouble(alcool)/Double.parseDouble(gasolina);

            if (Resultado<=0.7) {
                view.mostrarResultado("Alcool");
            }else {
                view.mostrarResultado("Gasolina");
            }


        }


    }
}
