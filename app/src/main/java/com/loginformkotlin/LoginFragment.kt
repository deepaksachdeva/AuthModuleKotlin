package com.loginformkotlin

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LoginFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() , View.OnClickListener{

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var authActivity: AuthActivity? = null

    private var mListener: OnFragmentInteractionListener? = null

    private var etUserName: EditText?=null
    private var etPassword: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_login, container, false)

        etUserName = view.findViewById<EditText>(R.id.et_user_name)
        etPassword = view.findViewById<EditText>(R.id.et_password)
        val tvSignupOption = view.findViewById<TextView>(R.id.tv_signup_option)
        val tvForgotPassword = view.findViewById<TextView>(R.id.tv_forgot_password)
        val btnReset = view.findViewById<Button>(R.id.btn_reset)
        val btnSubmit = view.findViewById<Button>(R.id.btn_submit)

        tvSignupOption.setOnClickListener(this)
        tvForgotPassword.setOnClickListener(this)
        btnReset.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)
//        btnReset.setOnClickListener{
//            etUserName.se
//        }
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        authActivity = context as AuthActivity?
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): LoginFragment {
            val fragment = LoginFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_signup_option ->{
                authActivity!!.replaceAuthsFragment(SignUpFragment())
            }
            R.id.tv_forgot_password ->{
                authActivity!!.replaceAuthsFragment(SignUpFragment())
            }
            R.id.btn_reset ->{
                etUserName!!.setText("")
                etPassword!!.setText("")
                Toast.makeText(activity, "Reset", Toast.LENGTH_SHORT).show()
            }
            R.id.btn_submit ->{
                Toast.makeText(activity, "Submit", Toast.LENGTH_SHORT).show()
            }
        }
    }

}// Required empty public constructor
