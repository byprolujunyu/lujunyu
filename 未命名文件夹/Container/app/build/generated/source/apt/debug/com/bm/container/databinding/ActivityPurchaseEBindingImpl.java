package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityPurchaseEBindingImpl extends ActivityPurchaseEBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(39);
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {1},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 2);
        sViewsWithIds.put(R.id.banner, 3);
        sViewsWithIds.put(R.id.ll_isGoing, 4);
        sViewsWithIds.put(R.id.isGoing, 5);
        sViewsWithIds.put(R.id.rest_time, 6);
        sViewsWithIds.put(R.id.tv_iamge, 7);
        sViewsWithIds.put(R.id.location, 8);
        sViewsWithIds.put(R.id.people, 9);
        sViewsWithIds.put(R.id.tvTitleName, 10);
        sViewsWithIds.put(R.id.type, 11);
        sViewsWithIds.put(R.id.status, 12);
        sViewsWithIds.put(R.id.num, 13);
        sViewsWithIds.put(R.id.num_choosed, 14);
        sViewsWithIds.put(R.id.price_choosed, 15);
        sViewsWithIds.put(R.id.special_choosed, 16);
        sViewsWithIds.put(R.id.special_price_choosed, 17);
        sViewsWithIds.put(R.id.invoice_choosed, 18);
        sViewsWithIds.put(R.id.invoice_model, 19);
        sViewsWithIds.put(R.id.check_invoice, 20);
        sViewsWithIds.put(R.id.personal_check, 21);
        sViewsWithIds.put(R.id.company_check, 22);
        sViewsWithIds.put(R.id.invoiceBasicInformation, 23);
        sViewsWithIds.put(R.id.invoice_head, 24);
        sViewsWithIds.put(R.id.companyInfo, 25);
        sViewsWithIds.put(R.id.llinvoice_content, 26);
        sViewsWithIds.put(R.id.invoice_content, 27);
        sViewsWithIds.put(R.id.llbankName, 28);
        sViewsWithIds.put(R.id.bankName, 29);
        sViewsWithIds.put(R.id.llbank_id_text, 30);
        sViewsWithIds.put(R.id.bank_id_text, 31);
        sViewsWithIds.put(R.id.ll_etAdd, 32);
        sViewsWithIds.put(R.id.etAdd, 33);
        sViewsWithIds.put(R.id.ll_invoicePhone, 34);
        sViewsWithIds.put(R.id.invoicePhone, 35);
        sViewsWithIds.put(R.id.view, 36);
        sViewsWithIds.put(R.id.all_price, 37);
        sViewsWithIds.put(R.id.buy, 38);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityPurchaseEBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 39, sIncludes, sViewsWithIds));
    }
    private ActivityPurchaseEBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[37]
            , (com.bm.container.view.XEditText) bindings[31]
            , (android.widget.EditText) bindings[29]
            , (com.bigkoo.convenientbanner.ConvenientBanner) bindings[3]
            , (android.widget.TextView) bindings[38]
            , (android.widget.CheckBox) bindings[20]
            , (android.widget.RadioButton) bindings[22]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.EditText) bindings[33]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.TextView) bindings[18]
            , (android.widget.EditText) bindings[27]
            , (android.widget.EditText) bindings[24]
            , (android.widget.LinearLayout) bindings[19]
            , (android.widget.EditText) bindings[35]
            , (android.widget.TextView) bindings[5]
            , (android.widget.LinearLayout) bindings[32]
            , (android.widget.LinearLayout) bindings[34]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[30]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.LinearLayout) bindings[26]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
            , (android.widget.TextView) bindings[9]
            , (android.widget.RadioButton) bindings[21]
            , (android.widget.TextView) bindings[15]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[16]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[12]
            , (com.bm.container.databinding.TopbarBinding) bindings[1]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[11]
            , (android.view.View) bindings[36]
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