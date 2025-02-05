package org.qin.com.stock.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户角色表(SysUserRole)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -22205398300065630L;
/**
     * 主键
     */
    private Long id;
/**
     * 用户id
     */
    private Long userId;
/**
     * 角色id
     */
    private Long roleId;
/**
     * 创建时间
     */
    private Date createTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

