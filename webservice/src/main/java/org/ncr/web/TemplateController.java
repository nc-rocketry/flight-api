package org.ncr.web;

import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

public class TemplateController {

    protected ThreadLocal<Map<String, Object>> data = new ThreadLocal<>();

    protected void init() {
        data.set(new HashMap<>());
    }

    /**
     * Set a parameter value that will be passed to the view.
     * @param name
     * @param value
     */
    protected void set(String name, Object value) {
        if (data.get() == null) { init(); }
        data.get().put(name, value);
    }

    protected String render(String view, Model model) {
        model.addAllAttributes(data.get());
        return view;
    }
}
