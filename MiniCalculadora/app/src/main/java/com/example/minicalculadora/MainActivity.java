package com.example.minicalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText primeiroNumero;
    private TextInputEditText segundoNumero;
    private TextView resultadoCalculo;
    private RadioGroup tipoOperacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        primeiroNumero = findViewById(R.id.editPriNum);
        segundoNumero = findViewById(R.id.editSegNum);
        resultadoCalculo = findViewById(R.id.resultado);
        tipoOperacao = findViewById(R.id.operacao);
    }

    public void realizarOperacao(View view) {
        float nUm = 0, nDois = 0;
        boolean erro = false;
        try {
            nUm = Float.parseFloat(primeiroNumero.getText().toString());
            nDois = Float.parseFloat(segundoNumero.getText().toString());
        } catch (Exception e) {
            erro = true;
        } finally {
            if (erro == false) {
                calcularResultado(nUm, nDois);
            } else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Atenção");
                dialog.setMessage("É necessário digitar os dois números");
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.create();
                dialog.show();
            }
        }
    }

    public void calcularResultado(Float nUm, Float nDois){
        float resultado =  0;
        switch (tipoOperacao.getCheckedRadioButtonId()){
            case R.id.rbSoma:
                resultado = nUm + nDois;
                break;
            case R.id.rbSub:
                resultado = nUm - nDois;
                break;
            case R.id.rbMulti:
                resultado = nUm * nDois;
                break;
            case R.id.rbDiv:
                resultado = nUm / nDois;
                break;
        }
        resultadoCalculo.setText(String.valueOf(resultado));
    }
}