package com.example.user.payforparking2;


        import android.annotation.SuppressLint;
        import android.content.ContentValues;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.database.sqlite.SQLiteDatabase;
        import android.provider.MediaStore;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.AlertDialog;
        import android.database.Cursor;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.SearchView;
        import android.widget.Toast;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    }

    CustomersDbAdapter.DatabaseHelper myDb;
    EditText editName, editplate, editcolor, edittime, editdate, editTextId;
    StringBuffer buffer = new StringBuffer();
    SearchView searchView;Button btnAll;
    Intent intent;
    RadioButton radioCar,radioBike,rdoButton;
    public String v_type;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        myDb = new CustomersDbAdapter.DatabaseHelper(this);
        editName = (EditText) findViewById( R.id.editText_name);
        editplate = (EditText) findViewById(R.id.editText_plate);
        editcolor = (EditText) findViewById(R.id.edtcolor);
        // btnAll = (Button) findViewById(R.id.ShowAll);
        final RadioGroup rg= (RadioGroup) findViewById(R.id.radioGroup);
        // rg.setOnCheckedChangeListener(this);
        //////////////////////////radio group declaration
              /*radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
           public void onCheckedChanged(RadioGroup group, int checkedId) {
               int selectedRadioButtonID = radioGroup.getCheckedRadioButtonId();

               // If nothing is selected from Radio Group, then it return -1
               if (selectedRadioButtonID != -1) {

                   RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                   String selectedRadioButtonText = selectedRadioButton.getText().toString();

                   radioBike.setText("Bike");
               }
               else{
                   radioCar.setText( "Car");
               }
           }

       });*/

        // radioGroupGender.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) this);
        // viewAll();


        Button more = (Button) findViewById(R.id.go);
        more.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Intent myIntent = new Intent( view.getContext(), MainActivity.class );
                // startActivityForResult( myIntent, 0 );

                int selectedID=rg.getCheckedRadioButtonId();
                if(selectedID!=-1){
                    RadioButton selectedRadioButton= (RadioButton) findViewById(selectedID);
                    v_type=selectedRadioButton.getText().toString();
                }

                final AlertDialog.Builder builder = new AlertDialog.Builder(InsertActivity.this);

                builder.setMessage("this is message");
                builder.setTitle("အသိေပးခ်က္");

                //Setting message manually and performing action on button click
                builder.setMessage("သိမ္းဆည္းရန္ေသခ်ာပါသလား?");

                //This will not allow to close dialogbox until user selects an option
                builder.setCancelable(false);

                builder.setPositiveButton("လုပ္မည္", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                boolean isInserted = myDb.insertData(

                                        // editTextId.getText().toString(),
                                        editName.getText().toString(),
                                        editplate.getText().toString(),
                                        editcolor.getText().toString(),
                                        // radioGroup.getCheckedRadioButtonId().getText().ToString()
                                        v_type

                                );

                                if (isInserted == true) {
                                    ClearData();
                                    Toast.makeText(InsertActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();

                                } else {
                                    Toast.makeText(InsertActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                );

                builder.setNegativeButton("မလုပ္ပါ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //  Action for 'NO' Button
                        Toast.makeText(InsertActivity.this, "သင့္၏အခ်က္အလက္မ်ားျပင္ဆင္ရန္", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                //alert.setTitle("AlertDialogExample");
                alert.show();
            }

        });



    }

    ////////////////////////////////////////////////radio



    /* public void viewAll() {
             btnAll.setOnClickListener(
                     new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             Cursor res = myDb.getAllData();
                             if(res.getCount() == 0) {
                                 // show message
                                 showMessage("Error","Nothing found");
                                 return;
                             }

                             StringBuffer buffer = new StringBuffer();
                             while (res.moveToNext()) {
                                 buffer.append("Id :"+ res.getString(0)+"\n");
                                 buffer.append("အမည္"+res.getString(1)+"\n");
                                 buffer.append("လိုင္စင္နံပါတ္ :"+ res.getString(2)+"\n");
                                 buffer.append("အေရာင္ :"+ res.getString(3)+"\n");
                                 buffer.append("ရက္စြဲ:"+ res.getString(4)+"\n");
                                 buffer.append("အခ်ိန္:"+ res.getString(5)+"\n");
                                 buffer.append("ထုတ္ယူမႈအမွတ္အသား:"+ res.getString(6)+"\n");
                                 buffer.append("ယဥ္အမ်ိဳးအစား:"+ res.getString(7)+"\n\n");



                                 //   buffer.append("Time :"+ res.getString(5)+"\n\n");

                             }

                             // Show all data
                             showMessage("Data",buffer.toString());



                         }
                     });
         }

 */
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    private void ClearData(){
        editName.setText("");
        editplate.setText("");
        editcolor.setText("");

    }

    /*@Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int radioButtonId=radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton= (RadioButton) radioGroup.findViewById(radioButtonId);
        v_type=radioButton.getText().toString();
    }*/
    //////////////////////////////radio method
   /* public void setupUI() {

         radioCar = (RadioButton) findViewById(R.id.radioCar);
         radioBike = (RadioButton) findViewById(R.id.radioBike);
        if (motor.equals("radioCar")) {
            radioCar.setChecked(true);
        } else if (motor.equals("radioBike")) {
            radioBike.setChecked(true);
        } else {
            radioCar.setChecked(false);
            radioBike.setChecked(false);
        }


    }
*/
}


