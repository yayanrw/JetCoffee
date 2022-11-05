package com.heyproject.jetcoffee.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
Written by Yayan Rahmat Wijaya on 11/5/2022 14:48
Github : https://github.com/yayanrw
 **/

@Composable
fun HomeSection(
    title: String, modifier: Modifier = Modifier, content: @Composable () -> Unit
) {
    Column(modifier) {
        SectionText(title, modifier)
        content()
    }
}