package ltd.cmyr.demo.controller;


import ltd.cmyr.demo.entity.ResponseData;
import ltd.cmyr.demo.entity.User;
import ltd.cmyr.demo.exception.HTTPException;
import ltd.cmyr.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author caomeiyouren
 * @since 2023-10-08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //    @ApiOperation(value = "获取用户", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseData<User>> getUser(@PathVariable Integer id) throws HTTPException {
        User user = userService.getUser(id);
        if (user == null) {
            throw new HTTPException(404, "未寻找到该用户");
        }
        ResponseData<User> data = new ResponseData<User>();
        data.setStatusCode(200).setMessage("OK").setData(user);
        return ResponseEntity.ok(data);
    }
}
