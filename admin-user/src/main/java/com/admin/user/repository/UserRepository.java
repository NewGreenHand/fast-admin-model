package com.admin.user.repository;

import com.admin.core.basice.BaseRepository;
import com.admin.user.entity.SysUser;

/**
 *
 * @author fei
 * @date 2017/9/19
 */
public interface UserRepository extends BaseRepository<SysUser, Long> {

  /**
   * 获取一个用户
   *
   * @param userName 用户名
   * @return 用户对象
   */
  SysUser findByUserName(String userName);

  /**
   * 根据微信ID获取用户 信息
   * @param openId 微信ID
   * @return 用户对象
   */
  SysUser findByOpenId(String openId);

  /**
   * 检查用户名是否存在
   * @param userName 用户名
   * @return true: 已存在, false: 不存在
   */
  boolean existsByUserName(String userName);
}
