package com.example.circle.circlemenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import com.zhy.view.CircleMenuLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Handler;

/**
 * <pre>
 * @author zhy 
 * http://blog.csdn.net/lmj623565791/article/details/43131133
 * </pre>
 */
public class CircleActivity extends Activity
{

	private CircleMenuLayout mCircleMenuLayout;

	private String[] mItemTexts = new String[] { "NFC扫描 ", "数据查询", "功能描述",
			"关于我们", "个人中心", "退出系统" };
	private int[] mItemImgs = new int[] { R.drawable.home_mbank_5_normal,
			R.drawable.home_mbank_5_normal, R.drawable.home_mbank_5_normal,
			R.drawable.home_mbank_5_normal, R.drawable.home_mbank_5_normal,
			R.drawable.home_mbank_5_normal };
	private TextView show_date;
	private TextView show_time;
	private
	android.os.Handler handler = new android.os.Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if (msg.what == 10){
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat formatter   =   new SimpleDateFormat("HH:mm:ss");
				String time = formatter.format(date);
				show_time.setText(time);
				handler.sendEmptyMessageDelayed(10,1000);
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//自已切换布局文件看效果
		setContentView(R.layout.activity_main02);
//		setContentView(R.layout.activity_main);
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter   =   new SimpleDateFormat("yyyy年MM月dd日 EEEE");
		String date_time = formatter.format(date);
		System.out.println("时间为:" + date_time);
		mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
		show_date = (TextView) findViewById(R.id.show_date);
		show_time = (TextView) findViewById(R.id.show_time);
		show_date.setText(date_time);
		mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);


		mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
			@Override
			public void itemClick(View view, int pos) {
				System.out.println("pos为:" + pos);
				System.out.println("ID为:" + view.getId());
				switch (pos){
					case 0:
						startActivity(new Intent(CircleActivity.this,CCBActivity.class));
						break;
					case 1:
						Toast.makeText(CircleActivity.this, "这是数据查询",
								Toast.LENGTH_SHORT).show();
						break;
					case 2:
						Toast.makeText(CircleActivity.this, "这是功能描述",
								Toast.LENGTH_SHORT).show();
						break;
					case 3:
						Toast.makeText(CircleActivity.this, "这是关于我们",
								Toast.LENGTH_SHORT).show();
						break;
					case 4:
						Toast.makeText(CircleActivity.this, "这是个人中心",
								Toast.LENGTH_SHORT).show();
						startActivity(new Intent(CircleActivity.this,GerenActivity.class));
						break;
					case 5:
						Toast.makeText(CircleActivity.this, "这是退出系统",
								Toast.LENGTH_SHORT).show();
						break;
					default:
						break;
				}
			}
			@Override
			public void itemCenterClick(View view) {
			}
		});
		new Thread(){
			@Override
			public void run() {
				handler.sendEmptyMessage(10);
			}
		}.start();
		
	}

}
