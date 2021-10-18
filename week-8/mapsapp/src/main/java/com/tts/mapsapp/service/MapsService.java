package com.tts.mapsapp.service;

import com.tts.mapsapp.model.Location;

public interface MapsService {

    void addCoordinates(Location location);
    void setRandomCoordinates(Location location);

}
