import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';
import 'dart:io';

class DataBase {

  static final DataBase _instance = new DataBase.internal();
  factory DataBase() => _instance;

  static Database _db;

  String _dbName = 'mydb.db';

  Future<Database> get db async {
    if (_db != null) {
      return _db;
    }
    _db = await initDb();
    return _db;
  }

  DataBase.internal();

  //初始化数据库，根据路径版本号新建数据库
  initDb() async {
    // Directory directory = await getApplicationDocumentsDirectory();
    String p = await getDatabasesPath();
    String path = join(p, _dbName);
    var dataBase = await openDatabase(path, version: 1, onCreate: _onCreate);
    print('数据库创建成功，version： 1');
    return dataBase;
  }

  _onCreate(Database db, int version) async {
    // When creating the db, create the table
    await db.execute('CREATE TABLE Test (id INTEGER PRIMARY KEY, '
        'name TEXT, '
        'value INTEGER, '
        'num REAL)');
    print("创建表成功！");
  }


  closeDB() {
    if (_db != null || _db.isOpen) {
      _db.close();
      _db = null;
      print("关闭成功！");
    }
  }

  insert() async {

    var dbClient = await db;

    await dbClient.transaction((txn) async {
      int id1 = await txn.rawInsert(
          'INSERT INTO Test(name, value, num) VALUES("some name", 1234, 456.789)');
      print('inserted1: $id1');
      int id2 = await txn.rawInsert(
          'INSERT INTO Test(name, value, num) VALUES(?, ?, ?)',
          ['another name', 12345678, 3.1416]);
      print('inserted2: $id2');
    });
  }

 void insertNew() async {
    var dbClient = await db;
    await dbClient.execute('insert into Test(name,value,num) values("123",123,456)');
  }

 Future<List> query() async {

    var dbClient = await db;

    insertNew();

    List<Map> list = await dbClient.rawQuery('SELECT * FROM Test');
    print(list);
    return list;
  }
}