package com.luolei.novel.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.luolei.novel.sys.domain.SysUser;

public interface UserService extends IService<SysUser> {
    /**
     * 校验用户信息
     * @param loginName
     * @param passWord
     * @return
     */
    boolean checkSysUser(String loginName, String passWord);

    /**
     * 查询用户信息
     * @param loginName
     * @return
     */
    SysUser getSysUser(String loginName);
}
