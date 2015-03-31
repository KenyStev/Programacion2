package frangments.labprogra2.zerustudio.com.pruebafragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;

/**
 * Created by zerokull on 03-06-15.
 */
public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_layout,
                container, false);
        return view;
    }

    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.detailsText);
        view.setText(item);
    }
}
