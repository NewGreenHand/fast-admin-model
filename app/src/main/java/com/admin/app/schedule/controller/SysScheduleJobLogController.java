package com.admin.app.schedule.controller;

import com.admin.app.schedule.entity.SysScheduleJobLogEntity;
import com.admin.app.schedule.service.SysScheduleJobLogService;
import com.admin.app.schedule.dto.SysScheduleJobLogDto;
import org.springframework.web.bind.annotation.*;
import com.admin.core.basic.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 定时任务日志(SysScheduleJobLog)表控制层
 *
 * @author fei
 * @since 2019-12-20 16:16:36
 */
@Slf4j
@Validated
@RestController
@RequestMapping("sysScheduleJobLog")
public class SysScheduleJobLogController extends AbstractController<SysScheduleJobLogEntity, Long> {
  /** 服务对象 */
  private final SysScheduleJobLogService sysScheduleJobLogService;

  public SysScheduleJobLogController(SysScheduleJobLogService sysScheduleJobLogService) {
    super(sysScheduleJobLogService);
    this.sysScheduleJobLogService = sysScheduleJobLogService;
  }

  /**
   * 保存一条记录
   * @param dto 表单数据
   */
  @PostMapping
  public void save(@RequestBody @Valid SysScheduleJobLogDto dto) {
    this.sysScheduleJobLogService.save(dto.convert(SysScheduleJobLogEntity.class));
  }

  /**
   * 根据 ID 更新一条记录
   * @param id ID
   * @param dto 表单数据
   */
  @PutMapping("{id}")
  public void updateById(@PathVariable @NotNull Long id, @RequestBody @Valid SysScheduleJobLogDto dto) {
    SysScheduleJobLogEntity sysScheduleJobLogEntity = sysScheduleJobLogService.findById(id);

    sysScheduleJobLogService.update(dto.pathProperties(sysScheduleJobLogEntity));
  }

  /**
   * 根据ID删除一条数据
   * @param id ID
   */
  @DeleteMapping("{id}")
  public void delete(@PathVariable @NotNull Long id) {
    sysScheduleJobLogService.delete(id);
  }
}
