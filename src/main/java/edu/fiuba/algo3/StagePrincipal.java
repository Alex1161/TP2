package edu.fiuba.algo3;

import javafx.stage.Stage;

public class StagePrincipal extends Stage {

    private static StagePrincipal instance = new StagePrincipal();

    private StagePrincipal(){
        super();
    }

    public static StagePrincipal getInstance(){
        return instance;
    }
}
