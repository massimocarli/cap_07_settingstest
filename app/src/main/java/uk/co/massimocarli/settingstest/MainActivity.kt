package uk.co.massimocarli.settingstest

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .replace(R.id.anchor, MainFragment())
        .commit()
    }
  }

  override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    MenuInflater(this).inflate(R.menu.main_menu, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem?): Boolean {
    val selectedId = item?.itemId
    when (selectedId) {
      R.id.settings -> showSettings()
      else -> {

      }
    }
    return super.onOptionsItemSelected(item)
  }

  private fun showSettings() {
    supportFragmentManager.beginTransaction()
      .replace(R.id.anchor, SettingsFragment())
      .addToBackStack("Settings")
      .commit()
  }
}
