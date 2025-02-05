package org.qin.com.stock.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.qin.com.stock.entity.SysUser;
import org.qin.com.stock.service.SysUserService;
import org.qin.com.stock.utils.R;
import org.qin.com.stock.vo.req.LoginReqVo;
import org.qin.com.stock.vo.resp.LoginRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户表(SysUser)表控制层
 *
 * @author makejava
 * @since 2025-01-26 23:30:11
 */
@RestController
@RequestMapping("/api")
@Tag(name = "用户认证相关接口定义", description = "用户功能-用户登录功能")
public class SysUserController {
    /**
     * 服务对象
     */
    @Autowired
    private SysUserService sysUserService;

    /**
     * 生成登录校验码的访问接口
     * @return
     */
    @GetMapping("/captcha")
    @Operation(summary = "验证码生成功能",description = "验证码生成功能")
    public R<Map> getCaptchaCode(){
        return sysUserService.getCaptchaCode();
    }

    /**
     * 用户登录功能实现
     * @param vo
     * @return
     */
    @PostMapping("/login")
    @Operation(summary = "用户登录功能",description = "用户登录")
    public R<LoginRespVo> login(@RequestBody LoginReqVo vo){
        return this.sysUserService.login(vo);
    }

    /**
     * 用户查询功能实现，根据用户名查询用户信息
     * @param name
     * @return
     */
    @GetMapping("/user/name/{name}")
    @Operation(summary = "查询用户", description = "根据用户名查询用户信息")
    @Parameter(name = "name", description = "用户名", required = true, example = "JohnDoe")
    @ApiResponse(responseCode = "200", description = "成功获取用户信息", content = @Content(schema = @Schema(implementation = SysUser.class)))
    @ApiResponse(responseCode = "404", description = "用户未找到")
    public R<SysUser> queryByName(@PathVariable String name) {
        System.out.println("test:"+name);
        return R.ok(this.sysUserService.queryByName(name));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/user/id/{id}")
    @Operation(summary = "查询用户", description = "根据ID查询用户信息")
    public R<SysUser> queryById(@PathVariable("id") Long id) {
        return R.ok(this.sysUserService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param sysUser 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @PostMapping("/users")
//    public R<Page<SysUser>> queryByPage(SysUser sysUser, PageRequest pageRequest) {
//        return R.ok(this.sysUserService.queryByPage(sysUser, pageRequest));
//    }
    @PostMapping("/users")
    @Operation(summary = "分页查询用户", description = "根据条件分页查询用户列表")
    @ApiResponse(responseCode = "200", description = "查询成功", content = @Content(schema = @Schema(implementation = Page.class)))
    public R<Page<SysUser>> queryByPage(
            @Parameter(description = "查询条件", required = true) @RequestBody SysUser sysUser,
            @Parameter(description = "分页请求", required = true) @RequestBody PageRequest pageRequest) {
        return R.ok(sysUserService.queryByPage(sysUser, pageRequest));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体
     * @return 新增结果
     */
    @PostMapping("/user/add")
    public R<SysUser> add(SysUser sysUser) {
        return R.ok(this.sysUserService.insert(sysUser));
    }

    /**
     * 编辑数据
     *
     * @param sysUser 实体
     * @return 编辑结果
     */
    @PutMapping("/user/update")
    public R<SysUser> edit(SysUser sysUser) {
        return R.ok(this.sysUserService.update(sysUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/user/delete")
    public R<Boolean> deleteById(Long id) {
        return R.ok(this.sysUserService.deleteById(id));
    }

}

