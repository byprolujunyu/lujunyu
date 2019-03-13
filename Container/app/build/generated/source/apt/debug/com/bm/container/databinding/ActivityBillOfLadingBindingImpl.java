package com.bm.container.databinding;
import com.bm.container.R;
import com.bm.container.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
@javax.annotation.Generated("Android Data Binding")
public class ActivityBillOfLadingBindingImpl extends ActivityBillOfLadingBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(34);
        sIncludes.setIncludes(1, 
            new String[] {"item_car"},
            new int[] {3},
            new int[] {R.layout.item_car});
        sIncludes.setIncludes(0, 
            new String[] {"topbar"},
            new int[] {2},
            new int[] {R.layout.topbar});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.refresh, 4);
        sViewsWithIds.put(R.id.scrollView, 5);
        sViewsWithIds.put(R.id.tvOrderNo, 6);
        sViewsWithIds.put(R.id.input_no, 7);
        sViewsWithIds.put(R.id.title, 8);
        sViewsWithIds.put(R.id.num, 9);
        sViewsWithIds.put(R.id.input_chest, 10);
        sViewsWithIds.put(R.id.add_chest, 11);
        sViewsWithIds.put(R.id.list_chest, 12);
        sViewsWithIds.put(R.id.input_name, 13);
        sViewsWithIds.put(R.id.input_phone, 14);
        sViewsWithIds.put(R.id.input_user, 15);
        sViewsWithIds.put(R.id.input_address, 16);
        sViewsWithIds.put(R.id.deliveryTime, 17);
        sViewsWithIds.put(R.id.check_group, 18);
        sViewsWithIds.put(R.id.money, 19);
        sViewsWithIds.put(R.id.no_money, 20);
        sViewsWithIds.put(R.id.input_money, 21);
        sViewsWithIds.put(R.id.input_email, 22);
        sViewsWithIds.put(R.id.ll_name, 23);
        sViewsWithIds.put(R.id.input_company_name, 24);
        sViewsWithIds.put(R.id.ll_add, 25);
        sViewsWithIds.put(R.id.input_company_email, 26);
        sViewsWithIds.put(R.id.list, 27);
        sViewsWithIds.put(R.id.llList, 28);
        sViewsWithIds.put(R.id.ll_button, 29);
        sViewsWithIds.put(R.id.button, 30);
        sViewsWithIds.put(R.id.model_button, 31);
        sViewsWithIds.put(R.id.left_button, 32);
        sViewsWithIds.put(R.id.right_button, 33);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityBillOfLadingBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 34, sIncludes, sViewsWithIds));
    }
    private ActivityBillOfLadingBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[11]
            , (android.widget.Button) bindings[30]
            , (android.widget.LinearLayout) bindings[18]
            , (android.widget.EditText) bindings[17]
            , (android.widget.EditText) bindings[16]
            , (android.widget.EditText) bindings[10]
            , (android.widget.EditText) bindings[26]
            , (android.widget.EditText) bindings[24]
            , (android.widget.EditText) bindings[22]
            , (android.widget.EditText) bindings[21]
            , (android.widget.EditText) bindings[13]
            , (android.widget.EditText) bindings[7]
            , (android.widget.EditText) bindings[14]
            , (android.widget.EditText) bindings[15]
            , (com.bm.container.databinding.ItemCarBinding) bindings[3]
            , (android.widget.TextView) bindings[32]
            , (com.bm.container.view.ExtraListView) bindings[27]
            , (com.bm.container.view.ExtraListView) bindings[12]
            , (android.widget.LinearLayout) bindings[25]
            , (android.widget.LinearLayout) bindings[29]
            , (android.widget.LinearLayout) bindings[28]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[31]
            , (android.widget.RadioButton) bindings[19]
            , (android.widget.RadioButton) bindings[20]
            , (android.widget.TextView) bindings[9]
            , (android.support.v4.widget.SwipeRefreshLayout) bindings[4]
            , (android.widget.TextView) bindings[33]
            , (android.widget.ScrollView) bindings[5]
            , (android.widget.TextView) bindings[8]
            , (com.bm.container.databinding.TopbarBinding) bindings[2]
            , (android.widget.TextView) bindings[6]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        topbar.invalidateAll();
        itemItemCar.invalidateAll();
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
        if (itemItemCar.hasPendingBindings()) {
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
        itemItemCar.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeTopbar((com.bm.container.databinding.TopbarBinding) object, fieldId);
            case 1 :
                return onChangeItemItemCar((com.bm.container.databinding.ItemCarBinding) object, fieldId);
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
    private boolean onChangeItemItemCar(com.bm.container.databinding.ItemCarBinding ItemItemCar, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        executeBindingsOn(itemItemCar);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): topbar
        flag 1 (0x2L): itemItemCar
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}