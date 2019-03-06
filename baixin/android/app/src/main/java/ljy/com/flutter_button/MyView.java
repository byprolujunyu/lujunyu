package ljy.com.flutter_button;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.List;
import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class MyView implements PlatformView {

    private final TextView myNativeView;

    MyView(Context context, BinaryMessenger messenger, int id, Map<String, Object> params) {
        TextView myNativeView = new TextView(context);
        myNativeView.setText("");

        if (params.containsKey("myContent")) {
            String myContent = (String) params.get("myContent");
            myNativeView.setText(myContent);
        }

        myNativeView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );

        this.myNativeView = myNativeView;
    }

    @Override
    public View getView() {
        return myNativeView;
    }

    @Override
    public void dispose() {

    }
}
