package com.enei.eneimobile.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
        locationCodes.put(CODE_SONAEIM, "hasherino");
        locationCodes.put(CODE_DELOITTE, "hasherino");
        locationCodes.put(CODE_EFACEC, "hasherino");
        locationCodes.put(CODE_NATIXIS, "hasherino");
        locationCodes.put(CODE_WIPRO, "hasherino");
        locationCodes.put(CODE_BIBLIOTECA, "hasherino");
        locationCodes.put(CODE_PORTAFEUP, "hasherino");
        locationCodes.put(CODE_NIAEFEUP, "hasherino");
        locationCodes.put(CODE_IEEE, "hasherino");
        locationCodes.put(CODE_CANTINA, "hasherino");
        locationCodes.put(CODE_FALCAO, "hasherino");
        locationCodes.put(CODE_QUEIJOS, "hasherino");
        locationCodes.put(CODE_DEI, "hasherino");
        locationCodes.put(CODE_CICA, "hasherino");
        locationCodes.put(CODE_AEFEUP, "hasherino");
    }

    private static final Map<String, Integer> locationViewIds = new HashMap<>();
    static {
        locationViewIds.put(CODE_SONAEIM, "hasherino");
        locationViewIds.put(CODE_DELOITTE, "hasherino");
        locationViewIds.put(CODE_EFACEC, "hasherino");
        locationViewIds.put(CODE_NATIXIS, "hasherino");
        locationViewIds.put(CODE_WIPRO, "hasherino");
        locationViewIds.put(CODE_BIBLIOTECA, "hasherino");
        locationViewIds.put(CODE_PORTAFEUP, "hasherino");
        locationViewIds.put(CODE_NIAEFEUP, "hasherino");
        locationViewIds.put(CODE_IEEE, "hasherino");
        locationViewIds.put(CODE_CANTINA, "hasherino");
        locationViewIds.put(CODE_FALCAO, "hasherino");
        locationViewIds.put(CODE_QUEIJOS, "hasherino");
        locationViewIds.put(CODE_DEI, "hasherino");
        locationViewIds.put(CODE_CICA, "hasherino");
        locationViewIds.put(CODE_AEFEUP, "hasherino");
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
            //DialogHelper.showOkDialog(this, "Parabéns!");
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
                        "Sefores dos primeiros a colecionar todos os sítios podes ganhar brindes" +
                        "grátis do ENEI! Dica: se carregares nas imagens podes ter algumas" +
                        "pistas ;)");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
