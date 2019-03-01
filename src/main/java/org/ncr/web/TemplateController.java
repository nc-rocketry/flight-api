package org.ncr.web;

import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

public class TemplateController {

    protected ThreadLocal<Map<String, Object>> data = new ThreadLocal<>();

    protected void init(String pageTitle) {
        data.set(new HashMap<>());
        setPageTitle(pageTitle);
    }

    protected void setPageTitle(String title) { set("page_title", title); }

    protected void set(String name, Object value) {
        data.get().put(name, value);
    }

    protected ModelAndView render(String view) {
        return new ModelAndView(view, data.get());
    }
}
