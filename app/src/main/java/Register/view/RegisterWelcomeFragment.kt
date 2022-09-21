package Register.view

import Register.view.presentation.RegisterNameAndPasswordPresenter
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.instagram1.R
import com.example.instagram1.databinding.FragmentRegisterNamePasswordBinding
import com.example.instagram1.databinding.FragmentRegisterWelcomeBinding
import common.view.base.DependencyInjector
import common.view.util.TxtWatcher
import java.lang.IllegalArgumentException

class RegisterWelcomeFragment : Fragment(R.layout.fragment_register_welcome) {

        private var binding: FragmentRegisterWelcomeBinding? = null
        private var fragmentAttachListener : FragmentAttachListener? = null




        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding = FragmentRegisterWelcomeBinding.bind(view)


            val name = arguments?.getString(KEY_NAME)?:throw IllegalArgumentException("name not foud")

            binding?.let {
                with(it) {

                    registerBtnNext.isEnabled = true
                    registerTxtWelcome.text = getString(R.string.welcome_to_instagram,name)
                    registerBtnNext.setOnClickListener{
                        fragmentAttachListener?.goToPhotoScreen()
                    }
                }
            }
        }
        override fun onAttach(context: Context) {
            super.onAttach(context)
            if (context is FragmentAttachListener){
                fragmentAttachListener = context
            }
        }


        override fun onDestroy() {
            binding = null
            super.onDestroy()
        }

        companion object {
            const val KEY_NAME = "key_name"
        }


    }
