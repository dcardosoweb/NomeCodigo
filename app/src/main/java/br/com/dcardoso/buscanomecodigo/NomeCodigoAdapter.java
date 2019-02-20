package br.com.dcardoso.buscanomecodigo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.dcardoso.buscanomecodigo.databinding.FragmentNomeItemBinding;

public class NomeCodigoAdapter extends RecyclerView.Adapter<NomeCodigoAdapter.NomeCodigoViewHolder> {

    private List<NomeCodigo> nomeList;
    private Context context;

    public NomeCodigoAdapter(List<NomeCodigo> itemList, Context ctx){
        nomeList = itemList;
        context = ctx;
    }

    @Override
    public int getItemCount() {
        return nomeList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull NomeCodigoViewHolder nomeCodigoViewHolder, int i) {

        NomeCodigo item = nomeList.get(i);
        nomeCodigoViewHolder.binding.setItem(item);
    }

    @NonNull
    @Override
    public NomeCodigoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        FragmentNomeItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.getContext()),
                R.layout.fragment_nome_item, viewGroup, false);

        NomeCodigoViewHolder viewHolder = new NomeCodigoViewHolder(binding);
        return viewHolder;
    }

    public class NomeCodigoViewHolder extends RecyclerView.ViewHolder {

        FragmentNomeItemBinding binding;

        public NomeCodigoViewHolder(FragmentNomeItemBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            binding = itemLayoutBinding;
        }

        public NomeCodigoViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
