package com.zlisinski.zunits;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.zlisinski.zunits.distanceUnits.AbstractDistanceUnit;
import com.zlisinski.zunits.distanceUnits.DistanceTypes;
import com.zlisinski.zunits.distanceUnits.Meter;

public class DistanceActivity extends Activity {

    EditText mainValue;
    Spinner mainUnitSpinner;
    AbstractDistanceUnit curUnit;
    TableLayout resultsTable;
    TextView[] resultUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        // Show the Up button in the action bar.
        //setupActionBar();

        mainValue = (EditText)findViewById(R.id.mainValue);
        mainUnitSpinner = (Spinner)findViewById(R.id.mainUnit);
        resultsTable = (TableLayout)findViewById(R.id.resultsTable);

        curUnit = new Meter("1");

        addResultRows();
        setupMainUnitSpinner();
        setMainValueEvents();

        mainValue.setText(curUnit.getValue().toString());
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setupActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.distance, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. Use NavUtils to allow users
                // to navigate up one level in the application structure. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back
                //
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Creates an array of DistanceType labels for the Spinner Adapter.
     * @return An array of unit labels.
     */
    protected String[] getUnitLabels() {
        String[] labels = new String[DistanceTypes.values().length];

        for (DistanceTypes type : DistanceTypes.values()) {
            labels[type.ordinal()] = type.getDisplayName();
        }

        return labels;
    }

    /**
     * Loops through all DistanceTypes and adds TableRows for each type.
     */
    protected void addResultRows() {
        resultUnits = new TextView[DistanceTypes.values().length];

        for (DistanceTypes type : DistanceTypes.values()) {
            int i = type.ordinal();

            // Create TableRow
            TableRow row = new TableRow(this);

            // Create label TextView
            TextView label = new TextView(this);
            label.setText(type.getDisplayName());
            row.addView(label);

            // Create result TextView
            resultUnits[i] = new TextView(this);
            resultUnits[i].setText("0"); // This gets set later once the mainValue is set
            row.addView(resultUnits[i]);

            // Add row to table
            resultsTable.addView(row);
        }
    }

    /**
     * Sets up the mainUnitSpinner Spinner(Dropdown menu).
     */
    protected void setupMainUnitSpinner() {
        // Setup the Adapter to populate the Spinner
        ArrayAdapter<String> unitsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, getUnitLabels());
        unitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainUnitSpinner.setAdapter(unitsAdapter);

        // Add the event handlers
        mainUnitSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            // Event handler when a unit is selected
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Get the DistanceType from the selected index of the Spinner
                DistanceTypes curType = DistanceTypes.values()[position];

                // Use Reflection to instantiate an instance of the selected class. This should never fail, but if it does, just return
                try {
                    curUnit = (AbstractDistanceUnit)curType.getClassName().getConstructor(String.class).newInstance(mainValue.getText().toString());
                }
                catch (Exception e) {
                    Log.v("spinner", e.toString());
                    return;
                }

                // Update results TextViews with new values
                updateUnits();
            }

            // This event handler is not currently used
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Set starting unit to Meters
        mainUnitSpinner.setSelection(DistanceTypes.meter.ordinal());
    }

    /**
     * Set up event handlers for mainValue EditText
     */
    protected void setMainValueEvents() {
        mainValue.addTextChangedListener(new TextWatcher() {

            // Event handler for when text changes in mainValue
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String value = s.toString();

                // set value to "0" if it is empty
                if (value.equals(""))
                    value = "0";

                // append a "0" if number ends in a dot
                if (value.endsWith("."))
                    value = value + "0";

                // Update curUnit with value from EditText
                curUnit.setValue(value);

                // Update results TextViews with new values
                updateUnits();
            }

            // Unused
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            // Unused
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    /**
     * Updates results TextViews
     */
    protected void updateUnits() {
        resultUnits[DistanceTypes.angstrom.ordinal()].setText(curUnit.toAngstrom().toString());
        resultUnits[DistanceTypes.nanometer.ordinal()].setText(curUnit.toNanometer().toString());
        resultUnits[DistanceTypes.micrometer.ordinal()].setText(curUnit.toMicrometer().toString());
        resultUnits[DistanceTypes.millimeter.ordinal()].setText(curUnit.toMillimeter().toString());
        resultUnits[DistanceTypes.centimeter.ordinal()].setText(curUnit.toCentimeter().toString());
        resultUnits[DistanceTypes.meter.ordinal()].setText(curUnit.toMeter().toString());
        resultUnits[DistanceTypes.kilometer.ordinal()].setText(curUnit.toKilometer().toString());
        resultUnits[DistanceTypes.mil.ordinal()].setText(curUnit.toMil().toString());
        resultUnits[DistanceTypes.inch.ordinal()].setText(curUnit.toInch().toString());
        resultUnits[DistanceTypes.foot.ordinal()].setText(curUnit.toFoot().toString());
        resultUnits[DistanceTypes.yard.ordinal()].setText(curUnit.toYard().toString());
        resultUnits[DistanceTypes.fathom.ordinal()].setText(curUnit.toFathom().toString());
        resultUnits[DistanceTypes.statuteMile.ordinal()].setText(curUnit.toStatuteMile().toString());
        resultUnits[DistanceTypes.nauticalMile.ordinal()].setText(curUnit.toNauticalMile().toString());
        resultUnits[DistanceTypes.rod.ordinal()].setText(curUnit.toRod().toString());
        resultUnits[DistanceTypes.chain.ordinal()].setText(curUnit.toChain().toString());
        resultUnits[DistanceTypes.furlong.ordinal()].setText(curUnit.toFurlong().toString());
        resultUnits[DistanceTypes.astronomicalUnit.ordinal()].setText(curUnit.toAstronomicalUnit().toString());
    }
}
