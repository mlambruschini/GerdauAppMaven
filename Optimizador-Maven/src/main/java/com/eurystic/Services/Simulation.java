package com.eurystic.Services;

import com.anylogic.engine.Engine;
import eurystic.gerdaumallas.simulador.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static com.anylogic.engine.TimeUnits.MINUTE;

public class Simulation {

    public static Resultados resultados;

    private final Maestros maestros = Maestros.getInstance();

    private final CustomSimulation customSimulation = new CustomSimulation(null);

    public void runSimulador(){

        Engine engine = getNewEngine();

        final Main root = new Main( engine, null, null );
        root.setParametersToDefaultValues();
        root.modoSoloSoldadoras = true;

        maestros.maestroMaquinas.forEach(maestroMaq -> {
            List<Programa> copiaPrograma = new ArrayList<>();

            maestroMaq.programaPrefijado.forEach(prog ->
                    copiaPrograma.add(prog.copiarPrograma())
            );

            root.programaFijoSoldadoras.put(maestroMaq, copiaPrograma);
        });

        engine.start( root );
        engine.runFast();

        root.procesarResultados();

        Resultados resultadosPreliminares = root.resultados;

        resultadosPreliminares.programaPorMaquina.forEach((maq, prog) -> {
            if (maq.tipo != MaestroMaquina.Tipo.SOLDADORA) {
                System.out.println("Error, no se exporto el simulador con modoSoloSoldadoras default");
                System.exit(1);
            }
        });

        engine = getNewEngine();

        Main root2 = new Main( engine, null, null );
        root2.setParametersToDefaultValues();
        root2.modoSoloSoldadoras = false;
        root2.programaFijoSoldadoras = (LinkedHashMap<MaestroMaquina, List<Programa>>) resultadosPreliminares.programaPorMaquina;

        engine.start( root2 );
        engine.runFast();

        root2.procesarResultados();

        resultados = root2.resultados;


        engine.stop();
    }

    private Engine getNewEngine() {
        Engine engine = customSimulation.createEngine();
        engine.setTimeUnit( MINUTE );
        engine.getDefaultRandomGenerator().setSeed( 1 );
        engine.setSimultaneousEventsSelectionMode( Engine.EVENT_SELECTION_LIFO );

        engine.setStartTime( 0.0 );
        engine.setStartDate(maestros.fechaInicio);
        engine.setStopDate(maestros.fechaFin);

        return engine;
    }

}
