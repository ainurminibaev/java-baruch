package foo.bar.day03.tp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    ObjectMapper mapper;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String pathVar(HttpServletRequest request, ModelMap modelMap) {
        Map<String, Object> map = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            map.put(key, request.getHeader(key));
        }
        modelMap.put("headers", map);
        return "hello";
    }


    /**
     *
     * @param id
     * @param headers
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/index/{id}", method = RequestMethod.GET)
    public String pathVar(@PathVariable String id, @RequestHeader Map<String, String> headers, ModelMap modelMap) {
        //put to model some data
        modelMap.put("var", id);
        //list
        modelMap.addAttribute(headers);
        return "hello";
    }

    @RequestMapping(value = "/string", method = RequestMethod.GET, headers = {}, produces = "text/plain;charset=UTF-8")
    public String string(@RequestBody String body) {
        return body;
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, headers = {"content-type=application/json"}, produces = "application/json; charset=utf-8")
    public
    @ResponseBody
    String json(@RequestBody String body) {
        try {
            return mapper.readValue(body, String.class);
        } catch (IOException e) {
            e.printStackTrace();
            return "null value";
        }
    }

}