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
        newLocations.add(new Location("sonaeim", "", R.id.sonaeim, "SONAE IM", "Patrocinador principal do ENEI. É uma unidade de um dos maiores grupos nacionais de empresas focada no investimento, através de fusões e aquisições, em empresas tecnológicas nas áreas de telecomunicações e retalho."));
        newLocations.add(new Location("deloitte", "", R.id.deloitte, "Deloitte", "Conta com aproximadamente 264,000 profissionais em firmas membro que prestam serviços nas áreas de audit & assurance, consulting, financial advisory, risk advisory, tax e serviços relacionados, em mais de 150 países e territórios."));
        newLocations.add(new Location("efacec", "", R.id.efacec, "Efafec", "É a maior empresa industrial portuguesa do setor elétrico e eletromecânico, desenvolvendo produtos, soluções e sistemas de elevada tecnologia que fazem parte do dia-a-dia de milhões de pessoas."));
        newLocations.add(new Location("natixis", "", R.id.natixis, "Natixis", "Segmento bancário para empresas e investimentos, gestão de ativos, seguros e serviços financeiros do Grupo BPCE, o segundo maior grupo bancário em França."));
        newLocations.add(new Location("wipro", "", R.id.wipro, "Wipro", "Empresa líder mundial em tecnologia da informação, consultoria e em serviços de processos de negócios."));
        newLocations.add(new Location("biblioteca", "", R.id.biblioteca, "Biblioteca", "O principal local de estudo para os estudantes da FEUP. É um edifício de 6 andares com vista para o parque de estacionamento dos estudantes."));
        newLocations.add(new Location("portafeup", "", R.id.entrada, "Entrada FEUP", "Principal entrada da FEUP, onde se localiza a secretaria e outros serviços académicos."));
        newLocations.add(new Location("niaefeup", "", R.id.niaefeup, "NIAEFEUP", "Núcleo de Informática da AEFEUP. Nesta sala os estudantes realizam trabalhos ou participam em projetos do núcleo. Muitas das reuniões de preparação do ENEI realizaram-se aqui!"));
        newLocations.add(new Location("ieee", "", R.id.ieee, "IEEE UP Student Branch", "Ramo da Universidade do Porto do núcleo IEEE. Este núcleo realiza muitas atividades e workshops na FEUP e foi um ponto importante na organização do ENEI!"));
        newLocations.add(new Location("cantina", "", R.id.cantina, "Cantina de Engenharia", "Cantina que serve principalmente a FEUP e, recentemente, a FEP (Faculdade de Economia). Se já estiveste em refeições do ENEI, provavelmente já estiveste aqui ;)"));
        newLocations.add(new Location("falcao", "", R.id.falcao, "Pavilhào Luís Falcão", "Pavilhão desportivo ao serviço da Universidade do Porto onde se realizam treinos das mais diversas modalidades bem como jogos dos campeonatos universitários."));
        newLocations.add(new Location("queijos", "", R.id.queijos, "Queijos", "Embora seja o local onde se encontram os principais auditórios para aulas teóricas, é mais conhecido pela forma que tem quando visto de cima. É um ponto de encontro frequente para os estudantes da FEUP bem como local de ensaio para as diversas tunas da Faculdade."));
        newLocations.add(new Location("dei", "", R.id.dei, "DEI", "Este é o departamento responsável pelos cursos de informática da FEUP. Na entrada podes encontrar um exemplar de um dos primeiros computadores Apple!"));
        newLocations.add(new Location("cica", "", R.id.cica, "CICA", "Centro de Informática da FEUP, responsável pela maior parte das infraestruturas informáticas da FEUP como o site, sistemas de partilha de ficheiros ou sistema de controlo de acessos."));
        newLocations.add(new Location("aefeup", "", R.id.aefeup, "AEFEUP", "Principal local de convívio para os estudantes da FEUP e faculdades vizinhas. Aqui podes encontrar um espaço relaxado e é onde se realizam muitas festas da FEUP. Sim, a festarola do ENEI é aqui ;)"));
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
