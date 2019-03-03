package org.ncr.thrustcurve;

import club.ncr.dto.MotorDTO;
import club.ncr.motors.MotorDbCache;
import org.ncr.dto.motor.ImpulseDTO;
import org.ncr.web.TemplateController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/thrustcurve")
public class Search extends TemplateController {

    @Autowired
    private MotorDbCache motorCache;

    @Override
    protected void init() {
        super.init();
        set("impulses", motorCache.getImpulses());
        set("diameters", motorCache.getDiameters());
        set("manufacturers", motorCache.getManufacturers());
    }

    @GetMapping(value = "/search", produces = "text/html")
    public String index(ServletRequest req, ServletResponse resp, Model model) {
        return render("thrustcurve/search", model);
    }


    @GetMapping(value = "/impulse/{impulse}", produces = "text/html")
    public String byImpulse(@PathVariable ImpulseDTO impulse, Model model) {
        init();

        List<MotorDTO> motors = motorCache.getImpulse(impulse.toString()).getMotors().stream()
                .map(motor -> new MotorDTO(motor))
                .collect(Collectors.toList());

        set("motors", motors);
        set("selected_impulse", impulse.toString());

        return render("thrustcurve/impulse", model);
    }

}
