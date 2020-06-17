package com.nguoisomot.shoppingproject;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_UNLOCKED;
import static com.nguoisomot.shoppingproject.DBqueries.categoryModelList;
import static com.nguoisomot.shoppingproject.DBqueries.firebaseFirestore;
import static com.nguoisomot.shoppingproject.DBqueries.lists;
import static com.nguoisomot.shoppingproject.DBqueries.loadCategories;
import static com.nguoisomot.shoppingproject.DBqueries.loadFragmentData;
import static com.nguoisomot.shoppingproject.DBqueries.loadedCategoriesNames;
import static com.nguoisomot.shoppingproject.MainActivity.drawer;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    private ConnectivityManager connectivityManager;
    private NetworkInfo networkInfo;

    public static SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView categoryRecyclerView;
    private List<CategoryModel> categoryModelFakeList = new ArrayList<>();
    private CategoryAdapter categoryAdapter;
    private RecyclerView homePageRecyclerView;
    private List<HomePageModel> homePageModelFakeList = new ArrayList<>();
    private HomePageAdapter adapter;
    private ImageView noInternetConnect;
    private Button retryBtn;

    //// Horizontal Product Layout
    private TextView horizontalLayoutTitle;
    private Button horizontalLayoutViewAllBtn;
    private RecyclerView horizontalRecyclerView;
//    private FirebaseFirestore firebaseFirestore;
    //// Horizontal Product Layout


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        swipeRefreshLayout = view.findViewById(R.id.refresh_layout);
        noInternetConnect = view.findViewById(R.id.no_internet_connection);
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        homePageRecyclerView = view.findViewById(R.id.home_page_recyclerview);
        retryBtn = view.findViewById(R.id.retry_btn);


        swipeRefreshLayout.setColorSchemeColors(getContext().getResources().getColor(R.color.colorPrimary), getContext().getResources().getColor(R.color.colorPrimary));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        LinearLayoutManager testingLayoutManager = new LinearLayoutManager(getContext());
        testingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        homePageRecyclerView.setLayoutManager(testingLayoutManager);

        /////// category fake list
        categoryModelFakeList.add(new CategoryModel("null", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));
        categoryModelFakeList.add(new CategoryModel("", ""));

        /////// category fake list

        ////// home page fake list
        List<SliderModel> sliderModelFakeList = new ArrayList<>();
        sliderModelFakeList.add(new SliderModel("null", "#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null", "#ffffff"));
        sliderModelFakeList.add(new SliderModel("null", "#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null", "#dfdfdf"));
        sliderModelFakeList.add(new SliderModel("null", "#dfdfdf"));

        List<HorizontalProductScrollModel> horizontalProductScrollModelFakeList = new ArrayList<>();
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("x6Q0OfdxqRze1daotqcp", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("x6Q0OfdxqRze1daotqcp", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("x6Q0OfdxqRze1daotqcp", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("x6Q0OfdxqRze1daotqcp", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("x6Q0OfdxqRze1daotqcp", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("x6Q0OfdxqRze1daotqcp", "", "", "", ""));
        horizontalProductScrollModelFakeList.add(new HorizontalProductScrollModel("x6Q0OfdxqRze1daotqcp", "", "", "", ""));


        homePageModelFakeList.add(new HomePageModel(0, sliderModelFakeList));
        homePageModelFakeList.add(new HomePageModel(1, "", "#dfdfdf"));
        homePageModelFakeList.add(new HomePageModel(2, "", "#dfdfdf", horizontalProductScrollModelFakeList, new ArrayList<WishlistModel>()));
        homePageModelFakeList.add(new HomePageModel(3, "", "#dfdfdf", horizontalProductScrollModelFakeList));

        ////// home page fake list
        categoryAdapter = new CategoryAdapter(categoryModelFakeList);

        adapter = new HomePageAdapter(homePageModelFakeList);


        connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() == true) {

            drawer.setDrawerLockMode(LOCK_MODE_UNLOCKED);
            /////0000000000000
            noInternetConnect.setVisibility(View.GONE);
            retryBtn.setVisibility(View.GONE);
            categoryRecyclerView.setVisibility(View.VISIBLE);
            homePageRecyclerView.setVisibility(View.VISIBLE);
            if (categoryModelList.size() == 0) {
                loadCategories(categoryRecyclerView, getContext());
            } else {
                categoryAdapter = new CategoryAdapter(categoryModelList);
                categoryAdapter.notifyDataSetChanged();
            }
            categoryRecyclerView.setAdapter(categoryAdapter);

            if (lists.size() == 0) {
                loadedCategoriesNames.add("HOME");
                lists.add(new ArrayList<HomePageModel>());
                loadFragmentData(homePageRecyclerView, getContext(), 0, "HOME");
            } else {
                adapter = new HomePageAdapter(lists.get(0));
                adapter.notifyDataSetChanged();
            }
            homePageRecyclerView.setAdapter(adapter);
        } else {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            //////111111111111
            categoryRecyclerView.setVisibility(View.GONE);
            homePageRecyclerView.setVisibility(View.GONE);
            Glide.with(this).load(R.drawable.no_internet_icon).into(noInternetConnect);
            noInternetConnect.setVisibility(View.VISIBLE);
            retryBtn.setVisibility(View.VISIBLE);
        }

        /////// refresh layout
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                reloadPage();
            }
        });

        /////// refresh layout
        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadPage();
            }
        });
        return view;
    }
        private void reloadPage(){
            networkInfo = connectivityManager.getActiveNetworkInfo();
            categoryModelList.clear();
            lists.clear();
            loadedCategoriesNames.clear();
            if (networkInfo != null && networkInfo.isConnected() == true) {
                drawer.setDrawerLockMode(LOCK_MODE_UNLOCKED);
                ////00000000000
                noInternetConnect.setVisibility(View.GONE);
                retryBtn.setVisibility(View.GONE);
                categoryRecyclerView.setVisibility(View.VISIBLE);
                homePageRecyclerView.setVisibility(View.VISIBLE);
                categoryAdapter = new CategoryAdapter(categoryModelFakeList);
                adapter = new HomePageAdapter(homePageModelFakeList);
                categoryRecyclerView.setAdapter(categoryAdapter);
                homePageRecyclerView.setAdapter(adapter);

                loadCategories(categoryRecyclerView, getContext());

                loadedCategoriesNames.add("HOME");
                lists.add(new ArrayList<HomePageModel>());
                loadFragmentData(homePageRecyclerView, getContext(), 0, "HOME");
            } else {
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                //111111111111111
                Toast.makeText(getContext(),"No internet Connection!", Toast.LENGTH_SHORT).show();
                categoryRecyclerView.setVisibility(View.GONE);
                homePageRecyclerView.setVisibility(View.GONE);
                Glide.with(getContext()).load(R.drawable.no_internet_icon).into(noInternetConnect);
                noInternetConnect.setVisibility(View.VISIBLE);
                retryBtn.setVisibility(View.VISIBLE);
                swipeRefreshLayout.setRefreshing(false);
            }
        }
}
