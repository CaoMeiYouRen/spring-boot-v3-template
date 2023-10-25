package ltd.cmyr.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import ltd.cmyr.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author caomeiyouren
 * @since 2023-10-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
