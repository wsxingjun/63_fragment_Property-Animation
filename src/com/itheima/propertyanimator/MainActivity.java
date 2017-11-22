package com.itheima.propertyanimator;

import android.os.Bundle;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//���صĲ���
		setContentView(R.layout.activity_main);
		
		//�ҵ�iv ִ�ж���
		iv = (ImageView) findViewById(R.id.iv);
		//������һ������¼�
		iv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Toast.makeText(MainActivity.this, "��㲻����", 0).show();
			}
		});
		

//		iv.setTranslationX(translationX)
//		iv.setScaleX(scaleX)
//		iv.setAlpha(alpha)
//		iv.setRotation(rotation)
		
		
	}

	//λ�ƶ���
	public void translate(View v){
		//�������Զ���
		/**
		 * target ִ�е�Ŀ��  
		 * propertyName ��������  The name of the property being animated.
		 * float... values �ɱ���� 
		 */
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 10, 50,20,100);
		oa.setDuration(2000);
		oa.start(); //��ʼ����
		
	}
	//���Ŷ���
	public void scale(View v){
		
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "scaleY", 0.1f, 2, 1, 2);
		oa.setDuration(2000);
		oa.start();
	}
	
	//ʵ��͸����Ч�� 
	public void alpha(View v){
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "alpha", 0, 0.5f, 0, 1,0,1);
		oa.setDuration(2000);
		oa.start();
	}
	
	//ʵ����ת��Ч��
	public void rotate(View v){
//		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotation", 0, 180, 90, 360);
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "rotationX", 0, 180, 90, 360);
		oa.setDuration(2000);
		oa.start();
	}
	
	
	//һ��� 
	public void fly(View v){
		AnimatorSet as = new AnimatorSet();
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv, "translationX", 10, 50, 20, 100);
		ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv, "scaleY", 0.1f, 2, 1, 2);
		ObjectAnimator oa3 = ObjectAnimator.ofFloat(iv, "alpha", 0, 0.5f, 0, 1);
		ObjectAnimator oa4 = ObjectAnimator.ofFloat(iv, "rotationY", 0, 180, 90, 360);
		as.setDuration(2000);//ִ�ж���ʱ��
		as.setTarget(iv);//ivִ�ж���
		//����������Ӷ���
		//������
		as.playSequentially(oa, oa2, oa3, oa4);
		//һ���
//		as.playTogether(oa, oa2, oa3, oa4);
		as.start();
	}
	
	//ʹ��xml�ķ�ʽ�������Զ���
	public void playxml(View v){
		
		ObjectAnimator oa = (ObjectAnimator) AnimatorInflater.loadAnimator(this, R.animator.oanimator);
		//����ִ��Ŀ��
		oa.setTarget(iv);
		oa.start();//��ʼִ��
	}
}
