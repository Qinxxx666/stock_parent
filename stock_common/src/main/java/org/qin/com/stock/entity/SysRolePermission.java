package org.qin.com.stock.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色权限表(SysRolePermission)实体类
 *
 * @author makejava
 * @since 2025-01-26 23:26:21
 */
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = -68679156750590298L;
/**
     * 主键
     */
    private Long id;
/**
     * 角色id
     */
    private Long roleId;
/**
     * 菜单权限id
     */
    private Long permissionId;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

