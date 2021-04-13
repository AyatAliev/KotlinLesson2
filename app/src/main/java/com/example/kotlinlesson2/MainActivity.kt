package com.example.kotlinlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.kotlinlesson2.extension.loadImage
import com.example.kotlinlesson2.extension.showToast
import com.example.kotlinlesson2.extension.visible
import com.example.kotlinlesson2.model.Contact
import com.example.kotlinlesson2.model.Member
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val conctats = mutableListOf<Member>()
    private val conctat = List(1) { Member("Ayat", "996700000000", true) }
    private val myContact = Contact()


    // List, HashMap, Set, HashSet, LinkedList
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addContact()
        displayContacts()
        tv_title.visible = true
        conctats.clear()
        initListener()
        btn_add.setOnClickListener {
            tv_title.text = conctats.toString()
        }
//        test_image.loadImage(this,"https://i.pinimg.com/originals/94/1a/16/941a1638848c06d3d83139f2ba267c9d.jpg")
    }

    private fun initListener() {
        input_collection.setOnEditorActionListener(object : TextView.OnEditorActionListener{
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {

                if (actionId == EditorInfo.IME_ACTION_SEND){
                    conctats.add(Member(name = input_collection.text.toString()))
                    return true
                }

                return false
            }

        })
    }

    private fun displayContacts() {

        for (contact in conctats) {
            var name: String = ""
           if (contact.name != null) {
               name = contact.name!!
           }

            showToast(contact.name.toString())
        }

        showToast(conctats.toString())
    }

    private fun addContact() {
        conctats.add(Member("Ayat", "996700000000", true))
        conctats.add(Member(phone = "99650000000", isFriend = false))
        conctats.add(Member(phone = "99650000000", isFriend = false))
        conctats.add(Member(phone = "99650000000", isFriend = false))
        conctats.add(Member(phone = "99650000000", isFriend = false))
    }

}