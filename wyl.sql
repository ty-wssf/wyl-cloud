drop table if exists sys_config;
create table sys_config
(
    config_id    bigint auto_increment comment '参数主键' primary key,
    config_name  varchar(128) null comment '参数名称',
    config_key   varchar(128) null comment '参数键名',
    config_value varchar(256) null comment '参数键值',
    config_type  char              default '0' null comment '系统内置（1是 0否）',
    create_by    varchar(64)  null comment '创建者',
    create_time  datetime     null comment '创建时间',
    update_by    varchar(64)  null comment '更新者',
    update_time  datetime     null default null comment '更新时间',
    remark       varchar(512) null comment '备注'
) comment = '参数配置表';drop table if exists sys_dict_type;

create table sys_dict_type
(
    dict_id     bigint auto_increment comment '字典主键'
        primary key,
    dict_name   varchar(128)     null comment '字典名称',
    dict_type   varchar(128)     null comment '字典类型',
    status      char default '0' null comment '状态（0正常 1停用）',
    create_by   varchar(64)      null comment '创建者',
    create_time datetime         null comment '创建时间',
    update_by   varchar(64)      null comment '更新者',
    update_time datetime         null comment '更新时间',
    remark      varchar(256)     null comment '备注',
    constraint dict_type
        unique (dict_type)
) comment '字典类型表';

insert into sys_dict_type values(1,  '系统是否', 'sys_yes_no',          '0', 'admin', sysdate(), '', null, '系统是否列表');

drop table if exists sys_dict_data;
create table sys_dict_data
(
    dict_code   bigint auto_increment comment '字典编码'
        primary key,
    dict_sort   int  default 0   null comment '字典排序',
    dict_label  varchar(128)     null comment '字典标签',
    dict_value  varchar(128)     null comment '字典键值',
    dict_type   varchar(128)     null comment '字典类型',
    css_class   varchar(128)     null comment '样式属性（其他样式扩展）',
    list_class  varchar(128)     null comment '表格回显样式',
    is_default  char default '0' null comment '是否默认（1是 0否）',
    status      char default '0' null comment '状态（0正常 1停用）',
    create_by   varchar(64)      null comment '创建者',
    create_time datetime         null comment '创建时间',
    update_by   varchar(64)      null comment '更新者',
    update_time datetime         null comment '更新时间',
    remark      varchar(256)     null comment '备注'
) comment '字典数据表';

insert into sys_dict_data values(1, 1,  '是',       '1',       'sys_yes_no',          '',   'primary', 'Y', '0', 'admin', sysdate(), '', null, '系统默认是');
insert into sys_dict_data values(2, 2,  '否',       '0',       'sys_yes_no',          '',   'danger',  'N', '0', 'admin', sysdate(), '', null, '系统默认否');

