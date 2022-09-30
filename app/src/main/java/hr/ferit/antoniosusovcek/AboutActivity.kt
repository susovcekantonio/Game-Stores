package hr.ferit.antoniosusovcek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val scrollAbout = findViewById<ViewPager2>(R.id.scrollAbout)
        val fragments: ArrayList<Fragment> = arrayListOf(
            SteamFragment(),
            EpicFragment(),
            OriginFragment()
        )

        val adapter = PagerAdapter(fragments, this)
        scrollAbout.adapter = adapter
    }
}