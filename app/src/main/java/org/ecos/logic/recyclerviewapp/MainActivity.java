package org.ecos.logic.recyclerviewapp;

import static android.view.Window.FEATURE_ACTION_BAR;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.ecos.logic.recyclerviewapp.adapter.RefuelingAdapter;
import org.ecos.logic.recyclerviewapp.data.Data;
import org.ecos.logic.recyclerviewapp.data.Refueling;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<Refueling> refuelingCollection = Data.getRefuelingCollection();
    private final RefuelingAdapter refuelingAdapter = new RefuelingAdapter(refuelingCollection);
    private AlertDialog.Builder builder;
    private final ActivityResultContracts.StartActivityForResult contract = new ActivityResultContracts.StartActivityForResult();
    private ActivityResultLauncher<Intent> launcher;

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

        this.launcher = this.registerForActivityResult(contract, MainActivity::onActivityResult);
        refuelingAdapter.setLauncher(this.launcher);
        refuelingCollection.setAdapter(refuelingAdapter);

        prepareBackButton();

        createAlertDialog();

    }

    private static void onActivityResult(ActivityResult o) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.edit_menu_item){
            Toast.makeText(this.getApplicationContext(),R.string.edit,Toast.LENGTH_LONG).show();
        }
        if(item.getItemId() == R.id.delete_menu_item){
            this.refuelingCollection.get(1).setKm(666);
            this.refuelingAdapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
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