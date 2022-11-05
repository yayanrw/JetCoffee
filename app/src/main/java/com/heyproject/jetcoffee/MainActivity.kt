package com.heyproject.jetcoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.heyproject.jetcoffee.model.*
import com.heyproject.jetcoffee.ui.components.CategoryItem
import com.heyproject.jetcoffee.ui.components.HomeSection
import com.heyproject.jetcoffee.ui.components.MenuItem
import com.heyproject.jetcoffee.ui.components.SearchBar
import com.heyproject.jetcoffee.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeTheme {
                JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp() {
    Scaffold(bottomBar = {
        BottomBar()
    }) {
        Column {
            Banner()
            HomeSection(title = stringResource(R.string.section_category),
                content = { CategoryRow() })
            HomeSection(title = stringResource(R.string.section_best_seller_menu),
                content = { MenuRow(dummyMenu) })
            HomeSection(title = stringResource(R.string.section_best_seller_menu),
                content = { MenuRow(dummyBestSellerMenu) })
        }
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dummyCategory, key = { it.textCategory }) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun MenuRow(
    menus: List<Menu>, modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(menus, key = { it.title }) { menu ->
            MenuItem(menu)
        }
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
    ) {
        val navigationItems = listOf(
            BottomBarItem(
                title = stringResource(R.string.menu_home), icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_favorite), icon = Icons.Default.Favorite
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_profile), icon = Icons.Default.AccountCircle
            ),
        )
        navigationItems.map {
            BottomNavigationItem(icon = {
                Icon(
                    imageVector = it.icon, contentDescription = it.title
                )
            },
                label = {
                    Text(it.title)
                },
                selected = it.title == navigationItems[0].title,
                unselectedContentColor = LightGray,
                onClick = {})
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryRowPreview() {
    JetCoffeeTheme {
        CategoryRow()
    }
}

@Composable
@Preview(showBackground = true)
fun MenuRowPreview() {
    JetCoffeeTheme {
        MenuRow(menus = dummyMenu)
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun JetCoffeeAppPreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
    }
}