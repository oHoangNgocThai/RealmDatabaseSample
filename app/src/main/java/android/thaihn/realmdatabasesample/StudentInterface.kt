package android.thaihn.realmdatabasesample

import android.thaihn.realmdatabasesample.entity.Student
import io.realm.Realm
import io.realm.RealmResults

interface StudentInterface {
    fun addStudent(realm: Realm?, student: Student): Boolean
    fun deleteStudent(realm: Realm?, id: Int): Boolean
    fun updateStudent(realm: Realm?, student: Student): Boolean
    fun getStudent(realm: Realm?, id: Int): Student?
    fun getStudents(realm: Realm?): RealmResults<Student>?
    fun removeLastStudent(realm: Realm?)
    fun getLastStudent(realm: Realm?): Student?
}
