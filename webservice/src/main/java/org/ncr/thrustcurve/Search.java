package org.ncr.thrustcurve;

import club.ncr.cayenne.MotorImpulse;
import club.ncr.motors.MotorDbCache;
import org.ncr.web.TemplateController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thrustcurve.TCApiClient;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Controller
@RequestMapping("/thrustcurve")
public class Search extends TemplateController {

    @Autowired
    private MotorDbCache motorCache;

    @GetMapping(value = "/search", produces = "text/html")
    public String index(ServletRequest req, ServletResponse resp, Model model) {
        init();

        set("impulses", motorCache.getImpulses());
        set("diameters", motorCache.getDiameters());
        set("manufacturers", motorCache.getManufacturers());

        model.addAttribute("impulses", motorCache.getImpulses());
        model.addAttribute("diameters", motorCache.getImpulses());
        model.addAttribute("manufacturers", motorCache.getImpulses());

        return render("thrustcurve/search", model);
    }



}
