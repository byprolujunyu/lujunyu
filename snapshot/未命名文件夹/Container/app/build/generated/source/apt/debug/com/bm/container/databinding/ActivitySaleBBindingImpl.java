package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivitySaleBBindingImpl extends ActivitySaleBBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(54);
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {1},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 2);
        sViewsWithIds.put(R.id.banner, 3);
        sViewsWithIds.put(R.id.llIsGoing, 4);
        sViewsWithIds.put(R.id.isGoing, 5);
        sViewsWithIds.put(R.id.rest_time, 6);
        sViewsWithIds.put(R.id.tv_iamge, 7);
        sViewsWithIds.put(R.id.location, 8);
        sViewsWithIds.put(R.id.people, 9);
        sViewsWithIds.put(R.id.ll_status, 10);
        sViewsWithIds.put(R.id.textView2, 11);
        sViewsWithIds.put(R.id.tv_status, 12);
        sViewsWithIds.put(R.id.tvTitleName, 13);
        sViewsWithIds.put(R.id.type, 14);
        sViewsWithIds.put(R.id.iv_type, 15);
        sViewsWithIds.put(R.id.status, 16);
        sViewsWithIds.put(R.id.ll_age, 17);
        sViewsWithIds.put(R.id.tv_age, 18);
        sViewsWithIds.put(R.id.num, 19);
        sViewsWithIds.put(R.id.ll_price_choosed, 20);
        sViewsWithIds.put(R.id.price_choosed, 21);
        sViewsWithIds.put(R.id.llStartPrice, 22);
        sViewsWithIds.put(R.id.tvStartPrice, 23);
        sViewsWithIds.put(R.id.tvRemark, 24);
        sViewsWithIds.put(R.id.special_choosed, 25);
        sViewsWithIds.put(R.id.special_price_choosed, 26);
        sViewsWithIds.put(R.id.invoice_choosed, 27);
        sViewsWithIds.put(R.id.invoice_model, 28);
        sViewsWithIds.put(R.id.check_invoice, 29);
        sViewsWithIds.put(R.id.personal_check, 30);
        sViewsWithIds.put(R.id.personal, 31);
        sViewsWithIds.put(R.id.company_check, 32);
        sViewsWithIds.put(R.id.company, 33);
        sViewsWithIds.put(R.id.invoiceBasicInformation, 34);
        sViewsWithIds.put(R.id.invoice_head, 35);
        sViewsWithIds.put(R.id.companyInfo, 36);
        sViewsWithIds.put(R.id.llinvoice_content, 37);
        sViewsWithIds.put(R.id.invoice_content, 38);
        sViewsWithIds.put(R.id.llbankName, 39);
        sViewsWithIds.put(R.id.bankName, 40);
        sViewsWithIds.put(R.id.llbank_id_text, 41);
        sViewsWithIds.put(R.id.bank_id_text, 42);
        sViewsWithIds.put(R.id.ll_etAdd, 43);
        sViewsWithIds.put(R.id.etAdd, 44);
        sViewsWithIds.put(R.id.ll_invoicePhone, 45);
        sViewsWithIds.put(R.id.invoicePhone, 46);
        sViewsWithIds.put(R.id.saler_model, 47);
        sViewsWithIds.put(R.id.offer_price, 48);
        sViewsWithIds.put(R.id.textViewpic, 49);
        sViewsWithIds.put(R.id.textView7, 50);
        sViewsWithIds.put(R.id.textView8, 51);
        sViewsWithIds.put(R.id.history_list, 52);
        sViewsWithIds.put(R.id.sure, 53);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySaleBBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 54, sIncludes, sViewsWithIds));
    }
    private ActivitySaleBBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.bm.container.view.XEditText) bindings[42]
            , (android.widget.EditText) bindings[40]
            , (com.bigkoo.convenientbanner.ConvenientBanner) bindings[3]
            , (android.widget.CheckBox) bindings[29]
            , (android.widget.TextView) bindings[33]
            , (android.widget.RadioButton) bindings[32]
            , (android.widget.LinearLayout) bindings[36]
            , (android.widget.EditText) bindings[44]
            , (com.bm.container.view.ExtraListView) bindings[52]
            , (android.widget.LinearLayout) bindings[34]
            , (android.widget.TextView) bindings[27]
            , (android.widget.EditText) bindings[38]
            , (android.widget.EditText) bindings[35]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.EditText) bindings[46]
            , (android.widget.TextView) bindings[5]
            , (android.widget.ImageView) bindings[15]
            , (android.widget.LinearLayout) bindings[17]
            , (android.widget.LinearLayout) bindings[43]
            , (android.widget.LinearLayout) bindings[45]
            , (android.widget.LinearLayout) bindings[4]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.LinearLayout) bindings[10]
            , (android.widget.LinearLayout) bindings[41]
            , (android.widget.LinearLayout) bindings[39]
            , (android.widget.LinearLayout) bindings[37]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[19]
            , (android.widget.EditText) bindings[48]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[31]
            , (android.widget.RadioButton) bindings[30]
            , (android.widget.TextView) bindings[21]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[2]
            , (android.widget.TextView) bindings[6]
            , (android.widget.LinearLayout) bindings[47]
            , (android.widget.TextView) bindings[25]
            , (android.widget.TextView) bindings[26]
            , (android.widget.TextView) bindings[16]
            , (android.widget.Button) bindings[53]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[50]
            , (android.widget.TextView) bindings[51]
            , (android.widget.TextView) bindings[49]
            , (com.bm.container.databinding.TopbarBinding) bindings[1]
            , (android.widget.TextView) bindings[18]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[24]
            , (android.widget.TextView) bindings[23]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[14]
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