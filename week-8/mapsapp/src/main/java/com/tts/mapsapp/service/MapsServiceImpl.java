package com.tts.mapsapp.service;

import com.tts.mapsapp.model.GeocodingResponse;
import com.tts.mapsapp.model.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class MapsServiceImpl implements MapsService {

    @Value("${api_key}")
    private String apiKey;

    @Override
    public void addCoordinates(Location location) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                location.getCity() + "," + location.getState() + "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();

        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
    }

    @Override
    public void setRandomCoordinates(Location location) {
        // generate random floats
//        Random random = new Random();
        float lat = (float) (-90.00 + Math.random() * (90.00 + 90.00));
        float lng = (float) (-180.00 + Math.random() * (180.00 + 180.00));
        // update location
        location.setLat(Float.toString(lat));
        location.setLng(Float.toString(lng));
    }
}
