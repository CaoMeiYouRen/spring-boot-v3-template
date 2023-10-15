package ltd.cmyr.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ltd.cmyr.demo.entity.User;
import ltd.cmyr.demo.mapper.UserMapper;
import ltd.cmyr.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author caomeiyouren
 * @since 2023-10-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Integer id) {
        return userMapper.selectById(id);
    }
}
