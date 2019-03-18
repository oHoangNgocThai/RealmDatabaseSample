package android.thaihn.realmdatabasesample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.thaihn.realmdatabasesample.databinding.ActivityMainBinding
import android.thaihn.realmdatabasesample.entity.Student
import io.realm.Realm
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var mRealm: Realm? = null

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mRealm = Realm.getDefaultInstance()
    }

    private fun createDataDefault() {
        val realm = Realm.getDefaultInstance()
        realm.executeTransaction {
            val random = Random.nextInt(0, 100)
            val student = Student(random, "Hoang Ngoc Thai", 22)
            it.copyFromRealm(student)
        }
    }
}
