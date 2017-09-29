package com.example.notification;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;


public class ProtectedService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Notification notification = new Notification();
		notification.icon = R.mipmap.ic_launcher;// 顶部的小图标
		// RemoteViews 远程view
		notification.contentView = new RemoteViews(getPackageName(),
				R.layout.notifi);

		// 指定打开页面的意图
		Intent actionIntent = new Intent();
		actionIntent.setAction("android.intent.action.MAIN");
		actionIntent.addCategory("android.intent.category.LAUNCHER");

		ComponentName componentName = new ComponentName(this,
				MainActivity.class);
		// 通过ComponentName对象 指定跳转的页面
		actionIntent.setComponent(componentName);

		// PendingIntent 延时意图 意图不是立刻执行 需要一个触发点 是对普通意图的封装
		notification.contentIntent = PendingIntent.getActivity(
				getApplicationContext(), 101, actionIntent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		// 参1 通知的id 参2 通知的对象
		startForeground(10001, notification);
	}
}
