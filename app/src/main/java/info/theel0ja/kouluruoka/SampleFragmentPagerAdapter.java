package info.theel0ja.kouluruoka;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by theel0ja on 2.4.2017.
 */

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;

    //private String primary_schools = Integer.toString(R.string.elementary_school);
    private String primary_schools = "Alakoulut";
    private String secondary_schools = "Yläkoulut ja lukiot";
    // TODO ^: FIX TRANSLATIONS

    private String tabTitles[] = new String[] {primary_schools , secondary_schools };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}