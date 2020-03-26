package com.sunshine.web;

import com.sunshine.domain.data.User;
import com.sunshine.domain.enumeration.StatusEnum;
import com.sunshine.domain.vo.ResponseObject;
import com.sunshine.service.UserService;
import com.sunshine.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理用户信息的相关操作
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册功能：同名判断
     *
     * @param user
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/register")
    public ResponseObject register(User user, HttpServletRequest request, HttpServletResponse res_obj) {
        System.out.println("显示注册信息为：" + user);
        // 同名判断
        User data = userService.getUserByNameOrEmail(user);
        try {
            if (data != null) {
                return ResponseUtil.error(StatusEnum.FAILURE.getCode(), "该邮箱已经注册，请登录");
        }
            userService.saveUser(user);
            //request.getRequestDispatcher("html/register.html").forward(request, res_obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.error(StatusEnum.FAILURE.getCode(), "注册失败");
        }
        return ResponseUtil.success(StatusEnum.SUCCESS.getCode(), "注册成功");
    }

    /**
     * 登录功能：表单回显 + 登录失败（账号错误？+ 密码错误？）
     *
     * @param user
     * @param request
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/login")
    public ResponseObject login(User user, HttpServletRequest request, HttpServletResponse res_Obj) {
        // 获取前台输入的密码
        System.out.println("显示登录信息为：" + user);
        String req_pwd = user.getPassword();

        try {
            User data = userService.getUserByNameOrEmail(user);
            if (data == null) {
                return ResponseUtil.error(StatusEnum.FAILURE.getCode(), "用户名/邮箱不存在，请注册");
            }
            if (!req_pwd.equals(data.getPassword())) {
                return ResponseUtil.error(StatusEnum.FAILURE.getCode(), "密码错误！请重新输入");
            }
            //request.getRequestDispatcher("html/login.html").forward(request, res_Obj);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.error(StatusEnum.FAILURE.getCode(), "登录失败");
        }
        return ResponseUtil.success(StatusEnum.SUCCESS.getCode(), "登录成功");
    }
}
