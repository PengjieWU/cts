package cn.pj.cts.util;


import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 20:49 2019/3/31
 * @Modify By:
 **/
public class SendMail {

    // 发件人 账号和密码
    public static final String MY_EMAIL_ACCOUNT = "15986862699@163.com";
    public static final String MY_EMAIL_PASSWORD = "wu886620";// 密码,是你自己的设置的授权码

    // SMTP服务器(这里用的163 SMTP服务器)
    public static final String MEAIL_163_SMTP_HOST = "smtp.163.com";
    public static final String SMTP_163_PORT = "25";// 端口号,这个是163使用到的;QQ的应该是465或者875

    // 收件人
    public static final String RECEIVE_EMAIL_ACCOUNT = "wupengjieteam@163.com";

    public static void testSend(String targetEmail,String inviter,String inviterProjectName,String projectId,String role) throws AddressException, MessagingException {
        Properties p = new Properties();
        p.setProperty("mail.smtp.host", MEAIL_163_SMTP_HOST);
        p.setProperty("mail.smtp.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.socketFactory.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");

        Session session = Session.getInstance(p, new Authenticator() {
            // 设置认证账户信息
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
            }
        });
        session.setDebug(true);
        StringBuffer contentBuffer = new StringBuffer("<h1>&nbsp&nbsp尊敬的用户</h1><br/>");
        contentBuffer.append("<h1>");
        contentBuffer.append(inviter);
        contentBuffer.append("邀请你加入项目");
        contentBuffer.append(inviterProjectName);
        contentBuffer.append("。你在本次项目中担任的是");
        contentBuffer.append(role);
        contentBuffer.append("一职。<br/>点击下方链接同意并自动加入该项目组<br/>");
        contentBuffer.append("<a href=\"http://127.0.0.1:8020/TeamCollaborationSystem/addUserJump.html?projectId=");
        contentBuffer.append(projectId);
        contentBuffer.append("&targetEmail=");
        contentBuffer.append(targetEmail);
        contentBuffer.append("&role=");
        contentBuffer.append(role+"\"");
        contentBuffer.append("target=\"_blank\">");
        contentBuffer.append("加入项目");
        contentBuffer.append("</a>");
        contentBuffer.append("<br/>点击链接代表你同意本系统的一切协议，当你已注册本系统账户时，系统将自动拉取你进项目组，当你未注册本系统时，系统将用该邮箱为你创建初始账号，初始密码为123456，请登录后自己修改密码和账号名称，谢谢。");

        MimeMessage message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
        // 收件人和抄送人
        message.setRecipients(Message.RecipientType.TO, targetEmail);
//		message.setRecipients(Message.RecipientType.CC, MY_EMAIL_ACCOUNT);

        // 内容(这个内容还不能乱写,有可能会被SMTP拒绝掉;多试几次吧)
        message.setSubject("邀请通知");
        message.setContent(contentBuffer.toString(), "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        System.out.println("准备发送");
        Transport.send(message);
    }

    public static void testFindPassword(String targetEmail,String verificationCode) throws AddressException, MessagingException {
        Properties p = new Properties();
        p.setProperty("mail.smtp.host", MEAIL_163_SMTP_HOST);
        p.setProperty("mail.smtp.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.socketFactory.port", SMTP_163_PORT);
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.socketFactory.class", "SSL_FACTORY");

        Session session = Session.getInstance(p, new Authenticator() {
            // 设置认证账户信息
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MY_EMAIL_ACCOUNT, MY_EMAIL_PASSWORD);
            }
        });
        session.setDebug(true);
        StringBuffer contentBuffer = new StringBuffer("<h1>&nbsp&nbsp尊敬的用户</h1><br/>");
        contentBuffer.append("您的验证码为：");
        contentBuffer.append("1234");
        contentBuffer.append("。30分钟内有效，请尽快输入。");
        MimeMessage message = new MimeMessage(session);
        // 发件人
        message.setFrom(new InternetAddress(MY_EMAIL_ACCOUNT));
        // 收件人和抄送人
        message.setRecipients(Message.RecipientType.TO, targetEmail);
		message.setRecipients(Message.RecipientType.CC, MY_EMAIL_ACCOUNT);

        // 内容(这个内容还不能乱写,有可能会被SMTP拒绝掉;多试几次吧)
        message.setSubject("找回密码");
        message.setContent(contentBuffer.toString(), "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        System.out.println("准备发送");
        Transport.send(message);

    }
}
