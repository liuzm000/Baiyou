package abc;

import com.netease.nim.uikit.NimUIKit;
import com.netease.nimlib.sdk.AbortableFuture;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.RequestCallback;
import com.netease.nimlib.sdk.StatusBarNotificationConfig;
import com.netease.nimlib.sdk.auth.LoginInfo;

/**
 * Created by liuzhimin on 2017/8/15.
 */

public class LoginServerHelper {

    private AbortableFuture<LoginInfo> loginRequest;
    public final static String appKey = "1d8da4402a17816db6ec73a6d0501de9";
    public final static String appSecret="e15606b2b2c9";


    public  void loginChatSer(final String account,final String token ,final  LoginServerHelperInterf mLoginServerHelperInterf ){

//        helper.showLoading();
        // 云信只提供消息通道，并不包含用户资料逻辑。开发者需要在管理后台或通过服务器接口将用户帐号和token同步到云信服务器。
        // 在这里直接使用同步到云信服务器的帐号和token登录。
        // 这里为了简便起见，demo就直接使用了密码的md5作为token。
        // 如果开发者直接使用这个demo，只更改appkey，然后就登入自己的账户体系的话，需要传入同步到云信服务器的token，而不是用户密码。
        // 登录
        loginRequest = NimUIKit.doLogin(new LoginInfo(account, token), new RequestCallback<LoginInfo>() {
            @Override
            public void onSuccess(LoginInfo param) {



                DemoCache.setAccount(account);
                saveLoginInfo(account, token);
                // 初始化消息提醒配置
                initNotificationConfig();

                mLoginServerHelperInterf.onSuccess();

            }

            @Override
            public void onFailed(int code) {
                mLoginServerHelperInterf.onFailed(code);
//                helper.toast("登录失败");
//                helper.hideLoading();
            }

            @Override
            public void onException(Throwable exception) {
//                helper.toast("登录失败");
//                helper.hideLoading();
                mLoginServerHelperInterf.onException(exception);
            }
        });

    }

    private void initNotificationConfig() {
        // 初始化消息提醒
        NIMClient.toggleNotification(UserPreferences.getNotificationToggle());

        // 加载状态栏配置
        StatusBarNotificationConfig statusBarNotificationConfig = UserPreferences.getStatusConfig();
        if (statusBarNotificationConfig == null) {
            statusBarNotificationConfig = DemoCache.getNotificationConfig();
            UserPreferences.setStatusConfig(statusBarNotificationConfig);
        }
        // 更新配置
        NIMClient.updateStatusBarNotificationConfig(statusBarNotificationConfig);
    }

    private void saveLoginInfo(final String account, final String token) {
        Preferences.saveUserAccount(account);
        Preferences.saveUserToken(token);
    }


    public interface LoginServerHelperInterf {
        public void onSuccess();
        public void onFailed(int code);
        public void onException(Throwable exception);
    }

}
