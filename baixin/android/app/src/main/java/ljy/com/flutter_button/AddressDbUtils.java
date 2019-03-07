package ljy.com.flutter_button;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AddressDbUtils extends SQLiteOpenHelper {

    private static volatile AddressDbUtils ourInstance;

    public AddressDbUtils(Context context) {
        super(context, "address.db", null, 1);
    }

    public static AddressDbUtils getInstance(Context context) {
        if (ourInstance == null) {
            synchronized (DbUtils.class) {
                if (ourInstance == null) {
                    ourInstance = new AddressDbUtils(context);
                }
            }
        }
        return ourInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS addresstab(_id INTEGER primary key autoincrement , _name TEXT, _phone TEXT ,_address  TEXT, _default INTEGER DEFAULT 1)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 查询数据库
     *
     * @param sql
     * @param selectionArgs
     * @return
     */
    public Cursor query(String sql, String[] selectionArgs) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor rawQuery = db.rawQuery(sql, selectionArgs);
        return rawQuery;
    }

    public int add(String name, String _phone, String _address,int defaultint) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_name", name);
        values.put("_phone", _phone);
        values.put("_address", _address);
        values.put("_default",defaultint);
        return (int) db.insert("addresstab", null, values);
    }


    public int delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String[] whereArgs = {String.valueOf(id)};
        return db.delete("addresstab","_id = ?",whereArgs);
    }
}
