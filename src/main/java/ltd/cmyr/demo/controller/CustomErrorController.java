package ltd.cmyr.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ltd.cmyr.demo.entity.ResponseData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.webmvc.autoconfigure.error.BasicErrorController;
import org.springframework.boot.webmvc.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("${spring.web.error.path:${error.path:/error}}")
public class CustomErrorController extends BasicErrorController {

    @Value("${spring.web.error.path:${error.path:/error}}")
    private String path;

    public CustomErrorController(WebProperties webProperties) {
        super(new DefaultErrorAttributes(), webProperties.getError());
    }

    /**
     * 覆盖默认的JSON响应
     */
    @Override
    public ResponseEntity error(HttpServletRequest request) {
        String method = request.getMethod();
        String path = request.getRequestURI();
        ResponseData data = new ResponseData(404, String.format("Cannot %s %s", method, path));
        return ResponseEntity.status(404).body(data);
    }

    /**
     * 覆盖默认的HTML响应
     */
    @Override
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        //请求的状态
        HttpStatus status = getStatus(request);
        response.setStatus(status.value());
        Map<String, Object> model = getErrorAttributes(request,
                getErrorAttributeOptions(request, MediaType.TEXT_HTML));
        ModelAndView modelAndView = resolveErrorView(request, response, status, model);
        //指定自定义的视图
        return (modelAndView == null ? new ModelAndView("error", model) : modelAndView);
    }
}