package miu.edu.OntarioJSONDataRipperService.service;

import com.google.gson.Gson;
import miu.edu.OntarioJSONDataRipperService.domain.OntarioEnergy;

public class ConvertStringToObject {
    public static OntarioEnergy covertFromJsonToOntario (String jsonString) {
        return new Gson().fromJson(jsonString, OntarioEnergy.class);
    }
}
