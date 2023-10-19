package miu.edu.PresentationService.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ConvertStringToObject {
    public static OntarioEnergyDTO covertFromJsonToOntario (String jsonString) {
        return new Gson().fromJson(jsonString, OntarioEnergyDTO.class);
    }
}
