package com.wyl.dict.gatewayimpl.database.dataobject;

import java.util.Date;
import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;
import java.io.Serializable;

/**
 * 通知公告表(SysNotice)实体类
 *
 * @author wyl
 * @since 2021-12-15 09:07:21
 */
@Data
public class SysNotice extends BaseEntity {

            /**
        * 公告ID
        */    
        private Integer noticeId;
                /**
        * 公告标题
        */    
        private String noticeTitle;
                /**
        * 公告类型（1通知 2公告）
        */    
        private String noticeType;
                /**
        * 公告内容
        */    
        private String noticeContent;
                /**
        * 公告状态（0正常 1关闭）
        */    
        private String status;
                        
}