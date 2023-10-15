package ltd.cmyr.demo.handler;


import jakarta.servlet.http.HttpServletRequest;
import ltd.cmyr.demo.entity.ResponseData;
import ltd.cmyr.demo.exception.HTTPException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 404处理
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exceptionHandler(HttpServletRequest request, Exception e) {
        ResponseData data = new ResponseData();
        if (e instanceof HTTPException) {
            data.setStatusCode(((HTTPException) e).statusCode);
            data.setMessage(e.getMessage());
            return ResponseEntity.status(((HTTPException) e).statusCode).body(data);
        }
        if (e instanceof NullPointerException) {
            data.setStatusCode(400);
            data.setMessage(e.getMessage());
            return ResponseEntity.status(400).body(data);
        }
        if (e instanceof NoHandlerFoundException) {
            String method = request.getMethod();
            String path = request.getRequestURI();
            data.setStatusCode(404);
            data.setMessage("Cannot " + method + " " + path);
            return ResponseEntity.status(404).body(data);
        }
        e.printStackTrace();
        data.setStatusCode(500);
        data.setMessage("非常抱歉，服务器出现内部异常");
        return ResponseEntity.status(500).body(data);
    }

}