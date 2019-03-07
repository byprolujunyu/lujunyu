package ljy.com.flutter_button;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {


    private static final String CHANNEL = "cart/query";
    private static final String CHANNEL1 = "cart/add";
    private static final String CHANNEL2 = "cart/update";
    private static final String CHANNEL3 = "cart/delete";
    private MethodChannel query;
    private MethodChannel delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);
        query = new MethodChannel(getFlutterView(), CHANNEL);
        query.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                List<Map> ms = new ArrayList<>();
                Cursor query = DbUtils.getInstance(MainActivity.this).query("select * from carttab", null);
                while (query.moveToNext()) {
                    Map map = new HashMap();
                    int name = query.getColumnIndex("_name");
                    String nameStr = query.getString(name);
                    map.put("_naem", nameStr);
                    int imageuri = query.getColumnIndex("_imageuri");
                    String imageuriStr = query.getString(imageuri);
                    map.put("_imageuri", imageuriStr);
                    int price = query.getColumnIndex("_price");
                    String priceStr = query.getString(price);
                    map.put("_price", new Double(priceStr));
                    int id = query.getColumnIndex("_id");
                    int id2 = query.getInt(id);
                    map.put("_id", id2);
                    int count = query.getInt(query.getColumnIndex("_count"));
                    map.put("_count",count);
                    ms.add(map);
                }
                setResult(ms);
            }
        });
        new MethodChannel(getFlutterView(), CHANNEL1).setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    HashMap map = (HashMap) methodCall.arguments;
                    String name = (String) map.get("goodsName");
                    String imageuri = (String) map.get("image");
                    Double price = (Double) map.get("presentPrice");
                    int count = (int) map.get("count");
                    int i = DbUtils.getInstance(MainActivity.this).add(name, imageuri, price.toString(),count);
                    System.out.println(i);
                    result.success("ok");
                } catch (Exception e) {
                    e.printStackTrace();
                    result.notImplemented();
                }


            }
        });
        new MethodChannel(getFlutterView(), CHANNEL2).setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {

            }
        });

        delete = new MethodChannel(
                getFlutterView(), CHANNEL3
        );

        delete.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                int id = (int) methodCall.arguments;
                int delete = DbUtils.getInstance(MainActivity.this).delete(id);
                result.success(delete);
            }
        });
    }

    private void setResult(List<Map> ms) {
        query.invokeMethod("queryback", ms);
    }
}
