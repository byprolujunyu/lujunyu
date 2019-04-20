package ljy.com.flutter_button;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import org.devio.flutter.plugin.asr.AsrPlugin;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {

    private void addsomeaddress() {
        AddressDbUtils.getInstance(this).add("杨霖", "14782002531", "静安区阳城路101弄41号101", 1);
        AddressDbUtils.getInstance(this).add("何晓萍", "13564389123", "上海市松江区九亭街道10号402室", 0);
        AddressDbUtils.getInstance(this).add("杨霖", "17602134437", "上海市松江区泗凯路875弄1号502室", 0);
    }

    private static final String CHANNEL = "cart/query";
    private static final String CHANNEL1 = "cart/add";
    private static final String CHANNEL2 = "cart/update";
    private static final String CHANNEL3 = "cart/delete";
    private MethodChannel query;
    private MethodChannel delete;
    private MethodChannel queryAddress;
    private MethodChannel addAddress;
    private MethodChannel deleteAddress;

    private MethodChannel jumptoAddress;

    private MethodChannel jump;
    private void registerSelfPlugin() {
        AsrPlugin.registerWith(registrarFor("org.devio.flutter.plugin.asr.AsrPlugin"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);
        registerSelfPlugin();
        jump = new MethodChannel(getFlutterView(), "detail/jump");
        jump.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                HashMap map = (HashMap) methodCall.arguments;
                System.out.println(map);
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("map", (Serializable) map);
                startActivity(intent);
            }
        });
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
                    map.put("_count", count);
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
                    int i = DbUtils.getInstance(MainActivity.this).add(name, imageuri, price.toString(), count);
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

        queryAddress = new MethodChannel(getFlutterView(), "address/queryAddress");

        queryAddress.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {

                List<Map> ms = new ArrayList<>();
                Cursor query = AddressDbUtils.getInstance(MainActivity.this).query("select * from addresstab", null);
                while (query.moveToNext()) {
                    Map map = new HashMap();
                    int name = query.getColumnIndex("_name");
                    String nameStr = query.getString(name);
                    map.put("_name", nameStr);
                    int imageuri = query.getColumnIndex("_phone");
                    String imageuriStr = query.getString(imageuri);
                    map.put("_phone", imageuriStr);
                    int price = query.getColumnIndex("_address");
                    String priceStr = query.getString(price);
                    map.put("_address", priceStr);
                    int id = query.getColumnIndex("_id");
                    int id2 = query.getInt(id);
                    map.put("_id", id2);
                    int aDefault = query.getInt(query.getColumnIndex("_default"));
                    map.put("isSelected", aDefault);
                    ms.add(map);
                }

                setResultAdd(ms);
            }
        });

        deleteAddress = new MethodChannel(getFlutterView(), "address/deleteAddress");

        deleteAddress.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                int id = (int) methodCall.arguments;
                AddressDbUtils.getInstance(MainActivity.this).delete(id);
                System.out.println(id);
                result.success("ok");
            }
        });

        addAddress = new MethodChannel(getFlutterView(), "address/addAddress");

        addAddress.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                try {
                    HashMap map = (HashMap) methodCall.arguments;
                    addsomeaddress();
                    result.success("ok");
                } catch (Exception e) {
                    e.printStackTrace();
                    result.notImplemented();
                }
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

        jumptoAddress = new MethodChannel(getFlutterView(), "address/jumptoAddress");

        jumptoAddress.setMethodCallHandler(new MethodChannel.MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                Intent intent = new Intent(MainActivity.this, AddressActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setResult(List<Map> ms) {
        query.invokeMethod("queryback", ms);
    }

    private void setResultAdd(List<Map> ms) {
        queryAddress.invokeMethod("queryaddressback", ms);
    }
}
