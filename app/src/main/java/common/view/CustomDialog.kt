package common.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.instagram1.R
import com.example.instagram1.databinding.DialogCustomBinding

class CustomDialog(context: Context): Dialog(context) {
    private lateinit var binding: DialogCustomBinding

    private lateinit var dialogLinearLayout: LinearLayout
    private lateinit var txtButtons:Array<TextView>
    private lateinit var txtTitle:TextView
    private var titleId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        binding = DialogCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.dialogTitle
        //dialogLinearLayout = binding.dialogContainer


    }

    override fun setTitle(titleId:Int) {
        this.titleId = titleId
    }



    fun addbutton(vararg texts: Int,listener: View.OnClickListener ){
        txtButtons = Array(texts.size){
            TextView(context)
        }
        texts.forEachIndexed{ index, txtid ->
            txtButtons[index].id = txtid
            txtButtons[index].setText(txtid)
            txtButtons[index].setOnClickListener{
                listener.onClick(it)
                dismiss()
            }


        }
    }

    override fun show() {
        super.show()

        titleId?.let {
            binding.dialogTitle.setText(it)
        }
        for (textView in txtButtons) {

            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(30,50,30,50)
            binding.dialogContainer.addView(textView,layoutParams)
        }
    }
}