package android.thaihn.realmdatabasesample

import android.thaihn.realmdatabasesample.entity.Student
import io.realm.Realm
import io.realm.RealmResults

class StudentModel : StudentInterface {

    override fun addStudent(realm: Realm?, student: Student): Boolean {
        return try {
            realm?.let {
                it.beginTransaction()
                it.copyToRealmOrUpdate(student)
                it.commitTransaction()
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override fun deleteStudent(realm: Realm?, id: Int): Boolean {
        return try {
            realm?.let {
                it.beginTransaction()
                it.where(Student::class.java).equalTo("id", id).findFirst()?.deleteFromRealm()
                it.commitTransaction()
                true
            }
            false
        } catch (ex: Exception) {
            ex.printStackTrace()
            false
        }


    }

    override fun updateStudent(realm: Realm?, student: Student): Boolean {
        return try {
            realm?.let {
                it.beginTransaction()
                it.copyToRealm(student)
                it.commitTransaction()
                true
            }
            false
        } catch (ex: Exception) {
            ex.printStackTrace()
            false
        }
    }

    override fun getStudent(realm: Realm?, id: Int): Student? {
        return realm?.where(Student::class.java)?.equalTo("id", id)?.findFirst()
    }

    override fun getStudents(realm: Realm?): RealmResults<Student>? {
        return realm?.where(Student::class.java)?.findAll()
    }

    override fun removeLastStudent(realm: Realm?) {
        realm?.let {
            it.beginTransaction()
            getLastStudent(realm)?.deleteFromRealm()
            it.commitTransaction()
        }
    }

    override fun getLastStudent(realm: Realm?): Student? {
        return realm?.where(Student::class.java)?.findAll()?.last()
    }

}
