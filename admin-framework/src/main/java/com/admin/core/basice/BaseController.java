package com.admin.core.basice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 基本 控制器
 * @author fei
 * @date 2018/10/25
 */
@Slf4j
@Validated
public abstract class BaseController<T, ID extends Serializable> {

  private BaseService<T, ID> service;

  public BaseController(BaseService<T, ID> service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  public T findOne(@NotNull @PathVariable ID id) {
    return service.findByPk(id);
  }

}
