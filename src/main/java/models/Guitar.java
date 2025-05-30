package models;

import interfaces.Playable;

public class Guitar implements Playable {
    @Override
    public String play() {
        return "Гітара грає акорди";
    }
}
