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
        locationCodes.put(CODE_SONAEIM, "QTf5C4Xdql");
        locationCodes.put(CODE_DELOITTE, "tvQWbsbTHR");
        locationCodes.put(CODE_EFACEC, "vSUpNIygM5");
        locationCodes.put(CODE_NATIXIS, "EnMJE4Kj0k");
        locationCodes.put(CODE_WIPRO, "JZk5h5oFXC");
        locationCodes.put(CODE_BIBLIOTECA, "6R1pSGuttd");
        locationCodes.put(CODE_PORTAFEUP, "JRTszWRIUl");
        locationCodes.put(CODE_NIAEFEUP, "JJP0KJ3Omo");
        locationCodes.put(CODE_IEEE, "U5JJDnFfE1");
        locationCodes.put(CODE_CANTINA, "UdOsCciw5n");
        locationCodes.put(CODE_FALCAO, "GI5ON0865E");
        locationCodes.put(CODE_QUEIJOS, "5C6fvNL8QQ");
        locationCodes.put(CODE_DEI, "gEDh1XDqXk");
        locationCodes.put(CODE_CICA, "tH2NmauM4x");
        locationCodes.put(CODE_AEFEUP, "xFxRv85oc5");
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

    private static final Map<Integer, String> viewHints = new HashMap<>();
    static {
        viewHints.put(R.id.sonaeim, "[TESTE] código 1 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.deloitte, "[TESTE] código 2 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.efacec, "[TESTE] código 3 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.natixis, "[TESTE] código 4 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.wipro, "[TESTE] código 5 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.biblioteca, "[TESTE] código 6 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.entrada, "[TESTE] código 7 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.niaefeup, "[TESTE] código 8 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.ieee, "[TESTE] código 9 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.cantina, "[TESTE] código 10 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.falcao, "[TESTE] código 11 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.queijos, "[TESTE] código 12 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.dei, "[TESTE] código 13 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.cica, "[TESTE] código 14 (futuramente existirão pistas sobre onde encontrar os códigos)");
        viewHints.put(R.id.aefeup, "[TESTE] código 15 (futuramente existirão pistas sobre onde encontrar os códigos)");
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
                    DialogHelper.showOkDialog(this, "Parabéns! Descobriste o local \"" + place + "\". Não desistas de procurar os outros códigos!");
                    prefs.edit().putBoolean(location, true).apply();
                }
            }
        }

        checkSuccessfulCodes();

        checkWon();

        View.OnClickListener hintListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hint = viewHints.get(view.getId());
                DialogHelper.showOkDialog(GameActivity.this, hint);
            }
        };

        for(String loc : locations) {
            int id = locationViewIds.get(loc);
            findViewById(id).setOnClickListener(hintListener);
        }
    }

    private void checkWon() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        for(String location : locations) {
            if(!prefs.getBoolean(location, false)) {
                return;
            }
        }
        DialogHelper.showOkDialog(this, "Encontraste todos os códigos! Mostra esta mensagem a um membro da organização para receberes o teu brinde ;)");
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
