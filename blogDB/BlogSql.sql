/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/8/2 9:54:42                             */
/*==============================================================*/


drop table if exists sys_log;

drop table if exists sys_menu;

drop table if exists sys_role;

drop table if exists sys_role_menu;

drop table if exists sys_user;

drop table if exists sys_user_role;

drop table if exists y_article;

drop table if exists y_article_comment;

drop table if exists y_article_label;

drop table if exists y_article_statistics;

drop table if exists y_category;

drop table if exists y_comment;

drop table if exists y_image;

drop table if exists y_label;

drop table if exists y_suggest;

/*==============================================================*/
/* Table: sys_log                                               */
/*==============================================================*/
create table sys_log
(
   log_id               int(11) not null auto_increment comment '日志ID',
   request_name         varchar(50) comment '请求名字',
   request_method       varchar(20) comment '请求方式',
   request_url          varchar(100) comment '请求URL',
   request_ip           varchar(50) comment '请求的IP',
   result_type          char(1) comment '返回结果',
   result_content       varchar(100) comment '结果内容',
   time_consuming       int(11) comment '消耗时间(秒s)',
   operating_time       datetime comment '操作时间',
   operating_user       int(11) comment '操作人',
   primary key (log_id)
)
charset = UTF8;

alter table sys_log comment '操作日志表';

/*==============================================================*/
/* Table: sys_menu                                              */
/*==============================================================*/
create table sys_menu
(
   menu_code            varchar(100) not null comment '菜单code',
   parent_code          varchar(100) comment '父菜单code',
   menu_name            varchar(36) not null comment '菜单名字',
   button_code          varchar(16) comment '按钮标识',
   menu_url             varchar(500) not null comment '菜单URL',
   menu_icon            varchar(36) comment '菜单图标',
   menu_sort            int(11) not null comment '菜单排序',
   menu_type            varchar(10) not null comment '菜单类别 ( MENU:菜单  BUTTON:按钮 )',
   perms                varchar(100) not null comment 'shiro权限标识',
   status               char(1) not null comment '菜单状态（ 0:禁止  1:启用 ）',
   create_time          datetime comment '创建时间',
   create_user          int(11) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          int(11) comment '修改人',
   primary key (menu_code)
)
charset = UTF8;

alter table sys_menu comment '菜单表';

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   role_id              int(11) not null auto_increment comment '角色id',
   role_code            varchar(16) not null comment '角色code',
   role_name            varchar(16) not null comment '角色名称',
   role_type            char(1) not null comment '角色类型（ 0:超级管理员  1:普通管理员  2:普通用户 ）',
   role_status          char(1) comment '角色状态（ 0:禁止  1:启用 ）',
   create_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          int(11) comment '修改人',
   update_time          datetime comment '修改时间',
   primary key (role_id)
)
charset = UTF8;

alter table sys_role comment '角色表';

/*==============================================================*/
/* Table: sys_role_menu                                         */
/*==============================================================*/
create table sys_role_menu
(
   role_menu_id         int(11) not null auto_increment comment '角色菜单表ID',
   role_id              int(11) comment '角色ID',
   menu_code            varchar(100) comment '菜单code',
   cteate_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   primary key (role_menu_id)
)
charset = UTF8;

alter table sys_role_menu comment '角色菜单中间表';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   user_id              int(11) not null auto_increment comment '用户id',
   user_code            varchar(10) not null comment '用户编号',
   login_name           varchar(20) not null comment '登录账号',
   login_password       varchar(36) not null comment '登录密码',
   user_name            varchar(16) not null comment '用户名字',
   user_phone           varchar(11) not null comment '用户手机',
   user_qq              varchar(20) comment '用户QQ',
   user_head_url        varchar(200) comment '用户头像',
   user_sex             char(1) comment '用户性别（ 0:男  1:女  2:保密 ）',
   user_signature       varchar(200) comment '用户个性签名',
   status               char(1) comment '用户状态（ 0:禁止  1:启用 ）',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '修改时间',
   update_user          int(11) comment '修改人',
   primary key (user_id)
)
charset = UTF8;

alter table sys_user comment '用户表';

/*==============================================================*/
/* Table: sys_user_role                                         */
/*==============================================================*/
create table sys_user_role
(
   user_role_id         int(11) not null auto_increment comment '用户角色表ID',
   user_id              int(11) not null comment '用户ID',
   role_id              int(11) not null comment '角色ID',
   create_time          datetime comment '创建时间',
   primary key (user_role_id)
)
charset = UTF8;

alter table sys_user_role comment '用户角色中间表';

/*==============================================================*/
/* Table: y_article                                             */
/*==============================================================*/
create table y_article
(
   article_id           int(11) not null auto_increment comment '文章ID',
   article_code         varchar(16) not null comment '文章code',
   article_title        varchar(50) not null comment '文章标题',
   article_cover_url    varchar(100) comment '文章封面URL',
   article_description  varchar(100) not null comment '文章描述',
   article_content      text comment '文章内容',
   category_id          int(11) not null comment '分类ID',
   recommend            char(1) not null comment '推荐文章',
   recommend_sort       int(11) comment '推荐排序',
   publish_status       char(1) not null comment '发布状态（ 0:未发布  1:已发布  9:禁止发布 ）',
   create_user          int(11) not null comment '创建人（作者）',
   create_time          datetime comment '创建时间',
   update_user          int(11) comment '修改人',
   update_time          datetime comment '修改时间',
   primary key (article_id)
)
charset = UTF8;

alter table y_article comment '文章表';

/*==============================================================*/
/* Table: y_article_comment                                     */
/*==============================================================*/
create table y_article_comment
(
   article_comment_id   int(11) not null auto_increment comment '文章评论ID',
   article_id           int(11) not null comment '文章ID',
   comment_id           int(11) not null comment '评论ID',
   create_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   primary key (article_comment_id)
)
charset = UTF8;

alter table y_article_comment comment '文章评论表';

/*==============================================================*/
/* Table: y_article_label                                       */
/*==============================================================*/
create table y_article_label
(
   article_label_id     int(11) not null auto_increment comment '文章标签ID',
   article_id           int(11) comment '文章ID',
   label_id             int(11) comment '标签ID',
   create_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   primary key (article_label_id)
)
charset = UTF8;

alter table y_article_label comment '文章标签中间表';

/*==============================================================*/
/* Table: y_article_statistics                                  */
/*==============================================================*/
create table y_article_statistics
(
   article_statistics_id int(11) not null auto_increment comment '文章统计ID',
   article_id           int(11) not null comment '文章ID',
   like_quantity        int(11) not null comment '点赞数量',
   read_quantity        int(11) not null comment '阅读数量',
   comment_quantity     int(11) not null comment '评论数量',
   create_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          int(11) comment '修改人',
   update_time          datetime comment '修改时间',
   primary key (article_statistics_id)
)
charset = UTF8;

alter table y_article_statistics comment '文章统计表';

/*==============================================================*/
/* Table: y_category                                            */
/*==============================================================*/
create table y_category
(
   category_id          int(11) not null auto_increment comment '分类ID',
   parent_id            int(11) comment '父分类ID',
   category_name        varchar(50) comment '分类名称',
   category_sort        int(11) comment '分类排序',
   category_status      char(1) not null comment '分类状态（ 0:禁止  1:启用 ）',
   create_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          int(11) comment '修改人',
   update_time          datetime comment '修改时间',
   primary key (category_id)
)
charset = UTF8;

alter table y_category comment '文章分类表';

/*==============================================================*/
/* Table: y_comment                                             */
/*==============================================================*/
create table y_comment
(
   comment_id           int not null auto_increment comment '评论ID',
   parent_id            int(11) comment '父评论ID',
   comment_content      varchar(500) not null comment '评论内容',
   comment_ip           varchar(100) not null comment '评论时IP',
   comment_status       char(1) not null comment '评论状态（ 0:禁止  1:启用 ）',
   belong_user          int(11) not null comment '被评论人',
   create_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          int(11) comment '修改人',
   update_time          datetime comment '修改时间',
   primary key (comment_id)
)
charset = UTF8;

alter table y_comment comment '评论表';

/*==============================================================*/
/* Table: y_image                                               */
/*==============================================================*/
create table y_image
(
   image_id             int(11) not null comment '图片ID',
   image_name           varchar(50) not null comment '图片名称',
   image_url            varchar(100) not null comment '图片URL',
   image_description    varchar(200) comment '图片描述',
   upload_time          datetime comment '上传时间',
   upload_ip            varchar(100) comment '上传IP',
   upload_user          int(11) not null comment '上传人',
   primary key (image_id)
)
charset = UTF8;

alter table y_image comment '图片表';

/*==============================================================*/
/* Table: y_label                                               */
/*==============================================================*/
create table y_label
(
   label_id             int(11) not null auto_increment comment '标签ID',
   label_code           varchar(16) not null comment '标签code',
   label_name           varchar(16) not null comment '标签名字',
   lable_status         char(1) comment '标签状态（ 0:禁止  1:启用 ）',
   create_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   update_user          int(11) comment '修改人',
   udpate_time          datetime comment '修改时间',
   primary key (label_id)
)
charset = UTF8;

alter table y_label comment '标签表';

/*==============================================================*/
/* Table: y_suggest                                             */
/*==============================================================*/
create table y_suggest
(
   suggest_id           int(11) not null auto_increment comment '意见ID',
   suggest_content      text not null comment '意见内容',
   user_ip              varchar(50) comment 'ip地址',
   suggest_status       char(1) comment '意见状态（ 0:废弃  1:不予理会  3:有兴趣纳入目标  4:采纳正在做  6:已经完成 ）',
   display_status       char(1) comment '显示状态（ 0:禁止  1:启用 ）',
   create_user          int(11) comment '创建人',
   create_time          datetime comment '创建时间',
   primary key (suggest_id)
)
charset = UTF8;

alter table y_suggest comment '吐槽意见表';

