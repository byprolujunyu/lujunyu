package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivitySendSaleInfoBindingImpl extends ActivitySendSaleInfoBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(48);
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {1},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 2);
        sViewsWithIds.put(R.id.country, 3);
        sViewsWithIds.put(R.id.country_text, 4);
        sViewsWithIds.put(R.id.city, 5);
        sViewsWithIds.put(R.id.city_text, 6);
        sViewsWithIds.put(R.id.editTitleName, 7);
        sViewsWithIds.put(R.id.type, 8);
        sViewsWithIds.put(R.id.type_text, 9);
        sViewsWithIds.put(R.id.status, 10);
        sViewsWithIds.put(R.id.status_text, 11);
        sViewsWithIds.put(R.id.type_age, 12);
        sViewsWithIds.put(R.id.et_age, 13);
        sViewsWithIds.put(R.id.num, 14);
        sViewsWithIds.put(R.id.number, 15);
        sViewsWithIds.put(R.id.sale_or_bid, 16);
        sViewsWithIds.put(R.id.sale, 17);
        sViewsWithIds.put(R.id.bid, 18);
        sViewsWithIds.put(R.id.money, 19);
        sViewsWithIds.put(R.id.money_input, 20);
        sViewsWithIds.put(R.id.time, 21);
        sViewsWithIds.put(R.id.time_text, 22);
        sViewsWithIds.put(R.id.ll_low_price, 23);
        sViewsWithIds.put(R.id.edit_low_price, 24);
        sViewsWithIds.put(R.id.special_check, 25);
        sViewsWithIds.put(R.id.special_check_left, 26);
        sViewsWithIds.put(R.id.input_money, 27);
        sViewsWithIds.put(R.id.textViewpic_two, 28);
        sViewsWithIds.put(R.id.editRemarks, 29);
        sViewsWithIds.put(R.id.invoice, 30);
        sViewsWithIds.put(R.id.no_invoice, 31);
        sViewsWithIds.put(R.id.has_invoice, 32);
        sViewsWithIds.put(R.id.file0, 33);
        sViewsWithIds.put(R.id.iv_delete_0, 34);
        sViewsWithIds.put(R.id.file1, 35);
        sViewsWithIds.put(R.id.iv_delete_1, 36);
        sViewsWithIds.put(R.id.file2, 37);
        sViewsWithIds.put(R.id.iv_delete_2, 38);
        sViewsWithIds.put(R.id.file3, 39);
        sViewsWithIds.put(R.id.iv_delete_3, 40);
        sViewsWithIds.put(R.id.file4, 41);
        sViewsWithIds.put(R.id.iv_delete_4, 42);
        sViewsWithIds.put(R.id.file5, 43);
        sViewsWithIds.put(R.id.iv_delete_5, 44);
        sViewsWithIds.put(R.id.all_money_model, 45);
        sViewsWithIds.put(R.id.all_money, 46);
        sViewsWithIds.put(R.id.sure, 47);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySendSaleInfoBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 48, sIncludes, sViewsWithIds));
    }
    private ActivitySendSaleInfoBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[46]
            , (android.widget.LinearLayout) bindings[45]
            , (android.widget.RadioButton) bindings[18]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.TextView) bindings[6]
            , (android.widget.LinearLayout) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.EditText) bindings[24]
            , (android.widget.EditText) bindings[29]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[13]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[33]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[35]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[37]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[39]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[41]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[43]
            , (android.widget.RadioButton) bindings[32]
            , (android.widget.EditText) bindings[27]
            , (com.bm.container.view.MultipleRadioGroup) bindings[30]
            , (android.widget.ImageView) bindings[34]
            , (android.widget.ImageView) bindings[36]
            , (android.widget.ImageView) bindings[38]
            , (android.widget.ImageView) bindings[40]
            , (android.widget.ImageView) bindings[42]
            , (android.widget.ImageView) bindings[44]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.EditText) bindings[20]
            , (android.widget.RadioButton) bindings[31]
            , (android.widget.LinearLayout) bindings[14]
            , (android.widget.EditText) bindings[15]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[2]
            , (android.widget.RadioButton) bindings[17]
            , (com.bm.container.view.MultipleRadioGroup) bindings[16]
            , (com.bm.container.view.MultipleRadioGroup) bindings[25]
            , (android.widget.RadioButton) bindings[26]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[47]
            , (android.widget.TextView) bindings[28]
            , (android.widget.LinearLayout) bindings[21]
            , (android.widget.TextView) bindings[22]
            , (com.bm.container.databinding.TopbarBinding) bindings[1]
            , (android.widget.LinearLayout) bindings[8]
            , (android.widget.LinearLayout) bindings[12]
            , (android.widget.TextView) bindings[9]
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