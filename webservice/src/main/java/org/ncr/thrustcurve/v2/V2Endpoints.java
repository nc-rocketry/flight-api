package org.ncr.thrustcurve.v2;

import club.ncr.cayenne.Motor;
import club.ncr.dto.MotorDTO;
import club.ncr.dto.MotorDataDTO;
import club.ncr.dto.MotorManufacturerDTO;
import club.ncr.etl.TCMotorLoad;
import club.ncr.motors.MotorDbCache;
import org.ncr.dto.motor.MotorSummary;
import org.ncr.model.MotorImpulse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thrustcurve.TCApiClient;
import org.thrustcurve.api.search.SearchCriteria;
import org.thrustcurve.api.search.SearchRequest;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/thrustcurve/api/v2")
public class V2Endpoints implements V2Contract {

    private TCApiClient client= new TCApiClient();

    @Autowired
    private MotorDbCache cache= new MotorDbCache("cayenne-ncrclub.xml");

    @PostConstruct
    private void init() {
    }

    @Override
    @RequestMapping(value="/search/impulse/{impulse}", method = RequestMethod.GET, produces = "application/json")
    public List<MotorDTO> search(@PathVariable("impulse") MotorImpulse impulse) throws IOException {
        return search(new SearchCriteria().impulseClass(impulse.toString()), false);
    }

    @Override
    @RequestMapping(value = "/search/diameter/{diameter}", method = RequestMethod.GET, produces = "application/json")
    public List<MotorDTO> search(@PathVariable("diameter") float diameter) throws IOException {
        return search(new SearchCriteria().diameter(diameter), false);
    }

    private List<MotorDTO> search(SearchCriteria criteria, boolean withData) throws IOException {
        try {
            return client.search(new SearchRequest(criteria), withData)
                    .getRecords()
                    .stream()
                    .map(m -> new MotorDTO(m))
                    .collect(Collectors.toList());
        } catch (IOException iox) {
            throw iox;
        }
    }

    @Override
    @RequestMapping(value = "/list/diameters", method = RequestMethod.GET, produces = "application/json")
    public List<Float> diameters() { return cache.getDiameters().stream().map(d -> d.getDiameter()).collect(Collectors.toList()); }

    @Override
    @RequestMapping(value = "/list/impulses", method = RequestMethod.GET, produces = "application/json")
    public List<String> impulses() { return cache.getImpulses().stream().map(i -> i.getImpulse()).collect(Collectors.toList()); }

    @Override
    @RequestMapping(value = "/list/manufacturers", method = RequestMethod.GET, produces = "application/json")
    public List<MotorManufacturerDTO> manufacturers() { return cache.getManufacturers().stream().map(m -> new MotorManufacturerDTO(m)).collect(Collectors.toList()); }

    @Override
    @RequestMapping(value = "/get/motor/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<MotorDataDTO> getMotorData(@PathVariable String id) throws IOException {
        final Motor motor= cache.getMotor(id);
        if (motor.getData().size() == 0) {
            return Arrays.asList(new MotorDataDTO(motor, null));
        }
        return motor.getData().stream().map(data -> new MotorDataDTO(motor, data))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/cache/index/by/manufacturer")
    public List<Object> cacheIndexByManufacturer() {
        return cache.getManufacturers().stream()
                .map(mfg -> mfg.getMotors().stream()
                        .map(motor -> new MotorSummary(motor))
                        .sorted()
                )
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/cache/index/by/impulse")
    public List<Object> cacheIndexByImpulse() {
        return cache.getImpulses().stream()
                .map(impulse -> impulse.getMotors().stream()
                        .map(motor -> new MotorSummary(motor))
                        .sorted()
                )
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/cache/update/{impulse}")
    public String updateCache(@PathVariable MotorImpulse impulse) {
        new TCMotorLoad(cache.getImpulse(impulse.toString())).execute();
        return "OK";
    }

}
