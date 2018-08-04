package pl.mikigal.cda.services;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.PluginConfiguration;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.stereotype.Service;
import pl.mikigal.cda.data.Quality;

@Service
public class RipperService {

    private static final String CDA_URL = "https://www.cda.pl/video/";
    private final WebClient webClient;

    public RipperService() {
        PluginConfiguration flash = new PluginConfiguration("Shockwave Flash", "Shockwave Flash 11.4 r402", "11.4 r402", "NPSWF32_11_4_402_287.dll");
        flash.getMimeTypes().add(new PluginConfiguration.MimeType("application/x-shockwave-flash", "Adobe Flash movie", "swf"));

        BrowserVersion bv = BrowserVersion.CHROME;
        bv.getPlugins().add(flash);

        webClient = new WebClient(bv);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.waitForBackgroundJavaScript(5000);
        webClient.waitForBackgroundJavaScriptStartingBefore(5000);
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
    }

    public String rip(String id, Quality quality) {
        try {
            HtmlPage page = webClient.getPage(CDA_URL + id + "?wersja=" + quality.getName());
            String url = getPlayerObject(page, id).getLastElementChild().getAttribute("value").split("file=")[1].split("&")[0].replace("%3A", ":").replace("%2F", "/");
            return url;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private DomElement getPlayerObject(HtmlPage page, String id) {
        DomElement base = page.getElementById("mediaplayer" + id);
        return base == null ? page.getElementById("mediaplayer" + id.substring(0, id.length() - 2)) : base;
    }
}
