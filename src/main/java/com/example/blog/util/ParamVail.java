package com.example.blog.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class ParamVail {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean vailNumber(int num) {
        String str = String.valueOf(num);
        if (StringUtils.hasText(str)) {
            String regex = "^[0-9\u4E00-\u9FA5]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(str);
            return match.matches();
        } else {
            return false;
        }

    }


    public static boolean vailString(String str) {
        if (StringUtils.hasText(str)) {
            String regex = "^[a-zA-Z0-9\u4E00-\u9FA5]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher match = pattern.matcher(str);
            return match.matches();
        } else {
            return false;
        }

    }


    public static boolean vailString(List<String> strs) {
        boolean flag = true;
        for (String str:strs) {
            if (StringUtils.hasText(str)) {
                String regex = "^[a-zA-Z0-9\u4E00-\u9FA5]+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher match = pattern.matcher(str);
                if (!match.matches()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return flag;
    }

    public static boolean isEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

}
