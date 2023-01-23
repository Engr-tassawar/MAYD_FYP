package adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fragments.on_going_fragment;
import fragments.pending_fragment;
import fragments.service_provider_cancel_fragment_;

public class fragmentAdapter extends FragmentPagerAdapter {


    public fragmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0: return new on_going_fragment();
            case 1: return new pending_fragment();
            case 2: return new service_provider_cancel_fragment_();
            default:return new pending_fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position==0){
             title="On-Going";
        }
        else if (position==1) {
           title = "Completed";
        }
        else if (position==2) {
            title = "Cancelled";
        }
        return title;

    }
}
