package info.theel0ja.kouluruoka;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mWebView = (WebView) findViewById(R.id.webview);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Use remote resource
        // 4.0.3 and up - Use https version
        // 4.0.3 and down - Use non-https version
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            mWebView.loadUrl("https://viikon-kouluruoka.theel0ja.info/turku/alakoulu/?app&lang=" + java.util.Locale.getDefault().getLanguage());
        }
        else {
            mWebView.loadUrl("http://viikon-kouluruoka.theel0ja.info/turku/alakoulu?app&lang=" + java.util.Locale.getDefault().getLanguage());
        }

    }

    // Buttons
    public void ElementarySchool(View view) {
        mWebView = (WebView) findViewById(R.id.webview);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 4.0.3 and up - Use https version
        // 4.0.3 and down - Use non-https version
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            mWebView.loadUrl("https://viikon-kouluruoka.theel0ja.info/turku/alakoulu/?app&lang=" + java.util.Locale.getDefault().getLanguage());
        }
        else {
            mWebView.loadUrl("http://viikon-kouluruoka.theel0ja.info/turku/alakoulu?app&lang=" + java.util.Locale.getDefault().getLanguage());
        }
    }

    public void SecondarySchool(View view) {
        mWebView = (WebView) findViewById(R.id.webview);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new WebViewClient());

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 4.0.3 and up - Use https version
        // 4.0.3 and down - Use non-https version
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
            mWebView.loadUrl("https://viikon-kouluruoka.theel0ja.info/turku/ylakoulu/?app&lang=" + java.util.Locale.getDefault().getLanguage());
        }
        else {
            mWebView.loadUrl("http://viikon-kouluruoka.theel0ja.info/turku/ylakoulu?app&lang=" + java.util.Locale.getDefault().getLanguage());
        }
    }

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

    // back-button is goback in webview
    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
