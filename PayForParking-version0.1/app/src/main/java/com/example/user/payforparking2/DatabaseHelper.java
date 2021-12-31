package com.example.user.payforparking2;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.DatabaseUtils;
        import android.database.SQLException;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.icu.text.TimeZoneFormat;
        import android.util.Log;
        import android.widget.RadioButton;

        import java.sql.Date;
        import java.sql.Time;
        import java.sql.Timestamp;
        import java.text.SimpleDateFormat;
        import java.util.Calendar;
        import java.util.Locale;
        import java.util.SimpleTimeZone;
        import java.util.TimeZone;

class CustomersDbAdapter {


    // public static final String FTS_VIRTUAL_TABLE = "Customer_table";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_PLATENO = "Plateno";
    public static final String KEY_DATE = "Date";
    public static final String KEY_TIME = "Time";
    public static final String KEY_COLOR = "Color";
    public static final String KEY_RADIO = "Radio";
    public static final String KEY_FLAGE = "Flage";
    public static final String KEY_SEARCH = "searchData";

    private static final String TAG = "CustomersDbAdapter";
    public DatabaseHelper mDbHelper;
    public static SQLiteDatabase mDb;

    private static final String DATABASE_NAME = "CustomerDB";
    public static final String FTS_VIRTUAL_TABLE = "CustomerTable";
    private static final int DATABASE_VERSION = 1;

    Calendar cal;
    SimpleDateFormat retrieve_date;
    //// String bike="ဆိုင္ကယ္";


    //Create a FTS3 Virtual Table for fast searches
    private static final String DATABASE_CREATE =
            "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE + " USING fts3(" +
                    KEY_ID + "," +
                    KEY_NAME + "," +
                    KEY_PLATENO + "," +
                    KEY_COLOR + "," +
                    KEY_DATE + "," +
                    KEY_TIME + "," +
                    KEY_FLAGE + "," +
                    KEY_RADIO + "," +
                    KEY_SEARCH + "," +
                    " UNIQUE (" + KEY_NAME + "));";

    //private static final String DATABASE_CREATE_1 ="CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE + "(ID AUTOINCREMENT, NAME TEXT, )";
    public Cursor searchCustomerByCar(String inputText) throws SQLException {
        Log.w(TAG, inputText);
        cal = Calendar.getInstance();
        retrieve_date = new SimpleDateFormat("d-M-yyyy");
        String date = retrieve_date.format(cal.getTime());
        String motor = "ကား";
        String key = "0";
        // String flage="0";
                /* String query = "SELECT docid as _id," +
                KEY_NAME + "," +
                KEY_PLATENO + "," +
                KEY_COLOR+","+KEY_DATE+","+KEY_TIME+","+KEY_RADIO+","+KEY_FLAGE+
                " from " + FTS_VIRTUAL_TABLE +
                " where " +  KEY_SEARCH + " MATCH '" + inputText +"' AND" +KEY_DATE+ "MATCH '"+ date+" ' AND" +KEY_RADIO+ "MATCH '"+bike+"';";*/
        String query = "SELECT docid as _id," +
                KEY_ID + "," +
                KEY_NAME + "," +
                KEY_PLATENO + "," +
                KEY_COLOR + "," + KEY_DATE + "," + KEY_TIME + "," + KEY_RADIO + "," + KEY_FLAGE +
                " from " + FTS_VIRTUAL_TABLE +
                " where " + KEY_SEARCH + " MATCH '" + inputText + "'  AND " + KEY_DATE + " = '" + date + "' AND " + KEY_RADIO + " = '" + motor + "' AND " + KEY_FLAGE + " = '" + key + "' ;";
        // AND" +KEY_DATE+ "MATCH '"+ date+" '' AND" +KEY_RADIO+ "MATCH '"+bike+"' AND " + KEY_RADIO  + " = '" + radio +"'
        Log.w(TAG, query);
        Cursor mCursor = mDb.rawQuery(query, null);
        // String query = "SELECT * FROM '"+CUSTOMER_TABLE+"' WHERE '"+KEY_NAME+"' LIKE '"+inputText+"' ";
        // Cursor mCursor = mDb.rawQuery(query,null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    private final Context mCtx;

    //CMA(3.9.19
    public void updateFlag(String searchID) {

        Integer integerFlag = 1;
        //String s_id = String.valueOf(searchID);
        //String updateQuery="update '"+FTS_VIRTUAL_TABLE+"' set '"+KEY_FLAGE+"'="+1+" where '"+KEY_ID+"'='"+searchID+"'";
        //String updateQuery = "update CustomerTable set Flage=1 where id=11";
        String updateQuery = "update CustomerTable set Flage=1 where id="+'"'+searchID+'"';
/*
       String updateQuery="update '"+FTS_VIRTUAL_TABLE+"' set '"+KEY_FLAGE+"'='"+str+"' where '"+KEY_ID+"'="+searchID;
        //String updateQuery="update '"+FTS_VIRTUAL_TABLE+"' set '"+KEY_FLAGE+"= str where '"+KEY_ID+"'="+searchID;
        mDb.execSQL(updateQuery);*/
        //SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = mDb.rawQuery(updateQuery, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        //  int c_id = mCursor.getCount() + 1;
        //String str="Done";

        //mDb.update(FTS_VIRTUAL_TABLE, values, "'"+KEY_ID+"'='"+i+"'", null);
        // mDb.update(FTS_VIRTUAL_TABLE, values, "KEY_ID=?",new String []{searchID});
    }

    public int getCountForVType(String v_type,String c_date) {
      /*  cal = Calendar.getInstance();
        retrieve_date = new SimpleDateFormat("d-M-yyyy");
        String date = retrieve_date.format(cal.getTime());*/
        String query = " select id FROM CustomerTable where radio="+'"'+v_type+'"'+"and Date="+ '"'+c_date+'"' +"and flage=1";
        //and date="+'"'+cal_date+'"'
        Cursor mCursor = mDb.rawQuery(query, null);
        return mCursor.getCount();
        // return mCursor;


    }


    public static class DatabaseHelper extends SQLiteOpenHelper {
        Calendar calander;
        SimpleDateFormat insert_date;
        SimpleDateFormat insert_time;

        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.w(TAG, DATABASE_CREATE);
            db.execSQL(DATABASE_CREATE);
        }
        // db.execSQL( "create table " + CUSTOMER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PLATENO TEXT,COLOR TEXT,REC_DATE TEXT, REC_TIME TEXT,REMARKS BOOLEAN  DEFAULT 0)" );}


        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
            onCreate(db);
        }

        public boolean insertData(String name, String plateno, String color, String radio) throws SQLException {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            String flage = "0";
//cma

           /* String query = "SELECT '" + KEY_ID + "' FROM '" + FTS_VIRTUAL_TABLE + "' ;";
            Log.w(TAG, query);
            Cursor mCursor = db.rawQuery(query, null);

            if (mCursor != null) {
                mCursor.moveToFirst();
            }

            int c_id = mCursor.getCount() + 1;*/
            long c_id= DatabaseUtils.queryNumEntries(db,FTS_VIRTUAL_TABLE);
            // String query = "SELECT * FROM '"+CUSTOMER_TABLE+"' WHERE '"+KEY_NAME+"' LIKE '"+inputText+"' ";
            // Cursor mCursor = mDb.rawQuery(query,null);
            // int c_id=1;

//        contentValues.put( COL_1, "" );
            String RadioValue;

            c_id=c_id+1;
            contentValues.put(KEY_ID, c_id);
            contentValues.put(KEY_NAME, name);
            contentValues.put(KEY_PLATENO, plateno);
            contentValues.put(KEY_COLOR, color);
            String vType = null;

            calander = Calendar.getInstance();
            insert_date = new SimpleDateFormat("d-M-yyyy");
            insert_time = new SimpleDateFormat("HH:mm:ss");
            String date = insert_date.format(calander.getTime());
            String time = insert_time.format(calander.getTime());
            contentValues.put(KEY_DATE, date);
            contentValues.put(KEY_TIME, time);
            contentValues.put(KEY_FLAGE, flage);
            contentValues.put(KEY_RADIO, radio);
            contentValues.put(KEY_SEARCH, name);


            //  long result = db.insert( FTS_VIRTUAL_TABLE, null, contentValues );
            long result = db.insert(FTS_VIRTUAL_TABLE, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;
        }


        public Cursor getAllData() {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor res = db.rawQuery("select * from " + FTS_VIRTUAL_TABLE, null);
            return res;
        }

        public int getCountForVType(String v_type) {
            SQLiteDatabase db = this.getWritableDatabase();
            String veh="ကား";
           /* if(v_type.equals("CalCar")) veh="ကား";
            else veh="ဆိုင္ကယ္";*/
            // String query = " select'"+KEY_ID +"'  FROM '" + FTS_VIRTUAL_TABLE + "'where '"+KEY_RADIO+"'='"+veh+"' ;";
            Cursor res = db.rawQuery(" select '"+KEY_ID +"'FROM '" + FTS_VIRTUAL_TABLE +"' where '"+KEY_RADIO+"'='"+veh+"' ;", null);
            int count=res.getCount();

            return count;
        }

       /* public boolean updateKey_Flsg(String searchID) throws SQLException {

            SQLiteDatabase db= this.getWritableDatabase();
            String str="0";
            String updateQuery="update FTS_VIRTUAL_TABLE set KEY_FLAG='"+str+"' where KEY_ID=searchID"+searchID;
            db.execSQL(updateQuery);
            ContentValues values=new ContentValues();
            values.put("KEY_FLAG","ထုတ္ယူၿပီး");
            int res=db.update(FTS_VIRTUAL_TABLE, values, "KEY_ID="+searchID,null);

              return true;

        }*/////////////phyo
    }

    public CustomersDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public CustomersDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }


    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }

    }

    public long createCustomer(String name, String plateno, String color, String date, String time, String flage, String radio) {

        ContentValues initialValues = new ContentValues();
        String searchValue = name + " " +
                plateno + " " + color + "" + date + "" + time + "" + flage;
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_PLATENO, plateno);
        initialValues.put(KEY_COLOR, color);
        initialValues.put(KEY_DATE, date);
        initialValues.put(KEY_TIME, time);
        initialValues.put(KEY_RADIO, radio);
        initialValues.put(KEY_FLAGE, flage);
        initialValues.put(KEY_SEARCH, searchValue);

        return mDb.insert(FTS_VIRTUAL_TABLE, null, initialValues);
    }


    public Cursor searchCustomerByBike(String inputText) throws SQLException {
        Log.w(TAG, inputText);
        cal = Calendar.getInstance();
        retrieve_date = new SimpleDateFormat("d-M-yyyy");
        String date = retrieve_date.format(cal.getTime());
        String motor = "ဆိုင္ကယ္";
        String key = "0";
        // String flage="0";
                /* String query = "SELECT docid as _id," +
                KEY_NAME + "," +
                KEY_PLATENO + "," +
                KEY_COLOR+","+KEY_DATE+","+KEY_TIME+","+KEY_RADIO+","+KEY_FLAGE+
                " from " + FTS_VIRTUAL_TABLE +
                " where " +  KEY_SEARCH + " MATCH '" + inputText +"' AND" +KEY_DATE+ "MATCH '"+ date+" ' AND" +KEY_RADIO+ "MATCH '"+bike+"';";*/
        String query = "SELECT docid as _id," +
                KEY_ID + "," +
                KEY_NAME + "," +
                KEY_PLATENO + "," +
                KEY_COLOR + "," + KEY_DATE + "," + KEY_TIME + "," + KEY_RADIO + "," + KEY_FLAGE +
                " from " + FTS_VIRTUAL_TABLE +
                " where " + KEY_SEARCH + " MATCH '" + inputText + "'  AND " + KEY_DATE + " = '" + date + "' AND " + KEY_RADIO + " = '" + motor + "' AND " + KEY_FLAGE + " = '" + key + "' ;";
        // AND" +KEY_DATE+ "MATCH '"+ date+" '' AND" +KEY_RADIO+ "MATCH '"+bike+"' AND " + KEY_RADIO  + " = '" + radio +"'
        Log.w(TAG, query);
        Cursor mCursor = mDb.rawQuery(query, null);
        // String query = "SELECT * FROM '"+CUSTOMER_TABLE+"' WHERE '"+KEY_NAME+"' LIKE '"+inputText+"' ";
        // Cursor mCursor = mDb.rawQuery(query,null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }



    public boolean deleteAllCustomers() {

        int doneDelete = 0;
        doneDelete = mDb.delete(FTS_VIRTUAL_TABLE, null, null);
        Log.w(TAG, Integer.toString(doneDelete));
        return doneDelete > 0;

    }

}