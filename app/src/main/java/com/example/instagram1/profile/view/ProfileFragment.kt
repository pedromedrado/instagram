package com.example.instagram1.profile.view

import android.view.*
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.instagram1.R
import com.example.instagram1.databinding.FragmentProfileBinding
import com.example.instagram1.profile.view.data.presenter.ProfilePresenter
import common.view.Post
import common.view.base.BaseFragment
import common.view.base.DependencyInjector
import common.view.model.UserAuth

class ProfileFragment : BaseFragment<FragmentProfileBinding, Profile.Presenter>(
    R.layout.fragment_profile,
    FragmentProfileBinding::bind
), Profile.View {
    override lateinit var presenter: Profile.Presenter
    private val adapter = PostAdapter()



    override fun setupPresenter() {
        val repository =  DependencyInjector.profileRepository()
        presenter = ProfilePresenter(this,repository)

    }


    override fun setupViews() {

        binding?.profileRv?.layoutManager = GridLayoutManager(requireContext(), 3)
        binding?.profileRv?.adapter = adapter
    }

    override fun getMenu(): Int {
        return R.menu.menu_profile
    }


    override fun ShowProgress(enabled: Boolean) {
        binding?.progressProfile?.visibility = if (enabled) View.VISIBLE else View.GONE
    }

    override fun displayUserProfile(userAuth: UserAuth) {
        binding?.profileTxtPostsCount?.text = userAuth.postCount.toString()
        binding?.profileTxtFollowersCount?.text = userAuth.followingCount.toString()
        binding?.profileTxtFollowers?.text = userAuth.followersCount.toString()
        binding?.profileTxtUsername?.text = userAuth.name
        binding?.profileTxtBio

        presenter.fetchUserPosts()
    }

    override fun displayEmptyPosts() {
        binding?.profileTxtEmpty?.visibility = View.VISIBLE
        binding?.profileRv?.visibility = View.GONE
    }

    override fun displayFullPosts(posts: List<Post>) {
        binding?.profileTxtEmpty?.visibility = View.GONE
        binding?.profileRv?.visibility = View.VISIBLE
        adapter.items = posts
        adapter.notifyDataSetChanged()


    }

    override fun displayRequestFailure(message: String) {
        Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
    }
}
