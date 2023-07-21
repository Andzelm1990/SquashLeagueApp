package com.example.logowanie

import android.app.Activity
import android.content.Intent
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView

class LeftMenu (private val activity: Activity) {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var battonMenu : ImageButton
    private lateinit var navigationViewmoje : NavigationView

    fun nawigationLeft (){
        // Pobierz drawer layout z layoutu
        drawerLayout = activity.findViewById(R.id.drawer_layout)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        navigationViewmoje = activity.findViewById(R.id.nav_view)
        navigationViewmoje.itemIconTintList = null
        navigationViewmoje.setNavigationItemSelectedListener { menuItem ->
            operationOfTheMenuButtons(menuItem, activity)
        }
        // Pobierz przycisk menu z layoutu
        battonMenu = activity.findViewById(R.id.bt_home_menu)
        battonMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun operationOfTheMenuButtons(menuItem: MenuItem, activity: Activity): Boolean {
        when (menuItem.itemId) {
            R.id.menu_home -> {
                if (activity !is HomeActivity){
                    val intent = Intent(activity, HomeActivity::class.java)
                    activity.startActivity(intent)
                    return true
                }else{
                    Toast.makeText(activity, "Już jesteś w Home", Toast.LENGTH_SHORT).show()
                    return false
                }
            }
            R.id.menu_account -> {
                Toast.makeText(activity, "Przepraszamy, ta funkcjonalność nie jest jeszcze dostępna", Toast.LENGTH_SHORT).show()
                // TODO: obsługa przycisku
                return true
            }
            R.id.menu_ranking -> {
                if (activity !is Ranking){
                    val intent = Intent(activity, Ranking::class.java)
                    activity.startActivity(intent)
                    return true
                }else{
                        if(activity.findViewById<ViewPager2>(R.id.vp2_tab_ranking).currentItem != 0){
                            activity.findViewById<ViewPager2>(R.id.vp2_tab_ranking).currentItem = 0
                            return true
                        }else{
                            Toast.makeText(activity, "Już jesteś w Ranking", Toast.LENGTH_SHORT).show()
                            return false
                        }
                }
            }
            R.id.menu_lique -> {
                if (activity !is Ranking){
                    val intent = Intent(activity, Ranking::class.java)
                    activity.startActivity(intent)
                    return true
                }else{
                    if(activity.findViewById<ViewPager2>(R.id.vp2_tab_ranking).currentItem != 1){
                        activity.findViewById<ViewPager2>(R.id.vp2_tab_ranking).currentItem = 1
                        return true
                    }else{
                        Toast.makeText(activity, "Już jesteś w Ranking", Toast.LENGTH_SHORT).show()
                        return false
                    }
                }
            }
            R.id.menu_community -> {
                if (activity !is CommunityActivity){
                    val intent = Intent(activity, CommunityActivity::class.java)
                    activity.startActivity(intent)
                    return true
                }else{
                    if(activity.findViewById<ViewPager2>(R.id.vp2_tab_players).currentItem != 0){
                        activity.findViewById<ViewPager2>(R.id.vp2_tab_players).currentItem = 0
                        return true
                    }else{
                        Toast.makeText(activity, "Już jesteś w Wyszukaj gracza", Toast.LENGTH_SHORT).show()
                        return false
                    }
                }
            }
            R.id.menu_help_us -> {
                Toast.makeText(activity, "Przepraszamy, ta funkcjonalność nie jest jeszcze dostępna", Toast.LENGTH_SHORT).show()
                // TODO: obsługa przycisku
                return true
            }
            R.id.menu_faqs -> {
                Toast.makeText(activity, "Przepraszamy, ta funkcjonalność nie jest jeszcze dostępna", Toast.LENGTH_SHORT).show()
                // TODO: obsługa przycisku
                return true
            }
            R.id.menu_premium -> {
                Toast.makeText(activity, "Przepraszamy, ta funkcjonalność nie jest jeszcze dostępna", Toast.LENGTH_SHORT).show()
                // TODO: obsługa przycisku
                return true
            }
            R.id.menu_contacts -> {
                Toast.makeText(activity, "Przepraszamy, ta funkcjonalność nie jest jeszcze dostępna", Toast.LENGTH_SHORT).show()
                // TODO: obsługa przycisku
                return true
            }
            R.id.menu_information -> {
                Toast.makeText(activity, "Przepraszamy, ta funkcjonalność nie jest jeszcze dostępna", Toast.LENGTH_SHORT).show()
                // TODO: obsługa przycisku
                return true
            }
            R.id.menu_log_out -> {
                Toast.makeText(activity, "Przepraszamy, ta funkcjonalność nie jest jeszcze dostępna", Toast.LENGTH_SHORT).show()
                // TODO: obsługa przycisku
                return true
            }
            else -> return false
        }
    }



}