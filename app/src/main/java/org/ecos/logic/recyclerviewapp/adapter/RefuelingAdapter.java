package org.ecos.logic.recyclerviewapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ecos.logic.recyclerviewapp.R;
import org.ecos.logic.recyclerviewapp.data.Refueling;

import java.util.List;

public class RefuelingAdapter extends RecyclerView.Adapter<RefuelingViewHolder> {
    private final List<Refueling> refuelingCollection;

    public void setLauncher(ActivityResultLauncher<Intent> launcher) {
        this.launcher = launcher;
    }

    private ActivityResultLauncher<Intent> launcher;

    public RefuelingAdapter(List<Refueling> refuelingCollection) {
        this.refuelingCollection = refuelingCollection;
    }

    @NonNull
    @Override
    public RefuelingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell, parent, false);
        RefuelingViewHolder refuelingViewHolder = new RefuelingViewHolder(view);
        refuelingViewHolder.setLauncher(this.launcher);
        return refuelingViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RefuelingViewHolder holder, int position) {
        holder.setRefueling(this.refuelingCollection.get(position));
        holder.update();
    }

    @Override
    public int getItemCount() {
        return this.refuelingCollection.size();
    }

}
