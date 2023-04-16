package com.example.shopapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopapp.model.AccountModel;
import com.example.shopapp.model.CartItemModel;
import com.example.shopapp.model.ImagesModel;
import com.example.shopapp.model.PostsModel;
import com.example.shopapp.model.ProductModel;
import com.example.shopapp.model.PurchaseModel;
import com.example.shopapp.utils.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class MainActivityViewModel extends ViewModel {
    private static final String TAG = "MainActivityViewModel";

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private List<CartItemModel> cartItemModels = new ArrayList<>();
    private MutableLiveData<List<CartItemModel>> cartItemLiveData = new MutableLiveData<>();
    private MutableLiveData<String> totalPriceLiveData = new MutableLiveData<>();

    public LiveData<List<PostsModel>> getPosts() {
        return Repository.getInstance().getPosts(compositeDisposable);
    }

    public LiveData<ProductModel> getDetails(String name) {
        return Repository.getInstance().getDetails(name, compositeDisposable);
    }

    public LiveData<List<ImagesModel>> getImages(String name) {
        return Repository.getInstance().getImages(name, compositeDisposable);
    }

    public LiveData<AccountModel> getAccountDetails(String number) {
        return Repository.getInstance().getAccountDetails(number, compositeDisposable);
    }

    public LiveData<Integer> updateAccount(AccountModel model) {
        return Repository.getInstance().updateAccount(model, compositeDisposable);
    }

    public void addProductToCart(CartItemModel cartItemModel) {
        if (isProductExisted(cartItemModel)) {
            cartItemModels.add(cartItemModel);
            cartItemLiveData.setValue(cartItemModels);
            setTotalPriceLiveData();
        }
    }

    private boolean isProductExisted(CartItemModel cartItemModel) {
        boolean isOk = true;
        for (CartItemModel model : cartItemModels) {
            if (cartItemModel.getName().equals(model.getName())) {
                isOk = false;
                break;
            }
        }
        return isOk;
    }

    //activity of plus, minus, & remove BTNs
    public void plusOneProduct(int position) {
        cartItemModels.get(position).setNumberOfProduct(String.valueOf(Integer.parseInt(cartItemModels.get(position).getNumberOfProduct()) + 1));
        cartItemLiveData.setValue(cartItemModels);
        setTotalPriceLiveData();
    }

    public void minusOneProduct(int position) {
        if (Integer.parseInt(cartItemModels.get(position).getNumberOfProduct()) > 1) {
            cartItemModels.get(position).setNumberOfProduct(String.valueOf(Integer.parseInt(cartItemModels.get(position).getNumberOfProduct()) - 1));
            setTotalPriceLiveData();
            cartItemLiveData.setValue(cartItemModels);
        }
    }

    public void removeProduct(int position) {
        cartItemModels.remove(position);
        cartItemLiveData.setValue(cartItemModels);
        setTotalPriceLiveData();
    }


    //getters
    public MutableLiveData<List<CartItemModel>> getCartItemLiveData() {
        return cartItemLiveData;
    }

    // getter --> totalPrice
    public String getTotalPrice() {
        int totalPrice = 0;
        for (CartItemModel model : cartItemModels) {
            totalPrice += Integer.parseInt(model.getPrice()) * Integer.parseInt(model.getNumberOfProduct());
        }
        return String.valueOf(totalPrice);
    }

    public LiveData<String> getTotalPriceLiveData() {
        return totalPriceLiveData;
    }

    public LiveData<Integer> pay(String refID, String number, String price, String purchasedate) {
        return Repository.getInstance().pay(compositeDisposable, refID, number, price, purchasedate);
    }

    public LiveData<List<PurchaseModel>> getPaysDetail() {
        return Repository.getInstance().getPaysDetail(compositeDisposable);
    }

    //setters
    public void setTotalPriceLiveData() {
        totalPriceLiveData.setValue(getTotalPrice());
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
