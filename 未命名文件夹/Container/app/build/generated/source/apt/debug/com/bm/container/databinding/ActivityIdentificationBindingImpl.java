package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityIdentificationBindingImpl extends ActivityIdentificationBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(51);
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {1},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 2);
        sViewsWithIds.put(R.id.focus, 3);
        sViewsWithIds.put(R.id.seller, 4);
        sViewsWithIds.put(R.id.buyer, 5);
        sViewsWithIds.put(R.id.personal, 6);
        sViewsWithIds.put(R.id.company, 7);
        sViewsWithIds.put(R.id.tv_info, 8);
        sViewsWithIds.put(R.id.tv_userId, 9);
        sViewsWithIds.put(R.id.id, 10);
        sViewsWithIds.put(R.id.name, 11);
        sViewsWithIds.put(R.id.name_text, 12);
        sViewsWithIds.put(R.id.phone, 13);
        sViewsWithIds.put(R.id.phone_text, 14);
        sViewsWithIds.put(R.id.address, 15);
        sViewsWithIds.put(R.id.weixin, 16);
        sViewsWithIds.put(R.id.weixin_text, 17);
        sViewsWithIds.put(R.id.qq, 18);
        sViewsWithIds.put(R.id.qq_text, 19);
        sViewsWithIds.put(R.id.company_name, 20);
        sViewsWithIds.put(R.id.company_name_text, 21);
        sViewsWithIds.put(R.id.company_legal_entity, 22);
        sViewsWithIds.put(R.id.company_phone, 23);
        sViewsWithIds.put(R.id.company_phone_text, 24);
        sViewsWithIds.put(R.id.company_address, 25);
        sViewsWithIds.put(R.id.company_address_text, 26);
        sViewsWithIds.put(R.id.company_person_in_charge, 27);
        sViewsWithIds.put(R.id.company_person_in_charge_text, 28);
        sViewsWithIds.put(R.id.bank_id_name, 29);
        sViewsWithIds.put(R.id.bank_name_text, 30);
        sViewsWithIds.put(R.id.bank, 31);
        sViewsWithIds.put(R.id.bank_text, 32);
        sViewsWithIds.put(R.id.bank_id, 33);
        sViewsWithIds.put(R.id.bank_id_text, 34);
        sViewsWithIds.put(R.id.country, 35);
        sViewsWithIds.put(R.id.countryText, 36);
        sViewsWithIds.put(R.id.city, 37);
        sViewsWithIds.put(R.id.city_text, 38);
        sViewsWithIds.put(R.id.chooose_city, 39);
        sViewsWithIds.put(R.id.delete, 40);
        sViewsWithIds.put(R.id.add, 41);
        sViewsWithIds.put(R.id.gridview, 42);
        sViewsWithIds.put(R.id.choose_city_tip, 43);
        sViewsWithIds.put(R.id.viewllBusinessLicense, 44);
        sViewsWithIds.put(R.id.llBusinessLicense, 45);
        sViewsWithIds.put(R.id.ivAddBusinessLicense, 46);
        sViewsWithIds.put(R.id.llIdentity, 47);
        sViewsWithIds.put(R.id.ivAddPositive, 48);
        sViewsWithIds.put(R.id.ivAddTheOtherSide, 49);
        sViewsWithIds.put(R.id.register, 50);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityIdentificationBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 51, sIncludes, sViewsWithIds));
    }
    private ActivityIdentificationBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.TextView) bindings[41]
            , (android.widget.LinearLayout) bindings[15]
            , (android.widget.LinearLayout) bindings[31]
            , (android.widget.LinearLayout) bindings[33]
            , (android.widget.LinearLayout) bindings[29]
            , (com.bm.container.view.XEditText) bindings[34]
            , (android.widget.EditText) bindings[30]
            , (android.widget.TextView) bindings[32]
            , (android.widget.RadioButton) bindings[5]
            , (android.widget.LinearLayout) bindings[39]
            , (android.widget.TextView) bindings[43]
            , (android.widget.LinearLayout) bindings[37]
            , (android.widget.TextView) bindings[38]
            , (android.widget.RadioButton) bindings[7]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.EditText) bindings[26]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.LinearLayout) bindings[20]
            , (android.widget.EditText) bindings[21]
            , (android.widget.LinearLayout) bindings[27]
            , (android.widget.EditText) bindings[28]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.EditText) bindings[24]
            , (android.widget.LinearLayout) bindings[35]
            , (android.widget.TextView) bindings[36]
            , (android.widget.TextView) bindings[40]
            , (android.widget.LinearLayout) bindings[3]
            , (com.bm.container.view.ExtraGridView) bindings[42]
            , (android.widget.TextView) bindings[10]
            , (android.widget.ImageView) bindings[46]
            , (android.widget.ImageView) bindings[48]
            , (android.widget.ImageView) bindings[49]
            , (android.widget.LinearLayout) bindings[45]
            , (android.widget.LinearLayout) bindings[47]
            , (android.widget.LinearLayout) bindings[11]
            , (android.widget.EditText) bindings[12]
            , (android.widget.RadioButton) bindings[6]
            , (android.widget.LinearLayout) bindings[13]
            , (android.widget.EditText) bindings[14]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.EditText) bindings[19]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[2]
            , (android.widget.Button) bindings[50]
            , (android.widget.RadioButton) bindings[4]
            , (com.bm.container.databinding.TopbarBinding) bindings[1]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.view.View) bindings[44]
            , (android.widget.LinearLayout) bindings[16]
            , (android.widget.EditText) bindings[17]
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