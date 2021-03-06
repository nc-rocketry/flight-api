package org.ncr.thrustcurve.v2;

import club.ncr.cayenne.Motor;
import club.ncr.dto.MotorDTO;
import club.ncr.dto.MotorManufacturerDTO;
import club.ncr.etl.TCMotorLoad;
import club.ncr.motors.MotorDbCache;
import org.ncr.dto.motor.ImpulseDTO;
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
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/thrustcurve/api/v2")
public class V2Endpoints implements V2Contract {

    @Autowired
    private TCApiClient client;

    @Autowired
    private MotorDbCache motorCache;

    @PostConstruct
    private void init() {
    }

    @Override
    @RequestMapping(value="/search/impulse/{impulse}", method = RequestMethod.GET, produces = "application/json")
    public List<MotorDTO> search(@PathVariable("impulse") ImpulseDTO impulse) throws IOException {
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
    public List<Float> diameters() { return motorCache.getDiameters().stream().map(d -> d.getDiameter()).collect(Collectors.toList()); }

    @Override
    @RequestMapping(value = "/list/impulses", method = RequestMethod.GET, produces = "application/json")
    public List<String> impulses() { return motorCache.getImpulses().stream().map(i -> i.getImpulse()).collect(Collectors.toList()); }

    @Override
    @RequestMapping(value = "/list/manufacturers", method = RequestMethod.GET, produces = "application/json")
    public List<MotorManufacturerDTO> manufacturers() { return motorCache.getManufacturers().stream().map(m -> new MotorManufacturerDTO(m)).collect(Collectors.toList()); }

    @Override
    @RequestMapping(value = "/get/motor/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<MotorDTO> getMotorData(@PathVariable String id) throws IOException {
        final Motor motor= motorCache.getMotor(id);
        return Arrays.asList(new MotorDTO(motor));
    }

    @RequestMapping(value = "/cache/index/manufacturer")
    public List<Object> motorCacheIndexByManufacturer() {
        return motorCache.getManufacturers().stream()
                .map(mfg -> mfg.getMotors().stream()
                        .map(motor -> new MotorDTO(motor))
                        .sorted()
                )
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/cache/index/impulse")
    public List<Object> motorCacheIndexByImpulse() {
        return motorCache.getImpulses().stream()
                .map(impulse -> impulse.getMotors().stream()
                        .map(motor -> new MotorDTO(motor))
                        .sorted()
                )
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/cache/update/{impulse}")
    public String updateCache(@PathVariable ImpulseDTO impulse) {
        new TCMotorLoad(motorCache.getImpulse(impulse.toString())).execute();
        return "OK";
    }

}
