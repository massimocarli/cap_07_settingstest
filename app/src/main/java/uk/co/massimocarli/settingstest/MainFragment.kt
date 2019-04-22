package uk.co.massimocarli.settingstest

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.fragment_main.*


/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

  lateinit var sharedPrefs: SharedPreferences

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_main, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    sharedPrefs = PreferenceManager.getDefaultSharedPreferences(activity)
  }

  override fun onStart() {
    super.onStart()
    val topics = sharedPrefs.getStringSet("key_selected_topics", emptySet())
    val nickname = sharedPrefs.getString("prefs_comment_nickname", "Anonymous")
    outputText.text = "$nickname has topics: ${topics.joinToString()}"
  }
}
