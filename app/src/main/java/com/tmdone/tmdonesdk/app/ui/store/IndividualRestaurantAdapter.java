package com.tmdone.tmdonesdk.app.ui.store;


import static com.tmdone.tmdonesdk.app.utility.DoubleUtility.getDecimalValueWithCurrency;

import android.app.Activity;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tmdone.tmdonesdk.R;
import com.tmdone.tmdonesdk.app.uimodels.SingleRestaurantItem;
import com.tmdone.tmdonesdk.app.uimodels.SingleRestaurantItemContent;
import com.tmdone.tmdonesdk.app.uimodels.SingleRestaurantItemHeader;
import com.tmdone.tmdonesdk.app.uimodels.Store;
import com.tmdone.tmdonesdk.databinding.ItemIndividualRestaurantBinding;
import com.tmdone.tmdonesdk.databinding.ItemIndividualRestaurantHeaderBinding;

import java.util.ArrayList;
import java.util.List;

public class IndividualRestaurantAdapter extends RecyclerView.Adapter {

    private final static int ITEM_HEADER = 0;
    private final static int ITEM_BODY = 1;

    private final Store mStore;
    private final Activity mActivity;
    private final FragmentManager fragmentManager;
    private final String TAG = "IndividualResAdapter";
    private List<SingleRestaurantItem> mSingleItems;
    private RestaurantItemSelectionListener restaurantItemSelectionListener;

    public IndividualRestaurantAdapter(Store store, Activity activity, FragmentManager fragmentManager) {
        this.mSingleItems = new ArrayList<>();
        this.mStore = store;
        this.mActivity = activity;
        this.fragmentManager = fragmentManager;
    }

    public void setUpSingleRestaurantItemList(List<SingleRestaurantItem> singleItem) {
        this.mSingleItems.clear();
        this.mSingleItems = singleItem;
        notifyDataSetChanged();
    }

    public void setOnRestaurantItemSelectionListener(RestaurantItemSelectionListener restaurantItemSelectionListener) {
        this.restaurantItemSelectionListener = restaurantItemSelectionListener;
    }


    public interface RestaurantItemSelectionListener {
        void onRestaurantItemSelection(SingleRestaurantItemContent singleRestaurantItemContent);
    }

    public void clear() {
        mSingleItems.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_HEADER) {
            ItemIndividualRestaurantHeaderBinding binding = ItemIndividualRestaurantHeaderBinding.inflate(inflater, parent, false);
            return new ViewHolderHeader(binding);
        } else {
            ItemIndividualRestaurantBinding binding = ItemIndividualRestaurantBinding.inflate(inflater, parent, false);
            return new ViewHolderContent(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderHeader) {
            SingleRestaurantItemHeader itemHeader = (SingleRestaurantItemHeader) mSingleItems.get(position);
            if (itemHeader != null) {
                ((ViewHolderHeader) holder).bind(itemHeader);
            }
        } else {
            SingleRestaurantItemContent itemContent = (SingleRestaurantItemContent) mSingleItems.get(position);
            if (itemContent != null) {
                ((ViewHolderContent) holder).bind(itemContent);
            }
        }
    }

    public String getCurrentName(RecyclerView recyclerView, int position) {
        IndividualRestaurantAdapter adapter = (IndividualRestaurantAdapter) recyclerView.getAdapter();
        return adapter.mSingleItems.get(position).getHeaderName();
    }

    @Override
    public int getItemViewType(int position) {
        if (mSingleItems.get(position) instanceof SingleRestaurantItemHeader) {
            return ITEM_HEADER;
        } else {
            return ITEM_BODY;
        }
    }

    @Override
    public int getItemCount() {
        return mSingleItems.size();
    }

    public int getTargetPosition(RecyclerView recyclerView, String header) {
        IndividualRestaurantAdapter adapter = (IndividualRestaurantAdapter) recyclerView.getAdapter();
        if (adapter.mSingleItems != null) {
            for (int i = 0; i < adapter.mSingleItems.size(); i++) {
                if (adapter.mSingleItems.get(i).getHeader() != null) {
                    if (adapter.mSingleItems.get(i).getHeader().equals(header)) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    public class ViewHolderHeader extends RecyclerView.ViewHolder {

        private final ItemIndividualRestaurantHeaderBinding mBinding;

        public ViewHolderHeader(@NonNull ItemIndividualRestaurantHeaderBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bind(SingleRestaurantItemHeader itemHeader) {
            mBinding.setHeader(itemHeader);
            mBinding.executePendingBindings();
        }
    }

    public class ViewHolderContent extends RecyclerView.ViewHolder {

        private final ItemIndividualRestaurantBinding mBinding;

        public ViewHolderContent(@NonNull ItemIndividualRestaurantBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bind(SingleRestaurantItemContent itemBody) {
            mBinding.setContent(itemBody);
            attachPriceFeeToText(itemBody);
            mBinding.executePendingBindings();


            mBinding.linearFoodItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!itemBody.isInStock()) {
                        return;
                    }

//                    Log.d(TAG, "onClick : " + new Gson().toJson(itemBody));
                    openIndividualItemView(itemBody);
                }
            });


            if (itemBody.isInStock()) {
                mBinding.textOutOfStock.setVisibility(View.GONE);
            } else {
                mBinding.textOutOfStock.setVisibility(View.VISIBLE);
            }


            if (itemBody.getPrice().getItemOnSale() && itemBody.getPrice().getPrice() != itemBody.getPrice().getUnitPrice()) {
                mBinding.textOldPrice.setVisibility(View.VISIBLE);
                mBinding.textOldPrice.setPaintFlags(mBinding.textOldPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                mBinding.textOldPrice.setText(getDecimalValueWithCurrency(mActivity, itemBody.getPrice().getUnitPrice()));
            } else {
                mBinding.textOldPrice.setVisibility(View.GONE);
            }


            if (itemBody.isFeatured()) {
                mBinding.imgStatus.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.featured_flag));
                mBinding.linearOnFeatureContainer.setVisibility(View.VISIBLE);
            } else if (itemBody.getPrice().getItemOnSale()) {
                mBinding.imgStatus.setImageDrawable(ContextCompat.getDrawable(mActivity, R.drawable.sale_icon));
                mBinding.linearOnFeatureContainer.setVisibility(View.VISIBLE);
            } else {
                mBinding.linearOnFeatureContainer.setVisibility(View.GONE);
            }

        }

        private void attachPriceFeeToText(SingleRestaurantItemContent contentItem) {
            if (contentItem.getPrice().getPrice() > 0) {
                mBinding.textPrice.setText(getDecimalValueWithCurrency(mActivity, contentItem.getPrice().getPrice()));
            } else {
                mBinding.textPrice.setText(itemView.getContext().getString(R.string.based_on_selection));
            }
        }


        private void openIndividualItemView(SingleRestaurantItemContent itemContent) {
            restaurantItemSelectionListener.onRestaurantItemSelection(itemContent);
        }
    }
}
