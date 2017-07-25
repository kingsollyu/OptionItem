/*
 * Copyright 2017 Sollyu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sollyu.android.option.item.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sollyu.android.option.item.OptionItemEdit;
import com.sollyu.android.option.item.OptionItemSwitch;
import com.sollyu.android.option.item.OptionItemView;

public class MainActivity extends AppCompatActivity {

    private OptionItemView   mOivAbout  = null;
    private OptionItemSwitch mOivSwitch = null;
    private OptionItemEdit   mOivEdit   = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        mOivAbout  = (OptionItemView) findViewById(R.id.oivAbout);
        mOivSwitch = (OptionItemSwitch) findViewById(R.id.oisSwitch);
        mOivEdit   = (OptionItemEdit) findViewById(R.id.oieEdit);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Snackbar.make(mOivAbout, mOivAbout.getLeftText(), Snackbar.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickTest(View view) {
        Toast.makeText(this, "点击测试", Toast.LENGTH_SHORT).show();
    }

    public void onClickSwitch(View view) {
        Toast.makeText(this, "开关: " + mOivSwitch.isChecked() , Toast.LENGTH_SHORT).show();
    }

    public void onClickSettings(View view) {
    }

    public void onClickEdit(View view) {
        Toast.makeText(this, "输入内容: " + mOivEdit.getRightEditText() , Toast.LENGTH_SHORT).show();
    }
}
