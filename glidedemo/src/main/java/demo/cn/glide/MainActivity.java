package demo.cn.glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    ImageView mImageView;
    String mPhotoUrls[]=new String[]{
            "http://p0.so.qhimg.com/bdr/_240_/t01f969f2c6578e6c0a.jpg",
            "http://p4.so.qhimg.com/bdr/_240_/t01daf89f44356d7df9.jpg",
            "http://p3.so.qhimg.com/bdr/_240_/t01155f5ca7f39d2488.jpg",
            "http://p0.so.qhimg.com/bdr/_240_/t01b5b467ab0ac50060.jpg"};
    int mPhotoIndex=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView= ((ImageView) findViewById(R.id.imageView1));
    }
    public void defaultPhoto(View v){
        mImageView.setImageResource(R.mipmap.ic_launcher);
    }
     public void prePhoto(View v){
         //计算图片的序号
         if(mPhotoIndex<=0){
             mPhotoIndex=0;
         }else{
             mPhotoIndex--;
         }
         //下载并设置图片
         downAndSetphotoByGlide();
     }
    public  void nextPhoto(View v){
        //计算图片的序号
        if(mPhotoIndex>=mPhotoUrls.length-1){
            mPhotoIndex=mPhotoUrls.length-1;
        }else{
            mPhotoIndex++;
        }
        //下载并设置图片
        downAndSetphotoByGlide();

    }
    private  void downAndSetphotoByGlide(){

        Glide.with(MainActivity.this)     //支持context\Activity\Fragment
                .load(mPhotoUrls[mPhotoIndex])       //开始下载
                .error(R.mipmap.ic_launcher)          //如果下载异常则显示指定的图片
                .into(mImageView);                    //显示到指定的组件上
    }
}
