package kr.nepp.intent_20220516

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_CODE_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOther.setOnClickListener {
//            다른 화면으로 이동
            val myIntent = Intent(this, OtherActivity::class.java)
            startActivity(myIntent);
        }

        btnSendMessage.setOnClickListener {
//            1. 입력한 내용을 변수에 저장
            val inputMessage = edtMessage.text.toString()
            var myIntent = Intent(this, ViewMessageActivity::class.java)

//            출발 전에, 데이터를 첨부하자
            myIntent.putExtra("message", inputMessage)

//            2. 메세지 보여주는 화면으로 이동 (1의 변수를 들고)
            startActivity(myIntent)

        }

        btnEditNickname.setOnClickListener {

//            1. Inetne 만드는 방법은 동일

            val myIntent = Intent(this, EditNicknameActivity::class.java)

//            2. 편도 X, 왕복으로 간다고 명시.
            startActivityForResult(myIntent, REQ_CODE_NICKNAME)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        닉네임을 받아돌아온게 맞는가

        if(requestCode == REQ_CODE_NICKNAME) {

//            확인 누른게 맞는가
            if(resultCode == RESULT_OK) {
//                첨부된 닉네임을 꺼내서 => 텍스트뷰에 반영
//                data변수가 이전의 화면에 resultIntent를 담고 있다.

                val newNickname = data?.getStringExtra("nick")

                txtNickname.text = newNickname
            }
        }
    }
}