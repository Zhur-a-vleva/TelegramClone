package com.example.telegramclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.telegramclone.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawer: Drawer
    private lateinit var header: AccountHeader
    private lateinit var toolBar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater) // create view binding, which creates binding classes for every layout in module
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFields() {
        toolBar = binding.mainToolbar
    }

    private fun initFunc() {
        setSupportActionBar(toolBar)
        createHeader()
        createDrawer()
    }

    private fun createHeader() {
        header = AccountHeaderBuilder()
            .withActivity(this)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem()
                    .withName("Darya Zhuravleva")
                    .withEmail("89600818082") // it is replaced with a number, because Telegram do not use email
            ).build()
    }

    private fun createDrawer() { // the analogue for menu
        drawer = DrawerBuilder()
            .withActivity(this)
            .withToolbar(toolBar)
            .withActionBarDrawerToggle(true)
            .withSelectedItem(-1)
            .withAccountHeader(header)
            .addDrawerItems( // enumerate menu's items
                PrimaryDrawerItem()
                    .withIdentifier(100)
                    .withIconTintingEnabled(true)
                    .withName(R.string.menu_create_group)
                    .withSelectable(false)
            ).build()
    }

}