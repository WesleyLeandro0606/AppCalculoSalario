package br.ulbra.appcalculosalario;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivy extends Activity {

    RadioGroup rgopcoes;
    Button btcalcular;
    EditText edsalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edsalario = (EditText) findViewById(R.id.edsalario);
        rgopcoes = (RadioGroup) findViewById(R.id.rgopcoes);
        btcalcular = (Button) findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String valor = edsalario.getText().toString()
                        .replace(".", "")
                        .replace(",", ".");

                double salario = Double.parseDouble(valor);

                int op = rgopcoes.getCheckedRadioButtonId();

                double novo_salario = 0;

                if (op == R.id.rb40)
                    novo_salario = salario + (salario * 0.4);

                else if (op == R.id.rb45)
                    novo_salario = salario + (salario * 0.45);

                else
                    novo_salario = salario + (salario * 0.5);

                AlertDialog.Builder dialogo =
                        new AlertDialog.Builder(MainActivy.this);

                dialogo.setTitle("Novo salário");

                dialogo.setMessage(
                        "Seu novo salário é : R$"
                                + String.format("%.2f", novo_salario)
                );

                dialogo.setNeutralButton("OK", null);

                dialogo.show();
            }
        });
    }
}