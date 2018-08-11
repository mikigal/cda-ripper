package pl.mikigal.cda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.mikigal.cda.data.Download;
import pl.mikigal.cda.data.DownloadRepository;
import pl.mikigal.cda.data.Quality;
import pl.mikigal.cda.services.RipperService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RootController {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private final RipperService ripperService;
    private final DownloadRepository downloadRepo;

    @Autowired
    public RootController(RipperService ripperService, DownloadRepository downloadRepo) {
        this.ripperService = ripperService;
        this.downloadRepo = downloadRepo;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/video/{url:.*}")
    public String video(@PathVariable String url) {
        return "redirect:/" + url;
    }

    @GetMapping("/{url:.*}")
    public String video(Model model, HttpServletRequest request, @PathVariable String url) {

        System.out.println(url);

        if(!url.contains("cda.pl$2F")) {
            return "redirect:/?error=1";
        }

        String id = null;

        try {
            String[] ss = url.split("\\$2F");
            id = ss[ss.length - 1].split("\\$2F")[0];
        } catch (Exception e) {
            return "redirect:/?error=1";
        }

        model.addAttribute("id", id);
        model.addAttribute("p360", ripperService.rip(id, Quality.P360));
        model.addAttribute("p480", ripperService.rip(id, Quality.P480));
        model.addAttribute("p720", ripperService.rip(id, Quality.P720));
        model.addAttribute("p1080", ripperService.rip(id, Quality.P1080));

        downloadRepo.save(new Download(sdf.format(new Date()), this.fetchIp(request), id));

        return "download";
    }

    private String fetchIp(HttpServletRequest request) {
        String header = request.getHeader("X-FORWARDED-FOR");
        return header == null || "".equals(header) ? request.getRemoteAddr() : header;
    }
}
