package com.cookandroid.myapplication

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.kakao.sdk.user.UserApiClient
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val items = arrayOf("..월","1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월")
        val items1 = resources.getStringArray(R.array.my_array)
        val items2 = resources.getStringArray(R.array.position)

        val myAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        val myAdapter1 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items1)
        val myAdapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items2)

        spinner_month.adapter = myAdapter
        spinner_day.adapter = myAdapter1
        spinner_position.adapter = myAdapter2

        spinner_month.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                //아이템이 클릭 되면 맨 위부터 position 0번부터 순서대로 동작하게 됩니다.
                when(position) {
                    0   ->  {
                    }
                    1   ->  {
                    }
                    //...
                    else -> {
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        spinner_day.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                //아이템이 클릭 되면 맨 위부터 position 0번부터 순서대로 동작하게 됩니다.
                when(position) {
                    0   ->  {
                    }
                    1   ->  {
                    }
                    //...
                    else -> {
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
        spinner_position.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                //아이템이 클릭 되면 맨 위부터 position 0번부터 순서대로 동작하게 됩니다.
                when(position) {
                    0   ->  {
                    }
                    1   ->  {
                    }
                    //...
                    else -> {
                    }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }


        UserApiClient.instance.me { user, error ->
            id.text = "회원번호: ${user?.id}"
            nickname.text = "닉네임: ${user?.kakaoAccount?.profile?.nickname}"
            profileimage_url.text = "프로필 링크: ${user?.kakaoAccount?.profile?.profileImageUrl}"
            thumbnailimage_url.text = "썸네일 링크: ${user?.kakaoAccount?.profile?.thumbnailImageUrl}"
        }

        kakao_logout_button.setOnClickListener {
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Toast.makeText(this, "로그아웃 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "로그아웃 성공", Toast.LENGTH_SHORT).show()
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
            }
        }

        kakao_unlink_button.setOnClickListener {
            UserApiClient.instance.unlink { error ->
                if (error != null) {
                    Toast.makeText(this, "회원 탈퇴 실패 $error", Toast.LENGTH_SHORT).show()
                }else {
                    Toast.makeText(this, "회원 탈퇴 성공", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP))
                }
            }
        }



    }
}