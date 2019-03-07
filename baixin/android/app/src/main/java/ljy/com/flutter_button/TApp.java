package ljy.com.flutter_button;

import android.app.Application;

public class TApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
     addsomeaddress();
    }
    private void addsomeaddress() {
        AddressDbUtils.getInstance(this).add("杨霖","14782002531","静安区阳城路101弄41号101",1);
        AddressDbUtils.getInstance(this).add("何晓萍","13564389123","上海市松江区九亭街道10号402室",0);
        AddressDbUtils.getInstance(this).add("杨霖","17602134437","上海市松江区泗凯路875弄1号502室",0);
    }
}
