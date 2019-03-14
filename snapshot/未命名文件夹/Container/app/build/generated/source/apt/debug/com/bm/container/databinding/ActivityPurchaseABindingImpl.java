package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityPurchaseABindingImpl extends ActivityPurchaseABinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(50);
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {1},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.framlayout, 2);
        sViewsWithIds.put(R.id.up, 3);
        sViewsWithIds.put(R.id.web, 4);
        sViewsWithIds.put(R.id.refresh, 5);
        sViewsWithIds.put(R.id.more, 6);
        sViewsWithIds.put(R.id.scrollView, 7);
        sViewsWithIds.put(R.id.banner, 8);
        sViewsWithIds.put(R.id.ll_isGoing, 9);
        sViewsWithIds.put(R.id.isGoing, 10);
        sViewsWithIds.put(R.id.rest_time, 11);
        sViewsWithIds.put(R.id.location, 12);
        sViewsWithIds.put(R.id.people, 13);
        sViewsWithIds.put(R.id.ll_status, 14);
        sViewsWithIds.put(R.id.textView2, 15);
        sViewsWithIds.put(R.id.tv_status, 16);
        sViewsWithIds.put(R.id.tvTitleName, 17);
        sViewsWithIds.put(R.id.type, 18);
        sViewsWithIds.put(R.id.iv_type, 19);
        sViewsWithIds.put(R.id.status, 20);
        sViewsWithIds.put(R.id.ll_age, 21);
        sViewsWithIds.put(R.id.tv_age, 22);
        sViewsWithIds.put(R.id.num, 23);
        sViewsWithIds.put(R.id.llStartPrice, 24);
        sViewsWithIds.put(R.id.tvStartPrice, 25);
        sViewsWithIds.put(R.id.special, 26);
        sViewsWithIds.put(R.id.saler_model, 27);
        sViewsWithIds.put(R.id.input_number, 28);
        sViewsWithIds.put(R.id.textView6, 29);
        sViewsWithIds.put(R.id.price, 30);
        sViewsWithIds.put(R.id.textViewpic, 31);
        sViewsWithIds.put(R.id.check_group, 32);
        sViewsWithIds.put(R.id.no_money, 33);
        sViewsWithIds.put(R.id.money, 34);
        sViewsWithIds.put(R.id.input_money, 35);
        sViewsWithIds.put(R.id.textViewpic_two, 36);
        sViewsWithIds.put(R.id.require, 37);
        sViewsWithIds.put(R.id.textView9, 38);
        sViewsWithIds.put(R.id.no_invoice, 39);
        sViewsWithIds.put(R.id.invoice, 40);
        sViewsWithIds.put(R.id.file0, 41);
        sViewsWithIds.put(R.id.file1, 42);
        sViewsWithIds.put(R.id.file2, 43);
        sViewsWithIds.put(R.id.file3, 44);
        sViewsWithIds.put(R.id.file4, 45);
        sViewsWithIds.put(R.id.file5, 46);
        sViewsWithIds.put(R.id.textView7, 47);
        sViewsWithIds.put(R.id.history_list, 48);
        sViewsWithIds.put(R.id.sure, 49);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPurchaseABindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 50, sIncludes, sViewsWithIds));
    }
    private ActivityPurchaseABindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.bigkoo.convenientbanner.ConvenientBanner) bindings[8]
            , (com.bm.container.view.MultipleRadioGroup) bindings[32]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[41]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[42]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[43]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[44]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[45]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[46]
            , (android.widget.FrameLayout) bindings[2]
            , (com.bm.container.view.ExtraListView) bindings[48]
            , (android.widget.EditText) bindings[35]
            , (android.widget.EditText) bindings[28]
            , (android.widget.RadioButton) bindings[40]
            , (android.widget.TextView) bindings[10]
            , (android.widget.ImageView) bindings[19]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.LinearLayout) bindings[9]
            , (android.widget.LinearLayout) bindings[24]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.TextView) bindings[12]
            , (android.widget.RadioButton) bindings[34]
            , (com.bm.container.view.PullUpView) bindings[6]
            , (android.widget.RadioButton) bindings[39]
            , (android.widget.RadioButton) bindings[33]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[13]
            , (android.widget.EditText) bindings[30]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[5]
            , (com.bm.container.view.MultipleRadioGroup) bindings[37]
            , (android.widget.TextView) bindings[11]
            , (android.widget.LinearLayout) bindings[27]
            , (android.widget.ScrollView) bindings[7]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[20]
            , (android.widget.Button) bindings[49]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[38]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[36]
            , (com.bm.container.databinding.TopbarBinding) bindings[1]
            , (android.widget.TextView) bindings[22]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[18]
            , (com.bm.container.view.PullDownView) bindings[3]
            , (android.webkit.WebView) bindings[4]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        topbar.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (topbar.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    public void setLifecycleOwner(@Nullable android.arch.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        topbar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeTopbar((com.bm.container.databinding.TopbarBinding) object, fieldId);
        }
        return false;
    }
    private boolean onChangeTopbar(com.bm.container.databinding.TopbarBinding Topbar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
        executeBindingsOn(topbar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): topbar
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}