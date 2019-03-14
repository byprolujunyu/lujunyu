package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityOrderDetailBindingImpl extends ActivityOrderDetailBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(37);
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {1},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 2);
        sViewsWithIds.put(R.id.tip_top, 3);
        sViewsWithIds.put(R.id.order_id, 4);
        sViewsWithIds.put(R.id.state, 5);
        sViewsWithIds.put(R.id.pic, 6);
        sViewsWithIds.put(R.id.titleName, 7);
        sViewsWithIds.put(R.id.title, 8);
        sViewsWithIds.put(R.id.iv_type, 9);
        sViewsWithIds.put(R.id.name, 10);
        sViewsWithIds.put(R.id.count, 11);
        sViewsWithIds.put(R.id.location, 12);
        sViewsWithIds.put(R.id.num, 13);
        sViewsWithIds.put(R.id.all_price, 14);
        sViewsWithIds.put(R.id.tvOrderTime, 15);
        sViewsWithIds.put(R.id.tvPayTime, 16);
        sViewsWithIds.put(R.id.tvDeliveryTime, 17);
        sViewsWithIds.put(R.id.pay_type, 18);
        sViewsWithIds.put(R.id.invoice_model, 19);
        sViewsWithIds.put(R.id.checkbox, 20);
        sViewsWithIds.put(R.id.person, 21);
        sViewsWithIds.put(R.id.rbGeTi, 22);
        sViewsWithIds.put(R.id.company, 23);
        sViewsWithIds.put(R.id.rbDanWei, 24);
        sViewsWithIds.put(R.id.invoice_head, 25);
        sViewsWithIds.put(R.id.companyInfo, 26);
        sViewsWithIds.put(R.id.invoice_content, 27);
        sViewsWithIds.put(R.id.tvBankName, 28);
        sViewsWithIds.put(R.id.tv_bank_id_text, 29);
        sViewsWithIds.put(R.id.tvAdd, 30);
        sViewsWithIds.put(R.id.tvInvoicePhone, 31);
        sViewsWithIds.put(R.id.tip, 32);
        sViewsWithIds.put(R.id.view_background, 33);
        sViewsWithIds.put(R.id.model_button, 34);
        sViewsWithIds.put(R.id.left_button, 35);
        sViewsWithIds.put(R.id.right_button, 36);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityOrderDetailBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 37, sIncludes, sViewsWithIds));
    }
    private ActivityOrderDetailBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[14]
            , (android.widget.CheckBox) bindings[20]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[27]
            , (android.widget.TextView) bindings[25]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.ImageView) bindings[9]
            , (android.widget.TextView) bindings[35]
            , (android.widget.TextView) bindings[12]
            , (android.widget.LinearLayout) bindings[34]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[18]
            , (android.widget.LinearLayout) bindings[21]
            , (com.hongtian.easyroundimageview.EasyRoundImageView) bindings[6]
            , (android.widget.RadioButton) bindings[24]
            , (android.widget.RadioButton) bindings[22]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[2]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[7]
            , (com.bm.container.databinding.TopbarBinding) bindings[1]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[16]
            , (android.view.View) bindings[33]
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