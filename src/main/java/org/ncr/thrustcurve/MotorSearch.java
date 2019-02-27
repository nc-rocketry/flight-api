package org.ncr.thrustcurve;

import club.ncr.cayenne.Motor;
import club.ncr.motors.MotorDbCache;
import org.ncr.model.MotorImpulse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thrustcurve.TCApiClient;
import org.thrustcurve.api.search.SearchCriteria;
import org.thrustcurve.api.search.SearchRequest;

import java.io.IOException;

@RestController
@RequestMapping("/tc/")
public class MotorSearch {


    private TCApiClient client= new TCApiClient();
    private MotorDbCache cache= new MotorDbCache("cayenne-ncrclub.xml");

    @RequestMapping("search")
    public Object search(@RequestParam("impulse") MotorImpulse impulse) throws IOException {

        SearchCriteria criteria = new SearchCriteria();
        criteria.impulseClass(impulse.toString());

        try {
            return client.search(new SearchRequest(criteria), false);
        } catch (IOException iox) {
            throw iox;
        }

    }

    @RequestMapping("list/diameters")
    public Object diameters() { return cache.getDiameters(); }

    @RequestMapping("list/impulses")
    public Object impulses() { return cache.getImpulses(); }

    @RequestMapping("list/manufacturers")
    public Object manufacturers() { return cache.getManufacturers(); }


}
