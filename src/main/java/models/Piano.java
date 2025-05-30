package models;

import interfaces.Playable;

public class Piano implements Playable {
    @Override
    public String play() {
        return "Піаніно грає мелодію";
    }
}
