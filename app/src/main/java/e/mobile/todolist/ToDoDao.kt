package e.mobile.todolist

import android.arch.persistence.room.*

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: ToDoObject)

    @Query("SELECT * FROM TodoObject")
    fun getAll(): List<ToDoObject>

    @Delete
    fun delete(todo: ToDoObject)

    @Query("SELECT * FROM TodoObject WHERE ToDoID = :ToDoID LIMIT 1")
    fun getToDo(ToDoID: Int): ToDoObject
}