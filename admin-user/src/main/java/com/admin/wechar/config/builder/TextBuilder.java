package com.admin.wechar.config.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * 文字消息构造器
 *
 * @author fei
 * @date 2018/10/11
 */
public class TextBuilder extends AbstractBuilder {
  @Override
  public WxMpXmlOutMessage build(String content, WxMpXmlMessage wxMessage, WxMpService service) {
    return WxMpXmlOutMessage.TEXT()
        .content(content)
        .fromUser(wxMessage.getToUser())
        .toUser(wxMessage.getFromUser())
        .build();
  }
}
