import 'package:sqflite/sqflite.dart';

final String tableTodo = 'cart_normal';
final String columnId = '_id';
final String columnName = '_name';
final String columnImageuri = '_imageuri';
final String columnCount = '_count';
final String columnPrice = '_price';

class Todo {
  int id;
  String name;
  String imageuri;
  int isSelected;
  int count;
  int isDelete;
  int price;



  Todo({this.name, this.imageuri, this.count,
       this.price});

  Map<String, dynamic> toMap() {
    var map = <String, dynamic>{
      columnName: name,
      columnImageuri: imageuri,
      columnCount: count,
      columnPrice: price,
    };
    if (id != null) {
      map[columnId] = id;
    }
    return map;
  }



  Todo.fromMap(Map<String, dynamic> map) {
    id = map[columnId];
    name = map[columnName];
    imageuri = map[columnImageuri];
    count = map[columnCount];
    price = map[columnPrice];
  }


}

class TodoProvider {
  Database db;


  TodoProvider(){
    open('cart.db');
  }

  Future open(String path) async {
    db = await openDatabase(path, version: 1,
        onCreate: (Database db, int version) async {
      await db.execute('''
create table $tableTodo ( 
  $columnId integer primary key autoincrement, 
  $columnName text not null,
  $columnImageuri text not null,
  $columnCount integer not null)
  $columnPrice integer not null)
''');
    });
  }

  Future<Todo> insert(Todo todo) async {
    todo.id = await db.insert(tableTodo, todo.toMap());
    return todo;
  }

  Future<List<Map>> getTodo() async {
    List<Map> maps = await db.query(tableTodo,
        columns: [
          columnId,
          columnName,
          columnImageuri,
          columnPrice,
          columnCount
        ],
    );
    return maps;
  }

  Future<int> delete(int id) async {
    return await db.delete(tableTodo, where: '$columnId = ?', whereArgs: [id]);
  }

  Future<int> update(Todo todo) async {
    return await db.update(tableTodo, todo.toMap(),
        where: '$columnId = ?', whereArgs: [todo.id]);
  }

  Future close() async => db.close();
}
