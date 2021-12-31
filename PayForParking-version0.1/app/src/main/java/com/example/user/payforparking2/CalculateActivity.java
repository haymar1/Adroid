package com.example.user.payforparking2;

        import android.app.DatePickerDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.Calendar;

public class CalculateActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_result;
    RadioButton CalBike,CalCar;
    RadioGroup CalradioGroup;
    String v_type=null;
    EditText txtDate;
    Button bt_Date;
    public int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        CalBike=(RadioButton)findViewById( R.id.CalBike);
        CalCar=(RadioButton)findViewById(R.id.CalCar);
        CalradioGroup=(RadioGroup)findViewById(R.id.CalradioGroup);
        txtDate= (EditText) findViewById(R.id.TxtDate);

        Button bt_calculate = (Button) findViewById(R.id.bt_Show);
        final Button bt_Date=(Button)findViewById(R.id.bt_Date);

        tv_result = (TextView) findViewById(R.id.tv_result);
       /*bt_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (v == bt_Date) {
                    final Calendar c = Calendar.getInstance();
                    mYear = c.get(Calendar.YEAR);
                    mMonth = c.get(Calendar.MONTH);
                    mDay = c.get(Calendar.DAY_OF_MONTH);
                    DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        }
                    })

                }
                  }
                  });
       */

        // Get Current Date




        bt_Date.setOnClickListener(this);
        bt_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedID=CalradioGroup.getCheckedRadioButtonId();
                if(selectedID!=-1){
                    RadioButton selectedRadioButton= (RadioButton) findViewById(selectedID);
                    v_type=selectedRadioButton.getText().toString();
                }
                int dailyIncome=0;
                String cal_date=txtDate.getText().toString();
                // Toast.makeText(CalculateActivity.this, "Show btn is click!!။"+cal_date, Toast.LENGTH_SHORT).show();
                //  CustomersDbAdapter.DatabaseHelper db=new CustomersDbAdapter.DatabaseHelper(CalculateActivity.this);
                CustomersDbAdapter adapter = new CustomersDbAdapter(view.getContext());
                adapter.open();

                int numOfV=adapter.getCountForVType(v_type,cal_date);
                // int numOfV=numOfVeh.getColumnIndexOrThrow("c");
                //  int numOfV =db.getCountForVType(v_type);
               /* if (cursor != null) {
                int numOfV=cursor.getColumnIndexOrThrow("numOfVehicle");*/
                if(v_type.equals("ဆိုင္ကယ္")){
                    dailyIncome=numOfV*200;

                }
                else {
                    dailyIncome = numOfV * 300;
                }
                tv_result.setText(v_type+" အတြက္ေန႕စဥ္၀င္ေငြ ="+dailyIncome);
            }




        });
    }

    @Override
    public void onClick(View v) {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
        //Toast.makeText(CalculateActivity.this, "Date btn is click!!။"+txtDate.getText().toString(), Toast.LENGTH_SHORT).show();


    }

    /*private void makeCalculations() {
        // I'm assuming you're getting numbers.


        // Do your calculation here.
        // I'm assuming you have inserted the result on a variable called 'result'. Like: double result
       // double result = ((double) n1*n2);
        tv_result.setText("Total Income is: " + result);
    }*/

    // The rest of your Activity and methods.

}

