package com.nguoisomot.shoppingproject;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyRewardsFragment extends Fragment {


    public MyRewardsFragment() {
        // Required empty public constructor
    }

    RecyclerView rewardsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_rewards, container, false);
        rewardsRecyclerView = view.findViewById(R.id.my_rewards_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rewardsRecyclerView.setLayoutManager(layoutManager);

        List<RewardModel> rewardModelList = new ArrayList<>();
        rewardModelList.add(new RewardModel("Cashback", "till 2nd, december, 2019", "GET 25% CASHBACK on any product above $199 and $299"));
        rewardModelList.add(new RewardModel("Cashback", "till 2nd, december, 2019", "GET 25% CASHBACK on any product above $199 and $299"));
        rewardModelList.add(new RewardModel("Cashback", "till 2nd, december, 2019", "GET 25% CASHBACK on any product above $199 and $299"));
        rewardModelList.add(new RewardModel("Cashback", "till 2nd, december, 2019", "GET 25% CASHBACK on any product above $199 and $299"));

        MyRewardsAdapter myRewardsAdapter = new MyRewardsAdapter(rewardModelList, false);

        rewardsRecyclerView.setAdapter(myRewardsAdapter);
        myRewardsAdapter.notifyDataSetChanged();

        return view;
    }

}
