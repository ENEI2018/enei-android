package com.enei.eneimobile.views;

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
    private static final String APP_URL_PREFIX = "enei://";

    private static final String CODE_SONAEIM = "sonaeim";
    private static final String CODE_DELOITTE = "deloitte";
    private static final String CODE_EFACEC = "efacec";
    private static final String CODE_NATIXIS = "natixis";
    private static final String CODE_WIPRO = "wipro";
    private static final String CODE_BIBLIOTECA = "biblioteca";
    private static final String CODE_PORTAFEUP = "portafeup";
    private static final String CODE_NIAEFEUP = "niaefeup";
    private static final String CODE_IEEE = "ieee";
    private static final String CODE_CANTINA = "cantina";
    private static final String CODE_FALCAO = "falcao";
    private static final String CODE_QUEIJOS = "queijos";
    private static final String CODE_DEI = "dei";
    private static final String CODE_CICA = "cica";
    private static final String CODE_AEFEUP = "aefeup";
    //private static final String CODE_ = "";

    private static final List<String> locations = new ArrayList<>();
    static {
        locations.add(CODE_SONAEIM);
        locations.add(CODE_DELOITTE);
        locations.add(CODE_EFACEC);
        locations.add(CODE_NATIXIS);
        locations.add(CODE_WIPRO);
        locations.add(CODE_BIBLIOTECA);
        locations.add(CODE_PORTAFEUP);
        locations.add(CODE_NIAEFEUP);
        locations.add(CODE_IEEE);
        locations.add(CODE_CANTINA);
        locations.add(CODE_FALCAO);
        locations.add(CODE_QUEIJOS);
        locations.add(CODE_DEI);
        locations.add(CODE_CICA);
        locations.add(CODE_AEFEUP);
    }

    private static final Map<String, String> locationCodes = new HashMap<>();
    static {
        locationCodes.put(CODE_SONAEIM, "hasherino1");
        locationCodes.put(CODE_DELOITTE, "hasherino2");
        locationCodes.put(CODE_EFACEC, "hasherino3");
        locationCodes.put(CODE_NATIXIS, "hasherino4");
        locationCodes.put(CODE_WIPRO, "hasherino5");
        locationCodes.put(CODE_BIBLIOTECA, "hasherino6");
        locationCodes.put(CODE_PORTAFEUP, "hasherino7");
        locationCodes.put(CODE_NIAEFEUP, "hasherino8");
        locationCodes.put(CODE_IEEE, "hasherino9");
        locationCodes.put(CODE_CANTINA, "hasherino10");
        locationCodes.put(CODE_FALCAO, "hasherino11");
        locationCodes.put(CODE_QUEIJOS, "hasherino12");
        locationCodes.put(CODE_DEI, "hasherino13");
        locationCodes.put(CODE_CICA, "hasherino14");
        locationCodes.put(CODE_AEFEUP, "hasherino15");
    }

    private static final Map<String, Integer> locationViewIds = new HashMap<>();
    static {
        locationViewIds.put(CODE_SONAEIM, R.id.sonaeim);
        locationViewIds.put(CODE_DELOITTE, R.id.deloitte);
        locationViewIds.put(CODE_EFACEC, R.id.efacec);
        locationViewIds.put(CODE_NATIXIS, R.id.natixis);
        locationViewIds.put(CODE_WIPRO, R.id.wipro);
        locationViewIds.put(CODE_BIBLIOTECA, R.id.biblioteca);
        locationViewIds.put(CODE_PORTAFEUP, R.id.entrada);
        locationViewIds.put(CODE_NIAEFEUP, R.id.niaefeup);
        locationViewIds.put(CODE_IEEE, R.id.ieee);
        locationViewIds.put(CODE_CANTINA, R.id.cantina);
        locationViewIds.put(CODE_FALCAO, R.id.falcao);
        locationViewIds.put(CODE_QUEIJOS, R.id.queijos);
        locationViewIds.put(CODE_DEI, R.id.dei);
        locationViewIds.put(CODE_CICA, R.id.cica);
        locationViewIds.put(CODE_AEFEUP, R.id.aefeup);
    }

    private static final Map<String, String> locationNames = new HashMap<>();
    static {
        locationNames.put(CODE_SONAEIM, "SONAE IM");
        locationNames.put(CODE_DELOITTE, "Deloitte");
        locationNames.put(CODE_EFACEC, "Efacec");
        locationNames.put(CODE_NATIXIS, "Natixis");
        locationNames.put(CODE_WIPRO, "Wipro");
        locationNames.put(CODE_BIBLIOTECA, "Biblioteca");
        locationNames.put(CODE_PORTAFEUP, "Entrada FEUP");
        locationNames.put(CODE_NIAEFEUP, "NIAEFEUP");
        locationNames.put(CODE_IEEE, "IEEE");
        locationNames.put(CODE_CANTINA, "Cantina");
        locationNames.put(CODE_FALCAO, "Pavilhão Luís Falcão");
        locationNames.put(CODE_QUEIJOS, "Queijos");
        locationNames.put(CODE_DEI, "Departamento de Engenharia Informática");
        locationNames.put(CODE_CICA, "CICA");
        locationNames.put(CODE_AEFEUP, "AEFEUP");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String readUrl = getIntent().getDataString();
        if(readUrl != null) {
            readUrl = readUrl.substring(APP_URL_PREFIX.length());
        }

        if(readUrl != null && readUrl.length() > 0) {
            String place = null;
            String location = null;
            for(String loc : locations) {
                if(locationCodes.get(loc).equals(readUrl)) {
                    place = locationNames.get(loc);
                    location = loc;
                    break;
                }
            }
            if(place != null) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
                if(prefs.getBoolean(location, false)) {
                    DialogHelper.showOkDialog(this, "Já tinhas descoberto o lugar \"" + place + "\". Procura novos códigos nos locais do ENEI!");
                } else {
                    DialogHelper.showOkDialog(this, "Parabéns! Descobriste " + place);
                    prefs.edit().putBoolean(location, true).apply();
                }
            }
        }

        checkSuccessfulCodes();

        for(String loc : locations) {
            int id = locationViewIds.get(loc);
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogHelper.showOkDialog(GameActivity.this, "We are still working on this message, our typewriters have broken.");
                }
            });
        }
    }

    private void checkSuccessfulCodes() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        for(String location : locations) {
            if(prefs.getBoolean(location, false)) {
                findViewById(locationViewIds.get(location)).setAlpha(1);
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
                DialogHelper.showOkDialog(this, "Procura os códigos QR do ENEI" +
                        "espalhados nos diversos locais do encontro e lê-os com o teu telemóvel!" +
                        "Sefores dos primeiros a colecionar todos os sítios podes ganhar brindes " +
                        "grátis do ENEI! Dica: se carregares nas imagens podes ter algumas" +
                        " pistas ;)");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
