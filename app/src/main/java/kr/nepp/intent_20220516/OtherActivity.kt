package kr.nepp.intent_20220516

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        btnReturn.setOnClickListener {

//            메인화면으로 돌아가기

//            var myIntent = Intent(this, MainActivity::class.java)
//            startActivity(myIntent)

//            현재화면 종료 > 이전 화면이 다시 나타남
            finish()
        }
    }
}