package com.example.blog.service.serviceImpl;

import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.CommonService;
import com.example.blog.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;
@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    private JavaMailSender sender;

    @Resource
    RedisUtils redisUtils;

    @Resource
    UserMapper userMapper;

    @Value("${spring.mail.username}")
    String mail;

    @Override
    public void sendVerifyCode(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("[xx网站] 您的验证码");
        Random random = new Random();
        int code = random.nextInt(899999) + 100000;
        redisUtils.set("verify:code:" + email, code + "", 3, TimeUnit.MINUTES);
        message.setText("您的验证码为：" + code + ",三分钟内有效，请及时完成注册!如果不是本人操作,请忽略");
        message.setTo(email);
        message.setFrom(mail);
        sender.send(message);
    }

    @Override
    public boolean doVerify(String email, String code) {
        String string = (String) redisUtils.get("verify:code:" + mail);
        if (string == null) {
            return false;
        }
        return string.equals(code);
    }

    @Override
    public void addUser(User user) {
        redisUtils.set("user"+user.getId(),user);
        userMapper.insert(user);
    }

    @Override
    public boolean isUserExist(String name) {
        User user = userMapper.selectByName(name);
        if (user != null) {
            redisUtils.set("user"+user.getId(),user);
            return true;
        }
        return false;
    }







}
