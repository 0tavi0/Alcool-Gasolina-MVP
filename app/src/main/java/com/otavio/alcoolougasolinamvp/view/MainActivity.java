package com.otavio.alcoolougasolinamvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.otavio.alcoolougasolinamvp.R;
import com.otavio.alcoolougasolinamvp.presenter.PresenterMainActivity;
import com.otavio.alcoolougasolinamvp.task.MainActivityTask;

public class MainActivity extends AppCompatActivity implements MainActivityTask.View {

    private MainActivityTask.Presenter presenter;
    TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtalcool = findViewById(R.id.edtAlcool);
        final EditText edtgasolina = findViewById(R.id.edtGasolina);

        txtResultado = findViewById(R.id.txtResultado);

        Button btnCalcular = findViewById(R.id.btnok);
        presenter = new PresenterMainActivity(this);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String alcool = edtalcool.getText().toString();
                String gasolina = edtgasolina.getText().toString();


                presenter.calcular(alcool, gasolina);


            }
        });
    }

    @Override
    public void edtAlcoolEmBranco() {

        Toast.makeText(this, "Faltando Alcool", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void edtGasolinaEmBranco() {
        Toast.makeText(this, "Faltando Gasolina", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void mostrarResultado(String resultado) {
        txtResultado.setText(resultado);
    }


}
