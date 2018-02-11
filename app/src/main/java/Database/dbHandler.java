package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kristen on 2/10/2018.
 */
public class dbHandler extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "TechInterview";

        private static final int DATABASE_VERSION = 2;

        // Database creation sql statement
        private static final String DATABASE_CREATE = "create table Users ( _id integer primary key,name text not null);";

        public dbHandler(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        // Method is called during creation of the database
        @Override
        public void onCreate(SQLiteDatabase database) {
            database.execSQL(DATABASE_CREATE);
        }

        // Method is called during an upgrade of the database,
        @Override
        public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
            Log.w(dbHandler.class.getName(),
                    "Upgrading database from version " + oldVersion + " to "
                            + newVersion + ", which will destroy all old data");
            database.execSQL("DROP TABLE IF EXISTS Users");
            onCreate(database);
        }
    }
