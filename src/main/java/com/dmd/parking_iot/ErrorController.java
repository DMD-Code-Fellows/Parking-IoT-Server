package com.dmd.parking_iot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Spring controller for runtime errors.
 */
@Controller
public class ErrorController {

    /**
     * Error route.
     * @return The template name for rendering an html error page.
     */
    @GetMapping("/error")
    public String index() {
        return "error";
    }
}
