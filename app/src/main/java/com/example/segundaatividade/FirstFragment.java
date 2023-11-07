package com.example.segundaatividade;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.segundaatividade.databinding.FragmentFirstBinding;
import com.example.segundaatividade.models.Aluno;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private AlunoListAdapter alunoBinding;
    public Aluno aluno;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        RecyclerView rv = rootView.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(requireContext());
        rv.setLayoutManager(llm);

        ArrayList<Aluno> dados = new ArrayList<>();
        dados.add(new Aluno("Gabriel Alexandre Victório", "233138", "gabriel.victorio@edu.unipar.br"));
        dados.add(new Aluno("Thiago Correa de Souza", "193583", "thiago.souza@edu.unipar.br"));
        dados.add(new Aluno("Vitor Ferraresi Pegino", "215993", "thiago.souza@edu.unipar.br"));

        AlunoListAdapter adapter = new AlunoListAdapter(dados);
        rv.setAdapter(adapter);

        return rootView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}