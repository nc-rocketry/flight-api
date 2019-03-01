package org.ncr.thrustcurve;

import org.ncr.web.TemplateController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Controller
@RequestMapping("/thrustcurve")
public class Search extends TemplateController {

    @GetMapping(value = "/search", produces = "text/html")
    public ModelAndView index(ServletRequest req, ServletResponse resp) {
        init("Search");
        return render("thrustcurve/index");
    }



}
