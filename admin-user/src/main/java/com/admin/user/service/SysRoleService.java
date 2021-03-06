package com.admin.user.service;

import com.admin.core.basic.InterfaceService;
import com.admin.user.entity.SysRoleEntity;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

/**
 * 角色业务
 * @author fei
 * @date 2017/9/19
 */
public interface SysRoleService extends InterfaceService<SysRoleEntity, Long> {

  /**
   * 根据角色ID集合获取角色信息.
   * @param ids 角色ID集合
   * @return 角色集合
   */
  List<SysRoleEntity> findAllByIds(Long... ids);

  /**
   * 获取角色权限
   * @param id 角色ID
   * @return 权限集合
   */
  Set<Long> getRolePermission(@NotNull Long id);

  /**
   * 获取所有有效的角色对象
   * @return 角色集合
   */
  @NotNull
  List<SysRoleEntity> findAllValid();
}
