package com.enei.eneimobile.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.enei.eneimobile.R;
import com.enei.eneimobile.utils.DialogHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameActivity extends AppCompatActivity {
    public static final String APP_URL_PREFIX = "enei://";
    public static final String EXTRA_KEY = "ENEI_CODE";

    public static class Location {
        public String code;
        public String hash;
        public int view;
        public String name;
        public String hint;

        public Location(String code, String hash, int view, String name, String hint) {
            this.code = code;
            this.hash = hash;
            this.view = view;
            this.name = name;
            this.hint = hint;
        }
    }


    public static final List<Location> newLocations = new ArrayList<>();
    static {
        newLocations.add(new Location("sonaeim", "QTf5C4Xdql", R.id.sonaeim, "SONAE IM", "[TESTE] código 1 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("deloitte", "tvQWbsbTHR", R.id.deloitte, "Deloitte", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("efacec", "vSUpNIygM5", R.id.efacec, "Efafec", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("natixis", "EnMJE4Kj0k", R.id.natixis, "Natixis", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("wipro", "JZk5h5oFXC", R.id.wipro, "Wipro", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("biblioteca", "6R1pSGuttd", R.id.biblioteca, "Biblioteca", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("portafeup", "JRTszWRIUl", R.id.entrada, "Entrada FEUP", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("niaefeup", "JJP0KJ3Omo", R.id.niaefeup, "NIAEFEUP", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("ieee", "U5JJDnFfE1", R.id.ieee, "IEEE UP Student Branch", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("cantina", "UdOsCciw5n", R.id.cantina, "Cantina de Engenharia", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("falcao", "GI5ON0865E", R.id.falcao, "Pavilhào Luís Falcão", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("queijos", "5C6fvNL8QQ", R.id.queijos, "Queijos", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("dei", "gEDh1XDqXk", R.id.dei, "DEI", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("cica", "tH2NmauM4x", R.id.cica, "CICA", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
        newLocations.add(new Location("aefeup", "xFxRv85oc5", R.id.aefeup, "AEFEUP", "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String readUrl = getIntent().getStringExtra(EXTRA_KEY);

        if (readUrl != null && readUrl.length() > 0) {
            Location selectedLocation = null;
            for (Location loc : newLocations) {
                if (loc.hash.equals(readUrl)) {
                    selectedLocation = loc;
                    break;
                }
            }

            if (selectedLocation != null) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                if (prefs.getBoolean(selectedLocation.hash, false)) {
                    DialogHelper.showOkDialog(this, "Já tinhas descoberto o lugar \"" + selectedLocation.name + "\". Procura novos códigos nos locais do ENEI!");
                } else {
                    DialogHelper.showOkDialog(this, "Parabéns! Descobriste o local \"" + selectedLocation.name + "\". Não desistas de procurar os outros códigos!");
                    prefs.edit().putBoolean(selectedLocation.hash, true).apply();
                }
            } else {
                Intent myIntent =
                        new Intent(GameActivity.this, PeddyPaperActivity.class);
                GameActivity.this.startActivity(myIntent);
            }
        }

        checkSuccessfulCodes();

        checkWon();

        View.OnClickListener hintListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Location loc = null;
                for(Location l : newLocations) {
                    if(l.view == view.getId()) {
                        loc = l;
                        break;
                    }
                }

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(GameActivity.this);
                if(loc != null) {
                    if(prefs.getBoolean(loc.hash, false)) {
                        DialogHelper.showOkDialog(GameActivity.this, "Local: " + loc.name + '\n' + loc.hint);
                    } else {
                        DialogHelper.showOkDialog(GameActivity.this, loc.hint);
                    }
                }
            }
        };

        for (Location loc : newLocations) {
            findViewById(loc.view).setOnClickListener(hintListener);
        }
    }

    private void checkWon() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        for (Location location : newLocations) {
            if (!prefs.getBoolean(location.hash, false)) {
                return;
            }
        }
        DialogHelper.showOkDialog(this, "Encontraste todos os códigos! Mostra esta mensagem a um membro da organização para receberes o teu brinde ;)");
    }

    private void checkSuccessfulCodes() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        for (Location location : newLocations) {
            if (prefs.getBoolean(location.hash, false)) {
                findViewById(location.view).setAlpha(1);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.schedule_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.schedule_help:
                DialogHelper.showOkDialog(this, "Procura os códigos QR do ENEI " +
                        "espalhados nos diversos locais do encontro e lê-os com o teu telemóvel!" +
                        " Se fores dos primeiros a colecionar todos os sítios podes ganhar brindes " +
                        "grátis do ENEI! Dica: se carregares nas imagens podes ter algumas" +
                        " pistas ;)");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
