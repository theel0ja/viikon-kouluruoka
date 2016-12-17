package info.theel0ja.kouluruoka;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;


public class Archives extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archives);
        Toast.makeText(this, "Valitse koulu valikosta", Toast.LENGTH_SHORT).show();

        // Just preventing crashing from onBackPressed()
            mWebView = (WebView) findViewById(R.id.archive_webview);
            mWebView.setWebViewClient(new WebViewClient());
    }

    // Initialize menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_archives, menu);
        return true;
    }

    // Buttons of menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_elementary:

                // Set header text
                TextView headerTxtA = (TextView) findViewById(R.id.headerTxt);
                headerTxtA.setText(getString(R.string.elementary_school));

                    mWebView = (WebView) findViewById(R.id.archive_webview);

                    // Force links and redirects to open in the WebView instead of in a browser
                    mWebView.setWebViewClient(new WebViewClient());

                    // Enable Javascript
                    WebSettings webSettingsA = mWebView.getSettings();
                    webSettingsA.setJavaScriptEnabled(true);

                    // 4.0.3 and up - Use https version
                    // 4.0.3 and down - Use non-https version
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                        mWebView.loadUrl("https://viikon-kouluruoka.theel0ja.info/archives/turku/alakoulu/?app&lang=" + java.util.Locale.getDefault().getLanguage());
                    }
                    else {
                        mWebView.loadUrl("http://viikon-kouluruoka.theel0ja.info/archives/turku/alakoulu?app&lang=" + java.util.Locale.getDefault().getLanguage());
                    }

                return true;

            case R.id.action_secondary:
                // Set header text
                TextView headerTxtB = (TextView) findViewById(R.id.headerTxt);
                headerTxtB.setText(getString(R.string.secondary_school));

                    mWebView = (WebView) findViewById(R.id.archive_webview);

                    // Force links and redirects to open in the WebView instead of in a browser
                    mWebView.setWebViewClient(new WebViewClient());

                    // Enable Javascript
                    WebSettings webSettingsB = mWebView.getSettings();
                    webSettingsB.setJavaScriptEnabled(true);

                    // 4.0.3 and up - Use https version
                    // 4.0.3 and down - Use non-https version
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
                        mWebView.loadUrl("https://viikon-kouluruoka.theel0ja.info/archives/turku/ylakoulu/?app&lang=" + java.util.Locale.getDefault().getLanguage());
                    }
                    else {
                        mWebView.loadUrl("http://viikon-kouluruoka.theel0ja.info/archives/turku/ylakoulu?app&lang=" + java.util.Locale.getDefault().getLanguage());
                    }

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