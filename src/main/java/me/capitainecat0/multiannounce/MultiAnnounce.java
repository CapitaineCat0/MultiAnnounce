package me.capitainecat0.multiannounce;

import me.capitainecat0.multiannounce.utils.PluginCore;
import me.capitainecat0.multiannounce.utils.Timer;

public final class MultiAnnounce extends PluginCore<MultiAnnounce> {
    private static MultiAnnounce instance;

    @Override
    protected boolean start(MultiAnnounce instance) {
        MultiAnnounce.instance = this;
        new Timer(this).runTaskTimer(this, 0, this.getConfig().getInt("interval-in-second")* 20L);
        this.registerCommand(new ReloadCMD(), "multiannounce");
        return true;
    }

    @Override
    protected void stop() {

    }

    public static MultiAnnounce getInstance(){return instance;}
}
