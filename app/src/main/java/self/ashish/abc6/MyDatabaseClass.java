package self.ashish.abc6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ashish on 12/16/2015.
 */
public class MyDatabaseClass extends SQLiteOpenHelper {
    SQLiteDatabase database;
    private static final String DATABASE_NAME="Abc6.db";
    private static final String TABLE_NAME="Book";
    private static final String NAME="NAME";
    private static final String AUTHOR="AUTHOR";
    private static final String PUBLICATION="PUBLICATION";
    private static final int VERSION=1;
    private static final String ID="_id";
    private static final String CREATE_TABLE="create table "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME
            +" TEXT NOT NULL,"+AUTHOR+" TEXT NOT NULL,"+PUBLICATION+" TEXT NOT NULL"+");";
    public MyDatabaseClass(Context context) {
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE"+TABLE_NAME);
        onCreate(db);
    }
    public long insert(Book book){
        database=getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,book.getName());
        values.put(AUTHOR, book.getAuthor());
        values.put(PUBLICATION, book.getPublication());

        return database.insert(TABLE_NAME,null,values);
    }
    public Cursor display(){
        database=getReadableDatabase();
        return database.query(TABLE_NAME,new String[]{ID,NAME,AUTHOR,PUBLICATION},null,null,null,null,null);
    }
}
