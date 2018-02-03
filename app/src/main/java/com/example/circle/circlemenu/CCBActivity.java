package com.example.circle.circlemenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.zhy.view.CircleMenuLayout;

/**
 * <pre>
 * @author zhy 
 * http://blog.csdn.net/lmj623565791/article/details/43131133
 * </pre>
 */
public class CCBActivity extends Activity
{

	private CircleMenuLayout mCircleMenuLayout;

	private String[] mItemTexts = new String[] { "NFC扫描 ", "数据查询", "功能描述",
			"关于我们", "个人中心", "退出系统" };
	private int[] mItemImgs = new int[] { R.drawable.home_mbank_5_normal,
			R.drawable.home_mbank_5_normal, R.drawable.home_mbank_5_normal,
			R.drawable.home_mbank_5_normal, R.drawable.home_mbank_5_normal,
			R.drawable.home_mbank_5_normal };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//自已切换布局文件看效果
//		setContentView(R.layout.activity_main02);
		setContentView(R.layout.activity_main);

		mCircleMenuLayout = (CircleMenuLayout) findViewById(R.id.id_menulayout);
		mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);



		mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener() {
			@Override
			public void itemClick(View view, int pos) {
				Toast.makeText(CCBActivity.this, mItemTexts[pos],
						Toast.LENGTH_SHORT).show();
			}

			@Override
			public void itemCenterClick(View view) {
				Toast.makeText(CCBActivity.this,
						"you can do something just like ccb  ",
						Toast.LENGTH_SHORT).show();
			}
		});
		
	}

}
