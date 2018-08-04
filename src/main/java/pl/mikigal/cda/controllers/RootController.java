package pl.mikigal.cda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.mikigal.cda.data.Quality;
import pl.mikigal.cda.services.RipperService;

@Controller
public class RootController {

    private final RipperService ripperService;

    @Autowired
    public RootController(RipperService ripperService) {
        this.ripperService = ripperService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/{id}")
    public String video(Model model, @PathVariable String id) {
        model.addAttribute("id", id);
        model.addAttribute("p360", ripperService.rip(id, Quality.P360));
        model.addAttribute("p480", ripperService.rip(id, Quality.P480));
        model.addAttribute("p720", ripperService.rip(id, Quality.P720));
        model.addAttribute("p1080", ripperService.rip(id, Quality.P1080));
        return "index";
    }
}
