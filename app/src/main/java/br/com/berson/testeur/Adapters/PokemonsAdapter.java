package br.com.berson.testeur.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.berson.testeur.Controllers.OnItemClickListener;
import br.com.berson.testeur.Models.Result;
import br.com.berson.testeur.R;

public class PokemonsAdapter extends RecyclerView.Adapter<PokemonsAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<Result> bancos;
    private final OnItemClickListener listener;



    public PokemonsAdapter(Context context, ArrayList<Result> bancos, OnItemClickListener listener) {
        this.mContext = context;
        this.bancos = bancos;
        this.listener = listener;

        Log.e("sewqqswsq", bancos.toString());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layouts_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.pokemonName.setText(bancos.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return bancos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView pokemonName;

        ViewHolder(final View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.nomePokemon);

            itemView.setOnClickListener(v -> {
                listener.onItemClick(bancos.get(getAdapterPosition()));
            });
        }
    }
}
