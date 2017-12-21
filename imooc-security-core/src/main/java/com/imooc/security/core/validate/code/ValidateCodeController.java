package com.imooc.security.core.validate.code;

import com.imooc.security.core.properties.SecurityProperties;
import com.imooc.security.core.validate.code.image.ImageCode;
import com.imooc.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author shudp
 * @create 2017/12/17.
 */
@RestController
public class ValidateCodeController {

    public static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;
    @Autowired
    private ValidateCodeGenerator smsCodeGenerator;
    @Autowired
    private SmsCodeSender smsCodeSender;
    @Autowired
    private Map<String,ValidateCodeProcessor> validateCodeProcessors;

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/{type}")
    private void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {

       validateCodeProcessors.get(type + "CodeProcessor").create(new ServletWebRequest(request,response));

    }





}
