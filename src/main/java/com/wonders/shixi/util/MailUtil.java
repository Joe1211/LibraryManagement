package com.wonders.shixi.util;
/*
    @author 韩佳奇
    @date 2018/12/27
*/


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
        public static void sendEmail(String bookname,int time,String emailaddress){
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号587
        props.put("mail.smtp.port", "587");
        // 账号
        props.put("mail.user", "312613431@qq.com");
        // STMP口令
        props.put("mail.password", "qewvnyziizdabicf");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        try {
            InternetAddress form = new InternetAddress(
                    props.getProperty("mail.user"));
            message.setFrom(form);

            // 设置收件人的邮箱
            InternetAddress to = new InternetAddress(emailaddress);
            message.setRecipient(MimeMessage.RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject("Wonders图书馆还书提示");

            // 设置邮件的内容体
            message.setContent("您所借阅的"+"《"+bookname+"》"+"还剩"+time+"天的借读时间,请您注意及时还书", "text/html;charset=UTF-8");
//            message.setContent("猜猜我是谁！", "text/html;charset=UTF-8");

            // 最后当然就是发送邮件啦
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    public static void sendEmailOut(String bookname,int time,String emailaddress){
        // 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号587
        props.put("mail.smtp.port", "587");
        // 账号
        props.put("mail.user", "312613431@qq.com");
        // STMP口令
        props.put("mail.password", "qewvnyziizdabicf");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        try {
            InternetAddress form = new InternetAddress(
                    props.getProperty("mail.user"));
            message.setFrom(form);

            // 设置收件人的邮箱
            InternetAddress to = new InternetAddress(emailaddress);
            message.setRecipient(MimeMessage.RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject("Wonders图书馆还书提示");

            // 设置邮件的内容体
            message.setContent("您所借阅的"+"《"+bookname+"》"+"以超出免费借阅时间"+time+"天,应缴纳"+time*0.5+"元人民币，请及时归还，若超出两个月不归还图书将被拉入黑名单！", "text/html;charset=UTF-8");
            // 最后当然就是发送邮件啦
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

//    public void sendimmediatelymail(String bookname,String emailaddress){
//        // 创建Properties 类用于记录邮箱的一些属性
//        Properties props = new Properties();
//        // 表示SMTP发送邮件，必须进行身份验证
//        props.put("mail.smtp.auth", "true");
//        //此处填写SMTP服务器
//        props.put("mail.smtp.host", "smtp.qq.com");
//        //端口号587
//        props.put("mail.smtp.port", "587");
//        // 账号
//        props.put("mail.user", "312613431@qq.com");
//        // STMP口令
//        props.put("mail.password", "qewvnyziizdabicf");
//
//        // 构建授权信息，用于进行SMTP进行身份验证
//        Authenticator authenticator = new Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//                // 用户名、密码
//                String userName = props.getProperty("mail.user");
//                String password = props.getProperty("mail.password");
//                return new PasswordAuthentication(userName, password);
//            }
//        };
//        // 使用环境属性和授权信息，创建邮件会话
//        Session mailSession = Session.getInstance(props, authenticator);
//        // 创建邮件消息
//        MimeMessage message = new MimeMessage(mailSession);
//        // 设置发件人
//        try {
//            InternetAddress form = new InternetAddress(
//                    props.getProperty("mail.user"));
//            message.setFrom(form);
//
//            // 设置收件人的邮箱
//            InternetAddress to = new InternetAddress("1652744678@qq.com");
//            message.setRecipient(MimeMessage.RecipientType.TO, to);
//
//            // 设置邮件标题
//            message.setSubject("Wonders图书馆还书提示");
//
//            // 设置邮件的内容体
////            message.setContent("您所借阅的"+bookname+"已经到了归还时间,请您注意及时还书", "text/html;charset=UTF-8");
//            message.setContent("已经到了归还时间,请您注意及时还书", "text/html;charset=UTF-8");
//
//            // 最后当然就是发送邮件啦
//            Transport.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void sendaftermail(String bookname,int time,String emailaddress){
//        // 创建Properties 类用于记录邮箱的一些属性
//        Properties props = new Properties();
//        // 表示SMTP发送邮件，必须进行身份验证
//        props.put("mail.smtp.auth", "true");
//        //此处填写SMTP服务器
//        props.put("mail.smtp.host", "smtp.qq.com");
//        //端口号587
//        props.put("mail.smtp.port", "587");
//        // 账号
//        props.put("mail.user", "312613431@qq.com");
//        // STMP口令
//        props.put("mail.password", "qewvnyziizdabicf");
//
//        // 构建授权信息，用于进行SMTP进行身份验证
//        Authenticator authenticator = new Authenticator() {
//
//            protected PasswordAuthentication getPasswordAuthentication() {
//                // 用户名、密码
//                String userName = props.getProperty("mail.user");
//                String password = props.getProperty("mail.password");
//                return new PasswordAuthentication(userName, password);
//            }
//        };
//        // 使用环境属性和授权信息，创建邮件会话
//        Session mailSession = Session.getInstance(props, authenticator);
//        // 创建邮件消息
//        MimeMessage message = new MimeMessage(mailSession);
//        // 设置发件人
//        try {
//            InternetAddress form = new InternetAddress(
//                    props.getProperty("mail.user"));
//            message.setFrom(form);
//
//            // 设置收件人的邮箱
//            InternetAddress to = new InternetAddress(emailaddress);
//            message.setRecipient(MimeMessage.RecipientType.TO, to);
//
//            // 设置邮件标题
//            message.setSubject("Wonders图书馆还书提示");
//
//            // 设置邮件的内容体
//            message.setContent("您所借阅的"+bookname+"已经逾期"+time+"天,逾期之后将会对您处以罚金,请您尽快归还图书", "text/html;charset=UTF-8");
//
//            // 最后当然就是发送邮件啦
//            Transport.send(message);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
//    }
}
