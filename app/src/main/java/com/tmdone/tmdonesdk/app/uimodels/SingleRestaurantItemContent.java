package com.tmdone.tmdonesdk.app.uimodels;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.tmdone.tmdonesdk.R;
import com.tmdone.tmdonesdk.network.service.models.PriceResponse;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

public class SingleRestaurantItemContent extends SingleRestaurantItem {
    private String id;
    private String description;
    private String image;
    private PriceResponse price;
    private double rating;
    private boolean isInStock;
    private boolean isFeatured;
    private int itemIndex;

    @BindingAdapter({"foodImage"})
    public static void loadFoodLogo(ImageView imageView, String logoUrl) {
        ImageLoader imageLoader = Coil.imageLoader(imageView.getContext());
        ImageRequest imageRequest = new ImageRequest.Builder(imageView.getContext())
                .data(logoUrl)
                .crossfade(true)
                .placeholder(R.drawable.image_default_menu_item)
                .target(imageView)
                .build();
        imageLoader.enqueue(imageRequest);
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PriceResponse getPrice() {
        return price;
    }

    public void setPrice(PriceResponse price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }


    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }
}
