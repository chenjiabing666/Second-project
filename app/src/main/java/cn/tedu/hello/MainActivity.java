package cn.tedu.hello;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {

    private Button btn_1;
    private Button btn_2;

    private EditText mob_text_view;

    private EditText sms_text_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_1 = findViewById(R.id.btn_1);
        btn_2=findViewById(R.id.btn_2);
        mob_text_view=findViewById(R.id.mob_edit_text);
        sms_text_view=findViewById(R.id.sms_edit_text);

        //点击事件
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);

        //长按事件
        btn_1.setOnLongClickListener(this);
        btn_2.setOnLongClickListener(this);

    }

    /**
     * 点击监听事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (v==btn_1){
//            Toast.makeText(this,"点击打电话",Toast.LENGTH_SHORT).show();

            //创建一个隐式的Intent
            String action=Intent.ACTION_DIAL; //拨号的意图
            Intent intent=new Intent(action);

            //携带数据
            String number=mob_text_view.getText().toString();
            System.out.println(number);
            intent.setData(Uri.parse("tel:"+number));
            //启动拨号的界面
            startActivity(intent);
        }else if(v==btn_2){
//            Toast.makeText(this,"点击发短信",Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(Intent.ACTION_SEND);  //发送短信的意图
            //携带数据
            String number=mob_text_view.getText().toString();
            intent.setData(Uri.parse("smsto:"+number)); //手机号码
            String sms=sms_text_view.getText().toString();  //短信内容
            intent.putExtra("sms_body",sms);  //添加短信内容，sms_body作为携带的数据key，只能是这个
            startActivity(intent);  //启动


        }

    }


    /**
     * 长按监听事件
     * @param v
     * @return  返回true表示此事件已经被消费了，不会再次触发点击事件
     */
    @Override
    public boolean onLongClick(View v) {
        if (v==btn_1){
//            Toast.makeText(this,"长按打电话",Toast.LENGTH_SHORT).show();


        }else if(v==btn_2){
            Toast.makeText(this,"长按发短信",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
