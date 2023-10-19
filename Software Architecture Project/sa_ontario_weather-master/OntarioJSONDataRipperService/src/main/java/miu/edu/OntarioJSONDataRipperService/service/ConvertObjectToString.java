package miu.edu.OntarioJSONDataRipperService.service;

import com.google.gson.Gson;
import miu.edu.OntarioJSONDataRipperService.domain.OntarioEnergy;

public class ConvertObjectToString {
    public static String convertFromOntarioWeatherToString (OntarioEnergy ontarioWeather) {
        Gson gson = new Gson();
        return gson.toJson(ontarioWeather);
    }
}
