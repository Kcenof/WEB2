package services;

import interfaces.Playable;

public class InstrumentService {
    public String perform(Playable instrument) {
        return instrument.play();
    }
}
