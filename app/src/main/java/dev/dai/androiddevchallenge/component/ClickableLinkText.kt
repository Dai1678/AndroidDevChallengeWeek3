package dev.dai.androiddevchallenge.component

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun ClickableLinkText(
    text: String,
    links: List<String>,
    textStyle: TextStyle,
    textAlign: TextAlign,
    modifier: Modifier = Modifier,
) {
    val styledText = buildAnnotatedString {
        append(text)
        links.forEach { linkText ->
            val startIndex = text.indexOf(linkText)
            val endIndex = startIndex + linkText.length
            addStyle(
                style = SpanStyle(textDecoration = TextDecoration.Underline),
                start = startIndex,
                end = endIndex
            )
        }
    }
    ClickableText(
        text = styledText,
        style = textStyle.copy(
            textAlign = textAlign,
            color = MaterialTheme.colors.onBackground
        ),
        modifier = modifier,
        onClick = { }
    )
}