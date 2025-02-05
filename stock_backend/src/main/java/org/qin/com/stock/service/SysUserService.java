package org.qin.com.stock.service;

import org.qin.com.stock.entity.SysUser;
import org.qin.com.stock.utils.R;
import org.qin.com.stock.vo.req.LoginReqVo;
import org.qin.com.stock.vo.resp.LoginRespVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Map;

/**
 * 用户表(SysUser)表服务接口
 *
 * @author makejava
 * @since 2025-01-26 23:30:11
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Long id);

    /**
     * 分页查询
     *
     * @param sysUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SysUser> queryByPage(SysUser sysUser, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    SysUser queryByName(String name);

    R<LoginRespVo> login(LoginReqVo vo);

    /**
     * 登录校验码生成服务方法
     * @return
     */
    R<Map> getCaptchaCode();
}
