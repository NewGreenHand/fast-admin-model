package com.admin.auth.model;

import com.admin.core.exception.UserNotInitException;
import com.admin.auth.config.security.JwtUser;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * 获取当前用户信息
 *
 * @author fei
 * @date 2018/2/28
 */
public class CurrentUser {
  /**
   * 获取当前用户方法
   * @return 当前用户
   */
  public static JwtUser currentUser() {
    return (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }

  /**
   * 获取当前登录用户的用户名
   *
   * @return 用户名
   */
  public static Optional<String> currentUserName() {
    return Optional.of(currentUser())
      .map(JwtUser::getUsername);
  }

  /**
   * 获取当前用户ID
   * @return 用户ID
   */
  public static Long currentUserId() {
    return Optional.of(currentUser())
      .map(JwtUser::getId)
      .orElseThrow(UserNotInitException::new);
  }
}

