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
import java.util.List;

import static com.enei.eneimobile.views.GameActivity.EXTRA_KEY;
import static com.enei.eneimobile.views.GameActivity.Location;

public class PeddyPaperActivity extends AppCompatActivity {
    private static final String APP_URL_PREFIX = "enei://";

    public static final List<Location> newLocations = new ArrayList<>();

    static {
        newLocations.add(new Location("aliados", "1", R.id.aliados, "Avenida dos Aliados", "O que podes encontrar neste local:\n1. Edifício da Câmara do Porto\n2. Onde o porto festeja o campeonato\n3. Um dos McDonald’s mais bonitos do mundo."));
        newLocations.add(new Location("saobento", "2", R.id.sbento, "Estação de São Bento", "Inaugurada há mais de 100 anos, esta é uma das principais estações de comboios do Porto e considerada uma das mais bonitas do Mundo!"));
        newLocations.add(new Location("ribeira", "3", R.id.ribeira, "Ribeira", "1. Ponte emblemática, projetada por Gustave Eiffel.\n2. O Barco Rabelo faz parte da sua paisagem.\n3. Parte da Muralha Fernandina."));
        newLocations.add(new Location("palaciobolsa", "4", R.id.palaciobolsa, "Palácio da Bolsa", "1. Salão Árabe\n2. Escadaria Nobre\n3. Pátio das Nações"));
        newLocations.add(new Location("ruaflores", "5", R.id.ruaflores, "Rua das Flores", "O que podes encontrar neste sítio:1. Flores nas varandas.\n2. Casa dos Maias.\n3. Onde está o alfarrabista da cidade do Porto.\n"));
        newLocations.add(new Location("clerigos", "6", R.id.clerigos, "Torre dos Clérigos", "1. Torre mais alta do Porto.\n2. Antigo Convento\n3. Igreja com teto oval, feito pelo Nasoni."));
        newLocations.add(new Location("passeiovirtudes", "7", R.id.passeiovirtudes, "Passeio das Virtudes", "1. Melhor spot para um final de tarde perfeito.\n2. Vista para a Ponte da Arrábida.\n3. Vista para os jardins do Palácio de Cristal."));
        newLocations.add(new Location("igrejacarmo", "8", R.id.igrejacarmo, "Igreja do Carmo", "1. Estilo arquitetónico: barroco\n2. Azulejos que contam história\n3. Construída juntamente com a Igreja das Carmelitas como se fosse uma só."));
        newLocations.add(new Location("reitoria", "9", R.id.reitoria, "Reitoria da Universidade do Porto", "1. Edifício protegido pelos Leões.\n2. Atual Museu da História Natural da UP\n3. Antiga Faculdade de Ciências da UP"));
        newLocations.add(new Location("piolho", "10", R.id.piolho, "Piolho", "1. Abertura em 1909, com o nome Café D’Ouro.\n2. Café preferido dos estudantes\n3. Diz-se que o seu nome, pelo qual é vulgarmente conhecido, surgiu quando pessoas mais velhas comentavam o ambiente do café como “uma piolhice”."));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peddy_paper);

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
                    DialogHelper.showOkDialog(this, "Já tinhas descoberto o lugar \"" + selectedLocation.name + "\". Procura novos códigos nos locais do Peddy Paper!");
                } else {
                    DialogHelper.showOkDialog(this, "Parabéns! Descobriste o local \"" + selectedLocation.name + "\". Não desistas de procurar os outros códigos!");
                    prefs.edit().putBoolean(selectedLocation.hash, true).apply();
                }
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

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(PeddyPaperActivity.this);
                if(loc != null) {
                    if(prefs.getBoolean(loc.hash, false)) {
                        DialogHelper.showOkDialog(PeddyPaperActivity.this, "Local: " + loc.name + '\n' + loc.hint);
                    } else {
                        DialogHelper.showOkDialog(PeddyPaperActivity.this, loc.hint);
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
                DialogHelper.showOkDialog(this, "Lê os QR codes do ENEI nos " +
                        "diversos locais do Peddy Paper para te habilitares a ganhar o prémio! " +
                        "Dica: carrega nas diversas imagens para veres pistas sobre os respetivos locais ;)");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
