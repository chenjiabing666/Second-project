package cn.tedu.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

/**
 * 进度条的测试类
 */
public class ThirdActivity extends AppCompatActivity {


    private LinearLayout ll_progress;
    private ProgressBar bar_1;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        ll_progress=findViewById(R.id.ll_progress);
        bar_1=findViewById(R.id.bar_1);
        seekBar=findViewById(R.id.seekBar);

        //给seekBar设置监听
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //进度改变的时候调用
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            //开始滑竿的时候调用
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            //离开滑竿的时候调用
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();  //seekbar的进度
                bar_1.setProgress(progress); //设置进度

                if (progress==seekBar.getMax()){  //判断是否达到最大值

                    /**
                     * View.INVISIBLE：不可见，但是占用空间
                     *  View.GONE：不可见，且不占用空间
                     */
                    ll_progress.setVisibility(View.GONE);  //设置不可见
                }else{  //如果没有达到最大值
                    ll_progress.setVisibility(View.VISIBLE);  //设置可见
                }
            }
        });
    }
}
