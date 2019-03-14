package ljy.com.flutter_button;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class AddressActivity extends Activity {

    private EditText name;
    private EditText phone;
    private TextView address;
    private EditText roomNo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_address);
        Class

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        address = (TextView) findViewById(R.id.address);
        roomNo = (EditText) findViewById(R.id.roomNo);

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


    public void submit(View view) {
        String name = this.name.getText().toString();
        String phone = this.phone.getText().toString();
        String roomNo = this.roomNo.getText().toString();
    }

    public void goback(View view) {
        finish();
    }
}
