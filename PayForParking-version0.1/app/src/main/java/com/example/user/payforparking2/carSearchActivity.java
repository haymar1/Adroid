package com.example.user.payforparking2;


        import java.util.Calendar;

        import android.app.Activity;
        import android.content.ContentValues;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.support.v7.app.AlertDialog;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.LinearLayout;
        import android.widget.ListView;
        import android.widget.RadioButton;
        import android.widget.SearchView;
        import android.widget.SimpleCursorAdapter;
        import android.widget.TextView;
        import android.widget.AdapterView.OnItemClickListener;
        import android.widget.Toast;
        import static com.example.user.payforparking2.CustomersDbAdapter.KEY_COLOR;
        import static com.example.user.payforparking2.CustomersDbAdapter.KEY_DATE;
        import static com.example.user.payforparking2.CustomersDbAdapter.KEY_ID;
        import static com.example.user.payforparking2.CustomersDbAdapter.KEY_NAME;
        import static com.example.user.payforparking2.CustomersDbAdapter.KEY_PLATENO;
        import static com.example.user.payforparking2.CustomersDbAdapter.KEY_TIME;


public class carSearchActivity extends Activity implements SearchView.OnQueryTextListener,
        SearchView.OnCloseListener {

    private ListView mListView;
    private SearchView searchView;
    public CustomersDbAdapter mDbHelper;
    public SQLiteDatabase sqLiteDatabase;

    public String searchID = null;
    public TextView idText, nameText, plateText, colorText, dateText, timeText, flageText, radioText;
    public Cursor cursor;
    String stringID;

    CustomersDbAdapter.DatabaseHelper myDb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_car_search);

        searchView = (SearchView) findViewById(R.id.searchCar);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(this);

        mListView = (ListView) findViewById(R.id.list);
        // inspectionDate = (TextView) findViewById( R.id.inspectionDate );
        //displayDate();
        mDbHelper = new CustomersDbAdapter(this);
        mDbHelper.open();

       /* mDbHelper.createCustomer( "Ma Ma","MA MA","TGI/123345","RED" );
        mDbHelper.createCustomer( "Hay Mar","HAR MAR","TGI/123345","RED" );
        mDbHelper.createCustomer( "Phyo","PHYO","TGI/123345","RED" );*/////////////////Phyo static data insert

    }


    protected void onDestroy() {
        super.onDestroy();
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }

    public boolean onQueryTextChange(String newText) {
        //showResults(newText + "*");
        showResults(newText);
        return false;
    }

    public boolean onQueryTextSubmit(String query) {
        //showResults(query + "*");
        showResults(query);
        return false;
    }

    public boolean onClose() {
        showResults("");
        return false;
    }

    private void showResults(String query) {


        cursor = mDbHelper.searchCustomerByCar((query != null ? query.toString() : "@@@@"));
        //cursor1 = mDbHelper.searchCustomerID(query != null ? query.toString() : "@@@@");

        if (cursor == null) {

        } else {
            // searchID = cursor.getString(cursor.getColumnIndex("id"));
            // Specify the columns we want to display in the result
            String[] from = new String[]{
                    // KEY_ID,
                    KEY_NAME,
                    KEY_PLATENO,
                    KEY_COLOR,
                    KEY_DATE,
                    KEY_TIME,
                    //KEY_RADIO,
                    // KEY_FLAGE
            };


            // Specify the Corresponding layout elements where we want the columns to go
            int[] to = new int[]{
                    // R.id.id,////////////by phyo add id
                    R.id.name,
                    R.id.plateno,
                    R.id.color,
                    R.id.date,
                    R.id.time,
                    //////////////////////By hyo (3_9_19)
                    // R.id.radio,
                    //R.id.flage
            };


            // Create a simple cursor adapter for the definitions and apply them to the ListView
            SimpleCursorAdapter customers = new SimpleCursorAdapter(this, R.layout.customerresult, cursor, from, to);
            mListView.setAdapter(customers);
            stringID = KEY_ID;
            // Define the on-click listener for the list items
            mListView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                    // Get the cursor, positioned to the corresponding row in the result set
                    Cursor cursor = (Cursor) mListView.getItemAtPosition(position);
                    // Get the state's capital from this row in the database.
                    String ID = cursor.getString(cursor.getColumnIndexOrThrow("id"));
                    String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                    String plateno = cursor.getString(cursor.getColumnIndexOrThrow("plateno"));
                    String color = cursor.getString(cursor.getColumnIndexOrThrow("color"));
                    String date = cursor.getString(cursor.getColumnIndexOrThrow("date"));
                    String time = cursor.getString(cursor.getColumnIndexOrThrow("time"));
                    String radio = cursor.getString(cursor.getColumnIndexOrThrow("radio"));
                    String f = cursor.getString(cursor.getColumnIndexOrThrow("flage"));
                    String flage = null;
                    if (f.equals("0")) flage = "မထုတ္ယူရေသးပါ။";

                   /* //Check if the Layout already exists
                    LinearLayout customerLayout = (LinearLayout) findViewById(R.id.customerLayout);
                    if (customerLayout == null) {
                        //Inflate the Customer Information View
                        //  to night  LinearLayout leftLayout = (LinearLayout)findViewById(R.id.rightLayout);
                        // View customerInfo = getLayoutInflater().inflate(R.layout.customerinfo, leftLayout, false);
                        //leftLayout.addView(customerInfo); to night(29)
                    }*/


                    //Get References to the TextViews
                    // idText = (TextView) findViewById(R.id.tid);
                    nameText = (TextView) findViewById(R.id.tname);
                    plateText = (TextView) findViewById(R.id.tplateno);
                    colorText = (TextView) findViewById(R.id.tcolor);
                    dateText = (TextView) findViewById(R.id.tdate);
                    timeText = (TextView) findViewById(R.id.ttime);
                    //  flageText = (TextView) findViewById(R.id.tflage);
                    //  radioText = (TextView) findViewById(R.id.tradio);


                    // Update the parent class's TextView
                    // idText.setText(ID);
                    nameText.setText(name);
                    plateText.setText(plateno);
                    colorText.setText(color);
                    dateText.setText(date);
                    timeText.setText(time);
                    //  flageText.setText(flage);
                    // radioText.setText(radio);

                    //stringID=idText.getText().toString();


                    searchView.setQuery("", true);


                }
            });

            mListView.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, final View view, final int position, final long id) {
                    //String selectedItem = (String) parent.getItemAtPosition(position);
                    new AlertDialog.Builder(carSearchActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setMessage("ထုတ္ယူမည္?!")
                            .setTitle("")
                            .setPositiveButton("ထုတ္ယူရန္", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    //CMA(3.9.19
                                    CustomersDbAdapter.DatabaseHelper db = new CustomersDbAdapter.DatabaseHelper(null);

                                    CustomersDbAdapter adapter = new CustomersDbAdapter(view.getContext());
                                    adapter.open();
                                    // Get the state's capital from this row in the database.

                                    // Get the state's capital from this row in the database.

                                    adapter.updateFlag(stringID);
                                    //CMA(3.9.19
                                    // (update_cma)

                                    //boolean bool=db.updateKey_Flsg("1");
                                    // if(bool==true)
                                    Toast.makeText(carSearchActivity.this, "ထုတ္ယူပါမည္။", Toast.LENGTH_SHORT).show();


                                }

                            })
                            .setNegativeButton("ေငြရွင္းရန္", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent cinemaIntent = new Intent(carSearchActivity.this, PaymentActivity.class);
                                    startActivity(cinemaIntent);
                                }
                            })
                            .show();

                }

            });

        }


    }
   /* public String setStatus(String selected) {
        SQLiteDatabase sqldb;
        sqldb = this.getWritableDatabase();
        sqldb.execSQL("UPDATE TABLE_PEOPLE SET ISSELECTED=1 WHERE id=" + selected);
        sqldb.close();
        return "Anything you want";
    }
*/

/*
    public void getID() {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show message
            //showMessage("Error", "Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :" + res.getString(0) + "\n");
                            */
/*buffer.append("အမည္" + res.getString(1) + "\n");
                            buffer.append("လိုင္စင္နံပါတ္ :" + res.getString(2) + "\n");
                            buffer.append("အေရာင္ :" + res.getString(3) + "\n");
                            buffer.append("ရက္စြဲ:" + res.getString(4) + "\n");
                            buffer.append("အခ်ိန္:" + res.getString(5) + "\n");
                            buffer.append("ထုတ္ယူမႈအမွတ္အသား:" + res.getString(6) + "\n");
                            buffer.append("ယဥ္အမ်ိဳးအစား:" + res.getString(7) + "\n\n");
*//*

            String stringID = buffer.toString();

            //   buffer.append("Time :"+ res.getString(5)+"\n\n");

        }

        // Show all data
        //showMessage("Data", buffer.toString());


    }
*/

}