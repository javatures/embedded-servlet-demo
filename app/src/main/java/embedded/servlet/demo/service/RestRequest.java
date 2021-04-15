package embedded.servlet.demo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;

public class RestRequest {
    private Pattern regExAllPattern = Pattern.compile("/person");
    private Pattern regExIdPattern = Pattern.compile("/person/([0-9]*)");

    private int id;

    public RestRequest(String path) throws ServletException {
        Matcher matcher = regExIdPattern.matcher(path);
        if (matcher.find()) {
            id = Integer.parseInt(matcher.group(1));
            return;
        }

        matcher = regExAllPattern.matcher(path);
        if (matcher.find()) return;

        throw new ServletException("Invalid URI");
    }

    public int getId() {
        return id;
    }
}
