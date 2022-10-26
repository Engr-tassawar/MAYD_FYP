package adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fragments.on_going_fragment;
import fragments.pending_fragment;

public class fragmentAdapter extends FragmentPagerAdapter {


    public fragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:return new pending_fragment();
            case 1:return new on_going_fragment();
            default:return new pending_fragment();

        }
    }

    @Override
    public int getCount() {

        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
             title="Pending";
        }
        else if (position==1) {
           title = "On-going";
        }
        return title;

    }
}
