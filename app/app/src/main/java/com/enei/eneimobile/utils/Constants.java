package com.enei.eneimobile.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;

import com.enei.eneimobile.R;

import java.util.HashMap;
import java.util.Map;

public abstract class Constants {
    public static Context appContext = null;

    public static final String ENEI_WEBSITE = "https://enei.pt";
    public static final String FONT_PATH = "Montserrat-Regular.ttf";

    public static final int BACKGROUND_DARK_BLUE = Color.rgb(0, 0, 95);

    public static final Map<Integer, String> speakerDescriptions = new HashMap<>();
    static {
        speakerDescriptions.put(R.id.speaker_tanenbaum, "Most computer users nowadays are nontechnical people who have a mental model of what they expect from a computer based on their experience with TV sets and stereos: you buy it, plug it in, and it works perfectly for the next 10 years. Computers aren't like that, which leads to frustration. Part of the problem is the operating system, which is often millions of lines of kernel code, each of which can potentially bring the system down. As long as we maintain the current structure of the operating system as a huge single monolithic program full of foreign code (device drivers) and running in kernel mode, the situation will not improve. In an attempt to provide better reliability and security, we have created a new multiserver operating system, MINIX 3, with only 15,000 lines in kernel and the rest of the operating system split up into small components each running as a separate user-mode processes. It is available for the x86 and ARM for embedded systems. The talk will discuss the design of the system and some of unique aspects, such as live update--the ability to replace the operating system with a new version while it is running without affecting running applications. The MINIX 3 Website is at www.minix3.org.");
        speakerDescriptions.put(R.id.speaker_luispauloreis, "No futuro, humanos e robôs terão que trabalhar juntos em ambientes complexos, resolver problemas difíceis e realizar tarefas que exigem cooperação homem-máquina em equipa. Deste modo, são necessárias metodologias para permitir que os robôs aprendam, interajam e cooperem com os seus parceiros humanos. Esta palestra será baseada nas metodologias desenvolvidas para a criação de equipas heterogéneas multi-robô e humano-robô com ênfase nas metodologias desenvolvidas nos nossos projetos: FC Portugal e HearBo. O projeto do FC Portugal desenvolveu metodologias para a criação de equipas de futebol robótico capazes de seguir instruções de alto-nível de um treinador humano/robô usando conceitos como estratégia, táticas, formações e jogadas estudadas. O projeto também desenvolveu metodologias para aprendizagem de skills, usando simulação, tais como andar, chutar, levantar-se ou passar/receber uma bola. O projeto permitiu que os nossos grupos de investigação vencessem 4 campeonatos mundiais e 10 campeonatos europeus de futebol robótico de diferentes ligas/competições. No HearBo, juntamente com o Honda-RI Japão, desenvolvemos metodologias de aprendizagem e interação de robôs humanos para robôs humanoides capazes de reconhecer o tipo de música e dançar respeitando o seu estilo e ritmo. A conversa será ilustrada com vídeos de ambos os projetos.");
        speakerDescriptions.put(R.id.speaker_ivosilva, "No desenvolvimento de um produto existe a necessidade de ter diferentes ambientes que se destinam a finalidades distintas. De forma a agilizar este processo, a disponibilização das diferentes versões de uma aplicação pode ser automatizada, utilizando um conjunto de tecnologias de continuous delivery. Esta palestra consiste numa descrição do nosso processo no Finta (uma app mobile direcionada a fãs de futebol: http://getfinta.pt/) e das ferramentas usadas.");
        speakerDescriptions.put(R.id.speaker_andresilva, "A palestra será uma introdução a tecnologia blockchain, onde se irá descrever como funciona um sistema como Bitcoin e o que assegura a segurança do mesmo. Durante a palestra iremos começar por descrever o problema que estamos a tentar resolver (distributed ledger) e iterativamente construir uma solução que no final deverá ser semelhante a Bitcoin (não irá ser 100% semelhante para evitar descrever detalhes de implementação). Por fim irei também fazer uma pequena menção a outros sistema como o Ethereum.");
        speakerDescriptions.put(R.id.speaker_ruicosta, "With the increasing demand for the continuous connectivity on the move, the way we look at the Internet is changing. Vehicles are now becoming smarter with the increasing number of built-in sensors and high demand for the ability to move data between vehicles and the cloud. The autonomous vehicle sets the pinnacle of that transformation, by generating 4 terabytes of data per day and being a key enabler of new mobility-on-demand services that will change the way we live our lives every day. Veniam is building a V2X (vehicle-to-everything) platform that is able to move terabytes of data between vehicles (V2V) and vehicles and the cloud (V2C). Cars can now do more than carrying people and goods from point A to point B and become active nodes of the Internet, a new one, an Internet of Moving Things.");
        speakerDescriptions.put(R.id.speaker_danielteixeira, "Segurança na perspectiva do adversário, a palestra é uma introdução a algumas das técnicas tácticas e procedimentos utilizadas por adversários.\n" +
                "\n" +
                "Durante a palestra vai ser analisado um cenário de ataque real, no qual se contempla as seguintes fases de um ataque: reconhecimento, análise de vulnerabilidades, bypass de soluções de segurança, compromisso inicial e movimento lateral.\n" +
                "\n" +
                "Tem como objectivo mostrar com um adversário se movimenta numa organização e a eficácia das soluções de segurança actuais.");
        speakerDescriptions.put(R.id.speaker_wolfgang, "In his talk, Wolfgang will highlight different areas of his journey in the wonderful world of robotics and touch upon challenges and frontiers in the field. In particular, he will highlight recent research successes and open challenges along with implications of an applied field.");
        speakerDescriptions.put(R.id.speaker_espinheira, "Nesta palestra o Eduardo vai apresentar a perspectiva de um engenheiro na gestão de carreiras e recrutamento. Em particular vai indicar 3 ferramentas fundamentais a utilizar, salientando dicas e armadilhas dos desafios dos engenheiros informáticos hoje em dia.");
        speakerDescriptions.put(R.id.speaker_joaoazevedo, "Nesta apresentação, vamos introduzir o paradigma da programação funcional usando JavaScript. Tentaremos demonstrar que tratando a computação como a avaliação de funções puras, usando dados imutáveis e preferindo expressões a comandos conseguimos produzir código mais fácil de entender, mais modular e mais fácil de testar.");
        speakerDescriptions.put(R.id.speaker_josepedrosilva, "Ever heard of the 4th Industrial revolution or the Industry 4.0? It's not all about the hardware. In fact, most of the hardware is already here, what we are missing is the software that will make this vision a reality. In this talk we are going to talk about the technologies driving the industry to its 4th revolution and about what we are still missing to achieve I4.0. If you want to be prepared for the next big thing in the enterprise world, join us to find more!");
        speakerDescriptions.put(R.id.speaker_alexey, "\"A Internet foi criada como um projeto da CIA e continua a ser desenvolvida como tal\", uma citação infame (e longe de ser correta) do presidente russo, Putin, de abril de 2014, pode descrever de melhor forma a atitude do governo russo contemporâneo em relação à Net. Sendo geralmente céticas da Net, as autoridades russas nunca confiaram no meio. Mas, após os protestos pós-eleição de 2011-2012 e as revelações de Snowden, o Kremlin abriu uma nova frente contra ela, implementando um plano coordenado para exercer tanto controlo online como atualmente tem offline. Alexey Sidorenko, observador de longo prazo deste processo, compartilhará uma história ainda em andamento de The Closure - um lento processo de privação de liberdades para se comunicar e expressar online na Rússia.");
        speakerDescriptions.put(R.id.speaker_jobvandervoort, "O GitLab iniciou-se como um projeto open source. Com o passar dos ano, cresceu e tornou-se num empresa constituída por cerca de 250 pessoas. Em vez de abrir um escritório em São Francisco, o GitLab fez tudo remotamente: 0 escritórios. Além disso, todo o trabalho desenvolvido pelo GitLab é aberto. Nesta talk, Job examinará como o GitLab gere o seu crescimento como empresa, onde todos podem trabalhar com os seus pijamas e onde todo o trabalho é público.");
        speakerDescriptions.put(R.id.speaker_nelsonpinho, "A Transformação Digital não é uma buzzword, é uma inevitabilidade. Temas como IoT, blockchain, quantum computing, ou Inteligência Artificial já fazem parte dos nossos dias. Esta sessão pretende fomentar o debate acerca de como a transformação digital está a alterar paradigmas e como poderá ser aplicada a 4 pilares: A co-criação com o cliente; A capacitação do colaborador; A optimização das operações e a Transformação dos produtos.");
        speakerDescriptions.put(R.id.speaker_ruiguedes, "Exploração do tema das novas realidades (virtual, aumentada e mista), distinção entre elas, aplicabilidade no mundo real, abordagens tecnológicas e o seu enquadramento no futuro das tecnologias.");
        speakerDescriptions.put(R.id.speaker_leonelmorgado, "“Serious games” is a commonplace word now. But what can we really to achieve with them? Rather than mere fireworks or motivation gimmick, serious games are powerful mindtools, which allow us to explore and live different perspectives, face complex dynamics in concrete form: live the dynamics rather than just read about them. Augmented and virtual reality, combined with gestural interaction, gelocalization, and mobility, may further expand the possibilities of the genre, and in this talk I’ll explain what we want to achieve and how. I’ll also explain how all of this is taking place without much of a connection with current information systems, how this needs to be tackled by software engineers and what baby steps have already begun to be take in this regard.");
    }

    public static final Map<Integer, String> speakerLinks = new HashMap<>();
    static {
        speakerLinks.put(R.id.speaker_tanenbaum, ENEI_WEBSITE + "/speakers/12");
        speakerLinks.put(R.id.speaker_andresilva, ENEI_WEBSITE + "/speakers/0");
        speakerLinks.put(R.id.speaker_ruicosta, ENEI_WEBSITE + "/speakers/11");
        speakerLinks.put(R.id.speaker_wolfgang, ENEI_WEBSITE + "/speakers/14");
        speakerLinks.put(R.id.speaker_espinheira, ENEI_WEBSITE + "/speakers/13");
        speakerLinks.put(R.id.speaker_joaoazevedo, ENEI_WEBSITE + "/speakers/9");
        speakerLinks.put(R.id.speaker_josepedrosilva, ENEI_WEBSITE + "/speakers/10");
        speakerLinks.put(R.id.speaker_joaoleal, ENEI_WEBSITE + "/speakers/1");
        speakerLinks.put(R.id.speaker_ferrolho, ENEI_WEBSITE + "/speakers/3");
        speakerLinks.put(R.id.speaker_luispauloreis, ENEI_WEBSITE + "/speakers/19");
        speakerLinks.put(R.id.speaker_ivosilva, ENEI_WEBSITE + "/speakers/8");
        speakerLinks.put(R.id.speaker_ws1, ENEI_WEBSITE + "/talks/14");
        speakerLinks.put(R.id.speaker_renatorodrigues, ENEI_WEBSITE + "/talks/4");
        speakerLinks.put(R.id.speaker_andrebatista, ENEI_WEBSITE + "/talks/5");
        speakerLinks.put(R.id.speaker_danielteixeira, ENEI_WEBSITE + "/speakers/20");
        speakerLinks.put(R.id.speaker_filipecarvalho, ENEI_WEBSITE + "/talks/6");
        speakerLinks.put(R.id.speaker_networking, ENEI_WEBSITE + "/talks/0");
        speakerLinks.put(R.id.speaker_alexey, ENEI_WEBSITE + "/speakers/15");
        speakerLinks.put(R.id.speaker_jobvandervoort, ENEI_WEBSITE + "/speakers/16");
        speakerLinks.put(R.id.speaker_andrecruz, ENEI_WEBSITE + "/talks/10");
        speakerLinks.put(R.id.speaker_ws6, ENEI_WEBSITE + "/talks/11");
        speakerLinks.put(R.id.speaker_slot1, ENEI_WEBSITE + "/speakers/18");
        speakerLinks.put(R.id.speaker_nelsonpinho, ENEI_WEBSITE + "/speakers/2");
        speakerLinks.put(R.id.speaker_leonelmorgado, ENEI_WEBSITE + "/speakers/17");
        speakerLinks.put(R.id.speaker_ws9, ENEI_WEBSITE + "/talks/12");
        speakerLinks.put(R.id.speaker_mariocarneiro, ENEI_WEBSITE + "/talks/13");
        speakerLinks.put(R.id.speaker_ws4, ENEI_WEBSITE + "/talks/8");
        speakerLinks.put(R.id.speaker_paulopatricio, ENEI_WEBSITE + "/talks/7");
        speakerLinks.put(R.id.speaker_ws3, ENEI_WEBSITE + "/talks/16");
        speakerLinks.put(R.id.speaker_ws7, ENEI_WEBSITE + "/talks/17");
        speakerLinks.put(R.id.speaker_ws8, ENEI_WEBSITE + "/talks/15");
        speakerLinks.put(R.id.speaker_ws5, ENEI_WEBSITE + "/talks/19");
        speakerLinks.put(R.id.speaker_ruiguedes, ENEI_WEBSITE + "/speakers/21");
        speakerLinks.put(R.id.speaker_pedrocaramez, ENEI_WEBSITE + "/talks/18");
        speakerLinks.put(R.id.speaker_jantarcvs, ENEI_WEBSITE + "/talks/2");
        speakerLinks.put(R.id.speaker_cocktails, ENEI_WEBSITE + "/talks/1");
        //speakerLinks.put(R.id.speaker_egasbastos, ENEI_WEBSITE + "/talks/");
        //view.findViewById(R.id.speaker_debate).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws2).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws3).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_karaoke1).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws7).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_ws8).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_slot2).setOnClickListener(Constants.speakerListener);
        //view.findViewById(R.id.speaker_karaoke2).setOnClickListener(Constants.speakerListener)
    }

    public static final View.OnClickListener speakerListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(appContext == null) {
                return;
            }

            int viewID = view.getId();
            String link = null;
            if (speakerLinks.containsKey(viewID)) {
                link = speakerLinks.get(viewID);
            }

            if (speakerDescriptions.containsKey(viewID)) {
                DialogHelper.showTalkDialog(appContext, speakerDescriptions.get(viewID), link);
            } else if (link != null) {
                Intent browserIntent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                appContext.startActivity(browserIntent);
            } else {
                DialogHelper.showOkDialog(appContext, "Link indisponível.");
            }
        }
    };
}
