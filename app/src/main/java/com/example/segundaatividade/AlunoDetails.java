package com.example.segundaatividade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.segundaatividade.models.Aluno;

public class AlunoDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_details);

        Bundle bundle = getIntent().getExtras();
        Aluno aluno = bundle.getParcelable("aluno");

        if (aluno != null) {
            TextView textViewRA = findViewById(R.id.raTextView);
            TextView textViewNome = findViewById(R.id.nomeTextView);
            TextView textViewEmail = findViewById(R.id.emailTextView);

            textViewRA.setText(aluno.getRa());
            textViewNome.setText(aluno.getNome());
            textViewEmail.setText(aluno.getEmail());
        }
    }
}