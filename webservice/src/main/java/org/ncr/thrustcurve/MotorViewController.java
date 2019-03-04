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
public class MotorViewController extends TemplateController {

    @Autowired
    private MotorDbCache motorCache;

    @Override
    protected void init() {
        super.init();
        set("impulses", motorCache.getImpulses());
        set("diameters", motorCache.getDiameters());
        set("manufacturers", motorCache.getManufacturers());
    }

    @GetMapping(value = "/motor/{externalId}", produces = "text/html")
    public String byImpulse(@PathVariable String externalId, Model model) {
        init();

        MotorDTO motor = new MotorDTO(motorCache.getMotor(externalId));

        set("motor", motor);
        set("selected_impulse", motor.impulse);
        set("selected_diameter", motor.diameter);

        return render("thrustcurve/motor_results", model);
    }

    // TODO: make download(data)


}
