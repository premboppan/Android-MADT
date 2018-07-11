package com.example.macstudent.myapplication.Acitvities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.example.macstudent.myapplication.Vehicle.Motorcycle;

/**
 * Created by ADMIN on 7/10/2018.
 */

public class EmployeeActivity EmployeeActivities extends AppCompatActivity {

    @BindView(R.id.edtName)
    EditText edtName;
    @BindView(R.id.edtDob)
    EditText edtDob;
    @BindView(R.id.chkVehicle)
    CheckBox chkVehicle;
    @BindView(R.id.rbCar)
    RadioButton rbCar;
    @BindView(R.id.rbMotorcycle)
    RadioButton rbMotorcycle;
    @BindView(R.id.rgbVehicle)
    RadioGroup rgbVehicle;
    @BindView(R.id.linearVehicle)
    LinearLayout linearVehicle;
    @BindView(R.id.imgModel)
    ImageView imgModel;
    @BindView(R.id.edtModel)
    EditText edtModel;
    @BindView(R.id.edtplate)
    EditText edtplate;
    @BindView(R.id.relativeVehicleInfo)
    RelativeLayout relativeVehicleInfo;
    @BindView(R.id.rbParttime)
    RadioButton rbParttime;
    @BindView(R.id.rbIntern)
    RadioButton rbIntern;
    @BindView(R.id.rbFulltime)
    RadioButton rbFulltime;
    @BindView(R.id.rgbEmployeeType)
    RadioGroup rgbEmployeeType;
    @BindView(R.id.linearEmpType)
    LinearLayout linearEmpType;
    @BindView(R.id.edtHours)
    EditText edtHours;
    @BindView(R.id.edtRate)
    EditText edtRate;
    @BindView(R.id.chkFixedOrCommission)
    CheckBox chkFixedOrCommission;
    @BindView(R.id.edtCommissionPerOrFixedAmt)
    EditText edtCommissionPerOrFixedAmt;
    @BindView(R.id.linearFixedOrCommission)
    LinearLayout linearFixedOrCommission;
    @BindView(R.id.linearParttime)
    LinearLayout linearParttime;
    @BindView(R.id.edtSchoolName)
    EditText edtSchoolName;
    @BindView(R.id.linearIntern)
    LinearLayout linearIntern;
    @BindView(R.id.edtSalary)
    EditText edtSalary;
    @BindView(R.id.edtBonus)
    EditText edtBonus;
    @BindView(R.id.linearFulltime)
    LinearLayout linearFulltime;
    @BindView(R.id.btnSavePayroll)
    Button btnSavePayroll;
    @BindView(R.id.linearMain)
    LinearLayout linearMain;
    Unbinder unbinder;

    String name;
    int age = 0;
    String department;
    double rate;
    double hoursWorked;
    double salary;
    double bonus;
    String schoolName;
    double commisionPer;
    double fixedAmount;
    int manufacturingYear;

    Employee employee = null;
    Vehicle vehicle = null;
    Employee Employee = new Employee(EmployeeActivities.this);
    Bundle bundle= new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        ButterKnife.bind(this);

        linearVehicle.setVisibility(View.GONE);
        relativeVehicleInfo.setVisibility(View.GONE);
        linearParttime.setVisibility(View.GONE);
        linearIntern.setVisibility(View.GONE);
        linearFulltime.setVisibility(View.GONE);

    }

    @OnClick(R.id.chkVehicle)
    public void onChkVehicleClicked()
    {
        rgbEmployeeType.setVisibility(View.VISIBLE);
        if (chkVehicle.isChecked())
        {
            linearVehicle.setVisibility(View.VISIBLE);
            relativeVehicleInfo.setVisibility(View.VISIBLE);
        }
        else
        {
            linearVehicle.setVisibility(View.GONE);
            relativeVehicleInfo.setVisibility(View.GONE);
        }
    }

    @OnCheckedChanged({R.id.rbParttime, R.id.rbIntern, R.id.rbFulltime})
    public void onEmployeeTypeChanged(CompoundButton radioButton, boolean checked)
    {
        //boolean checked = radioButton.isChecked();

        if (checked)
        {
            linearParttime.setVisibility(View.GONE);
            linearIntern.setVisibility(View.GONE);
            linearFulltime.setVisibility(View.GONE);
            switch (radioButton.getId())
            {
                case R.id.rbParttime:
                    linearParttime.setVisibility(View.VISIBLE);
                    break;

                case R.id.rbIntern:
                    linearIntern.setVisibility(View.VISIBLE);

                    break;

                case R.id.rbFulltime:
                    linearFulltime.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    @OnClick(R.id.chkFixedOrCommission)
    public void onChkFixedOrCommissionChecked()
    {
        if (chkFixedOrCommission.isChecked())
        {
            edtCommissionPerOrFixedAmt.setHint("Enter Fixed Commission Percentage");
        }
        else
        {
            edtCommissionPerOrFixedAmt.setHint("Enter Fixed Commission Amount");
        }
    }

//    public static void startIntent(Context context, Bundle bundle) {
//        Intent mIntent = new Intent(context, MainTabActivity.class);
//        mIntent.putExtras(bundle);
//        context.startActivity(mIntent);
//    }

    @OnClick(R.id.btnSavePayroll)
    public void onViewClicked() {

        bundle.putSerializable("employee", addData());
        Log.d("DataEntry", "2");
        Employee.insertEmployee(addData());
        Log.d("DataEntry", "3");
        //dbEmployee.getAllUser(employee);
        Intent mIntent = new Intent(EmployeeActivity.this, Activity.class);
        Log.d("DataEntry", "4");
        mIntent.putExtras(bundle);
        EmployeeActivity.this.startActivity(mIntent);

    }

    public Employee addData(){

        if (chkVehicle.isChecked()){
            if (rbCar.isChecked()){
                Car car = new Car();
                car.setCompany(edtModel.getText().toString());
                car.setPlate(edtplate.getText().toString());
                car.setColour("black");
                car.setYear(2015);
                //employee.setVehicle(car);
                vehicle = car;
                Log.d("DataEntry", "car");
            }
            if (rbMotorcycle.isChecked()){
                Motorcycle Motorcycle = new Motorcycle();
                Motorcycle.setCompany(edtModel.getText().toString());
                Motorcycle.setPlate(edtplate.getText().toString());
                Motorcycle.setColour("black");
                Motorcycle.setYear(2015);
                //employee.setVehicle(motorcycle);
                vehicle = Motorcycle;
                Log.d("DataEntry", "motorcycle");
            }
        }
        if (rbIntern.isChecked()){
            name = edtName.getText().toString();
            age = Integer.parseInt(edtDob.getText().toString());
            schoolName = edtSchoolName.getText().toString();
            Log.d("DataEntry", schoolName);
            Intern intern = new Intern();
            intern.setName(name);
            intern.setSchoolName(schoolName);
            intern.setCalBirthYear(age);
            Employee = intern;
            Employee.setVehicle(vehicle);
            Employee.calEarnings();
            Employee.setEmployee("Intern");
            Log.d("DataEntry", "Intern");
        }
        if (rbFulltime.isChecked()){
            name = edtName.getText().toString();
            age = Integer.parseInt(edtDob.getText().toString());
            salary = Double.parseDouble(edtSalary.getText().toString());
            bonus = Double.parseDouble(edtBonus.getText().toString());
            FullTime fullTime = new FullTime(name, age, salary, bonus);
            fullTime.setName(name);
            fullTime.setAge(age);
            fullTime.setSalary(salary);
            fullTime.setBonus(bonus);
            Employee = FullTime;
            Employee.setVehicle(vehicle);
            Employee.setEmployee("FullTime");
            Employee.calEarnings();
            Log.d("DataEntry", "Fulltime");
        }
        if (rbParttime.isChecked()){
            if (chkFixedOrCommission.isChecked())
            {
                name = edtName.getText().toString();
                age = Integer.parseInt(edtDob.getText().toString());
                rate = Double.parseDouble(edtRate.getText().toString());
                hoursWorked = Double.parseDouble(edtHours.getText().toString());
                commisionPer = Double.parseDouble(edtCommissionPerOrFixedAmt.getText().toString());
                CommissionBasedPartTime com = new CommissionBasedPartTime();
                com.setName(name);
                com.setAge(age);
                com.setRate(rate);
                com.setHoursWorked(hoursWorked);
                com.setCommissionPercentage(commisionPer);
                Employee = com;
                Employee.setVehicle(vehicle);
                Employee.calEarnings();
                Employee.setEmployee("Commission based");
                Log.d("DataEntry", "com");
            }else
            {
                name = edtName.getText().toString();
                age = Integer.parseInt(edtDob.getText().toString());
                rate = Double.parseDouble(edtRate.getText().toString());
                hoursWorked = Double.parseDouble(edtHours.getText().toString());
                fixedAmount = Double.parseDouble(edtCommissionPerOrFixedAmt.getText().toString());
                FixedBasedPartTime fixedBasedPartTime = new FixedBasedPartTime(name, age, rate, hoursWorked, fixedAmount);
                fixedBasedPartTime.setName(name);
                fixedBasedPartTime.setAge(age);
                fixedBasedPartTime.setRate(rate);
                fixedBasedPartTime.setHoursWorked(hoursWorked);
                fixedBasedPartTime.setFixedAmount(fixedAmount);
                Employee = fixedBasedPartTime;
                Employee.setVehicle(vehicle);
                Employee.calEarnings();
                Employee.setEmployee("Fixed based");
                Log.d("DataEntry", "Fix");
            }
        }
        Log.d("DataEntry", "0");
        return employee;
    }
}


