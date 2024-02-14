package com.gryffindoraf.gameplus.service;

public class TwitchException extends RuntimeException {
    public TwitchException(String errorMessage) {
        super(errorMessage);
    }
}
