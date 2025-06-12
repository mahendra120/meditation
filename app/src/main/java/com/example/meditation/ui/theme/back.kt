package com.example.meditation.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val SkipStartCircle: ImageVector
    get() {
        if (_SkipStartCircle != null) return _SkipStartCircle!!

        _SkipStartCircle = ImageVector.Builder(
            name = "SkipStartCircle",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(8f, 15f)
                arcTo(7f, 7f, 0f, true, true, 8f, 1f)
                arcToRelative(7f, 7f, 0f, false, true, 0f, 14f)
                moveToRelative(0f, 1f)
                arcTo(8f, 8f, 0f, true, false, 8f, 0f)
                arcToRelative(8f, 8f, 0f, false, false, 0f, 16f)
            }
            path(
                fill = SolidColor(Color.Black)
            ) {
                moveTo(10.229f, 5.055f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, -0.52f, 0.038f)
                lineTo(7f, 7.028f)
                verticalLineTo(5.5f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, -1f, 0f)
                verticalLineToRelative(5f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, 1f, 0f)
                verticalLineTo(8.972f)
                lineToRelative(2.71f, 1.935f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, 0.79f, -0.407f)
                verticalLineToRelative(-5f)
                arcToRelative(0.5f, 0.5f, 0f, false, false, -0.271f, -0.445f)
            }
        }.build()

        return _SkipStartCircle!!
    }

private var _SkipStartCircle: ImageVector? = null

