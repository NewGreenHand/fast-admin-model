package com.admin.user.entity;

import com.admin.core.basic.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 系统角色映射类.
 *
 * @author fei
 * @date 2017/10/3
 */
@Entity
@Table(name = "sys_role", schema = "fastAdmin")
public class SysRoleEntity extends AbstractEntity implements Serializable {
  private static final long serialVersionUID = 2230732982891238618L;
  /** 角色名. */
  private String name;
  /** 描述. */
  private String description;
  /** 状态 */
  private Boolean enabled;
  /** 菜单ID集合. */
  private Set<Long> menuIds;
  /** 权限 ID 集合 */
  private Set<Long> interfaceIds;

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Basic
  @Column(name = "enabled")
  public Boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  @JsonIgnore
  @ElementCollection
  @CollectionTable(
      name = "sys_role_menu",
      joinColumns = {@JoinColumn(name = "role_id")})
  @Column(name = "menu_id")
  public Set<Long> getMenuIds() {
    return menuIds;
  }

  public void setMenuIds(Set<Long> menuIds) {
    this.menuIds = menuIds;
  }

  @JsonIgnore
  @ElementCollection
  @CollectionTable(
      name = "sys_role_interface",
      joinColumns = {@JoinColumn(name = "rid")})
  @Column(name = "pid")
  public Set<Long> getInterfaceIds() {
    return interfaceIds;
  }

  public void setInterfaceIds(Set<Long> interfaceIds) {
    this.interfaceIds = interfaceIds;
  }
}
