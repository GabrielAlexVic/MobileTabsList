package com.example.segundaatividade;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.segundaatividade.models.Aluno;

import java.util.ArrayList;

public class AlunoListAdapter extends RecyclerView.Adapter<AlunoListAdapter.AlunoViewHolder>{
    ArrayList<Aluno> dados = new ArrayList<>();

    public AlunoListAdapter( ArrayList<Aluno> dados) {
        this.dados = dados;
    }

    @NonNull
    @Override
    public AlunoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        AlunoViewHolder pvh = new AlunoViewHolder(v);

        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AlunoViewHolder holder, int position) {
        holder.ra.setText(dados.get(position).getRa());
        holder.nome.setText(dados.get(position).getNome());
        holder.email.setText(dados.get(position).getEmail());

        holder.buttonVerDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, AlunoDetails.class);

                intent.putExtra("aluno", dados.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }

    public static class AlunoViewHolder extends RecyclerView.ViewHolder {
        TextView ra;
        TextView nome;
        TextView email;
        public Button buttonVerDados;

        public AlunoViewHolder(@NonNull View itemView) {
            super(itemView);
                
            //dados dos alunos
            ra = itemView.findViewById(R.id.ra);
            nome = itemView.findViewById(R.id.nome);
            email = itemView.findViewById(R.id.email);
            buttonVerDados = itemView.findViewById(R.id.containedButton);
        }
    }
}
