package Register.view

import Register.view.presentation.RegisterEmailPresenter
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
import com.example.instagram1.databinding.FragmentRegisterEmailBinding
import com.example.instagram1.databinding.FragmentRegisterNamePasswordBinding
import common.view.base.DependencyInjector
import common.view.util.TxtWatcher
import java.lang.IllegalArgumentException

class RegisterNamePasswordFragment : Fragment(R.layout.fragment_register_name_password),
    RegisterNameAndPassword.View {

    private var binding: FragmentRegisterNamePasswordBinding? = null
    private var fragmentAttachListener : FragmentAttachListener? = null

    override lateinit var presenter: RegisterNameAndPassword.Presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRegisterNamePasswordBinding.bind(view)

        val repository = DependencyInjector.registerEmailRepository()
        presenter = RegisterNameAndPasswordPresenter(this, repository)

        val email = arguments?.getString(KEY_EMAIL)?:throw IllegalArgumentException("email not foud")

        binding?.let {
            with(it) {

                loginTxtRegister.setOnClickListener(){
                    activity?.finish()
                }

                registerNameBtnNext.setOnClickListener() {
                    presenter.create(
                        email,
                        registerEditNameEmail.text.toString(),
                        registerEditPassword.text.toString(),
                        registerEditPasswordConfirm.text.toString()
                    )
                }

                registerEditNameEmail.addTextChangedListener(watcher)
                registerEditPassword.addTextChangedListener(watcher)
                registerEditPasswordConfirm.addTextChangedListener(watcher)

                registerEditNameEmail.addTextChangedListener(TxtWatcher{
                    displayNameFailure(null)
                })
                registerEditPassword.addTextChangedListener(TxtWatcher{
                    displayNameFailure(null)
                })
                registerEditPasswordConfirm.addTextChangedListener(TxtWatcher{
                    displayNameFailure(null)
                })
            }

        }

        Log.i("teste", email.toString())


    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListener){
            fragmentAttachListener = context
        }
    }


    override fun showProgress(enabled: Boolean) {
        binding?.registerNameBtnNext?.showProgress(enabled)
    }

    override fun displayNameFailure(nameError: Int?) {
        binding?.registerNameInput?.error = nameError?.let { getString(it) }
    }

    override fun displayPasswordFailure(passwordError: Int?) {
        binding?.registerPasswordEmailInput?.error = passwordError?.let { getString(it) }


    }

    override fun OncreateFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    override fun OncreateSucess(name: String) {
        fragmentAttachListener?.goToWelcomeScreen(name)
    }

    private val watcher = TxtWatcher {
        binding?.registerNameBtnNext?.isEnabled =
            binding?.registerEditNameEmail?.text.toString().isNotEmpty()
                    && binding?.registerEditPassword?.text.toString().isNotEmpty()
                    && binding?.registerEditPasswordConfirm?.text.toString().isNotEmpty()
    }

    override fun onDestroy() {
        binding = null
        presenter.onDestroy()
        super.onDestroy()
    }

    companion object {
        const val KEY_EMAIL = "key_email"
    }


}

