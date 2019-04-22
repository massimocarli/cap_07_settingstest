package uk.co.massimocarli.settingstest

import android.os.Bundle
import androidx.preference.EditTextPreference
import androidx.preference.MultiSelectListPreference
import androidx.preference.PreferenceFragmentCompat

class SettingsFragment : PreferenceFragmentCompat() {

  lateinit var topicPreferences: MultiSelectListPreference
  lateinit var nicknamePreferences: EditTextPreference

  override fun onCreatePreferences(
    savedInstanceState: Bundle?,
    rootKey: String?
  ) {
    addPreferencesFromResource(R.xml.my_preferences)
    topicPreferences = (findPreference("key_selected_topics") as MultiSelectListPreference)
      .apply {
        setOnPreferenceChangeListener { preference, newValue ->
          updateSummary(newValue as Set<String>)
          true
        }
      }
    updateSummary(topicPreferences.values)
    nicknamePreferences = (findPreference("prefs_comment_nickname") as EditTextPreference)
      .apply {
        setOnPreferenceChangeListener { preference, newValue ->
          updateSummary(newValue as String)
          true
        }
      }
    nicknamePreferences.text?.run {
      updateSummary(nicknamePreferences.text)
    }
  }

  private fun updateSummary(values: Set<String>) {
    if (!values.isEmpty()) {
      topicPreferences.summary = values.joinToString()
    } else {
      topicPreferences.summary = getString(R.string.prefs_topic_summary)
    }
  }

  private fun updateSummary(value: String) {
    if (!value.isBlank()) {
      nicknamePreferences.summary = getString(R.string.nickname_summary_format, value)
    } else {
      nicknamePreferences.summary = getString(R.string.settings_comment_nickname_summary)
    }
  }
}