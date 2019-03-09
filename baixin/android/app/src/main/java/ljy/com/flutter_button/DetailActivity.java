package ljy.com.flutter_button;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DetailActivity extends Activity {

    private DetailBean dbean;
    private HashMap map;
    private TextView title;
    private HashMap goodInfo;
    private List<HashMap> goodComments;
    private HashMap advertesPicture;
    String api = "https://wxmini.baixingliangfan.cn/baixing/wxmini/getGoodDetailById/";

    private ImageView productImage;
    private TextView textName;
    private TextView productNum;
    private TextView presentPrice;
    private TextView oriPrice;




    void request(String id) {

        Request request = new Request.Builder()
                .url(api)
                .post(getFormBody(id))
                .build();
        new OkHttpClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();

                dbean = new Gson().fromJson(json, DetailBean.class);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        System.out.println(dbean);

                        title = findViewById(R.id.title);

                        title.setText(dbean.getData().getGoodInfo().getGoodsName());
                    }
                });

            }
        });
    }

    private RequestBody getFormBody(String id) {

        RequestBody body = new FormBody.Builder()
                .add("goodId", id).build();
        return body;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);

        map = (HashMap) getIntent().getSerializableExtra("map");
        map = (HashMap) map.get("data");
        advertesPicture = (HashMap) map.get("advertesPicture");
        goodInfo = (HashMap) map.get("goodInfo");
        goodComments = (List<HashMap>) map.get("goodComments");

        productImage = (ImageView) findViewById(R.id.productImage);
        textName = (TextView) findViewById(R.id.textName);
        productNum = (TextView) findViewById(R.id.productNum);
        presentPrice = (TextView) findViewById(R.id.presentPrice);
        oriPrice = (TextView) findViewById(R.id.oriPrice);

        TextView title = findViewById(R.id.title);
        if (map != null) {
            String titleStr = (String) goodInfo.get("goodsName");
            title.setText(titleStr);
            String imguri = (String) goodInfo.get("comPic");
//            Glide.with(DetailActivity.this).load(imguri).into(productImage);
            String productname = (String) goodInfo.get("goodsName");
            textName.setText(productname);
            Double
                    present_Price = (Double) goodInfo.get("presentPrice");
            presentPrice.setText(present_Price+"0");
            String goodsSerialNumber = (String) goodInfo.get("goodsSerialNumber");
            productNum.setText(goodsSerialNumber);
            Double ori_price = (Double) goodInfo.get("oriPrice");
            oriPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            oriPrice.setText(ori_price+"0");
        }
    }

    public void goback(View view) {
        finish();
    }
}
