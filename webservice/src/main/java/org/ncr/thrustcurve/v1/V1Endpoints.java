package org.ncr.thrustcurve.v1;

import club.ncr.motors.MotorDbCache;
import org.ncr.model.MotorImpulse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thrustcurve.TCApiClient;
import org.thrustcurve.api.search.SearchCriteria;
import org.thrustcurve.api.search.SearchRequest;
import org.thrustcurve.api.search.SearchResults;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/thrustcurve/api/v1")
public class V1Endpoints implements V1Contract {


    private TCApiClient client= new TCApiClient();
    private MotorDbCache cache= new MotorDbCache("cayenne-ncrclub.xml");

    @Override
    @RequestMapping(value="/search/impulse/{impulse}", method = RequestMethod.GET, produces = "application/json")
    public Object search(@PathVariable("impulse") MotorImpulse impulse) throws IOException {
        return search(new SearchCriteria().impulseClass(impulse.toString()));
    }

    @Override
    @RequestMapping(value = "/search/diameter/{diameter}", method = RequestMethod.GET, produces = "application/json")
    public Object search(@PathVariable("diameter") int diameter) throws IOException {
        return search(new SearchCriteria().diameter(diameter));
    }

    public SearchResults search(SearchCriteria criteria) throws IOException {
        try {
            return client.search(new SearchRequest(criteria), false);
        } catch (IOException iox) {
            throw iox;
        }
    }

    @Override
    @RequestMapping(value = "/list/diameters", method = RequestMethod.GET, produces = "application/json")
    public List<Integer> diameters() { return cache.getDiameters().stream().map(d -> d.getDiameter()).collect(Collectors.toList()); }

    @Override
    @RequestMapping(value = "/list/impulses", method = RequestMethod.GET, produces = "application/json")
    public List<String> impulses() { return cache.getImpulses().stream().map(i -> i.getImpulse()).collect(Collectors.toList()); }

    @Override
    @RequestMapping(value = "/list/manufacturers", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String, Object>> manufacturers() { return cache.getManufacturers().stream().map(m -> m.asMap()).collect(Collectors.toList()); }


}
