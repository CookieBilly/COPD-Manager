package ws.billy.app.Code.New.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ws.billy.app.*;
import ws.billy.app.Code.New.Chat.ChatActivity;

public class HomeFragment extends Fragment {

	View view;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_home, container, false);

		view.findViewById(R.id.contact_doctor).setOnClickListener(v -> startActivity(new Intent(getActivity(), ChatActivity.class)));

		// query to get daily completion

		return view;
	}

	public void dailyCompleteListener() {

		// check if an answer has been created today

		// if yes:
			// hide reminder

		// if no:
			// make question on bottom bar highlighted


	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

}
