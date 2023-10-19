package miu.edu.PresentationService.controller;

import jakarta.servlet.http.HttpServletResponse;
import miu.edu.PresentationService.domain.Data;
import miu.edu.PresentationService.domain.OntarioEnergy;
import miu.edu.PresentationService.service.IOntarioEnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;

@RestController
@RequestMapping("api/ontario-energy")
public class OntarioEnergyController {

    @Autowired
    private IOntarioEnergyService service;

    @GetMapping("")
    public ResponseEntity<?> findAll () {
        Data data = new Data(service.findTop2());
        return new ResponseEntity<Data>(data, HttpStatus.OK);
    }

    @GetMapping("/export")
    public void exportToCSV (HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String fileName = "ontario-energy.csv";
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;
        response.setHeader(headerKey, headerValue);

        Data data = new Data(service.findAll());
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] csvHeader = {"Date & Time", "Time Of Reading", "Power Generated",
                "Ontario Demand", "Total Co2e", "Co2e Intensity", "Nuclear Percentage",
                "Nuclear Output", "Hydro Percentage", "Hydro Output", "Gas Percentage",
                "Gas Output", "Wind Percentage", "Wind Output", "Biofuel Percentage",
                "Biofuel Output", "Solar Percentage", "Solar Output", "Imports", "Exports", "Net Import Exports"};
        String[] nameMapping = {"date", "timeOfReading", "powerGenerated",
                "ontarioDemand", "totalCo2e", "co2eIntensity",
                "nuclearPercentage", "nuclearOutput", "hydroPercentage",
                "hydroOutput", "gasPercentage", "gasOutput",
                "windPercentage", "windOutput", "biofuelPercentage",
                "biofuelOutput", "solarPercentage", "solarOutput",
                "imports", "exports", "netImportExports"};

        csvWriter.writeHeader(csvHeader);
        for (OntarioEnergy d: data.getData()) {
            csvWriter.write(d, nameMapping);
        }
        csvWriter.close();
    }
}
