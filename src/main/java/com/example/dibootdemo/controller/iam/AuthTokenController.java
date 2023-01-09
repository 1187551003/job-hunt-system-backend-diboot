package com.example.dibootdemo.controller.iam;

import com.diboot.core.cache.BaseCacheManager;
import com.diboot.core.controller.BaseController;
import com.diboot.core.vo.JsonResult;
import com.diboot.core.vo.LabelValue;
import com.diboot.iam.annotation.BindPermission;
import com.diboot.iam.annotation.Log;
import com.diboot.iam.auth.AuthServiceFactory;
import com.diboot.iam.config.Cons;
import com.diboot.iam.dto.PwdCredential;
import com.diboot.iam.entity.BaseLoginUser;
import com.diboot.iam.service.IamUserRoleService;
import com.diboot.iam.util.IamSecurityUtils;
import com.diboot.iam.util.TokenUtils;
import com.diboot.iam.vo.IamRoleVO;
import com.pig4cloud.captcha.ArithmeticCaptcha;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * IAM身份认证/申请Token接口
 *
 * @author 刘长卿
 * @version 1.0
 * @date 2023-01-07
 * Copyright © 刘长卿
 */
@RestController
@Slf4j
@BindPermission(name = "登录认证", code = "AUTH")
public class AuthTokenController extends BaseController {
    @Autowired
    private IamUserRoleService iamUserRoleService;

    @Autowired
    private BaseCacheManager baseCacheManager;

    /**
     * 获取验证码
     */
    @GetMapping("/auth/captcha")
    public void captcha(@RequestParam("traceId") String traceId, HttpServletResponse response) throws Exception {
        response.setContentType("image/gif");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // 算数验证码
        ArithmeticCaptcha captcha = new ArithmeticCaptcha();
        // 验证码存入缓存
        baseCacheManager.putCacheObj(Cons.CACHE_CAPTCHA, traceId, captcha.text());
        // 输出图片流
        captcha.out(response.getOutputStream());
    }

    /**
     * 用户登录获取token
     *
     * @param credential
     * @return
     */
    @PostMapping("/auth/login")
    public JsonResult login(@RequestBody PwdCredential credential) {
        // 获取缓存中的验证码
        String traceId = credential.getTraceId();
        String verCode = credential.getCaptcha();
        String captcha = baseCacheManager.getCacheString(Cons.CACHE_CAPTCHA, traceId);
        baseCacheManager.removeCacheObj(Cons.CACHE_CAPTCHA, traceId);
        // 判断验证码
        if (verCode == null || !verCode.trim().toLowerCase().equals(captcha)) {
            return JsonResult.FAIL_VALIDATION("验证码错误或已失效");
        }

        String Token = AuthServiceFactory.getAuthService(Cons.DICTCODE_AUTH_TYPE.PWD.name()).applyToken(credential);
        BaseLoginUser currentUser = IamSecurityUtils.getCurrentUser();
        LabelValue TokenAndName = new LabelValue(Token, currentUser.getDisplayName());
        return JsonResult.OK(TokenAndName);
    }

    /**
     * 注销/退出
     *
     * @return
     */
    @Log(businessObj = "LoginUser", operation = "退出")
    @PostMapping("/logout")
    public JsonResult logout() {
        String accessToken = TokenUtils.getRequestToken(request);
        IamSecurityUtils.logoutByToken(accessToken);
        return JsonResult.OK();
    }

    /**
     * 获取用户角色权限信息
     *
     * @return
     */
    @GetMapping("/iam/userInfo")
    public JsonResult getUserInfo() {
        Map<String, Object> data = new HashMap<>();
        // 获取当前登录用户对象
        BaseLoginUser currentUser = IamSecurityUtils.getCurrentUser();
        if (currentUser == null) {
            return JsonResult.OK();
        }
        data.put("name", currentUser.getDisplayName());
        // 角色权限数据
        IamRoleVO roleVO = iamUserRoleService.buildRoleVo4FrontEnd(currentUser);
        data.put("role", roleVO);
        return JsonResult.OK(data);
    }

    @GetMapping("/iam/userName")
    public JsonResult getUserName() {
        BaseLoginUser currentUser = IamSecurityUtils.getCurrentUser();
        return JsonResult.OK(currentUser.getDisplayName());
    }

    /***
     * 心跳接口，用于判断是否Token快过期
     * @return
     */
    @PostMapping("/iam/ping")
    public JsonResult ping() {
        // 能进到这里说明Token是有效的
        String requestToken = TokenUtils.getRequestToken(request);
        String cachedUserInfoStr = TokenUtils.getCachedUserInfoStr(requestToken);
        if (TokenUtils.isCloseToExpired(cachedUserInfoStr)) {
            // iam会自动更换Token
            return JsonResult.OK().msg("Token已刷新");
        }
        return JsonResult.OK().msg("Token处于有效期");
    }
}