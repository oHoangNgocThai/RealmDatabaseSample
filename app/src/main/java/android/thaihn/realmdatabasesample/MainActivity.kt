package android.thaihn.realmdatabasesample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.thaihn.realmdatabasesample.databinding.ActivityMainBinding
import android.thaihn.realmdatabasesample.entity.Student
import android.thaihn.realmdatabasesample.ui.StudentAdapter
import android.widget.Toast
import io.realm.Realm
import kotlin.random.Random

class MainActivity : AppCompatActivity(), StudentAdapter.StudentListener {

    private var mRealm: Realm? = null

    private var mStudentModel = StudentModel()

    private val mStudentAdapter = StudentAdapter(arrayListOf(), this)

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mRealm = Realm.getDefaultInstance()

        mainBinding.rvStudent.apply {
            adapter = mStudentAdapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }

        mStudentModel.getStudents(mRealm)?.let {
            if (it.count() > 0) {
                updateUi(mRealm)
            }
        }

        mainBinding.btnAdd.setOnClickListener {
            val name = mainBinding.edtName.text.toString().trim()
            val age = mainBinding.edtAge.text.toString().trim()
            if (name.isEmpty()) {
                Toast.makeText(applicationContext, "Name is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (age.isEmpty()) {
                Toast.makeText(applicationContext, "Age is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val student = Student(Random.nextInt(0, 100), name, age.toInt())

        }
    }

    override fun onItemClick(item: Student) {

    }

    private fun updateUi(realm: Realm?) {
        val results = arrayListOf<Student>()
        mStudentModel.getStudents(realm)?.forEach { student ->
            results.add(student)
        }
        mStudentAdapter.updateData(results)
    }

}
