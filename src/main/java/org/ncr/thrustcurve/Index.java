package org.ncr.thrustcurve;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/thrustcurve")
public class Index {

    @GetMapping(value = "/", produces = "text/html")
    public String index(ServletRequest req, ServletResponse resp) {
        Map<String, ?> data = new HashMap<>();
        return "thrustcurve/index";
    }
}
