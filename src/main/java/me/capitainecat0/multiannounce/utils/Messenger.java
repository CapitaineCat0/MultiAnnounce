package me.capitainecat0.multiannounce.utils;

import me.capitainecat0.multiannounce.MultiAnnounce;

public enum Messenger {

    CMD_NO_PERM(MultiAnnounce.colored("&cVous n'avez pas la permission d'utiliser la commande &e/%cmd% reload&c!")),
    RELOAD_SUCCES(MultiAnnounce.colored("&c&lMulti&a&lAnnounce &arechargé!"));


    private final String msg;
    public String getMessage() {
        return msg;
    }
    Messenger(String msg) {
        this.msg = msg;
    }
}
