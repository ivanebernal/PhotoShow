package com.ivanebernal.photoshow;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ivanebernal.photoshow.Models.Datum;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PhotoDetailFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PhotoDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PhotoDetailFragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private Datum mDatum;

    private OnFragmentInteractionListener mListener;

    public PhotoDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment PhotoDetailFragment.
     */
    public static PhotoDetailFragment newInstance(Datum param1) {
        PhotoDetailFragment fragment = new PhotoDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mDatum = getArguments().getParcelable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photo_detail, container, false);
        ImageView photoImageView = (ImageView) view.findViewById(R.id.photo_detailed);
        TextView captionTextView = (TextView) view.findViewById(R.id.caption);
        TextView likesText = (TextView) view.findViewById(R.id.num_likes);
        ImageView profilePic = (ImageView) view.findViewById(R.id.user_pic);
        TextView userName = (TextView) view.findViewById(R.id.user_name);

        int picWidth = mDatum.getImages().getStandardResolution().getWidth();
        int picHeight = mDatum.getImages().getStandardResolution().getHeight();
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        boolean isInPortrait = getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        int screenWidth = isInPortrait? size.x:size.y;
        double whr = picHeight/picWidth;
        double spr = screenWidth/picWidth;
        int picNewWidth = isInPortrait? (int) (picWidth * spr) : size.x/2;
        int picNewHeight = (int) (picNewWidth*whr);

        int profPicDimen = screenWidth / 6;

        Picasso.with(getActivity()).load(mDatum.getImages().getStandardResolution().getUrl()).resize(picNewHeight,picNewWidth).into(photoImageView);
        captionTextView.setText(mDatum.getCaption().getText());
        likesText.setText(mDatum.getLikes().getCount()+"");
        userName.setText(mDatum.getUser().getUsername());
        Picasso.with(getActivity()).load(mDatum.getUser().getProfilePicture()).resize(profPicDimen, profPicDimen).into(profilePic);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
