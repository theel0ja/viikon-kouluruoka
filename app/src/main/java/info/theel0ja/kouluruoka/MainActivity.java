package info.theel0ja.kouluruoka;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // https://guides.codepath.com/android/Google-Play-Style-Tabs-using-TabLayout#design-support-library

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    /*
    // Switch page
    public void switchPage(View view) {

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        if(currentPage == 0) {
            currentPage = 1;
            // set back button
            fab.setImageResource(R.drawable.ic_arrow_back_white_24dp);
        }
        else {
            currentPage = 0;
            // set forward button
            fab.setImageResource(R.drawable.ic_arrow_forward_white_24dp);
        }


        mWebView = (WebView) findViewById(R.id.webview);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 4.0.3 and up - Use https version
        // 4.0.3 and down - Use non-https version
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            mWebView.loadUrl("https://" + backendURL + "/" + currentSchool + "/?app&material&lang=" + java.util.Locale.getDefault().getLanguage() + "&q=" + currentPage + "&buttons=1");
        }
        else {
            mWebView.loadUrl("http://" + backendURL + "/" + currentSchool + "/?app&material&lang=" + java.util.Locale.getDefault().getLanguage() + "&q=" + currentPage + "&buttons=1");
        }
    }
    */

    // TODO ^: do that


    // Initialize menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    // Buttons of menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_archives:
                // User chose the "Settings" item, show the app settings UI...
                Intent i_archives = new Intent(this, Archives.class);
                startActivity(i_archives);

                return true;

            /*case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Intent i_settings = new Intent(this, Settings.class);
                startActivity(i_settings);

                return true;*/

            case R.id.action_about:
                // User chose the "Settings" item, show the app settings UI...
                Intent i_about = new Intent(this, About.class);
                startActivity(i_about);

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
/*
    // back-button is goback in webview
    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
*/

// TODO ^: Move that to PageFragment.java etc, it's not working here...
}