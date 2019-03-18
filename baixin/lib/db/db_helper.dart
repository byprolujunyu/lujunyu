import 'dart:async';
import 'dart:io';
import 'package:flutter_button/model/cart_model.dart';
import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';
import 'package:sqflite/sqflite.dart';
import '../service/service_method.dart';

class DataBaseHelper {
  final String tableUser = "cartTable";
  final String columnID = "_id";
  final String columnName = "_name";
  final String columnImage = "_image";
  final String columnPrice = "_price";
  final String columnCount = "_count";

  static final DataBaseHelper instance = new DataBaseHelper.init();

  factory DataBaseHelper() => instance;

  static Database _db;

  Future<Database> get db async {
    if (_db != null) {
      return _db;
    }
    _db = await initDB();
    return _db;
  }

  DataBaseHelper.init();

  initDB() async {
    Directory documentDir = await getApplicationDocumentsDirectory();
    String path = join(documentDir.path, "MainDb.db");

    var ourDB = await openDatabase(path, version: 1, onCreate: _onCreate);
    return ourDB;
  }

  void _onCreate(Database db, int version) async {
    await db.execute(
        "CREATE TABLE $tableUser($columnID INTEGER PRIMARY KEY, $columnName TEXT, $columnImage TEXT UNIQUE,$columnPrice DOUBLE ,$columnCount INTEGER )");
  }

  Future<int> saveUser(User user) async {
    var dbClient = await db;
    var result = await dbClient.insert("$tableUser", user.toMap());
    return result;
  }

  Future saveNewUser(User user) async {
    var dbClient = await db;
    int result = await dbClient.insert("$tableUser", user.toMap());
  }

  Future<List> getAllUsers() async {
    var dbClient = await db;
    var result = await dbClient.rawQuery("SELECT * FROM $tableUser");
    return result.toList();
  }

  Future<bool> judge(String image) async {
    var dbClient = await db;
    var count = await dbClient.rawQuery(
        "SELECT COUNT(*) from $tableUser where $columnImage = ?", [image]);
    return (count == 0 && count == 1) ? false : true;
  }

  Future<int> getCount() async {
    var dbClient = await db;
    return Sqflite.firstIntValue(
        await dbClient.rawQuery("SELECT COUNT(*) from $tableUser"));
  }

  Future<List<User>> getUser() async {
    var dbClient = await db;
    var result = await dbClient.rawQuery("SELECT * FROM $tableUser ");
    List<User> us = List();
    for (var user in result) {
      User u = User.fromMap(user);
      us.add(u);
    }
    return us;
  }

  Future<int> deleteUser(int id) async {
    var dbClient = await db;
    return await dbClient
        .delete(tableUser, where: "$columnID = ?", whereArgs: [id]);
  }

  Future<int> deleteAll() async {
    var dbClient = await db;
    return await dbClient
        .delete(tableUser);
  }

  Future<int> updateUser(User user) async {
    var dbClient = await db;
    return await dbClient.update(tableUser, user.toMap(),
        where: "$columnID=?", whereArgs: [user.id]);
  }

  Future close() async {
    var dbClient = await db;
    return dbClient.close();
  }
}
