package android.thaihn.realmdatabasesample.entity

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Student(

    @PrimaryKey open var id: Int,

    open var name: String,

    open var age: Int

) : RealmObject() {

    fun copy(
        _id: Int = this.id,
        _name: String = this.name,
        _age: Int = this.age
    ) = Student(_id, _name, _age)

}
