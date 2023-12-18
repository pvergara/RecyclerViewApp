package org.ecos.logic.recyclerviewapp.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.ecos.logic.recyclerviewapp.MainActivity2;
import org.ecos.logic.recyclerviewapp.R;
import org.ecos.logic.recyclerviewapp.data.Refueling;

public class RefuelingViewHolder extends RecyclerView.ViewHolder {
    private final ImageView image;
    private Refueling refueling;
    private TextView textView;

    public RefuelingViewHolder(@NonNull View itemView) {
        super(itemView);

        this.textView = itemView.findViewById(R.id.textView);
        this.image = itemView.findViewById(R.id.imageView);
        this.image.setOnLongClickListener(this::longClick);

        itemView.setOnClickListener(this::onClick);

    }

    private ActivityResultLauncher<Intent> launcher;


    private void onClick(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity2.class);
//        intent.putExtra();
//        private int type;
//        private String date;
//        private double litres;
//        private int km;
//        private int gasStationId;

        launcher.launch(intent);
    }

    private boolean longClick(View view) {
        return false;
    }

    public void setRefueling(Refueling refueling) {
        this.refueling = refueling;
    }

    public void update() {
        this.textView.setText(this.refueling.getKm()+"");
        this.image.setImageResource(this.refueling.getGasStation().getLogo());
    }

    public void setLauncher(ActivityResultLauncher<Intent> launcher) {
        this.launcher = launcher;
    }
}
