package codebrains.crazysellout.Activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import codebrains.crazysellout.Adapters.ProducerTabsAdapter;
import codebrains.crazysellout.Fragments.AddItemsFragment;
import codebrains.crazysellout.R;


public class MainProducerActivity extends ActionBarActivity implements  android.support.v7.app.ActionBar.TabListener {

    private ViewPager tabsviewPager;
    private ProducerTabsAdapter mTabsAdapter;
    private AddItemsFragment aif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_producer);

        this.aif = new AddItemsFragment();

        tabsviewPager = (ViewPager) findViewById(R.id.tabspager);
        mTabsAdapter = new ProducerTabsAdapter(getSupportFragmentManager());
        tabsviewPager.setAdapter(mTabsAdapter);

        this.getSupportActionBar().setHomeButtonEnabled(false);
        this.getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab addProductsTab = getSupportActionBar().newTab().setText("Add Products").setTabListener(this);
        ActionBar.Tab myProductsTab = getSupportActionBar().newTab().setText("My Products").setTabListener(this);
        ActionBar.Tab productsTab = getSupportActionBar().newTab().setText("Products").setTabListener(this);

        getSupportActionBar().addTab(addProductsTab);
        getSupportActionBar().addTab(myProductsTab);
        getSupportActionBar().addTab(productsTab);

        //This helps in providing swiping effect for v7 compat library
        tabsviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    /**
     * Event click that occurs whenever the submit button on add new item freagment is clicked.
     *
     * @param view The view of the activity.
     */

    public void AddNewProductProcess(View view){
        this.aif.AddNewProductProcess();
    }

    public void GetCoordinationsProcess(View view){
        this.aif.GetCoordinationsProcess(this);
    }

}