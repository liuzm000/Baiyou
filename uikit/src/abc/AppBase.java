package abc;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;

import com.netease.nim.uikit.NimUIKit;
import com.netease.nim.uikit.custom.DefaultUserInfoProvider;
import com.netease.nim.uikit.session.viewholder.MsgViewHolderThumbBase;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.SDKOptions;
import com.netease.nimlib.sdk.auth.LoginInfo;

import abc.DemoCache;
import abc.Preferences;

//import org.library.http.HttpAsyncTaskUtils;

public class AppBase extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
//		HttpAsyncTaskUtils.debug = true ;
		DemoCache.setContext(this);

		NIMClient.init(this, getLoginInfo(), getOptions());

		if (inMainProcess()) {
			// 在主进程中初始化UI组件，判断所属进程方法请参见demo源码。
			NimUIKit.init(this);
		}

	}

	private LoginInfo getLoginInfo() {
		String account = Preferences.getUserAccount();
		String token = Preferences.getUserToken();

		if (!TextUtils.isEmpty(account) && !TextUtils.isEmpty(token)) {
			DemoCache.setAccount(account.toLowerCase());
			return new LoginInfo(account, token);
		} else {
			return null;
		}
	}

	private SDKOptions getOptions() {
		SDKOptions options = new SDKOptions();

		// 如果将新消息通知提醒托管给SDK完成，需要添加以下配置。
//		initStatusBarNotificationConfig(options);

		// 配置保存图片，文件，log等数据的目录
		options.sdkStorageRootPath = Environment.getExternalStorageDirectory() + "/" + getPackageName() + "/nim";

		// 配置数据库加密秘钥
		options.databaseEncryptKey = "NETEASE";

		// 配置是否需要预下载附件缩略图
		options.preloadAttach = true;

		// 配置附件缩略图的尺寸大小，
		options.thumbnailSize = MsgViewHolderThumbBase.getImageMaxEdge();

		// 用户信息提供者
		options.userInfoProvider = new DefaultUserInfoProvider(this);

		// 定制通知栏提醒文案（可选，如果不定制将采用SDK默认文案）
//		options.messageNotifierCustomization = messageNotifierCustomization;

		// 在线多端同步未读数
		options.sessionReadAck = true;

		// 云信私有化配置项
//		configServerAddress(options);

		return options;
	}


	public boolean inMainProcess() {
		String packageName = getPackageName();
		String processName = SystemUtil.getProcessName(this);
		return packageName.equals(processName);
	}

}
