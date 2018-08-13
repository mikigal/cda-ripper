package pl.mikigal.cda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.mikigal.cda.entity.DownloadEntity;
import pl.mikigal.cda.properties.Properties;
import pl.mikigal.cda.repository.DownloadRepository;
import pl.mikigal.cda.service.RipperService;
import pl.mikigal.cda.type.QualityType;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RootController {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    private final Properties properties;
    private final RipperService ripperService;
    private final DownloadRepository downloadRepo;

    public RootController(Properties properties, RipperService ripperService, DownloadRepository downloadRepo) {
        this.properties = properties;
        this.ripperService = ripperService;
        this.downloadRepo = downloadRepo;
    }

    @GetMapping("/")
    public String root(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("/{url:.*}")
    public String video(Model model, HttpServletRequest request, @PathVariable String url) {

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

        DownloadEntity last = downloadRepo.findFirstByIpOrderByDateDesc(fetchIp(request));

        try {
            if(last != null && sdf.parse(last.getDate()).getTime() + (properties.getDelayTime() * 1000) > new Date().getTime()) {
                return "redirect:/?error=2";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/?error=-1";
        }

        downloadRepo.save(new DownloadEntity(sdf.format(new Date()), this.fetchIp(request), id));

        model.addAttribute("id", id);
        model.addAttribute("p360", ripperService.rip(id, QualityType.P360));
        model.addAttribute("p480", ripperService.rip(id, QualityType.P480));
        model.addAttribute("p720", ripperService.rip(id, QualityType.P720));
        model.addAttribute("p1080", ripperService.rip(id, QualityType.P1080));

        return "download";
    }

    private String fetchIp(HttpServletRequest request) {
        String header = request.getHeader("X-FORWARDED-FOR");
        return header == null || "".equals(header) ? request.getRemoteAddr() : header;
    }
}
