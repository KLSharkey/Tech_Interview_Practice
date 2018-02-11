package Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Kristen on 2/10/2018.
 */
/*@Entity
public class User {
    private String email;
    private String password;

    User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
*/
public class User {

    private dbHandler dbHelper;

    private SQLiteDatabase database;

    public final static String USER_TABLE = "Users"; // name of table

    public final static String USER_ID = "_id"; // id value for User
    public final static String USER_EMAIL = "email";  // email of User
    public final static String USER_PASSWORD = "password";

    /**
     * @param context
     */
    public User(Context context) {
        dbHelper = new dbHandler(context);
        database = dbHelper.getWritableDatabase();
    }


    public long createRecords(String id, String name) {
        ContentValues values = new ContentValues();
        values.put(USER_ID, id);
        values.put(USER_EMAIL, name);
        return database.insert(USER_TABLE, null, values);
    }

    public Cursor selectRecords() {
        String[] cols = new String[]{USER_ID, USER_EMAIL, USER_PASSWORD};
        Cursor mCursor = database.query(true, USER_TABLE, cols, null
                , null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }
}