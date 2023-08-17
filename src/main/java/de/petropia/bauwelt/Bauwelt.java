package de.petropia.bauwelt;

import de.petropia.bauwelt.plot.Plot;
import de.petropia.bauwelt.status.BuildworldStatusRequest;
import de.petropia.turtleServer.api.PetropiaPlugin;
import eu.cloudnetservice.driver.event.EventManager;
import eu.cloudnetservice.driver.inject.InjectionLayer;

import java.util.ArrayList;
import java.util.List;

public class Bauwelt extends PetropiaPlugin {

    private static Bauwelt instance;
    private static final List<Plot> plots = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;
        registerListener();
    }

    private void registerListener(){
        InjectionLayer.ext().instance(EventManager.class).registerListener(new BuildworldStatusRequest());
    }

    public static Bauwelt getInstance(){
        return instance;
    }

    public static List<Plot> getPlots(){
        return plots;
    }
}
