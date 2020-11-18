package com.luolei.novel.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luolei.novel.sys.domain.SysUser;
import com.luolei.novel.sys.mapper.SysUserMapper;
import com.luolei.novel.sys.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements UserService {
    

    @Override
    public boolean checkSysUser(String loginName, String passWord) {

        return true;
    }

    @Override
    public SysUser getSysUser(String loginName) {
        return this.query().eq("name", loginName).one();
    }
}
