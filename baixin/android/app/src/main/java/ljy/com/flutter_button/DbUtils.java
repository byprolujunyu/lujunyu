package ljy.com.flutter_button;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbUtils extends SQLiteOpenHelper {
    private static volatile DbUtils ourInstance;

    public DbUtils(Context context) {
        super(context, "cart.db", null, 1);
    }

    public static DbUtils getInstance(Context context) {
        if (ourInstance == null) {
            synchronized (DbUtils.class) {
                if (ourInstance == null) {
                    ourInstance = new DbUtils(context);
                }
            }
        }
        return ourInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "CREATE TABLE IF NOT EXISTS carttab(_id Integer primary key autoincrement , _name TEXT, _imageuri TEXT unique,_isselected int,_count int DEFAULT 1,_isdelete int,_price text)";
        db.execSQL(sql);

    }

    /**
     * 查询数据库
     * @param sql
     * @param selectionArgs
     * @return
     */
    public Cursor query(String sql, String [] selectionArgs){
        SQLiteDatabase db = getReadableDatabase();
        Cursor rawQuery = db.rawQuery(sql, selectionArgs);
        return rawQuery;
    }


    public int add(String name,String imageuri,String price,int count){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("_name",name);
        values.put("_imageuri",imageuri);
        values.put("_price",price);
        values.put("_count",count);
        return (int) db.insert("carttab",null,values);
    }

    public int delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String[] whereArgs = {String.valueOf(id)};
        return db.delete("carttab","_id = ?",whereArgs);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
