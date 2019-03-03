package org.ncr.thrustcurve;

import org.ncr.web.TemplateController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Controller
@RequestMapping("/thrustcurve")
public class Index extends TemplateController {

    @GetMapping(value = {"", "/"}, produces = "text/html")
    public String index(ServletRequest req, ServletResponse resp, Model model) {
        return render("thrustcurve/index", model);
    }



}
