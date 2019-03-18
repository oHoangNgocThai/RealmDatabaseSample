package android.thaihn.realmdatabasesample

import android.thaihn.realmdatabasesample.entity.Student
import io.realm.Realm

interface StudentInterface {
    fun addStudent(realm: Realm, student: Student): Boolean
    fun deleteStudent(realm: Realm, student: Student): Boolean
    fun updateStudent(realm: Realm, student: Student): Boolean
    fun getStudent(realm: Realm, id: Int): Student
    fun removeLastStudent(realm: Realm)
}
