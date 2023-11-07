package com.example.segundaatividade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class SecondFragment extends Fragment {

    private EditText nota1;
    private EditText nota2;

    public void MediaCalculatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        nota1 = view.findViewById(R.id.nota1);
        nota2 = view.findViewById(R.id.nota2);

        Button calcularButton = view.findViewById(R.id.calcularButton);
        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularMedia(v);
            }
        });

        return view;
    }

    private void calcularMedia(View view) {
            double valor1 = Double.parseDouble(nota1.getText().toString());
            double valor2 = Double.parseDouble(nota2.getText().toString());

            double resultado = (valor1 + valor2) / 2;

            if(resultado < 4)
                mostrarSnackbar(view, String.format(Locale.getDefault(), "Aluno Reprovado: Média: %.2f", resultado));
            else if (resultado >= 4 && resultado < 6)
                mostrarSnackbar(view, String.format(Locale.getDefault(), "Aluno em Recuperação: Média: %.2f", resultado));
            else
                mostrarSnackbar(view, String.format(Locale.getDefault(), "Aluno Aprovado: Média: %.2f", resultado));
    }

    private void mostrarSnackbar(View view, String mensagem) {
        Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT).show();
    }
}
