package ltd.cmyr.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import ltd.cmyr.demo.entity.User;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author caomeiyouren
 * @since 2023-10-08
 */
public interface IUserService extends IService<User> {

    /**
     * 成功返回 User ，失败返回 null
     *
     * @param id
     * @return
     */
    User getUser(Integer id);
}
