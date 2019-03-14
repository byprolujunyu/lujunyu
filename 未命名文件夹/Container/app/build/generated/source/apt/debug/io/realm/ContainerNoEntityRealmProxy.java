package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContainerNoEntityRealmProxy extends com.bm.container.module.base.Entity.ContainerNoEntity
    implements RealmObjectProxy, ContainerNoEntityRealmProxyInterface {

    static final class ContainerNoEntityColumnInfo extends ColumnInfo
        implements Cloneable {

        public long noIndex;
        public long numberIndex;

        ContainerNoEntityColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.noIndex = getValidColumnIndex(path, table, "ContainerNoEntity", "no");
            indicesMap.put("no", this.noIndex);
            this.numberIndex = getValidColumnIndex(path, table, "ContainerNoEntity", "number");
            indicesMap.put("number", this.numberIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ContainerNoEntityColumnInfo otherInfo = (ContainerNoEntityColumnInfo) other;
            this.noIndex = otherInfo.noIndex;
            this.numberIndex = otherInfo.numberIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ContainerNoEntityColumnInfo clone() {
            return (ContainerNoEntityColumnInfo) super.clone();
        }

    }
    private ContainerNoEntityColumnInfo columnInfo;
    private ProxyState<com.bm.container.module.base.Entity.ContainerNoEntity> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("no");
        fieldNames.add("number");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ContainerNoEntityRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ContainerNoEntityColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.bm.container.module.base.Entity.ContainerNoEntity>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$no() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.noIndex);
    }

    public void realmSet$no(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.noIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.noIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.noIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.noIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$number() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.numberIndex);
    }

    public void realmSet$number(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.numberIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.numberIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numberIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.numberIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ContainerNoEntity")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ContainerNoEntity");
            realmObjectSchema.add(new Property("no", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("number", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("ContainerNoEntity");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_ContainerNoEntity")) {
            Table table = sharedRealm.getTable("class_ContainerNoEntity");
            table.addColumn(RealmFieldType.STRING, "no", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "number", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_ContainerNoEntity");
    }

    public static ContainerNoEntityColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_ContainerNoEntity")) {
            Table table = sharedRealm.getTable("class_ContainerNoEntity");
            final long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final ContainerNoEntityColumnInfo columnInfo = new ContainerNoEntityColumnInfo(sharedRealm.getPath(), table);

            if (table.hasPrimaryKey()) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
            }

            if (!columnTypes.containsKey("no")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'no' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("no") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'no' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.noIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'no' is required. Either set @Required to field 'no' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("number")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'number' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("number") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'number' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.numberIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'number' is required. Either set @Required to field 'number' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ContainerNoEntity' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_ContainerNoEntity";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.bm.container.module.base.Entity.ContainerNoEntity createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.bm.container.module.base.Entity.ContainerNoEntity obj = realm.createObjectInternal(com.bm.container.module.base.Entity.ContainerNoEntity.class, true, excludeFields);
        if (json.has("no")) {
            if (json.isNull("no")) {
                ((ContainerNoEntityRealmProxyInterface) obj).realmSet$no(null);
            } else {
                ((ContainerNoEntityRealmProxyInterface) obj).realmSet$no((String) json.getString("no"));
            }
        }
        if (json.has("number")) {
            if (json.isNull("number")) {
                ((ContainerNoEntityRealmProxyInterface) obj).realmSet$number(null);
            } else {
                ((ContainerNoEntityRealmProxyInterface) obj).realmSet$number((String) json.getString("number"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.bm.container.module.base.Entity.ContainerNoEntity createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.bm.container.module.base.Entity.ContainerNoEntity obj = new com.bm.container.module.base.Entity.ContainerNoEntity();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("no")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ContainerNoEntityRealmProxyInterface) obj).realmSet$no(null);
                } else {
                    ((ContainerNoEntityRealmProxyInterface) obj).realmSet$no((String) reader.nextString());
                }
            } else if (name.equals("number")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ContainerNoEntityRealmProxyInterface) obj).realmSet$number(null);
                } else {
                    ((ContainerNoEntityRealmProxyInterface) obj).realmSet$number((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.bm.container.module.base.Entity.ContainerNoEntity copyOrUpdate(Realm realm, com.bm.container.module.base.Entity.ContainerNoEntity object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.bm.container.module.base.Entity.ContainerNoEntity) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.bm.container.module.base.Entity.ContainerNoEntity copy(Realm realm, com.bm.container.module.base.Entity.ContainerNoEntity newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.bm.container.module.base.Entity.ContainerNoEntity) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.bm.container.module.base.Entity.ContainerNoEntity realmObject = realm.createObjectInternal(com.bm.container.module.base.Entity.ContainerNoEntity.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ContainerNoEntityRealmProxyInterface) realmObject).realmSet$no(((ContainerNoEntityRealmProxyInterface) newObject).realmGet$no());
            ((ContainerNoEntityRealmProxyInterface) realmObject).realmSet$number(((ContainerNoEntityRealmProxyInterface) newObject).realmGet$number());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.bm.container.module.base.Entity.ContainerNoEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bm.container.module.base.Entity.ContainerNoEntity.class);
        long tableNativePtr = table.getNativeTablePointer();
        ContainerNoEntityColumnInfo columnInfo = (ContainerNoEntityColumnInfo) realm.schema.getColumnInfo(com.bm.container.module.base.Entity.ContainerNoEntity.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$no = ((ContainerNoEntityRealmProxyInterface)object).realmGet$no();
        if (realmGet$no != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noIndex, rowIndex, realmGet$no, false);
        }
        String realmGet$number = ((ContainerNoEntityRealmProxyInterface)object).realmGet$number();
        if (realmGet$number != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numberIndex, rowIndex, realmGet$number, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bm.container.module.base.Entity.ContainerNoEntity.class);
        long tableNativePtr = table.getNativeTablePointer();
        ContainerNoEntityColumnInfo columnInfo = (ContainerNoEntityColumnInfo) realm.schema.getColumnInfo(com.bm.container.module.base.Entity.ContainerNoEntity.class);
        com.bm.container.module.base.Entity.ContainerNoEntity object = null;
        while (objects.hasNext()) {
            object = (com.bm.container.module.base.Entity.ContainerNoEntity) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$no = ((ContainerNoEntityRealmProxyInterface)object).realmGet$no();
                if (realmGet$no != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noIndex, rowIndex, realmGet$no, false);
                }
                String realmGet$number = ((ContainerNoEntityRealmProxyInterface)object).realmGet$number();
                if (realmGet$number != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.numberIndex, rowIndex, realmGet$number, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.bm.container.module.base.Entity.ContainerNoEntity object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.bm.container.module.base.Entity.ContainerNoEntity.class);
        long tableNativePtr = table.getNativeTablePointer();
        ContainerNoEntityColumnInfo columnInfo = (ContainerNoEntityColumnInfo) realm.schema.getColumnInfo(com.bm.container.module.base.Entity.ContainerNoEntity.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$no = ((ContainerNoEntityRealmProxyInterface)object).realmGet$no();
        if (realmGet$no != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.noIndex, rowIndex, realmGet$no, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.noIndex, rowIndex, false);
        }
        String realmGet$number = ((ContainerNoEntityRealmProxyInterface)object).realmGet$number();
        if (realmGet$number != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numberIndex, rowIndex, realmGet$number, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numberIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.bm.container.module.base.Entity.ContainerNoEntity.class);
        long tableNativePtr = table.getNativeTablePointer();
        ContainerNoEntityColumnInfo columnInfo = (ContainerNoEntityColumnInfo) realm.schema.getColumnInfo(com.bm.container.module.base.Entity.ContainerNoEntity.class);
        com.bm.container.module.base.Entity.ContainerNoEntity object = null;
        while (objects.hasNext()) {
            object = (com.bm.container.module.base.Entity.ContainerNoEntity) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$no = ((ContainerNoEntityRealmProxyInterface)object).realmGet$no();
                if (realmGet$no != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.noIndex, rowIndex, realmGet$no, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.noIndex, rowIndex, false);
                }
                String realmGet$number = ((ContainerNoEntityRealmProxyInterface)object).realmGet$number();
                if (realmGet$number != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.numberIndex, rowIndex, realmGet$number, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numberIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.bm.container.module.base.Entity.ContainerNoEntity createDetachedCopy(com.bm.container.module.base.Entity.ContainerNoEntity realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.bm.container.module.base.Entity.ContainerNoEntity unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.bm.container.module.base.Entity.ContainerNoEntity)cachedObject.object;
            } else {
                unmanagedObject = (com.bm.container.module.base.Entity.ContainerNoEntity)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.bm.container.module.base.Entity.ContainerNoEntity();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ContainerNoEntityRealmProxyInterface) unmanagedObject).realmSet$no(((ContainerNoEntityRealmProxyInterface) realmObject).realmGet$no());
        ((ContainerNoEntityRealmProxyInterface) unmanagedObject).realmSet$number(((ContainerNoEntityRealmProxyInterface) realmObject).realmGet$number());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ContainerNoEntity = [");
        stringBuilder.append("{no:");
        stringBuilder.append(realmGet$no() != null ? realmGet$no() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{number:");
        stringBuilder.append(realmGet$number() != null ? realmGet$number() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerNoEntityRealmProxy aContainerNoEntity = (ContainerNoEntityRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aContainerNoEntity.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aContainerNoEntity.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aContainerNoEntity.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
