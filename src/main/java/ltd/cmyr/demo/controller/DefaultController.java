package ltd.cmyr.demo.controller;


import io.swagger.v3.oas.annotations.Operation;
import ltd.cmyr.demo.entity.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/")
public class DefaultController {

    @Operation(summary = "获取时间", method = "GET")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object time() {
        ResponseData data = new ResponseData(200, "OK", new Date());
        return new ResponseEntity<ResponseData>(data, HttpStatus.OK);
    }
}
