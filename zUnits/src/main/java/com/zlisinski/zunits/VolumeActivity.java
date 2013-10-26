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

import com.zlisinski.zunits.volumeUnits.AbstractVolumeUnit;
import com.zlisinski.zunits.volumeUnits.Liter;
import com.zlisinski.zunits.volumeUnits.VolumeTypes;


public class VolumeActivity extends Activity {

    EditText mainValue;
    Spinner mainUnitSpinner;
    AbstractVolumeUnit curUnit;
    TableLayout resultsTable;
    TextView[] resultUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        // Show the Up button in the action bar.
        setupActionBar();

        mainValue = (EditText)findViewById(R.id.mainValue);
        mainUnitSpinner = (Spinner)findViewById(R.id.mainUnit);
        resultsTable = (TableLayout)findViewById(R.id.resultsTable);

        curUnit = new Liter("1");

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
        getMenuInflater().inflate(R.menu.volume, menu);
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
        String[] labels = new String[VolumeTypes.values().length];

        for (VolumeTypes type : VolumeTypes.values()) {
            labels[type.ordinal()] = type.getDisplayName();
        }

        return labels;
    }

    /**
     * Loops through all DistanceTypes and adds TableRows for each type.
     */
    protected void addResultRows() {
        resultUnits = new TextView[VolumeTypes.values().length];

        for (VolumeTypes type : VolumeTypes.values()) {
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
                VolumeTypes curType = VolumeTypes.values()[position];

                // Use Reflection to instantiate an instance of the selected class. This should never fail, but if it does, just return
                try {
                    curUnit = (AbstractVolumeUnit)curType.getClassName().getConstructor(String.class).newInstance(mainValue.getText().toString());
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
        mainUnitSpinner.setSelection(VolumeTypes.liter.ordinal());
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
        resultUnits[VolumeTypes.milliliter.ordinal()].setText(curUnit.toMilliliter().toString());
        resultUnits[VolumeTypes.cubicCentimeters.ordinal()].setText(curUnit.toCubicCentimeter().toString());
        resultUnits[VolumeTypes.liter.ordinal()].setText(curUnit.toLiter().toString());
        resultUnits[VolumeTypes.cubicInch.ordinal()].setText(curUnit.toCubicInch().toString());
        resultUnits[VolumeTypes.gallonUS.ordinal()].setText(curUnit.toGallonUS().toString());
        //resultUnits[VolumeTypes..ordinal()].setText(curUnit.to().toString());
    }
}
