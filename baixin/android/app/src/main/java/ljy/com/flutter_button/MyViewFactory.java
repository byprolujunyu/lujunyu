package ljy.com.flutter_button;

import android.content.Context;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class MyViewFactory extends PlatformViewFactory {
    private BinaryMessenger messenger;

    public MyViewFactory(BinaryMessenger createArgsCodec) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = (BinaryMessenger) createArgsCodec;
    }

    @Override
    public PlatformView create(Context context, int i, Object o) {
        Map<String, Object> params = (Map<String, Object>) o;
        return new MyView(context, messenger, i, params);
    }
}
