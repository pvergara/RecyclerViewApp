package org.ecos.logic.recyclerviewapp;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import org.ecos.logic.recyclerviewapp.adapter.RefuelingAdapter;
import org.ecos.logic.recyclerviewapp.data.Data;

public class MainActivity extends AppCompatActivity {

    private final RefuelingAdapter refuelingAdapter = new RefuelingAdapter(Data.getRefuelingCollection());
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView refuelingCollection = this.findViewById(R.id.refueling_collection);

        if (this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            refuelingCollection.setLayoutManager(new LinearLayoutManager(this.getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        } else {
            refuelingCollection.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        }

        refuelingCollection.setAdapter(refuelingAdapter);

        prepareBackButton();

        createAlertDialog();

        setTitle(R.string.refueling);
    }

    private void prepareBackButton() {
        OnBackPressedDispatcher lerele = this.getOnBackPressedDispatcher();
        lerele.addCallback(this, onBackPressedCallback);
    }

    private void createAlertDialog() {
        builder = new AlertDialog.Builder(MainActivity.this).
                setTitle(R.string.titulo).
                setMessage(R.string.mensaje).
                setIcon(android.R.drawable.ic_dialog_alert);
        Drawable icono = MainActivity.this.getDrawable(android.R.drawable.ic_dialog_alert);
        int color = MainActivity.this.getColor(R.color.purple_500);
        icono.setTint(color);
        builder.setIcon(icono);
        builder.setPositiveButton(R.string.ok,MainActivity.this::onOkListerner);
        builder.create();
    }

    private final OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback(true) {
        @Override
        public void handleOnBackPressed() {
            builder.show();
        }
    };

    private void onOkListerner(DialogInterface dialogInterface, int i) {
        finish();
    }


}