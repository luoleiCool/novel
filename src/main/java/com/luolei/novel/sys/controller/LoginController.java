package com.luolei.novel.sys.controller;

import com.luolei.novel.sys.annotation.Action;
import com.luolei.novel.sys.common.HttpResult;
import com.luolei.novel.sys.common.JwtUtil;
import com.luolei.novel.sys.domain.SysUser;
import com.luolei.novel.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @Action(name = "登录")
    public HttpResult login(@RequestBody Map<String,String> map) {
        String loginName = map.get("loginName");
        String passWord = map.get("passWord");
        //身份验证
        boolean isSuccess =  userService.checkSysUser(loginName,passWord);

        if (isSuccess) {
            //模拟数据库查询
            SysUser user = userService.getSysUser(loginName);
            if (user != null) {
                //返回token
                String token = JwtUtil.sign(loginName, user.getId());
                if (token != null) {
                    return HttpResult.success("成功",token);
                }
            }
        }
        return HttpResult.fail();
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @RequestMapping("/getUser")
    @Action(name = "获取用户信息")
    public HttpResult getUser(String loginName) {
        if(!StringUtils.isEmpty(loginName)){
            return HttpResult.success("", userService.getSysUser(loginName));
        }
        return HttpResult.fail();
    }

}
