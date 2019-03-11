import 'dart:async';
import 'dart:io';
import 'package:flutter_button/model/address.dart';
import 'package:flutter_button/model/cart_model.dart';
import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';

class DataBaseHelper_address {
  final String tableUser = "addressTable";
  final String columnID = "_id";
  final String columnName = "_name";
  final String columnAddress = "_address";
  final String columnPhone = "_phone";
  final String columnNum = "_num";
  final String columnIsSelected = "_isSelected" ;

  static final DataBaseHelper_address instance =
      new DataBaseHelper_address.init();

  factory DataBaseHelper_address() => instance;

  static Database _db;

  Future<Database> get db async {
    if (_db != null) {
      return _db;
    }
    _db = await initDB();
    return _db;
  }

  DataBaseHelper_address.init();

  initDB() async {
    Directory documentDir = await getApplicationDocumentsDirectory();
    String path = join(documentDir.path, "Address.db");

    var ourDB = await openDatabase(path, version: 1, onCreate: _onCreate);
    return ourDB;
  }

  void _onCreate(Database db, int version) async {
    await db.execute(
        "CREATE TABLE $tableUser($columnID INTEGER PRIMARY KEY, $columnName TEXT, $columnAddress TEXT,$columnNum TEXT ,$columnPhone TEXT ,$columnIsSelected INTEGER)");
  }

  Future<int> saveAddress(Address add) async {
    var dbClient = await db;
    int result = await dbClient.insert("$tableUser", add.toMap());
    return result;
  }

  Future<List> getAllAdds() async {
    var dbClient = await db;
    var result = await dbClient.rawQuery("SELECT * FROM $tableUser");
    return result.toList();
  }

  Future<int> getCount() async {
    var dbClient = await db;
    return Sqflite.firstIntValue(
        await dbClient.rawQuery("SELECT COUNT(*) from $tableUser"));
  }

  Future<List<Address>> getUser() async {
    var dbClient = await db;
    var result = await dbClient.rawQuery("SELECT * FROM $tableUser ");
    List<Address> us = List();
    for (var add in result) {
      Address u = Address.fromMap(add);
      us.add(u);
    }
    return us;
  }

  Future<int> deleteAdd(int id) async {
    var dbClient = await db;
    return await dbClient
        .delete(tableUser, where: "$columnID = ?", whereArgs: [id]);
  }

  Future<int> updateAdd(Address user) async {
    var dbClient = await db;
    return await dbClient.update(tableUser, user.toMap(),
        where: "$columnID=?", whereArgs: [user.id]);
  }

  Future close() async {
    var dbClient = await db;
    return dbClient.close();
  }
}
